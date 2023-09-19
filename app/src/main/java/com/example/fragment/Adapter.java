package com.example.fragment;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<String> data;

    public Adapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imageview ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.content_layout, null);
            imageview = convertView.findViewById(R.id.image);

            convertView.setTag(imageview);
        } else {
            imageview = (ImageView) convertView.getTag();
        }
        //new DownloadImage(dataitem.iv_photo).execute(photo_list.get(position).getSource_photo());
        Picasso.get().load(data.get(position)).resize(300, 400).centerCrop().into(imageview);

        new DownloadImage(context,imageview,data.get(position)).onStartLoading();
//        Picasso.get().load(photo_list.get(position).getSource_photo()).resize(300,400).centerCrop().into(dataitem.iv_photo);


        return convertView;

    }



}
