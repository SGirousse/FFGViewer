package org.jeudego.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represent a player entity and it contains all basic informations used to display and
 * search in the whole app.
 *  
 * @author simeon
 *
 */
public class Player implements Parcelable {
	private int _id;
	private String _name;
	private String _surname;
	private String _no_licence;
	private String _rating;
	private String _club;
	
	public Player(){
	}
	
	public Player(int id, String name, String surname, String no_licence, String rating, String club){
		this._id = id;
		this._name = name;
		this._surname = surname;
		this._no_licence = no_licence;
		this._rating = rating;
		this._club = club;
	}
	
	public Player(Parcel in){
		this._id = in.readInt();
		this._name = in.readString();
		this._surname = in.readString();
		this._no_licence = in.readString();
		this._rating = in.readString();
		this._club = in.readString();
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
	
	public void setRating(String rating){
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
	
	public String getRating(){
		return _rating;
	}
	
	public String getClub(){
		return _club;
	}

	public String toString(){
		return "ID : "+_id+" \nNom : "+_name+" \nPrenom : "+_surname+"No licence : "+_no_licence+" \nRating : "+_rating+" \nClub: "+_club;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(_id);
		dest.writeString(_name);
		dest.writeString(_surname);
		dest.writeString(_no_licence);
		dest.writeString(_rating);
		dest.writeString(_club);
	}
	
	public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
	    public Player createFromParcel(Parcel in) {
	        return new Player(in);
	    }

	    public Player[] newArray(int size) {
	        return new Player[size];
	    }
	};
}
