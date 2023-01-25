package com.example.binderexample2;

import android.os.RemoteException;
import android.util.Log;

public class Binder extends IBinderInterface.Stub {

    private int value;
    private boolean mRun = true;

    @Override
    public void setValue(int value) throws RemoteException {
        this.value = value;
    }

    @Override
    public int getValue() throws RemoteException {
        return value;
    }

    @Override
    public void sendMessage() throws RemoteException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mRun) {
                    try {
                        Log.d("ServiceTAG", "Hello from service");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void stop() {
        mRun = false;
    }
}
