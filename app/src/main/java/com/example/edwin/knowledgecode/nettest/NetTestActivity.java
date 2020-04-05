package com.example.edwin.knowledgecode.nettest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.edwin.androidlib.BaseTestActivity;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetTestActivity extends BaseTestActivity implements BaseTestActivity.IClickProxy {

    private final String URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585992636983&di=7d60fff085c5fac672994d1f605908c7&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg";

    private ThreadPoolExecutor executor;
    private final OkHttpClient mClinet = new OkHttpClient();
    private NetMainHanlder mMainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] strings = {};
        initFunc(strings, this);
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        mMainHandler = new NetMainHanlder(this)
;    }

    private Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                final Request request = new Request.Builder().url("https://www.baidu.com/").build();
                try {
                    Response response = mClinet.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

//    private Runnable postTask() {
//
//    }

    private static class NetMainHanlder extends Handler {

        private WeakReference<NetTestActivity> activityWeakReference;

        public NetMainHanlder(NetTestActivity activity) {
            this.activityWeakReference = new WeakReference<NetTestActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

            }
        }
    }

    @Override
    public void handleFunc1() {

    }

    @Override
    public void handleFunc2() {

    }

    @Override
    public void handleFunc3() {

    }

    @Override
    public void handleFunc4() {

    }

    @Override
    public void handleFunc5() {

    }

    @Override
    public void handleFunc6() {

    }

    @Override
    public void handleFunc7() {

    }

    @Override
    public void handleFunc8() {

    }
}
