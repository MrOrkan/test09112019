package org.slas.test09112019.presentation.base;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public abstract class BaseNavigationActivity<T extends ViewModel> extends BaseActivity<T> {

    protected NavController navController;

    @IdRes
    protected abstract Integer getNavFragmentId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(this, getNavFragmentId());
    }
}
