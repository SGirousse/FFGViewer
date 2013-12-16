package org.jeudego.adapters;

import java.util.List;

import org.jeudego.pojo.Tournament;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TournamentQuickViewAdapter extends ArrayAdapter<Tournament>{

	private List<Tournament> _tournament_list;
	private Context _context;
	private int _layout_to_inflate_id;
	
	public TournamentQuickViewAdapter(Context context, int layout_id, List<Tournament> objects){
		super(context, layout_id, objects);
		
		_tournament_list = objects;
		_context = context;
		_layout_to_inflate_id = layout_id;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("TRACE", "TournamentQuickViewAdapter *** public View getView(int position, View convertView, ViewGroup parent)");
		
		if (convertView==null) {
			LayoutInflater layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(_layout_to_inflate_id, parent, false);   
		} 
		
	    //Player to update
		Tournament t = _tournament_list.get(position);
		
		TextView text_view_tournament_title = (TextView) convertView.findViewById(org.jeudego.ffg.R.id.textViewTournamentTitle);		
		text_view_tournament_title.setText(t.getTitle());

		return convertView;
	}
}