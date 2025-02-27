
package com.example.lifecycledemo1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";

    //It holds a string value that represents the lifecycle state of an activity.
    private final MutableLiveData<String> lifecycleMessage = new MutableLiveData<>("");

    public LiveData<String> getLifecycleMessage() {
        return lifecycleMessage;
    }

    public void updateLifecycleMessage(String message) {
        lifecycleMessage.setValue(message);
        Log.d(TAG, "Lifecycle message updated: " + message);
    }
}

//ViewModel holds the data.