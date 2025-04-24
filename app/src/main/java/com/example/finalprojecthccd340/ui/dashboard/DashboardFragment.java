package com.example.finalprojecthccd340.ui.dashboard;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalprojecthccd340.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

  private FragmentDashboardBinding binding;
  private String[] bodyParts = {"Arms", "Legs", "Back", "Chest", "Shoulders"};

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    // Set up Spinner
    ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
      android.R.layout.simple_spinner_dropdown_item, bodyParts);
    binding.spinnerBodyParts.setAdapter(adapter);

    // Workout Plan Button
    binding.btnWorkoutPlan.setOnClickListener(v -> {
      binding.spinnerBodyParts.setVisibility(View.VISIBLE);
      binding.spinnerBodyParts.setOnItemSelectedListener(new SimpleItemSelectedListener(item -> {
        showPopup("Workout Plan for " + item, "Here’s a great workout for your " + item.toLowerCase() + "!");
      }));
    });

    // Stretch Plan Button
    binding.btnStretchPlan.setOnClickListener(v -> {
      binding.spinnerBodyParts.setVisibility(View.VISIBLE);
      binding.spinnerBodyParts.setOnItemSelectedListener(new SimpleItemSelectedListener(item -> {
        showPopup("Stretch Plan for " + item, "Here’s a helpful stretch for your " + item.toLowerCase() + "!");
      }));
    });

    return root;
  }

  private void showPopup(String title, String message) {
    new AlertDialog.Builder(requireContext())
      .setTitle(title)
      .setMessage(message)
      .setPositiveButton("OK", null)
      .show();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
