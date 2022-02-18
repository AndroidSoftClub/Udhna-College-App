package com.example.userapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.userapp.R;
import com.example.userapp.databinding.ItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class MyPagerAdapter extends SliderViewAdapter<MyPagerAdapter.SliderAdapterVH> {
    Activity activity;
    int images[] = {

            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_three,
            R.drawable.p_one,
            R.drawable.p_two,
            R.drawable.p_three,
            R.drawable.p_four,

            R.drawable.image_four,
            R.drawable.image_six,
            R.drawable.image_seven,
            R.drawable.image_eight,
            R.drawable.image_five

    };

    public MyPagerAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        return new SliderAdapterVH(ItemBinding.inflate(LayoutInflater.from(activity)));
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Glide.with(activity)
                .load(images[position])
                .placeholder(Color.WHITE)
                .into(viewHolder.binding.ivID)
                .clearOnDetach();
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ItemBinding binding;
        public SliderAdapterVH(ItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }
    }
}
