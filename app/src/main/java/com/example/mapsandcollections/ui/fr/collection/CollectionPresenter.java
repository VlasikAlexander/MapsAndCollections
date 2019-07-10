package com.example.mapsandcollections.ui.fr.collection;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.List;

public class CollectionPresenter implements CollectionContract.IPresenter, ITaskerListener {

    final private CollectionContract.IView view;
    private static final String MAPS = "MAPS";
    private final ITasker tasker;

    public CollectionPresenter(CollectionContract.IView view, ITasker tasker) {
        this.view = view;
        this.tasker = tasker;
        tasker.setListener(this);
    }

    @Override
    public void calculate(String threads, String elements) {
        tasker.launchTasks(MAPS, threads, elements);
    }

    @Override
    public void onResult(List<Double> list) {
        view.updateUI(list);
    }

    @Override
    public void onDone(double time, String task) {
        view.updateOneWidget(time, task);
    }


}
