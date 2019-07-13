package com.example.mapsandcollections.ui;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mapsandcollections.ui.fr.BaseFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public static final String MAP = "MAP";
    public static final String COLLECTION = "COLLECTION";

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
                return BaseFragment.newInstance(COLLECTION);
            case 1:
                return BaseFragment.newInstance(MAP);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0) ? "Collections" : "Maps";
    }
}
