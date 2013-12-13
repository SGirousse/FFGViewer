package org.jeudego.listeners;

import org.jeudego.ffg.MainActivity;
import org.jeudego.ffg.SplashScreenFFGActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @author simeon
 *
 */
public class AccessFFGButton implements OnClickListener{

	private MainActivity _main_activity;
	
	public AccessFFGButton(MainActivity main_activity){
		this._main_activity = main_activity;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "AccessFFGButton *** public void onClick(View v)");
		
		//We're gone to access FFG web site via a browser
		Intent i = new Intent(this._main_activity.getBaseContext(), SplashScreenFFGActivity.class);

		this._main_activity.startActivity(i);
	}

}
