package com.activityplanner.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

public class GetJsonData implements Serializable{
	private static final long serialVersionUID = -9193894949417355223L;
	private String urlString;
	private StringBuilder result = null;
	private String API_KEY;
	private String LOCATION = null;
	
	//Get current JSON data - initial data
	public GetJsonData(String city) {
		this.LOCATION = city+",CA";
		API_KEY = "8b4df28fa34a49addd1f1f96306cef76";
		urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=imperial";
		
		try {
			result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			//CONVERT JSON TO STRING
			while((line = br.readLine())!= null){
				result.append(line);
			}
			br.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Get future JSON data
	public GetJsonData(String city, int num) {
		this.LOCATION = city+",CA";
		API_KEY = "8b4df28fa34a49addd1f1f96306cef76";
		urlString =  "http://api.openweathermap.org/data/2.5/forecast?q="+LOCATION+"&appid="+API_KEY+"&units=imperial";
		
		try {
			result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			//CONVERT JSON TO STRIN
			while((line = br.readLine())!= null){
				result.append(line);
			}
			br.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getWeatherData() {
		return result.toString();
	}
}
