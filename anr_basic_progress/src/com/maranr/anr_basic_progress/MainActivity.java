package com.maranr.anr_basic_progress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/** 
 * Demo of the progress indicators.
 * Basic demo shows 'circling' style indicator (just goes round and round)
 * Adding 'horizontal' style creates horizontal bar indicator.
 * @author tdir
 *
 */
public class MainActivity extends Activity {
	
    private ProgressBar progressBar;
    private Handler handler = new Handler();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        // This is not needed for the basic 'circling' progress indicator.
        // It is used for the 'bar' indicator (i.e, if main.xml def'n of 
        // the ProgressBar has 'style="?android:attr/progressBarStyleHorizontal"'
        progressBar.setMax(200);

        // Runs in bkgnd thread
        Runnable runnable = new Runnable() {

        	private int progressState = 0;
        	
            public void run()  {
            	while (progressState < 200) {
            		Log.d("bkgnd.run", "progState=" + progressState);
            		progressState = doSomeWork(progressState);
                    
                    
                    Runnable poster = new Runnable() { 
                        public void run() {
                            progressBar.setProgress(progressState);
                        }
                    };
                    handler.post(poster);
            	}
            	Log.d("bkgnd.run", "WORK LOOP COMPLETED... hiding the progress bar.");
            	
            	// Done doing 'work'. Hide the progress bar.
            	Runnable hider = new Runnable() {
            		public void run() {
            			Log.d("hider.run", "SET VISIBILITY to 'gone'");
                        //---0 - VISIBLE; 4 - INVISIBLE; 8 - GONE---
            			int visibility0 = View.VISIBLE;
            			int visibility4 = View.INVISIBLE; // leaves view widget, occupies room on GUI
            			int visibility8 = View.GONE;      // removes view, view objs below it collapse upwards
                        progressBar.setVisibility(visibility4);
            		}
            	};
                handler.post(hider);
        	}

            private int doSomeWork(int progressValue)  {
                try {
                    //---simulate doing some work---
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return progressValue + 1;
            }
        };
        
        Thread thd = new Thread(runnable);
        thd.start();  
        
    }
}