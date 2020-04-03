package com.example.edwin.knowledgecode.broadcast;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import com.example.edwin.androidlib.BaseTestActivity;
import com.example.edwin.androidlib.Define;

public class BroadcastActivity extends BaseTestActivity implements BaseTestActivity.IClickProxy {

    private DynaticReiver reiver = null;
    private DynaticReiver localReiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] button = {"注册广播", "发送普通广播", "发送有序广播", "发送本地广播"};
        initFunc(button, this);
    }

    @Override
    protected void onDestroy() {
        if (reiver != null) {
            unregisterReceiver(reiver);
        }
        if (localReiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(localReiver);
        }
        super.onDestroy();
    }

    @Override
    public void handleFunc1() {
        if (reiver == null) {
            reiver = new DynaticReiver();
        }
        IntentFilter filter = new IntentFilter(Define.BROADCAST_ACITON);
        filter.setPriority(2);
        registerReceiver(reiver, filter);
    }

    private Intent getNormalIntent() {
        Intent intent = new Intent(Define.BROADCAST_ACITON);
        intent.putExtra(Define.BROADCAST_KEY, "普通");
        return intent;
    }

    @Override
    public void handleFunc2() {
        sendBroadcast(getNormalIntent());
    }

    @Override
    public void handleFunc3() {
        sendOrderedBroadcast(getNormalIntent(),
                null, reiver, null, RESULT_OK, null, null);
    }

    private int index = 0;
    @Override
    public void handleFunc4() {
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getApplicationContext());
        if (localReiver == null) {
            localReiver = new DynaticReiver();
            IntentFilter filter = new IntentFilter(Define.BROADCAST_ACITON);
            filter.setPriority(3);
            manager.registerReceiver(localReiver, filter);
        }

        Intent intent = new Intent(Define.BROADCAST_ACITON);
        intent.putExtra(Define.BROADCAST_KEY, "本地");
        manager.sendBroadcast(intent);
    }

    /**
     * contentProvider的操作，用于调用其他应用的数据啥的
     */
    @Override
    public void handleFunc5() {
        ContentResolver resolver = getContentResolver();
//        resolver.query();
//        resolver.update();
//        resolver.getType();
//        resolver.insert();
//        resolver.delete();
//        resolver.refresh();
//        resolver.notifyChange();
//        Cursor cursor = resolver.query();
//        cursor.close();
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
