package com.example.mapsandcollections.ui;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mapsandcollections.ui.fr.collection.CollectionFragment;
import com.example.mapsandcollections.ui.fr.map.MapFragment;

class MyFragmentAdapter extends FragmentPagerAdapter {


    MyFragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CollectionFragment.newInstance();
            case 1:
                return MapFragment.newInstance();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0) ? "Collections" : "Maps";
    }
}
