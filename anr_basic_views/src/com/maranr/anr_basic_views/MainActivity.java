package com.maranr.anr_basic_views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
	    //---Button view---
	    Button btnOpen = (Button) findViewById(R.id.btnOpen);
	    btnOpen.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {            	
	        	String str = "You have clicked the Open button";
	            displayToast(str);
	        }
	    });
	
	    //---Button view---
	    Button btnSave = (Button) findViewById(R.id.btnSave);
	    btnSave.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            displayToast("You have clicked the Save button");
	        }
	    });
	
	    //---image Button view---
	    // NOTE this got an error if used just 'Button' instead of ImageButton(!)
	    ImageButton btnImg1 = (ImageButton) findViewById(R.id.btnImg1);
	    btnImg1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            displayToast("You have clicked the IMAGE button");
	        }
	    });

	    //---CheckBox---
	    CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
	    checkBox.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	            if (((CheckBox)v).isChecked()) 
	                displayToast("Plain CheckBox is checked");
	            else
	                displayToast("Plain CheckBox is unchecked");            
	        }
	    });
	
	    //---Styled CheckBox (star shaped) ---
	    CheckBox starCheckBox = (CheckBox) findViewById(R.id.starCheckbox);
	    starCheckBox.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	            if (((CheckBox)v).isChecked()) 
	                displayToast("Star CheckBox is checked");
	            else
	                displayToast("Star CheckBox is unchecked");            
	        }
	    });
	
	    //---RadioButton vertical group ---
	    // NOTE orientation is set in the main.xml; layout_width is different for vert vs horiz 
	    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);        
	    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {                              
	            RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1); 
	            if (rb1.isChecked()) {
	            	displayToast("Option 1 checked!");                	
	            } else {
	            	displayToast("Option 2 checked!");
	            }
	        }
	    });
	
	    //---RadioButton horizontal group ---
	    // NOTE orientation is set in the main.xml; layout_width is different for vert vs horiz 
	    RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.rdbGp2);        
	    radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {                              
	            RadioButton rb3 = (RadioButton) findViewById(R.id.rdb3); 
	            if (rb3.isChecked()) {
	            	displayToast("Option A checked!");                	
	            } else {
	            	displayToast("Option B checked!");
	            }
	        }
	    });

	    //---ToggleButton---
	    ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle1);
	    toggleButton.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	           if (((ToggleButton)v).isChecked())
	                displayToast("Toggle button is On");
	           else
	               displayToast("Toggle button is Off");
	        }
	    });
	}

	private void displayToast(String msg)
	{
	     Toast.makeText(getBaseContext(), msg, 
	             Toast.LENGTH_SHORT).show();        
	}    
    
}