package com.example.finalprojecthccd340;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojecthccd340.ui.profile.ProfileFragment;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

  private List<Workout> workoutList;

  public WorkoutAdapter(List<Workout> workoutList) {
    this.workoutList = workoutList;
  }

  @Override
  public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
    return new WorkoutViewHolder(view);
  }

  @Override
  public void onBindViewHolder(WorkoutViewHolder holder, int position) {
    Workout workout = workoutList.get(position);
    holder.exerciseText.setText(workout.getExercise());
    holder.weightText.setText(workout.getWeight());
    holder.repsText.setText(workout.getReps());
    holder.stepsText.setText(workout.getSteps());
  }

  @Override
  public int getItemCount() {
    return workoutList.size();
  }

  public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
    TextView exerciseText, weightText, repsText, stepsText;

    public WorkoutViewHolder(View itemView) {
      super(itemView);
      exerciseText = itemView.findViewById(R.id.exerciseText);
      weightText = itemView.findViewById(R.id.weightText);
      repsText = itemView.findViewById(R.id.repsText);
      stepsText = itemView.findViewById(R.id.stepsText);
    }
  }
}
