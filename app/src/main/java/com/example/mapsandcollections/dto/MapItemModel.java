package com.example.mapsandcollections.dto;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class MapItemModel implements IItemTaskModel {

    private static final String HASH_MAP = "HashMap";
    private static final String TREE_MAP = "TreeMap";

    public static final String ADD_NEW = "Adding new";
    public static final String REMOVE_NEW = "Removing";
    public static final String SEARCH_BY_KEY = "Search by key";


    private final Handler handler;
    private List<ItemTask> itemTaskList;
    private  Map<Object, Object> hashMap;
    private  Map<Object, Object> treeMap;
    private ITaskerListener listener;

    public MapItemModel() {
        this.handler = new Handler(Looper.getMainLooper());
        createModel();
    }

    private void createModel() {

        final List<ItemTask> itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, HASH_MAP, ADD_NEW, () -> {
            double start = System.nanoTime();
           hashMap.put(new Object(), new Object());
           itemTaskList.get(0).setShowProgressBar(false);
           itemTaskList.get(0).setResult((System.nanoTime() - start) / 1_000_000);
           handler.post(() -> listener.onDone(0));
            return -1D;
        }));

    }

    @Override
    public List<ItemTask> getItemTasks() {
        return itemTaskList;
    }

    @Override
    public void setListener(ITaskerListener listener) {
        this.listener = listener;
    }

    @Override
    public List<Callable<Double>> getTasks() {
        return null;
    }

    @Override
    public void createCollections(String elements) {
        hashMap = getHashMap(elements);
        treeMap = getTreeMap(elements);
    }

    private Map<Object, Object> getTreeMap(String elements) {
        return generateMap(new HashMap<>(), elements);
    }

    private Map<Object, Object> getHashMap(String elements) {
        return generateMap(new TreeMap<>() ,elements);
    }

    private Map<Object, Object> generateMap(Map<Object, Object> map, String elements) {
        final int amount = Integer.parseInt(elements);
        for (int i = 0; i < amount; i++) {
            map.put(new Object(), new Object());
        }
        return map;
    }
}
