package com.example.mapsandcollections.components.tasker;


import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Tasker implements ITasker {

    private final TasksModel taskModel;
    private ExecutorService singleExecutor;
    private ExecutorService executor;
    private final Handler handler;
    private ITaskerListener listener;


    public Tasker(TasksModel taskModel) {
        this.taskModel = taskModel;
        this.handler = new Handler(Looper.getMainLooper());


    }

    @Override
    public void launchTasks(final String type, String threads, final String elements) {
        executor = Executors.newFixedThreadPool(Integer.parseInt(threads));
        singleExecutor = Executors.newSingleThreadExecutor();

        singleExecutor.execute(() -> {
            final List<Callable<Double>> task = taskModel.getTasks(type, elements, listener);
            try {
                List<Future<Double>> results  = executor.invokeAll(task);
         //       getResults(results);
            } catch (InterruptedException e) {
                e.printStackTrace();
                executor.shutdown();
            }

        });


    }

    @Override
    public void setListener(ITaskerListener listener) {
        this.listener = listener;
    }

    private void getResults(List<Future<Double>> results) {
        List<Double> time = new ArrayList<>();
        for (Future<Double> ftr : results) {
            try {
                time.add(ftr.get());
                System.out.println("future " + ftr.get());


            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      //  new Handler(Looper.getMainLooper()).post(() -> listener.onResult(time));
    }


}
