package com.example.jni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JNIexample jni = new JNIexample();
        int res = jni.increment(5);
        Log.d("JNI_TAG", String.valueOf(res));
    }
}