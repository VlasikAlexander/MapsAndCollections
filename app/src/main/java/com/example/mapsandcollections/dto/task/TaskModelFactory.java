package com.example.mapsandcollections.dto.task;

import com.example.mapsandcollections.components.tasker.Tasker;

import static com.example.mapsandcollections.ui.MyFragmentAdapter.MAP;

public class TaskModelFactory {

    public static TaskModel  getTaskModel(String type, int size, Tasker.OnTaskDoneListener listener) {
            return MAP.equals(type) ? new MapTaskModel(size, listener) : new ListTaskModel(size, listener);
    }
}
