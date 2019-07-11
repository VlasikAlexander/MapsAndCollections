package com.example.mapsandcollections.dto;

import com.example.mapsandcollections.components.tasker.ITaskerListener;

import java.util.List;
import java.util.concurrent.Callable;

public class MapItemModel implements IItemTaskModel {
    @Override
    public List<ItemTask> getItemTasks() {
        return null;
    }

    @Override
    public void setElements(List<Object> arrayList, List<Object> linkedList, List<Object> copyOnWriteList) {

    }

    @Override
    public void setListener(ITaskerListener listener) {

    }

    @Override
    public List<Callable<Double>> getTasks() {
        return null;
    }

    @Override
    public void createCollections(String elements) {

    }
}
