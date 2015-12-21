package com.litmon.app.autobluetoothtetheringchanger;

import android.bluetooth.BluetoothProfile;
import android.content.Context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fukuo on 西暦15/12/22.
 */

class BluetoothPanUtil {

    private final static String CLASS_NAME = "android.bluetooth.BluetoothPan";

    private static Class<?> bluetoothPan;
    private static Constructor<?> constructor;

    public static Class<?> getKlass() {
        if (bluetoothPan == null) {
            try {
                bluetoothPan = Class.forName(CLASS_NAME);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return bluetoothPan;
    }

    public static Constructor<?> getConstructor() {
        if (constructor == null) {
            try {
                constructor = getKlass().getDeclaredConstructor(Context.class, BluetoothProfile.ServiceListener.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            constructor.setAccessible(true);
        }

        return constructor;
    }

    public static Object getInstance(Context context, BluetoothProfile.ServiceListener listener) {
        try {
            return getConstructor().newInstance(context, listener);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void setTetheringOn(Object instance, boolean isTetheringOn) {
        try {
            Method method = getKlass().getDeclaredMethod("setBluetoothTethering", boolean.class);
            method.invoke(instance, isTetheringOn);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static boolean isTetherinOn(Object instance) {
        try {
            Method method = getKlass().getDeclaredMethod("isTetheringOn");
            return (boolean) method.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void close(Object instance) {
        try {
            Method method = getKlass().getDeclaredMethod("close");
            method.invoke(instance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}