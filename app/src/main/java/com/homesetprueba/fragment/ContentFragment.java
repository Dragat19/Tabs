package com.homesetprueba.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homesetprueba.R;
import com.homesetprueba.adapter.HomeNewRecyclerView;
import com.homesetprueba.mvp.model.BasicInfo;
import com.homesetprueba.mvp.model.News;
import com.homesetprueba.mvp.presenters.NewsPresenter;
import com.homesetprueba.mvp.views.NewsView;
import java.util.ArrayList;

import static com.homesetprueba.fragment.HomeFragment.HOME_BASIC;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class ContentFragment extends Fragment implements NewsView {

    private BasicInfo info;
    private HomeNewRecyclerView adapter;
    private RecyclerView mRecycler;
    private NewsPresenter presenter;

    public static ContentFragment newInstance(BasicInfo moduleInfo,int page) {
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(HOME_BASIC, moduleInfo);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content,container,false);
        info = (BasicInfo) getArguments().getSerializable(HOME_BASIC);
        presenter = new NewsPresenter();
        presenter.attachMvpView(this);
        presenter.getNews(info.getId_cat());
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler_news);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setHasFixedSize(true);
        return v;
    }


    @Override
    public void onDataUpdate(ArrayList<News> news) {
        if (news.size() != 0){
            for (int i = 0; i < news.size(); i++) {
                adapter  = new HomeNewRecyclerView(getContext(),news);
            }
            mRecycler.setAdapter(adapter);
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onHttpError(int errorCode, String meg) {

    }

    @Override
    public void onDestroy() {
        presenter.detachMvpView();
        super.onDestroy();
    }
}
