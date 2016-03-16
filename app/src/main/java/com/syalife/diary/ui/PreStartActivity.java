package com.syalife.diary.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

import com.syalife.diary.R;
import com.syalife.diary.util.PermissionsUtil;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PreStartActivity extends Activity {

    public boolean isVisible() {
        PermissionsUtil permissionsUtil = PermissionsUtil.getInstance();
        permissionsUtil.printPermissionStatus(this);
        if (permissionsUtil.needRequestPermission(this)) {
            permissionsUtil.requestPermission(this, PermissionsUtil.getInstance().PERMISSIONS);
            return true;
        } else {
            doStart();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isVisible()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_pre_start);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean getAllPermissions = true;
        for (int grant : grantResults) {
            if (grant == PackageManager.PERMISSION_DENIED) {
                getAllPermissions = false;
                break;
            }
        }

        if (getAllPermissions) {
            doStart();
            finish();
        } else {
            Intent intent =  new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            startActivity(intent);
        }
    }

    private void doStart() {
        Intent i = new Intent(PreStartActivity.this, DiaryActivity.class);
        startActivity(i);
    }

}
