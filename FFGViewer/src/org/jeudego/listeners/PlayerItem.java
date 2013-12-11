package org.jeudego.listeners;

import java.util.List;

import org.jeudego.ffg.PlayerListActivity;
import org.jeudego.ffg.PlayerProfileActivity;
import org.jeudego.pojo.Player;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class PlayerItem implements OnItemClickListener {
	
	private PlayerListActivity _player_list_activity;
	private List<Player> _p_list;
	
	public PlayerItem(PlayerListActivity player_list_activity, List<Player> p_list){
		this._player_list_activity = player_list_activity;
		this._p_list = p_list;
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Log.i("TRACE", "PlayerItem *** public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)");

		//Get the player into list
		Player p = _p_list.get(arg2);
		
		//Ask for the profile activity
		Intent i = new Intent(_player_list_activity.getBaseContext(), PlayerProfileActivity.class );
		i.putExtra("player_toshow", p);
		
		_player_list_activity.startActivity(i);
	
	}

}
