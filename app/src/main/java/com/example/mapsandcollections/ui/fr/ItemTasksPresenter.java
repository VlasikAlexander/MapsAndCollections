package com.example.mapsandcollections.ui.fr;

import android.text.TextUtils;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.item.IItemModel;
import com.example.mapsandcollections.dto.item.ItemModelFactory;
import com.example.mapsandcollections.dto.item.ItemTask;

import java.util.List;

import static com.example.mapsandcollections.ui.MyFragmentAdapter.COLLECTION;

public class ItemTasksPresenter implements ItemTasksContract.IPresenter, Tasker.OnTaskDoneListener {

    private final ITasker tasker;
    private final ItemTasksContract.IView view;
    private final ItemModelFactory itemModelFactory;
    private IItemModel taskModel;
    private String type;

    public ItemTasksPresenter(ItemTasksContract.IView view, ITasker tasker, ItemModelFactory itemModelFactory) {
        this.view = view;
        this.tasker = tasker;
        this.itemModelFactory = itemModelFactory;
    }

    @Override
    public void calculate(String type, String elements, String threads) {
        // I use EditText with inputType = number. So I do not need to check isDigitOnly, but still have to check the case when user types 0 or a few zeros.
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
        final ItemTask itemTask = taskModel.getItems().get(position);
        itemTask.setShowProgressBar(false);
        itemTask.setResult(time);
        view.updateUI(position);

        // is this better than it was ?
//        taskModel.getItems().get(position).setShowProgressBar(false);
//        taskModel.getItems().get(position).setResult(time);
//        view.updateUI(position);
    }

    @Override
    public List<ItemTask> getItemTasks() {
        taskModel = itemModelFactory.getItemModel(type);
        return taskModel.getItems();
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getSpanCount(String type) {
       return taskModel.getCountSpan();
    }
}
