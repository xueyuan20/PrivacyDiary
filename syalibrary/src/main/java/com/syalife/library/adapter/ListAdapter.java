package com.syalife.library.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import com.syalife.library.creater.IViewCreator;
import com.syalife.library.view.ViewHolder;
import com.syalife.syalibrary.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/2/4.
 */
public class ListAdapter<T> implements android.widget.ListAdapter, IViewCreator<T>, IListAdapter<T> {
    private Context mContext;
    private List<T> mDataList = null;
    private DataSetObserver mDataSetObserver;

    public ListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObserver = observer;
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObserver = null;
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = createView(getContext(), position, getItem(position));
            convertView = viewHolder.getView();
        } else {
            viewHolder = (ViewHolder) convertView.getTag(R.string.g_convert_view);
        }
        viewHolder.putData(ViewHolder.POSITION, position);
        viewHolder.putData(ViewHolder.ITEM, getItem(position));

        updateView(viewHolder, position, getItem(position));
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if ((mDataList == null) && (mDataList.isEmpty())) {
            return true;
        }
        return false;
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

    public boolean addAll(Collection<? extends T> collection) {
        if (mDataList == null) {
            mDataList = new ArrayList<>(collection.size());
        }
        return mDataList.addAll(collection);
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

    @Override
    public void notifyDataSetChanged() {

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public ViewHolder createView(Context context, int position, T item) {
        return null;
    }

    @Override
    public void updateView(ViewHolder viewHolder, int position, T item) {

    }
}
