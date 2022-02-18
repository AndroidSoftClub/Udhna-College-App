package com.example.userapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.userapp.Adapter.RVSapataAdapter;
import com.example.userapp.Model.ModelData;
import com.example.userapp.R;
import com.example.userapp.Utils.Cons;
import com.example.userapp.databinding.ActivitySapaDharaBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SapaDharaActivity extends AppCompatActivity {
ActivitySapaDharaBinding binding;
RVSapataAdapter adapter;
ArrayList<ModelData> modeldata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySapaDharaBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        modeldata.clear();

        binding.backsaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.rvsID.setHasFixedSize(true);
        binding.rvsID.setItemAnimator(new DefaultItemAnimator());
        binding.rvsID.setLayoutManager(new LinearLayoutManager(this));
        binding.rvsID.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        adapter = new RVSapataAdapter(this,modeldata);
        binding.rvsID.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Function");

        if (Cons.isOnline(this))
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                modeldata.clear();
                for (DataSnapshot s : dataSnapshot.getChildren()) {
                    ModelData value = s.getValue(ModelData.class);
                    Log.d("FFM", "Data: " + value.getSummery());
                    modeldata.add(value);

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("FFM","Fail: " + error.getMessage());
            }
        });


    }
}