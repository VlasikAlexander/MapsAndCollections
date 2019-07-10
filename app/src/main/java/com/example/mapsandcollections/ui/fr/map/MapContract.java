package com.example.mapsandcollections.ui.fr.map;

import java.util.List;

public class MapContract {

    public interface IPresenter {

        void calculate(String threads, String elements);
    }

    public interface IView {

        void updateUI(List<Double> list);
    }

    public interface IHost {

    }
}
