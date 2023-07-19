package com.example.my_food_recipe_app_project_design;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class RecipePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);

        Toolbar recipetoolbar = findViewById(R.id.recipetoolbar);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent();
        startActivity(i);
    }
}