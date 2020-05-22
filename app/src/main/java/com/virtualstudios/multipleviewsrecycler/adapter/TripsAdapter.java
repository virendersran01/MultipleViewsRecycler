package com.virtualstudios.multipleviewsrecycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virtualstudios.multipleviewsrecycler.R;
import com.virtualstudios.multipleviewsrecycler.models.Ads;
import com.virtualstudios.multipleviewsrecycler.models.Item;
import com.virtualstudios.multipleviewsrecycler.models.News;
import com.virtualstudios.multipleviewsrecycler.models.Trip;

import java.util.List;

public class TripsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Item> items;

    public TripsAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (viewType == 0){
           return  new TripViewHolder(
                   LayoutInflater.from(parent.getContext()).inflate(
                           R.layout.item_container_trip,
                           parent,
                           false
                   )
           );
       }else if (viewType == 1){
           return new AdsViewHolder(
                   LayoutInflater.from(parent.getContext()).inflate(
                           R.layout.item_container_ads,
                           parent,
                           false
                   )
           );
       }else {
           return new NewsViewHolder(
                   LayoutInflater.from(parent.getContext()).inflate(
                           R.layout.item_container_news,
                           parent,
                           false
                   )
           );
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == 0){
            Trip trip = (Trip) items.get(position).getObject();
            ((TripViewHolder)holder).setTripData(trip);
        }else if (getItemViewType(position) == 1){
            Ads ads = (Ads) items.get(position).getObject();
            ((AdsViewHolder)holder).setAdsData(ads);
        }else {
            News news = (News) items.get(position).getObject();
            ((NewsViewHolder)holder).setNewsData(news);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    static class TripViewHolder extends RecyclerView.ViewHolder {
        private ImageView  imageTrip;
        private TextView textTripTitle, textTrip;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTrip = itemView.findViewById(R.id.imageTrip);
            textTripTitle = itemView.findViewById(R.id.textTripTitle);
            textTrip = itemView.findViewById(R.id.textTrip);
        }

        void setTripData(Trip trip){
            imageTrip.setImageResource(trip.getTripImage());
            textTripTitle.setText(trip.getTripTitle());
            textTrip.setText(trip.getTrip());
        }
    }

    static class AdsViewHolder extends RecyclerView.ViewHolder {
        private  TextView textAdsTitle, textAds;

        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
            textAdsTitle = itemView.findViewById(R.id.textAdsTitle);
            textAds = itemView.findViewById(R.id.textAds);
        }

        void setAdsData(Ads ads){
            textAdsTitle.setText(ads.getAdsTitle());
            textAds.setText(ads.getAds());
        }
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        private  TextView textNewsTitle, textNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textNewsTitle = itemView.findViewById(R.id.textNewsTitle);
            textNews = itemView.findViewById(R.id.textNews);
        }

        void setNewsData(News news){
            textNewsTitle.setText(news.getNewsTitle());
            textNews.setText(news.getNews());
        }
    }
}
