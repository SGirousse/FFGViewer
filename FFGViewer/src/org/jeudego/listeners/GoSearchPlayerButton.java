package org.jeudego.listeners;

import java.util.List;

import org.jeudego.adapters.PlayerQuickViewAdapter;
import org.jeudego.pojo.Player;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

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
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
