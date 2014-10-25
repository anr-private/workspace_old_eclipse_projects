package com.maranr.anr_anr_btn_test;

/**
 * Custom buttons featuring both text and image on same button,
 * plus use of background images to show button states visibly (focused, pressed, disabled).
 *  
 * http://stackoverflow.com/questions/1532876/android-combining-text-image-on-a-button-or-imagebutton
 */


import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}