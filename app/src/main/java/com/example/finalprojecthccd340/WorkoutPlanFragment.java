package com.example.finalprojecthccd340;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class WorkoutPlanFragment extends Fragment {

  private TextView textWorkoutSuggestion;
  private String selectedBodyPart = "";

  public WorkoutPlanFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_workout_plan, container, false);

    textWorkoutSuggestion = rootView.findViewById(R.id.textWorkoutSuggestion);

    if (getArguments() != null) {
      selectedBodyPart = getArguments().getString("bodyPart", "");
    }

    // Set the suggested workout based on the selected body part
    textWorkoutSuggestion.setText(getWorkoutSuggestion(selectedBodyPart));

    return rootView;
  }

  private String getWorkoutSuggestion(String bodyPart) {
    if (bodyPart == null || bodyPart.isEmpty()) {
      return "Select a body part to see a workout!";
    }

    switch (bodyPart) {
      case "Arms":
        return "Try bicep curls and tricep dips!";
      case "Legs":
        return "Try squats and lunges!";
      case "Back":
        return "Try rows and deadlifts!";
      case "Chest":
        return "Try push-ups and bench press!";
      case "Shoulders":
        return "Try overhead press and lateral raises!";
      default:
        return "Workout coming soon!";
    }
  }
}
