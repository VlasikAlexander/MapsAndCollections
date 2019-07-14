package com.example.mapsandcollections.components;

import android.content.Context;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.ItemModelFactory;

public class Provider implements IProvider {

    final private Context context;
    final private ITasker tasker;
    final private ItemModelFactory itemModelFactory;

    public Provider(Context context) {
        this.context = context;
        this.itemModelFactory = new ItemModelFactory(context);
        this.tasker = new Tasker(itemModelFactory);

    }

    @Override
    public ITasker getTasker() {
        return tasker;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public ItemModelFactory getItemModelFactory() {
        return itemModelFactory;
    }
}
