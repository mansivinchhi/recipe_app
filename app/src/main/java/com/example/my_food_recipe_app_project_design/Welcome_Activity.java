package com.example.my_food_recipe_app_project_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Welcome_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this is work like intent or onclick
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
    }

    //intent pass for welcome to registration


    public void registration(View view) {
        startActivity(new Intent(Welcome_Activity.this,Registration_Activity.class));
    }

    public void login(View view) {
        startActivity(new Intent(Welcome_Activity.this,Registration_Activity.class));
    }
}