package com.syalife.diary.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.syalife.diary.R;
import com.syalife.diary.object.ContentItem;
import com.syalife.library.adapter.ListAdapter;
import com.syalife.library.util.LOG;
import com.syalife.library.view.ViewHolder;

import java.util.HashSet;

/**
 * Created by Administrator on 2016/2/3.
 */
public class ContentListAdpter extends ListAdapter<ContentItem> {
    private HashSet<ContentItem> mHash = new HashSet();
    private Context mContext;

    public ContentListAdpter(Context ctx) {
        super(ctx);
        mContext = ctx;
    }

    @Override
    public int getCount() {
        return mHash.size();
    }

    @Override
    public ContentItem getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ContentViewHolder createView(Context context, int position, ContentItem item) {
        return new ContentViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_list, null));
    }

    @Override
    public void updateView(ViewHolder viewHolder, int position, ContentItem item) {
        LOG.i("[ContentItem]" + item.toString());

        ContentViewHolder contentViewHolder = (ContentViewHolder) viewHolder;
        contentViewHolder.mTitle.setText(item.getTitle());
    }

    public class ContentViewHolder extends ViewHolder implements View.OnClickListener {
        private TextView mTitle;
        private ImageView mImage;

        public ContentViewHolder(View parent) {
            super(parent);
            mImage = (ImageView) findViewById(R.id.item_image);
            mTitle = (TextView) findViewById(R.id.item_title);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
