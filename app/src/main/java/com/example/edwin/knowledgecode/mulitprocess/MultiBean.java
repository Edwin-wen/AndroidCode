package com.example.edwin.knowledgecode.mulitprocess;

import android.os.Parcel;
import android.os.Parcelable;

public class MultiBean implements Parcelable {

    private String shareData;
    private int    shareIndex  = 100;

    public MultiBean(String shareData) {
        this.shareData = shareData;
    }

    public String getShareData() {
        return shareData;
    }

    public void setShareData(String shareData) {
        this.shareData = shareData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.shareData);
        dest.writeInt(this.shareIndex);
    }

    public void readFromParcel(Parcel reply) {
        this.shareIndex = reply.readInt();
        this.shareData = reply.readString();
    }

    protected MultiBean(Parcel in) {
        this.shareData = in.readString();
        this.shareIndex = in.readInt();
    }

    public static final Creator<MultiBean> CREATOR = new Creator<MultiBean>() {
        @Override
        public MultiBean createFromParcel(Parcel source) {
            return new MultiBean(source);
        }

        @Override
        public MultiBean[] newArray(int size) {
            return new MultiBean[size];
        }
    };
}
