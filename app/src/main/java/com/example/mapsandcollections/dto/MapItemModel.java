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

    private String hash_map;
    private String tree_map;

    private String add_new;
    private String remove;
    private String search_by_key;

    private final Handler handler;
    private final Context context;
    private final Random random;
    private List<ItemTask> itemTaskList;
    private Map<Object, Object> hashMap;
    private Map<Object, Object> treeMap;
    private Tasker.OnTaskDoneListener listener;

    MapItemModel(Context context) {
        this.handler = new Handler(Looper.getMainLooper());
        this.context = context;
        random = new Random();
        initStrings();
        createModel();
    }

    private void initStrings() {
        hash_map = context.getString(R.string.hash_map);
        tree_map = context.getString(R.string.tree_map);

        add_new = context.getString(R.string.add_new);
        remove = context.getString(R.string.remove);
        search_by_key = context.getString(R.string.search_by_key);
    }

    private void createModel() {

        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, hash_map, add_new, () -> {
            setTask(itemTaskList.get(0));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(1, tree_map, add_new, () -> {
           setTask(itemTaskList.get(1));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(2, hash_map, remove, () -> {
            setTask(itemTaskList.get(2));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(3, tree_map, remove, () -> {
            setTask(itemTaskList.get(3));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(4, hash_map, search_by_key, () -> {
            setTask(itemTaskList.get(4));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(5, tree_map, search_by_key, () -> {
            setTask(itemTaskList.get(5));
            return -1D;
        }));
    }

    private void  setTask(ItemTask itemTask) {
        final int int_key = random.nextInt(getSize(itemTask.getType()));
        final double start = System.nanoTime();
        if (add_new.equals(itemTask.getAction())) {
            getMapByType(itemTask.getType()).put(int_key, new Object());
        } else if (remove.equals(itemTask.getAction())) {
            getMapByType(itemTask.getType()).remove(int_key);
        } else {
            for (Map.Entry<Object, Object> it : getMapByType(itemTask.getType()).entrySet()) {
                if ((int) it.getKey() == int_key)
                    break;
            }
        }
        handler.post(() -> listener.onDone(itemTask.getPosition(), (System.nanoTime() - start) / 1_000_000));
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

    private Map<Object, Object> getMapByType(String type) {
        if (hash_map.equals(type)) return hashMap;
        if (tree_map.equals(type)) return treeMap;
        return new HashMap<>();
    }

    private int getSize(String type) {
       if (hash_map.equals(type)) return hashMap.size();
       if (tree_map.equals(type)) return treeMap.size();
        return 0;
    }
}
