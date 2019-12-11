package org.slas.test09112019.data.api;

import org.slas.test09112019.data.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomApi {

    @GET("?results=20")
    Call<ApiResponse> getUsersList();
}
