package com.example.edwin.knowledgecode.filetest;

import android.app.Application;
import android.os.Environment;

import static android.content.Context.MODE_PRIVATE;

public class FilePathUtil {

    /**
     * 内部存储；也就是/data目录下面的， 和应用相关的也放在这里，可以创建文件时设置访问权限private这样其他的应用就访问不了
     * 如果没有设置，其他应用可以通过包名(反射出目标应用的Application类)来访问该应用目录的文件
     * 随应用卸载也跟着删除的，需要root权限才可以访问
     * @param context
     * @return
     */
    public static String getInternDataDirectory(Application context) {
        String path1 = Environment.getDataDirectory().getAbsolutePath();
        String path2 = context.getFilesDir().getAbsolutePath();
        String path3 = context.getCacheDir().getAbsolutePath();
        String path4 = context.getDir("myFile", MODE_PRIVATE).getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(path1).append(" ").append(path2).append(" ").append(path3).append(" ").append(path4).toString();
    }

    /**
     * 外部存储：/storage/emulated/0 这个目录下的，应用在外部存储的也放在这里
     * @param context
     * @return
     */
    public static String getExternDataDirectory(Application context) {
        String path1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        String path2 = Environment.getExternalStoragePublicDirectory("").getAbsolutePath();

        // 注意：4.4之前没插入sd卡返回null，4.4之后返回的是正确的
        String path3 = context.getExternalCacheDir().getAbsolutePath();
        String path4 = context.getExternalFilesDir("").getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(path1).append(" ").append(path2).append(" ").append(path3).append(" ").append(path4).toString();
    }

    /**
     * 清除缓存：我们知道应用程序在运行过程中需要经过很多过程，比如读入程序，计算，输入输出等等，这些过程中肯定会产生很多的数据，它们在内存中，以供程序运行时调用。所以清除缓存清除的是APP运行过程中所产生的临时数据。
     * 清除数据：清除数据才是真正的删除了我们保存在文件中的数据（永久性数据，如果不人为删除的话会一直保存在文件中）例如当我们在设置里面清除了某个应用的数据，那么/data/user/0/packname/和/storage/emulated/0/Android/data/packname/下的文件里面的数据会全部删除，包括cache，files，lib，shared_prefs等等
     */

    /**
     * 插件化资源文件的共享
     * 取对方进程的资源：得构造对方的Resources对象（这一步得先反射出对方的AssetManager（得拿到对方资源的目录路径）），且本地应用有相同名字的资源id
     */

    /**
     * SharedPreferences 在这个/data/data/应用程序包/shared_prefs，路径下
     * shareId相同可以访问到对方/data目录下的文件，包括share文件的访问，不过得创建文件时非私有才行
     */
}
