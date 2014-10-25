package com.maranr.anr_time_picker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Demo time and date pickers 
 * Two forms: using picker views directly on the GUI,
 * and using pop-up dialogs.
 * The code demos both ways. It first shows a dialog
 * containing either time or date picker (as set in the
 * showDialog() call at line 48), displaying the choice
 * in a Toast popup. Then you can use the GUI-based pickers
 * and press the button to see their values.
 * 
 * @author tdir
 *
 */
public class MainActivity extends Activity {
	
	TimePicker timePicker;
	DatePicker datePicker;
	
    int hour, minute;    
    int yr, month, day;

    // used for showing dialog
    static final int TIME_DIALOG_ID = 0;
    static final int DATE_DIALOG_ID = 1;

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // To show the dialog form
        //showDialog(TIME_DIALOG_ID);
        showDialog(DATE_DIALOG_ID);
        
        // These are the views used directly on the GUI
    	datePicker = (DatePicker) findViewById(R.id.datePicker);

    	timePicker = (TimePicker) findViewById(R.id.timePicker);
     	timePicker.setIs24HourView(true);

     	// Gets values from the GUI-based pickers (not the dialog)
        Button btnOpen = (Button) findViewById(R.id.btnSet);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Integer intmin = timePicker.getCurrentMinute();
            	String minStg;
            	if (intmin < 10) {
            		minStg = "0" + intmin;
            	} else {
            		minStg = "" + intmin;
            	}
                Toast.makeText(getBaseContext(),
                		"Date selected:" + (datePicker.getMonth() + 1) + 
                		"/" + datePicker.getDayOfMonth() +
                		"/" + datePicker.getYear() + "\n" +
                		"Time selected:" + timePicker.getCurrentHour() + 
                		":" + minStg, 
                        Toast.LENGTH_SHORT).show();
                }
        });

    }
    
    // ================================================================
    // From here on down, these support the dialog form of the pickers
    // (they are not used for the GUI-based pickers)
    
    @Override    
    protected Dialog onCreateDialog(int id) 
    {
        switch (id) {
            case TIME_DIALOG_ID: 
                return new TimePickerDialog(this, mTimeSetListener, hour, minute, false);
            case DATE_DIALOG_ID: 
                return new DatePickerDialog(this, mDateSetListener, yr, month, day);
        }
        return null;    
    }
 
    private DatePickerDialog.OnDateSetListener mDateSetListener =
        new DatePickerDialog.OnDateSetListener() 
        {
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                    int dayOfMonth) 
            {
            	yr = year;
                month = monthOfYear;
                day = dayOfMonth;
                Toast.makeText(getBaseContext(), 
                        "You have selected : " + (month + 1) +
                        "/" + day + "/" + year,
                        Toast.LENGTH_SHORT).show();
            }
        };
        
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
    	new TimePickerDialog.OnTimeSetListener() 
        {        
            public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) 
            {
                hour = hourOfDay;
                minute = minuteOfHour;
                Toast.makeText(getBaseContext(), 
                        "You have selected : " + hour + ":" + minute,
                        Toast.LENGTH_SHORT).show();

            }
        };       
    
    
    
    
}