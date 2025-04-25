package com.example.finalprojecthccd340;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalprojecthccd340.databinding.ActivityMainBinding;
import com.example.finalprojecthccd340.Workout;

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

    BottomNavigationView navView = findViewById(R.id.nav_view);

    // Set up the app's navigation and action bar
    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
      R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profile)
      .build();
    NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
    NavController navController = navHostFragment.getNavController();

    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(binding.navView, navController);
  }

  // Method to add a workout to the history
  public void addWorkoutToHistory(Workout workout) {
    workoutHistory.add(workout);
  }

  // Method to get the workout history
  public List<Workout> getWorkoutHistory() {
    return workoutHistory;
  }
}
