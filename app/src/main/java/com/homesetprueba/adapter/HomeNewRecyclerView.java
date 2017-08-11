package com.homesetprueba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.homesetprueba.R;
import com.homesetprueba.mvp.model.News;
import com.homesetprueba.mvp.model.NewsTest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertsanchez on 9/8/17.
 */

public class    HomeNewRecyclerView extends RecyclerView.Adapter<HomeNewRecyclerView.ItemViewHolder> {

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
        holder.mTitle.setText(news.get(position).getTitle());
        setImagen_picasso(news.get(position).getPreview(),holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private ImageView mImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.card_title);
            mImageView = (ImageView) itemView.findViewById(R.id.card_img);
        }
    }

    public void setImagen_picasso(String Url, ImageView imageView) {
        Picasso.with(context)
                .load(Url)
                .resize(700,400)
                .error(R.drawable.img_holder)
                .into(imageView);
    }
}
