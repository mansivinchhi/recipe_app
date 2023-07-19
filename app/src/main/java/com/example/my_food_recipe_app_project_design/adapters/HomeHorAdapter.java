package com.example.my_food_recipe_app_project_design.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_food_recipe_app_project_design.R;
import com.example.my_food_recipe_app_project_design.models.HomeHorModel;
import com.example.my_food_recipe_app_project_design.models.Homevermodel;

import java.util.ArrayList;
import java.util.List;

// stape => 4 HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> and create ViewHolder class
// and implements a all methods and
public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    // stape => 8
    updateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    FragmentActivity fragmentActivity;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(com.example.my_food_recipe_app_project_design.adapters.updateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //stape => 9 (re)
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //stape => 10
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());


        if (check) {
            ArrayList<Homevermodel> homevermodels = new ArrayList<>();
            homevermodels.add(new Homevermodel(R.drawable.pizza33, "breakfast"));
            homevermodels.add(new Homevermodel(R.drawable.pizza2, "lunch"));
            homevermodels.add(new Homevermodel(R.drawable.e, "dinner"));
            homevermodels.add(new Homevermodel(R.drawable.pizza4, "sweets"));
            homevermodels.add(new Homevermodel(R.drawable.pizza12, "moctails"));

            updateVerticalRec.callBack(position, homevermodels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    row_index = position;
                    notifyDataSetChanged();
                    if (position == 0)
                    {
                        ArrayList<Homevermodel> homevermodels = new ArrayList<>();
                        homevermodels.add(new Homevermodel(R.drawable.pizza33, "pizza"));
                        homevermodels.add(new Homevermodel(R.drawable.pizza2, "pizza"));
                        homevermodels.add(new Homevermodel(R.drawable.e, "pizza"));
                        homevermodels.add(new Homevermodel(R.drawable.pizza4, "pizza"));
                        homevermodels.add(new Homevermodel(R.drawable.pizza12, "pizza"));

                        updateVerticalRec.callBack(position, homevermodels);
                    }
                    else if (position == 1)
                    {
                        ArrayList<Homevermodel> homevermodels = new ArrayList<>();
                        homevermodels.add(new Homevermodel(R.drawable.d, "burger"));
                        homevermodels.add(new Homevermodel(R.drawable.burger1, "burger"));
                        homevermodels.add(new Homevermodel(R.drawable.burger2, "burger"));
                        homevermodels.add(new Homevermodel(R.drawable.burger4, "burger"));
                        homevermodels.add(new Homevermodel(R.drawable.burger, "burger"));

                        updateVerticalRec.callBack(position, homevermodels);
                    }
                    else if (position == 2) {
                        ArrayList<Homevermodel> homevermodels = new ArrayList<>();
                        homevermodels.add(new Homevermodel(R.drawable.frenchfries, "frenchfries"));
                        homevermodels.add(new Homevermodel(R.drawable.fries1, "frenchfries"));
                        homevermodels.add(new Homevermodel(R.drawable.fries2, "frenchfries"));
                        homevermodels.add(new Homevermodel(R.drawable.fries3, "frenchfries"));
                        homevermodels.add(new Homevermodel(R.drawable.fries4, "frenchfries"));

                        updateVerticalRec.callBack(position, homevermodels);
                    } else if (position == 3) {
                        ArrayList<Homevermodel> homevermodels = new ArrayList<>();
                        homevermodels.add(new Homevermodel(R.drawable.i, "icecream"));
                        homevermodels.add(new Homevermodel(R.drawable.m, "icecream"));
                        homevermodels.add(new Homevermodel(R.drawable.icecream1, "icecream"));
                        homevermodels.add(new Homevermodel(R.drawable.icecream3, "icecream"));
                        homevermodels.add(new Homevermodel(R.drawable.icecream4, "icecream"));


                        updateVerticalRec.callBack(position, homevermodels);
                    } else if (position == 4) {
                        ArrayList<Homevermodel> homevermodels = new ArrayList<>();
                        homevermodels.add(new Homevermodel(R.drawable.sandwich2, "sandwich"));
                        homevermodels.add(new Homevermodel(R.drawable.sandwich1, "sandwich"));
                        homevermodels.add(new Homevermodel(R.drawable.sandwich3, "sandwich"));
                        homevermodels.add(new Homevermodel(R.drawable.g, "sandwich"));
                        homevermodels.add(new Homevermodel(R.drawable.sandwich4, "sandwich"));

                        updateVerticalRec.callBack(position, homevermodels);
                    }
                }
            });
            if (select)
            {
                if (position == 0)
                {
                    holder.cardView.setBackgroundResource(R.drawable.changebg);
                    select = false;

                }
            }
            else
            {
                if (row_index == position)
                {
                    holder.cardView.setBackgroundResource(R.drawable.changebg);

                }
                else
                {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }
    // stape => 11 (how many items or we can say listsize)
    @Override
    public int getItemCount() {
        return list.size();
    }
    // stape => 5 create constructor matching supper
    public class ViewHolder extends RecyclerView.ViewHolder {

        //stape => 6 (now find that)
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            //stape =>7 (find view like that)

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
