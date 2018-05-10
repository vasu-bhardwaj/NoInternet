package com.fivemin.chief.nonetworklibrary.networkBroadcast;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by chief on 3/5/18.
 */

public class NoNet implements ConnectionCallback {
    private static int count;
    private static boolean isAlreadyShown = false;
    final String TAG = "NoNet";
    private DefaultNoNet mDefaultNoNet;
    private Context context;
    private NetworkMonitor mNetworkMonitor;
    private FragmentManager fm;
    private IntentFilter intentFilter;

    @Override
    public void Networkupdate(boolean isConnectionActive) {
        if (!isConnectionActive) {
            Log.d(TAG, "No network Connectivity");
            showDefaultDialog();
            count++;
        } else {
            Log.d(TAG, "network Connectivity is present");
            hideDefaultDialog();
        }
    }

    private void showDefaultDialog() {
        if (!isAlreadyShown) {
            mDefaultNoNet.show(fm, "nonetDefault");
            isAlreadyShown = true;
            Log.d(TAG, "Showing Dialog");
        }
    }

    private void hideDefaultDialog() {
        if (count > 0) {
            while (count >= 0) {
                mDefaultNoNet.dismiss();
                count--;
            }
            isAlreadyShown = false;
            Log.d(TAG, "Dismissing Dialog");
        }
    }

    public void RegisterNoNet() {
        context.registerReceiver(mNetworkMonitor, intentFilter);
        mNetworkMonitor.register(this);
    }

    public void initNoNet(Context context, FragmentManager fragmentManager) {
        if (mNetworkMonitor == null) {
            mNetworkMonitor = new NetworkMonitor();
            this.context = context;
            this.fm = fragmentManager;
            intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            mDefaultNoNet = DefaultNoNet.newInstance();
        }
    }

    public void unRegisterNoNet() {
        context.unregisterReceiver(mNetworkMonitor);
        mNetworkMonitor.remove(this);
    }
}