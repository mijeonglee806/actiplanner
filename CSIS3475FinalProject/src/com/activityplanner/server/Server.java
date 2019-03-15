package com.activityplanner.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server implements CallBack{
	final static int PORT = 8881;
	ServerSocket serverSocket;
	Socket clientSocket;
	DoubleLinkedList<Weather> dLink = null;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.communicate();
	}
	
	// COMMUNICATE WITH CLIENT
	public void communicate() {
		InetAddress ip;
		try {
			serverSocket = new ServerSocket(PORT);
			ip = InetAddress.getLocalHost();
			System.out.println("IP Address of Server: " + ip.getHostAddress());
			
			// Connect to client
			System.out.println("Waiting for Client...");
			clientSocket = serverSocket.accept();
			System.out.println("Connected to client! ");
			
			// Get city name from client
			ClientHandler clientHandler = new ClientHandler(clientSocket, this);
			Thread serverThread = new Thread(clientHandler);
			serverThread.start();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void setCityName(String city) {
		// Set the city name in order to retrieve data from API
		currentWeather(city);
		futureWeather(city);
		
		// Send the retrieved data to client
		sendDataToClient();
	}
	
	private void sendDataToClient() {
		ObjectOutputStream objOutput;
		
		try {
			objOutput = new ObjectOutputStream(clientSocket.getOutputStream());
			objOutput.writeObject(dLink);
			objOutput.flush();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private void currentWeather(String city) {
		GetJsonData jsonDataCurrent;
		ParsingCurrentJsonToObject pcjto;
		double temp;
		String weather, desc, date;
		
		dLink = new DoubleLinkedList<Weather>();
		
		// Get current weather
		jsonDataCurrent = new GetJsonData(city);
		pcjto = new ParsingCurrentJsonToObject(jsonDataCurrent.getWeatherData());
		
		temp = pcjto.getCurrentTemperature();
		weather = pcjto.getCurrentMain();
		desc = pcjto.getCurrentDesc();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date cDate = new Date();  
		date = formatter.format(cDate);
		
		dLink.add(new Weather(temp, weather, desc, date));
	}
	
	private void futureWeather(String city) {
		GetJsonData jsonDataFuture;
		ParsingFutureJsonToObject pjto;
		Double temp;
		String weather, desc, date;
		
		// Get future weather
		jsonDataFuture = new GetJsonData(city, 1);
		pjto = new ParsingFutureJsonToObject(jsonDataFuture.getWeatherData());
		
		for(int idx=0; idx < pjto.getSize(); idx++) {
			temp = pjto.getTemperature(idx);
			weather = pjto.getWeatherMain(idx);
			desc = pjto.getWeahterDesc(idx);
			date = pjto.getDate(idx);
			
			dLink.add(new Weather(temp, weather, desc, date));
		}
	}
}
