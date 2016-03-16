package com.syalife.diary.util;


import com.syalife.diary.DiaryApplication;

public class DistanceUtil {

    public static int getCameraAlbumWidth() {
        return (DiaryApplication.getApp().getScreenWidth() - DiaryApplication.getApp().dp2px(10)) / 4 - DiaryApplication.getApp().dp2px(4);
    }
    
    // 相机照片列表高度计算 
    public static int getCameraPhotoAreaHeight() {
        return getCameraPhotoWidth() + DiaryApplication.getApp().dp2px(4);
    }
    
    public static int getCameraPhotoWidth() {
        return DiaryApplication.getApp().getScreenWidth() / 4 - DiaryApplication.getApp().dp2px(2);
    }

    //活动标签页grid图片高度
    public static int getActivityHeight() {
        return (DiaryApplication.getApp().getScreenWidth() - DiaryApplication.getApp().dp2px(24)) / 3;
    }
}
