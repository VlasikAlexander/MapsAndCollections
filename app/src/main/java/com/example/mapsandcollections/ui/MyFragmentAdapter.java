package com.example.mapsandcollections.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.ui.fr.ItemTasksFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public static final String MAP = "MAP";
    public static final String COLLECTION = "COLLECTION";
    private final Context context;

    MyFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ItemTasksFragment.newInstance(COLLECTION);
            case 1:
                return ItemTasksFragment.newInstance(MAP);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0) ? context.getString(R.string.collection) : context.getString(R.string.maps);
    }
}
