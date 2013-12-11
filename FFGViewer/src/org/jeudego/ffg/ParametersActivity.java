package org.jeudego.ffg;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

public class ParametersActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TRACE", "ParametersActivity *** public void onCreate(Bundle savedInstanceState) ");
        setContentView(R.layout.activity_parameters);
        
		SharedPreferences preferences = getSharedPreferences("INTERNET_PREF_FILE", Context.MODE_PRIVATE);
		String internet_dl = preferences.getString("internet_dl","");
		String internet_wifi = preferences.getString("internet_wifi","");
		String internet_data = preferences.getString("internet_data","");
		
		CheckBox cb_dl = (CheckBox) findViewById(R.id.checkBoxAutoDL);
		CheckBox cb_wifi = (CheckBox) findViewById(R.id.checkBoxAutoWifi);
		CheckBox cb_data = (CheckBox) findViewById(R.id.checkBoxAutoData);
		
		if(!internet_dl.equalsIgnoreCase("")){
			cb_dl.setChecked(internet_dl.equalsIgnoreCase("1"));
		}else{
			SharedPreferences preferences_edit = getSharedPreferences("INTERNET_PREF_FILE",Context.MODE_WORLD_WRITEABLE);
			SharedPreferences.Editor editor = preferences_edit.edit();
			editor.putString("internet_dl", "0");
			editor.commit();
			
			cb_dl.setChecked(false);
		}
		
		if(!internet_wifi.equalsIgnoreCase("")){
			cb_wifi.setChecked(internet_wifi.equalsIgnoreCase("1"));
		}else{
			SharedPreferences preferences_edit = getSharedPreferences("INTERNET_PREF_FILE",Context.MODE_WORLD_WRITEABLE);
			SharedPreferences.Editor editor = preferences_edit.edit();
			editor.putString("internet_wifi", "1");
			editor.commit();
			
			cb_wifi.setChecked(true);
		}
		
		if(!internet_data.equalsIgnoreCase("")){
			cb_data.setChecked(internet_data.equalsIgnoreCase("1"));
		}else{
			SharedPreferences preferences_edit = getSharedPreferences("INTERNET_PREF_FILE",Context.MODE_WORLD_WRITEABLE);
			SharedPreferences.Editor editor = preferences_edit.edit();
			editor.putString("internet_data", "0");
			editor.commit();
			
			cb_data.setChecked(false);
		}
    }
}
