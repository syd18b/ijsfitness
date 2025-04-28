package com.example.finalprojecthccd340.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Arrays;
import java.util.List;

public class BodyPartSelectFragment extends Fragment implements OnBodyPartClickListener {

  private RecyclerView recyclerView;
  private BodyPartAdapter adapter;
  private String type; // "workout" or "stretch"

  public BodyPartSelectFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_body_part_select, container, false);

    recyclerView = view.findViewById(R.id.recycler_view_body_parts);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    List<String> bodyParts = Arrays.asList(
      "Arms",
      "Chest",
      "Core",
      "Legs",
      "Back",
      "Shoulders"
    );

    adapter = new BodyPartAdapter(bodyParts, this);
    recyclerView.setAdapter(adapter);

    if (getArguments() != null) {
      type = getArguments().getString("type");
    }

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    MaterialToolbar toolbar = requireActivity().findViewById(R.id.topAppBar);
    if (toolbar != null) {
      toolbar.setNavigationIcon(android.R.drawable.ic_media_previous);
      toolbar.setNavigationOnClickListener(v -> {
        Navigation.findNavController(requireView()).navigateUp();
      });
    }
  }

  @Override
  public void onBodyPartClick(String bodyPart) {
    Bundle bundle = new Bundle();
    bundle.putString("bodyPart", bodyPart);

    if ("workout".equals(type)) {
      Navigation.findNavController(requireView()).navigate(R.id.suggestedWorkoutFragment, bundle);
    } else if ("stretch".equals(type)) {
      Navigation.findNavController(requireView()).navigate(R.id.stretchPlanFragment, bundle);
    } else {
      Toast.makeText(getContext(), "Unknown type selected", Toast.LENGTH_SHORT).show();
    }
  }
}
