package com.example.mapsandcollections.ui.fr;

import com.example.mapsandcollections.dto.item.ItemTask;

import java.util.List;

public class ItemTasksContract {

    public interface IPresenter {

        void calculate(String type, String elements, String threads);

        List<ItemTask> getItemTasks();

        void setType(String type);

        int getSpanCount(String type);
    }

    public interface IView {

        void updateUI(int position);

        void setShowProgressBar();

        void showError();
    }

    public interface IHost {

    }
}
