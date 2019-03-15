package com.activityplanner.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsingCurrentJsonToObject {
	private String temp = "";
	private String description = "";
	private String main = "";
	private JSONObject obj_data;
	private JSONObject obj_data_main;
	private JSONArray arr_data_desc;
	private JSONObject obj_data_desc;
	
	public ParsingCurrentJsonToObject(String jsonData) {
		try {
			obj_data = new JSONObject(jsonData.toString());
			obj_data_main = obj_data.getJSONObject("main");
			temp = obj_data_main.get("temp").toString();
			
			arr_data_desc = obj_data.getJSONArray("weather");
			obj_data_desc = arr_data_desc.getJSONObject(0);
			main = obj_data_desc.get("main").toString();
			description = obj_data_desc.get("description").toString();
			
		}catch(JSONException ex) {
			ex.printStackTrace();
		}
	}
	
	// Get data
	public double getCurrentTemperature() {
		return Double.parseDouble(temp);
	}
	public String getCurrentMain() {
		return main;
	}
	public String getCurrentDesc() {
		return description;
	}
}
