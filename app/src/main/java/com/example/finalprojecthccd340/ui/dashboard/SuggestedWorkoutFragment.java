package com.example.finalprojecthccd340.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.appcompat.app.AppCompatActivity;
import com.example.finalprojecthccd340.R;
import com.google.android.material.appbar.MaterialToolbar;

public class SuggestedWorkoutFragment extends Fragment {

  private TextView suggestionTextView;

  public SuggestedWorkoutFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_suggested_workout, container, false);

    suggestionTextView = root.findViewById(R.id.suggestionTextView);

    if (getArguments() != null) {
      String selectedBodyPart = getArguments().getString("bodyPart", "");

      String suggestion = generateWorkoutSuggestion(selectedBodyPart);
      suggestionTextView.setText(suggestion);
    }

    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Set up MaterialToolbar to show the back button
    MaterialToolbar toolbar = requireActivity().findViewById(R.id.topAppBar);
    if (toolbar != null) {
      toolbar.setNavigationIcon(android.R.drawable.ic_media_previous);  // Set back arrow icon
      toolbar.setNavigationOnClickListener(v -> {
        Navigation.findNavController(requireView()).navigateUp();  // Navigate back
      });
    }
  }

  // ✅ Detailed workout suggestions
  private String generateWorkoutSuggestion(String bodyPart) {
    if (bodyPart == null || bodyPart.isEmpty()) {
      return "Select a body part to see a suggested workout!";
    }

    switch (bodyPart) {
      case "Arms":
        return "Arm Workout:\n- 3 sets of 12 bicep curls\n- 3 sets of 15 tricep dips\nRest 45 seconds between sets.";
      case "Legs":
        return "Leg Workout:\n- 3 sets of 12 squats\n- 3 sets of 12 lunges\n- 3 sets of 15 calf raises\nRest 60 seconds between sets.";
      case "Back":
        return "Back Workout:\n- 3 sets of 10 barbell rows\n- 3 sets of 12 lat pulldowns\nRest 90 seconds between sets.";
      case "Chest":
        return "Chest Workout:\n- 3 sets of 10 push-ups\n- 3 sets of 8 bench presses\nRest 60 seconds between sets.";
      case "Shoulders":
        return "Shoulder Workout:\n- 3 sets of 12 overhead presses\n- 3 sets of 15 lateral raises\nRest 45 seconds between sets.";
      case "Core":
        return "Core Workout:\n- 3 sets of 20 crunches\n- 3 sets of 30-second planks\n- 3 sets of 15 Russian twists\nRest 30 seconds between sets.";
      default:
        return "Workout coming soon!";
    }
  }

}
