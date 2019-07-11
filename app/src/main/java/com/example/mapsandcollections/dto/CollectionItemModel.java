package com.example.mapsandcollections.dto;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionItemModel implements IItemTaskModel {


    private static final String ARRAY_LIST = "ArrayList";
    private static final String LINKED_LIST = "LinkedList";
    private static final String COW_LIST = "CopyOnWriteList";

    private static final String ADD_START = "Add in the\n beginning";
    private static final String ADD_MIDDLE = "Add in the\n middle";
    private static final String ADD_END = "Add in the\n end";
    private static final String REMOVE_START = "Remove in the\n beginning";
    private static final String REMOVE_MIDDLE = "Remove in the\n middle";
    private static final String REMOVE_END = "Remove in the\n end";
    private static final String SEARCH_BY_VALUE = "Search by\n value";

    private List<Object> arrayList;
    private List<Object> linkedList;
    private List<Object> copyOnWriteArrayList;
    private final Handler handler;
    private ITaskerListener listener;
    private List<ItemTask> itemTaskList;

    public CollectionItemModel() {
        handler = new Handler(Looper.getMainLooper());
        createModel();
    }


    @Override
    public List<ItemTask> getItemTasks() {
        return itemTaskList;
    }

    private void createModel() {

        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(
                0,
                ARRAY_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(0, new Object());
                    itemTaskList.get(0).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(0).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(0));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                1,
                LINKED_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).add(0, new Object());
                    itemTaskList.get(1).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(1).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(1));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                2,
                COW_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).add(0, new Object());
                    itemTaskList.get(2).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(2).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(2));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                3,
                ARRAY_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(3).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(3).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(3));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                4,
                LINKED_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(4).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(4).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(4));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                5,
                COW_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(5).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(5).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(5));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                6,
                ARRAY_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(6).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(6).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(6));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                7,
                LINKED_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(7).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(7).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(7));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                8,
                COW_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(8).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(8).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(8));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                9,
                ARRAY_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(0);
                    itemTaskList.get(9).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(9).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(9));
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                10,
                LINKED_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(0);
                    itemTaskList.get(10).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(10).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(10));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                11,
                COW_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(0);
                    itemTaskList.get(11).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(11).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(11));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                12,
                ARRAY_LIST,
                REMOVE_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(getSize() / 2);
                    itemTaskList.get(12).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(12).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(12));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(13, LINKED_LIST, REMOVE_MIDDLE, () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(getSize() / 2);
                    itemTaskList.get(13).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(13).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(13));
                    return -1D;
                }));
        itemTaskList.add(new ItemTask(14, COW_LIST, REMOVE_MIDDLE, () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(getSize() / 2);
                    itemTaskList.get(14).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(14).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(14));
                    return -1D;
                }));
        itemTaskList.add(new ItemTask(15, ARRAY_LIST, REMOVE_END, () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(getSize() - 1);
                    itemTaskList.get(15).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(15).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(15));
                    return -1D;
                }));
        itemTaskList.add(new ItemTask(16, LINKED_LIST, REMOVE_END, () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(getSize() - 1);
                    itemTaskList.get(16).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(16).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(16));
                    return -1D;
                }));

        itemTaskList.add(new ItemTask(
                17,
                COW_LIST,
                REMOVE_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(getSize() - 1);
                    itemTaskList.get(17).setResult((System.nanoTime() - start) / 1_000_000);
                    itemTaskList.get(17).setShowProgressBar(false);
                    handler.post(() -> listener.onDone(17));
                    return -1D;
                }
        ));

        itemTaskList.add(new ItemTask(
                18,
                ARRAY_LIST,
                SEARCH_BY_VALUE,
                () -> {
                    final Random random = new Random();
                    final Object suspect = getElements(ARRAY_LIST).get(random.nextInt(getSize()));
                    double start = System.nanoTime();
                    for (Object o : getElements(ARRAY_LIST)) {
                        if (suspect == o) {
                            itemTaskList.get(18).setResult((System.nanoTime() - start) / 1_000_000);
                            itemTaskList.get(18).setShowProgressBar(false);
                            handler.post(() -> listener.onDone(18));
                            return -1D;
                        }
                    }
                    return -1D;
                }
        ));
        itemTaskList.add(new ItemTask(
                19,
                LINKED_LIST,
                SEARCH_BY_VALUE,
                () -> {
                    final Random random = new Random();
                    final Object suspect = getElements(LINKED_LIST).get(random.nextInt(getSize()));
                    double start = System.nanoTime();
                    for (Object o : getElements(LINKED_LIST)) {
                        if (suspect == o) {
                            itemTaskList.get(19).setResult((System.nanoTime() - start) / 1_000_000);
                            itemTaskList.get(19).setShowProgressBar(false);
                            handler.post(() -> listener.onDone(19));
                            return -1D;
                        }
                    }
                    return -1D;
                }

        ));
        itemTaskList.add(new ItemTask(
                20,
                COW_LIST,
                SEARCH_BY_VALUE,
                () -> {
                    final Random random = new Random();
                    final Object suspect = getElements(LINKED_LIST).get(random.nextInt(getSize()));
                    double start = System.nanoTime();
                    for (Object o : getElements(LINKED_LIST)) {
                        if (suspect == o) {
                            itemTaskList.get(20).setResult((System.nanoTime() - start) / 1_000_000);
                            itemTaskList.get(20).setShowProgressBar(false);
                            handler.post(() -> listener.onDone(20));
                            return -1D;
                        }
                    }
                    return -1D;
                }
        ));
    }

    private List<Object> getElements(String type) {
        switch (type) {
            case ARRAY_LIST:
                return getArrayList();
            case LINKED_LIST:
                return getLinkedList();
            case COW_LIST:
                return getCopyOnWriteList();
        }
        return new ArrayList<>();
    }

    private List<Object> getCopyOnWriteList() {
        return copyOnWriteArrayList;
    }

    private List<Object> getLinkedList() {
        return linkedList;
    }

    private List<Object> getArrayList() {
        return arrayList;
    }

    private int getSize() {
        return arrayList.size();
    }

    @Override
    public void setListener(ITaskerListener listener) {
        this.listener = listener;
    }

    @Override
    public List<Callable<Double>> getTasks() {
        List<Callable<Double>> taskList = new ArrayList<>();

        for (ItemTask itemTask : getItemTasks()) {
            taskList.add(itemTask.getTask());
        }
        return taskList;
    }

    @Override
    public void createCollections(String elements) {
        arrayList = getArrayList(elements);
        linkedList = getLinkedList(elements);
        copyOnWriteArrayList = getCopyOnWriteList(elements);
    }


    private List<Object> getCopyOnWriteList(String elements) {
        return generateList(new CopyOnWriteArrayList<>(), elements);
    }

    private List<Object> getLinkedList(String elements) {
        return generateList(new LinkedList<>(), elements);
    }

    private List<Object> getArrayList(String elements) {
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




