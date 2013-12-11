package org.jeudego.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PlayersDBHelper extends SQLiteOpenHelper{
	/**
	 * Database
	 */
	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "fggviewer.db";
	
	/**
	 * Tables
	 */
	//Player table
	public static final String TABLE_PLAYER = "table_players";
	public static final String COL_PLAYER_ID= "_id";
	public static final String COL_PLAYER_NAME = "player_name";
	public static final String COL_PLAYER_SURNAME = "player_surname";
	public static final String COL_PLAYER_NOLICENCE = "player_nolicence";
	public static final String COL_PLAYER_CLUB = "player_club";
	public static final String COL_PLAYER_RATING = "player_rating";
	//Club table
	public static final String TABLE_CLUB = "table_club";
	public static final String COL_CLUB_ID= "_id";
	public static final String COL_CLUB_NAME = "club_name";
	
	/**
	 * Database create script
	 */
	public static final String DB_CREATE_PLAYERS =
			"create table " + TABLE_PLAYER + "(" 
		    + COL_PLAYER_ID + " integer primary key autoincrement, "
		    + COL_PLAYER_NAME + " text not null, "
		    + COL_PLAYER_SURNAME + " text not null, "
		    + COL_PLAYER_NOLICENCE + " text not null, "
		    + COL_PLAYER_CLUB + " text not null, "
		    + COL_PLAYER_RATING + " text not null "
		    +")";
	
			/*"create table "
		      + TABLE_CLUB + "(" 
		      + COL_CLUB_ID + " integer primary key autoincrement, "
		      + COL_CLUB_NAME + " text not null "
		      +"); "
		      + */

	
	public PlayersDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("TRACE", "PlayersDBHelper *** public void onCreate(SQLiteDatabase db) ");
		db.execSQL(DB_CREATE_PLAYERS);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w( PlayersDBHelper.class.getName(),
	            "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLUB);
        onCreate(db);
	}
	
	public String[] getAllPlayersColumns(){
		String[] allPlayerColumns = new String[]{COL_PLAYER_ID, COL_PLAYER_NAME, COL_PLAYER_SURNAME, COL_PLAYER_NOLICENCE, COL_PLAYER_RATING, COL_PLAYER_CLUB}; 
		return allPlayerColumns;
	}
}
