package com.example.finalprojecthccd340.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.finalprojecthccd340.R;

public class EditProfileFragment extends Fragment {

  private EditText editName, editAge, editHeight, editWeight;
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
    editName = rootView.findViewById(R.id.editName);
    editAge = rootView.findViewById(R.id.editAge);
    editHeight = rootView.findViewById(R.id.editHeight);
    editWeight = rootView.findViewById(R.id.editWeight);
    saveButton = rootView.findViewById(R.id.saveButton);

    // Set up button click listener
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        saveProfile();
      }
    });

    return rootView;
  }

  // Method to handle saving profile and replacing fragment
  private void saveProfile() {
    // Get the profile data from the EditText fields
    String name = editName.getText().toString();
    String age = editAge.getText().toString();
    String height = editHeight.getText().toString();
    String weight = editWeight.getText().toString();

    // Perform any necessary validation or save the data to your model here

    // Now, replace this fragment with the ProfileFragment
    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, new ProfileFragment()); // Replace with ProfileFragment
    transaction.addToBackStack(null); // Optional: Add to back stack
    transaction.commit();
  }
}
