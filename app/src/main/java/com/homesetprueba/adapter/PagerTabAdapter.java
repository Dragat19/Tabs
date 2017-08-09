package com.homesetprueba.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by albertsanchez on 9/8/17.
 */

public class PagerTabAdapter extends FragmentStatePagerAdapter {
    int mNumTabs;
    public PagerTabAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.mNumTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {

       /* switch (position){
            case 0:
                ContentFragment tabNews = new ContentFragment();
                return tabNews;
            case 1:
                HomeFragment tabFino = new HomeFragment();
                return tabFino;
            default:
                return null;
        }*/
       return null;
    }

    @Override
    public int getCount() {
        return mNumTabs;
    }
}
