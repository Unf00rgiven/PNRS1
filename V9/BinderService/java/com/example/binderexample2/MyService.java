package com.example.binderexample2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public Binder binder = null;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (binder == null) {
            binder = new Binder();
        }

        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        binder.stop();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binder = null;
    }
}