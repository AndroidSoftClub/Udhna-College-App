package com.example.userapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userapp.databinding.RvMemberLayoutBinding;

import java.util.ArrayList;

public class RVMemberAdapter extends RecyclerView.Adapter<RVMemberAdapter.VH> {
    Activity activity;
    ArrayList<String> stringArrayList = new ArrayList<>();

    public RVMemberAdapter(Activity activity, ArrayList<String> stringArrayList) {
        this.activity = activity;
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RvMemberLayoutBinding.inflate(LayoutInflater.from(activity)));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        String s = stringArrayList.get(position);

        holder.binding.namestyID.setText((position+1) + " - "  + s);
    }

    @Override
    public int getItemCount() {
        return stringArrayList == null ? 0 : stringArrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        RvMemberLayoutBinding binding;
        public VH(@NonNull RvMemberLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
