package com.frankfancode.androiddemo.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.frankfancode.androiddemo.R;
import com.frankfancode.androiddemo.entity.Card;

/**
 * Created by Frank on 2015/11/1.
 */
public class DealCardFragment extends Fragment {
    private Card card;

    public DealCardFragment(Card card) {
        this.card = card;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_deal_card, container, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.iv_card = (ImageView) rootView.findViewById(R.id.iv_card);
        viewHolder.iv_card.setImageURI(Uri.parse(card.imageUri));
        return rootView;

    }

    class ViewHolder {
        private ImageView iv_card;
    }
}
