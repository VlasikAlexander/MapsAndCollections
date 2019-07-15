package com.example.mapsandcollections.dto.item;

import android.content.Context;

import com.example.mapsandcollections.R;

import java.util.ArrayList;
import java.util.List;

public class MapItemModel implements IItemModel {

    private String hash_map;
    private String tree_map;

    private String add_new;
    private String remove;
    private String search_by_key;

    private final Context context;
    private List<ItemTask> itemsList;


    MapItemModel(Context context) {
        this.context = context;
        initStrings();
        createModel();
    }

    @Override
    public List<ItemTask> getItems() {
        return itemsList;
    }

    @Override
    public int getCountSpan() {
        return 2;
    }

    private void initStrings() {
        hash_map = context.getString(R.string.hash_map);
        tree_map = context.getString(R.string.tree_map);
        add_new = context.getString(R.string.add_new);
        remove = context.getString(R.string.remove);
        search_by_key = context.getString(R.string.search_by_key);
    }

    private void createModel() {
        itemsList = new ArrayList<>();
        itemsList.add(new ItemTask(0, hash_map, add_new));
        itemsList.add(new ItemTask(1, tree_map, add_new));
        itemsList.add(new ItemTask(2, hash_map, remove));
        itemsList.add(new ItemTask(3, tree_map, remove));
        itemsList.add(new ItemTask(4, hash_map, search_by_key));
        itemsList.add(new ItemTask(5, tree_map, search_by_key));
    }

}
