package org.jeudego.pojo;

public class Club {

	private String _id;
	private String _name;
	
	public Club(){
	}
	
	public Club(String id, String name){
		this._id=id;
		this._name=name;
	}
	
	public void setId(String id){
		this._id=id;
	}
	
	public void setName(String name){
		this._name=name;
	}
	
	public String getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
	public String toString(){
		return "ID : "+_id+" \nName : "+_name;
	}
}
