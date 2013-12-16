package org.jeudego.ffg;

import java.util.ArrayList;
import java.util.List;

import org.jeudego.adapters.TournamentQuickViewAdapter;
import org.jeudego.listeners.FollowSwitch;
import org.jeudego.pojo.Tournament;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.widget.ListView;
import android.widget.Switch;

public class TournamentsActivity extends Activity{

	private List<Tournament> _t_list;
	private TournamentQuickViewAdapter _tournament_quick_view_adapter;
	private FollowSwitch _follow_switch;
    private Cursor mCursor = null;
    private static final String[] COLS = new String[]
    		{ CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "TournamentsActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_tournaments);
        
        _t_list = new ArrayList<Tournament>();
        
        _t_list.add(new Tournament("Tournoi interne de Pau", "Best tournament ever ? Bon peut-être pas mais ... il est cool quand même ! ","date...", true));
        _t_list.add(new Tournament("Paris-Meijin","Tournoi en 3 ctg : A, B et C. Dai Junfu vainqueur des 42 dernières éditions attendra de pied ferme son prochain adversaire !", "date...", false));
        _t_list.add(new Tournament("1er tour du championnat de France - Pau/Tarbes", "Sans peurs ni reproches ... tous les licenciés sont convier à jouer la qualification pour le 2nd tour.", "date...", false));
        
        // --- Adapters --- //
        //Each tournament to show
        _tournament_quick_view_adapter = new TournamentQuickViewAdapter(this, R.layout.item_tournament, _t_list);
        //Add it to listView
        ListView lv = (ListView) findViewById(R.id.listViewTournaments);
        lv.setAdapter(_tournament_quick_view_adapter);
        //lv.setOnClickListener(l)
        // --- Listeners --- //
        /*_follow_switch = new FollowSwitch();
        Switch follow_switch = (Switch) findViewById(R.id.switchFollow);
        follow_switch.setOnCheckedChangeListener(_follow_switch);*/
        
        /*
        Time dayStart = new Time();
        dayStart.setToNow();
        dayStart.hour=0;
        dayStart.minute=0;
        dayStart.second=0;
        Long dayStartInMillis = dayStart.toMillis(false);
        mCursor = getContentResolver().query(CalendarContract.Events.CONTENT_URI, COLS, CalendarContract.Events.TITLE + " LIKE ?", new String[]{"%Nelly%"}, null);
        if(mCursor.moveToFirst()){

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(mCursor.getString(0));
        while(mCursor.moveToNext()){
        	tv.setText(tv.getText()+" --- "+mCursor.getString(0));
        }
        }*/
        
        //http://developer.android.com/reference/android/provider/CalendarContract.Events.html
        
    /*
        
        long calID = 3;
        long startMillis = 0; 
        long endMillis = 0;     
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2013, 12, 16, 7, 30);
        startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(2013, 12, 16, 8, 45);
        endMillis = endTime.getTimeInMillis();
        //...

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(Events.DTSTART, startMillis);
        values.put(Events.DTEND, endMillis);
        values.put(Events.TITLE, "Jazzercise");
        values.put(Events.DESCRIPTION, "Group workout");
        values.put(Events.CALENDAR_ID, calID);
        values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles");
        Uri uri = cr.insert(Events.CONTENT_URI, values);

        // get the event ID that is the last element in the Uri
        long eventID = Long.parseLong(uri.getLastPathSegment());*/
    }
}
