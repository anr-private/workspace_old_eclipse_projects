package com.maranr.anr_list_selectable;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.maranr.anr_list_selectable.pojo.MyItem;



public class MyItemListAdapter extends ArrayAdapter<MyItem> {
	
	private LayoutInflater li;

	/**
	 * Constructor from a list of items
	 */
	public MyItemListAdapter(Context context, List<MyItem> items) {
		super(context, 0, items);
		this.li = (LayoutInflater) 
			context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// This is how you would determine if this particular item is checked
		// when the view gets created
		// 
		//final ListView lv = (ListView) parent;
		//final boolean isChecked = lv.isItemChecked(position);

		// The item we want to get the view for
		// 
		final MyItem item = this.getItem(position);

		// Re-use the view if possible - else create 
		// 
		View v = convertView;
		if (v == null) {
			ViewGroup root = null; // no group
			v = li.inflate(R.layout.myitem, root);
		}

		// Set some view properties (We should use the view holder pattern in
		// order to avoid all the findViewById and thus improve performance)
		// @@@@ do this improvement
		final TextView idView = (TextView) v.findViewById(R.id.itemId);
		if (idView != null) {
			idView.setText("#" + item.getId());
		}

		final TextView captionView = (TextView) v.findViewById(R.id.itemCaption);
		if (captionView != null) {
			captionView.setText(item.getCaption());
		}

		return v;
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}


}


// ### end ###