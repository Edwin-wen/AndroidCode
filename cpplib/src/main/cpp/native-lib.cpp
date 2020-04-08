#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_edwin_cpluslib_CppMainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

/**
 * 静态注册 写完全名的
 */
extern "C" JNIEXPORT void JNICALL
Java_com_example_edwin_cpluslib_CppMainActivity_setStringToJNI(
        JNIEnv* env,
        jobject /* this */) {
}

/**
 * 动态注册
 */
extern "C" JNIEXPORT jstring JNICALL
native_getString(JNIEnv *env, jobject /* this */) {
    std::string hello = "哈哈哈哈哈";
    return env->NewStringUTF(hello.c_str());
}

/**
 * 对应java类的全路径名，.用/代替
 */
const char *classPathName = "com/example/edwin/cpluslib/CppMainActivity";

/**
 * JNINativeMethod 结构体的数组
 * 结构体参数1：对应java类总的native方法
 * 结构体参数2：对应java类总的native方法的描述信息，用javap -s xxxx.class 查看
 * 结构体参数3：c/c++ 种对应的方法名
 */
JNINativeMethod method[] = {{"getString", "()Ljava/lang/String;", (void *) native_getString}};

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    //定义 JNIEnv 指针
    JNIEnv *env = NULL;
    //获取 JNIEnv
    vm->GetEnv((void **) &env, JNI_VERSION_1_6);
    //获取对应的java类
    jclass clazz = env->FindClass(classPathName);
    //注册native方法
    env->RegisterNatives(clazz, method, 1);
    //返回Jni 的版本
    return JNI_VERSION_1_6;
}



