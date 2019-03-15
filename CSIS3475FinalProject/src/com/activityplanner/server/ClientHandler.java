package com.activityplanner.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket clientSocket;
	private String city;
	private CallBack callBack;
	
	public ClientHandler(Socket socket, CallBack cBack) {
		this.clientSocket = socket;
		this.callBack = cBack;
	}
	
	@Override
	public void run() {
		BufferedReader in;
		try {
			// Get the city name from client
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String line;
			while(true) {
				line = in.readLine();
				if(line == null) break;
				city = line;
				callBack.setCityName(city);
				System.out.println("User entered city: " + city);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				clientSocket.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
