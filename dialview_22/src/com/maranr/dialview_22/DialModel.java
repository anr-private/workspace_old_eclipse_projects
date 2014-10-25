package com.maranr.dialview_22;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;

public class DialModel {
	public interface Listener {
		void onDialPositionChanged(DialModel sender, int nicksChanged);
	}
	
	private List<Listener> listeners = new ArrayList<Listener>(); 

	private int totalNicks = 16;
	
	private int currentNick = 0;
	
	public DialModel() {
		
	}

	public final float getRotationInDegrees() {
		return (360.0f / totalNicks) * currentNick;
	}

	public final void rotate(int nicks) {
		currentNick = (currentNick + nicks);
		if (currentNick >= totalNicks) {
			currentNick %= totalNicks;
		} else if (currentNick < 0) {
			currentNick = (totalNicks + currentNick);
		}
		
		for (Listener listener : listeners) {
			listener.onDialPositionChanged(this, nicks);
		}
	}
	
	public final List<Listener> getListeners() {
		return listeners;
	}

	public final int getTotalNicks() {
		return totalNicks;
	}

	public final int getCurrentNick() {
		return currentNick;
	}

	public final void addListener(Listener listener) {
		Log.d("DialModel", "ADD LISTENER CALLED listener=" + listener);
		listeners.add(listener);
	}
	
	public final void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	private static String getBundlePrefix() {
		return DialModel.class.getSimpleName() + ".";
	}
	
	public final void save(Bundle bundle) {
		String prefix = getBundlePrefix();
		
		bundle.putInt(prefix + "totalNicks", totalNicks);
		bundle.putInt(prefix + "currentNick", currentNick);
	}
	
	// Restore this model's state from saved state bundle   ANR
	public void restoreFromBundle(Bundle bundle) {
		if (bundle == null) {
			return;
		}
		String prefix = getBundlePrefix();
		this.totalNicks = bundle.getInt(prefix + "totalNicks");
		this.currentNick = bundle.getInt(prefix + "currentNick");
	}
	
	
	/* @@@@ ANR MODEL FIX
	public static DialModel restore(Bundle bundle) {
		DialModel model = new DialModel();
		
		String prefix = getBundlePrefix();
		model.totalNicks = bundle.getInt(prefix + "totalNicks");
		model.currentNick = bundle.getInt(prefix + "currentNick");
		
		return model;
	}
*/

}
