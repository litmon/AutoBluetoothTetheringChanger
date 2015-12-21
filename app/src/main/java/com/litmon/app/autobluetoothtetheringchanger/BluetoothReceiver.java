package com.litmon.app.autobluetoothtetheringchanger;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BluetoothReceiver", "onStateChanged");

        switch (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF)) {
            case BluetoothAdapter.STATE_ON:
            case BluetoothAdapter.STATE_TURNING_ON:
                Log.d("BluetoothReceiver", "STATE_ON");
                context.startService(new Intent(context, BluetoothService.class));
                break;
        }
    }
}