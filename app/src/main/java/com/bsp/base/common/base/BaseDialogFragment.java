package com.bsp.base.common.base;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.bsp.base.util.AndroidUtil;

public abstract class BaseDialogFragment extends DialogFragment {
    private final String TAG = this.getClass().getName();

    public void show(FragmentManager fragmentManager){
        show(fragmentManager, TAG);
    }

    protected void setupDialogWindow() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.requestFeature(Window.FEATURE_NO_TITLE);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window.setLayout((int) (AndroidUtil.displaySize.x * 0.9),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }
    }
}
