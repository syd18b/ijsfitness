package com.example.finalprojecthccd340.ui.stretchplan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;

import java.util.ArrayList;

public class StretchPlanFragment extends Fragment {

  private RecyclerView stretchOptionsRecyclerView;

  // A list of body parts for stretching
  private ArrayList<String> stretchOptions;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_stretch_plan, container, false);

    // Initialize the RecyclerView
    stretchOptionsRecyclerView = root.findViewById(R.id.stretchOptionsRecyclerView);

    // Initialize the list of stretch options (body parts)
    stretchOptions = new ArrayList<>();
    stretchOptions.add("Legs");
    stretchOptions.add("Chest");
    stretchOptions.add("Back");
    stretchOptions.add("Biceps");
    stretchOptions.add("Shoulders");
    stretchOptions.add("Triceps");

    // Set up the RecyclerView with a LinearLayoutManager
    stretchOptionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    // Set the adapter to the RecyclerView
    StretchOptionsAdapter adapter = new StretchOptionsAdapter(stretchOptions, getContext());
    stretchOptionsRecyclerView.setAdapter(adapter);

    return root;
  }
}
