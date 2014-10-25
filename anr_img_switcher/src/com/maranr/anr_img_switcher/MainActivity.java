package com.maranr.anr_img_switcher;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

// NOTE see main.xml for various colors seen on gui
// NOTE implements ViewFactory - i.e, makeView()
public class MainActivity extends Activity implements ViewFactory {
	
    private Integer[] imageIds = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7                    
    };
    
    private ImageSwitcher imageSwitcher;

	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                //android.R.anim.slide_in_left
                android.R.anim.fade_in
                ));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                //android.R.anim.slide_out_right
                android.R.anim.fade_out
                ));
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this, this.imageIds));
        
        gallery.setOnItemClickListener(new OnItemClickListener()  {
            public void onItemClick(AdapterView<?> parent, 
            						View v, int position, long id)   {
            	Log.d("onItemClick1", "adapterView parent=" + parent.getClass().getName());
            	Log.d("onItemClick2", "  view=" + v.getClass().getName());
            	Log.d("onItemClick3", "  pos=" + position + " id=" + id);
            	imageSwitcher.setImageResource(imageIds[position]);  // NOTE use of imageSwitcher, imageIds
            }
        });  
    }
    
    
    /* required by ViewFactory infc */  // this could be done in a separate class...
    public View makeView() {
    	Log.d("makeView", "CALLED");
    	
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF00FF00); // WAS 0xFF 00 00 00  opaque black
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new 
                ImageSwitcher.LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.FILL_PARENT));
        return imageView;
    }
    
}