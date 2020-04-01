// IDataChanel.aidl
package com.example.edwin.androidlib.multiapp;

import com.example.edwin.androidlib.multiapp.ShareData;
interface IDataChanel {

    void setShareData(inout ShareData data);
    ShareData getShareData();
}
