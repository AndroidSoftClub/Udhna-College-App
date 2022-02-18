package com.example.userapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.userapp.databinding.RvItemBinding;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.VH> {
    Activity activity;
    int[] images;

    public RVCustomAdapter(Activity activity, int[] images) {
        this.activity = activity;
        this.images = images;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RvItemBinding.inflate(LayoutInflater.from(activity)));
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Glide.with(activity)
                .load(images[position])
                .placeholder(Color.WHITE)
                .into(holder.binding.ivitemID)
                .clearOnDetach();

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        RvItemBinding binding;
        public VH(@NonNull RvItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
