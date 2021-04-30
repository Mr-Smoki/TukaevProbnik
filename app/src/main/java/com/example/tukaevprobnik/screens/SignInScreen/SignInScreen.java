package com.example.tukaevprobnik.screens.SignInScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tukaevprobnik.common.entity.CheckData;
import com.example.tukaevprobnik.databinding.ActivitySignInScreenBinding;

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