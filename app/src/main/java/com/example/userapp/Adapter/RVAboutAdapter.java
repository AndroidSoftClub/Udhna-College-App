package com.example.userapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userapp.R;
import com.example.userapp.databinding.RvAboutusLayoutBinding;

public class RVAboutAdapter extends RecyclerView.Adapter<RVAboutAdapter.VH> {
Activity activity;
    int images[] = {
            R.drawable.p_one,
            R.drawable.p_two,

            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_three,
            R.drawable.p_three,
            R.drawable.p_four,

            R.drawable.image_four,
            R.drawable.image_six,
            R.drawable.image_seven,
            R.drawable.image_eight,
            R.drawable.image_five,



    };


    int color[];

    String[] stringArrayList = {"Playground","Placement","Gyamkhana","NSS","Recreation","Refreshment","Multimedia"};

    public RVAboutAdapter(Activity activity) {
        this.activity = activity;
        color = new int[]{

                activity.getResources().getColor(R.color.design_dark_default_color_primary),
                activity.getResources().getColor(R.color.purple_500),
                activity.getResources().getColor(R.color.purple_700),
                activity.getResources().getColor(R.color.teal_700),
                activity.getResources().getColor(R.color.black),

        };
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RvAboutusLayoutBinding.inflate(LayoutInflater.from(activity)));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder.adapter = new RVCustomAdapter(activity,images);
        holder.binding.rvID.setAdapter(holder.adapter);
        holder.binding.tvnameID.setText(stringArrayList[position]);


    }

    @Override
    public int getItemCount() {
        return stringArrayList.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        RvAboutusLayoutBinding binding;
        RVCustomAdapter adapter;
        public VH(@NonNull RvAboutusLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
            binding.rvID.setHasFixedSize(true);
            binding.rvID.setLayoutManager(new GridLayoutManager(activity,2,RecyclerView.HORIZONTAL,false));
            binding.rvID.setItemAnimator(new DefaultItemAnimator());


        }
    }
}
