package org.slas.test09112019.presentation.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import org.slas.test09112019.BR;
import org.slas.test09112019.R;
import org.slas.test09112019.databinding.ActivityMainBinding;
import org.slas.test09112019.presentation.base.BaseNavigationActivity;

public class MainActivity extends BaseNavigationActivity<ActivityMainBinding, MainViewModel>
        implements MainNavigator {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected Integer getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Integer getNavFragmentId() {
        return R.id.nav_main_host;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected MainViewModel createViewModel() {
        //todo if dagger added (this, factory)
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void handleError(Throwable throwable) {
        //catch error
    }
}
