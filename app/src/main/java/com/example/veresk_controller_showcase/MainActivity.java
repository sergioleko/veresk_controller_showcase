package com.example.veresk_controller_showcase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    String inputAddress;
    TextInputLayout stationAddressIL;
    InetAddress stationAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        stationAddressIL = findViewById(R.id.stationAdddressInput);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startConnection(View view) throws IOException {

        inputAddress = stationAddressIL.getEditText().getText().toString();

        final WifiManager wfm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        if (wfm != null && wfm.isWifiEnabled()){
            stationAddress = InetAddress.getByName(inputAddress);
            findViewById(R.id.stationAdddressInput).setVisibility(View.INVISIBLE);
            findViewById(R.id.connectionButton).setVisibility(View.INVISIBLE);

            if (stationAddress.isReachable(1000)){

            }
            else {
                Toast.makeText(this, "Station unreachable", Toast.LENGTH_LONG).show();
            }

        }

        else {
            Toast.makeText(this, "Wi-Fi error", Toast.LENGTH_LONG).show();
        }
    }
}