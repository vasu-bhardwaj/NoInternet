package com.fivemin.chief.nointernet;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.NetworkReceiver;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.contract.NetworkObserver;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.contract.ObserverRegister;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(new NetworkReceiver() , intentFilter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
