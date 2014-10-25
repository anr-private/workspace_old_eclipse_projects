package com.maranr.anr_list_selectable.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * Extension of a RelativeLayout to provide a Checkable behavior.
 * A 'plain' RelativeLayout does not handle/provide Checkable.
 * 
 * You could replace RelativeLayout with any layout class.
 * 
 */

public class CheckableRelativeLayout extends RelativeLayout 
									 implements Checkable {
	
	private boolean isChecked;
	private List<Checkable> checkableViews;

	public CheckableRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		initialise(attrs);
	}

	public CheckableRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialise(attrs);
	}

	public CheckableRelativeLayout(Context context, int checkableId) {
		super(context);
		initialise(null);
	}

	/* Checkable impl.
	 * @see android.widget.Checkable#isChecked()
	 */
	public boolean isChecked() {
		return this.isChecked;
	}

	/* Checkable impl.
	 * @see android.widget.Checkable#setChecked(boolean)
	 */
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
		for (Checkable c : checkableViews) {
			c.setChecked(isChecked);
		}
	}

	/* Checkable impl.
	 * @see android.widget.Checkable#toggle()
	 */
	public void toggle() {
		this.isChecked =  ! this.isChecked;
		for (Checkable c : this.checkableViews) {
			c.toggle();
		}
	}

	/**
	 * discover automatically the child widgets that implement the Checkable interface
	 */
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		final int childCount = this.getChildCount();
		for (int i = 0; i < childCount; ++i) {
			this.findCheckableChildren(this.getChildAt(i));
		}
	}

	/**
	 * Add to our checkable list all the children of the view that implement the
	 * interface Checkable
	 */
	private void findCheckableChildren(View v) {
		if (v instanceof Checkable) {
			this.checkableViews.add((Checkable) v);
		}

		if (v instanceof ViewGroup) {
			final ViewGroup vg = (ViewGroup) v;
			final int childCount = vg.getChildCount();
			for (int i = 0; i < childCount; ++i) {
				this.findCheckableChildren(vg.getChildAt(i));
			}
		}
	}

	/**
	 * Read the custom XML attributes
	 */
	private void initialise(AttributeSet attrs) {
		this.isChecked = false;
		this.checkableViews = new ArrayList<Checkable>(5);
	}

}
