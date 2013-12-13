package org.jeudego.adapters;

import java.util.List;

import org.jeudego.pojo.Player;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PlayerQuickViewAdapter extends ArrayAdapter<Player>{

	private List<Player> _player_list;
	private Context _context;
	private int _layout_to_inflate_id;
	
	public PlayerQuickViewAdapter(Context context, int layout_id, List<Player> objects){
		super(context, layout_id, objects);
		
		this._player_list = objects;
		this._context = context;
		this._layout_to_inflate_id = layout_id;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("TRACE", "PlayerQuickViewAdapter *** public View getView(int position, View convertView, ViewGroup parent)");
		
		if (convertView==null) {
			Log.i("TRACE","INFLATER");
			LayoutInflater layoutInflater = (LayoutInflater)this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(this._layout_to_inflate_id, parent, false);   
		} 
		
	    //Player to update
		Player p = this._player_list.get(position);

		Log.i("TRACE", "PlayerQuickViewAdapter *** "+p.getName()+" "+position);
		
		TextView text_view_name = (TextView) convertView.findViewById(org.jeudego.ffg.R.id.textViewPlayerName);		
		text_view_name.setText(p.getName());
		TextView text_view_surname = (TextView) convertView.findViewById(org.jeudego.ffg.R.id.textViewPlayerSurname);
		text_view_surname.setText(p.getSurname());
		TextView text_view_rating = (TextView) convertView.findViewById(org.jeudego.ffg.R.id.textViewPlayerRating);
		text_view_rating.setText(p.getLevel());
		TextView text_view_club = (TextView) convertView.findViewById(org.jeudego.ffg.R.id.textViewPlayerClub);
		text_view_club.setText(p.getClub());

		return convertView;
	}
}
