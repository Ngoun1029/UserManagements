package com.example.usermanagement.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usermanagement.R;
import com.example.usermanagement.ui.adapter.UserAdapter;
import com.example.usermanagement.viewmodel.UserListViewModel;

import java.util.ArrayList;


public class UserListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        viewModel.getUsers().observe(this, users -> {
            adapter = new UserAdapter(users, UserListActivity.this);
            recyclerView.setAdapter(adapter);
        });

        viewModel.getError().observe(this, errorMsg -> {
            Toast.makeText(UserListActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        });

        viewModel.fetchUsers(1);
    }
}
