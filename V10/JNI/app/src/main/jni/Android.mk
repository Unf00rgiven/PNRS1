LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := MyLibrary
LOCAL_SRC_FILES := com_example_jni_JNIexample.cpp
include $(BUILD_SHARED_LIBRARY)