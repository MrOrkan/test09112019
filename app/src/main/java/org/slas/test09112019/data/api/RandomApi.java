package org.slas.test09112019.data.api;

import org.slas.test09112019.data.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomApi {

    @GET(".")
    Call<ApiResponse> getUsersList(@Query("page") int page, @Query("results") int count);
}
