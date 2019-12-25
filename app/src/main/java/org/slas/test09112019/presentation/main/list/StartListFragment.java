package org.slas.test09112019.presentation.main.list;

import android.os.Bundle;
import android.view.View;

import org.slas.test09112019.R;
import org.slas.test09112019.adapters.UsersAdapter;
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
    private boolean isFirstOpen = true;

    @Override
    protected Integer getLayout() {
        return R.layout.fragment_main_start_list;
    }

    @Override
    protected StartListViewModel createViewModel() {
        startListViewModel = ViewModelProviders.of(this).get(StartListViewModel.class);
        return startListViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewUsers = view.findViewById(R.id.recyclerViewUsers);
        init();
        setupLiveData();
    }

    private void init(){
        if (getActivity() != null){
            mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
            mainViewModel.updateActionBarTitle(TITLE_HOME);
        }

        if (isFirstOpen){
            startListViewModel.loadItems();
            isFirstOpen = false;
        }

        startListViewModel.setNavigator(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewUsers.setLayoutManager(linearLayoutManager);

        if (usersAdapter == null){
            usersAdapter = new UsersAdapter(getContext(), new ArrayList<>());
        }
        recyclerViewUsers.setAdapter(usersAdapter);
        usersAdapter.notifyDataSetChanged();

        usersAdapter.setOnItemClickListener(position -> {
            navController.navigate(R.id.profileFragment, getBundle(position));
        });

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
        startListViewModel.get_apiResponseLiveData().observe(getViewLifecycleOwner(), apiResponse -> {
            if (apiResponse == null) return;
            usersAdapter.removeLoading();
            List<User> users = apiResponse.getUsers();
            usersList.clear();
            usersList.addAll(users);
            usersAdapter.addItems(usersList);

            if (!users.isEmpty() && users.size() >= UsersRepository.COUNT){
                usersAdapter.addLoading();
            } else {
                isLastPage = true;
            }
            isLoading = false;
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

    private Bundle getBundle(int position){
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", usersAdapter.getItem(position));
        return bundle;
    }
}
