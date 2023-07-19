package com.example.my_food_recipe_app_project_design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


// Category Adepter extends ArrayAdapter

public class CategoryAdaptor extends ArrayAdapter<CategoryModel> {

    Context context;
    public CategoryAdaptor(@NonNull Context context, ArrayList<CategoryModel> list) {
        super(context, 0, list);
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.category_menu, parent, false);
        }
        CategoryModel model = getItem(position);
        TextView CategoryName = view.findViewById(R.id.CategoryName);
        //for Glide use
        // first we create a refrence ImageView and findview by id

        ImageView CategoryImage = view.findViewById(R.id.CategoryImage);
        CategoryName.setText(model.getCategoryName());

        //this is all for load the Image by using Glide
        //Glide.with()  <- in this pass the context ither (.this or getContext())
        //.load() <- in this we pass the urls for image(model.getCategoryImage())
        //.into() <- pass the ImageView (CategoryImage)
        //and in last simplly add a user Internate Permission in menifestfile
        Glide.with(getContext()).load(model.getCategoryImage()).into(CategoryImage);
       return view;
    }
}