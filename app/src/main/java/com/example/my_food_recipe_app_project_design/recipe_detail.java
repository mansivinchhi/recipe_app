package com.example.my_food_recipe_app_project_design;

import static com.example.my_food_recipe_app_project_design.Constant.recipeImage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.Body;

public class recipe_detail extends AppCompatActivity {
    View view;
    TextView txtrecipe_title;
    ImageView recipe_details_image;
    Context mContext;
    Activity act;
    Button btnback_recipe_detail;
    FloatingActionButton regular_fab;
    EditText edi_feedback;
    RatingBar feedback_ratingBar;
    Button btn_feedback_submit;
    String f_description;
    float f_rating;
    Bundle bundle;
    String TAG ="recipe_detail";
    WebView txt_recipe_ingredients_details, txt_recipe_instruction_details;
    SharedPreferences sh_uid;

    String rid,rname,rimage,rIngredients,rInstruction = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        mContext = recipe_detail.this;
        act = recipe_detail.this;
        

        rid = getIntent().getStringExtra("R_Id" );
        rname = getIntent().getStringExtra("R_Name");
        rimage = getIntent().getStringExtra("R_Image");
        rIngredients= getIntent().getStringExtra("R_Ingredients");
        rInstruction = getIntent().getStringExtra("R_Instruction");

        FindViewById();
        Body();

    }

    private void FindViewById() {
        recipe_details_image = findViewById(R.id.recipe_details_image);
        txtrecipe_title = findViewById(R.id.txtrecipe_title);
//        txt_recipe_ingredients_details = view.findViewById(R.id.txt_recipe_ingredients_details);
        txt_recipe_ingredients_details = findViewById(R.id.txt_recipe_ingredients_details);
        txt_recipe_instruction_details = findViewById(R.id.txt_recipe_instruction_details);
        btnback_recipe_detail = findViewById(R.id.btnback_recipe_detail);
        regular_fab = findViewById(R.id.regular_fab);

    }
    private void Body() {

        regular_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertForFeedback(view);
            }
        });

        txtrecipe_title.setText(rname);
//            txt_recipe_instruction_details.setText(Html.fromHtml(bundle.getString("R_Instruction")));
//            txt_recipe_ingredients_details.setText(Html.fromHtml(bundle.getString("R_Ingredients")));

        txt_recipe_ingredients_details.loadData(rIngredients,"text/html; charset=utf-8", "utf-8");
        txt_recipe_instruction_details.loadData(rInstruction,"text/html; charset=utf-8", "utf-8");

        Glide.with(mContext).load(recipeImage + rimage).into(recipe_details_image);

        btnback_recipe_detail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });


    }
    public void showAlertForFeedback(View view) {
        Dialog dialog=new Dialog(mContext);
        dialog.setTitle("Feedback");
        dialog.setContentView(R.layout.feedback_dialog);
        edi_feedback = dialog.findViewById(R.id.edi_feedback);
        feedback_ratingBar = dialog.findViewById(R.id.feedback_ratingBar);
        btn_feedback_submit = dialog.findViewById(R.id.btn_feedback_submit);

        btn_feedback_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                f_description = edi_feedback.getText().toString();
                f_rating = (float) feedback_ratingBar.getRating();
                insertFeedback();
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    private void insertFeedback() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constant.addFeedback_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d(TAG,""+response);
                        Toast.makeText(mContext, ""+response, Toast.LENGTH_SHORT).show();
                        try {


                            JSONObject object = new JSONObject(response);
                            boolean success = object.getBoolean("success");
                            String msg = object.getString("msg");
                            if (success) {
                                Toast.makeText(mContext, ""+msg, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d(TAG,""+e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "" + error, Toast.LENGTH_SHORT).show();
                        Log.d(TAG,""+error.toString());
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
                Map<String, String> p = new HashMap<>();
//                SharedPreferences sharedPreferences = mContext.getSharedPreferences("userdata",0);
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                final String uid = sharedPreferences.getString("u_id","0");
               // Log.d("params","uid:"+uid+" r_id"+bundle.getString("R_Id")+" descreption :"+f_description+" rating "+f_rating);
                p.put("r_id", "" + rid);
                p.put("u_id", "11");
                p.put("f_description", f_description);
                p.put("f_rating", String.valueOf(f_rating));
                return p;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(mContext);
        queue.add(request);
    }


}