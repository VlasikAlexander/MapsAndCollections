package com.example.mapsandcollections.dto.task;

import java.util.List;
import java.util.concurrent.Callable;

public interface TaskModel {

    List<Callable<Double>> getTasks();
}
