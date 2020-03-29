package com.example.edwin.knowledgecode.activity.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = null;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }


    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
