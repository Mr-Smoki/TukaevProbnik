package com.example.tukaevprobnik.screens.MainScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tukaevprobnik.databinding.ActivityMainBinding;
import com.example.tukaevprobnik.databinding.ActivitySignInScreenBinding;

public class MainScreen extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}