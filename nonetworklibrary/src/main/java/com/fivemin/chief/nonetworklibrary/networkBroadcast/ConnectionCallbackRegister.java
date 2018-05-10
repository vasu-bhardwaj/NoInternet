package com.fivemin.chief.nonetworklibrary.networkBroadcast;

/**
 * Created by chief on 3/3/18.
 */

public interface ConnectionCallbackRegister {

    void register(ConnectionCallback connectionCallback);

    void remove(ConnectionCallback connectionCallback);

    void notifycallback();

}
