package com.activityplanner.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsingFutureJsonToObject{
	
	private JSONObject obj_JSONObject;
	private JSONArray obj_JSONArray;
	private JSONObject[] obj_JSONObject_list;
	private JSONArray obj_JSONObject_list_weather;
	private JSONObject obj_JSONObject_list_weather_data;
	
	public ParsingFutureJsonToObject(String jsonData) {
		try {
			//CONVERT STRING TO JAVA OBJECT
			obj_JSONObject = new JSONObject(jsonData.toString());
			//GETTING LIST
			obj_JSONArray = obj_JSONObject.getJSONArray("list");
			
			int listArrLength = obj_JSONArray.length();
			obj_JSONObject_list = new JSONObject[listArrLength];
			for(int counter = 0; counter<listArrLength; counter++) {
				obj_JSONObject_list[counter] = obj_JSONArray.getJSONObject(counter);
			}
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
	}
	
	public int getSize() {
		return obj_JSONArray.length();
	}

	public Double getTemperature(int idx) {
		Double temp = null;
		try {
			JSONObject obj_JSONObject_list_main = obj_JSONObject_list[idx].getJSONObject("main");
			temp = Double.parseDouble(obj_JSONObject_list_main.get("temp").toString());
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
		return temp;
	}
	
	public String getWeatherMain(int idx) {
		String weather = null;
		try {
			obj_JSONObject_list_weather = obj_JSONObject_list[idx].getJSONArray("weather");
			obj_JSONObject_list_weather_data = obj_JSONObject_list_weather.getJSONObject(0);
			weather = obj_JSONObject_list_weather_data.get("main").toString();
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
		return weather;
	}
	
	public String getWeahterDesc(int idx) {
		String weather = null;
		try {
			obj_JSONObject_list_weather = obj_JSONObject_list[idx].getJSONArray("weather");
			obj_JSONObject_list_weather_data = obj_JSONObject_list_weather.getJSONObject(0);
			weather = obj_JSONObject_list_weather_data.get("description").toString();
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
		return weather;
	}
	public String getDate(int idx) {
		String Date = null;
		try {
			Date = obj_JSONObject_list[idx].get("dt_txt").toString();
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
		return Date;
	}
}
