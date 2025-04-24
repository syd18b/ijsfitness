package com.example.finalprojecthccd340.ui.dashboard;

import android.view.View;
import android.widget.AdapterView;

public class SimpleItemSelectedListener implements AdapterView.OnItemSelectedListener {
  public interface ItemSelectedCallback {
    void onItemSelected(String item);
  }

  private final ItemSelectedCallback callback;

  public SimpleItemSelectedListener(ItemSelectedCallback callback) {
    this.callback = callback;
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String selected = parent.getItemAtPosition(position).toString();
    callback.onItemSelected(selected);
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {
    // Optional: handle nothing selected
  }
}
