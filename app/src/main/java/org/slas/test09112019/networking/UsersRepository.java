package org.slas.test09112019.networking;

import org.slas.test09112019.data.api.RandomApi;
import org.slas.test09112019.data.model.ApiResponse;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    private RandomApi randomApi;
    private static UsersRepository usersRepository;

    public UsersRepository() {
        randomApi = RetrofitService.cteateService(RandomApi.class);
    }

    public static UsersRepository getInstance(){
        if (usersRepository == null){
            usersRepository = new UsersRepository();
        }
        return usersRepository;
    }

    public MutableLiveData<ApiResponse> getUsers(){
        final MutableLiveData<ApiResponse> apiData = new MutableLiveData<>();
        randomApi.getUsersList().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()){
                    apiData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                apiData.setValue(null);
            }
        });
        return apiData;
    }


}
