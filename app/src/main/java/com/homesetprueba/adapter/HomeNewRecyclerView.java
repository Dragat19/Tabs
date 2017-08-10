package com.homesetprueba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.homesetprueba.R;
import com.homesetprueba.model.News;

import java.util.List;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class HomeNewRecyclerView extends RecyclerView.Adapter<HomeNewRecyclerView.ItemViewHolder> {

    private Context context;
    private List<News> news;

    public HomeNewRecyclerView(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        ItemViewHolder homeView = new ItemViewHolder(v);
        return  homeView;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mTitle.setText(news.get(position).getTitleNews());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.card_title);
        }
    }
}
