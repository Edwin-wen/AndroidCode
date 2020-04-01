package com.example.edwin.knowledgecode.multiapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.edwin.androidlib.multiapp.IDataChanel;
import com.example.edwin.androidlib.multiapp.ShareData;
import com.example.edwin.knowledgecode.R;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String REMOTE_PROCESSNAME = "com.example.edwin.subapp";
    private final static String COMMPONET_NAME = "com.example.edwin.subapp.multiapp.RemoteAppService";

    private ClientConnection connection = new ClientConnection();
    private TextView textView = null;
    private IDataChanel mChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        findViewById(R.id.bind_remote).setOnClickListener(this);
        findViewById(R.id.send_data).setOnClickListener(this);
        findViewById(R.id.get_data).setOnClickListener(this);
        textView = findViewById(R.id.data_show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bind_remote:
                bindRemoteService();
                break;
            case R.id.send_data:
                ShareData data = new ShareData();
                data.setData("Client data");
                try {
                    mChannel.setShareData(data);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.get_data:
                try {
                    String string = mChannel.getShareData().getData();
                    textView.setText(string);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void bindRemoteService() {
        Intent intent = new Intent();
        ComponentName name = new ComponentName(REMOTE_PROCESSNAME, COMMPONET_NAME);
        intent.setComponent(name);
        boolean result = bindService(intent, connection, BIND_AUTO_CREATE);
        if(!result) {
            throw new RuntimeException("远程服务绑定失败");
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        connection = null;
        mChannel = null;
        super.onDestroy();
    }

    private class ClientConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mChannel = IDataChanel.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            throw new RuntimeException("远程调用服务失败");
        }
    }
}
