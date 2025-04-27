package com.example.finalprojecthccd340;

public class Workout {
  private String exercise;
  private String weight;
  private String reps;
  private String steps;

  public Workout(String exercise, String weight, String reps, String steps) {
    this.exercise = exercise;
    this.weight = weight;
    this.reps = reps;
    this.steps = steps;
  }

  public String getExercise() {
    return exercise;
  }

  public String getWeight() {
    return weight;
  }

  public String getReps() {
    return reps;
  }

  public String getSteps() {
    return steps;
  }
}
