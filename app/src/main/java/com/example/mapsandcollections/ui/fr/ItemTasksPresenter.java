package com.example.mapsandcollections.ui.fr;

import android.text.TextUtils;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.IItemTaskModel;
import com.example.mapsandcollections.dto.ItemModelFactory;
import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

import static com.example.mapsandcollections.ui.MyFragmentAdapter.COLLECTION;

public class ItemTasksPresenter implements ItemTasksContract.IPresenter, Tasker.OnTaskDoneListener {

    private final ITasker tasker;
    private final ItemTasksContract.IView view;
    private final ItemModelFactory itemModelFactory;
    private IItemTaskModel taskModel;
    private String type;

    public ItemTasksPresenter(ItemTasksContract.IView view, ITasker tasker, ItemModelFactory itemModelFactory) {
        this.view = view;
        this.tasker = tasker;
        this.itemModelFactory = itemModelFactory;
    }

    @Override
    public void calculate(String type, String elements, String threads) {
        if (TextUtils.isEmpty(elements) || TextUtils.isEmpty(threads) ||
                Integer.parseInt(elements) <= 0 || Integer.parseInt(elements) <= 0) {
            view.showError();
            return;
        }
        view.setShowProgressBar();
        tasker.launchTasks(type, elements, threads, this);
    }

    @Override
    public  void onDone(int position, double time) {
        taskModel.getItemTasks().get(position).setShowProgressBar(false);
        taskModel.getItemTasks().get(position).setResult(time);
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

    @Override
    public int getSpanCount(String type) {
        if (COLLECTION.equals(type)) return 3;
        else return 2;
    }
}
