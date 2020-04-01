package com.example.edwin.knowledgecode.main;

import com.example.edwin.knowledgecode.filetest.FileTestActivity;
import com.example.edwin.knowledgecode.main.fragment.dummy.FragmentListItem;
import com.example.edwin.knowledgecode.multiapp.ClientActivity;
import com.example.edwin.knowledgecode.servicetest.ServiceTestActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemUtil {

    public static List<FragmentListItem> getAndroidFunc() {
        ArrayList<FragmentListItem> list = new ArrayList<>();
        HashMap<String, Class<?>> androidfuncs = new HashMap<>();
        androidfuncs.put("文件写入测试", FileTestActivity.class);
        androidfuncs.put("多进程通信测试", ClientActivity.class);
        androidfuncs.put("服务Service测试", ServiceTestActivity.class);
        for (Map.Entry<String, Class<?>> entry : androidfuncs.entrySet()) {
            FragmentListItem item = new FragmentListItem(entry.getKey(), entry.getValue());
            list.add(item);
        }
        return list;
    }

    public static List<FragmentListItem> getJavaFunc() {
        ArrayList<FragmentListItem> list = new ArrayList<>();
        HashMap<String, Class<?>> javaFuncs = new HashMap<>();
        javaFuncs.put("java", null);
        for (Map.Entry<String, Class<?>> entry : javaFuncs.entrySet()) {
            FragmentListItem item = new FragmentListItem(entry.getKey(), entry.getValue());
            list.add(item);
        }
        return list;
    }
}
