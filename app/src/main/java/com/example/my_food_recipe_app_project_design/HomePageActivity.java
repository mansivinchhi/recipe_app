package com.example.my_food_recipe_app_project_design;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new detailpage()).commit();

    }
}