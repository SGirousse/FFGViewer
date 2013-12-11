package org.jeudego.database;

import java.util.ArrayList;
import java.util.List;

import org.jeudego.pojo.Player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PlayerDataSource {
	private SQLiteDatabase _players_db;
	private PlayersDBHelper _players_db_helper;
	
	public PlayerDataSource(Context context){
		_players_db_helper = new PlayersDBHelper(context);
	}
	
	public void open(boolean writable){
		if(writable){
			_players_db = _players_db_helper.getWritableDatabase();
		}else{
			_players_db = _players_db_helper.getReadableDatabase();
		}
	}
	
	public void close(){
		_players_db.close();
	}
	
	public long insertPlayer(Player p){
		Log.i("TRACE_DB", "PlayerDataSource *** public long insertPlayer(Player p)");
		Log.i("TRACE_DB", "PlayerDataSource *** public long insertPlayer(Player p) : joueur insere = "+p.getName());
		
		ContentValues values = new ContentValues();
		
		values.put(_players_db_helper.COL_PLAYER_ID, p.getId());
		values.put(_players_db_helper.COL_PLAYER_NAME, p.getName());
		values.put(_players_db_helper.COL_PLAYER_SURNAME, p.getSurname());
		values.put(_players_db_helper.COL_PLAYER_CLUB, p.getClub());
		values.put(_players_db_helper.COL_PLAYER_RATING, p.getRating());
		values.put(_players_db_helper.COL_PLAYER_NOLICENCE, p.getNoLicence());
		
		//Return the affected _id (useful if autoincrement)
		return _players_db.insert(_players_db_helper.TABLE_PLAYER, null, values);
	}
	
	public int updatePlayer(int id, Player p){
		ContentValues values = new ContentValues();
		
		values.put(_players_db_helper.COL_PLAYER_ID, p.getId());
		values.put(_players_db_helper.COL_PLAYER_NAME, p.getName());
		values.put(_players_db_helper.COL_PLAYER_SURNAME, p.getSurname());
		values.put(_players_db_helper.COL_PLAYER_CLUB, p.getClub());
		values.put(_players_db_helper.COL_PLAYER_RATING, p.getRating());
		values.put(_players_db_helper.COL_PLAYER_NOLICENCE, p.getNoLicence());
		
		return _players_db.update(_players_db_helper.TABLE_PLAYER, values, _players_db_helper.COL_PLAYER_ID + " = " +id, null);
	}
	
	public int deletePlayerWithId(int id){
		return _players_db.delete(_players_db_helper.TABLE_PLAYER, _players_db_helper.COL_PLAYER_ID + " = " +id, null);
	}
	
	public int deleteAllPlayers(){
		return _players_db.delete(_players_db_helper.TABLE_PLAYER, null, null);
	}
	
	public List<Player> getAllPlayers(){
	    List<Player> p_list = new ArrayList<Player>();

	    //Cursor cursor = _players_db.query(_players_db_helper.TABLE_PLAYER,
	    //    null, null, null, null, null, null);
	    //Cursor cursor = _players_db.rawQuery("SELECT * FROM "+_players_db_helper.TABLE_PLAYER, null);
	    Cursor cursor = null;
	    
	    for (long x=1; x<8; x++){
	    	cursor = _players_db.query(_players_db_helper.TABLE_PLAYER,
		        null, _players_db_helper.COL_PLAYER_ID + " = " + x, null, null, null, null);
	    	cursor.moveToFirst();
    		Player p = cursorToPlayer(cursor);
	    	p_list.add(p);
	    	Log.i("TRACE_DB", "PlayerDataSource *** getAllPlayers : joueur recupere = "+p.getName());
	    	
	    }
	    
	   /* if(cursor.moveToFirst()){
	    	do{
	    		Player p = cursorToPlayer(cursor);
		    	p_list.add(p);
		    	Log.i("TRACE_DB", "PlayerDataSource *** getAllPlayers : joueur recupere = "+p.getName());
		    	
		    	cursor.moveToNext();
		    }while(cursor.moveToNext());
	    }*/
	    
	    //close the cursor
	    cursor.close();
	    
	    Log.i("TRACE", "Nombre de joueurs = "+p_list.size());
	    
	    return p_list;
	}
	
	public Player cursorToPlayer(Cursor c){
		Player p = new Player();
		
		p.setId(c.getInt(0));
		p.setName(c.getString(1));
		p.setSurname(c.getString(2));
		p.setNoLicence(c.getString(3));
		p.setClub(c.getString(4));
		p.setRating(c.getString(5));
		
		Log.i("TRACE", "CursorToPlayer "+p.getName());
		return p;
	}
}
