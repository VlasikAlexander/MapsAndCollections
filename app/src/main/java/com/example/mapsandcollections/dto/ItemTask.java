package com.example.mapsandcollections.dto;

import java.util.concurrent.Callable;

public class ItemTask {

    private final String type;
    private final String action;
    private final int position;
    private double result;
    private Callable<Double> task;

    private boolean isShowProgressBar;

    ItemTask(int position, String type, String action, Callable<Double> task) {
        this.position = position;
        this.type = type;
        this.action = action;
        this.task = task;

    }

    public double getResult() {
        return result;
    }

    public int getPosition() {
        return position;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public String getAction() {
        return action;
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
