package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter myAdapter;
    private TabLayout.Tab recommendTab, hotSpotTab, fuZhouTab, societyTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);       //设置沉浸式状态栏，在MIUI系统中，状态栏背景透明。原生系统中，状态栏背景半透明。
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //设置沉浸式虚拟键，在MIUI系统中，虚拟键背景透明。原生系统中，虚拟键背景半透明。
        initView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        myAdapter = new MyAdapter(fragmentManager);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        recommendTab = tabLayout.getTabAt(0);
        hotSpotTab = tabLayout.getTabAt(1);
        fuZhouTab = tabLayout.getTabAt(2);
        societyTab = tabLayout.getTabAt(3);
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
    }
}