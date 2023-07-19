package com.example.my_food_recipe_app_project_design;

import static com.example.my_food_recipe_app_project_design.Constant.recipeImage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdaptor extends RecyclerView.Adapter<RecipeAdaptor.RecipeViewHolder> {

    RecipeModel r;
    Context context;
    //    RecipeModel objects;
    ArrayList<RecipeModel> objects;

    // hear we create Constructor(context context , our data is ArrayList)
    public RecipeAdaptor(Context context, ArrayList<RecipeModel> objects) {
        this.context = context;
        this.objects = objects;
    }
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // now returen a view holder and for this we use a Layoutinflater inflater from(parent.getContext)

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //View v = inflater.inflate(
        // R.layout.recipe_view) which is use for recipe List,
        // parent,
        // false
        View v = inflater.inflate(R.layout.recipe_view, parent, false);
        // return new RecipeViewholder (V) <- pass the View
        return new RecipeViewHolder(v);

    }
    // second method for bimding the views
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

        RecipeModel r = objects.get(position);

        holder.txt_r_name.setText(r.getRname());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.txt_r_desc.setText(Html.fromHtml(r.getRinstruction(), HtmlCompat.FROM_HTML_MODE_COMPACT));
        } else {
            holder.txt_r_desc.setVisibility(View.GONE);
        }
        ImageView view = holder.recipe_image;
//        holder.recipe_image.setImageResource(r.getRimage());
        Glide.with(context).load(recipeImage + r.getRimage()).into(view);
        //view holder for onclick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putString("R_Id", r.getRid());
//                bundle.putString("R_Name", r.getRname());
//                bundle.putString("R_Image", r.getRimage());
//                bundle.putString("R_Ingredients", r.getRingredients());
//                bundle.putString("R_Instruction", r.getRinstruction());
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                Fragment myFragment = new RecipeDetailsFragment();
//                myFragment.setArguments(bundle);
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();
                Intent intent = new Intent(context,recipe_detail.class);
                intent.putExtra("R_Id", r.getRid());
                intent.putExtra("R_Name", r.getRname());
                intent.putExtra("R_Image", r.getRimage());
                intent.putExtra("R_Ingredients", r.getRingredients());
                intent.putExtra("R_Instruction", r.getRinstruction());

                context.startActivity(intent);
           }
        });

    }

    //third method getItem Count which is use for up to our Items size
    @Override
    public int getItemCount()
    {
        return objects.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        // refrence for required field
        TextView txt_r_name, txt_r_desc;
        ImageView recipe_image;

        //find views and assign the ids
        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_r_name = itemView.findViewById(R.id.txt_r_name);
            txt_r_desc = itemView.findViewById(R.id.txt_r_desc);
            recipe_image = itemView.findViewById(R.id.recipe_image);
        }
    }
}