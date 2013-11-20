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
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
