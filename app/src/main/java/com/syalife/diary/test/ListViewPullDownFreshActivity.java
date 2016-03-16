package com.syalife.diary.test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.syalife.diary.R;
import com.syalife.diary.test.listview.PullDownRefreshListView;
import com.syalife.diary.test.listview.PullDownRefreshListView.OnRefreshListener;

import java.util.List;
import java.util.Map;

/**
 * ListView分页加载数据
 *
 * @author
 */
public class ListViewPullDownFreshActivity extends AppCompatActivity {

    private PullDownRefreshListView listView;
    private List<Map<String, Object>> data;
    private listViewAdapter adapter;
    //分页加载的数据的数量
    private int pageSize = 10;
    private final int pageType = 1;
    //查看更多
    private TextView moreTextView;
    //正在加载进度条
    private LinearLayout loadProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulldown_listview);

        listView = (PullDownRefreshListView) findViewById(R.id.pulldown_refresh_listview);

        //第一个参数：1起始数  第二个参数：显示的数目
        data = InitValue.initValue(1, 15);

        //在ListView中添加"加载更多"
        addPageMore();
        //添加"加载更多"一定要在设置Adapter之前
        adapter = new listViewAdapter();
        listView.setAdapter(adapter);

        listView.setonRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        data = InitValue.initValue(1, data.size(), data);
//    					data.add("刷新后添加的内容");
//    					data.add("刷新后添加的内容");
//    					data.add("刷新后添加的内容");
//    					data.add("刷新后添加的内容");
//    					data.add("刷新后添加的内容");
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        adapter.notifyDataSetChanged();
                        listView.onRefreshComplete();
                    }

                }.execute();
            }
        });
    }

    private class listViewAdapter extends BaseAdapter {
        int count = data.size();

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(ListViewPullDownFreshActivity.this).inflate(R.layout.item_new, null);
            TextView title = (TextView) view.findViewById(R.id.tv1);
            TextView text = (TextView) view.findViewById(R.id.tv2);
            title.setText(data.get(position).get("title").toString());
            text.setText(data.get(position).get("text").toString());
            return view;
        }

    }

    /**
     * 加载下一页的数据
     *
     * @param pageStart
     * @param pageSize
     */
    private void chageListView(int pageStart, int pageSize) {
        List<Map<String, Object>> data = InitValue.initValue(pageStart, pageSize);
        for (Map<String, Object> map : data) {
            this.data.add(map);
        }
        data = null;
    }

    /**
     * 在ListView中添加"加载更多"
     */
    private void addPageMore() {
        View view = LayoutInflater.from(this).inflate(R.layout.list_page_load, null);
        moreTextView = (TextView) view.findViewById(R.id.more_id);
        loadProgressBar = (LinearLayout) view.findViewById(R.id.load_id);
        moreTextView.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示进度条
                loadProgressBar.setVisibility(View.VISIBLE);
                //隐藏"加载更多"
                moreTextView.setVisibility(View.GONE);

                // TODO: 2016/3/16 to load data from network
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //休眠3秒，用于模拟网络操作时间
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //加载模拟数据：下一页数据， 在正常情况下，上面的休眠是不需要，直接使用下面这句代码加载相关数据
                        chageListView(data.size() + 1, pageSize);

                        // TODO: 2016/3/16  to call hideLoadingView() to update views.
                    }
                }).start();
            }
        });
        listView.addFooterView(view);
    }

    private void hideLoadingView() {
        //改变适配器的数目
        adapter.count += pageSize;
        //通知适配器，发现改变操作
        adapter.notifyDataSetChanged();
        listView.onRefreshComplete();
        //再次显示"加载更多"
        moreTextView.setVisibility(View.VISIBLE);
        //再次隐藏“进度条”
        loadProgressBar.setVisibility(View.GONE);
    }
}