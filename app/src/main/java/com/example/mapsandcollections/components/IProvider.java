package com.example.mapsandcollections.components;

import com.example.mapsandcollections.components.tasker.ITasker;
import com.example.mapsandcollections.dto.IItemTaskModel;

public interface IProvider {

    IItemTaskModel getCollectionItemModel();

    IItemTaskModel getMapItemModel();

    ITasker getTasker();

}
