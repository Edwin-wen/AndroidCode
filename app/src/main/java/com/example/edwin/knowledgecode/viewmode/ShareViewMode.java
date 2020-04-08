package com.example.edwin.knowledgecode.viewmode;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;

/**
 * 生命周期与其宿主一致，不受宿主的生命周期变化变化，只会相应结束方法
 * 1.用于实现MVVM的VM模块，把数据处理从Activity或者Fragment解耦出来
 * 2.用于fragment数据共享，如recycleView的viewPool
 */
public class ShareViewMode extends ViewModel {
    private RecyclerView.RecycledViewPool mSharePool = new RecyclerView.RecycledViewPool();

    public ShareViewMode() {
    }

    public RecyclerView.RecycledViewPool getSharePool() {
        return mSharePool;
    }

    public void setSharePool(RecyclerView.RecycledViewPool mSharePool) {
        this.mSharePool = mSharePool;
    }
}
