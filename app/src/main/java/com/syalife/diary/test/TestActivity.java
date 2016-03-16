package com.syalife.diary.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.syalife.diary.R;
import com.syalife.diary.test.utils.TimeUtils;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, ListViewPullDownFreshActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn02).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("[Date]", "[test dateformat]" + TimeUtils.getInstance().getCurrentDate());
                Log.e("[Date]", "[test dateformat]" + TimeUtils.getInstance().getCurrentTime());
                Log.e("[Date]", "[test dateformat]" + TimeUtils.getInstance().getCurrentDateAndTime());
            }
        });
        findViewById(R.id.btn03).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
        findViewById(R.id.btn04).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
