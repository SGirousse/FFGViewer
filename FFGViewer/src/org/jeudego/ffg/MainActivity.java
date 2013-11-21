package org.jeudego.ffg;

import org.jeudego.listeners.AccessFFGButton;
import org.jeudego.listeners.SearchPlayerButton;
import org.jeudego.listeners.ShowProfileButton;
import org.jeudego.listeners.UpdatingButton;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

/**
 * The main activity, offering option to Go on main
 * screens and use main features.
 * 
 * @author simeon
 *
 */
public class MainActivity extends Activity {
	
	//Version
	private final String _VERSION = "v0.2.5 - 21.11.2013";

	//Listeners
	private AccessFFGButton _access_ffg_button;
	private ShowProfileButton _show_profile_button;
	private SearchPlayerButton _search_player_button;
	private UpdatingButton _updating_button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "MainActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_main);
        
        //Set version
        TextView textview_version = (TextView) findViewById(R.id.textViewVersion);
        textview_version.setText(this._VERSION);
                
        // --- Listeners --- //
        //Web site access
        this._access_ffg_button = new AccessFFGButton(this);
        Button access_ffg_button = (Button) findViewById(R.id.buttonGoFFG);
        access_ffg_button.setOnClickListener(this._access_ffg_button);
        
        //Show own profile
        this._show_profile_button = new ShowProfileButton(this);
        Button show_profile_button = (Button) findViewById(R.id.buttonShowProfile);
        show_profile_button.setOnClickListener(this._show_profile_button);
        
        //Search player
        this._search_player_button = new SearchPlayerButton(this);
        Button search_player_button = (Button) findViewById(R.id.buttonSearch);
        search_player_button.setOnClickListener(this._search_player_button);
        
        //Update DB
        Button update_button = (Button) findViewById(R.id.buttonUpdating);
        TextView textview_last_update_date = (TextView) findViewById(R.id.textViewLastMAJDate);
        this._updating_button = new UpdatingButton(this, update_button, textview_last_update_date);
        update_button.setOnClickListener(this._updating_button);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
