package org.jeudego.database;

import java.util.ArrayList;
import java.util.List;

import org.jeudego.pojo.Player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
		ContentValues values = new ContentValues();
		
		values.put(_players_db_helper.COL_PLAYER_ID, p.getId());
		values.put(_players_db_helper.COL_PLAYER_NAME, p.getName());
		values.put(_players_db_helper.COL_PLAYER_SURNAME, p.getSurname());
		values.put(_players_db_helper.COL_PLAYER_CLUB, p.getClub());
		values.put(_players_db_helper.COL_PLAYER_RATING, p.getRating());
		values.put(_players_db_helper.COL_PLAYER_NOLICENCE, p.getNoLicence());
		
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
	
	public List<Player> getAllPlayers(){
	    List<Player> p_list = new ArrayList<Player>();

	    Cursor cursor = _players_db.query(_players_db_helper.TABLE_PLAYER,
	        _players_db_helper.getAllPlayersColumns(), null, null, null, null, null);

	    if(cursor.moveToFirst()){
		    do{
		      Player p = cursorToPlayer(cursor);
		      p_list.add(p);
		      cursor.moveToNext();
		    }while(cursor.moveToNext());
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return p_list;
	}
	
	public Player cursorToPlayer(Cursor c){
		Player p = new Player();
		p.setId(c.getInt(0));
		p.setName(c.getString(1));
		p.setSurname(c.getString(2));
		p.setNoLicence(c.getString(3));
		p.setClub(c.getString(4));
		p.setRating(c.getInt(5));
		
		return p;
	}
}
