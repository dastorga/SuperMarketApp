package com.example.dario.supermarketapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class RecyclerViewAdapterProduct extends RecyclerView.Adapter<RecyclerViewAdapterProduct.ViewHolder> {

    Context context;
    List<DataAdapterProduct> dataAdapters;
    ImageLoader imageLoader;

    public RecyclerViewAdapterProduct(List<DataAdapterProduct> getDataAdapter, Context context){
        super();
        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        DataAdapterProduct dataAdapterOBJ =  dataAdapters.get(position);
        imageLoader = ImageAdapter.getInstance(context).getImageLoader();
        imageLoader.get(dataAdapterOBJ.getImageUrl(),
                ImageLoader.getImageListener(
                        Viewholder.VollyImageView,//Server Image
                        R.mipmap.ic_launcher,//Before loading server image the default showing image.
                        android.R.drawable.ic_dialog_alert //Error image if requested image dose not found on server.
                )
        );
        Viewholder.VollyImageView.setImageUrl(dataAdapterOBJ.getImageUrl(), imageLoader);
        Viewholder.ImageTitleTextView.setText(dataAdapterOBJ.getImageTitle());
        Viewholder.DescriptionProductTextView.setText(dataAdapterOBJ.getDescription());
        Viewholder.PriceProducTextView.setText(dataAdapterOBJ.getPrice());
    }

    @Override
    public int getItemCount() {
        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ImageTitleTextView,DescriptionProductTextView,PriceProducTextView;
        public NetworkImageView VollyImageView ;

        public ViewHolder(View itemView) {
            super(itemView);
            ImageTitleTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
            DescriptionProductTextView = (TextView) itemView.findViewById(R.id.DescriptionProductTextView);
            PriceProducTextView = (TextView) itemView.findViewById(R.id.PriceProducTextView);
            VollyImageView = (NetworkImageView) itemView.findViewById(R.id.VolleyImageView);
        }
    }
}