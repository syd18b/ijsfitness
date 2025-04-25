package com.example.finalprojecthccd340.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.finalprojecthccd340.R;
import com.example.finalprojecthccd340.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

  private FragmentProfileBinding binding;

  // Declare EditText fields for user input
  private EditText editProfileName, editProfileAge, editProfileHeight, editProfileWeight;
  private TextView profileName, profileAge, profileHeight, profileWeight;
  private Switch editProfileToggle;

  private Button editProfileButton;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProfileBinding.inflate(inflater, container, false);
    View root = binding.getRoot();


    editProfileButton = root.findViewById(R.id.editProfile);

    editProfileButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Launch EditProfileFragment
        FragmentTransaction transaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.fragment_container, new EditProfileFragment());
        transaction.addToBackStack(null); // Optional: adds to back stack
        transaction.commit();

    // Initialize views
    profileName = binding.profileName;
    profileAge = binding.profileAge;
    profileHeight = binding.profileHeight;
    profileWeight = binding.profileWeight;

    editProfileName = binding.editProfileName;
    editProfileAge = binding.editProfileAge;
    editProfileHeight = binding.editProfileHeight;
    editProfileWeight = binding.editProfileWeight;
    editProfileToggle = binding.editProfileToggle;

    // Set initial values (this would come from your data or ViewModel)
    profileName.setText("John Doe");
    profileAge.setText("Age: 24");

    // Convert height from cm to feet and inches
    int cm = 170;
    int feet = cm / 30;  // 1 foot = 30.48 cm
    int inches = (int)((cm % 30) / 2.54);  // remaining inches
    profileHeight.setText("Height: " + feet + " ft " + inches + " in");

    // Convert weight from kg to pounds
    double kg = 70;
    double pounds = kg * 2.20462;
    profileWeight.setText("Weight: " + String.format("%.1f", pounds) + " lbs");

    // Handle toggle for switching between edit and view mode
    editProfileToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        // Switch to editing mode
        profileName.setVisibility(View.GONE);
        profileAge.setVisibility(View.GONE);
        profileHeight.setVisibility(View.GONE);
        profileWeight.setVisibility(View.GONE);

        editProfileName.setVisibility(View.VISIBLE);
        editProfileAge.setVisibility(View.VISIBLE);
        editProfileHeight.setVisibility(View.VISIBLE);
        editProfileWeight.setVisibility(View.VISIBLE);

        // Populate the EditText fields with current values
        editProfileName.setText("John Doe");
        editProfileAge.setText("24");
        editProfileHeight.setText("170");
        editProfileWeight.setText("70");
      } else {
        // Switch back to view mode
        profileName.setVisibility(View.VISIBLE);
        profileAge.setVisibility(View.VISIBLE);
        profileHeight.setVisibility(View.VISIBLE);
        profileWeight.setVisibility(View.VISIBLE);

        editProfileName.setVisibility(View.GONE);
        editProfileAge.setVisibility(View.GONE);
        editProfileHeight.setVisibility(View.GONE);
        editProfileWeight.setVisibility(View.GONE);

        // Save updated values
        String updatedName = editProfileName.getText().toString();
        String updatedAge = editProfileAge.getText().toString();
        String updatedHeight = editProfileHeight.getText().toString();
        String updatedWeight = editProfileWeight.getText().toString();

        // Convert height from cm to feet and inches
        int newCm = Integer.parseInt(updatedHeight);
        int newFeet = newCm / 30;
        int newInches = (int)((newCm % 30) / 2.54);
        profileHeight.setText("Height: " + newFeet + " ft " + newInches + " in");

        // Convert weight from kg to pounds
        double newKg = Double.parseDouble(updatedWeight);
        double newPounds = newKg * 2.20462;
        profileWeight.setText("Weight: " + String.format("%.1f", newPounds) + " lbs");

        // Update the TextViews with new values
        profileName.setText(updatedName);
        profileAge.setText("Age: " + updatedAge);
      }
    });

    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
