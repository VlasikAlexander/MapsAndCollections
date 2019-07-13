package com.example.mapsandcollections;

import android.app.Application;

import com.example.mapsandcollections.components.Injections;
import com.example.mapsandcollections.components.Provider;

public class App extends Application {

    // TODO: 13.07.2019 Rename Classes and Methods
    // TODO: 13.07.2019 Extract String Resources

    @Override
    public void onCreate() {
        super.onCreate();
        Injections.setProvider(new Provider(this));
    }


}
