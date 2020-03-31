package com.example.edwin.knowledgecode.process;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.edwin.knowledgecode.R;

public class ProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        view = findViewById(R.id.tv_bind);
        findViewById(R.id.button_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService();
            }
        });
        findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info info = new Info();
                info.setData("啦啦啦啦啦");
                try {
                    mTran.sendInfo(new Info());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mTran = IInfoTran.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    IInfoTran mTran = null;

    private TextView view;

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction("com.example.edwin.knowledgecode.process.RemoteAppService");
        intent.setPackage("com.example.edwin.knowledgecode.process");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }
 }
