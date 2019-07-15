package com.example.mapsandcollections.dto.item;

import android.content.Context;

import com.example.mapsandcollections.R;

import java.util.ArrayList;
import java.util.List;

public class MapItemModel implements IItemModel {

    private final String hash_map;
    private final String tree_map;
    private final String add_new;
    private final String remove;
    private final String search_by_key;
    private List<ItemResult> itemsList;




    MapItemModel(Context context) {
        hash_map = context.getString(R.string.hash_map);
        tree_map = context.getString(R.string.tree_map);
        add_new = context.getString(R.string.add_new);
        remove = context.getString(R.string.remove);
        search_by_key = context.getString(R.string.search_by_key);
        createModel();
    }

    @Override
    public List<ItemResult> getItems() {
        return itemsList;
    }

    @Override
    public int getCountSpan() {
        return 2;
    }

    private void createModel() {
        itemsList = new ArrayList<>();
        itemsList.add(new ItemResult(0, hash_map, add_new));
        itemsList.add(new ItemResult(1, tree_map, add_new));
        itemsList.add(new ItemResult(2, hash_map, remove));
        itemsList.add(new ItemResult(3, tree_map, remove));
        itemsList.add(new ItemResult(4, hash_map, search_by_key));
        itemsList.add(new ItemResult(5, tree_map, search_by_key));
    }

}
