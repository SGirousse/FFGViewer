package org.jeudego.utils;

import android.util.Log;

/**
 * Utility class to translate a MAJQuery to String (and conversely)
 * 
 * @author simeon
 * @see MAJQuery
 *
 */
public class QueryTranslation {

	public static String MAJQueryToString(MAJQuery query){
		Log.i("TRACE", "QueryTranslation *** public static String MAJQueryToString(MAJQuery query)");
		
		String queryTranslated = "NO_QUERY";
		
		switch(query){
		case ALL_DB :
			queryTranslated = "ALL_DB";
			break;
		case ALL_PLAYERS :
			queryTranslated = "ALL_PLAYERS";
			break;
		case ALL_CALENDAR :
			queryTranslated = "ALL_CALENDAR";
			break;
		case SOME_PLAYERS :
			queryTranslated = "SOME_PLAYERS";
			break;
		case ONE_PLAYER :
			queryTranslated = "ONE_PLAYER";
			break;
		default :
			Log.e("TRACE", "That kind of query doesn't exists.");
			queryTranslated = "QUERY_MISTAKE";
		}
		
		return queryTranslated;
	}
	
	public static MAJQuery StringToMAJQuery(String query){
		Log.i("TRACE", "QueryTranslation *** public static MAJQuery StringToMAJQuery(String query)");
		
		MAJQuery queryTranslated = null;
		
		if(query.compareTo("ALL_DB")==0){
			queryTranslated = MAJQuery.ALL_DB;
		}else if(query.compareTo("ALL_PLAYERS")==0){
			queryTranslated = MAJQuery.ALL_PLAYERS;
		}else if(query.compareTo("ALL_CALENDAR")==0){
			queryTranslated = MAJQuery.ALL_CALENDAR;
		}else if(query.compareTo("SOME_PLAYERS")==0){
			queryTranslated = MAJQuery.SOME_PLAYERS;
		}else if(query.compareTo("ONE_PLAYER")==0){
			queryTranslated = MAJQuery.ONE_PLAYER;
		}else{
			Log.e("TRACE", "That kind of query doesn't exists.");
		}

		return queryTranslated;
	}
}
