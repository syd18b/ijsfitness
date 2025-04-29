package com.example.finalprojecthccd340.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.finalprojecthccd340.R;

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

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);

        String goal = sharedPreferences.getString("GOAL", "Not set");
        String targetMuscle = sharedPreferences.getString("TARGET_MUSCLE", "Not set");
        String timeFrame = sharedPreferences.getString("TIME_FRAME", "Not set");

        TextView goalTextView = view.findViewById(R.id.goalTextView);
        TextView muscleTextView = view.findViewById(R.id.muscleTextView);
        TextView timeFrameTextView = view.findViewById(R.id.timeFrameTextView);

        goalTextView.setText("Goal: " + goal);
        muscleTextView.setText("Target Muscle: " + targetMuscle);
        timeFrameTextView.setText("Time Frame: " + timeFrame);

        Button button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(v -> {
            // Navigate to Dashboard tab
            requireActivity().findViewById(R.id.nav_view)
                    .performClick(); // Optional: triggers the listener if implemented
        });
    }
}
