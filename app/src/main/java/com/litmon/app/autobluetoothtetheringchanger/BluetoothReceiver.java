package com.litmon.app.autobluetoothtetheringchanger;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("onReceive", "Action: " + action);

//         Intent serviceIntent = new Intent(context, TetheringManipulationService.class);

//        switch (action) {
//            case BluetoothDevice.ACTION_ACL_CONNECTED:
//            case BluetoothDevice.ACTION_FOUND:
//            case BluetoothDevice.ACTION_PAIRING_REQUEST:
//        }
//
//        if (action.equals(BluetoothDevice.ACTION_ACL_CONNECTED)) {
//            serviceIntent.putExtra("setBluetoothTethering", true);
//        }

//         Log.d("onReceive", "TetheringManipulationService running.");
//         context.startService(serviceIntent);
    }
}
