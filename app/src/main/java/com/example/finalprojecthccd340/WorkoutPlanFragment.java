package com.example.finalprojecthccd340;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class WorkoutPlanFragment extends Fragment {

  private EditText editGoal, editTimeFrame;
  private Button btnSaveGoal;

  public WorkoutPlanFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the fragment layout
    View rootView = inflater.inflate(R.layout.fragment_workout_plan, container, false);

    // Initialize views
    editGoal = rootView.findViewById(R.id.editGoal);
    editTimeFrame = rootView.findViewById(R.id.editTimeFrame);
    btnSaveGoal = rootView.findViewById(R.id.btnSaveGoal);

    // Set button click listener
    btnSaveGoal.setOnClickListener(v -> saveWorkoutGoal());

    return rootView;
  }

  // Method to save the workout goal
  private void saveWorkoutGoal() {
    String goal = editGoal.getText().toString();
    String timeFrame = editTimeFrame.getText().toString();

    // Simple validation
    if (goal.isEmpty()) {
      Toast.makeText(getActivity(), "Please enter a workout goal.", Toast.LENGTH_SHORT).show();
    } else {
      // Save logic (e.g., save to database or SharedPreferences)
      Toast.makeText(getActivity(), "Goal saved: " + goal, Toast.LENGTH_SHORT).show();
    }
  }
}
