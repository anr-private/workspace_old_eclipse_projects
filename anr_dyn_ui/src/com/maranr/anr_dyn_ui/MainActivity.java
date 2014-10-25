package com.maranr.anr_dyn_ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * anr_dyn_ui
 * 
 * Dynamically-built GUI that uses code to create all views (widgets)
 * instead of using the main.xml layout file.
 * 
 * @author tdir
 *
 */
public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // USING DYNAMICALLY-BUILD GUI ---  setContentView(R.layout.main);
        
        // create the layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);

        // Create a TextView
        TextView tv = new TextView(this);
        tv.setText("This is a TextView view");
        tv.setLayoutParams(params);
        
        // Create a button
        Button btn = new Button(this);
        btn.setText("My Button - PUSH ME!");
        btn.setLayoutParams(params);
        
        // Add views to the layout
        layout.addView(tv);
        layout.addView(btn);
        
        // Layout params for the LinearLayout
        LinearLayout.LayoutParams lps = new LinearLayout.LayoutParams(
        										LayoutParams.FILL_PARENT,
        										LayoutParams.WRAP_CONTENT); 
        this.addContentView(layout, lps);
    }
}