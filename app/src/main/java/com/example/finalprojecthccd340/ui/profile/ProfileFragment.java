package com.example.finalprojecthccd340.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;
import com.example.finalprojecthccd340.Workout;
import com.example.finalprojecthccd340.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileFragment extends Fragment {

  private RecyclerView rvWorkoutHistory;
  private WorkoutAdapter workoutAdapter;
  private List<Workout> workoutList = new ArrayList<>();

  private TextView profileName, profileAge, profileHeight, profileWeight;
  private Switch editProfileToggle;

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_profile, container, false);

    profileName = root.findViewById(R.id.profileName);
    profileAge = root.findViewById(R.id.profileAge);
    profileHeight = root.findViewById(R.id.profileHeight);
    profileWeight = root.findViewById(R.id.profileWeight);

    editProfileToggle = root.findViewById(R.id.editProfileToggle);

    // Setup RecyclerView for workout history
    rvWorkoutHistory = root.findViewById(R.id.rvWorkoutHistory);
    workoutAdapter = new WorkoutAdapter(workoutList);
    rvWorkoutHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
    rvWorkoutHistory.setAdapter(workoutAdapter);

    // Load workout history from SharedPreferences
    loadWorkoutHistory();

    return root;
  }

  private void loadWorkoutHistory() {
    SharedPreferences preferences = getActivity().getSharedPreferences("workout_history", Context.MODE_PRIVATE);
    Map<String, ?> allEntries = preferences.getAll();
    workoutList.clear();  // Clear current list before adding new items

    for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
      String workoutData = (String) entry.getValue();
      String[] data = workoutData.split(",");
      Workout workout = new Workout(data[0], data[1], data[2], data[3]);
      workoutList.add(workout);
    }

    // Notify adapter that the data has changed
    workoutAdapter.notifyDataSetChanged();
  }
}
