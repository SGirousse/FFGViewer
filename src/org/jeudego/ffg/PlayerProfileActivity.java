package org.jeudego.ffg;

import org.jeudego.pojo.Player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Show own profile according to personal data set.
 * 
 * @author simeon
 *
 */
public class PlayerProfileActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "PlayerProfileActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_player_profile);
        
        //Get the player to show, it has to be put into the extra
        Bundle data = getIntent().getExtras();
        Player p = data.getParcelable("player_toshow");

        //Set the player data on the screen
        if(p!=null){
	    	TextView text_view_name = (TextView) findViewById(R.id.textViewNameSurname);
	    	text_view_name.setText(p.getName()+" "+p.getSurname());
	    	TextView text_view_club = (TextView) findViewById(R.id.textViewClub);
	    	text_view_club.setText(p.getClub());
	    	TextView text_view_nolicence = (TextView) findViewById(R.id.textViewNoLicence);
	    	text_view_nolicence.setText(p.getNoLicence());
	    	TextView text_view_rating = (TextView) findViewById(R.id.textViewRating);
	    	text_view_rating.setText(p.getLevel());
        }
    }
}
