package com.fivemin.chief.nonetworklibrary.networkBroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.fivemin.chief.nonetworklibrary.R;

/**
 * Created by chief on 2/5/18.
 */

public class DefaultNoNet extends DialogFragment {


    private Button notify, settings;
    private ImageView close;

    public DefaultNoNet() {
    }

    public static DefaultNoNet newInstance() {
        DefaultNoNet frag = new DefaultNoNet();
        frag.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.no_net_default, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get Buttons from view
        notify = view.findViewById(R.id.RetryBtn);
        settings = view.findViewById(R.id.settingsBtn);

        close = view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWifiSettings();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMobileData();
            }
        });

    }

    private void openWifiSettings() {
        startActivity(
                new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    private void openMobileData() {
        startActivity(
                new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
    }


}
