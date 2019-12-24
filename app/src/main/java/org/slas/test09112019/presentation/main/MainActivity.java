package org.slas.test09112019.presentation.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import org.slas.test09112019.BR;
import org.slas.test09112019.R;
import org.slas.test09112019.presentation.base.BaseNavigationActivity;

public class MainActivity extends BaseNavigationActivity<MainViewModel>
        implements MainNavigator {

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
    protected MainViewModel createViewModel() {
        //todo if dagger added (this, factory)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void handleError(Throwable throwable) {
        //catch error
    }

    private void init(){

        mainViewModel.get_titleLiveData().observe(this, s -> {
            if (getSupportActionBar() != null){
                getSupportActionBar().setTitle(s);
            }
        });

    }
}
