package aexp.buttonlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.util.Log;
import java.util.List;

public class ButtonListAdapter extends BaseAdapter {

    public static final String LOG_TAG = "ButtonListAdapter";

    private Context context;
    private List<ButtonRow> buttonList;
	private int rowResID;

    public ButtonListAdapter(Context context, int rowResID,
						List<ButtonRow> buttonList ) { 
        this.context = context;
		this.rowResID = rowResID;
        this.buttonList = buttonList;
    }

    public int getCount() {                        
        return buttonList.size();
    }

    public Object getItem(int position) {     
        return buttonList.get(position);
    }

    public long getItemId(int position) {  
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) { 
        ButtonRow row = buttonList.get(position);
        LayoutInflater inflater = LayoutInflater.from( context );
		View v = inflater.inflate(  rowResID, parent, false );
		TextView textTextControl = (TextView)v.findViewById( R.id.text1 );
		if( textTextControl != null )
			textTextControl.setText( Integer.toString( row.getValue() ) );
		Button buttonControl = 
                (Button)v.findViewById( R.id.increase_button );
		if( buttonControl != null ) {
            String buttonText = row.getButtonText();
			buttonControl.setText( buttonText );
            buttonControl.setFocusable( false );
            IncreaseCallbackHandler ch = 
                    new IncreaseCallbackHandler( textTextControl, row );
            buttonControl.setOnClickListener( ch );
        }
        return v;
    }

    class IncreaseCallbackHandler implements View.OnClickListener {
        public IncreaseCallbackHandler( 
                TextView textView,
                ButtonRow row ) {
            this.textView = textView;
            this.row = row;
        }

        public void onClick(View view) {
            int v = row.increaseValue();
            textView.setText( Integer.toString( v ) );
        }

        TextView textView;
        ButtonRow row;
    }

}
