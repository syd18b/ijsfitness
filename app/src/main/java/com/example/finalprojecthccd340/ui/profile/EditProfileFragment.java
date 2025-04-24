package com.example.finalprojecthccd340.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.finalprojecthccd340.databinding.FragmentEditProfileBinding;

public class EditProfileFragment extends Fragment {

  private FragmentEditProfileBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout using ViewBinding
    binding = FragmentEditProfileBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    // Initialize views from the binding object
    EditText editName = binding.editName;
    EditText editAge = binding.editAge;
    EditText editHeight = binding.editHeight;
    EditText editWeight = binding.editWeight;
    Button saveButton = binding.saveButton;

    // Set initial values (these could come from a ViewModel or data source)
    editName.setText("John Doe");
    editAge.setText("24");
    editHeight.setText("170");
    editWeight.setText("70");

    // Save the changes when the user clicks the Save button
    saveButton.setOnClickListener(v -> {
      String updatedName = editName.getText().toString();
      String updatedAge = editAge.getText().toString();
      String updatedHeight = editHeight.getText().toString();
      String updatedWeight = editWeight.getText().toString();

      // You can handle saving the data to a ViewModel, SharedPreferences, or Database here

      // Return to the ProfileFragment with updated information
      getActivity().getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_container, new ProfileFragment()) // Assuming fragment_container is the container in your activity
        .commit();
    });

    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
