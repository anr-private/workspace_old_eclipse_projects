package com.maranr.anr_notifier;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;

public class NotifierView extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifier);
		
		// find notification mgr
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		// cancel notification we started
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		int notifId = extras.getInt("notificationId");
		//int notifId = getIntent().getExtras().getInt("notificationId");
		nm.cancel(notifId);
	}

}
