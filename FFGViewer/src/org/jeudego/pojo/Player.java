package org.jeudego.pojo;

/**
 * Represent a player entity and it contains all basic informations used to display and
 * search in the whole app.
 *  
 * @author simeon
 *
 */
public class Player {
	private int _id;
	private String _name;
	private String _surname;
	private String _no_licence;
	private int _rating;
	private String _club;
	
	public Player(){
	}
	
	public Player(int id, String name, String surname, String no_licence, int rating, String club){
		this._id = id;
		this._name = name;
		this._surname = surname;
		this._no_licence = no_licence;
		this._rating = rating;
		this._club = club;
	}
	
	public void setName(String name){
		this._name=name;
	}
	
	public void setSurname(String surname){
		this._surname=surname;
	}
	
	public void setId(int id){
		this._id=id;
	}
	
	public void setNoLicence(String no_licence){
		this._no_licence=no_licence;
	}
	
	public void setRating(int rating){
		this._rating=rating;
	}
	
	public void setClub(String club){
		this._club=club;
	}
	
	public String getName(){
		return _name;
	}
	
	public String getSurname(){
		return _surname;
	}
	
	public int getId(){
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

	public String toString(){
		return "ID : "+_id+" \nNom : "+_name+" \nPrenom : "+_surname+"No licence : "+_no_licence+" \nRating : "+_rating+" \nClub: "+_club;
	}
}
