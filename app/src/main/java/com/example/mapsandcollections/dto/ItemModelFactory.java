package com.example.mapsandcollections.dto;

import static com.example.mapsandcollections.ui.MyFragmentAdapter.COLLECTION;

public class ItemModelFactory {

    public IItemTaskModel getItemModel(String type) {

        if (COLLECTION.equals(type)) return new CollectionItemModel();
        else return new MapItemModel();
    }
}
