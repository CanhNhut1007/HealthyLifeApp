package com.example.healthlife.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import com.example.healthlife.entities.AccessToken;
import com.example.healthlife.entities.PostResponse;

public interface ApiService {

    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register( @Field("email") String email, @Field("password") String password,@Field("password_confirmation") String password_confirmation);

    @POST("login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("email") String username, @Field("password") String password);


    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);
}
