package org.jeudego.services;

import org.jeudego.utils.MAJQuery;
import org.jeudego.utils.QueryTranslation;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * That service run in background and update the database. It can be the whole database 
 * or a part (like one player information)
 * 
 * @author simeon
 *
 */
public class MAJLocalDatabaseService extends IntentService {

	public MAJLocalDatabaseService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent workIntent) {
		Log.i("TRACE", "MAJLocalDatabaseService *** protected void onHandleIntent(Intent workIntent)");
		
		MAJQuery type_of_query;
		String data_string;
		
		//Get informations
		data_string = workIntent.getDataString();
		
		if(data_string.compareTo("")!=0){ //isEmpty only supported on API 9
			String data_splitted_string[] = data_string.split(";");
			
			type_of_query = QueryTranslation.StringToMAJQuery(data_splitted_string[0]);
			
			switch(type_of_query){
			case ALL_DB :
				Log.i("TRACE", "MAJLocalDatabaseService *** All the database is gonna be updated");
				
				break;
			case ALL_PLAYERS :
				Log.i("TRACE", "MAJLocalDatabaseService *** All the players are gonna be updated");
				
				break;
			case ALL_CALENDAR :
				Log.i("TRACE", "MAJLocalDatabaseService *** All the calendar are gonna be updated");
				
				break;
			case SOME_PLAYERS :
				Log.i("TRACE", "MAJLocalDatabaseService *** Some players are gonna be updated");
				
				break;
			case ONE_PLAYER :
				Log.i("TRACE", "MAJLocalDatabaseService *** On player is gonna be updated");
				
				break;
			default :
				Log.e("TRACE", "To be implemented - yeah.");
			}
			
		}else{
			//Error, the query is empty
		}
	}

}
