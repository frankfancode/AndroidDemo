package com.frankfancode.androiddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.frankfancode.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView mDemoListView;
    private List<Demo> demoList;
    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == mDemoListView.getId()) {
                startActivity(new Intent(MainActivity.this, demoList.get(position).demoClass));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDemoListView = (ListView) findViewById(R.id.lv_demo);
        mDemoListView.setOnItemClickListener(itemClickListener);
        initData();
    }

    private void initData() {
        demoList = new ArrayList<>();
        demoList.add(new Demo("Lrc Custom View", LrcActivity.class));
        demoList.add(new Demo("TestAIDLProxy", TestAIDLProxyActivity.class));
        demoList.add(new Demo("Deal card View Pager", DeailCardActivity.class));
        demoList.add(new Demo("Lrc Custom View", LrcActivity.class));
        demoList.add(new Demo("Lrc Custom View", LrcActivity.class));
        demoList.add(new Demo("Lrc Custom View", LrcActivity.class));
        demoList.add(new Demo("Lrc Custom View", LrcActivity.class));
        DemoAdapter demoAdapter = new DemoAdapter(this, demoList);
        mDemoListView.setAdapter(demoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private class DemoAdapter extends BaseAdapter {

        private Context context;
        private List<Demo> values;

        public DemoAdapter(Context context, List values) {
            super();
            this.context = context;
            this.values = values;
        }

        @Override
        public int getCount() {
            if (null != values) {
                return values.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (null != values) {
                return values.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (null == convertView) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.layout_demo_item, parent, false);
                holder = new ViewHolder();
                holder.demoTitleTextView = (TextView) convertView.findViewById(R.id.tv_demo_title);
                TextPaint tp = holder.demoTitleTextView.getPaint();
                tp.setFakeBoldText(true);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.demoTitleTextView.setText(values.get(position).title);
            return convertView;
        }

        public class ViewHolder {
            public TextView demoTitleTextView;
        }
    }

    public class Demo {
        public String title;
        private Class demoClass;

        public Demo(String title, Class demoClass) {
            this.title = title;
            this.demoClass = demoClass;
        }
    }
}
