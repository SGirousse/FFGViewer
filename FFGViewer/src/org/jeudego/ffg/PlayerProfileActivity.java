package org.jeudego.ffg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

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
        Log.i("TRACE", "MyProfileActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_player_profile);
        
        //TODO : get player to show
        
    }
}
