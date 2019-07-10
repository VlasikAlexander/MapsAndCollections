package com.example.mapsandcollections;

import android.app.Application;

import com.example.mapsandcollections.components.Injections;
import com.example.mapsandcollections.components.Provider;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injections.setProvider(new Provider(this));
    }
}
