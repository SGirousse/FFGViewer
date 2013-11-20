package org.jeudego.ffg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenFFGActivity extends Activity {
	 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffg_splashscreen);
 
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreenFFGActivity.this, ViewWebsiteActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}