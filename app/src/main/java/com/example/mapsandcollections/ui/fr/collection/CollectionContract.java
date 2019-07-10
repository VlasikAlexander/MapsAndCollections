package com.example.mapsandcollections.ui.fr.collection;

import java.util.List;

public class CollectionContract {

    public interface IPresenter {

        void calculate(String threads, String elements);
    }

    public interface IView {

        void updateUI(List<Double> list);

        void updateOneWidget(double time, String task);
    }

    public interface IHost {

    }
}
