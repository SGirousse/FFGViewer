package org.jeudego.pojo;

import java.util.ArrayList;
import java.util.List;

public class News {

	private int _id;
	private String _title;
	private String _contents;
	private String _source;
	private String _url;
	private List<String> _authors;
	
	public News(){
	}
	
	public News(String title, String contents, String source, String url, ArrayList<String> authors){
		_title=title;
		_contents=contents;
		_source=source;
		_url=url;
		_authors=authors;
	}
	
	public News(int id, String title, String contents, String source, String url, ArrayList<String> authors){
		_id=id;
		_title=title;
		_contents=contents;
		_source=source;
		_url=url;
		_authors=authors;
	}
	
	public int getId(){
		return _id;
	}
	
	public void setTitle(String title){
		_title=title;
	}
	
	public String getTitle(){
		return _title;
	}
	
	public void setContents(String contents){
		_contents=contents;
	}
	
	public String getContents(){
		return _contents;
	}
	
	public void setSource(String source){
		_source=source;
	}
	
	public String getSource(){
		return _source;
	}
	
	public void setUrl(String url){
		_url=url;
	}
	
	public String getUrl(){
		return _url;
	}
	
	public void setAuthors(ArrayList<String> authors){
		_authors=authors;
	}
	
	public List<String> getAuthors(){
		return _authors;
	}

}
