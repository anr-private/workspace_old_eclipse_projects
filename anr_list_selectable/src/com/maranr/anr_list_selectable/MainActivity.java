package com.maranr.anr_list_selectable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.ListActivity;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.maranr.anr_list_selectable.pojo.MyItem;

/**
 * http://www.marvinlabs.com/2010/10/custom-listview-ability-check-items/
 * See ~/workspace/CODE_SAMPLES/selectablelisttutorial
 * 
 * ListView with custom items that have checkboxes.
 * 
 * NEEDS TO BE DEBUGGED @@@@@@
 */
public class MainActivity extends ListActivity {
	
	private List<MyItem> data;
	private ListView listView;
	private MyItemListAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
		// Create some sample data and sort it alphabetically
		// --
		data = new ArrayList<MyItem>(10);
		data.add(new MyItem(10, "France"));
		data.add(new MyItem(11, "United Kingdom"));
		data.add(new MyItem(12, "Ireland"));
		data.add(new MyItem(13, "Germany"));
		data.add(new MyItem(14, "Belgium"));
		data.add(new MyItem(15, "Luxembourg"));
		data.add(new MyItem(16, "Netherlands"));
		data.add(new MyItem(17, "Italy"));
		data.add(new MyItem(18, "Denmark"));
		data.add(new MyItem(19, "Spain"));
		data.add(new MyItem(20, "Portugal"));
		data.add(new MyItem(21, "Greece"));
		Collections.sort(data, new Comparator<MyItem>() {
			public int compare(MyItem i1, MyItem i2) {
				return i1.getCaption().compareTo(i2.getCaption());
			}
		});

	     // Create the adapter to render our data
	     // --
	     this.adapter = new MyItemListAdapter(this, data);
	     ListAdapter adapter = new MyItemListAdapter(this, data);
	     this.setListAdapter(adapter);
	
	     // Get some views for later use
	     // --
	     listView = this.getListView();
	     listView.setItemsCanFocus(false);
    }
    
    
    
    /*
    final SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
if (checkedItems == null) {
	// That means our list is not able to handle selection
	// (choiceMode is CHOICE_MODE_NONE for example)
	return;
}

// For each element in the status array
final int checkedItemsCount = checkedItems.size();
for (int i = 0; i < checkedItemsCount; ++i) {
	// This tells us the item position we are looking at
	final int position = checkedItems.keyAt(i);

	// And this tells us the item status at the above position
	final boolean isChecked = checkedItems.valueAt(i);

	// And we can get our data from the adapter like that
	final Item currentItem = adapter.getItem(position);
}
*/
}