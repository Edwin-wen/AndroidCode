package com.example.edwin.knowledgecode.mulitprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MultiProcessService extends Service {
    public MultiProcessService() {
    }

    private IBinder mBinder = new IBeanController.Stub() {

        private MultiBean mBean = null;

        @Override
        public void setMultiBean(MultiBean bean) throws RemoteException {
            mBean = bean;
        }

        @Override
        public MultiBean getMultiBean() throws RemoteException {
            if (mBean == null) {
                mBean = new MultiBean("aaa");
            }
            mBean.setShareData("服务端数据");
            Log.e("多进程测试", "服务端设置了数据=====");
            return mBean;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("多进程测试","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("多进程测试","onBind");
        return mBinder;
    }
}
