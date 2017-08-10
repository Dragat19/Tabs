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
import com.homesetprueba.mvp.model.NewsTest;
import com.homesetprueba.mvp.views.NewsView;

import java.util.ArrayList;
import java.util.List;

import static com.homesetprueba.fragment.HomeFragment.BASIC_INFO;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class ContentFragment extends Fragment implements NewsView {
    private int mPage;
    private List<NewsTest> news;
    private HomeNewRecyclerView adapter;
    private RecyclerView mRecycler;

    public static ContentFragment newInstance(BasicInfo moduleInfo,int page) {
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BASIC_INFO, moduleInfo);
        fragment.setPage(page);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setPage(int page) {
       mPage = page;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content,container,false);
        news = new ArrayList<>();
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler_news);

        switch (mPage){
            case 0:

            case 1:
                break;

        }

        return v;
    }


    @Override
    public void onDataUpdate(ArrayList<News> news) {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onHttpError(int errorCode, String meg) {

    }
}
