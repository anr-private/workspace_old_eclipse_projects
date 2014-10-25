package com.maranr.dialview_22;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity  implements DialModel.Listener  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
	    DialView dial1 = (DialView) findViewById(R.id.dial_1);
	    dial1.getModel().addListener(this);
	    /*
	    DialView dial2 = (DialView) findViewById(R.id.dial_2);
	    dial2.getModel().addListener(this);
	    */
    }

	//@Override
	public void onDialPositionChanged(DialModel sender, int nicksChanged) {
		Log.d("MAIN", "onDialPosChgd nicks=" + nicksChanged);
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(sender.getCurrentNick() + "");
	}

}