package com.example.edwin.knowledgecode.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.edwin.knowledgecode.mulitprocess.IBeanController;
import com.example.edwin.knowledgecode.mulitprocess.MultiBean;

public class OtherProcessService extends Service {
    public OtherProcessService() {
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
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mBean.setShareData("服务端数据");
            Log.e("服务测试", "服务端设置了数据=====");
            return mBean;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Override
    public IBinder onBind(Intent intent) {
       return mBinder;
    }
}
