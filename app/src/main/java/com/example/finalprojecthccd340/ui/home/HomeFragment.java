package com.example.finalprojecthccd340.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.finalprojecthccd340.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Button button5 = view.findViewById(R.id.button5); // "New Workout" button

    button5.setOnClickListener(v -> {
      // ✅ Instead of navigating manually, simulate tapping the bottom nav
      BottomNavigationView bottomNav = requireActivity().findViewById(R.id.nav_view);
      bottomNav.setSelectedItemId(R.id.navigation_dashboard);
    });
  }
}
