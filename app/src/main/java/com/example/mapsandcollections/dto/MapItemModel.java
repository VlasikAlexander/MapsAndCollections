package com.example.mapsandcollections.dto;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.Callable;

public class MapItemModel implements IItemTaskModel {

    private String HASH_MAP;
    private String TREE_MAP;

    private String ADD_NEW;
    private String REMOVE;
    private String SEARCH_BY_KEY;

    private final Handler handler;
    private final Context context;
    private List<ItemTask> itemTaskList;
    private Map<Object, Object> hashMap;
    private Map<Object, Object> treeMap;
    private Tasker.OnTaskDoneListener listener;

    MapItemModel(Context context) {
        this.handler = new Handler(Looper.getMainLooper());
        this.context = context;
        initStrings();
        createModel();
    }

    private void initStrings() {
        HASH_MAP = context.getString(R.string.hash_map);
        TREE_MAP = context.getString(R.string.tree_map);

        ADD_NEW = context.getString(R.string.add_new);
        REMOVE = context.getString(R.string.remove);
        SEARCH_BY_KEY = context.getString(R.string.search_by_key);
    }

    private void createModel() {

        final Random random = new Random();
        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, HASH_MAP, ADD_NEW, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            double start = System.nanoTime();
            hashMap.put(int_key, new Object());
            handler.post(() -> listener.onDone(0, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(1, TREE_MAP, ADD_NEW, () -> {
            double start = System.nanoTime();
            final int int_key = random.nextInt(getSize(TREE_MAP));
            treeMap.put(int_key, new Object());
            handler.post(() -> listener.onDone(1, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(2, HASH_MAP, REMOVE, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            hashMap.put(int_key, new Object());
            double start = System.nanoTime();
            hashMap.remove(int_key);
            handler.post(() -> listener.onDone(2, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(3, TREE_MAP, REMOVE, () -> {
            final int int_key = random.nextInt(getSize(TREE_MAP));
            double start = System.nanoTime();
            treeMap.remove(int_key);
            handler.post(() -> listener.onDone(3, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(4, HASH_MAP, SEARCH_BY_KEY, () -> {
            final int int_key = random.nextInt(getSize(HASH_MAP));
            double start = System.nanoTime();
            for (HashMap.Entry<Object, Object> it : hashMap.entrySet()) {
                if ((int) it.getKey() == int_key) {
                    handler.post(() -> listener.onDone(4, (System.nanoTime() - start) / 1_000_000));
                }
            }
            return -1D;
        }));

        itemTaskList.add(new ItemTask(5, TREE_MAP, SEARCH_BY_KEY, () -> {
            final int int_key = random.nextInt(getSize(TREE_MAP));
            double start = System.nanoTime();
            for (TreeMap.Entry<Object, Object> it : treeMap.entrySet()) {
                if ((int) it.getKey() == int_key) {
                    handler.post(() -> listener.onDone(5, (System.nanoTime() - start) / 1_000_000));
                }
            }
            return -1D;
        }));

    }

    @Override
    public List<ItemTask> getItemTasks() {
        return itemTaskList;
    }

   private void setListener(Tasker.OnTaskDoneListener listener) {
        this.listener = listener;
    }

    @Override
    public List<Callable<Double>> getTasks(String elements, Tasker.OnTaskDoneListener listener) {
        setListener(listener);
        createCollections(elements);
        final List<Callable<Double>> taskList = new ArrayList<>();
        for (ItemTask itemTask : getItemTasks()) {
            taskList.add(itemTask.getTask());
        }
        return taskList;
    }

    private void createCollections(String elements) {
        hashMap = getHashMap(elements);
        treeMap = getTreeMap(elements);
    }

    private Map<Object, Object> getTreeMap(String elements) {
        return generateTreeMap(new TreeMap<>(), elements);
    }

    private Map<Object, Object> getHashMap(String elements) {
        return generateHashMap(new HashMap<>(), elements);
    }

    private Map<Object, Object> generateHashMap(Map<Object, Object> map, String elements) {
        final int amount = Integer.parseInt(elements);
        for (int i = 0; i < amount; i++) {
            map.put(i, new Object());
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
       if (HASH_MAP.equals(type)) return hashMap.size();
       if (TREE_MAP.equals(type)) return treeMap.size();
        return 0;
    }
}
