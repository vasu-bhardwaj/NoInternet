package com.fivemin.chief.nonetworklibrary.networkBroadcast.contract;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.NetworkReceiver;

/**
 * This class is used to register and unregister broadcast and finish
 */

public class NoInternet {
    final String TAG = "NoInternet";
    NetworkReceiver mReceiver = null;
    Context mContext = null;

    public void RegisterReciver(Context context) {
        if (mReceiver == null) {
            mReceiver = new NetworkReceiver();
            Log.d(TAG, "Object Created");
        }
        if (mContext == null) {
            this.mContext = context;
            Log.d(TAG, "Context Object Created");
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mContext.registerReceiver(mReceiver, intentFilter);
        Log.d(TAG, "BORADCAST REGISTER");
    }

    public void UnRegisterReciver() {
        mContext.unregisterReceiver(mReceiver);
        Log.d(TAG, "BORADCAST UNREGISTER");
    }

    public void finish() {
        mContext = null;
        mReceiver = null;
        Log.d(TAG, "Finish Object Null");
    }
}
