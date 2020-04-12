package com.bsp.base.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

@SuppressWarnings({"WeakerAccess", "unused"})
public class AndroidUtil {

    private static float density = Resources.getSystem().getDisplayMetrics().density;
    private static Handler applicationHandler;

    public static Point displaySize = new Point();
    private static DisplayMetrics displayMetrics = new DisplayMetrics();

    public static void init(Context applicationContext) {
        applicationHandler = new Handler(applicationContext.getMainLooper());
        density = applicationContext.getResources().getDisplayMetrics().density;
        updateScreenSize(applicationContext);
    }

    private static void updateScreenSize(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (manager != null) {
            Display display = manager.getDefaultDisplay();
            if (display != null) {
                display.getMetrics(displayMetrics);
                display.getSize(displaySize);
            }
        }
        if (configuration.screenWidthDp != Configuration.SCREEN_WIDTH_DP_UNDEFINED) {
            int newSize = (int) (configuration.screenWidthDp * density);
            if (Math.abs(displaySize.x - newSize) > 3) {
                displaySize.x = newSize;
            }
        }
        if (configuration.screenHeightDp != Configuration.SCREEN_HEIGHT_DP_UNDEFINED) {
            int newSize = (int) (configuration.screenHeightDp * density);
            if (Math.abs(displaySize.y - newSize) > 3) {
                displaySize.y = newSize;
            }
        }
    }

    public static int dpToPx(int dp) {
        return (int) (dp * density);
    }

    public static float dpToPx(float dp) {
        return dp * density;
    }

    public static void runOnUIThread(Runnable runnable) {
        runOnUIThread(runnable, 0);
    }

    public static void runOnUIThread(Runnable runnable, long delay) {
        if (delay == 0L) {
            applicationHandler.post(runnable);
        } else {
            applicationHandler.postDelayed(runnable, delay);
        }
    }

    public static void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm =
                    (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm =
                (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        view.clearFocus();
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
