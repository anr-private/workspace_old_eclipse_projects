package com.maranr.anr_listview_chk;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * In spite of this project's name, it does not use Checkbox items in ListView.
 * It is basically an old version of anr_listview_w_styles.
 * 
 * @author tdir
 *
 */
public class MainActivity extends ListActivity {
	
	 String[] presidents = {
	            "Dwight D. Eisenhower",
	            "John F. Kennedy",
	            "Lyndon B. Johnson",
	            "Richard Nixon",
	            "Gerald Ford",
	            "Jimmy Carter",
	            "Ronald Reagan",
	            "George H. W. Bush",
	            "Bill Clinton",
	            "George W. Bush",
	            "Barack Obama"
	    };

	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        ListView lstView = getListView();
        Log.d("onCreate", "LISTVIEW is " + lstView);

        //lstView.setChoiceMode(0); //CHOICE_MODE_NONE
        //lstView.setChoiceMode(1); //CHOICE_MODE_SINGLE
        lstView.setChoiceMode(2);   //CHOICE_MODE_MULTIPLE
        lstView.setTextFilterEnabled(true);
        
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, presidents));
    }
    
    
    public void onListItemClick(ListView parent, View v, int position, long id)  {
    	
    	Log.d("+++onListItemClick", "view=" + v);
    	Log.d("+++onListItemCLICK", "...pos=" + position + "  id=" + id);
    	Log.d("+++onListItemCLIKK", "...isCHECKED=" + parent.isItemChecked(position));
    	
    	//---toggle the check displayed next to the item---
    	boolean flag =  ! parent.isItemChecked(position);
    	Log.d("+++onListClick", "SET CHECKED TO " + flag);
    	parent.setItemChecked(position, flag);
    	
        Toast.makeText(this, 
    	    "You have selected " + presidents[position], 
            Toast.LENGTH_SHORT).show();
    }  
    
    
    
}