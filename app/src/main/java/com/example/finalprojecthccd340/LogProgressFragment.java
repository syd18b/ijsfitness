package com.example.finalprojecthccd340;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LogProgressFragment extends Fragment {

  private EditText editExercise, editWeight, editReps, editSteps;
  private Button btnSaveProgress;

  public LogProgressFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the fragment layout
    View rootView = inflater.inflate(R.layout.fragment_log_progress, container, false);

    // Initialize the views by finding them from the inflated root view
    editExercise = rootView.findViewById(R.id.editExercise);
    editWeight = rootView.findViewById(R.id.editWeight);
    editReps = rootView.findViewById(R.id.editReps);
    editSteps = rootView.findViewById(R.id.editSteps);
    btnSaveProgress = rootView.findViewById(R.id.btnSaveProgress);

    // Set the button click listener to save the progress
    btnSaveProgress.setOnClickListener(v -> saveProgress());

    return rootView;
  }

  // Method to save the progress
  private void saveProgress() {
    String exercise = editExercise.getText().toString();
    String weight = editWeight.getText().toString();
    String reps = editReps.getText().toString();
    String steps = editSteps.getText().toString();

    // Simple validation to ensure all required fields are filled in
    if (exercise.isEmpty() || weight.isEmpty() || reps.isEmpty()) {
      Toast.makeText(getActivity(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
    } else {
      // Save logic (e.g., save to database or SharedPreferences)
      Toast.makeText(getActivity(), "Progress saved: " + exercise, Toast.LENGTH_SHORT).show();
    }
  }
}
