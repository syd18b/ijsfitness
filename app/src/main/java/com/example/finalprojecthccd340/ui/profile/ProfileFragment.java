package com.example.finalprojecthccd340.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;
import com.example.finalprojecthccd340.Workout;
import com.example.finalprojecthccd340.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.finalprojecthccd340.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

  private FragmentProfileBinding binding;

  private ImageView profileImage;
  private TextView profileName, profileEmail, profileAge, profileHeight, profileWeight;
  private Button editProfileButton;

  private SharedPreferences prefs;
  private RecyclerView rvWorkoutHistory;
  private WorkoutAdapter workoutAdapter;
  private List<Workout> workoutList = new ArrayList<>();

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentProfileBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    // Initialize SharedPreferences
    prefs = requireContext().getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);

    // Bind views
    profileImage = binding.profileImage;
    profileName = binding.profileName;
    profileEmail = binding.profileEmail;
    profileAge = binding.profileAge;
    profileHeight = binding.profileHeight;
    profileWeight = binding.profileWeight;
    editProfileButton = binding.editProfile;

    // Load saved data or use defaults
    String firstName = prefs.getString("FIRST_NAME", "John");
    String lastName = prefs.getString("LAST_NAME", "Doe");
    String email = prefs.getString("EMAIL", "john.doe@example.com");
    int age = prefs.getInt("AGE", 24);
    String height = prefs.getString("HEIGHT", "");
    String weight = prefs.getString("WEIGHT", "");

    // Set values to UI
    profileImage.setImageResource(R.drawable.ic_default_profile); // default profile icon
    profileName.setText(firstName + " " + lastName);
    profileEmail.setText(email);
    profileAge.setText("Age: " + age);

    if (!height.isEmpty()) {
      profileHeight.setText("Height: " + height);
    } else {
      profileHeight.setText("Height: Not set");
    }

    if (!weight.isEmpty()) {
      profileWeight.setText("Weight: " + weight + " lbs");
    } else {
      profileWeight.setText("Weight: Not set");
    }

    // Edit profile button launches EditProfileFragment
    editProfileButton.setOnClickListener(v -> {
      FragmentTransaction transaction = getActivity()
              .getSupportFragmentManager()
              .beginTransaction();
      transaction.replace(R.id.fragment_container, new EditProfileFragment());
      transaction.addToBackStack(null);
      transaction.commit();
    });

    // Initialize RecyclerView for workout history
    rvWorkoutHistory = root.findViewById(R.id.rvWorkoutHistory);
    workoutAdapter = new WorkoutAdapter(workoutList);
    rvWorkoutHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
    rvWorkoutHistory.setAdapter(workoutAdapter);

    // Load workout history from SharedPreferences
    loadWorkoutHistory();

    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void loadWorkoutHistory() {
    SharedPreferences preferences = getActivity().getSharedPreferences("workout_history", Context.MODE_PRIVATE);
    Map<String, ?> allEntries = preferences.getAll();
    workoutList.clear();  // Clear current list before adding new items

    for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
      String workoutData = (String) entry.getValue();
      String[] data = workoutData.split(",");
      Workout workout = new Workout(data[0], data[1], data[2], data[3]);
      workoutList.add(workout);
    }

    // Notify adapter that the data has changed
    workoutAdapter.notifyDataSetChanged();
  }
}
