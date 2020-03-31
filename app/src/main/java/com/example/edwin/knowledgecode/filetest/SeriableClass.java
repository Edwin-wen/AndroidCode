package com.example.edwin.knowledgecode.filetest;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;

public class SeriableClass implements Serializable {

    transient private String password = "aaasddd";

    private String info = "qqqqqqq";

    private HashMap<String, Integer> map = new HashMap<>();

    public SeriableClass() {
        map.put("bbb", 100);
        map.put("ccc", 200);
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(password).append("--").append(info).append("--");
        for (HashMap.Entry entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append("*").append(entry.getValue());
        }
        Log.e("测试对象", stringBuilder.toString());
    }
}
