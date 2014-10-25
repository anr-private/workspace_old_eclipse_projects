package com.maranr.anr_tabs_both_orientations;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * Shows a tabbed display layout in both portrait and landscape orientations
 * using separate layout xml files.
 * 
 * http://stackoverflow.com/questions/4149953/androidorientation-vertical-does-not-work-for-tabwidget
 * 
 * NEEDS DEBUGGING
 * 
 * @author tdir
 *
 */
public class MainActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        Resources res = getResources();
        Configuration cfg = res.getConfiguration();
        boolean hor = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (hor) {
            TabWidget tw = tabHost.getTabWidget();
            tw.setOrientation(LinearLayout.VERTICAL);
        }

        /* @@@@ TO BE DEBUGGED */
        //ImageView imgView = (ImageView) findViewById(R.drawable.ic_launcher);
        Resources r = this.getResources();
        Drawable icon = (Drawable) r.getDrawable(R.drawable.ic_launcher);
        /*
        tabHost.addTab(tabHost.newTabSpec("TABname")
                .setIndicator(createIndicatorView(tabHost, "tab title", icon)))
                .setContent(this));
       */
        TabSpec tabspec = tabHost.newTabSpec("TABname");
        //tabspec.setIndicator("INDICATORtab");
        tabspec.setIndicator(createIndicatorView(tabHost, "myTabTitle", icon));
        tabspec.setContent(R.layout.tab_content1);
    }
    
    
    
    private View createIndicatorView(TabHost tabHost, CharSequence label, Drawable icon) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View tabIndicator = inflater.inflate(R.layout.tab_indicator,
                tabHost.getTabWidget(), // tab widget is the parent
                false); // no inflate params

        final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
        tv.setText(label);

        final ImageView iconView = (ImageView) tabIndicator.findViewById(R.id.icon);
        iconView.setImageDrawable(icon);

        return tabIndicator;
    }

    
}

/*
 * Usual way to create a tab:
    tabHost.addTab(tabHost.newTabSpec("tab name").setIndicator("title", icon).setContent(...));
 * New way is:    
    tabHost.addTab(tabHost.newTabSpec(AllTabName)
                .setIndicator(createIndicatorView(tabHost, "tab title", icon)))
                .setContent(this));

*/