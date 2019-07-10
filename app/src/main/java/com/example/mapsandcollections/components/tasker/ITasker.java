package com.example.mapsandcollections.components.tasker;

public interface ITasker {


    void launchTasks(String type, String threads, String elements);

    void setListener(ITaskerListener listener);

}

