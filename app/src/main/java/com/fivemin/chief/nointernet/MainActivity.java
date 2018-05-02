package com.fivemin.chief.nointernet;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.ConnectionCallback;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.DefaultNoNet;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.NetworkMonitor;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.Notify;


public class MainActivity extends AppCompatActivity implements ConnectionCallback {
    final String TAG = "MainActivity";
    Notify mNotify;
    private boolean connectionStatus = true;
    private NetworkMonitor mNetworkMonitor;

    @Override
    public void Networkupdate(boolean isConnectionActive) {
        if (!isConnectionActive) {
            Log.d(TAG, "No network Connectivity");
            connectionStatus = isConnectionActive;
            showEditDialog();
        } else {
            this.connectionStatus = isConnectionActive;
        }
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DefaultNoNet editNameDialogFragment = DefaultNoNet.newInstance();
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mNetworkMonitor == null) {
            mNetworkMonitor = new NetworkMonitor();
            mNotify = new Notify();
            mNotify.Notification("test", "asda", R.drawable.close_cross);
        }

    }

    @Override
    protected void onResume() {

        mNotify.unregister(this);

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkMonitor, intentFilter);
        mNetworkMonitor.register(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        boolean a = false;
        mNotify.register(this, connectionStatus);
        unregisterReceiver(mNetworkMonitor);
        mNetworkMonitor.remove(this);
        super.onPause();
    }
}
