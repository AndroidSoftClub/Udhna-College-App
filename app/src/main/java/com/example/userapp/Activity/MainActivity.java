package com.example.userapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.userapp.Adapter.MyPagerAdapter;
import com.example.userapp.Utils.Cons;
import com.example.userapp.databinding.ActivityMainBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding biding;
    MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(biding.getRoot());

        biding.slider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        biding.slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        biding.slider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        biding.slider.setIndicatorSelectedColor(Color.WHITE);
        biding.slider.setIndicatorUnselectedColor(Color.GRAY);
        biding.slider.setScrollTimeInSec(4); //set scroll delay in seconds :
        biding.slider.startAutoCycle();

        biding.slider.setAutoCycle(true);
        adapter = new MyPagerAdapter(this);
        biding.slider.setSliderAdapter(adapter);


        biding.homeID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });


        biding.aboutUsID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
            }
        });


        biding.webID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cons.isOnline(MainActivity.this)){
                    Cons.openWebPage(MainActivity.this,"https://www.udhnacollege.org/Home.php");
                }
            }
        });

        biding.sapID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SapaDharaActivity.class));
            }
        });


        biding.contactusID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
            }
        });







    }
}