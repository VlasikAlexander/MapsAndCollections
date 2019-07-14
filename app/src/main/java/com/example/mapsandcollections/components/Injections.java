package com.example.mapsandcollections.components;

import com.example.mapsandcollections.ui.fr.ItemTasksContract;
import com.example.mapsandcollections.ui.fr.ItemTasksPresenter;

public class Injections {

    private static IProvider provider;

    public static void setProvider(IProvider provider) {
        Injections.provider = provider;
    }

    public static IProvider getProvider() {
        return provider;
    }

    public static ItemTasksContract.IPresenter getBaseFragmentPresenter(ItemTasksContract.IView view) {
        return new ItemTasksPresenter(view, provider.getTasker(), provider.getItemModelFactory());
    }

}
