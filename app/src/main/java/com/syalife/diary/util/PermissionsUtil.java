package com.syalife.diary.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import com.syalife.library.util.SYA_LOG;

/**
 * Created by Administrator on 2015/12/26.
 */
public class PermissionsUtil {
    private static PermissionsUtil mInstance;
    public static PermissionsUtil getInstance() {
        if (mInstance == null) {
            mInstance = new PermissionsUtil();
        }
        return mInstance;
    }

    /**
     * PROTECTION_NORMAL:
     * "android.permission.INTERNET", // 0
     * "android.permission.ACCESS_NETWORK_STATE",// 1
     * "android.permission.ACCESS_WIFI_STATE",
     * "android.permission.CHANGE_WIFI_STATE",
     * "android.permission.WAKE_LOCK",
     * "android.permission.VIBRATE",
     * "android.permission.RECEIVE_BOOT_COMPLETED"
     *
     * NOT_USED:
     * "android.permission.CHANGE_NETWORK_STATE",
     * "android.permission.WRITE_SETTINGS",
     *
     * USED:
     * "android.permission.READ_EXTERNAL_STORAGE",
     * "android.permission.WRITE_EXTERNAL_STORAGE",
     * "android.permission.READ_PHONE_STATE",
     *
     **/
    public final String[] PERMISSIONS = new String[3];
    /**
     * Permission id: whether enable internet.
     */
    public final int READ_STORAGY = 0;
    public final int WRITE_STORAGY = 1;
    public final int READ_PHONE_STATE = 2;

    private PermissionsUtil() {
        mInstance = this;
        PERMISSIONS[READ_PHONE_STATE] = Manifest.permission.READ_PHONE_STATE;
        PERMISSIONS[READ_STORAGY] = Manifest.permission.READ_EXTERNAL_STORAGE;
        PERMISSIONS[WRITE_STORAGY] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    }

    public boolean needRequestPermission(Activity activity) {
        // Android M
        if (Build.VERSION.SDK_INT > 22) {
            for (int i = 0; i < PERMISSIONS.length; i++) {
                if (activity.checkSelfPermission(PERMISSIONS[i]) == PackageManager.PERMISSION_DENIED) {
                    return true;
                }
            }
        }
        return false;
    }

    public void requestPermission(Activity activity, String[] permissions) {
        if (Build.VERSION.SDK_INT > 22) {
            activity.requestPermissions(permissions, PackageManager.PERMISSION_GRANTED);
        }
    }

    public void printPermissionStatus(Context ctx) {
        if (Build.VERSION.SDK_INT > 22) {
            for (int i = 0; i < PERMISSIONS.length; i++) {
                if (ctx.checkSelfPermission(PERMISSIONS[i]) == PackageManager.PERMISSION_DENIED) {
                    SYA_LOG.e("[" + PERMISSIONS[i] + "] Denied.");
                } else {
                    SYA_LOG.i("[" + PERMISSIONS[i] + "] Granted.");
                }
            }
        }
    }
}
