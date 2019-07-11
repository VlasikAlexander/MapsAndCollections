package com.example.mapsandcollections.dto;

import android.os.Handler;
import android.os.Looper;

import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemTaskModel implements IItemTaskModel {


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

    private List<Object> elements;
    private final Handler handler;
    private ITaskerListener listener;

    public ItemTaskModel() {
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public List<ItemTask> getItemTasks() {
        final List<ItemTask> itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(
                0,
                ARRAY_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(0, new Object());
                    itemTaskList.get(0).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                1,
                LINKED_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).add(0, new Object());
                    itemTaskList.get(1).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                2,
                COW_LIST,
                ADD_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).add(0, new Object());
                    itemTaskList.get(2).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                3,
                ARRAY_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(3).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                4,
                LINKED_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(4).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                5,
                COW_LIST,
                ADD_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize() / 2, new Object());
                    itemTaskList.get(5).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                6,
                ARRAY_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(6).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                7,
                LINKED_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(7).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                8,
                COW_LIST,
                ADD_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).add(getSize(), new Object());
                    itemTaskList.get(8).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                9,
                ARRAY_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(0);
                    itemTaskList.get(9).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                10,
                LINKED_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(0);
                    itemTaskList.get(10).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                11,
                COW_LIST,
                REMOVE_START,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(0);
                    itemTaskList.get(11).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                12,
                ARRAY_LIST,
                REMOVE_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(getSize() / 2);
                    itemTaskList.get(12).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                13,
                LINKED_LIST,
                REMOVE_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(getSize() / 2);
                    itemTaskList.get(13).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                14,
                COW_LIST,
                REMOVE_MIDDLE,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(getSize() / 2);
                    itemTaskList.get(14).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                15,
                ARRAY_LIST,
                REMOVE_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(ARRAY_LIST).remove(getSize() - 1);
                    itemTaskList.get(15).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));
        itemTaskList.add(new ItemTask(
                16,
                LINKED_LIST,
                REMOVE_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(LINKED_LIST).remove(getSize() - 1);
                    itemTaskList.get(16).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
                }
        ));

        itemTaskList.add(new ItemTask(
                17,
                COW_LIST,
                REMOVE_END,
                () -> {
                    double start = System.nanoTime();
                    getElements(COW_LIST).remove(getSize() - 1);
                    itemTaskList.get(17).setResult(System.nanoTime() - start);
                    handler.post(() -> listener.onDone(0));
                    return 0l;
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
                            handler.post(() -> listener.onDone(18));
                            return 0d;
                        }
                    }
                    return 0d;
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
                            handler.post(() -> listener.onDone(19));
                            return 0d;
                        }
                    }
                    return 0d;
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
                            handler.post(() -> listener.onDone(20));
                            return 0d;
                        }
                    }
                    return 0d;
                }
        ));

        return itemTaskList;
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
        return null;
    }

    private List<Object> getLinkedList() {
        return null;
    }

    private List<Object> getArrayList() {
        return null;
    }

    private int getSize() {
        return elements.size();
    }

    private void setListener(ITaskerListener listener) {
        this.listener = listener;
    }
}




