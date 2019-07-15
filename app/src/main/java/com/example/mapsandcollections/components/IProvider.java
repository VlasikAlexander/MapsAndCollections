package com.example.mapsandcollections.components;

import android.content.Context;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.dto.item.ItemModelFactory;

public interface IProvider {

    ITasker getTasker();

    Context getContext();

    ItemModelFactory getItemModelFactory();

}
