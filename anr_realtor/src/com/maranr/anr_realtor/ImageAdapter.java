package com.maranr.anr_realtor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

/** 
 * Support for PropertyPage's Gallery on the photos tab.
 */

public class ImageAdapter extends BaseAdapter {

    private Context _context;
    private int _itemBackground;
    private Integer[] _imageIds;
    
    public ImageAdapter(Context c, Integer[] imageIds)    {
        this._context = c;
        this._imageIds = imageIds;
        
        // @@@@ WHAT DOES THIS DO??? 
        // Set the style -- see res/values/gallery_attrs.xml                
        TypedArray a = this._context.obtainStyledAttributes(R.styleable.Gallery1);
        this._itemBackground = a.getResourceId(
        		R.styleable.Gallery1_android_galleryItemBackground, 0);
        a.recycle();                                                    
    }


	public int getCount() {
        return this._imageIds.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View OLD__getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = new ImageView(this._context);
	        
		imageView.setImageResource(this._imageIds[position]);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
		imageView.setBackgroundResource(this._itemBackground);
		
		return imageView;
	}
	// @@@@ @ REUSE OBJ
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = null;
		if (convertView == null) {
			imageView = new ImageView(this._context);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
			imageView.setBackgroundResource(this._itemBackground);
		} else {
			// Reuse existing view
			imageView = (ImageView)convertView;
		}
		
		imageView.setImageResource(this._imageIds[position]);

		return imageView;
	}

}
