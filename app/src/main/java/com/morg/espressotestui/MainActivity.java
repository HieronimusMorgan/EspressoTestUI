package com.morg.espressotestui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.morg.espressotestui.databinding.ActivityMainBinding;
import com.morg.espressotestui.fragment.DirectorsFragment;
import com.morg.espressotestui.fragment.MovieDetailFragment;
import com.morg.espressotestui.fragment.StarActorsFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnDirectors.setOnClickListener(view -> changeFragment(new DirectorsFragment()));
        binding.btnMovieDetail.setOnClickListener(view -> changeFragment(new MovieDetailFragment()));
        binding.btnStarActor.setOnClickListener(view -> changeFragment(new StarActorsFragment()));

    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, Objects.requireNonNull(fragment));
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}