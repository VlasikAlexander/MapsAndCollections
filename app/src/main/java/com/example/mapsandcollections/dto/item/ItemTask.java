package com.example.mapsandcollections.dto.item;

import java.util.concurrent.Callable;

public class ItemTask {

    private final String type;
    private final String action;
    private final int position;
    private double result;


    private boolean isShowProgressBar;

    ItemTask(int position, String type, String action) {
        this.position = position;
        this.type = type;
        this.action = action;


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

}
