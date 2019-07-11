package com.example.mapsandcollections.components.tasker;

import java.util.List;

public interface ITaskerListener {

     void onResult(List<Double> list);

     void onDone(int position);

     void onDone(double v, String cowAddBegin);
}
