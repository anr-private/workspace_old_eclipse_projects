package com.maranr.anrtwoacts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);

		// Optional: get info passed to us through the Intent
		Bundle bundleExtras = getIntent().getExtras();
		String defaultName = "";
		if (bundleExtras != null) {
			defaultName = bundleExtras.getString("Name");
		}
		EditText txt_username = (EditText) findViewById(R.id.txt_username);
		txt_username.setHint(defaultName);
		
		Button btn = (Button) findViewById(R.id.btn_ok);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
				
				// find EditText
				EditText txt_usrname = (EditText)findViewById(R.id.txt_username);
				
				String s = txt_usrname.getText().toString();
				Log.d("Act2Event", "ACT2 returns s='" + s + "'");
				Uri uri = Uri.parse(s);
				intent.setData(uri);
				setResult(RESULT_OK, intent);
				
				// end the activity
				finish();
			}
		});
	}
}
