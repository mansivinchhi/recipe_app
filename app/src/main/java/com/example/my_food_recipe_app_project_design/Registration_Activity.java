package com.example.my_food_recipe_app_project_design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Registration_Activity extends AppCompatActivity {
    protected static final String URL = "http://192.168.1.68/food/API/addUser.php";

    String u_name,u_email,u_password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        EditText ediusername = findViewById(R.id.ediregusername);
        EditText ediemail = findViewById(R.id.ediregemail);
        EditText edipwd = findViewById(R.id.ediregpwd);
        EditText edicpwd = findViewById(R.id.ediregcpwd);

        Button btnreg = findViewById(R.id.btnreg);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ediusername.getText().toString().trim().isEmpty())
                {
                    ediusername.setError("plz enter username");
                }
                else if(ediemail.getText().toString().trim().isEmpty())
                {
                    ediemail.setError("plz enter email");

                }
                else if(edipwd.getText().toString().trim().isEmpty())
                {
                    edipwd.setError("plz enter password");
                }
                else if(edicpwd.getText().toString().trim().isEmpty())
                {
                    edicpwd.setError("plz enter confirm password");
                }

                else if (!ediemail.getText().toString().trim().matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }

                else if (!edicpwd.getText().toString().equals(edipwd.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Password does not matched", Toast.LENGTH_SHORT).show();
                }
                else {

                    u_name = ediusername.getText().toString();
                    u_email = ediemail.getText().toString();
                    u_password = edipwd.getText().toString();

                    insertTask();

                }
            }

        });
    }

    private void insertTask() {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constant.reg_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            boolean success = object.getBoolean("success");
                            String msg = object.getString("msg");
                            if(success)
                            {
                                Toast.makeText(Registration_Activity.this, msg, Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),Login_Activity.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(Registration_Activity.this, msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration_Activity.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> p = new HashMap<>();
                p.put("accept","application/json");
                return p;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> p = new HashMap<>();
                p.put("u_name",u_name);
                p.put("u_email",u_email);
                p.put("u_password",u_password);

                return p;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void login(View view) {
        startActivity(new Intent(getApplicationContext(),Login_Activity.class));
    }
}


//    public void login(View view) {
//        startActivity(new Intent(Registration_Activity.this, Login_Activity.class));
//    }
//    public void mainactivity(View view) {
//        startActivity(new Intent(Registration_Activity.this, MainActivity.class));
//    }
//});}}