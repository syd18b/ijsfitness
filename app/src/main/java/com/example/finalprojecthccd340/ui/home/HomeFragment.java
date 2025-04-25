package com.example.finalprojecthccd340.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.finalprojecthccd340.R;
import com.example.finalprojecthccd340.ui.dashboard.DashboardFragment;

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

        Button button2 = view.findViewById(R.id.button2);
        Button button5 = view.findViewById(R.id.button5);
        Button button6 = view.findViewById(R.id.button6);

        View.OnClickListener replaceWithDashboard = v -> {
            FragmentTransaction transaction = requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction();
            transaction.replace(R.id.fragment_container, new DashboardFragment());
            transaction.addToBackStack(null); // optional: allows "Back" to go to Home
            transaction.commit();
        };

        button2.setOnClickListener(replaceWithDashboard);
        button5.setOnClickListener(replaceWithDashboard);
        button6.setOnClickListener(replaceWithDashboard);
    }
}
