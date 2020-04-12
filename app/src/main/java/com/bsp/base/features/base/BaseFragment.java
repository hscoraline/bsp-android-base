package com.bsp.base.features.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private BaseActivity baseActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            baseActivity = (BaseActivity) context;
        } catch (ClassCastException exception) {
            throw new ClassCastException("Activity holder must extend SPBaseActivity");
        }
    }

    protected void handleLoading(boolean isShow){
        if(isShow){
            showLoading();
        }else{
            hideLoading();
        }
    }

    protected void showLoading() {
        baseActivity.showLoading();
    }

    protected void hideLoading() {
        baseActivity.hideLoading();
    }

    protected void showToast(String message){
        baseActivity.showToast(message);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        baseActivity = null;
    }
}
