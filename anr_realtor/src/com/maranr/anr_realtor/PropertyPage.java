package com.maranr.anr_realtor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewSwitcher.ViewFactory;

// Implements ViewFactory to support the ImageSwitcher used for photos tab.
// Requires method makeView().

public class PropertyPage extends Activity implements ViewFactory {

    private Integer[] _imageIds = {
            R.drawable.entry_gate,  // 1
            R.drawable.exterior_1,
            R.drawable.exterior_2,
            R.drawable.dining_formal_1, 
            R.drawable.family_1,  // 5
            R.drawable.family_2,
            R.drawable.kitchen_1,
            R.drawable.kitchen_2,
            R.drawable.kitchen_3, 
            R.drawable.dining_1,  // 10
            R.drawable.master_bed,
            R.drawable.master_bed_2,
            R.drawable.master_bath_1,
            R.drawable.stairs_up,   
            R.drawable.bedrm_a_1, // 15
            R.drawable.upstairs_game_1,
            R.drawable.upstairs_ofc_1,
            R.drawable.treehouse_1,
            R.drawable.pool_1,  
            R.drawable.garage_1, // 20
            R.drawable.garage_guest_1,
            R.drawable.garage_guest_2,
            R.drawable.garage_guest_3,
            R.drawable.garage_guest_4,
            R.drawable.garage_guest_5,

    };
    private String[] _imageDescs = {
    		"Entry gate - street to driveway", // 1
    		"Exterior, front of house",
    		"Exterior, front of house",
    		"Dining Room, formal area",
    		"Family Room",   // 5
    		"Family Room", 
    		"Kitchen",
    		"Kitchen",
    		"Kitchen",
    		"Breakfast dining area, adjacent to kitchen",
    		"Master Bedroom",
    		"Master Bedroom",
    		"Master Bathroom",
    		"Stairs leading to second floor",
    		"Upstairs bedroom",
    		"Game Room (upstairs)",
    		"Office (upstairs)",
    		"Tree House, back yard",
    		"Pool",
    		"Garage / Guest House",
    		"Garage / Guest House",
    		"Garage / Guest House",
    		"Garage / Guest House",
    		"Garage / Guest House",
    		"Garage / Guest House",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    		"",
    };

    private ImageSwitcher _imageSwitcher;
    private TextView _photoDescTV;
    // Save the most recently selected photo on photos tab.
    private int _photo_image_number = 0;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d("propPage", "onCreate CALLED");
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // keep keyboard from popping up on some devices
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
		setContentView(R.layout.property_page);

		// Optional: get info passed to us through the Intent
		Bundle bundleExtras = getIntent().getExtras();
		Log.d("propPg", "got extras=" + bundleExtras);

		String defaultName = "";
		if (bundleExtras != null) {
			defaultName = bundleExtras.getString("Name");
		}
		Log.d("propPg", "got defaultName=" + defaultName);
		
		// ******************************************************
		// *****   TABS SETUP    ********************************
		// ******************************************************
	    TabHost tabs=(TabHost)findViewById(R.id.tabhost);
	    if (tabs != null) {
		    tabs.setup();
		    
		    TabHost.TabSpec spec=null;
		    
		    spec = tabs.newTabSpec("overview_tag");
		    spec.setContent(R.id.overview_tab);
		    spec.setIndicator("Overview");
		    tabs.addTab(spec);
		    
		    spec = tabs.newTabSpec("photos_tag");
		    spec.setContent(R.id.photos_tab);
		    spec.setIndicator("Photos");
		    tabs.addTab(spec);
		    
		    spec = tabs.newTabSpec("area_tag");
		    spec.setContent(R.id.area_tab);
		    spec.setIndicator("Area");
		    tabs.addTab(spec);
		    
		    spec = tabs.newTabSpec("history_tag");
		    spec.setContent(R.id.history_tab);
		    spec.setIndicator("History");
		    tabs.addTab(spec);
	    }
	    
	    
		// ******************************************************
		// *****   OVERVIEW TAB   *******************************
		// ******************************************************

