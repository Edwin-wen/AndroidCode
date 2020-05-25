package com.example.edwin.knowledgecode.kotlin

import android.widget.TextView

class KTest(args: Int) {

    val mInt = 100;

    val mList = ArrayList<Int>();

    val mMap = HashMap<String, Int>();

    val mSet = HashSet<Int>();

    var mMuteableString: String
        get() {
            return mMuteableString
        }
        @Synchronized
        set(value) {
            synchronized(mInt) {

            }
        }

    init {

    }

    @Synchronized
    fun testPrintInt(intArgs: Int, str: String): String{
        print(intArgs)
        print(str)
        return intArgs.toString() + str
    }

    companion object {
        fun method() {
            synchronized(KTest.javaClass) {

            }
        }

    }



}

class K2Test{
    val test = KTest(111)

    fun show() {
        KTest.method();
    }

    fun simpleTest() {
        val data = KTest(1000)
        val k2Test = K2Test()
        data.mMuteableString = "aaa";
        val textView = findViewById<TextView>(R.id.m_tv)
        textView.text = data.testPrintInt(100, "aaaa")
    }
}