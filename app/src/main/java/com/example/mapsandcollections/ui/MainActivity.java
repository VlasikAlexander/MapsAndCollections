package com.example.mapsandcollections.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.ui.fr.ItemTasksContract;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements MainActivityContract.IView, ItemTasksContract.IHost{

    private ViewPager viewPager;
    private TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        tableLayout = findViewById(R.id.tab_layout);
        initViewPager();
    }

    private void initViewPager() {
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        tableLayout.setupWithViewPager(viewPager);
    }
}
