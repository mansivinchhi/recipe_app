//package com.example.cookmate;
package com.example.my_food_recipe_app_project_design;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

public class RecipeFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    Context mContext;
    ImageView imageView;
    ArrayList<RecipeModel> list = new ArrayList<RecipeModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recipe, container, false);
        mContext = container.getContext();
        list.clear();
        recyclerView = view.findViewById(R.id.recycle_recipe);
        imageView = view.findViewById(R.id.recipe_image);

        Bundle bundle = this.getArguments();
        String c_id;
        if (bundle != null) {
            c_id = bundle.getString("c_id");
            getRecipeList(c_id);
        } else {
            Toast.makeText(mContext, "notabc", Toast.LENGTH_SHORT).show();
        }
        return view;
    }


    private String getRecipeList(String c_id)
    {
        list.clear();
        StringRequest request = new StringRequest(Request.Method.POST, Constant.getRecipeList, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(mContext, ""+response, Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonarray = new JSONArray(response);
                    for (int i = 0; i < jsonarray.length(); i++) {
                        RecipeModel model = new RecipeModel();

                        JSONObject jsonobject = jsonarray.getJSONObject(i);

                        model.setRid(jsonobject.getString("r_id"));
                        model.setRname(jsonobject.getString("r_name"));
                        model.setRimage(jsonobject.getString("r_image"));
                        model.setRingredients(jsonobject.getString("r_ingredients"));
                        model.setRinstruction(jsonobject.getString("r_instruction"));
                        model.setCid(jsonobject.getString("c_id"));

                        list.add(model);

                    }

                    //Set Adapter To Set list
                    RecipeAdaptor recipeAdaptor = new RecipeAdaptor(mContext, list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    recyclerView.setAdapter(recipeAdaptor);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error::::", "" + error);
                Toast.makeText(mContext, "" + error, Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> p = new HashMap<>();
                p.put("accept", "application/json");
                return p;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("c_id", c_id);
                return param;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(mContext);
        queue.add(request);
        return null;
    }

}