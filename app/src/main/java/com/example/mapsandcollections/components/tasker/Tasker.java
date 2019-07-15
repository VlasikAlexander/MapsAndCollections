package com.example.mapsandcollections.components.tasker;


import com.example.mapsandcollections.dto.task.TaskModel;
import com.example.mapsandcollections.dto.task.TaskModelFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Tasker implements ITasker {

    public interface OnTaskDoneListener {

        void onDone(int position, double time);
    }

    @Override
    public void launchTasks(String type, String elements, final String threads, Tasker.OnTaskDoneListener listener) {

        final ExecutorService mainExecutor = Executors.newFixedThreadPool(Integer.parseInt(threads));
        final ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

        singleExecutor.execute(() -> {
            final TaskModel taskModel = TaskModelFactory.getTaskModel(type, Integer.parseInt(elements), listener);
            try {
                mainExecutor.invokeAll(taskModel.getTasks());
            } catch (InterruptedException e) {
                e.printStackTrace();
                mainExecutor.shutdown();
            }
        });
        singleExecutor.shutdown();
    }

}
