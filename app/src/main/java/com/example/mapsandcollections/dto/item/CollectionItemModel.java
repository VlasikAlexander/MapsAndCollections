package com.example.mapsandcollections.dto.item;

import android.content.Context;

import com.example.mapsandcollections.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionItemModel implements IItemModel {


    private final String array_list;
    private String linked_list;
    private String cow_list;

    private final String add_start;
    private final String add_middle;
    private final String add_end;
    private final String remove_start;
    private final String remove_middle;
    private final String remove_end;
    private final String search_by_value;
    private List<ItemResult> itemsList;


    CollectionItemModel(Context context) {

        array_list = context.getString(R.string.array_list);
        linked_list = context.getString(R.string.linked_list);
        cow_list = context.getString(R.string.cow_list);
        add_start = context.getString(R.string.add_start);
        add_middle = context.getString(R.string.add_middle);
        add_end = context.getString(R.string.add_end);
        remove_start = context.getString(R.string.remove_start);
        remove_middle = context.getString(R.string.remove_middle);
        remove_end = context.getString(R.string.remove_end);
        search_by_value = context.getString(R.string.serch_by_value);
        createModel();
    }

    @Override
    public List<ItemResult> getItems() {
        return itemsList;
    }

    @Override
    public int getCountSpan() {
        return 3;
    }


    private void createModel() {

        itemsList = new ArrayList<>();
        itemsList.add(new ItemResult(0, array_list, add_start));
        itemsList.add(new ItemResult(1, linked_list, add_start));
        itemsList.add(new ItemResult(2, cow_list, add_start));

        itemsList.add(new ItemResult(3, array_list, add_middle));
        itemsList.add(new ItemResult(4, linked_list, add_middle));
        itemsList.add(new ItemResult(5, cow_list, add_middle));

        itemsList.add(new ItemResult(6, array_list, add_end));
        itemsList.add(new ItemResult(7, linked_list, add_end));
        itemsList.add(new ItemResult(8, cow_list, add_end));

        itemsList.add(new ItemResult(9, array_list, remove_start));
        itemsList.add(new ItemResult(10, linked_list, remove_start));
        itemsList.add(new ItemResult(11, cow_list, remove_start));

        itemsList.add(new ItemResult(12, array_list, remove_middle));
        itemsList.add(new ItemResult(13, linked_list, remove_middle));
        itemsList.add(new ItemResult(14, cow_list, remove_middle));

        itemsList.add(new ItemResult(15, array_list, remove_end));
        itemsList.add(new ItemResult(16, linked_list, remove_end));
        itemsList.add(new ItemResult(17, cow_list, remove_end));

        itemsList.add(new ItemResult(18, array_list, search_by_value));
        itemsList.add(new ItemResult(19, linked_list, search_by_value));
        itemsList.add(new ItemResult(20, cow_list, search_by_value));
    }
}




