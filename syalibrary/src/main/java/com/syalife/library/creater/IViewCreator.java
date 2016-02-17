package com.syalife.library.creater;

import android.content.Context;

import com.syalife.library.view.SyaViewHolder;

/**
 * Created by Administrator on 2016/2/4.
 */
public interface IViewCreator<T> {
    SyaViewHolder createView(Context context, int position, T item);

    void updateView(SyaViewHolder viewHolder, int position, T item);
}
