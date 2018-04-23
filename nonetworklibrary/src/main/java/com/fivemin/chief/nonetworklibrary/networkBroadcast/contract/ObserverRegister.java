package com.fivemin.chief.nonetworklibrary.networkBroadcast.contract;

/**
 * Created by chief on 23/4/18.
 */
// SUBJECT
public interface ObserverRegister {

    public void registerObserver(NetworkObserver observer);
    public void removeObserver(NetworkObserver observer);
    public void notifyObservers();
}
