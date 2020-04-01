package com.example.edwin.knowledgecode;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.edwin.knowledgecode.mulitprocess.IBeanController;
import com.example.edwin.knowledgecode.mulitprocess.MultiProcessService;
import com.example.edwin.knowledgecode.mulitprocess.MultiTestService;
import com.example.edwin.knowledgecode.sameapp.MultiTest;

public class SameMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_main);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    private MultiTest multiTest = null;

    private IBeanController controller = null;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            String string = "bbb";
//            multiTest = MultiTest.Stub.asInterface(service);
            controller = IBeanController.Stub.asInterface(service);
            Log.d("多进程测试", "成功=======");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("多进程测试", "失败=======");
        }
    };

    private void bindServiceByAction() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.edwin.knowledgecode.mulitprocess", "com.example.edwin.knowledgecode.mulitprocess.MultiProcessService"));
        boolean result = bindService(intent, connection, Context.BIND_AUTO_CREATE);
        Log.d("bindResult", "==" + result);
    }

    private void bindService() {
        Intent intent = new Intent(this, MultiProcessService.class);
        boolean result = bindService(intent, connection, Context.BIND_AUTO_CREATE);
        Log.d("bindResult", "==" + result);
    }

    private void bindTest() {
        Intent intent = new Intent(this, MultiTestService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                bindService();
                bindServiceByAction();
                break;
            case R.id.btn2:
                if (controller != null) {
                    int i = 100;
                }
//                bindService();
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