	    ImageView imageView = (ImageView) findViewById(R.id.overview_image);    
        if (imageView != null) {
	        Integer imageId = R.drawable.overview;
	        imageView.setImageResource(imageId);
        }
        

		// ******************************************************
		// *****   PHOTOS TAB     *******************************
		// ******************************************************

        this._imageSwitcher = (ImageSwitcher) findViewById(R.id.photo_img_switcher);
        this._imageSwitcher.setFactory(this);
        this._imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                //android.R.anim.slide_in_left
                android.R.anim.fade_in
                ));
        this._imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                //android.R.anim.slide_out_right
                android.R.anim.fade_out
                ));
        
        this._photoDescTV = (TextView) findViewById(R.id.photo_desc_tv);

        Gallery gallery = (Gallery) findViewById(R.id.photo_gallery);
        gallery.setAdapter(new ImageAdapter(this, this._imageIds));
        
        gallery.setOnItemClickListener(new OnItemClickListener()  {
            public void onItemClick(AdapterView<?> parent, 
            						View v, int position, long id)   {
            	Log.d("onItemClick1", "adapterView parent=" + parent.getClass().getName());
            	Log.d("onItemClick2", "  view=" + v.getClass().getName());
            	Log.d("onItemClick3", "  pos=" + position + " id=" + id);
            	// NOTE _imageSwitcher, _imageIds are attribs of the enclosing class
            	// (but you cannot use 'this._imageSwitcher' because 'this' refers
            	// to the anonymous subclass of OnItemClickListener().
            	// Short form is:_imageSwitcher.setImageResource(_imageIds[position]);
            	// Long form: get the 'this' for the enclosing class use 'Classname.this' form
            	PropertyPage enclosingThis = PropertyPage.this;
            	enclosingThis._imageSwitcher.setImageResource(enclosingThis._imageIds[position]);
            	enclosingThis._photoDescTV.setText(enclosingThis._imageDescs[position]);
            	enclosingThis._photo_image_number = position;
            }
        });  
    
        
		// ******************************************************
		// *****   AREA TAB       *******************************
		// ******************************************************
	    Button btn1 = (Button) findViewById(R.id.wide_area_btn);
	    btn1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {            	
	        	String str = "You have clicked the WIDE button";
	            displayToast(str);
	        }
	    });
	
	    //---Button view---
	    Button btn2 = (Button) findViewById(R.id.txt_wrapped_area_btn);
	    btn2.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            displayToast("You have clicked the text-wrapped button");
	        }
	    });
	
	    //---image Button view---
	    // NOTE this got an error if used just 'Button' instead of ImageButton(!)
	    ImageButton btn3 = (ImageButton) findViewById(R.id.area_img_btn);
	    btn3.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            displayToast("You have clicked the IMAGE button");
	        }
	    });

	    CheckBox checkBox = (CheckBox) findViewById(R.id.area_chkbox);
	    checkBox.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	            if (((CheckBox)v).isChecked()) 
	                displayToast("Plain CheckBox is checked");
	            else
	                displayToast("Plain CheckBox is unchecked");            
	        }
	    });
	
	    //---Styled CheckBox (star shaped) ---
	    CheckBox starCheckBox = (CheckBox) findViewById(R.id.area_star_chkbox);
	    starCheckBox.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	            if (((CheckBox)v).isChecked()) 
	                displayToast("Star CheckBox is checked");
	            else
	                displayToast("Star CheckBox is unchecked");            
	        }
	    });

	    //---RadioButton vertical group ---
	    // NOTE orientation is set in the main.xml; layout_width is different for vert vs horiz 
	    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.area_vert_rdb_group);
	    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {                              
	            RadioButton rb1 = (RadioButton) findViewById(R.id.area_vert_rb_1); 
	            if (rb1.isChecked()) {
	            	displayToast("Option 1 checked!");                	
	            } else {
	            	displayToast("Option 2 checked!");
	            }
	        }
	    });
	
	    //---RadioButton horizontal group ---
	    // NOTE orientation is set in the main.xml; layout_width is different for vert vs horiz 
	    RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.area_horiz_rdb_group);        
	    radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
	        public void onCheckedChanged(RadioGroup group, int checkedId) {                              
	            RadioButton rb3 = (RadioButton) findViewById(R.id.area_horiz_rdb_1); 
	            if (rb3.isChecked()) {
	            	displayToast("Option A checked!");                	
	            } else {
	            	displayToast("Option B checked!");
	            }
	        }
	    });

	    ToggleButton toggleButton = (ToggleButton) findViewById(R.id.area_toggle_btn_1);
	    toggleButton.setOnClickListener(new View.OnClickListener() 
	    {
	        public void onClick(View v) {
	           if (((ToggleButton)v).isChecked())
	                displayToast("Toggle button is On");
	           else
	               displayToast("Toggle button is Off");
	        }
	    });
      
        // RESTORE the saved state (if any)
        this._restoreState(savedInstanceState);
	}
        
        /*
		Object obj = findViewById(R.id.txt_username);
		Log.d("propPG", "got EDITTEXT obj=" + obj.getClass().getName() + " obj=" + obj);

		EditText txt_username = (EditText) findViewById(R.id.txt_username);
		Log.d("propPG", "got EDITTEXT txt_uname=" + txt_username);
		txt_username.setHint(defaultName);
		
		Button btn = (Button) findViewById(R.id.btn_ok);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				// find EditText
				EditText txt_usrname = (EditText)findViewById(R.id.txt_username);
				String s = txt_usrname.getText().toString();
				
				Bundle bundle = new Bundle();
				bundle.putString("uname", s);
				
				Intent intent = new Intent();
				intent.putExtras(bundle);
				
				Log.d("PropPageEvent", "PROP PAGE returns s='" + s + "'");
				Log.d("PropPageEvent", "PROP PAGE returns bundle=" + bundle);
				
				// Uri uri = Uri.parse(s);
				// intent.setData(uri);
				
				PropertyPage.this.setResult(RESULT_OK, intent);
				
				// end the activity
				PropertyPage.this.finish();
			}
		});

	
	}*/
	
	
	@Override
	protected void onSaveInstanceState(Bundle bundle)  {
		super.onSaveInstanceState(bundle);
		
	    TabHost tabHost =(TabHost)findViewById(R.id.tabhost);
	    if (tabHost != null) {
	    	int tabNumber = tabHost.getCurrentTab();
	    	bundle.putInt("photoTab", tabNumber);
	    }
	    bundle.putInt("photo_image_number", this._photo_image_number);
	}
	
	private void _restoreState(Bundle bundle)  {
		if (bundle == null) {
			return;
		}
		
	    TabHost tabHost =(TabHost)findViewById(R.id.tabhost);
	    if (tabHost != null) {
			Integer tab = bundle.getInt("photoTab");
			if (tab != null) {
				int tabNumber = tab.intValue();
				tabHost.setCurrentTab(tabNumber);
			}
		}		
		Integer tab = bundle.getInt("photoTab");
		Log.d("PropPage", "_restoreState  tab=" + tab);
		
		Integer pin = bundle.getInt("photo_image_number");
		if (pin != null) {
			int photo_image_number = pin.intValue();
			this._photo_image_number = photo_image_number;
        	this._imageSwitcher.setImageResource(this._imageIds[photo_image_number]);
        	this._photoDescTV.setText(this._imageDescs[photo_image_number]);
		}
	}
	
	// Supports the photos tab. Required by ViewFactory ifc
    public View makeView() {
    	Log.d("makeView", "CALLED");
    	
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF000088);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new 
                ImageSwitcher.LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.FILL_PARENT));
        return imageView;
    }
	
    
	private void displayToast(String msg)  {
	     Toast.makeText(getBaseContext(), msg, 
	             Toast.LENGTH_SHORT).show();        
	}    
        
}
