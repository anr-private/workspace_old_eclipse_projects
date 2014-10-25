package com.maranr.anr_grid_view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    private Integer[] imageIds = {
            R.drawable.pic01,
            R.drawable.pic02,
            R.drawable.pic03,
            R.drawable.pic04,
            R.drawable.pic05,
            R.drawable.pic06,
            R.drawable.pic07,
            R.drawable.pic08,
            R.drawable.pic09,
            R.drawable.pic10,
            R.drawable.pic11,
            R.drawable.pic12,
            R.drawable.pic13,
            R.drawable.pic14,
            R.drawable.pic15,
            R.drawable.pic16,
            R.drawable.pic17,
            R.drawable.pic21,
            R.drawable.pic22,
            R.drawable.pic23,
            R.drawable.pic24,
            R.drawable.pic25,
            R.drawable.pic26,
            R.drawable.pic27,
            R.drawable.pic31,
            R.drawable.pic32,
            R.drawable.pic33,
            R.drawable.pic34,
            R.drawable.pic35,
            R.drawable.pic36,
            R.drawable.pic37,
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyImageAdapter(this, this.imageIds));
 
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, 
            						int position, long id) {
                Toast.makeText(getBaseContext(), 
                        "pic" + (position + 1) + " selected", 
                        Toast.LENGTH_SHORT).show();
            }
        });        
 
    }
    
}