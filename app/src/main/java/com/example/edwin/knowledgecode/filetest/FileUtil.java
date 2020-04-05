package com.example.edwin.knowledgecode.filetest;

import android.app.Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileUtil {

    public static File createFileinInternDir(String fileName, Application context) {
        String internPath = context.getFilesDir().getAbsolutePath();
        File file = new File(internPath + File.separator + fileName);
        boolean result = false;
        if (!file.exists()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = true;
        }

        return result ? file : null;
    }

    public static File createFileinExternDir(String fileName, Application context) {
        String internPath = context.getExternalFilesDir("").getAbsolutePath();
        File file = new File(internPath + File.separator + fileName);
        boolean result = false;
        if (!file.exists()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = true;
        }

        return result ? file : null;
    }

    /**
     * 这个就是把内存的对象转成字节码，io写盘到文件中
     * @param file
     * @param object
     */
    public static void writerObject(File file, Object object) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(object);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化时才是基于反射的
     * @param file
     * @return
     */
    public static Object readObject(File file) {
        Object o = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            o = inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * Parcelable是基于Android的，用于进程间通信，是将对象拆成Intent可以传输的小部分，然后去到另外个进程把对象组装起来
     * 基于内存组装和拆解，只能用于内存间传输，不能用于读写盘，因为不能保障进程间安全
     */
}
