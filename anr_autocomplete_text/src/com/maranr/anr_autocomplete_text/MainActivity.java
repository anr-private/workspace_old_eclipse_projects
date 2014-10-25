package com.maranr.anr_autocomplete_text;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	
	 private String[] presidents = 
		    {
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
        setContentView(R.layout.main);
        
        // manages the list for the autocomplete view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, presidents);
     
        // AutoCompleteTextView is actually a type of EditView (which is a TextView subclass)
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.txtPresidents);
        
        // min number of chars user must type into autocomplete view before
        // the suggestions appear
        textView.setThreshold(3);
        // install the suggestions into the view obj
        textView.setAdapter(adapter);      
    }
}