package aexp.buttonlist;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.SimpleAdapter;


import java.util.HashMap;
import java.util.ArrayList;

public class ButtonList extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayList<ButtonRow> list = new ArrayList<ButtonRow>();
        list.add( new ButtonRow( 0, "increase" ) );
        list.add( new ButtonRow( 16, "increase" ) );
        list.add( new ButtonRow( 211, "increase" ) );

        ButtonListAdapter notes = new ButtonListAdapter( 
				this, 
				R.layout.buttonrow,
                list );
        setListAdapter( notes );

    }
}
