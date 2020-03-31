// IInfoTran.aidl
package com.example.edwin.knowledgecode.process;

// Declare any non-default types here with import statements
import com.example.edwin.knowledgecode.process.Info;
interface IInfoTran {
    void sendInfo(inout Info info);
}
