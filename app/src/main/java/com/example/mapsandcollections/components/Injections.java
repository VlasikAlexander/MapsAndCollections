package com.example.mapsandcollections.components;

import com.example.mapsandcollections.components.tasker.Tasker;
import com.example.mapsandcollections.ui.MainActivityContract;
import com.example.mapsandcollections.ui.MainActivityPresenter;
import com.example.mapsandcollections.ui.fr.collection.CollectionContract;
import com.example.mapsandcollections.ui.fr.collection.CollectionPresenter;
import com.example.mapsandcollections.ui.fr.map.MapContract;
import com.example.mapsandcollections.ui.fr.map.MapPresenter;

public class Injections  {

    private static IProvider provider;

    public static void setProvider(IProvider provider) {
        Injections.provider = provider;
    }

    public static IProvider getProvider() {
        return provider;
    }

     public static MainActivityContract.IPresenter getMainActivityPresenter(MainActivityContract.IView view)  {
            return new MainActivityPresenter(view);
     }

    public static CollectionContract.IPresenter getCollectionPresenter(CollectionContract.IView view) {
        return new CollectionPresenter(view, provider.getTasker(), provider.getCollectionItemModel());
    }


    public static MapContract.IPresenter getMapFragmentPresenter(MapContract.IView view) {
        return new MapPresenter(view, provider.getTasker(), provider.getMapItemModel());
    }
}
