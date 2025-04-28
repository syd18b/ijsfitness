package com.example.finalprojecthccd340;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutPlanFragment extends Fragment {

  private static final String TAG = "WorkoutPlanFragment";

  private EditText editGoal, editTargetMuscle, editTimeFrame;
  private Button btnSaveWorkoutPlan;

  public static final String SHARED_PREF_NAME = "USER_INFO";
  public static final String GOAL = "GOAL";
  public static final String TARGET_MUSCLE = "TARGET_MUSCLE";
  public static final String TIME_FRAME = "TIME_FRAME";

  private SharedPreferences sharedPreferences;

  public WorkoutPlanFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_workout_plan, container, false);

    editGoal = rootView.findViewById(R.id.editWorkoutGoal);
    editTargetMuscle = rootView.findViewById(R.id.editTargetMuscle);
    editTimeFrame = rootView.findViewById(R.id.editTimeFrame);
    btnSaveWorkoutPlan = rootView.findViewById(R.id.btnSaveWorkoutPlan);

    sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREF_NAME, getContext().MODE_PRIVATE);

    btnSaveWorkoutPlan.setOnClickListener(v -> {
      saveWorkoutPlan(v);
      NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
      navController.popBackStack();
    });

    return rootView;
  }

  private void saveWorkoutPlan(View view) {
    String goal = editGoal.getText().toString().trim();
    String targetMuscle = editTargetMuscle.getText().toString().trim();
    String timeFrame = editTimeFrame.getText().toString().trim();

    if (goal.isEmpty() || targetMuscle.isEmpty() || timeFrame.isEmpty()) {
      Snackbar.make(view, "Please fill in all fields", Snackbar.LENGTH_LONG).show();
      return;
    }

    Log.d(TAG, "Saving workout: Goal = " + goal + ", Target Muscle = " + targetMuscle + ", Time Frame = " + timeFrame);

    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(GOAL, goal);
    editor.putString(TARGET_MUSCLE, targetMuscle);
    editor.putString(TIME_FRAME, timeFrame);
    editor.apply();

    Snackbar.make(view, "Workout Plan Saved!", Snackbar.LENGTH_LONG).show();
  }
}
