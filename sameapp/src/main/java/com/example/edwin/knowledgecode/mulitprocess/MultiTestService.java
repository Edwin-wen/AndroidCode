package com.example.edwin.knowledgecode.mulitprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.edwin.knowledgecode.sameapp.MultiTest;

public class MultiTestService extends Service {
    public MultiTestService() {
    }

    private static class MyBinder extends MultiTest.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.d("MultiTestService", "basicTypes=======");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MultiTestService", "onBind=======");
        return new MyBinder();
    }
}
