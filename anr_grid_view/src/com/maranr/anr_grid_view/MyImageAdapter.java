package com.maranr.anr_grid_view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImageAdapter extends BaseAdapter {

	private Context context;
	private Integer[] imageIds;
	
	public MyImageAdapter(Context context, Integer[] imageIds)
	{
		super();
		this.context = context;
		this.imageIds = imageIds;
	}
	
	public int getCount() {
		return this.imageIds.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(185, 185)); // orig was 185,185
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }
        
        imageView.setImageResource(imageIds[position]);
        
        return imageView;
	}

}
