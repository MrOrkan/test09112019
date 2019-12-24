package org.slas.test09112019.presentation.main.list;

import org.slas.test09112019.data.model.ApiResponse;
import org.slas.test09112019.networking.UsersRepository;
import org.slas.test09112019.presentation.base.BaseViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class StartListViewModel extends BaseViewModel<StartListNavigator> {

    private MutableLiveData<ApiResponse> _apiResponseLiveData;

    private UsersRepository usersRepository = UsersRepository.getInstance();

    public void loadItems(){
        _apiResponseLiveData = usersRepository.getUsers();
    }

    public LiveData<ApiResponse> get_apiResponseLiveData() {
        return _apiResponseLiveData;
    }
}
