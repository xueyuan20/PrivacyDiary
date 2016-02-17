package com.syalife.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.syalife.library.creater.IViewCreator;
import com.syalife.library.view.SyaViewHolder;
import com.syalife.syalibrary.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/2/4.
 */
public abstract class SyaListAdapter<T> extends BaseAdapter implements IViewCreator<T>, IListAdapter<T> {
    private Context mContext;
    private List<T> mDataList = null;

    public SyaListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public T getItem(int position) {
        return mDataList == null ? null : mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SyaViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = createView(getContext(), position, getItem(position));
            convertView = viewHolder.getView();
        } else {
            viewHolder = (SyaViewHolder) convertView.getTag(R.string.g_convert_view);
        }
        viewHolder.putData(SyaViewHolder.POSITION, position);
        viewHolder.putData(SyaViewHolder.ITEM, getItem(position));

        updateView(viewHolder, position, getItem(position));
        return convertView;
    }

    @Override
    public void setList(List<T> list) {
        mDataList = list;
    }

    @Override
    public List<T> getList() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        return mDataList;
    }

    @Override
    public void addAll(List<T> list) {
        if (mDataList == null) {
            mDataList = new ArrayList<>(list.size());
        }
        mDataList.addAll(list);
    }

    public void addAll(Collection<? extends T> collection) {
        if (mDataList == null) {
            mDataList = new ArrayList<>(collection.size());
        }
        mDataList.addAll(collection);
    }

    @Override
    public void add(T item) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.add(item);
    }

    @Override
    public boolean contains(T item) {
        if (mDataList != null) {
            return mDataList.contains(item);
        }
        return false;
    }

    @Override
    public void remove(T item) {
        if (mDataList != null) {
            mDataList.remove(item);
        }
    }

    @Override
    public void remove(int position) {
        if (mDataList != null) {
            mDataList.remove(position);
        }
    }

    @Override
    public void clear() {
        if (mDataList != null) {
            mDataList.clear();
        }
    }
}
