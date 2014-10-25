package com.mindtherobot.samples.dialview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends Activity implements DialModel.Listener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DialView dial = (DialView) findViewById(R.id.dial);
        dial.getModel().addListener(this);
    }

	@Override
	public void onDialPositionChanged(DialModel sender, int nicksChanged) {
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(sender.getCurrentNick() + "");
	}
}