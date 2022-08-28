package com.selimhatipoglu.movieapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {

    ArrayList<RecylerModel> arrayList;

    SimpleDraweeView draweeView;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, topic, star, time;
        ImageView image;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            topic = itemView.findViewById(R.id.movie_topic);
            star = itemView.findViewById(R.id.movie_star);
            time = itemView.findViewById(R.id.movie_time);
            draweeView =(SimpleDraweeView) itemView.findViewById(R.id.imageView);


        }




    }


    public RecylerAdapter(ArrayList<RecylerModel> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecylerModel recylerModel=arrayList.get(position);
        holder.title.setText(recylerModel.getTitle());
        holder.topic.setText(recylerModel.getTopic());
        holder.star.setText(recylerModel.getStar());
        holder.time.setText(recylerModel.getTime());
        Uri uri = Uri.parse(recylerModel.getImage());
        draweeView.setImageURI(uri);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



}


