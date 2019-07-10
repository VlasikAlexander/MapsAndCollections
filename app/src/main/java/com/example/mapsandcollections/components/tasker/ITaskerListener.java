package com.example.mapsandcollections.components.tasker;

import java.util.List;

public interface ITaskerListener {

     void onResult(List<Double> list);

     void onDone(double time, String task);
}
