package com.example.finalprojecthccd340.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.R;

import java.util.List;

public class BodyPartAdapter extends RecyclerView.Adapter<BodyPartAdapter.BodyPartViewHolder> {

  private List<String> bodyParts;
  private OnBodyPartClickListener listener;

  public BodyPartAdapter(List<String> bodyParts, OnBodyPartClickListener listener) {
    this.bodyParts = bodyParts;
    this.listener = listener;
  }

  @NonNull
  @Override
  public BodyPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_body_part, parent, false);
    return new BodyPartViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull BodyPartViewHolder holder, int position) {
    String bodyPart = bodyParts.get(position);
    holder.bodyPartText.setText(bodyPart);
    holder.itemView.setOnClickListener(v -> listener.onBodyPartClick(bodyPart));
  }

  @Override
  public int getItemCount() {
    return bodyParts.size();
  }

  static class BodyPartViewHolder extends RecyclerView.ViewHolder {
    TextView bodyPartText;

    public BodyPartViewHolder(@NonNull View itemView) {
      super(itemView);
      bodyPartText = itemView.findViewById(R.id.text_body_part);
    }
  }
}
