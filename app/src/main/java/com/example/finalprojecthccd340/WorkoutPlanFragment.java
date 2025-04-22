package com.example.finalprojecthccd340;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class WorkoutPlanFragment extends Fragment {

  // Declare EditText variables
  private EditText editGoal, editTargetMuscle, editTimeFrame;
  private Button btnSaveWorkoutPlan;

  public WorkoutPlanFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the fragment layout
    View rootView = inflater.inflate(R.layout.fragment_workout_plan, container, false);

    // Initialize the EditText views from the layout using findViewById
    editGoal = rootView.findViewById(R.id.editWorkoutGoal); // Correct ID from XML
    editTargetMuscle = rootView.findViewById(R.id.editTargetMuscle); // Correct ID from XML
    editTimeFrame = rootView.findViewById(R.id.editTimeFrame); // Correct ID from XML
    btnSaveWorkoutPlan = rootView.findViewById(R.id.btnSaveWorkoutPlan); // Correct ID from XML

    // Set up the button to save the workout plan
    btnSaveWorkoutPlan.setOnClickListener(v -> saveWorkoutPlan());

    return rootView;
  }

  private void saveWorkoutPlan() {
    // Get the text from the EditText fields
    String workoutGoal = editGoal.getText().toString();
    String targetMuscle = editTargetMuscle.getText().toString();
    String timeFrame = editTimeFrame.getText().toString();

    // You can now use the data (e.g., save it to a database, or display a message)
  }
}
