package com.fivemin.chief.nointernet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.contract.NoInternet;

public class MainActivity extends AppCompatActivity {
    NoInternet mNoInternet;

    @Override
    protected void onResume() {
        super.onResume();
        mNoInternet.RegisterReciver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNoInternet.UnRegisterReciver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNoInternet.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoInternet = new NoInternet();
    }


}
