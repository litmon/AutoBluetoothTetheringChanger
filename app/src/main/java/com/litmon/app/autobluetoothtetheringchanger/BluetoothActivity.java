package com.litmon.app.autobluetoothtetheringchanger;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by fukuo on 西暦15/12/22.
 */
public class BluetoothActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "アプリを起動しました！", Toast.LENGTH_SHORT).show();
        finish();
    }
}
