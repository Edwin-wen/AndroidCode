package com.example.edwin.knowledgecode;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.edwin.knowledgecode.mulitprocess.MultiProcessService;

public class SameMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_main);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction("com.example.edwin.knowledgecode.mulitprocess.MultiProcessService");
        intent.setPackage("com.example.edwin.knowledgecode.mulitprocess");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Intent intent = new Intent(this, MultiProcessService.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
//        Intent intent = new Intent(this, MultiProcessService.class);
//        stopService(intent);
        super.onDestroy();
    }
}
