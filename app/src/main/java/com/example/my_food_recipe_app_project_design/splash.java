package com.example.my_food_recipe_app_project_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView.animate().translationY(-100).setDuration(2000).setStartDelay(1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // for not again display whenever we go to the back
                finish();
                Intent iHome = new Intent(getApplicationContext(),Welcome_Screen.class);

                startActivity(iHome);
            }
        },8400);
    }
}