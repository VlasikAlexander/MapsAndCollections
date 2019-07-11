package com.example.mapsandcollections.dto;

import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.List;
import java.util.concurrent.Callable;

public interface IItemTaskModel {

   List<ItemTask> getItemTasks();

   void setListener(ITaskerListener listener);

   List<Callable<Double>> getTasks();

   void createCollections(String elements);
}
