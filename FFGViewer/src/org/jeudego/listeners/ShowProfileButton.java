package org.jeudego.listeners;

import org.jeudego.ffg.MainActivity;
import org.jeudego.ffg.PlayerProfileActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @author simeon
 *
 */
public class ShowProfileButton implements OnClickListener{

	private MainActivity _main_activity;
	
	public ShowProfileButton(MainActivity main_activity){
		this._main_activity = main_activity;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "ShowProfileButton *** public void onClick(View v) ");
		
		//Ask for the profile activity
		Intent i = new Intent(_main_activity.getBaseContext(), PlayerProfileActivity.class );
		
		_main_activity.startActivity(i);
	}

}
