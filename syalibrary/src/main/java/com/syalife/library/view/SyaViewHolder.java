package com.syalife.library.view;

import android.view.View;

import com.syalife.syalibrary.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/4.
 */
public class SyaViewHolder {
    public static final String POSITION = "position";
    public static final String ITEM = "item";

    private View mConvertView;
    private Map<Integer, View> viewMap = new HashMap<>();
    private Map<Object, Object> dataMap = new HashMap<>();

    public SyaViewHolder(View convertView) {
        mConvertView = convertView;
        mConvertView.setTag(R.string.g_convert_view, this);
    }

    public <V extends View> V findViewById(int id) {
        if (!viewMap.containsKey(id)) {
            viewMap.put(id, mConvertView.findViewById(id));
        }
        return (V) viewMap.get(id);
    }

    public View getView() {
        return mConvertView;
    }

    public int getPosition() {
        return getData(POSITION);
    }

    public <V> V getItem() {
        return getData(ITEM);
    }

    public <K, V> void putData(K key, V value) {
        dataMap.put(key, value);
    }

    public <K, V> V getData(K key) {
        return (V) dataMap.get(key);
    }
}
