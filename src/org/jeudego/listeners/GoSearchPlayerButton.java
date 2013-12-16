package org.jeudego.listeners;

import java.util.List;

import org.jeudego.adapters.PlayerQuickViewAdapter;
import org.jeudego.database.PlayerDAO;
import org.jeudego.ffg.MainActivity;
import org.jeudego.ffg.PlayerListActivity;
import org.jeudego.pojo.Player;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

/**
 * 
 * @author simeon
 *
 */
public class GoSearchPlayerButton implements OnClickListener{

	private PlayerListActivity _player_list_activity;
	private EditText _name_edit_text;
	private EditText _surname_edit_text;
	private List<Player> _player_list;
	private PlayerQuickViewAdapter _player_quick_view_adapter;
	
	public GoSearchPlayerButton(PlayerListActivity player_list_activity, EditText name_edit_text, EditText surname_edit_text, List<Player> player_list, PlayerQuickViewAdapter player_quick_view_adapter){
		this._player_list_activity = player_list_activity;
		this._name_edit_text = name_edit_text;
		this._surname_edit_text = surname_edit_text;
		this._player_list = player_list;
		this._player_quick_view_adapter = player_quick_view_adapter;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "GoSearchPlayerButton *** public void onClick(View v) ");
		
		Player p = new Player();
		boolean toAdd = true;
		String name = _name_edit_text.getText().toString();
		String surname = _surname_edit_text.getText().toString();
		PlayerDAO player_dao = new PlayerDAO(_player_list_activity);
		
		//Clean previous list
		_player_list.clear();
        
		player_dao.open(true);
        
		List<Player> all_p = player_dao.getAllPlayers();		
		
        player_dao.close();
        
        for(int i=0; i<all_p.size();i++){
        	toAdd = true;
        	p = all_p.get(i);
        	if(name!=null && name.length()>0){
        		toAdd = p.getName().equalsIgnoreCase(name);
        	}
        	if(surname!=null && surname.length()>0){
        		toAdd = p.getSurname().equalsIgnoreCase(surname);
        	}
        	if(toAdd){
        		_player_list.add(p);
        	}
        }
		
		//Notify change for interface update
		this._player_quick_view_adapter.notifyDataSetChanged();
	}

}
