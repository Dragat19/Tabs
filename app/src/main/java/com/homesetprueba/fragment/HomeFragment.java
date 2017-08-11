package com.homesetprueba.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homesetprueba.R;
import com.homesetprueba.adapter.PagerListFragmentAdapter;
import com.homesetprueba.mvp.model.Module;
import com.homesetprueba.mvp.presenters.HomePresenter;
import com.homesetprueba.mvp.views.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class HomeFragment extends Fragment implements HomeView {

    public static final String HOME_BASIC= "INFO";
    private static final String TAG = "HomeFragment";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerListFragmentAdapter adapter;

    private HomePresenter presenter;
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
        presenter = new HomePresenter();
        presenter.attachMvpView(this);
        presenter.getHome();

        return v;
    }

    @Override
    public void onDataUpdate(ArrayList<Module> modules) {

        if (modules.size() != 0){
            for (int i = 0; i < modules.size(); i++ ){
                adapter.addFragment(ContentFragment.newInstance(modules.get(i).getBasicInfo(),i),modules.get(i).getName());
            }
            adapter.notifyDataSetChanged();
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(2);
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
