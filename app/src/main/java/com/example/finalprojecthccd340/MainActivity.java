package com.example.finalprojecthccd340;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.finalprojecthccd340.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private List<Workout> workoutHistory = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    BottomNavigationView navView = binding.navView;

    NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
            .findFragmentById(R.id.nav_host_fragment);
    NavController navController = navHostFragment.getNavController();

    NavigationUI.setupWithNavController(navView, navController);
  }

  public void addWorkoutToHistory(Workout workout) {
    workoutHistory.add(workout);
  }

  public List<Workout> getWorkoutHistory() {
    return workoutHistory;
  }
}
