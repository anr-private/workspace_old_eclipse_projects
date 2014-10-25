package com.maranr.anr_spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String[] presidents;	 

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        presidents = 
                this.getResources().getStringArray(R.array.presidents_huge_array);
        
        Spinner s1 = (Spinner) this.findViewById(R.id.spinner1);
        
        // Adding 'dropdown' is supposed to show radio buttons, but
        // in 3.2 emulator it just makes the text of the items larger.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        											android.R.layout.simple_spinner_item, 
        											//android.R.layout.simple_spinner_dropdown_item, 
        											presidents);
 
        s1.setAdapter(adapter);
        
        // Listener gets called when a selection is made UNLESS THE VALUE
        // is the same as the currently-selected value, in which case no
        // callback occurs(!)
        s1.setOnItemSelectedListener(new OnItemSelectedListener()
        {
        	//@Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
            {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), 
                    "You have selected item : " + presidents[index], 
                    Toast.LENGTH_SHORT).show();                
            }

            // Should fire if you dismiss the popup - does not seem to work(!?)
			//@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Toast.makeText(getBaseContext(), "You selected nothing!", Toast.LENGTH_SHORT).show();
			} 
        });        

    }
}