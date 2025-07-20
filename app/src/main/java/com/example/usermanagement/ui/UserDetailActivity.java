package com.example.usermanagement.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.usermanagement.R;
import com.example.usermanagement.data.api.ApiClient;
import com.example.usermanagement.data.api.ReqresApi;
import com.example.usermanagement.data.model.User;
import com.example.usermanagement.data.model.UserDetailRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity {
    private ImageView avatar;
    private TextView name, email;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        avatar = findViewById(R.id.avatar);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        userId = getIntent().getIntExtra("user_id", -1);
        if (userId != -1) {
            fetchUserDetail(userId);
        } else {
            Toast.makeText(this, "No user ID supplied", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void fetchUserDetail(int id) {
        ReqresApi api = ApiClient.getClient().create(ReqresApi.class);
        api.getUserDetail(id).enqueue(new Callback<UserDetailRes>() {
            @Override
            public void onResponse(Call<UserDetailRes> call, Response<UserDetailRes> response) {
                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body().getData();
                    name.setText(user.getFirst_name() + " " + user.getLast_name());
                    email.setText(user.getEmail());
                    Glide.with(UserDetailActivity.this).load(user.getAvatar()).into(avatar);
                } else {
                    Toast.makeText(UserDetailActivity.this, "Failed to load user detail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDetailRes> call, Throwable t) {
                Toast.makeText(UserDetailActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
