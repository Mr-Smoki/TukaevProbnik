package com.example.tukaevprobnik.screens.SignInScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tukaevprobnik.common.entity.CheckData;
import com.example.tukaevprobnik.databinding.ActivitySignInScreenBinding;
import com.example.tukaevprobnik.screens.MainScreen.MainScreen;

import org.json.JSONException;
import org.json.JSONObject;

public class SignInScreen extends AppCompatActivity {

    ActivitySignInScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void SignIn(View view) {
        if(
                !binding.emailET.getText().toString().isEmpty()&&
                        !binding.passwordET.getText().toString().isEmpty()
        )
        {
            if (CheckData.checkMail(binding.emailET.getText().toString())){
                String url = "http://cinema.areas.su/auth/login";
                JSONObject object=new JSONObject();
                try {
                    object.put("email",binding.emailET.getText().toString());
                    object.put("password",binding.passwordET.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, object, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    CheckData.token=response.getLong("token");
                                    Intent intent = new Intent(SignInScreen.this, MainScreen.class);
                                    startActivity(intent);
                                    finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.getMessage();
                            }
                        });

// Access the RequestQueue through your singleton class.
               Volley.newRequestQueue(SignInScreen.this).add(jsonObjectRequest);

            }
            else {
                CheckData.makeMessage("Некорректный e-mail",this);
            }
        }
        else {
            CheckData.makeMessage("Есть пустые поля",this);
        }
    }
}