package com.homesetprueba.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class PagerListFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listFragmentTitle = new ArrayList<>();

    public PagerListFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        listFragment.add(fragment);
        listFragmentTitle.add(title);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment != null ? listFragment.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentTitle.get(position);
    }
}
