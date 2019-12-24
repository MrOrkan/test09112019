package org.slas.test09112019.networking;

import org.slas.test09112019.data.api.RandomApi;
import org.slas.test09112019.data.model.ApiResponse;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    public static final int COUNT = 20;

    private RandomApi randomApi;
    private static UsersRepository usersRepository;

    private MutableLiveData<ApiResponse> apiData = new MutableLiveData<>();

    private int page = 1;

    public UsersRepository() {
        randomApi = RetrofitService.createService(RandomApi.class);
    }

    public static UsersRepository getInstance(){
        if (usersRepository == null){
            usersRepository = new UsersRepository();
        }
        return usersRepository;
    }

    public MutableLiveData<ApiResponse> getUsers(){

        randomApi.getUsersList(page ,COUNT).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                if (response.isSuccessful()){
                    page++;
                    apiData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                apiData.setValue(null);
                t.printStackTrace();
            }
        });

        return apiData;
    }

}
