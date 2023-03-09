package com.example.asynctaskloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RVRetrofitAdapter extends RecyclerView.Adapter<RVRetrofitAdapter.RVHolderRetrofit> {

    Context mContext;

    List<DogsResult> dogsResults;

    public RVRetrofitAdapter(Context mContext, List<DogsResult> dogsResults){
        this.dogsResults = dogsResults;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_dogs,parent,false);
        return new RVHolderRetrofit(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolderRetrofit holder, int position) {
        holder.tvTitle.setText(dogsResults.get(position).getName());

        String imageUrl = dogsResults.get(position).getImage().getUrl();
        Glide.with(mContext).load(imageUrl)
                .placeholder(R.drawable.img)
                .error(R.drawable.ic_launcher_background)
                .into(holder.ivImage);
    }


    @Override
    public int getItemCount() {
        return dogsResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;
        public RVHolderRetrofit(@Nullable View itemView){
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
