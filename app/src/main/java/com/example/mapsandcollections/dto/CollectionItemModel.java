package com.example.mapsandcollections.dto;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.tasker.Tasker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionItemModel implements IItemTaskModel {


    private String ARRAY_LIST;
    private String LINKED_LIST;
    private String COW_LIST;

    private String ADD_START;
    private String ADD_MIDDLE;
    private String ADD_END;
    private String REMOVE_START;
    private String REMOVE_MIDDLE;
    private String REMOVE_END;
    private String SEARCH_BY_VALUE;

    private final Handler handler;
    private final Context context;
    private List<Object> arrayList;
    private List<Object> linkedList;
    private List<Object> copyOnWriteArrayList;
    private Tasker.OnTaskDoneListener listener;
    private List<ItemTask> itemTaskList;


    CollectionItemModel(Context context) {
        this.context = context;
        handler = new Handler(Looper.getMainLooper());
        initStrings();
        createModel();
    }

    private void initStrings() {
        ARRAY_LIST = context.getString(R.string.array_list);
        LINKED_LIST = context.getString(R.string.linked_list);
        COW_LIST = context.getString(R.string.cow_list);
        ADD_START = context.getString(R.string.add_start);
        ADD_MIDDLE = context.getString(R.string.add_middle);
        ADD_END = context.getString(R.string.add_end);
        REMOVE_START = context.getString(R.string.remove_start);
        REMOVE_MIDDLE = context.getString(R.string.remove_middle);
        REMOVE_END = context.getString(R.string.remove_end);
        SEARCH_BY_VALUE = context.getString(R.string.serch_by_value);

    }


    @Override
    public List<ItemTask> getItemTasks() {
        return itemTaskList;
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

    private void createModel() {

        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, ARRAY_LIST, ADD_START, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).add(0, new Object());
            handler.post(() -> listener.onDone(0, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(1, LINKED_LIST, ADD_START, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).add(0, new Object());
            handler.post(() -> listener.onDone(1, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(2, COW_LIST, ADD_START, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).add(0, new Object());
            handler.post(() -> listener.onDone(2, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(3, ARRAY_LIST, ADD_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).add(getSize(ARRAY_LIST) / 2, new Object());
            handler.post(() -> listener.onDone(3, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(4, LINKED_LIST, ADD_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).add(getSize(LINKED_LIST) / 2, new Object());
            handler.post(() -> listener.onDone(4, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(5, COW_LIST, ADD_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).add(getSize(COW_LIST) / 2, new Object());
            handler.post(() -> listener.onDone(5, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(6, ARRAY_LIST, ADD_END, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).add(getSize(ARRAY_LIST), new Object());
            handler.post(() -> listener.onDone(6, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(7, LINKED_LIST, ADD_END, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).add(getSize(LINKED_LIST), new Object());
            handler.post(() -> listener.onDone(7, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(8, COW_LIST, ADD_END, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).add(getSize(COW_LIST), new Object());
            handler.post(() -> listener.onDone(8, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(9, ARRAY_LIST, REMOVE_START, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).remove(0);
            handler.post(() -> listener.onDone(9, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(10, LINKED_LIST, REMOVE_START, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).remove(0);
            handler.post(() -> listener.onDone(10, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(11, COW_LIST, REMOVE_START, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).remove(0);
            handler.post(() -> listener.onDone(11, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(12, ARRAY_LIST, REMOVE_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).remove(getSize(ARRAY_LIST) / 2);
            handler.post(() -> listener.onDone(12, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(13, LINKED_LIST, REMOVE_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).remove(getSize(LINKED_LIST) / 2);
            handler.post(() -> listener.onDone(13, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(14, COW_LIST, REMOVE_MIDDLE, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).remove(getSize(COW_LIST) / 2);
            handler.post(() -> listener.onDone(14, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(15, ARRAY_LIST, REMOVE_END, () -> {
            double start = System.nanoTime();
            getList(ARRAY_LIST).remove(getSize(ARRAY_LIST) - 1);
            handler.post(() -> listener.onDone(15, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(16, LINKED_LIST, REMOVE_END, () -> {
            double start = System.nanoTime();
            getList(LINKED_LIST).remove(linkedList.size() - 1);
            handler.post(() -> listener.onDone(16, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));
        itemTaskList.add(new ItemTask(17, COW_LIST, REMOVE_END, () -> {
            double start = System.nanoTime();
            getList(COW_LIST).remove(copyOnWriteArrayList.size() - 1);
            handler.post(() -> listener.onDone(17, (System.nanoTime() - start) / 1_000_000));
            return -1D;
        }));

        itemTaskList.add(new ItemTask(18, ARRAY_LIST, SEARCH_BY_VALUE, () -> {
            final Random random = new Random();
            final Object suspect = getList(ARRAY_LIST).get(random.nextInt(getSize(ARRAY_LIST)));
            double start = System.nanoTime();
            for (Object o : getList(ARRAY_LIST)) {
                if (suspect.equals(o)) {
                    handler.post(() -> listener.onDone(18, (System.nanoTime() - start) / 1_000_000));
                    return -1D;
                }
            }
            return -1D;
        }));
        itemTaskList.add(new ItemTask(19, LINKED_LIST, SEARCH_BY_VALUE, () -> {
            final Random random = new Random();
            final Object suspect = getList(LINKED_LIST).get(random.nextInt(getSize(LINKED_LIST)));
            double start = System.nanoTime();
            for (Object o : getList(LINKED_LIST)) {
                if (suspect.equals(o)) {
                    handler.post(() -> listener.onDone(19, (System.nanoTime() - start) / 1_000_000));
                    return -1D;
                }
            }
            return -1D;
        }));
        itemTaskList.add(new ItemTask(20, COW_LIST, SEARCH_BY_VALUE, () -> {
            final Random random = new Random();
            final Object suspect = getList(COW_LIST).get(random.nextInt(getSize(COW_LIST)));
            double start = System.nanoTime();
            for (Object o : getList(COW_LIST)) {
                if (suspect.equals(o)) {
                    handler.post(() -> listener.onDone(20, (System.nanoTime() - start) / 1_000_000));
                    return -1D;
                }
            }
            return -1D;
        }));
    }


    private int getSize(String type) {
        if (ARRAY_LIST.equals(type)) return arrayList.size();
        if (LINKED_LIST.equals(type)) return linkedList.size();
        if (COW_LIST.equals(type)) return copyOnWriteArrayList.size();
        return 0;
    }

    private void setListener(Tasker.OnTaskDoneListener listener) {
        this.listener = listener;
    }

    private void createCollections(String elements) {
        arrayList = createArrayList(elements);
        linkedList = createLinkedList(elements);
        copyOnWriteArrayList = createCopyOnWriteList(elements);
    }

    private List<Object> getList(String type) {
        if (ARRAY_LIST.equals(type)) return arrayList;
        if (LINKED_LIST.equals(type)) return linkedList;
        if (COW_LIST.equals(type)) return copyOnWriteArrayList;
        return new ArrayList<>();
    }

    private List<Object> createCopyOnWriteList(String elements) {
        return generateList(new CopyOnWriteArrayList<>(), elements);
    }

    private List<Object> createLinkedList(String elements) {
        return generateList(new LinkedList<>(), elements);
    }

    private List<Object> createArrayList(String elements) {
        return generateList(new ArrayList<>(), elements);
    }

    private List<Object> generateList(List<Object> list, String elements) {
        final int amount = Integer.parseInt(elements);
        for (int i = 0; i < amount; i++) {
            list.add(new Object());
        }
        return list;
    }
}




