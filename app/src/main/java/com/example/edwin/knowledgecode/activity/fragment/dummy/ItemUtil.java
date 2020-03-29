package com.example.edwin.knowledgecode.activity.fragment.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemUtil {

    public static List<FragmentListItem> getAndroidFunc() {
        ArrayList<FragmentListItem> list = new ArrayList<>();
        HashMap<String, Class<?>> androidfuncs = new HashMap<>();
        androidfuncs.put("android", null);
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
