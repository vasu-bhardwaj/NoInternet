package com.fivemin.chief.nonetworklibrary.networkBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by chief on 3/3/18.
 */

public class NetworkMonitor extends BroadcastReceiver implements ConnectionCallbackRegister {
    private final String TAG = "NetworkMonitor";
    private boolean isConnectionActive;
    private ArrayList<ConnectionCallback> mCallbackArrayList = null;
    private ConnectivityManager connectivityManager = null;
    private int Index;

    public NetworkMonitor() {
        if (mCallbackArrayList == null) {
            mCallbackArrayList = new ArrayList<>(1);
         } else if (mCallbackArrayList.size() <= 0) {
         }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {

            if (connectivityManager == null) {
                connectivityManager = (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);
            }

            assert connectivityManager != null;
            final NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

            if (activeNetwork != null && activeNetwork.isConnected()) {
                isConnectionActive = true;
                Log.d(TAG, "Network  connected");
                notifycallback();
            } else // Network is not connected
            {
                isConnectionActive = false;
                Log.d(TAG, "Network  not connected");
                notifycallback();
            }

        }
    }


    @Override
    public void register(ConnectionCallback connectionCallback) {
        Log.d(TAG, "register" + Integer.toString(mCallbackArrayList.size()));
        mCallbackArrayList.add(connectionCallback);
        Log.d(TAG, "after register" + Integer.toString(mCallbackArrayList.size()));
    }

    @Override
    public void remove(ConnectionCallback connectionCallback) {
        Log.d(TAG, "Unregister" + Integer.toString(mCallbackArrayList.size()));
        Index = mCallbackArrayList.indexOf(connectionCallback);
        mCallbackArrayList.remove(Index);
        Log.d(TAG, "after Unregister" + Integer.toString(mCallbackArrayList.size()));
    }

    @Override
    public void notifycallback() {
        mCallbackArrayList.get(0).Networkupdate(isConnectionActive);
    }
}
