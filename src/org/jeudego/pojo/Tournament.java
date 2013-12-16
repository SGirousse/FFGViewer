package org.jeudego.pojo;

public class Tournament {

	private int _id;
	private String _title;
	private String _dates;
	private boolean _participate_to_it;
	private String _calendar_id;
	
	public Tournament(){
	}
	
	public Tournament(String title, String dates, boolean participate_to_it){
		_title=title;
		_dates=dates;
		_participate_to_it=participate_to_it;
	}
	
	public Tournament(int id, String title, String dates, boolean participate_to_it, String calendar_id){
		_id=id;
		_title=title;
		_dates=dates;
		_participate_to_it=participate_to_it;
		_calendar_id=calendar_id;
	}
	
	public String getTitle(){
		return _title;
	}

}
