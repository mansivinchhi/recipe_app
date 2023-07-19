
package com.example.my_food_recipe_app_project_design;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_food_recipe_app_project_design.adapters.DailyrecipeAdapter;
import com.example.my_food_recipe_app_project_design.models.DailyRecipeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Category_List extends Fragment implements DailyrecipeAdapter.AcceptRejectAdapterListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";

    RecyclerView list_cat;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Category_List.
     */
    // TODO: Rename and change types and number of parameters
    public static Category_List newInstance(String param1, String param2) {
        Category_List fragment = new Category_List();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);



        fragment.setArguments(args);
        return fragment;
    }
    public Category_List() {


        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getCategoryList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        list_cat = (RecyclerView) view.findViewById(R.id.list_cat);

        return  view;
    }
    private void getCategoryList() {

        RequestQueue mRequestQueue = Volley.newRequestQueue(requireContext());
        StringRequest mRequest = new StringRequest(Request.Method.POST, Constant.categories_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonarray=new JSONObject(response).getJSONArray("Data");
                    Log.d("res_category",jsonarray.toString());
                    ArrayList<DailyRecipeModel> list = new ArrayList<>();

                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);

                        int c_id = jsonobject.getInt("ID");
                        String c_name = jsonobject.getString("CategoryName");
                        String c_image = jsonobject.getString("CategoryImage");

                        DailyRecipeModel model = new DailyRecipeModel(c_id,c_name,c_image);
                        list.add(model);
                    }
                    DailyrecipeAdapter adapter = new DailyrecipeAdapter(requireContext(), list,Category_List.this);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
                    list_cat.setLayoutManager(layoutManager);
                    list_cat.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(requireContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClickViewMore(int position) {
        Toast.makeText(requireContext(), ""+position, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void addToCart(int position) {

    }

}