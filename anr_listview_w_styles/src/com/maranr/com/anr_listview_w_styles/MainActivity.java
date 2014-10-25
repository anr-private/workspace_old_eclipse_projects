package com.maranr.com.anr_listview_w_styles;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ListView with header and footer.
 * Also uses style sheet and styles to set text sizes, colors, etc.
 *
 */
public class MainActivity extends ListActivity {

	String[] names = new String[] { 
			"Linux", "Windows7", "Eclipse", "Suse",
			"Ubuntu", "Solaris", "Android", "iPhone",
			"AALinux", "AAWindows7", "AAEclipse", "AASuse",
			"BBUbuntu", "BBSolaris", "BBAndroid", "BBiPhone",
			};

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
    
    
        Log.d("++create","INFLATE the hdr");
		View header = getLayoutInflater().inflate(R.layout.list_header, null);
        Log.d("++create","INFLATE the footer");
		View footer = getLayoutInflater().inflate(R.layout.list_footer, null);
        Log.d("++create","get LV");
		ListView listView = getListView();
        Log.d("++gotLV","listview="+listView);
		listView.addHeaderView(header);
        Log.d("++create","added HDR");
		listView.addFooterView(footer);
        Log.d("++create","added FTR");

		ArrayAdapter<String> arrayAdptr = 
        		new ArrayAdapter<String>(this,
        								 //BUILT IN - replaced by our own: layout/rowlayout.xml
        								 //android.R.layout.simple_list_item_1,
        								 // (REPLACED the adroid.R.layout)
        								 R.layout.rowlayout,
        								 // this (ADDED) arg tells where the label is
        								 R.id.rlo_label, 
        								 names);
        Log.d("++create","new ARRAYADPTER"+arrayAdptr);
        
		this.setListAdapter(arrayAdptr);
        Log.d("++create","set the LIST ADPTR");

    
    }
    
    
	@Override
	protected void onListItemClick(ListView listv, View v, int position, long id) {
		Log.d("++listItemClick1", "listview=" + listv);
		Log.d("++listItemClick2", "view=" + v);
		Log.d("++listItemClick3", "pos=" + position + " id=" + id);
		
		super.onListItemClick(listv, v, position, id);

		// Get the item that was clicked
		Object o = this.getListAdapter().getItem(position);
		Log.d("++listItemClick4", "clickedObj type=" + o.getClass().getName());
		Log.d("++listItemClick4", "clickedObj=" + o);
		
		String keyword = o.toString();
		Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_SHORT).show();
	}
    
    
    
}