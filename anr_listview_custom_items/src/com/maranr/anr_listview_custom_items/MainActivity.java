package com.maranr.anr_listview_custom_items;

import java.util.ArrayList;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Uses ListView with a custom adapter and custom list entry ('row') classes.
 * Also has progress dialog to simulate loading data from source such 
 * as a web page or other service on the network.
 * Uses 'background' thread to 'get items from network' to populate the ListView. 
 * Shows a progress dialog while 'waiting'. Uses runOnUiThread(runnable) to put 
 * the results into the ListView and update the GUI.
 * 
 * http://www.softwarepassion.com/android-series-custom-listview-items-and-adapters/
 * 
 * @author tdir
 *
 */
// NOTE extends ListActivity
public class MainActivity extends ListActivity {
	
    private ProgressDialog 		m_ProgressDialog = null;
    private ArrayList<Order> 	m_orders = null;
    private OrderAdapter 		m_adapter;
    private Runnable viewOrders;
 
    // used to return the result from the 'loading from the network'
    // of m_orders array
    // NOTE: runs in the GUI thread
    private Runnable returnRes = new Runnable() {
    	// the decorator causes an error - commented out for now ANR
        //@Override
    	public void run() {
            m_ProgressDialog.dismiss();
            
            if (m_orders != null && m_orders.size() > 0) {
            	// don't know why need to notify here ... works ok without it
            	// maybe to display the 'main_no_items' mesg(?) - see main.xml
                m_adapter.notifyDataSetChanged();
                for(int i=0;  i < m_orders.size();  i++) {
                	m_adapter.add(m_orders.get(i));
                }
                /*
                try {
                	Thread.sleep(5000);// @@@
                } catch (Exception e) {
                    Log.e("BACKGROUND_PROC", e.getMessage());
                }*/
            }
            m_adapter.notifyDataSetChanged();
    	}
      };
      
      
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        m_orders = new ArrayList<Order>();
        this.m_adapter = new OrderAdapter(this, R.layout.row, m_orders);
                setListAdapter(this.m_adapter);
       
        viewOrders = new Runnable(){
            //@Override
            public void run() {
                getOrders();
            }
        };
    Thread thread =  new Thread(null, viewOrders, "MagentoBackground");
        thread.start();
        // @@@ WAS m_ProgressDialog = ProgressDialog.show(MainActivity.this,    
        m_ProgressDialog = ProgressDialog.show(this,    
              "Please wait...", "Retrieving data ...", true);
    }
    

    public void onListItemClick(ListView parent, View v, 
								int position, long id) {   

    	Order order = m_orders.get(position);
    	Toast.makeText(this, 
    			"You have selected:  " + order.getOrderName() + "; status=" + order.getOrderStatus(), 
    			Toast.LENGTH_SHORT).show();
    }
    
    
    /* Instead of creating our simple orders in the method above you could of course 
     * download them from somewhere and assign the result to the m_orders array list. 
     * The method runOnUIThread is a utility method for running tasks back on the 
     * main UI thread after the job is done on the separate thread created for 
     * long running tasks. We will call our getOrders method from a separate thread.
     */
    private void getOrders(){
        try{

            Order o1 = new Order();
            o1.setOrderName("Cheeseburger");
            o1.setOrderStatus("Pending");
            
            Order o2 = new Order();
            o2.setOrderName("Large Fries");
            o2.setOrderStatus("Completed");

            m_orders = new ArrayList<Order>();
            m_orders.add(o1);
            m_orders.add(o2);
            
            // Simulate network delay
            Thread.sleep(3000);
            Log.i("ARRAY", ""+ m_orders.size());
            
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }
        
        runOnUiThread(returnRes);
    }
    
    // The Order and OrderAdapter were private classes defined here like this one:
    private class JunkClass extends Object {
    }
    
}