package com.bsp.base.common.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bsp.base.common.base.BaseDialogFragment;
import com.bsp.base.databinding.DialogLoadingBinding;

public class LoadingDialog extends BaseDialogFragment {

    private DialogLoadingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogLoadingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void setupDialogWindow() {
        super.setupDialogWindow();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }
        setCancelable(false);
    }
}
