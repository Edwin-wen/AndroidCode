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

    public static void writerObject(File file, Object object) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(object);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
