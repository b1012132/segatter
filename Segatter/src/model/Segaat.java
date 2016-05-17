package model;

import java.io.Serializable;

public class Segaat implements Serializable {

	private String comment;
	private String date;
	private String auther;

	public Segaat(){}

	public Segaat(String comment, String date, String auther){
		this.comment = comment;
		this.date = date;
		this.auther = auther;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

}
