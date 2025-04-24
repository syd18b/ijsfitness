package com.example.finalprojecthccd340.ui.stretch;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalprojecthccd340.R;
import java.util.Arrays;
import java.util.List;

public class StretchDetailsActivity extends AppCompatActivity {

  private RecyclerView stretchRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stretch_details);

    stretchRecyclerView = findViewById(R.id.stretchRecyclerView);
    stretchRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    // Example list of stretches
    List<String> stretchOptions = Arrays.asList("Leg Stretch", "Chest Stretch", "Back Stretch", "Shoulder Stretch", "Hamstring Stretch");

    // Set the adapter with the data
    StretchOptionsAdapter adapter = new StretchOptionsAdapter(stretchOptions, this);  // Pass context and List
    stretchRecyclerView.setAdapter(adapter);
  }
}
