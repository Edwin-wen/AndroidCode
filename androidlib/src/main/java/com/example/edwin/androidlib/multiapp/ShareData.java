package com.example.edwin.androidlib.multiapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareData implements Parcelable {

    private String mData;

    public String getData() {
        return mData;
    }

    public void setData(String mData) {
        this.mData = mData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mData);
    }

    public void readFromParcel(Parcel reply) {
        this.mData = reply.readString();
    }

    public ShareData() {
    }

    protected ShareData(Parcel in) {
        this.mData = in.readString();
    }

    public static final Parcelable.Creator<ShareData> CREATOR = new Parcelable.Creator<ShareData>() {
        @Override
        public ShareData createFromParcel(Parcel source) {
            return new ShareData(source);
        }

        @Override
        public ShareData[] newArray(int size) {
            return new ShareData[size];
        }
    };
}
