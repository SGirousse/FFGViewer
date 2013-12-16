package org.jeudego.ffg;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;

public class TournamentScheduleActivity extends Activity{

    private Cursor mCursor = null;
    private static final String[] COLS = new String[]
    		{ CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "TournamentScheduleActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_schedule_tournament);
        Time dayStart = new Time();
        dayStart.setToNow();
        dayStart.hour=0;
        dayStart.minute=0;
        dayStart.second=0;
        Long dayStartInMillis = dayStart.toMillis(false);
        mCursor = getContentResolver().query(CalendarContract.Events.CONTENT_URI, COLS, CalendarContract.Events.DTSTART + " >= ?", new String[]{dayStartInMillis.toString()}, null);
        mCursor.moveToFirst();
        
        String title = mCursor.getString(0);


        Long start = mCursor.getLong(1);
        
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(title);
        
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
