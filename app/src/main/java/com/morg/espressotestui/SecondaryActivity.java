package com.morg.espressotestui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.morg.espressotestui.databinding.ActivitySecondaryBinding;

public class SecondaryActivity extends AppCompatActivity {
    ActivitySecondaryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(view -> onBackPressed());
    }
}