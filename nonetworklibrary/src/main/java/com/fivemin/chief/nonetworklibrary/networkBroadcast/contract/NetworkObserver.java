package com.fivemin.chief.nonetworklibrary.networkBroadcast.contract;

/**
 * Created by chief on 23/4/18.
 */

public interface NetworkObserver {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(ObserverRegister sub);
}
