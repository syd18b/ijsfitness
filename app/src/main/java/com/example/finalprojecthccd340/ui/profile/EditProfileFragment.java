package com.example.finalprojecthccd340.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.finalprojecthccd340.R;
import com.google.android.material.snackbar.Snackbar;

public class EditProfileFragment extends Fragment {

  private EditText editFirst, editLast, editAge, editEmail, editPassword, editHeight, editWeight;
  private Button saveButton;

  public EditProfileFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_edit_profile, container, false);

    // Initialize views
    editFirst = rootView.findViewById(R.id.editFirstName);
    editLast = rootView.findViewById(R.id.editLastName);
    editEmail = rootView.findViewById(R.id.editEmail);
    editPassword = rootView.findViewById(R.id.editPassword);
    editAge = rootView.findViewById(R.id.editAge);
    editHeight = rootView.findViewById(R.id.editHeight);
    editWeight = rootView.findViewById(R.id.editWeight);
    saveButton = rootView.findViewById(R.id.saveButton);

    // Load saved preferences and pre-fill EditTexts
    SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);

    String savedFirst = sharedPreferences.getString("FIRST_NAME", "");
    String savedLast = sharedPreferences.getString("LAST_NAME", "");
    String savedEmail = sharedPreferences.getString("EMAIL", "");
    String savedPassword = sharedPreferences.getString("PASSWORD", "");

    int savedAge = sharedPreferences.getInt("AGE", -1);
    String savedHeight = sharedPreferences.getString("HEIGHT", "");
    String savedWeight = sharedPreferences.getString("WEIGHT", "");

    if (editFirst.getText().toString().isEmpty() && !savedFirst.isEmpty()) {
      editFirst.setText(savedFirst);
    }

    if (editLast.getText().toString().isEmpty() && !savedLast.isEmpty()) {
      editLast.setText(savedLast);
    }

    if (editEmail.getText().toString().isEmpty() && !savedEmail.isEmpty()) {
      editEmail.setText(savedEmail);
    }

    if (editPassword.getText().toString().isEmpty() && !savedPassword.isEmpty()) {
      editPassword.setText(savedPassword);
    }

    if (editAge.getText().toString().isEmpty() && savedAge != -1) {
      editAge.setText(String.valueOf(savedAge));
    }

    if (editHeight.getText().toString().isEmpty() && !savedHeight.isEmpty()) {
      editHeight.setText(savedHeight);
    }

    if (editWeight.getText().toString().isEmpty() && !savedWeight.isEmpty()) {
      editWeight.setText(savedWeight);
    }

    // Profile image handling can be added here
    ImageView profileImage = rootView.findViewById(R.id.profileImage);

    Button changePhotoButton = rootView.findViewById(R.id.changePhotoButton);

    // changePhotoButton.setOnClickListener(v -> {
      // Launch intent to pick an image from gallery or camera
    // });

    // saveButton.setOnClickListener(v -> saveProfile());

    return rootView;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    saveButton.setOnClickListener(v -> {
      saveProfile();
      NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
      navController.popBackStack();
      Toast.makeText(requireContext(), "Profile saved successfully!", Toast.LENGTH_SHORT).show();
    });
  }

  private void saveProfile() {
    // Get the profile data from the EditText fields
    String first = editFirst.getText().toString();
    String last = editLast.getText().toString();
    String email = editEmail.getText().toString();
    String password = editPassword.getText().toString();

    String age = editAge.getText().toString();
    String height = editHeight.getText().toString();
    String weight = editWeight.getText().toString();

    SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("FIRST_NAME", first);
    editor.putString("LAST_NAME", last);
    editor.putString("EMAIL", email);
    editor.putString("PASSWORD", password);

    if (!age.isEmpty()) {
      editor.putInt("AGE", Integer.parseInt(age));
    }

    editor.putString("HEIGHT", height);
    editor.putString("WEIGHT", weight);
    editor.apply();
  }
}

