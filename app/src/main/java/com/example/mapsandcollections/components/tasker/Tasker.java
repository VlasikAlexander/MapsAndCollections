package com.example.mapsandcollections.components.tasker;


import com.example.mapsandcollections.dto.IItemTaskModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Tasker implements ITasker {

    @Override
    public void launchTasks(IItemTaskModel taskModel, String elements, final String threads, ITaskerListener listener) {

        final ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(threads));
        final ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        singleExecutor.execute(() -> {

            taskModel.createCollections(elements);
            taskModel.setListener(listener);
            taskModel.getTasks();

            try {
                executor.invokeAll(taskModel.getTasks());
            } catch (InterruptedException e) {
                e.printStackTrace();
                executor.shutdown();
            }
        });
    }
}
