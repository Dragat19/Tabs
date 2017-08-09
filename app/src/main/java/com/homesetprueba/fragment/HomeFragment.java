package com.homesetprueba.fragment;


/**
 * Created by albertsanchez on 9/8/17.
 */

public class HomeFragment extends TabsFragments {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    protected void initAdapter() {
        adapter.addFragment(ContentFragment.newInstance(0),"Noticia");
        adapter.addFragment(ContentFragment.newInstance(1),"Fino Meligeni");
    }

    @Override
    protected void initViewPager() {
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }

}
