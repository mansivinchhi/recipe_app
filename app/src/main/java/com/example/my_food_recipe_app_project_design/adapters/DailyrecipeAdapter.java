package com.example.my_food_recipe_app_project_design.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_food_recipe_app_project_design.R;
import com.example.my_food_recipe_app_project_design.models.DailyRecipeModel;

import java.util.ArrayList;

public class DailyrecipeAdapter extends RecyclerView.Adapter<DailyrecipeAdapter.ExampleViewHolder> {

    Context mContext;
    AcceptRejectAdapterListener mListener;
    ArrayList<DailyRecipeModel> category_list;
    public interface AcceptRejectAdapterListener
    {
        void onClickViewMore(int position);
        void addToCart(int position);
    }

    public DailyrecipeAdapter(Context mContext, ArrayList<DailyRecipeModel> category_list,AcceptRejectAdapterListener mListener)
    {
        this.mContext = mContext;
        this.category_list = category_list;
        this.mListener=mListener;
    }

    @NonNull
    @Override
    public DailyrecipeAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recipe_items,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyrecipeAdapter.ExampleViewHolder holder, int position) {
        final DailyRecipeModel itemrecyclerData = category_list.get(position);

        holder.CategoryName.setText(itemrecyclerData.getCategoryName());
         Glide.with(mContext)
                    .load(itemrecyclerData.getCategoryImage())
                    //.centerCrop()
                    .into(holder.categoryImage);

    }

    @Override
    public int getItemCount() {
        return category_list.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView CategoryName;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.CategoryImage);
            CategoryName = itemView.findViewById(R.id.CategoryName);
        }
    }
}