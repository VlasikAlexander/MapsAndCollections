package com.example.mapsandcollections.dto.item;

import android.content.Context;


public class ItemModelFactory {

    private final Context context;

    public ItemModelFactory(Context context) {
        this.context = context;
    }

    public IItemModel getItemModel(String type) {

        if (IItemModel.COLLECTION.equals(type)) return new CollectionItemModel(context);
        else return new MapItemModel(context);
    }
}
