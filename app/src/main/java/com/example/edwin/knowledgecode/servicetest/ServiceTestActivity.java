package com.example.edwin.knowledgecode.servicetest;

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

import com.example.edwin.androidlib.multiapp.IDataChanel;
import com.example.edwin.knowledgecode.R;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private IDataChanel controller = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        textView = findViewById(R.id.tv);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
    }

    private void bindService() {
        Intent intent = new Intent(this, OtherProcessService.class);
        boolean result = bindService(intent, connection, Context.BIND_AUTO_CREATE);
        if (!result) {
            throw new RuntimeException("服务绑定失败");
        }
    }

    private void startIntentService() {
        IntentActionService.startActionBaz(this, "a", "b");
        IntentActionService.startActionFoo(this, "a", "b");
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            controller = IDataChanel.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("服务测试", "调用失败");
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                bindService();
                break;
            case R.id.btn2:
                startIntentService();
                break;
            case R.id.btn3:
                try {
                    long time = System.currentTimeMillis();
                    // 说明默认aidl是阻塞当前线程的
                    Log.d("测试Binder时间", String.valueOf(time));
                    String str = controller.getShareData().getData();
                    long delta = System.currentTimeMillis() - time;
                    Log.d("测试Binder时间", delta + "  " + String.valueOf(System.currentTimeMillis()));
                    textView.setText(str + " " +  String.valueOf(delta));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
