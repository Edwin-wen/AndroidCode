package com.example.edwin.knowledgecode.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.edwin.knowledgecode.R;
import com.example.edwin.knowledgecode.main.fragment.ViewFragment;
import com.example.edwin.knowledgecode.main.fragment.FragmentTranformer;
import com.example.edwin.knowledgecode.main.fragment.ItemFragment;
import com.example.edwin.knowledgecode.main.fragment.MainFragmentAdapter;
import com.example.edwin.knowledgecode.main.fragment.dummy.FragmentListItem;

import java.util.ArrayList;
import java.util.List;


/**
 * 只处理fragment切换相关的流程
 */
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, ItemFragment.OnListFragmentInteractionListener {

    private ViewPager mMainViewPager;
    private MainFragmentAdapter mFragmentAdapter;
    private FragmentTranformer mFragmentTranformer;

    private ViewFragment mViewFragment;
    private ItemFragment  mAndroidFragment;
    private ItemFragment  mJavaFragment;
    private List<Fragment> fragmentList = new ArrayList<>();

    private List<TextView> mBottomTabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        bindFragment();
        initBottomTabs();
    }

    private void initFragment() {
        mViewFragment = ViewFragment.newInstance("view", "view");
        mAndroidFragment = ItemFragment.newInstance(1);
        mAndroidFragment.setItemDataList(ItemUtil.getAndroidFunc());
        mJavaFragment = ItemFragment.newInstance(2);
        mJavaFragment.setItemDataList(ItemUtil.getJavaFunc());
        fragmentList.add(mAndroidFragment);
        fragmentList.add(mJavaFragment);
        fragmentList.add(mViewFragment);
    }

    private void bindFragment() {
        mMainViewPager = findViewById(R.id.mainPager);
        mFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);
        mFragmentTranformer = new FragmentTranformer();
        mMainViewPager.setAdapter(mFragmentAdapter);
        mMainViewPager.addOnPageChangeListener(this);
        mMainViewPager.setPageTransformer(true, mFragmentTranformer);
    }

    private void initBottomTabs() {
        TextView androidTab = findViewById(R.id.android_func);
        TextView javaTab    = findViewById(R.id.java_func);
        TextView viewTab    = findViewById(R.id.view_func);
        androidTab.setOnClickListener(this);
        javaTab.setOnClickListener(this);
        viewTab.setOnClickListener(this);
        mBottomTabs.add(androidTab);
        mBottomTabs.add(javaTab);
        mBottomTabs.add(viewTab);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int index) {
        for (int i = 0; i < mBottomTabs.size(); i++) {
            TextView view = mBottomTabs.get(i);
            view.setTextColor(index == i ? Color.BLUE : Color.BLACK) ;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.android_func:
                mMainViewPager.setCurrentItem(0);
                break;
            case R.id.java_func:
                mMainViewPager.setCurrentItem(1);
                break;
            case R.id.view_func:
                mMainViewPager.setCurrentItem(2);
                break;
        }
    }


    /**
     * 列表item点击的监听
     * @param item
     */
    @Override
    public void onListFragmentInteraction(FragmentListItem item) {
        if (item.jumpToClass != null) {
            Intent intent = new Intent(this, item.jumpToClass);
            startActivity(intent);
        }
    }
}
