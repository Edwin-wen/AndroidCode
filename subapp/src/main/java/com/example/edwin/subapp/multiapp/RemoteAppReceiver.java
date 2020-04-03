package com.example.edwin.subapp.multiapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.edwin.androidlib.Define;

public class RemoteAppReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        int a = bundle.getInt(Define.BROADCAST_KEY);
        Log.d("广播测试", "远程广播收到了====" + a);
    }
}
