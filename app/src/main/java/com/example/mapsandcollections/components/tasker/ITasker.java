package com.example.mapsandcollections.components.tasker;

public interface ITasker {

    void launchTasks(String type, String elements, String threads, Tasker.OnTaskDoneListener listener);
}

