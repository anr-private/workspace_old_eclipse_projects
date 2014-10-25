package com.maranr.anr_internal_intents_22;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AnrInternalIntents22Activity extends Activity {
	
	Button b1, b2, b3, b4, b5;
	int theRequestCode = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        b1 = (Button) findViewById(R.id.btn_webbrowser);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent(android.content.Intent.ACTION_VIEW,
									  Uri.parse("http://www.amazon.com"));
				// could use i.setData(Uri.....)
				// This causes the MyBrowser activity to be chosen
				// (and the android browser is not used or provided as alternative)
				// When the addCategory() is commented out, the ACTION_VIEW will match
				// both the internal Android browser and our own MyBrowser activity.
				// When the Web Browser button is pressed, Android finds both activities
				// and shows a 'Complete Action Using' dialog.
				// Uncomment the addCategory() and Android selects MyBrowser directly --
				// no dialog is shown.
				//i.addCategory("com.maranr.MaranrApps");
				startActivity(i);
			}
		});

        b2 = (Button) findViewById(R.id.btn_makecalls);
        b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				//Intent i = new Intent(android.content.Intent.ACTION_DIAL,
				//		  Uri.parse("tel:+2105228311"));
				Intent i = new Intent(android.content.Intent.ACTION_DIAL);
				i.setData(Uri.parse("tel:+2105228311"));
				startActivity(i);
			}
		});

        b3 = (Button) findViewById(R.id.btn_showMap);
        b3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent(android.content.Intent.ACTION_VIEW);
				// alternative to using the Uri.parse() as 2nd arg to Intent ctor:
				i.setData(Uri.parse("geo:37.827500,-122.481670"));
				startActivity(i);
			}
		});
    
        b4 = (Button) findViewById(R.id.btn_chooseContact);
        b4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent(android.content.Intent.ACTION_PICK);
				i.setType(ContactsContract.Contacts.CONTENT_TYPE);
				startActivityForResult(i, theRequestCode);
			}
		});
        
        b5 = (Button) findViewById(R.id.btn_launchMyBrowser);
        b5.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent("com.maranr.MyBrowser");
				i.setData(Uri.parse("http://www.amazon.com"));
				startActivityForResult(i, theRequestCode);
			}
		});    
        
    }
    
    public void onActivityResult(int reqCode, int resultCode, Intent intent) {
    	if (reqCode == theRequestCode) {
    		if (resultCode == RESULT_OK) {
    			Log.d("onActResult", "GOT REQ=" +Integer.toString(reqCode)+" RESULT=" +Integer.toString(resultCode));
    			String s = intent.getData().toString();
    			Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
    			t.show();
    		}
    	}
    }

    
}