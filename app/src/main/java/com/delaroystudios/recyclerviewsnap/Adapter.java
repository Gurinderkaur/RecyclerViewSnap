package com.delaroystudios.recyclerviewsnap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by delaroy on 2/10/17.
 */

import android.widget.ImageView;
import android.widget.TextView;



public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<App> mApps;
    private boolean mHorizontal;
    private boolean mPager;

    public Adapter(boolean horizontal, boolean pager, List<App> apps) {
        mHorizontal = horizontal;
        mApps = apps;
        mPager = pager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mPager) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_pager, parent, false));
        } else {
            return mHorizontal ? new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter, parent, false)) :
                    new ViewHolder(LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.adapter_vertical, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        App app = mApps.get(position);
        holder.imageView.setImageResource(app.getDrawable());
        holder.nameTextView.setText(app.getName());
        holder.ratingTextView.setText(String.valueOf(app.getRating()));

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        public TextView ratingTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);
        }

    }

}