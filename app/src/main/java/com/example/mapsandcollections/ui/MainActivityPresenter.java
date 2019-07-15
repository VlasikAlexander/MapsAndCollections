package com.example.mapsandcollections.ui;

public class MainActivityPresenter implements MainActivityContract.IPresenter {

    private final MainActivityContract.IView view;

    public MainActivityPresenter(MainActivityContract.IView view) {
        this.view = view;
    }


}
