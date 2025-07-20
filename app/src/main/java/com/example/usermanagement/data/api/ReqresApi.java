package com.example.usermanagement.data.api;

import com.example.usermanagement.data.model.ListUserRes;
import com.example.usermanagement.data.model.LoginReq;
import com.example.usermanagement.data.model.LoginRes;
import com.example.usermanagement.data.model.UserDetailRes;
import com.example.usermanagement.data.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReqresApi {
    @Headers("x-api-key: reqres-free-v1")
    @GET("api/users")
    Call<ListUserRes> getUsers(@Query("page") int page);

    @Headers("x-api-key: reqres-free-v1")
    @POST("api/login")
    Call<LoginRes> login(@Body LoginReq body);

    @Headers("x-api-key: reqres-free-v1")
    @GET("api/users/{id}")
    Call<UserDetailRes> getUserDetail(@Path("id") int id);
}
