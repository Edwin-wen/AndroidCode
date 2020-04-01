package com.example.edwin.knowledgecode.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.edwin.androidlib.multiapp.IDataChanel;
import com.example.edwin.androidlib.multiapp.ShareData;

public class OtherProcessService extends Service {
    public OtherProcessService() {
    }

    private IBinder mBinder = new IDataChanel.Stub() {
        @Override
        public void setShareData(ShareData data) throws RemoteException {

        }

        @Override
        public ShareData getShareData() throws RemoteException {
            ShareData data = new ShareData();
            data.setData("阻塞3秒的数据");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return data;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
       return mBinder;
    }
}
