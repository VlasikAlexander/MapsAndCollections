package com.example.mapsandcollections.ui.fr.collection;

import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

public class CollectionContract {

    public interface IPresenter {

        void calculate(String elements, String threads);

        List<ItemTask> getItemTasks();
    }

    public interface IView {

        void updateUI(int position);

        void setShowProgressBar();
    }

    public interface IHost {

    }
}
