package com.example.mapsandcollections.ui;

import com.example.mapsandcollections.ui.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.IPresenter {

    private final MainActivityContract.IView view;

    public MainActivityPresenter(MainActivityContract.IView view) {
        this.view = view;
    }


}
