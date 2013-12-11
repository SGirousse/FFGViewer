package org.jeudego.ffg;

import org.jeudego.listeners.AccessFFGButton;
import org.jeudego.listeners.SearchPlayerButton;
import org.jeudego.listeners.ShowProfileButton;
import org.jeudego.listeners.UpdatingButton;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
	private final String _VERSION = "v0.3.2 - 12.12.2013";

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
        SharedPreferences preferences = getSharedPreferences("IDENT_USER_FILE", Context.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("User_surname", "Siméon");
        editor.putString("User_name", "Girousse");
        editor.putString("User_licence", "1100109");
        editor.commit();
        
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
    
    public boolean onOptionsItemSelected(MenuItem item) {
       Log.i("TRACE", "MainActivity *** public boolean onOptionsItemSelected(MenuItem item) ");
       //According to item id
       switch (item.getItemId()) 
       {
          case R.id.menu_settings:
                  //Launch the setup activity
                  Intent intent = new Intent(MainActivity.this, ParametersActivity.class);
                  startActivity(intent);
             return true;
       }
       return true;
    }
}
