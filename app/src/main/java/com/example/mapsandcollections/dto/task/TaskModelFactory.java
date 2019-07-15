package com.example.mapsandcollections.dto.task;

import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.item.IItemModel;


public class TaskModelFactory {

    public static TaskModel  getTaskModel(String type, int size, Tasker.OnTaskDoneListener listener) {
            return IItemModel.MAP.equals(type) ? new MapTaskModel(size, listener) : new ListTaskModel(size, listener);
    }
}
