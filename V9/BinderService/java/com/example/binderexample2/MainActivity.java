package com.example.binderexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ServiceConnection,
        View.OnClickListener {

    private IBinderInterface binder;
    public static final String TAG = "ServiceTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bind).setOnClickListener(this);
        findViewById(R.id.get).setOnClickListener(this);
        findViewById(R.id.set).setOnClickListener(this);
        findViewById(R.id.unbind).setOnClickListener(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder = IBinderInterface.Stub.asInterface(iBinder);
        try {
            binder.sendMessage();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        binder = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind:
                Intent intent = new Intent(MainActivity.this, MyService.class);
                if (bindService(intent, MainActivity.this, BIND_AUTO_CREATE)) {
                    Log.d(TAG, "Bind successful");
                } else {
                    Log.d(TAG, "Bind failed!");
                }
                break;
            case R.id.set:
                try {
                    binder.setValue(55);
                    Log.d(TAG, "Value set to 55");
                } catch (NullPointerException e) {
                    Log.d(TAG, "Binder is null!");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.get:
                try {
                    int val = binder.getValue();
                    Log.d(TAG, "Value is: " + val);
                } catch (NullPointerException e) {
                    Log.d(TAG, "Binder is null!");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.unbind:
                if (binder != null) {
                    Log.d(TAG, "Unbind!");
                    unbindService(MainActivity.this);
                    binder = null;
                }
                break;
            default:
                Log.d(TAG, "Another button");
        }
    }
}