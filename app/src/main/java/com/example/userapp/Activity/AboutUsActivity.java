package com.example.userapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.userapp.Adapter.RVAboutAdapter;
import com.example.userapp.databinding.ActivityAboutUsBinding;

public class AboutUsActivity extends AppCompatActivity {
ActivityAboutUsBinding binding;
RVAboutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.bbID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.recyID.setHasFixedSize(true);
        binding.recyID.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.recyID.setItemAnimator(new DefaultItemAnimator());

        adapter = new RVAboutAdapter(this);
        binding.recyID.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}