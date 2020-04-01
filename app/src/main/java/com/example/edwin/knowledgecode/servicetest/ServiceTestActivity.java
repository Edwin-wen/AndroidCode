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

import com.example.edwin.knowledgecode.R;
import com.example.edwin.knowledgecode.mulitprocess.IBeanController;
import com.example.edwin.knowledgecode.mulitprocess.MultiBean;

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private IBeanController controller = null;

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
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private void startIntentService() {
//        Intent intent = new Intent();
//        intent.setAction("action_service_aaaa");
//        intent.setPackage("com.example.edwin.knowledgecode.servicetest");
        IntentActionService.startActionBaz(this, "a", "b");
        IntentActionService.startActionFoo(this, "a", "b");
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            controller = IBeanController.Stub.asInterface(service);
            Log.e("服务测试", "调用成功");
//            try {
//                controller.setMultiBean(new MultiBean("客户端数据"));
//                Log.e("多进程测试", "客户端设置了数据=====");
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//            try {
//                Log.e("多进程测试", "客户端用服务端改的数据" + controller.getMultiBean().getShareData());
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
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
                    String str = controller.getMultiBean().getShareData();
                    Log.d("测试Binder时间", String.valueOf(System.currentTimeMillis() - time) + "  " + String.valueOf(System.currentTimeMillis()));
                    textView.setText(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
