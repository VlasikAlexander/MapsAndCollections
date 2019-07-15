package com.example.mapsandcollections.dto.item;

import android.content.Context;

import com.example.mapsandcollections.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionItemModel implements IItemModel {


    private String array_list;
    private String linked_list;
    private String cow_list;

    private String add_start;
    private String add_middle;
    private String add_end;
    private String remove_start;
    private String remove_middle;
    private String remove_end;
    private String search_by_value;


    private final Context context;
    private List<ItemTask> itemTaskList;


    CollectionItemModel(Context context) {
        this.context = context;
        initStrings();
        createModel();
    }

    private void initStrings() {
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

    }


    @Override
    public List<ItemTask> getItems() {
        return itemTaskList;
    }

    @Override
    public int getCountSpan() {
        return 3;
    }


    private void createModel() {

        itemTaskList = new ArrayList<>();
        itemTaskList.add(new ItemTask(0, array_list, add_start));
        itemTaskList.add(new ItemTask(1, linked_list, add_start));
        itemTaskList.add(new ItemTask(2, cow_list, add_start));

        itemTaskList.add(new ItemTask(3, array_list, add_middle));
        itemTaskList.add(new ItemTask(4, linked_list, add_middle));
        itemTaskList.add(new ItemTask(5, cow_list, add_middle));

        itemTaskList.add(new ItemTask(6, array_list, add_end));
        itemTaskList.add(new ItemTask(7, linked_list, add_end));
        itemTaskList.add(new ItemTask(8, cow_list, add_end));

        itemTaskList.add(new ItemTask(9, array_list, remove_start));
        itemTaskList.add(new ItemTask(10, linked_list, remove_start));
        itemTaskList.add(new ItemTask(11, cow_list, remove_start));

        itemTaskList.add(new ItemTask(12, array_list, remove_middle));
        itemTaskList.add(new ItemTask(13, linked_list, remove_middle));
        itemTaskList.add(new ItemTask(14, cow_list, remove_middle));

        itemTaskList.add(new ItemTask(15, array_list, remove_end));
        itemTaskList.add(new ItemTask(16, linked_list, remove_end));
        itemTaskList.add(new ItemTask(17, cow_list, remove_end));

        itemTaskList.add(new ItemTask(18, array_list, search_by_value));
        itemTaskList.add(new ItemTask(19, linked_list, search_by_value));
        itemTaskList.add(new ItemTask(20, cow_list, search_by_value));
    }
}




