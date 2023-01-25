//
// Created by Student on 6/6/2022.
//

#include "com_example_jni_JNIexample.h"

JNIEXPORT jint JNICALL Java_jniexample_JNIexample_increment(JNIEnv * env, jobject jobj, jint x){

    return ++x;

}