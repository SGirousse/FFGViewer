package org.jeudego.ffg;

import org.jeudego.listeners.AccessFFGButton;
import org.jeudego.listeners.SearchPlayerButton;
import org.jeudego.listeners.ShowProfileButton;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

/**
 * The main activity, offering option to Go on main
 * screens and use main features.
 * 
 * @author simeon
 *
 */
public class MainActivity extends Activity {

	//Listeners
	private AccessFFGButton _access_ffg_button;
	private ShowProfileButton _show_profile_button;
	private SearchPlayerButton _search_player_button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "MainActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_main);
                
        // --- Listeners --- //
        //Web site access
        this._access_ffg_button = new AccessFFGButton(this);
        Button access_ffg_button = (Button) findViewById(R.id.buttonGoFFG);
        access_ffg_button.setOnClickListener(this._access_ffg_button);
        
        //Show own profile
        this._show_profile_button = new ShowProfileButton();
        Button show_profile_button = (Button) findViewById(R.id.buttonShowProfile);
        show_profile_button.setOnClickListener(this._show_profile_button);
        
        //Search player
        this._search_player_button = new SearchPlayerButton(this);
        Button search_player_button = (Button) findViewById(R.id.buttonSearch);
        search_player_button.setOnClickListener(this._search_player_button);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
