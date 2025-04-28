package com.example.finalprojecthccd340.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.finalprojecthccd340.R;

public class NewWorkoutChoiceFragment extends Fragment {

  private Button workoutPlanButton;
  private Button stretchPlanButton;

  public NewWorkoutChoiceFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_new_workout_choice, container, false);

    workoutPlanButton = root.findViewById(R.id.btnWorkoutPlan);
    stretchPlanButton = root.findViewById(R.id.btnStretchPlan);

    workoutPlanButton.setOnClickListener(v -> {
      Bundle bundle = new Bundle();
      bundle.putString("type", "workout");
      Navigation.findNavController(v).navigate(R.id.bodyPartSelectFragment, bundle);
    });

    stretchPlanButton.setOnClickListener(v -> {
      Bundle bundle = new Bundle();
      bundle.putString("type", "stretch");
      Navigation.findNavController(v).navigate(R.id.bodyPartSelectFragment, bundle);
    });

    return root;
  }
}
