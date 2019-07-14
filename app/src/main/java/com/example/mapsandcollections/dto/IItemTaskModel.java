package com.example.mapsandcollections.dto;

import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.List;
import java.util.concurrent.Callable;

public interface IItemTaskModel {

   List<ItemTask> getItemTasks();

   List<Callable<Double>> getTasks(String elements, Tasker.OnTaskDoneListener listener);

}
