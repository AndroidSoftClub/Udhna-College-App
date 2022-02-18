package com.example.userapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.userapp.Adapter.RVAboutAdapter;
import com.example.userapp.Adapter.RVCustomAdapter;
import com.example.userapp.Adapter.RVMemberAdapter;
import com.example.userapp.Model.ModelData;
import com.example.userapp.R;
import com.example.userapp.databinding.ActivitySapaShowBinding;

public class SapaShowActivity extends AppCompatActivity {
    ModelData modelData;
    ActivitySapaShowBinding binding;
    RVMemberAdapter adapter;
    RVCustomAdapter aboutAdapter;

    int images[] = {
            R.drawable.p_one,
            R.drawable.p_two,
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_three,
            R.drawable.p_three,
            R.drawable.p_four,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySapaShowBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        modelData = getIntent().getParcelableExtra("model");

        binding.nameiD.setText(modelData.getFunctionName());
        binding.tvID.setText(modelData.getSummery());
        binding.summeryID.setText("Summery (" + modelData.getFunctionName() + ")");


        //todo: Member..

        binding.rvmemberID.setHasFixedSize(true);
        binding.rvmemberID.setLayoutManager(new LinearLayoutManager(this));
        binding.rvmemberID.setItemAnimator(new DefaultItemAnimator());
        binding.rvmemberID.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new RVMemberAdapter(this, modelData.getStudentList());
        binding.rvmemberID.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //todo: Winder Member..

        binding.winderID.setHasFixedSize(true);
        binding.winderID.setLayoutManager(new LinearLayoutManager(this));
        binding.winderID.setItemAnimator(new DefaultItemAnimator());
        binding.winderID.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new RVMemberAdapter(this, modelData.getStudentList());
        binding.winderID.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //todo: Photos Adapter..

        binding.rvgalleryID.setHasFixedSize(true);
        binding.rvgalleryID.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.rvgalleryID.setItemAnimator(new DefaultItemAnimator());

        aboutAdapter = new RVCustomAdapter(this, images);
        binding.rvgalleryID.setAdapter(aboutAdapter);
        aboutAdapter.notifyDataSetChanged();

        binding.baeveckID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}