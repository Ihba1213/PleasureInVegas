package com.example.pleasureinvegas.restApiInterface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface apiCalls {
    @FormUrlEncoded
    @GET("auth/user_register")
    Call<String> registrUser(@Field("mobile") String Phone);

}
