package com.homesetprueba.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.homesetprueba.R;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class ContentFragment extends Fragment {
    private int mPager;
    private TextView tvTabs;

    public static ContentFragment newInstance(int page) {
        ContentFragment fragment = new ContentFragment();
        fragment.setPage(page);
        return fragment;
    }

    public void setPage(int page){
         mPager = page;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_news,container,false);
        tvTabs = (TextView) v.findViewById(R.id.tvTabs);

        switch (mPager){
            case 0:
                tvTabs.setText("Tab 1");
                break;
            case 1:
                tvTabs.setText("Tab 2");
                break;

        }

        return v;
    }

}
