package com.example.edwin.knowledgecode.filetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.edwin.knowledgecode.R;

import java.io.File;

public class FileTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
        testFileAndSeriable();

    }

    private void testFileAndSeriable() {
        Log.d("应用路径-内部", FilePathUtil.getInternDataDirectory(getApplication()));
        Log.d("应用路径-外部", FilePathUtil.getExternDataDirectory(getApplication()));
        File file = FileUtil.createFileinExternDir("SeriableText", getApplication());
        FileUtil.writerObject(file, new SeriableClass());
        SeriableClass object = (SeriableClass) FileUtil.readObject(file);
        object.print();
    }
}
