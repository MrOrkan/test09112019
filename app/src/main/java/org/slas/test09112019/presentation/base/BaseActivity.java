package org.slas.test09112019.presentation.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity<T extends ViewModel> extends AppCompatActivity {

    private T viewModel;

    protected abstract T createViewModel();

    @LayoutRes
    protected abstract Integer getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.viewModel = createViewModel();
    }

}
