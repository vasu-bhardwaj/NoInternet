package com.fivemin.chief.nonetworklibrary.networkBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.contract.NetworkObserver;
import com.fivemin.chief.nonetworklibrary.networkBroadcast.contract.ObserverRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for code that receives and handles broadcast intents sent by
 * {@link BroadcastReceiver}.
 * <p>
 * //TODO UPDATE THE DOC
 * <p>You can either dynamically register an instance of this class with
 * {@link Context#registerReceiver Context.registerReceiver()}
 * or statically declare an implementation with the
 * {@link android.R.styleable#AndroidManifestReceiver &lt;receiver&gt;}
 * tag in your <code>AndroidManifest.xml</code>
 *
 * </p>
 */

public class NetworkReceiver extends BroadcastReceiver implements ObserverRegister {

    private ArrayList<NetworkObserver> observers = new ArrayList<NetworkObserver>();

    @Override
    public void registerObserver(NetworkObserver observer) {

    }

    @Override
    public void removeObserver(NetworkObserver observer) {

    }

    @Override
    public void notifyObservers() {

    }

    boolean oneTime = false;
    private String TAG = "NetworkRecevier";
    private ConnectivityManager connectivityManager = null;
    private NetworkInfo networkInfo = null;
    private boolean isNetworkActive = true;


    @Override
    public void onReceive(Context context, Intent intent) {
        connectivityManager = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        isNetworkActive = networkInfo != null && networkInfo.isConnected();
        init();
    }

    void init() {
        // to make sure list is only allocated ones.
        if (!oneTime) {
            Log.d(TAG, "List Allocated");
        }
        oneTime = true;
    }
}

