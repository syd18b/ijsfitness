package com.example.finalprojecthccd340.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.example.finalprojecthccd340.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalprojecthccd340.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

  private FragmentProfileBinding binding;
  private ImageView profileImage;
  private TextView profileName, profileAge, profileHeight, profileWeight;
  private EditText editProfileName, editProfileAge, editProfileHeight, editProfileWeight;
  private Switch editProfileToggle;

  private static final int PICK_IMAGE_REQUEST = 1;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProfileBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    // Initialize views
    profileImage = binding.profileImage;
    profileName = binding.profileName;
    profileAge = binding.profileAge;
    profileHeight = binding.profileHeight;
    profileWeight = binding.profileWeight;

    editProfileName = binding.editProfileName;
    editProfileAge = binding.editProfileAge;
    editProfileHeight = binding.editProfileHeight;
    editProfileWeight = binding.editProfileWeight;
    editProfileToggle = binding.editProfileToggle;

    // Set initial values (these would come from your ViewModel or data)
    profileName.setText("John Doe");
    profileAge.setText("Age: 24");
    profileHeight.setText("Height: 170 cm");
    profileWeight.setText("Weight: 70 kg");

    // Set the default profile image (placeholder)
    profileImage.setImageResource(R.drawable.ic_default_profile);

    // Handle toggle for switching between edit and view mode
    editProfileToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        // Switch to editing mode
        profileName.setVisibility(View.GONE);
        profileAge.setVisibility(View.GONE);
        profileHeight.setVisibility(View.GONE);
        profileWeight.setVisibility(View.GONE);
        profileImage.setVisibility(View.GONE);

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
        profileImage.setVisibility(View.VISIBLE);

        editProfileName.setVisibility(View.GONE);
        editProfileAge.setVisibility(View.GONE);
        editProfileHeight.setVisibility(View.GONE);
        editProfileWeight.setVisibility(View.GONE);

        // Save updated values
        String updatedName = editProfileName.getText().toString();
        String updatedAge = editProfileAge.getText().toString();
        String updatedHeight = editProfileHeight.getText().toString();
        String updatedWeight = editProfileWeight.getText().toString();

        // Update the TextViews with new values
        profileName.setText(updatedName);
        profileAge.setText("Age: " + updatedAge);
        profileHeight.setText("Height: " + updatedHeight + " cm");
        profileWeight.setText("Weight: " + updatedWeight + " kg");
      }
    });

    // Profile image click listener to allow image change
    profileImage.setOnClickListener(v -> openImagePicker());

    return root;
  }

  // Method to open the image picker for changing the profile picture
  private void openImagePicker() {
    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    intent.setType("image/*");
    startActivityForResult(intent, PICK_IMAGE_REQUEST);
  }

  // Handle the result of the image picker
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
      // Get the image URI
      Bitmap selectedImage = null;
      try {
        selectedImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
        // Set the selected image as the profile picture
        profileImage.setImageBitmap(selectedImage);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
