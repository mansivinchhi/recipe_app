package com.example.my_food_recipe_app_project_design;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {

    //variable for all the requird field
    String u_email, u_password;
    //for email pattern
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //for shared preference
    SharedPreferences sharedPreferences;
    //for checkbox bydefolt
    boolean IsChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sharedPreferences = getSharedPreferences(Constant.sharedpreferencename, MODE_PRIVATE);


        EditText ediemail = findViewById(R.id.ediemail);
        EditText edipwd = findViewById(R.id.edipwd);

        Button btnlogin1 = findViewById(R.id.btnlogin1);
        CheckBox chkrememberme = findViewById(R.id.chkrememberme);

        //for checkox
        chkrememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    IsChecked = true;
                }
            }
        });
        //Login Button onclick event
        btnlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if elseif condition if any field isEmpty then set a error

                if (ediemail.getText().toString().trim().isEmpty()) {
                    ediemail.setError("plz enter email");

                } else if (edipwd.getText().toString().trim().isEmpty()) {
                    edipwd.setError("plz enter password");
                } else if (!ediemail.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                } else {
                    u_email = ediemail.getText().toString();
                    u_password = edipwd.getText().toString();
                    login();
                }
            }
        });

    }

    //login method
    private void login() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constant.login_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
//                            Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                            JSONObject object = new JSONObject(response);
                            boolean success = object.getBoolean("success");
                            String msg = object.getString("msg");
                            String u_id=object.getString("u_id");
                            if (success) {
                                Toast.makeText(Login_Activity.this, msg, Toast.LENGTH_SHORT).show();
                                if (IsChecked) {

                                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                    myEdit.putString(Constant.email_key, u_email);
                                    myEdit.putString(Constant.u_id,u_id);
                                    myEdit.commit();
                                    myEdit.apply();
                                }
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(Login_Activity.this,"Invalid email or password!", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login_Activity.this, "Invalid email or password!" + error, Toast.LENGTH_SHORT).show();
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
                p.put("u_email", u_email);
                p.put("u_password", u_password);
                return p;
            }
        };
        //for volly request

        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(request);
    }

    public void register(View view) {
        startActivity(new Intent(getApplicationContext(),Registration_Activity.class));
    }
}



//    public void Register(View view) {
//        startActivity(new Intent(Login_Activity.this, Registration_Activity.class));
//    }
//    public void mainactivity(View view) {
//        startActivity(new Intent(Login_Activity.this,Registration_Activity.class));
//    }
//}