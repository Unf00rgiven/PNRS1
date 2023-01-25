package com.example.jni;

public class JNIexample {
    static {
        System.loadLibrary("MyLibrary");
    }

    public native int increment(int x);
}
