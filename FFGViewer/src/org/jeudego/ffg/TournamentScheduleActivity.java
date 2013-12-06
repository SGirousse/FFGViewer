package org.jeudego.ffg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TournamentScheduleActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "TournamentScheduleActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_schedule_tournament);
    }
}
