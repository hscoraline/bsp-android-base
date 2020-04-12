package com.bsp.base.features.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bsp.base.common.dialog.LoadingDialog;

public abstract class BaseActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showSystemUI();
    }

    public void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        decorView.setBackgroundColor(Color.WHITE);
    }

    private Boolean isLoadingShowing() {
        return loadingDialog != null && loadingDialog.getDialog() != null
                && loadingDialog.getDialog().isShowing();
    }

    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog();
        }
        if (isLoadingShowing()) {
            return;
        }
        loadingDialog.show(getSupportFragmentManager());
    }

    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
