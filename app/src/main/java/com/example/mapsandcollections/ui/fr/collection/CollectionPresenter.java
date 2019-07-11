package com.example.mapsandcollections.ui.fr.collection;

import android.text.TextUtils;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.ITaskerListener;
import com.example.mapsandcollections.dto.IItemTaskModel;
import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

public class CollectionPresenter implements CollectionContract.IPresenter, ITaskerListener {

    private final CollectionContract.IView view;

    private final ITasker tasker;
    private final IItemTaskModel taskModel;

    public CollectionPresenter(CollectionContract.IView view, ITasker tasker, IItemTaskModel taskModel) {
        this.view = view;
        this.tasker = tasker;
        this.taskModel = taskModel;
    }

    @Override
    public void onDone(int position) {
        view.updateUI(position);
        System.out.println("onDome: " + position);
    }

    @Override
    public void calculate(String elements, String threads) {
        if (!TextUtils.isDigitsOnly(elements) || !TextUtils.isDigitsOnly(threads) || TextUtils.isEmpty(elements) || TextUtils.isEmpty(threads) || "0".contentEquals(elements) || "0".contentEquals(threads))
            return;
        view.setShowProgressBar();
        tasker.launchTasks(taskModel, elements, threads, this);

    }

    @Override
    public List<ItemTask> getItemTasks() {
        return taskModel.getItemTasks();
    }


}
