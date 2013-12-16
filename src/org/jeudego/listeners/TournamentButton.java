package org.jeudego.listeners;

import org.jeudego.ffg.MainActivity;
import org.jeudego.ffg.TournamentsActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class TournamentButton implements OnClickListener{
	
	private MainActivity _main_activity;
	
	public TournamentButton(MainActivity main_activity){
		_main_activity=main_activity;
	}

	@Override
	public void onClick(View v) {
		//Ask for the tournament schedule activity
		Intent i = new Intent(_main_activity.getBaseContext(), TournamentsActivity.class );		
		_main_activity.startActivity(i);
		
	}


}
