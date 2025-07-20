package com.example.usermanagement.data.repository;

import com.example.usermanagement.data.api.ApiClient;
import com.example.usermanagement.data.api.ReqresApi;
import com.example.usermanagement.data.model.ListUserRes;
import com.example.usermanagement.data.model.UsersResponse;

import retrofit2.Call;

public class UserRepository {
    private ReqresApi api;

    public UserRepository() {
        api = ApiClient.getClient().create(ReqresApi.class);
    }

    public Call<ListUserRes> getUsers(int page) {
        return api.getUsers(page);
    }
}
