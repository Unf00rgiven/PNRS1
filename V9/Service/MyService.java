package com.example.servis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    Nit nit = new Nit();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class Nit extends Thread{

        private boolean fleg = true;

        @Override
        public synchronized void start() {
            super.start();
            fleg = true;
        }

        @Override
        public void run() {
//            super.run();

            while(fleg){
                Log.d("ServiceExample", "Hello from thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void exit() {
            fleg = false;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nit.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        nit.exit();
    }
}