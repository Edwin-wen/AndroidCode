// IBeanController.aidl
package com.example.edwin.androidlib;

import com.example.edwin.androidlib.MultiBean;
// Declare any non-default types here with import statements
interface IBeanController {

    void setMultiBean(inout MultiBean bean);

    MultiBean getMultiBean();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


}
