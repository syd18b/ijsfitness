package com.example.finalprojecthccd340.ui.stretchplan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;

import java.util.ArrayList;

public class StretchOptionsAdapter extends RecyclerView.Adapter<StretchOptionsAdapter.ViewHolder> {

  private ArrayList<String> stretchOptions;
  private Context context;

  public StretchOptionsAdapter(ArrayList<String> stretchOptions, Context context) {
    this.stretchOptions = stretchOptions;
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_stretch_option, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String bodyPart = stretchOptions.get(position);
    holder.bodyPartTextView.setText(bodyPart);

    // Handle click to show the stretch ideas for the selected body part
    holder.itemView.setOnClickListener(v -> {
      // You can either use a dialog or open a new activity/fragment with specific stretches for this body part
      Intent intent = new Intent(context, StretchDetailsActivity.class);
      intent.putExtra("BODY_PART", bodyPart);  // Pass the body part as extra
      context.startActivity(intent);
    });
  }

  @Override
  public int getItemCount() {
    return stretchOptions.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView bodyPartTextView;

    public ViewHolder(View itemView) {
      super(itemView);
      bodyPartTextView = itemView.findViewById(R.id.bodyPartTextView);
    }
  }
}
