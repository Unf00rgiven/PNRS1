//
// Created by Student on 6/13/2022.
//

#include "ognjen_stojisavljevic_memorygame_JNI.h"

JNIEXPORT jint JNICALL Java_ognjen_stojisavljevic_memorygame_JNI_increment(JNIEnv *env, jobject jobj, jint x)
{
    x += 5;
    return x;
}

JNIEXPORT jint JNICALL Java_ognjen_stojisavljevic_memorygame_JNI_decrement(JNIEnv *env, jobject jobj, jint x)
{
    return --x;
}