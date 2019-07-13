package com.example.mapsandcollections.components;

import com.example.mapsandcollections.dto.ItemModelFactory;
import com.example.mapsandcollections.ui.fr.BaseContract;
import com.example.mapsandcollections.ui.fr.BasePresenter;

public class Injections {

    private static IProvider provider;

    public static void setProvider(IProvider provider) {
        Injections.provider = provider;
    }

    public static IProvider getProvider() {
        return provider;
    }

    public static BaseContract.IPresenter getBaseFragmentPresenter(BaseContract.IView view) {
        return new BasePresenter(view, provider.getTasker(), new ItemModelFactory());
    }

}
