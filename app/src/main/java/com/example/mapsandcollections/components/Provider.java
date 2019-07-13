package com.example.mapsandcollections.components;

import android.content.Context;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.dto.CollectionItemModel;
import com.example.mapsandcollections.dto.IItemTaskModel;
import com.example.mapsandcollections.dto.MapItemModel;

public class Provider implements IProvider {

    final private Context context;
    final private ITasker tasker;

    public Provider(Context context) {
        this.context = context;
        this.tasker = new Tasker();
    }

    @Override
    public ITasker getTasker() {
        return tasker;
    }
}
