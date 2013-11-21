package org.jeudego.listeners;

import java.util.List;

import org.jeudego.adapters.PlayerQuickViewAdapter;
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

	private EditText _name_edit_text;
	private EditText _surname_edit_text;
	private List<Player> _player_list;
	private PlayerQuickViewAdapter _player_quick_view_adapter;
	
	public GoSearchPlayerButton(EditText name_edit_text, EditText surname_edit_text, List<Player> player_list, PlayerQuickViewAdapter player_quick_view_adapter){
		this._name_edit_text = name_edit_text;
		this._surname_edit_text = surname_edit_text;
		this._player_list = player_list;
		this._player_quick_view_adapter = player_quick_view_adapter;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "GoSearchPlayerButton *** public void onClick(View v) ");
		
		/*Player p = null;
		String name = this._name_edit_text.getText().toString();
		String surname = this._surname_edit_text.getText().toString();
		
		//Clean previous lis
		this._player_list.clear();
		
		//Select new players
		for(int i=0;i<completeListOfPlayers.length();Number;i++){
			p = completeListOfPlayers.get(i);
			if((!name.isEmpty() && p.getName().compareTo(name)==0) && (!surname.isEmpty() && p.getSurname().compareTo(surname)==0)){
				//Add the player
				this._player_list.add(p);
			}
		}
		
		//Notify change for interface update
		this._player_quick_view_adapter.notifyDataSetChanged();
		*/
	}

}
