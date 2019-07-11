package com.example.mapsandcollections.ui.fr.map;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.List;

public class MapPresenter implements MapContract.IPresenter, ITaskerListener {

    public static final String MAPS = "MAPS";
    private final MapContract.IView view;

    private final ITasker tasker;

    public MapPresenter(MapContract.IView view, ITasker tasker ) {
        this.view = view;
        this.tasker =  tasker;
        tasker.setListener(this);
    }


    @Override
    public void calculate(String threads, String elements) {

        tasker.launchTasks(MAPS, threads, elements);

    }

    @Override
    public void  onResult(List<Double> list) {
        view.updateUI(list);
    }

    @Override
    public void onDone(int position) {

    }

    @Override
    public void onDone(double v, String cowAddBegin) {

    }


}
