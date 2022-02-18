package com.example.userapp.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userapp.Activity.SapaShowActivity;
import com.example.userapp.Model.ModelData;
import com.example.userapp.databinding.RvTextLayoutBinding;

import java.util.ArrayList;

public class RVSapataAdapter extends RecyclerView.Adapter<RVSapataAdapter.VH> {
    Activity activity;
    ArrayList<ModelData> modelDataArrayList = new ArrayList<>();

    public RVSapataAdapter(Activity activity, ArrayList<ModelData> modeldata) {
        this.activity = activity;
        this.modelDataArrayList = modeldata;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RvTextLayoutBinding.inflate(LayoutInflater.from(activity)));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        ModelData modelData = modelDataArrayList.get(position);

        Log.d("FFM","FunName: " + modelData.getFunctionName());

        holder.binding.sapatharaID.setText(modelData.getFunctionName());

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, SapaShowActivity.class)
                .putExtra("model",modelData));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelDataArrayList == null ? 0 : modelDataArrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        RvTextLayoutBinding binding;
        public VH(@NonNull RvTextLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
