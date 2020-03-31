package com.example.edwin.knowledgecode.process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteAppService extends Service {
    public RemoteAppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        String str = "aaa";
        return new MyBinder();
    }

    class MyBinder extends IInfoTran.Stub {

        @Override
        public void sendInfo(Info info) throws RemoteException {
            String string = info.getData();
        }
    }
}
