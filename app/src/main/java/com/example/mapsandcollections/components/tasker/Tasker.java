package com.example.mapsandcollections.components.tasker;


import com.example.mapsandcollections.dto.IItemTaskModel;
import com.example.mapsandcollections.dto.ItemModelFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Tasker implements ITasker {

    private final ItemModelFactory itemModelFactory;

    public Tasker(ItemModelFactory itemModelFactory) {
        this.itemModelFactory = itemModelFactory;
    }

    public interface OnTaskDoneListener {

        void onDone(int position, double time);
    }

    @Override
    public void launchTasks(String type, String elements, final String threads, Tasker.OnTaskDoneListener listener) {
        final IItemTaskModel taskModel = itemModelFactory.getItemModel(type);
        final ExecutorService mainExecutor = Executors.newFixedThreadPool(Integer.parseInt(threads));
        final ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        singleExecutor.execute(() -> {

            try {
                mainExecutor.invokeAll(taskModel.getTasks(elements, listener));
            } catch (InterruptedException e) {
                e.printStackTrace();
                mainExecutor.shutdown();
            }
        });
        singleExecutor.shutdown();
    }

}
