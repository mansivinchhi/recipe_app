package com.example.my_food_recipe_app_project_design.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_food_recipe_app_project_design.R;
import com.example.my_food_recipe_app_project_design.adapters.HomeHorAdapter;
import com.example.my_food_recipe_app_project_design.adapters.Homeveradapter;
import com.example.my_food_recipe_app_project_design.adapters.updateVerticalRec;
import com.example.my_food_recipe_app_project_design.models.HomeHorModel;
import com.example.my_food_recipe_app_project_design.models.Homevermodel;

import java.util.ArrayList;

public class Home extends Fragment implements updateVerticalRec {

    //stape => 12

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;
    Homeveradapter homeveradapter;

    //vertical
    ArrayList<Homevermodel> homevermodelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root  = inflater.inflate(R.layout.fragment_home,container,false);
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
/// for horizontal Recyclerview
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza3,"Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.rrr,"burger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.frenchfries,"frenchfris"));
        homeHorModelList.add(new HomeHorModel(R.drawable.icdp,"ice_cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich33,"sandwich"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


//        ///// for vertical Recyclerview
//        homevermodelList = new ArrayList<>();
//        homevermodelList.add(new Homevermodel(R.drawable.pizza12,"paneer cheese pizza"));
//        homevermodelList.add(new Homevermodel(R.drawable.dinner,"main course"));
//        homevermodelList.add(new Homevermodel(R.drawable.coffe,"coffe"));
//        homevermodelList.add(new Homevermodel(R.drawable.sweets,"donut"));
//        homevermodelList.add(new Homevermodel(R.drawable.sandwich1,"Sandwich"));
//        homevermodelList.add(new Homevermodel(R.drawable.waffles,"waffles"));

        homeveradapter = new Homeveradapter(getActivity(),homevermodelList);
        homeVerticalRec.setAdapter(homeveradapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
//        homeVerticalRec.setHasFixedSize(true);
//        homeVerticalRec.setNestedScrollingEnabled(false);

       return root;
    }

    @Override
    public void callBack(int Position, ArrayList<Homevermodel> list){
        homeveradapter = new Homeveradapter(getContext(),list);
        homeveradapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeveradapter);
    }
}