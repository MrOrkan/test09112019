package org.slas.test09112019.presentation.main;

import org.slas.test09112019.presentation.base.BaseViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<String> _titleLiveData = new MutableLiveData<>();

    public void updateActionBarTitle(String title){
        _titleLiveData.postValue(title);
    }

    public LiveData<String> get_titleLiveData() {
        return _titleLiveData;
    }
}
