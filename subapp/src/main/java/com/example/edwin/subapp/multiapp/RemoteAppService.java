package com.example.edwin.subapp.multiapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.edwin.androidlib.multiapp.IDataChanel;
import com.example.edwin.androidlib.multiapp.ShareData;

public class RemoteAppService extends Service {
    public RemoteAppService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return new RemoteBinder();
    }

    private static class RemoteBinder extends IDataChanel.Stub {

        private ShareData mData = null;

        @Override
        public void setShareData(ShareData data) throws RemoteException {
            mData = data;
            Log.d("多进程测试", "服务端收到客户端数据：" + data.getData());
        }

        @Override
        public ShareData getShareData() throws RemoteException {
            if (mData == null) {
                mData = new ShareData();
                mData.setData("this is data from service");
            }
            return mData;
        }
    }
}
