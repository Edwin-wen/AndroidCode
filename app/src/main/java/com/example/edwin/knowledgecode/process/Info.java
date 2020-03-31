package com.example.edwin.knowledgecode.process;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data);
    }

    public void readFromParcel(Parcel reply) {
        this.data = reply.readString();
    }

    public Info() {
    }

    protected Info(Parcel in) {
        this.data = in.readString();
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel source) {
            return new Info(source);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}

