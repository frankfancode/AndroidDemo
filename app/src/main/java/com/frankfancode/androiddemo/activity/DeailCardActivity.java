package com.frankfancode.androiddemo.activity;


import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frankfancode.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

public class DeailCardActivity extends AppCompatActivity {

    private ViewPager mCardViewPager;
    private DealCardPageAdapter dcPagerAdapter;
    private List<View> viewList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deail_card);
        mCardViewPager = (ViewPager) findViewById(R.id.vp_deal_card);
        TextView v=new TextView(this);
        v.setText("test1");v=new TextView(this);viewList.add(v);
        v.setText("test2");v=new TextView(this);viewList.add(v);
        v.setText("test3");v=new TextView(this);viewList.add(v);
        v.setText("test4");v=new TextView(this);viewList.add(v);
        v.setText("test5");v=new TextView(this);viewList.add(v);
        dcPagerAdapter=new DealCardPageAdapter(viewList);
        mCardViewPager.setAdapter(dcPagerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deail_card, menu);
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

    private class DealCardPageAdapter extends PagerAdapter{
        List<View> viewLists;

        public DealCardPageAdapter(List<View> viewLists) {
            this.viewLists = viewLists;
        }

        @Override
        public int getCount() {
            if (null==viewLists){
                return 0;
            }
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //销毁Item
        @Override
        public void destroyItem(View view, int position, Object object)
        {
            ((ViewPager) view).removeView(viewLists.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewLists.get(position),0);
            return viewLists.get(position);
        }
    }
}
