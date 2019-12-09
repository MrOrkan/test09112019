package org.slas.test09112019.presentation.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity {

    private T viewDataBinding;
    private V viewModel;

    protected abstract V createViewModel();

    public abstract int getBindingVariable();

    @LayoutRes
    protected abstract Integer getLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.viewModel = createViewModel();
    }

    private void performDataBinding(){
        viewDataBinding = DataBindingUtil.setContentView(this, getLayout());
        this.viewModel = viewModel == null ? createViewModel() : viewModel;
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

}
