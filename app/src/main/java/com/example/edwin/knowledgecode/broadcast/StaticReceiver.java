package com.example.edwin.knowledgecode.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.edwin.androidlib.Define;

public class StaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String a = bundle.getString(Define.BROADCAST_KEY);
        Log.e("广播测试", "静态广播收到了====" + a);
    }
}
