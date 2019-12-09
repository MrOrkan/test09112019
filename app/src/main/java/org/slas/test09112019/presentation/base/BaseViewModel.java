package org.slas.test09112019.presentation.base;

import java.lang.ref.WeakReference;

import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel<T> extends ViewModel {

    private WeakReference<T> navigator;

    public T getNavigator() {
        return navigator.get();
    }

    public void setNavigator(T navigator) {
        this.navigator = new WeakReference<>(navigator);
    }


}
