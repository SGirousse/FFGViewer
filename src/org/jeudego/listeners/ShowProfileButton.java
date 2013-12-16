package org.jeudego.listeners;

import org.jeudego.database.PlayerDAO;
import org.jeudego.ffg.MainActivity;
import org.jeudego.ffg.PlayerProfileActivity;
import org.jeudego.pojo.Player;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 
 * @author simeon
 *
 */
public class ShowProfileButton implements OnClickListener{

	private MainActivity _main_activity;
	
	public ShowProfileButton(MainActivity main_activity){
		_main_activity = main_activity;
	}
	
	public void onClick(View v) {
		Log.i("TRACE", "ShowProfileButton *** public void onClick(View v) ");
		
		//Get the player informations
		SharedPreferences preferences = _main_activity.getSharedPreferences("IDENT_USER_FILE", Context.MODE_PRIVATE);
		String no_licence = preferences.getString("User_licence","");
		
		if(!no_licence.equalsIgnoreCase("")){
			PlayerDAO player_dao = new PlayerDAO(_main_activity);
			
			player_dao.open(true);
			Player p = player_dao.getPlayerByNoLicence(no_licence);
			player_dao.close();
			
			if(p!=null){
				//Ask for the profile activity
				Intent i = new Intent(_main_activity.getBaseContext(), PlayerProfileActivity.class );
				i.putExtra("player_toshow", p);
				
				_main_activity.startActivity(i);
			}else{
				Toast t = Toast.makeText(_main_activity, "Profil mal rempli - licence no "+no_licence+" non trouvée dans la base de données", Toast.LENGTH_SHORT);
				t.show();
			}
		}else{
			Toast t = Toast.makeText(_main_activity, "Profil non rempli (Paramètres > Mon profil)", Toast.LENGTH_SHORT);
			t.show();
		}
	}
}
