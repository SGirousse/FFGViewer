package org.jeudego.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NewsDBHelper extends SQLiteOpenHelper {
	/**
	 * Database
	 */
	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "news.db";
	
	/**
	 * Tables
	 */
	//News table
	public static final String TABLE_NEWS = "table_news";
	public static final String COL_NEWS_ID= "_id";
	public static final String COL_NEWS_TITLE= "news_title";
	public static final String COL_NEWS_CONTENTS = "news_contents";
	public static final String COL_NEWS_SOURCE = "news_source";
	public static final String COL_NEWS_URL = "news_url";
	public static final String COL_NEWS_AUTHORS = "news_authors";
	
	/**
	 * Database create script
	 */
	public static final String DB_CREATE_PLAYERS =
			"create table " + TABLE_NEWS + "(" 
		    + COL_NEWS_ID + " integer primary key autoincrement, "
		    + COL_NEWS_TITLE + " text not null, "
		    + COL_NEWS_CONTENTS + " text not null, "
		    + COL_NEWS_SOURCE + " text, "
		    + COL_NEWS_URL + " text, "
		    + COL_NEWS_AUTHORS + " text "
		    +")";
	
	public NewsDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("TRACE_DB", "NewsDBHelper *** public void onCreate(SQLiteDatabase db) ");
		db.execSQL(DB_CREATE_PLAYERS);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w( NewsDBHelper.class.getName(),
	            "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);
        onCreate(db);
	}
	
	public String[] getAllNewssColumns(){
		String[] allPlayerColumns = new String[]{COL_NEWS_ID, COL_NEWS_TITLE, COL_NEWS_CONTENTS, COL_NEWS_SOURCE, COL_NEWS_URL, COL_NEWS_AUTHORS}; 
		return allPlayerColumns;
	}
}
