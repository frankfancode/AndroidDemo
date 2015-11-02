package com.frankfancode.androiddemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.frankfancode.androiddemo.entity.Card;
import com.frankfancode.androiddemo.fragment.DealCardFragment;

import java.util.List;

/**
 * Created by Frank on 2015/11/1.
 */
public class DealCardPageAdapter extends FragmentStatePagerAdapter {
    List<Card> values;

    public DealCardPageAdapter(FragmentManager fm,List<Card> values) {
        super(fm);
        this.values = values;
    }


    @Override
    public int getCount() {
        if (null == values) {
            return 0;
        }
        return values.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Fragment getItem(int position) {
        return new DealCardFragment(values.get(position));
    }
}