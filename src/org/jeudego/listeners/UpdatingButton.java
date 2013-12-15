package org.jeudego.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jeudego.database.PlayerDataSource;
import org.jeudego.ffg.MainActivity;
import org.jeudego.pojo.Player;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class UpdatingButton implements OnClickListener{

	public ImageButton _update_button;
	public MainActivity _main_activity;
	public TextView _last_maj;
	
	public UpdatingButton(MainActivity main_activity, ImageButton update_button, TextView last_maj){
		this._main_activity = main_activity;
		this._update_button = update_button;
		this._last_maj = last_maj;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "UpdatingButton *** public void onClick(View v) ");
		
		String toaster_msg = "Update message";

		//Player list
		PlayerDataSource player_dao = new PlayerDataSource(_main_activity);
		
		//While it's downloading, avoid multiple click
		_update_button.setEnabled(false);
		
		player_dao.open(true);
        
        player_dao.deleteAllPlayers();
        
		player_dao.insertPlayer(new Player(1,"CLAIR", "Yves", "9951702", "-411", "64Pa"));
        player_dao.insertPlayer(new Player(2,"BRAGA", "Nelly", "1300043", "-2012", "64Pa"));
		player_dao.insertPlayer(new Player(3,"GIROUSSE", "Sim√©on", "1100109", "-46", "64Pa"));
		player_dao.insertPlayer(new Player(4,"MAILLOT", "Geoffrey", "1300161", "-1210", "64Ta"));
		player_dao.insertPlayer(new Player(5,"LAMAS", "Fabien", "7777777", "-514", "64Pa"));
		player_dao.insertPlayer(new Player(6,"GRANGE-PRADERAS", "Jean-Romain", "6664266", "-2000", "64Pa"));
		player_dao.insertPlayer(new Player(7,"BELELLOU", "Kevin", "5462156", "-2546", "64Pa"));
        player_dao.insertPlayer(new Player(8,"BARON", "Jonathan", "6564266", "-20", "60Ta"));
        player_dao.insertPlayer(new Player(9,"CLAIR", "Jocelyn", "7445758", "-2000", "60Pa"));
		
        player_dao.close();
        
		//Re-enabled at the end
		this._update_button.setEnabled(true);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this._last_maj.setText(dateFormat.format(new Date()));
		
        SharedPreferences preferences = _main_activity.getSharedPreferences("UPDATE_FILE", Context.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("db_update", dateFormat.format(new Date()));
        editor.commit();
		
		toaster_msg = "Base de joueurs mise ‡† jour.";

		Toast t = Toast.makeText(_main_activity.getApplicationContext(), toaster_msg, Toast.LENGTH_SHORT);
		t.show();
	}	
}
