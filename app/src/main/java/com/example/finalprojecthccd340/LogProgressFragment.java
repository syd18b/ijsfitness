package com.example.finalprojecthccd340;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.finalprojecthccd340.R;

public class LogProgressFragment extends Fragment {

  private EditText weightInput, repsInput, stepsInput, exerciseInput;

  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_log_progress, container, false);

    weightInput = root.findViewById(R.id.weightInput);
    repsInput = root.findViewById(R.id.repsInput);
    stepsInput = root.findViewById(R.id.stepsInput);
    exerciseInput = root.findViewById(R.id.exerciseInput);

    root.findViewById(R.id.btnSaveWorkout).setOnClickListener(v -> {
      saveWorkout();
    });

    return root;
  }

  private void saveWorkout() {
    String exercise = exerciseInput.getText().toString();
    String weight = weightInput.getText().toString();
    String reps = repsInput.getText().toString();
    String steps = stepsInput.getText().toString();

    if (exercise.isEmpty() || weight.isEmpty() || reps.isEmpty() || steps.isEmpty()) {
      Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
      return;
    }

    SharedPreferences preferences = getActivity().getSharedPreferences("workout_history", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    // Create a unique key for each workout (timestamp-based)
    String workoutKey = "workout_" + System.currentTimeMillis();
    String workoutData = exercise + "," + weight + "," + reps + "," + steps;

    // Save the workout data
    editor.putString(workoutKey, workoutData);
    editor.apply();

    Toast.makeText(getActivity(), "Workout saved!", Toast.LENGTH_SHORT).show();
  }
}
