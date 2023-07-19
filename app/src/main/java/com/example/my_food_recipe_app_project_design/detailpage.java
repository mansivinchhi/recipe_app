package com.example.my_food_recipe_app_project_design;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class detailpage extends Fragment {
    View view;
    private Context mContext;
    private GridView CategoryList;
    private final ArrayList<CategoryModel> list = new ArrayList<>();
    //ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detailpage, container, false);
        mContext = container.getContext();

        list.clear();
        getCategoryList();
        FindViewByID(view);
        Body();
        return view;
    }
    private void FindViewByID(View view) {
        CategoryList = view.findViewById(R.id.CategoryList);
        ViewCompat.setNestedScrollingEnabled(CategoryList,true);
    }
    private void Body() {
        CategoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(mContext,Screen_Recipe.class);
                intent.putExtra("c_id",""+list.get(position).getCategoryID());
                startActivity(intent);
//                Bundle bundle = new Bundle();
//                bundle.putString("c_id",""+list.get(position).getCategoryID());
//                RecipeFragment recipeFragment=new RecipeFragment();
//                recipeFragment.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.fragment_container,recipeFragment).commit();
            }
        });
    }

    private void getCategoryList() {
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        StringRequest mRequest = new StringRequest(Request.Method.POST, Constant.categories_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonarray=new JSONObject(response).getJSONArray("Data");

                    for (int i = 0; i < jsonarray.length(); i++) {


                        JSONObject jsonobject = jsonarray.getJSONObject(i);

                        int c_id = jsonobject.getInt("ID");
                        String c_name = jsonobject.getString("CategoryName");
                        String c_image = jsonobject.getString("CategoryImage");

                        CategoryModel model = new CategoryModel(c_id,c_name,c_image);
                        list.add(model);
                    }
                    CategoryAdaptor adapter = new CategoryAdaptor(mContext, list);
                    CategoryList.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error : ", error.toString());
            }
        });
        mRequestQueue.add(mRequest);
    }
}
