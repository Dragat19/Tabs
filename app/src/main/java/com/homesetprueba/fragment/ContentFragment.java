package com.homesetprueba.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homesetprueba.R;
import com.homesetprueba.adapter.HomeNewRecyclerView;
import com.homesetprueba.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class ContentFragment extends Fragment {
    private int mPager;
    private List<News> news;
    private HomeNewRecyclerView adapter;
    private RecyclerView mRecycler;
    private String[] title = {"Title 1","Title 2","Title 3","Title 4","Title 5","Title 6"};

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
        View v = inflater.inflate(R.layout.fragment_content,container,false);
        news = new ArrayList<>();
        mRecycler = (RecyclerView) v.findViewById(R.id.recycler_news);

        switch (mPager){
            case 0:

                listNews();
                adapter = new HomeNewRecyclerView(getContext(),news);
                mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecycler.setHasFixedSize(true);
                mRecycler.setItemAnimator(new DefaultItemAnimator());
                mRecycler.setAdapter(adapter);
                break;

            case 1:
                break;

        }

        return v;
    }


    private void listNews (){
        news.add(new News(title[0]));
        news.add(new News(title[1]));
        news.add(new News(title[2]));
        news.add(new News(title[3]));
        news.add(new News(title[4]));
        news.add(new News(title[5]));
    }

}
