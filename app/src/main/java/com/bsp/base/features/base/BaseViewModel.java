package com.bsp.base.features.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> loadingEvent = new MutableLiveData<>();

    private MutableLiveData<String> errorEvent = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    protected void showLoading() {
        loadingEvent.setValue(true);
    }

    protected void hideLoading() {
        loadingEvent.setValue(false);
    }

    protected void showError(String message){
        errorEvent.setValue(message);
    }

    public LiveData<Boolean> onLoadingEvent() {
        return loadingEvent;
    }

    public LiveData<String> onErrorEvent(){
        return errorEvent;
    }

}
