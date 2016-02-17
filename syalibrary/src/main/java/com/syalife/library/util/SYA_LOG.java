package com.syalife.library.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/2/4.
 */
public class SYA_LOG {
    private static final String TAG = "DEBUG_2016";
    private static final boolean DEBUG_ENABLE = true;

    public static void i(String log) {
        if (DEBUG_ENABLE) {
            Log.i(TAG, log);
        }
    }

    public static void e(String log) {
        Log.e(TAG, log);
    }
}
