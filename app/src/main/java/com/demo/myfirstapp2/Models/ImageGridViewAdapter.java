package com.demo.myfirstapp2.Models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by PCPV on 08-06-16.
 */
public class ImageGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[]mThumbIds;

    public ImageGridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ImageGridViewAdapter(Context mContext, Integer[] mThumbIds) {
        this.mContext = mContext;
        this.mThumbIds = mThumbIds;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView;
        if(convertView == null){
            imgView = new ImageView(mContext);
            imgView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        }else{
            imgView = (ImageView) convertView;
        }
        imgView.setImageResource(mThumbIds[position]);
        return imgView;
    }
}
