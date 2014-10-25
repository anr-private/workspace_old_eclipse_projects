package com.maranr.dialogdemo;

import android.app.Activity;

import android.os.Bundle;
//import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
// for progress dialog
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends Activity {
	
	CharSequence[] items = {"Google", "Apple", "Micro$oft"};
	boolean[] itemsChecked = new boolean [items.length];
	
	private ProgressDialog _progressDialog;
	private int _progress = 0;
	private Handler _progressHandler;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.btn_dialog);
        btn.setOnClickListener(
        	new View.OnClickListener() {
				
				public void onClick(View v) {
					showDialog(0);
					
					//showDialog(1);
					//_progress = 0;
					//_progressDialog.setProgress(0);
					//_progressHandler.sendEmptyMessage(0);
				}
			});
        
        Button btn2 = (Button) findViewById(R.id.btn_dialog2);
        btn2.setOnClickListener(
        	new View.OnClickListener() {
				
				public void onClick(View v) {
					//showDialog(0);
					
					showDialog(1);
					_progress = 0;
					_progressDialog.setProgress(0);
					_progressHandler.sendEmptyMessage(0);
				}
			});
        
        _progressHandler = new Handler() {
        	public void handleMessage(Message mesg) {
        		super.handleMessage(mesg);
        		if (_progress >= 100) {
        			_progressDialog.dismiss();
        		} else {
        			_progress += 1;
        			_progressDialog.incrementProgressBy(1);
        			_progressHandler.sendEmptyMessageDelayed(0,  100);
        		}
        	}
        };
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	switch (id) {
    	case 0:
    		AlertDialog d = new AlertDialog.Builder(this)
    			.setIcon(R.drawable.icon)
    			.setTitle("This is my dialog with simple text")
    			.setPositiveButton("OK",
    					new DialogInterface.OnClickListener() {
							
							public void onClick(DialogInterface dialog, int whichButton) {
								Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();									
								
							}
						})
				.setNegativeButton("Cancel",
    					new DialogInterface.OnClickListener() {
					
							public void onClick(DialogInterface dialog, int whichButton) {
								Toast.makeText(getBaseContext(), "CANCEL clicked!", Toast.LENGTH_SHORT).show();									
								
							}
						})
				.setMultiChoiceItems(items, itemsChecked, 
						new DialogInterface.OnMultiChoiceClickListener() {
							
							public void onClick(DialogInterface dialog, int which, boolean isChecked) {
								Toast.makeText(getBaseContext(), 
									items[which] + (isChecked ? " checked!" : " unchecked!!"),
									Toast.LENGTH_SHORT).show();
							}
						})
				.create();
    		return d;
    		
    	case 1:
    		_progressDialog = new ProgressDialog(this);
    		_progressDialog.setIcon(R.drawable.icon);
    		_progressDialog.setTitle("DOWNloading junk...");
    		_progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    		_progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Hide",
    				new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getBaseContext(), "HIDE clicked!", Toast.LENGTH_SHORT).show();
						}
					});
    		_progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
    				new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getBaseContext(), "CANCEL clicked!", Toast.LENGTH_SHORT).show();
						}
					});
    		
    		return _progressDialog;
    	}

    	return null;
    }
}