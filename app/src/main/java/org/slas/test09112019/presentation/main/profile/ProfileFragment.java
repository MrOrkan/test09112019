package org.slas.test09112019.presentation.main.profile;

import android.os.Bundle;
import android.view.View;

import org.slas.test09112019.R;
import org.slas.test09112019.presentation.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class ProfileFragment extends BaseFragment<ProfileViewModel> {

    private ProfileViewModel profileViewModel;

    @Override
    protected ProfileViewModel createViewModel() {
        return ViewModelProviders.of(this).get(ProfileViewModel.class);
    }

    @Override
    protected Integer getLayout() {
        return R.layout.fragment_main_profile;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setupLiveData();
        setupAdapter();
    }

    private void init(){

    }

    private void setupLiveData(){

    }

    private void setupAdapter(){

    }
}
