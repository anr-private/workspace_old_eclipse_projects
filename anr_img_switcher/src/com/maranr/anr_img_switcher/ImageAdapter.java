package com.maranr.anr_img_switcher;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
    private Context context;
    private int itemBackground;
    private Integer[] imageIds;
    
    public ImageAdapter(Context c, Integer[] imageIds)    {
        this.context = c;
        this.imageIds = imageIds;
        		
        // @@@@ WHAT DOES THIS DO???    see layout/values/attrs.xml
        //---setting the style---                
        TypedArray a = this.context.obtainStyledAttributes(R.styleable.Gallery1); // see attrs.xml
        itemBackground = a.getResourceId(
                R.styleable.Gallery1_android_galleryItemBackground, 0);
        a.recycle();                                                    
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
		
        ImageView imageView = new ImageView(context);
        
        imageView.setImageResource(this.imageIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
        imageView.setBackgroundResource(itemBackground);
        
        return imageView;
	}

}
