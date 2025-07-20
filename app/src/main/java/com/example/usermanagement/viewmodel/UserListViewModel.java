package com.example.usermanagement.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.usermanagement.data.model.ListUserRes;
import com.example.usermanagement.data.model.User;
import com.example.usermanagement.data.repository.UserRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {
    private final UserRepository repository = new UserRepository();
    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void fetchUsers(int page) {
        repository.getUsers(page).enqueue(new Callback<ListUserRes>() {
            @Override
            public void onResponse(Call<ListUserRes> call, Response<ListUserRes> response) {
                if (response.isSuccessful() && response.body() != null) {
                    users.postValue(response.body().getData());
                } else {
                    error.postValue("Failed to load users");
                }
            }

            @Override
            public void onFailure(Call<ListUserRes> call, Throwable t) {
                error.postValue("Error: " + t.getMessage());
            }
        });
    }
}
