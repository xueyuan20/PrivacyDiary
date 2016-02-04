package com.syalife.library.creater;

import android.content.Context;

import com.syalife.library.view.ViewHolder;

/**
 * Created by Administrator on 2016/2/4.
 */
public interface IViewCreator<T> {
    ViewHolder createView(Context context, int position, T item);

    void updateView(ViewHolder viewHolder, int position, T item);
}
