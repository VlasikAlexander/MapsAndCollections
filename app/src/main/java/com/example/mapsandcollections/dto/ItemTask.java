package com.example.mapsandcollections.dto;

import java.util.concurrent.Callable;

public class ItemTask {

    private final String title;
    private final String description;
    private final int position;
    private double result;
    private Callable<Double> task;

    private boolean isShowProgressBar;

    ItemTask(int position, String title, String description, Callable<Double> task) {
        this.position = position;
        this.title = title;
        this.description = description;
        this.task = task;

    }

    public double getResult() {
        return result;
    }

    void setResult(double result) {
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isShowProgressBar() {
        return isShowProgressBar;
    }

    public void setShowProgressBar(boolean showProgressBar) {
        isShowProgressBar = showProgressBar;
    }

    Callable<Double> getTask() {
        return task;
    }


}
