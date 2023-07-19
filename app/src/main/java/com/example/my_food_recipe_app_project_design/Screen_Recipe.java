package com.example.my_food_recipe_app_project_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Screen_Recipe extends AppCompatActivity {

    Context mCOntext;
    Activity act;
    View view;
    RecyclerView recyclerView;
    Context mContext;

    public ArrayList<RecipeModel> getList() {
        return list;
    }

    ImageView imageView;
    ArrayList<RecipeModel> list = new ArrayList<RecipeModel>();
    String c_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_recipe);
        mContext = Screen_Recipe.this;
        act = Screen_Recipe.this;


       // Toolbar toolbar = view.findViewById(R.id.recipe_toolbar_back_button);
       // toolbar.setTitle("");
        //((Screen_Recipe) act).setSupportActionBar(toolbar);

       // setHasOptionsMenu(true);

        if (getIntent().getStringExtra("c_id") != null) {
            c_id = getIntent().getStringExtra("c_id");


        } else {
            Toast.makeText(mContext, "c_id is empty", Toast.LENGTH_SHORT).show();
        }
        FindViewById();
        Body();


    }

    private void Body() {
        getRecipeList(c_id);
    }
    private void FindViewById() {

        recyclerView =  findViewById(R.id.recycle_recipe);
        imageView = findViewById(R.id.recipe_image);

    }

    private void getRecipeList(String c_id)
    {
        list.clear();
        StringRequest request = new StringRequest(Request.Method.POST, Constant.getRecipeList, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response",""+response);
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

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("c_id", c_id);
                return param;
            }
        };



        RequestQueue queue = Volley.newRequestQueue(mContext);
        queue.add(request);
    }
}