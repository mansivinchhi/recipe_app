package com.example.my_food_recipe_app_project_design.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_food_recipe_app_project_design.R;
import com.example.my_food_recipe_app_project_design.models.Homevermodel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.nio.file.attribute.AclEntryType;
import java.util.ArrayList;
import java.util.List;


public class Homeveradapter extends RecyclerView.Adapter<Homeveradapter.ViewHolder> {
private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<Homevermodel> list;

    public Homeveradapter(Context context, ArrayList<Homevermodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String mName = list.get(position).getName();
        final int mImage = list.get(position).getImage();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.Name.setText(list.get(position).getName());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.readmorebtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Read More", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();

                    }
                });
                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);


                bottomName.setText(mName);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();




            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            Name = itemView.findViewById(R.id.Name);
        }
    }
}
