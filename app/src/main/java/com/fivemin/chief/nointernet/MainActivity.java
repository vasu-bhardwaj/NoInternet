package com.fivemin.chief.nointernet;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.NoNet;


public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
    FragmentManager fm = null;
    //  DefaultNoNet defaultNoNet = null;
    NoNet mNoNet;
    //  private NetworkMonitor mNetworkMonitor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        mNoNet = new NoNet();
        mNoNet.initNoNet(this, fm);
    }

    @Override
    protected void onResume() {
        mNoNet.RegisterNoNet();
        super.onResume();
    }

    @Override
    protected void onPause() {

        mNoNet.unRegisterNoNet();
        super.onPause();
    }
}
