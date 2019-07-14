package com.example.mapsandcollections.dto;

import android.content.Context;

import static com.example.mapsandcollections.ui.MyFragmentAdapter.COLLECTION;

public class ItemModelFactory {

    private final Context context;

    public ItemModelFactory(Context context) {
        this.context = context;
    }

    public IItemTaskModel getItemModel(String type) {

        if (COLLECTION.equals(type)) return new CollectionItemModel(context);
        else return new MapItemModel(context);
    }
}
