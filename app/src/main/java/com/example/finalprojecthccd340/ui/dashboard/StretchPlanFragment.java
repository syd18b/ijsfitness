
package com.example.finalprojecthccd340.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.finalprojecthccd340.R;
import com.google.android.material.appbar.MaterialToolbar;

public class StretchPlanFragment extends Fragment {

  private TextView stretchSuggestionTextView;

  public StretchPlanFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_stretch_plan, container, false);

    stretchSuggestionTextView = root.findViewById(R.id.stretchSuggestionTextView);

    if (getArguments() != null) {
      String selectedBodyPart = getArguments().getString("bodyPart", "");

      String stretchSuggestion = generateStretchSuggestion(selectedBodyPart);
      stretchSuggestionTextView.setText(stretchSuggestion);
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

  private String generateStretchSuggestion(String bodyPart) {
    if (bodyPart == null || bodyPart.isEmpty()) {
      return "Select a body part to see a stretch plan!";
    }

    switch (bodyPart) {
      case "Arms":
        return "Arm Stretch:\n- 3 sets of 20-second arm circles\n- 2 sets of 20-second tricep stretches.";
      case "Chest":
        return "Chest Stretch:\n- 3 sets of 30-second doorway stretches\n- 2 sets of 20-second chest openers.";
      case "Core":
        return "Core Stretch:\n- 3 sets of 30-second cobra stretches\n- 3 sets of 30-second cat-cow stretches.";
      case "Legs":
        return "Leg Stretch:\n- 3 sets of 30-second hamstring stretches\n- 3 sets of 30-second quad stretches.";
      case "Back":
        return "Back Stretch:\n- 3 sets of 30-second child's poses\n- 3 sets of 20-second seated spinal twists.";
      case "Shoulders":
        return "Shoulder Stretch:\n- 3 sets of 20-second cross-body stretches\n- 2 sets of 20-second overhead stretches.";
      default:
        return "Stretch coming soon!";
    }
  }
}
