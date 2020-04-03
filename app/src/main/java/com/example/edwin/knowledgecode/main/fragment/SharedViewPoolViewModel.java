package com.example.edwin.knowledgecode.main.fragment;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;

/**
 * 也就是说这个RecycledViewPool一般用于多fragment之间，item类型相同的，这样就可以共享一个缓存
 */
public class SharedViewPoolViewModel extends ViewModel {

    //for MainContentFragment
    private RecyclerView.RecycledViewPool mainContentFragmentPool;

    public RecyclerView.RecycledViewPool getMainContentFragmentPool() {
        if (mainContentFragmentPool == null)
            mainContentFragmentPool = new RecyclerView.RecycledViewPool();
        return mainContentFragmentPool;
    }

    public void setActivityViewPool() {
        /**
         *
         * 如果是Activity中包含多个Fragment
         */
//        SharedViewPoolViewModel sharedViewPoolModel = ViewModelProviders.of(getActivity()).get(SharedViewPoolViewModel.class);
//        recyclerView.setRecycledViewPool(sharedViewPoolModel.getHomeOutdoorPool());


        /**
         *
         * 如果是Fragment中包含多个Fragment
         */
//        SharedViewPoolViewModel sharedViewPoolModel = ViewModelProviders.of(null == getParentFragment() ? this : getParentFragment()).get(SharedViewPoolViewModel.class);
//        recyclerView.setRecycledViewPool(sharedViewPoolModel.getHomeOutdoorPool());
    }
}
