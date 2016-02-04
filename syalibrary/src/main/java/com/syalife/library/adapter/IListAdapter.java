package com.syalife.library.adapter;

import java.util.List;

/**
 * Created by Administrator on 2016/2/4.
 */
public interface IListAdapter<T> {

    void setList(List<T> list);

    List<T> getList();

    void addAll(List<T> list);

    void add(T item);

    T getItem(int position);

    boolean contains(T item);

    void remove(T item);

    void remove(int position);

    void clear();

    void notifyDataSetChanged();
}
