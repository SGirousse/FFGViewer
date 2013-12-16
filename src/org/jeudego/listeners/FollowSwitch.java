package org.jeudego.listeners;

import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FollowSwitch implements OnCheckedChangeListener{

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		Log.i("TRACE", "FollowSwitch *** public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)");
		
	}

}
