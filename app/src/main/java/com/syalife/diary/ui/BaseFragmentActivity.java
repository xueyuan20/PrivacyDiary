package com.syalife.diary.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.syalife.diary.ui.view.CommonTitleBar;

/**
 * Created by sky on 15/7/6.
 */
public class BaseFragmentActivity extends FragmentActivity {

    protected CommonTitleBar titleBar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if (titleBar != null)
            titleBar.setLeftBtnOnclickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
}
