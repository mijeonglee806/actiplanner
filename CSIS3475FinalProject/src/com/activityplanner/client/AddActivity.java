package com.activityplanner.client;

public class AddActivity {
	private String temp, weather;
	private String existingActivity = "";
	private String activity = "";

	public AddActivity(String temp, String weather, String activity) {
		this.temp = temp;
		this.weather = weather;
		this.existingActivity = activity;

		activity();
	}

	private void activity() {
		Boolean bicycle = false;
		Boolean swim = false;
		Boolean jogging = false;
		Boolean gym = false;
		Boolean ski = false;
		Boolean tennis = false;
		Boolean snowboard = false;
		Boolean yoga = false;
		Boolean taekwondo = false;
		Boolean soccer = false;
		Boolean climbing = false;
		Boolean kayaking = false;
		Boolean pingpong = false;
		Boolean pool = false;

		Boolean highTemp = false;

		if (weather.equals("Weather: Not available")) {
			activity += "Activity unavailable in this day";
		} else {
			// Temperature
			if (Double.parseDouble(temp) >= 50)
				highTemp = true;
			else
				highTemp = false;

			// Weather
			if (weather.equals("Clear") || weather.equals("Clouds")) {
				if (highTemp) {
					bicycle = true;
					swim = true;
					jogging = true;
					gym = true;
					yoga = true;
					taekwondo = true;
					soccer = true;
					climbing = true;
					kayaking = true;
					tennis = true;
					pool = true;
					pingpong = true;
				} else {
					ski = true;
					snowboard = true;
					gym = true;
					yoga = true;
					taekwondo = true;
					pool = true;
					pingpong = true;
					yoga = true;
				}
			} else if (weather.equals("Snow") || weather.equals("Mist")) {
				ski = true;
				snowboard = true;
				gym = true;
				yoga = true;
				taekwondo = true;
				pool = true;
				pingpong = true;
			} else {
				gym = true;
				yoga = true;
				taekwondo = true;
				pool = true;
				pingpong = true;
			}

			// Remove existing item from activity list
			if(existingActivity != null) {
				String[] temp = existingActivity.split(",");
				for (int idx = 0; idx < temp.length; idx++) {
					if (temp[idx].equals("Bicycle"))
						bicycle = false;
					else if (temp[idx].equals("Swim"))
						swim = false;
					else if (temp[idx].equals("Jogging"))
						jogging = false;
					else if (temp[idx].equals("Gym"))
						gym = false;
					else if (temp[idx].equals("Ski"))
						ski = false;
					else if (temp[idx].equals("Tennis"))
						tennis = false;
					else if (temp[idx].equals("Snowboard"))
						snowboard = false;
					else if (temp[idx].equals("Yoga"))
						yoga = false;
					else if (temp[idx].equals("Taekwondo"))
						taekwondo = false;
					else if (temp[idx].equals("Soccer"))
						soccer = false;
					else if (temp[idx].equals("Climbing"))
						climbing = false;
					else if (temp[idx].equals("Kayaking"))
						kayaking = false;
					else if (temp[idx].equals("Ping pong"))
						pingpong = false;
					else if (temp[idx].equals("Pool"))
						pool = false;
				}
			}
			
			if(bicycle) activity += "Bicycle, ";
			if(swim) activity += "Swim,";
			if(jogging) activity += "Jogging,";
			if(gym) activity += "Gym,";
			if(yoga) activity += "Yoga,";
			if(taekwondo) activity += "Taekwondo,";
			if(soccer) activity += "Soccer,";
			if(climbing) activity += "Climbing,";
			if(kayaking) activity += "Kayaking,";
			if(ski) activity += "Ski,";
			if(snowboard) activity += "Snowboard,";
			if(tennis) activity += "Tennis,";
			if(pingpong) activity += "Ping pong,";
			if(pool) activity += "Pool,";
		}
	}

	// Remove comma
	private String removeString(String str) {
		if (str != null && str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public String getActivity() {
		activity = removeString(activity);
		return activity;
	}
}
