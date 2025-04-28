package com.example.finalprojecthccd340.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.finalprojecthccd340.R;

public class DashboardFragment extends Fragment {

  private Button btnWorkoutPlan;
  private Button btnStretchPlan;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

    btnWorkoutPlan = root.findViewById(R.id.btnWorkoutPlan);
    btnStretchPlan = root.findViewById(R.id.btnStretchPlan);

    btnWorkoutPlan.setOnClickListener(v -> {
      Bundle bundle = new Bundle();
      bundle.putString("type", "workout");
      Navigation.findNavController(v).navigate(R.id.bodyPartSelectFragment, bundle);
    });

    btnStretchPlan.setOnClickListener(v -> {
      Bundle bundle = new Bundle();
      bundle.putString("type", "stretch");
      Navigation.findNavController(v).navigate(R.id.bodyPartSelectFragment, bundle);
    });

    return root;
  }
}
