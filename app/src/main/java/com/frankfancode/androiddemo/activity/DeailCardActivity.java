package com.frankfancode.androiddemo.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.frankfancode.androiddemo.R;
import com.frankfancode.androiddemo.adapter.DealCardPageAdapter;
import com.frankfancode.androiddemo.entity.Card;
import com.frankfancode.androiddemo.utils.Utils;
import com.frankfancode.androiddemo.widget.DealCardViewPager;

import java.util.ArrayList;
import java.util.List;

public class DeailCardActivity extends AppCompatActivity {
    private Activity mActivity = this;


    private DealCardViewPager mCardViewPager;
    private DealCardPageAdapter mDealCardPagerAdapter;
    private List<Card> mCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deail_card);
        mCardViewPager = (DealCardViewPager) findViewById(R.id.vp_deal_card);

        mCardList.add(new Card(Utils.resToUriString(mActivity, R.drawable.a), "picture a"));
        mCardList.add(new Card(Utils.resToUriString(mActivity, R.drawable.b), "picture b"));
        mCardList.add(new Card(Utils.resToUriString(mActivity, R.drawable.c), "picture c"));
        mCardList.add(new Card(Utils.resToUriString(mActivity, R.drawable.d), "picture d"));
        mDealCardPagerAdapter = new DealCardPageAdapter(getSupportFragmentManager(),mCardList);
        mCardViewPager.setAdapter(mDealCardPagerAdapter);


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


}
