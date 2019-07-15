package com.example.mapsandcollections.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mapsandcollections.dto.item.IItemModel;
import com.example.mapsandcollections.ui.fr.ItemTasksFragment;


public class MyFragmentAdapter extends FragmentPagerAdapter {

    MyFragmentAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        return 2;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ItemTasksFragment.newInstance(IItemModel.COLLECTION);
            case 1:
                return ItemTasksFragment.newInstance(IItemModel.MAP);
        }
        return new Fragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0) ? IItemModel.COLLECTION : IItemModel.MAP;
    }
}
