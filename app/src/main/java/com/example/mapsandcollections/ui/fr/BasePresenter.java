package com.example.mapsandcollections.ui.fr;

import android.text.TextUtils;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.IItemTaskModel;
import com.example.mapsandcollections.dto.ItemModelFactory;
import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

public class BasePresenter implements BaseContract.IPresenter, Tasker.OnTaskDoneListener {

    private final ITasker tasker;
    private IItemTaskModel taskModel;
    private final ItemModelFactory itemModelFactory;
    private String type;
    private final BaseContract.IView view;

    public BasePresenter(BaseContract.IView view, ITasker tasker, ItemModelFactory itemModelFactory) {
        this.view = view;
        this.tasker = tasker;
        this.itemModelFactory = itemModelFactory;

    }

    @Override
    public void calculate(String type, String elements, String threads) {
        if (TextUtils.isEmpty(elements) ||
                TextUtils.isEmpty(threads) ||
                "0".contentEquals(elements) ||
                "0".contentEquals(threads))
            return;

        view.setShowProgressBar();
        tasker.launchTasks(taskModel, elements, threads, this);
    }

    @Override
    public void onDone(int position) {
        view.updateUI(position);
    }

    @Override
    public List<ItemTask> getItemTasks() {
        taskModel = itemModelFactory.getItemModel(type);
        return taskModel.getItemTasks();
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
