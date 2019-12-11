package org.slas.test09112019.presentation.main.list;

import android.util.Log;

import org.slas.test09112019.data.model.ApiResponse;
import org.slas.test09112019.networking.UsersRepository;
import org.slas.test09112019.presentation.base.BaseViewModel;

import androidx.lifecycle.MutableLiveData;

public class StartListViewModel extends BaseViewModel<StartListNavigator> {

    private MutableLiveData<ApiResponse> mutableLiveData;
    private UsersRepository usersRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        usersRepository = UsersRepository.getInstance();
        mutableLiveData = usersRepository.getUsers();
    }

    public void onButtonClick(){
        getNavigator().showProfileFragment();
        Log.i("TEST", "we are inside click");
    }

    public MutableLiveData<ApiResponse> getMutableLiveData() {
        return mutableLiveData;
    }
}
