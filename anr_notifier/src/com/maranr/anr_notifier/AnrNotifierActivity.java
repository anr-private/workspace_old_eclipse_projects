package com.maranr.anr_notifier;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnrNotifierActivity extends Activity {
	
	int theNotifId = 1;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b = (Button) findViewById(R.id.show_notif_button);
        b.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		displayNotification();
        	}
        });
    }
    
    protected void displayNotification() {
    	// create a PendingIntent to launch our activity when user selects notification
    	Intent i = new Intent(this, NotifierView.class);
    	i.putExtra("notificationId", theNotifId);
    	
    	int reqCode = 0;
    	int flags = 0;
    	PendingIntent pendingIntent = PendingIntent.getActivity(this, reqCode, i, flags);
    	
    	Notification notif = new Notification(R.drawable.icon,
    										  "NOTIFYING YOU! Mtg starts now",
    										  System.currentTimeMillis());
    	
    	CharSequence from = "System Alarm";
    	CharSequence message = "Mtg with BIG CHEESE soon!";
    	
    	notif.setLatestEventInfo(this, from, message, pendingIntent);
    	
    	// 100 ms delay, vibrate for 250ms, pause 100 ms, vibrate 500 ms
    	notif.vibrate = new long[] {100, 250, 100, 500};
    	
    	// Post the notification
    	NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    	nm.notify(theNotifId, notif);
    }
}