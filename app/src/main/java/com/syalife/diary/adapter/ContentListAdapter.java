package com.syalife.diary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syalife.diary.R;
import com.syalife.diary.object.ContentItem;
import com.syalife.library.adapter.SyaListAdapter;
import com.syalife.library.util.SYA_LOG;
import com.syalife.library.view.SyaViewHolder;

/**
 * Created by Administrator on 2016/2/3.
 */
public class ContentListAdapter extends SyaListAdapter<ContentItem> {
    private Context mContext;
    public ContentListAdapter(Context ctx) {
        super(ctx);
        mContext = ctx;
    }

    @Override
    public ContentViewHolder createView(Context context, int position, ContentItem item) {
        return new ContentViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_list, null));
    }

    @Override
    public void updateView(SyaViewHolder viewHolder, int position, ContentItem item) {
        SYA_LOG.i("[ContentItem]" + item.toString());

        ContentViewHolder contentViewHolder = (ContentViewHolder) viewHolder;
        contentViewHolder.mTitle.setText(item.getTitle());
        contentViewHolder.mImage.setImageDrawable(mContext.getDrawable(R.mipmap.ic_launcher));
    }

    public class ContentViewHolder extends SyaViewHolder implements View.OnClickListener {
        private TextView mTitle;
        private ImageView mImage;

        public ContentViewHolder(View parent) {
            super(parent);
            mImage = findViewById(R.id.item_image);
            mTitle = findViewById(R.id.item_title);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
