package com.example.my_food_recipe_app_project_design;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.my_food_recipe_app_project_design.adapters.favAdapter;
import com.example.my_food_recipe_app_project_design.models.favModel;

import java.util.ArrayList;
import java.util.List;


public class fav extends Fragment {
    List<favModel>list;
    favAdapter favAdapter;
    RecyclerView recyclerView;



    public fav() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fav, container, false);
        recyclerView = view.findViewById(R.id.fav_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add(new favModel(R.drawable.s1,"favourite 1","100","1.00"));
        list.add(new favModel(R.drawable.s2,"favourite 2","200","2.00"));
        list.add(new favModel(R.drawable.s3,"favourite 3","300","3.00"));
        list.add(new favModel(R.drawable.s1,"favourite 4","400","4.00"));
        list.add(new favModel(R.drawable.s2,"favourite 5","500","5.00"));
        favAdapter = new favAdapter(list);
        recyclerView.setAdapter(favAdapter);

        return view;
    }
}