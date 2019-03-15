package com.activityplanner.server;

import java.io.Serializable;

public class Weather implements Serializable {
	private static final long serialVersionUID = 4732054576569714904L;
	
	Double temp;
	String weather, desc, date;
	
	public Weather(Double temp, String weather, String desc, String date) {
		this.temp = temp;
		this.weather = weather;
		this.desc = desc;
		this.date = date;
	}
	
	public String toString() {
		return temp + "," + weather + "," + desc + "," + date;
	}
	
}
