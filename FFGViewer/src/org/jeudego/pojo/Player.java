package org.jeudego.pojo;

/**
 * Represent a player entity and it contains all basic informations used to display and
 * search in the whole app.
 *  
 * @author simeon
 *
 */
public class Player {
	private String _name;
	private String _surname;
	private String _id;
	private String _no_licence;
	private int _rating;
	private String _club;
	private String _country;
	
	public Player(String id, String name, String surname){
		this._id = id;
		this._name = name;
		this._surname = surname;
	}
	
	public Player(String id, String name, String surname, String no_licence, int rating, String club, String country){
		this._id = id;
		this._name = name;
		this._surname = surname;
		this._no_licence = no_licence;
		this._rating = rating;
		this._club = club;
		this._country = country;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getSurname(){
		return _surname;
	}
	
	public String getId(){
		return _id;
	}
	
	public String getNoLicence(){
		return _no_licence;
	}
	
	public int getRating(){
		return _rating;
	}
	
	public String getClub(){
		return _club;
	}
	
	public String getCountry(){
		return _country;
	}
}
