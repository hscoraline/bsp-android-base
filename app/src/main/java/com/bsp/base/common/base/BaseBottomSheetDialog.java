package com.bsp.base.common.base;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

public abstract class BaseBottomSheetDialog extends BottomSheetDialogFragment {
    private final String TAG = this.getClass().getName();

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, TAG);
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(dialogInterface -> {
            FrameLayout bottomSheet = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        return dialog;
    }
}
