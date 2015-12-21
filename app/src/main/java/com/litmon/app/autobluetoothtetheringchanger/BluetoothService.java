package com.litmon.app.autobluetoothtetheringchanger;

import android.app.Service;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BluetoothService extends Service implements BluetoothProfile.ServiceListener {
    Object instance;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        instance = BluetoothPanUtil.getInstance(this, this);
        return startId;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(instance != null) {
            BluetoothPanUtil.close(instance);
        }
    }

    @Override
    public void onServiceConnected(int profile, BluetoothProfile proxy) {
        if(instance != null) {
            BluetoothPanUtil.setTetheringOn(instance, true);
        }
    }

    @Override
    public void onServiceDisconnected(int profile) {
    }
}