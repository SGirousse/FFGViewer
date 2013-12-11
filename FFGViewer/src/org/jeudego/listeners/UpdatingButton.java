package org.jeudego.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jeudego.database.PlayerDataSource;
import org.jeudego.ffg.MainActivity;
import org.jeudego.pojo.Player;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class UpdatingButton implements OnClickListener{

	public Button _update_button;
	public MainActivity _main_activity;
	public TextView _last_maj;
	//Player list
	private PlayerDataSource _player_dao;
	
	public UpdatingButton(MainActivity main_activity, Button update_button, TextView last_maj){
		this._main_activity = main_activity;
		this._update_button = update_button;
		this._last_maj = last_maj;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "UpdatingButton *** public void onClick(View v) ");
		//While it's downloading, avoid multiple click
		_update_button.setEnabled(false);
		
        _player_dao = new PlayerDataSource(_main_activity);
        _player_dao.open(true);
        
        _player_dao.deleteAllPlayers();
        
        long i;
		i = _player_dao.insertPlayer(new Player(1,"CLAIR", "Yves", "9951702", "-411", "64Pa"));
		Log.i("TRACE", "valeur du insert : "+i);
        i = _player_dao.insertPlayer(new Player(2,"BRAGA", "Nelly", "1300043", "-2012", "64Pa"));
		Log.i("TRACE", "valeur du insert : "+i);
		i = _player_dao.insertPlayer(new Player(3,"GIROUSSE", "Siméon", "1100109", "-46", "64Pa"));
		Log.i("TRACE", "valeur du insert : "+i);
		i = _player_dao.insertPlayer(new Player(4,"MAILLOT", "Geoffrey", "1300161", "-1210", "64Ta"));
		Log.i("TRACE", "valeur du insert : "+i);
		i = _player_dao.insertPlayer(new Player(5,"LAMAS", "Fabien", "7777777", "-514", "64Pa"));
		Log.i("TRACE", "valeur du insert : "+i);
		i = _player_dao.insertPlayer(new Player(6,"GRANGE-PRADERAS", "Jean-Romain", "6664266", "-2000", "64Pa"));
		Log.i("TRACE", "valeur du insert : "+i);
		_player_dao.insertPlayer(new Player(7,"BELELLOU", "Kevin", "5462156", "-2546", "64Pa"));
        _player_dao.insertPlayer(new Player(8,"BARON", "Jonathan", "6564266", "-20", "60Ta"));
		
        _player_dao.close();
		
		//Re-enabled at the end
		this._update_button.setEnabled(true);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this._last_maj.setText(dateFormat.format(new Date()));
		
		
	}

	
}
