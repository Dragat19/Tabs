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
import com.homesetprueba.mvp.model.Module;
import com.homesetprueba.mvp.presenters.HomeFragmentPresenter;
import com.homesetprueba.mvp.views.HomeView;

import java.util.ArrayList;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class HomeFragment extends Fragment implements HomeView {

    public static final String BASIC_INFO = "BASIC_INFO";

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerListFragmentAdapter adapter;

    private HomeFragmentPresenter presenter;
    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragments_tabs,null);

        tabLayout = (TabLayout)v.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        adapter = new PagerListFragmentAdapter(getChildFragmentManager());
        tabLayout.setupWithViewPager(viewPager);

        presenter = new HomeFragmentPresenter();
        presenter.attachMvpView(this);
        presenter.getHome();

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        return v;
    }

    @Override
    public void onDataUpdate(ArrayList<Module> modules) {

        for (int i = 0; i>modules.size(); i++ ){
            adapter.addFragment(ContentFragment.newInstance(modules.get(i).getBasicInfo()),modules.get(i).getName());
        }
    }

    @Override
    public void onDestroy() {
        presenter.detachMvpView();
        super.onDestroy();
    }


    @Override
    public void onError(String error) {

    }

    @Override
    public void onHttpError(int errorCode, String meg) {

    }



}
