package com.homesetprueba.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homesetprueba.R;
import com.homesetprueba.adapter.PagerListFragmentAdapter;

/**
 * Created by albertsanchez on 9/8/17.
 */

public abstract class TabsFragments extends Fragment  {

    protected TabLayout tabLayout;
    protected ViewPager viewPager;
    protected PagerListFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragments_tabs,null);

        tabLayout = (TabLayout)v.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        adapter = new PagerListFragmentAdapter(getChildFragmentManager());
        tabLayout.setupWithViewPager(viewPager);

        initViewPager();
        initAdapter();

        return v;
    }

    protected abstract void initAdapter();

    protected abstract void initViewPager();


}
