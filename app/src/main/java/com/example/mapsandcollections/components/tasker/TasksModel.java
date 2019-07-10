package com.example.mapsandcollections.components.tasker;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.mapsandcollections.ui.fr.map.MapPresenter.MAPS;

public class TasksModel {

    public static final String ARRAYLIST_ADD_BEGIN = "ARRAYLIST_ADD_BEGIN";
    public static final String ARRAYLIST_ADD_MIDDLE = "ARRAYLIST_ADD_MIDDLE";
    public static final String ARRAYLIST_ADD_END = "ARRAYLIST_ADD_END";
    public static final String ARRAYLIST_REMOVE_BEGIN = "ARRAYLIST_REMOVE_BEGIN";
    public static final String ARRAYLIST_REMOVE_MIDDLE = "ARRAYLIST_REMOVE_MIDDLE";
    public static final String ARRAYLIST_REMOVE_END = "ARRAYLIST_REMOVE_END";
    public static final String ARRAYLIST_SEARCH_BY_VALUE = "ARRAYLIST_SEARCH_BY_VALUE";

    public static final String COW_ADD_BEGIN = "COW_ADD_BEGIN";
    public static final String COW_ADD_END = "COW_ADD_END";
    public static final String COW_ADD_MIDDLE = "COW_ADD_MIDDLE";
    public static final String COW_REMOVE_BEGIN = "COW_REMOVE_BEGIN";
    public static final String COW_REMOVE_END = "COW_REMOVE_END";
    public static final String COW_REMOVE_MIDDLE = "COW_REMOVE_MIDDLE";
    public static final String COW_SEARCH_BY_VALUE = "COW_SEARCH_BY_VALUE";

    public static final String LINKEDLIST_ADD_BEGIN = "LINKEDLIST_ADD_BEGIN";
    public static final String LINKEDLIST_ADD_MIDDLE = "LINKEDLIST_ADD_MIDDLE";
    public static final String LINKEDLIST_ADD_END = "LINKEDLIST_ADD_END";
    public static final String LINKEDLIST_REMOVE_BEGIN = "LINKEDLIST_REMOVE_BEGIN";
    public static final String LINKEDLIST_REMOVE_MIDDLE = "LINKEDLIST_REMOVE_MIDDLE";
    public static final String LINKEDLIST_REMOVE_END = "LINKEDLIST_REMOVE_END";
    public static final String LINKEDLIST_SEARCH_BY_VALUE = "LINKEDLIST_SEARCH_BY_VALUE";

    private Handler handler = new Handler(Looper.getMainLooper());
    private ExecutorService executor;
    private ITaskerListener listener;


    public List<Callable<Double>> getTasks(String type, String elements, ITaskerListener listener) {
        this.listener = listener;
        if (MAPS.equals(type)) return getCollectionsTasks(elements);
        else return getCollectionsTasks(elements);

    }

    private List<Callable<Double>> getCollectionsTasks(String elements) {
        final List<Callable<Double>> tasks = new ArrayList<>();
        final int amount = Integer.parseInt(elements);


        final List<Object> arrayList = new ArrayList<>();
        final List<Object> linkedList = new LinkedList<>();
        final List<Object> copyOnWriteList = new CopyOnWriteArrayList<>();


        for (int i = 0; i < amount; i++) {
            arrayList.add(new Object());
            linkedList.add(new Object());
            copyOnWriteList.add(new Object());
            System.out.println(i);
        }
        // add First
        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.add(0, new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_ADD_BEGIN));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            linkedList.add(0, new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_ADD_BEGIN));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.add(0, new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_ADD_BEGIN));
            return 0d;
        });

        // ----------------------

        // add middle

        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.add((arrayList.size() / 2), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_ADD_MIDDLE));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            linkedList.add((linkedList.size() / 2), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_ADD_MIDDLE));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.add((copyOnWriteList.size() / 2), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_ADD_MIDDLE));
            return 0d;
        });

        // -------------------------

        // add End

        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.add(arrayList.size(), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_ADD_END));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            linkedList.add(linkedList.size(), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_ADD_END));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.add(copyOnWriteList.size(), new Object());
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_ADD_END));
            return 0d;
        });

        // ----------------------

        // remove First

        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.remove(0);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_REMOVE_BEGIN));
            return 0d;
        });

        tasks.add(() -> {
            long start = System.nanoTime();
            linkedList.remove(0);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_REMOVE_BEGIN));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.remove(0);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_REMOVE_BEGIN));
            return 0d;
        });

        //----------------------

        // remove middle

        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.remove(arrayList.size() / 2);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_REMOVE_MIDDLE));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            linkedList.remove(linkedList.size() / 2);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_REMOVE_MIDDLE));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.remove(copyOnWriteList.size() / 2);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_REMOVE_MIDDLE));
            return 0d;
        });

        //--------------------

        // remove end

        tasks.add(() -> {
            double start = System.nanoTime();
            arrayList.remove(arrayList.size() - 1);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_REMOVE_END));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            linkedList.remove(linkedList.size() - 1);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_REMOVE_END));
            return 0d;
        });

        tasks.add(() -> {
            double start = System.nanoTime();
            copyOnWriteList.remove(copyOnWriteList.size() - 1);
            handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_REMOVE_END));
            return 0d;
        });

        //--------------------

        // search by Value

        tasks.add(() -> {
            final Random random = new Random();
            final Object suspect = arrayList.get(random.nextInt(arrayList.size()));
            double start = System.nanoTime();
            for (Object o : arrayList) {
                if (suspect == o) {
                    handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, ARRAYLIST_SEARCH_BY_VALUE));
                    return 0d;
                }
            }
            return 0d;
        });

        tasks.add(() -> {
            final Random random = new Random();
            final Object suspect = linkedList.get(random.nextInt(linkedList.size()));
            double start = System.nanoTime();
            for (Object o : linkedList) {
                if (suspect == o) {
                    handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, LINKEDLIST_SEARCH_BY_VALUE));
                    return 0d;
                }
            }
            return 0d;
        });

        tasks.add(() -> {
            final Random random = new Random();
            final Object suspect = copyOnWriteList.get(random.nextInt(copyOnWriteList.size()));
            double start = System.nanoTime();
            for (Object o : copyOnWriteList) {
                if (suspect == o) {
                    handler.post(() -> listener.onDone((System.nanoTime()  - start) / 1_000_000, COW_SEARCH_BY_VALUE));
                    return 0d;
                }
            }
            return 0d;
        });

        //--------------------

        return tasks;
    }


    private BlockingQueue<Runnable> getMapTasks(String elements) {
        return null;
    }
}
