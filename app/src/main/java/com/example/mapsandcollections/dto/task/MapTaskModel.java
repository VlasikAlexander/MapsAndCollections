package com.example.mapsandcollections.dto.task;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class MapTaskModel implements TaskModel {

    private final int size;
    private final Tasker.OnTaskDoneListener listener;
    private final Handler handler;
    private Map<Object, Object> hashMap;
    private Map<Object, Object> treeMap;



     MapTaskModel(int size, Tasker.OnTaskDoneListener listener) {
        this.size = size;
        this.listener = listener;
        this.handler = new Handler(Looper.getMainLooper());
        initializeCollections();
    }

    private void initializeCollections() {
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, i);
            treeMap.put(i, i);
        }
    }

    @Override
    public List<Callable<Double>> getTasks() {
        final List<Callable<Double>> taskModel = new ArrayList<>();

        taskModel.add(addingTask(hashMap, 0));
        taskModel.add(addingTask(treeMap, 1));

        taskModel.add(removingTask(hashMap, 2));
        taskModel.add(removingTask(treeMap, 3));

        taskModel.add(searchingByKeyTask(hashMap, 4));
        taskModel.add(searchingByKeyTask(treeMap, 5));

        return taskModel;
    }

    private Callable<Double> searchingByKeyTask(Map<Object, Object> map, int position) {
        return () -> {
            final Random random = new Random();
            final int key = random.nextInt(map.size());
            final double start = System.nanoTime();
            for (Map.Entry<Object, Object> it : map.entrySet()) {
                if ((int) it.getKey() == key)
                    handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            }
            return -1D;
        };
    }

    private Callable<Double> removingTask(Map<Object, Object> map, int position) {
       return () -> {
           final Random random = new Random();
           final double start = System.nanoTime();
           final int key = random.nextInt(map.size());
           map.remove(key);
           handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
           map.put(key, key);
           return -1D;
       };
    }

    private Callable<Double> addingTask(Map<Object, Object> map, int position) {
        return () -> {
            final Random random = new Random();
            final double start = System.nanoTime();
            map.put(random.nextInt(map.size()), random.nextInt(map.size()));
            handler.post(() -> listener.onDone(position, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        };
    }
}
