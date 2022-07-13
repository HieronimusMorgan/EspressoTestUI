package com.morg.espressotestui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.morg.espressotestui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonTakePhoto.setOnClickListener(view -> {
            Dialog fileDialog = new Dialog(this, s -> binding.tvDetailParent.setText(s));
            fileDialog.show();
        });
    }

}