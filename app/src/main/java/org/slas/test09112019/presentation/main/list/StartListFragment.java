package org.slas.test09112019.presentation.main.list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.slas.test09112019.R;
import org.slas.test09112019.adapters.UsersAdapter;
import org.slas.test09112019.data.model.ApiResponse;
import org.slas.test09112019.data.model.User;
import org.slas.test09112019.networking.UsersRepository;
import org.slas.test09112019.pagination.PaginationListener;
import org.slas.test09112019.presentation.base.BaseFragment;
import org.slas.test09112019.presentation.base.adapter.RecyclerItem;
import org.slas.test09112019.presentation.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StartListFragment extends BaseFragment<StartListViewModel>
        implements StartListNavigator{

    private final static String TITLE_HOME = "Home";

    private StartListViewModel startListViewModel;
    private MainViewModel mainViewModel;

    private ArrayList<RecyclerItem> usersList = new ArrayList<>();
    private UsersAdapter usersAdapter;
    private RecyclerView recyclerViewUsers;

    private boolean isLoading = false;
    private boolean isLastPage = false;

    @Override
    protected Integer getLayout() {
        return R.layout.fragment_main_start_list;
    }

    @Override
    protected StartListViewModel createViewModel() {
        //todo if dagger added (this, factory)
        startListViewModel = ViewModelProviders.of(this).get(StartListViewModel.class);
        return startListViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewUsers = view.findViewById(R.id.recyclerViewUsers);
        setupLiveData();
        init();
    }

    private void init(){
        if (getActivity() != null){
            mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
            mainViewModel.updateActionBarTitle(TITLE_HOME);
        }

        startListViewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        if (usersAdapter == null){
            usersAdapter = new UsersAdapter(getContext(), new ArrayList<>());
            recyclerViewUsers.setLayoutManager(linearLayoutManager);
            recyclerViewUsers.setAdapter(usersAdapter);
        }
        else {
            usersAdapter.notifyDataSetChanged();
        }

        recyclerViewUsers.addOnScrollListener(new PaginationListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                startListViewModel.loadItems();
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
        });
    }

    private void setupLiveData(){
        startListViewModel.loadItems();

        startListViewModel.get_apiResponseLiveData().observe(this, apiResponse -> {
            if (apiResponse == null) return;

            usersAdapter.removeLoading();
            List<User> users = apiResponse.getUsers();
            usersList.addAll(users);
            usersAdapter.addItems(usersList);

            if (!users.isEmpty() && users.size() >= UsersRepository.COUNT){
                usersAdapter.addLoading();
            } else {
                isLastPage = true;
            }
            isLoading = false;
            usersAdapter.notifyDataSetChanged();
        });
    }



    @Override
    public void showProfileFragment() {
        navController.navigate(R.id.action_startListFragment_to_profileFragment);
    }

    @Override
    public void handleError(Throwable throwable) {
        // catch error
    }
}
