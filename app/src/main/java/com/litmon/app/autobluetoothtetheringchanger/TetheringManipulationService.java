package com.litmon.app.autobluetoothtetheringchanger;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TetheringManipulationService extends Service {
    Class<?> bluetoothPan;
    Constructor<?> ctor;
    Object instance;
    Class[] paramSet = { boolean.class };
    Method setTetheringOn;
    boolean isTetheringOn;
    BluetoothAdapter adapter;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isTetheringOn = intent.getBooleanExtra("setBluetoothTethering", true);

        try {
            bluetoothPan = Class.forName("android.bluetooth.BluetoothPan");

            ctor = bluetoothPan.getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class);
            setTetheringOn = bluetoothPan.getDeclaredMethod("setBluetoothTethering", paramSet);

            ctor.setAccessible(true);
            instance = ctor.newInstance(this, new BluetoothServiceListener(this));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return startId;
    }

    private class BluetoothServiceListener implements BluetoothProfile.ServiceListener {
        // なぜかないと上手くいかない
        final Context context;

        public BluetoothServiceListener(Context context) {
            this.context = context;
        }

        @Override
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            try {
                setTetheringOn.invoke(instance, isTetheringOn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(int profile) {
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
