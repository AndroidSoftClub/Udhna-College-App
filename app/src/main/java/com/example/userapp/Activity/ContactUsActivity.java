package com.example.userapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.userapp.R;
import com.example.userapp.databinding.ActivityContactUsBinding;

public class ContactUsActivity extends AppCompatActivity {
ActivityContactUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactUsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.backID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

      binding.contactID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //todo:call aclick..

            }
        });



    }
}