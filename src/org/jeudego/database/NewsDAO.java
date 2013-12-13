package org.jeudego.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NewsDAO {
	private SQLiteDatabase _news_db;
	private NewsDBHelper _news_db_helper;
	
	public NewsDAO(Context c){
		_news_db_helper = new NewsDBHelper(c);
	}
	
	public void open(boolean writable){
		if(writable){
			_news_db = _news_db_helper.getWritableDatabase();
		}else{
			_news_db = _news_db_helper.getReadableDatabase();			
		}
	}
	
	public void close(){
		_news_db.close();
	}
}
