// IBinderInterface.aidl
package com.example.binderexample2;

// Declare any non-default types here with import statements

interface IBinderInterface {
    void setValue(int value);
    int getValue();
    void sendMessage();
}