package com.example.mapsandcollections.components.tasker;

import com.example.mapsandcollections.dto.IItemTaskModel;

public interface ITasker {

    void launchTasks(IItemTaskModel taskModel, String elements, String threads, ITaskerListener listener);
}

