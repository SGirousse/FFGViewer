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
	
	/**
	 * Insert a new player into the database corresponding to the given Player object.
	 * 
	 * @param p
	 * @return int
	 * @see Player
	 */
	public long insertPlayer(Player p){
		Log.i("TRACE_DB", "PlayerDataSource *** public long insertPlayer(Player p)");
		
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
	
	/**
	 * Update a player (all the values are updated) according to the given id and the player object.
	 * 
	 * @param id
	 * @param p
	 * @return int
	 * @see Player
	 */
	public int updatePlayer(int id, Player p){
		Log.i("TRACE_DB", "PlayerDataSource *** public int updatePlayer(int id, Player p)");
		ContentValues values = new ContentValues();
		
		values.put(_players_db_helper.COL_PLAYER_ID, p.getId());
		values.put(_players_db_helper.COL_PLAYER_NAME, p.getName());
		values.put(_players_db_helper.COL_PLAYER_SURNAME, p.getSurname());
		values.put(_players_db_helper.COL_PLAYER_CLUB, p.getClub());
		values.put(_players_db_helper.COL_PLAYER_RATING, p.getRating());
		values.put(_players_db_helper.COL_PLAYER_NOLICENCE, p.getNoLicence());
		
		return _players_db.update(_players_db_helper.TABLE_PLAYER, values, _players_db_helper.COL_PLAYER_ID + " = " +id, null);
	}
	
	/**
	 * Delete a particular player according to the given id.
	 * 
	 * @param id
	 * @return int
	 */
	public int deletePlayerWithId(int id){
		Log.i("TRACE_DB", "PlayerDataSource *** public int deletePlayerWithId(int id)");
		
		return _players_db.delete(_players_db_helper.TABLE_PLAYER, _players_db_helper.COL_PLAYER_ID + " = " +id, null);
	}
	
	/**
	 * Delete all the players in database in order to clean it.
	 * 
	 * @return int
	 */
	public int deleteAllPlayers(){
		Log.i("TRACE_DB", "PlayerDataSource *** public int deleteAllPlayers()");
		
		return _players_db.delete(_players_db_helper.TABLE_PLAYER, null, null);
	}
	
	/**
	 * Get the whole list of players registered in the database.
	 * 
	 * @return List<Player>
	 */
	public List<Player> getAllPlayers(){
		Log.i("TRACE_DB", "PlayerDataSource *** public List<Player> getAllPlayers()");
		
	    List<Player> p_list = new ArrayList<Player>();

	    Cursor cursor = _players_db.query(_players_db_helper.TABLE_PLAYER,
	        null, null, null, null, null, null);
	    
	   if(cursor.moveToFirst()){
	    	do{
	    		Player p = cursorToPlayer(cursor);
		    	p_list.add(p);
		    }while(cursor.moveToNext());
	    }
	    
	    //close the cursor
	    cursor.close();
	    
	    return p_list;
	}
	
	public Player getPlayerByNoLicence(String no_licence){
		Cursor c = _players_db.query(_players_db_helper.TABLE_PLAYER,
		        null, _players_db_helper.COL_PLAYER_NOLICENCE +" = ? ", new String[]{no_licence}, null, null, null);
		
		if(c.moveToFirst()){
			return cursorToPlayer(c);
		}else{
			return null;
		}
	}
	
	/**
	 * It changes a cursor concerning a player to an Object Player.
	 * 
	 * @param c
	 * @return Player
	 * @see Player
	 */
	public Player cursorToPlayer(Cursor c){
		Log.i("TRACE_DB", "PlayerDataSource *** public Player cursorToPlayer(Cursor c)");
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
