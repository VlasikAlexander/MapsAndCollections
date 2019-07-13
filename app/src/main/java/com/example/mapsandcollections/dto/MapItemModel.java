package com.example.mapsandcollections.dto;

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

public class MapItemModel implements IItemTaskModel {

    private static final String HASH_MAP = "HashMap";
    private static final String TREE_MAP = "TreeMap";

    private static final String ADD_NEW = "Adding new";
    private static final String REMOVE = "Removing";
    private static final String SEARCH_BY_KEY = "Search by key";


    private final Handler handler;
    private List<ItemTask> itemTaskList;
    private Map<Object, Object> hashMap;
    private Map<Object, Object> treeMap;
    private Tasker.OnTaskDoneListener listener;

    MapItemModel() {
        this.handler = new Handler(Looper.getMainLooper());
        createModel();
    }

    private void createModel() {

        final Random random = new Random();
        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, HASH_MAP, ADD_NEW, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            double start = System.nanoTime();
            hashMap.put(int_key, new Object());
            itemTaskList.get(0).setShowProgressBar(false);
            itemTaskList.get(0).setResult((System.nanoTime() - start) / 1_000_000);
            handler.post(() -> listener.onDone(0));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(1, TREE_MAP, ADD_NEW, () -> {
            double start = System.nanoTime();
            final int int_key = random.nextInt(getSize(TREE_MAP));
            treeMap.put(int_key, new Object());
            itemTaskList.get(1).setShowProgressBar(false);
            itemTaskList.get(1).setResult((System.nanoTime() - start) / 1_000_000);
            handler.post(() -> listener.onDone(1));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(2, HASH_MAP, REMOVE, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            hashMap.put(int_key, new Object());
            double start = System.nanoTime();
            hashMap.remove(int_key);
            itemTaskList.get(2).setShowProgressBar(false);
            itemTaskList.get(2).setResult((System.nanoTime() - start) / 1_000_000);
            handler.post(() -> listener.onDone(2));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(3, TREE_MAP, REMOVE, () -> {
            final int int_key = random.nextInt(getSize(TREE_MAP));
            treeMap.put(int_key, new Object());
            double start = System.nanoTime();
            treeMap.remove(int_key);
            itemTaskList.get(3).setShowProgressBar(false);
            itemTaskList.get(3).setResult((System.nanoTime() - start) / 1_000_000);
            handler.post(() -> listener.onDone(3));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(4, HASH_MAP, SEARCH_BY_KEY, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            double start = System.nanoTime();
            for (HashMap.Entry<Object, Object> it : treeMap.entrySet()) {
                if ((int) it.getKey() == int_key) {
                    itemTaskList.get(4).setShowProgressBar(false);
                    itemTaskList.get(4).setResult((System.nanoTime() - start) / 1_000_000);
                    handler.post(() -> listener.onDone(4));
                }
            }
            return -1D;
        }));

        itemTaskList.add(new ItemTask(5, TREE_MAP, SEARCH_BY_KEY, () -> {
            final int int_key = random.nextInt(getSize(TREE_MAP));
            double start = System.nanoTime();
            for (TreeMap.Entry<Object, Object> it : treeMap.entrySet()) {
                if ((int) it.getKey() == int_key) {
                    itemTaskList.get(5).setShowProgressBar(false);
                    itemTaskList.get(5).setResult((System.nanoTime() - start) / 1_000_000);
                    handler.post(() -> listener.onDone(5));
                }
            }
            return -1D;
        }));

    }

    @Override
    public List<ItemTask> getItemTasks() {
        return itemTaskList;
    }

    @Override
    public void setListener(Tasker.OnTaskDoneListener listener) {
        this.listener = listener;
    }

    @Override
    public List<Callable<Double>> getTasks() {
        final List<Callable<Double>> taskList = new ArrayList<>();
        for (ItemTask itemTask : getItemTasks()) {
            taskList.add(itemTask.getTask());
        }
        return taskList;
    }

    @Override
    public void createCollections(String elements) {
        hashMap = getHashMap(elements);
        treeMap = getTreeMap(elements);
    }

    private Map<Object, Object> getTreeMap(String elements) {
        return generateTreeMap(new TreeMap<>(), elements);
    }

    private Map<Object, Object> getHashMap(String elements) {
        return generateMap(new HashMap<>(), elements);
    }

    private Map<Object, Object> generateMap(Map<Object, Object> map, String elements) {
        final int amount = Integer.parseInt(elements);
        for (int i = 0; i < amount; i++) {
            map.put(new Object(), new Object());
        }
        return map;
    }

    private TreeMap<Object, Object> generateTreeMap(TreeMap<Object, Object> map, String elements) {

        final int amount = Integer.parseInt(elements);
        for (int i = 0; i < amount; i++) {
            map.put(i, i);
        }
        return map;
    }

    private int getSize(String type) {
        switch (type) {
            case HASH_MAP:
                return hashMap.size();
            case TREE_MAP:
                return treeMap.size();
        }
        return 0;
    }
}
