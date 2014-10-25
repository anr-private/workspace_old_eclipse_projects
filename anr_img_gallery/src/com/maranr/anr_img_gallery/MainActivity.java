package com.maranr.anr_img_gallery;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//---the images to display---
    private Integer[] imageIds = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7                    
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        
        gallery.setAdapter(new ImageAdapter(this, this.imageIds));
        
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, 
            						View v, int position, long id) { 
            	// parent is Gallery
            	// v is ImageView (created by ImageAdapter, presumably)
            	Log.d("onClick", "ParentView is " + parent.getClass().getName());
            	Log.d("onClick", "View is " + v.getClass().getName() + "  pos=" + position +
            			"  id=" + id);
            	
                Toast.makeText(getBaseContext(), 
                        "Pic " + (position + 1) + " selected", 
                        Toast.LENGTH_SHORT).show();
                
                //---display the images selected---
                ImageView imageView = (ImageView) findViewById(R.id.image1);                
                imageView.setImageResource(imageIds[position]);
            }
        });

    }
}