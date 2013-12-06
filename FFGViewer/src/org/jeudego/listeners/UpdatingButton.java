package org.jeudego.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jeudego.ffg.MainActivity;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class UpdatingButton implements OnClickListener{

	public Button _update_button;
	public MainActivity _main_activity;
	public TextView _last_maj;
	
	public UpdatingButton(MainActivity main_activity, Button update_button, TextView last_maj){
		this._main_activity = main_activity;
		this._update_button = update_button;
		this._last_maj = last_maj;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "UpdatingButton *** public void onClick(View v) ");
		//While it's downloading, avoid multiple click
		this._update_button.setEnabled(false);
		
		// TODO Service in background updating database
				
		//Re-enabled at the end
		//this._update_button.setEnabled(true);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this._last_maj.setText(dateFormat.format(new Date()));
		
		
	}

	
}
