package com.example.mapsandcollections.dto;

import java.util.List;
import java.util.concurrent.Callable;

public class ItemTask {

    private final String title;
    private final String description;
    private final int position;
    private double result;
    private Callable task;
    private List<Object> elements;

    public ItemTask(int position, String title, String description, Callable task) {
        this.position = position;
        this.title = title;
        this.description = description;

    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Callable task) {
        this.task = task;
    }
}
