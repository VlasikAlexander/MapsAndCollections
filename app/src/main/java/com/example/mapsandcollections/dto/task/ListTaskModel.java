package com.example.mapsandcollections.dto.task;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;


public class ListTaskModel implements TaskModel {


    private List<Object> arrayList;
    private List<Object> linkedList;
    private List<Object> copyOnWriteList;
    private final Tasker.OnTaskDoneListener listener;
    private final int size;
    private final Handler handler;


    ListTaskModel(int size, Tasker.OnTaskDoneListener listener) {
        this.size = size;
        this.listener = listener;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public List<Callable<Double>> getTasks() {
        final List<Callable<Double>> taskModel = new ArrayList<>();

        taskModel.add(addStartTask(getArrayList(), 0));
        taskModel.add(addStartTask(getLinkedList(), 1));
        taskModel.add(addStartTask(getCopyOnWriteList(), 2));

        taskModel.add(addMiddleTask(getArrayList(), 3));
        taskModel.add(addMiddleTask(getLinkedList(), 4));
        taskModel.add(addMiddleTask(getCopyOnWriteList(), 5));

        taskModel.add(addEndTask(getArrayList(), 6));
        taskModel.add(addEndTask(getLinkedList(), 7));
        taskModel.add(addEndTask(getCopyOnWriteList(), 8));

        taskModel.add(removeStartTask(getArrayList(), 9));
        taskModel.add(removeStartTask(getLinkedList(), 10));
        taskModel.add(removeStartTask(getCopyOnWriteList(), 11));

        taskModel.add(removeMiddleTask(getArrayList(), 12));
        taskModel.add(removeMiddleTask(getLinkedList(), 13));
        taskModel.add(removeMiddleTask(getCopyOnWriteList(), 14));

        taskModel.add(removeEndTask(getArrayList(), 15));
        taskModel.add(removeEndTask(getLinkedList(), 16));
        taskModel.add(removeEndTask(getCopyOnWriteList(), 17));

        taskModel.add(searchByValueTask(getArrayList(), 18));
        taskModel.add(searchByValueTask(getLinkedList(), 19));
        taskModel.add(searchByValueTask(getCopyOnWriteList(), 20));


        return taskModel;
    }

    private Callable<Double> addStartTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.add(0, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> addMiddleTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.add(list.size() / 2, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> addEndTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.add(list.size() - 1, new Object());
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeStartTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.remove(0);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeMiddleTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.remove(list.size() / 2);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> removeEndTask(List<Object> list, int position) {
        return () -> {
            final double start = System.nanoTime();
            list.remove(list.size() - 1);
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }

    private Callable<Double> searchByValueTask(List<Object> list, int position) {
        final Random random = new Random();
        final Object randomValue = list.get(random.nextInt(list.size()));
        return () -> {
            double start = System.nanoTime();
            for (Object value : list) {
                if (value.equals(randomValue))
                    handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            }
            return -1D;
        };
    }


    private List<Object> getArrayList() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++)
            arrayList.add(new Object());
        return arrayList;
    }

    private List<Object> getLinkedList() {
        linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++)
            linkedList.add(new Object());
        return arrayList;
    }

    private List<Object> getCopyOnWriteList() {
        copyOnWriteList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < size; i++)
            copyOnWriteList.add(new Object());
        return arrayList;
    }
}
