package com.example.mapsandcollections.ui.fr;

import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

public class BaseContract {

    public interface IPresenter {

        void calculate(String type, String elements, String threads);
        List<ItemTask> getItemTasks();

        void setType(String type);
    }

    public interface IView {

        void updateUI(int position);

        void setShowProgressBar();
    }

    public interface IHost {

    }
}
