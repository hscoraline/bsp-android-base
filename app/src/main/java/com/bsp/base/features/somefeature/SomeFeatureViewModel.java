package com.bsp.base.features.somefeature;

import android.app.Application;

import androidx.annotation.NonNull;

import com.bsp.base.features.base.BaseViewModel;

public class SomeFeatureViewModel extends BaseViewModel {

    private String someData;

    public SomeFeatureViewModel(@NonNull Application application) {
        super(application);
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }
}
