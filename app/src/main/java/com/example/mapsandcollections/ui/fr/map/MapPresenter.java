package com.example.mapsandcollections.ui.fr.map;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.ITaskerListener;
import com.example.mapsandcollections.dto.IItemTaskModel;

import java.util.List;

public class MapPresenter implements MapContract.IPresenter, ITaskerListener {


    private final MapContract.IView view;

    private final ITasker tasker;
    private final IItemTaskModel taskModel;

    public MapPresenter(MapContract.IView view, ITasker tasker, IItemTaskModel taskModel ) {
        this.view = view;
        this.tasker =  tasker;
        this.taskModel =  taskModel;
    }


    @Override
    public void calculate(String elements, String threads) {
        tasker.launchTasks(taskModel, elements, threads, this);
    }

    @Override
    public void onDone(int position) {
    }

}
