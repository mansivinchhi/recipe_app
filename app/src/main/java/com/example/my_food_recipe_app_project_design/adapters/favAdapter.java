package com.example.my_food_recipe_app_project_design.adapters;

import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_food_recipe_app_project_design.R;
import com.example.my_food_recipe_app_project_design.models.favModel;

import java.util.List;

public class favAdapter extends RecyclerView.Adapter<favAdapter.ViewHolder> {
    List<favModel>list;

    public favAdapter(List<favModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public favAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.myfav_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull favAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,rating,price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            price = itemView.findViewById(R.id.TextView12);
        }
    }
}
