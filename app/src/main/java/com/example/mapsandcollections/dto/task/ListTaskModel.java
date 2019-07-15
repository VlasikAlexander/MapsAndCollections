package com.example.mapsandcollections.dto.task;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;


public class ListTaskModel implements TaskModel {


    private  List<Object> arrayList;
    private  List<Object> linkedList;
    private  List<Object> copyOnWriteList;
    private final Tasker.OnTaskDoneListener listener;
    private final int size;
    private final Handler handler;


     ListTaskModel(int size, Tasker.OnTaskDoneListener listener) {
        this.size = size;
        this.listener = listener;
        this.handler = new Handler(Looper.getMainLooper());
        initializeCollections();
    }

    private void initializeCollections() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        copyOnWriteList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(new Object());
            linkedList.add(new Object());
            copyOnWriteList.add(new Object());
        }
    }

    @Override
    public List<Callable<Double>> getTasks() {
        final List<Callable<Double>> taskModel = new ArrayList<>();

        taskModel.add(addStartTask(arrayList, 0));
        taskModel.add(addStartTask(linkedList, 1));
        taskModel.add(addStartTask(copyOnWriteList, 2));

        taskModel.add(addMiddleTask(arrayList, 3));
        taskModel.add(addMiddleTask(linkedList, 4));
        taskModel.add(addMiddleTask(copyOnWriteList, 5));

        taskModel.add(addEndTask(arrayList, 6));
        taskModel.add(addEndTask(linkedList, 7));
        taskModel.add(addEndTask(copyOnWriteList, 8));

        taskModel.add(removeStartTask(arrayList, 9));
        taskModel.add(removeStartTask(linkedList, 10));
        taskModel.add(removeStartTask(copyOnWriteList, 11));

        taskModel.add(removeMiddleTask(arrayList, 12));
        taskModel.add(removeMiddleTask(linkedList, 13));
        taskModel.add(removeMiddleTask(copyOnWriteList, 14));

        taskModel.add(removeEndTask(arrayList, 15));
        taskModel.add(removeEndTask(linkedList, 16));
        taskModel.add(removeEndTask(copyOnWriteList, 17));

        taskModel.add(searchByValueTask(arrayList, 18));
        taskModel.add(searchByValueTask(linkedList, 19));
        taskModel.add(searchByValueTask(copyOnWriteList, 20));


        return taskModel;
    }


    private Callable<Double> addStartTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.add(0, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> addMiddleTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.add(list.size() / 2, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> addEndTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.add(list.size() - 1, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeStartTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.remove(0);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeMiddleTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.remove(list.size() / 2);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeEndTask(List<Object> list, int position) {
        return () -> {
            double start = System.nanoTime();
            list.remove(list.size() - 1);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> searchByValueTask(List<Object> list, int position) {
         final Random random = new Random();
         final Object  randomValue = list.get(random.nextInt(list.size()));
        return () -> {
            double start = System.nanoTime();
            for (Object value : list) {
                if (value.equals(randomValue))
                    handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            }
            return -1D;
        };
    }

}
