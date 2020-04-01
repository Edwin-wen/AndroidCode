package com.example.edwin.knowledgecode.mulitprocess;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.edwin.knowledgecode.R;

public class MulitProcessActivity extends AppCompatActivity implements View.OnClickListener {

    IBeanController controller = null;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            controller = IBeanController.Stub.asInterface(service);
            Log.e("多进程测试", "调用成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("多进程测试", "调用失败");
        }
    };

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_process);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        textView = findViewById(R.id.textView);
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction("com.example.edwin.knowledgecode.mulitprocess.MultiProcessService");
        intent.setPackage("com.example.edwin.knowledgecode.mulitprocess");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                bindService();
                break;
            case R.id.button2:
                try {
                    String str = controller.getMultiBean().getShareData();
                    textView.setText(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
