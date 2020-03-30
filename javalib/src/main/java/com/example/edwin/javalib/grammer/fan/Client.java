package com.example.edwin.javalib.grammer.fan;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        IntFan fan = new IntFan();
        IntFan.showStaticData("staaaa");

        List<? super Base> list = new ArrayList<>();
        List<? extends Base> list1 = new ArrayList<>();
        ParentBase parentBase = new ParentBase();
        SonBase sonBase = new SonBase();
        list.add(parentBase);
        list1.add(sonBase);

        Test<SonBase> test = new Test<>();
        Test<ParentBase> test1 = new Test<>();
    }
}
