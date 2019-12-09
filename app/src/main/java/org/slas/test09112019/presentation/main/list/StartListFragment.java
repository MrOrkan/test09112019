package org.slas.test09112019.presentation.main.list;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.slas.test09112019.BR;
import org.slas.test09112019.R;
import org.slas.test09112019.databinding.FragmentMainProfileBinding;
import org.slas.test09112019.databinding.FragmentMainStartListBinding;
import org.slas.test09112019.presentation.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class StartListFragment extends BaseFragment<FragmentMainStartListBinding, StartListViewModel>
        implements StartListNavigator{

    private FragmentMainStartListBinding fragmentMainStartListBinding;
    private StartListViewModel startListViewModel;

    private Button button;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

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
        init();
        setupLiveData();
        setupAdapter();

    }

    private void init(){
        fragmentMainStartListBinding = getViewDataBinding();
        startListViewModel.setNavigator(this);

    }

    private void setupLiveData(){

    }

    private void setupAdapter(){

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
