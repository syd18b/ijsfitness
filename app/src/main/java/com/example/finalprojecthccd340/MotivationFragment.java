package com.example.finalprojecthccd340;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;

public class MotivationFragment extends Fragment {

  private TextView quoteText;

  private String[] quotes = {
    "You haven’t logged a workout yet today, you got it!",
    "Progress is progress, no matter how small.",
    "Push yourself, because no one else is going to do it for you."
  };

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_motivation, container, false);

    quoteText = root.findViewById(R.id.tvQuote);
    Button quoteBtn = root.findViewById(R.id.btnNewQuote);

    quoteBtn.setOnClickListener(v -> {
      int index = new Random().nextInt(quotes.length);
      quoteText.setText(quotes[index]);
    });

    return root;
  }
}
