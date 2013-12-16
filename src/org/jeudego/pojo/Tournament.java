package org.jeudego.pojo;

public class Tournament {

	private int _id;
	private String _title;
	private String _description;
	private String _dates;
	private boolean _follow;
	private String _calendar_id;
	
	public Tournament(){
	}
	
	public Tournament(String title, String description, String dates, boolean follow){
		_title=title;
		_description=description;
		_dates=dates;
		_follow=follow;
	}
	
	public Tournament(int id, String title, String description, String dates, boolean follow, String calendar_id){
		_id=id;
		_description=description;
		_title=title;
		_dates=dates;
		_follow=follow;
		_calendar_id=calendar_id;
	}
	
	public String getTitle(){
		return _title;
	}
	
	public void setTitle(String title){
		_title=title;
	}

	public String getDescription(){
		return _description;
	}
	
	public void setDescription(String description){
		_description=description;
	}
	
	public boolean getFollow(){
		return _follow;
	}
	
	public void setFollow(boolean follow){
		_follow=follow;
	}
}
