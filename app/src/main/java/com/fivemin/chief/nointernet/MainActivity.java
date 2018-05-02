package com.fivemin.chief.nointernet;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.ConnectionCallback;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.NetworkMonitor;


public class MainActivity extends AppCompatActivity implements ConnectionCallback {
    final String TAG = "MainActivity";
    private NetworkMonitor mNetworkMonitor;

    @Override
    public void Networkupdate(boolean isConnectionActive) {
        if (!isConnectionActive) {
            Log.d(TAG, "No network Connectivity");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mNetworkMonitor == null) {
            mNetworkMonitor = new NetworkMonitor();
        }
    }

    @Override
    protected void onResume() {


        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkMonitor, intentFilter);
        mNetworkMonitor.register(this);


        super.onResume();
    }

    @Override
    protected void onPause() {

        unregisterReceiver(mNetworkMonitor);
        mNetworkMonitor.remove(this);


        super.onPause();
    }
}
