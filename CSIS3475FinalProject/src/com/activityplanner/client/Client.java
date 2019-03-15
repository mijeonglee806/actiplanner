package com.activityplanner.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.activityplanner.server.DoubleLinkedList;
import com.activityplanner.server.Weather;

public class Client implements Runnable{
	private String hostName = "192.168.0.14";
	private final int PORT = 8881;
	private Socket clientSocket;
	
	private ClientGUI clientGUI = null;
	private DoubleLinkedList<Weather> dLink;
	private BinaryTree<String> bTree = null;
	private PrintWriter out;
	
	javax.swing.JLabel lbl_weather = null;
	javax.swing.JLabel lbl_desc = null;
	javax.swing.JLabel lbl_temp = null;
	javax.swing.JLabel lbl_day = null;
	javax.swing.JLabel lbl_date = null;
	javax.swing.JTable tbl_calendar = null;
	javax.swing.JLabel lbl_tempMark = null;
	javax.swing.JList<String> lbx_activity = null;
	javax.swing.JLabel lbl_line = null;
	javax.swing.JButton btn_add = null;
	
	int counter = 0;
	
	public Client() {
		bTree = new BinaryTree<>();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.communicate();
		client.eventGUI();
	}
	
	private void setDefaultGUI() {
		lbl_weather = clientGUI.lbl_weatherMain;
		lbl_desc = clientGUI.lbl_weatherDesc;
		lbl_temp = clientGUI.lbl_temp;
		lbl_day = clientGUI.lbl_day;
		lbl_date = clientGUI.lbl_date;
		tbl_calendar = clientGUI.tbl_calendar;
		lbx_activity = clientGUI.lbx_todo;
		lbl_line = clientGUI.lbl_lineDivision;
		
		// Set current weather
		String[] lines = dLink.toString().split("\\n");
		String[] line = lines[0].split(",");
		lbl_temp.setText(line[0]);
		lbl_weather.setText("Weather: " + line[1]);
		lbl_desc.setText(line[2]);
		
		// Set current time
		DateTimeFormatter date = DateTimeFormatter.ofPattern("d");
		Calendar calendar = Calendar.getInstance();
		Date dayOfWeek = calendar.getTime();
		LocalDate localDate = LocalDate.now();
		String currentDate = date.format(localDate); // Date
		String currentDay = new SimpleDateFormat("EE", Locale.ENGLISH).format(dayOfWeek.getTime());
		lbl_day.setText(currentDay);
		lbl_date.setText(currentDate);
		
		// Set current time in Calendar
		int row = -1;
		int column = -1;
		int cDate = Integer.parseInt(currentDate);
		if(cDate <= 3) row = 0;
		else if(cDate > 3 && cDate <= 10) row = 1;
		else if(cDate > 10 && cDate <= 17) row = 2;
		else if(cDate > 17 && cDate <= 24) row = 3;
		else if(cDate > 24 && cDate <= 30) row = 4;
		
		switch(currentDay) {
			case "Mon": column = 1; break;
			case "Tue": column = 2; break;
			case "Wed": column = 3; break;
			case "Thu": column = 4; break;
			case "Fri": column = 5; break;
			case "Sat": column = 6; break;
			case "Sun": column = 0; break;
			default: column = 0;
		}
		
		tbl_calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_calendar.getSelectionModel().setSelectionInterval(row, row);
		tbl_calendar.setColumnSelectionInterval(column, column);
		tbl_calendar.requestFocusInWindow();
		
		// Set activity
		try {
			//Read file
			FileReader reader = new FileReader("ACTIVITY_DATA.txt");
			BufferedReader br = new BufferedReader(reader);
			String data;
			String[] temp;
			while((data = br.readLine()) != null) {
				temp = data.split("-");
				String items = temp[0];
				String itemsDate = temp[1];
				bTree.add(items, itemsDate);
			}
			
			//Set data
			if(bTree.search(String.valueOf(cDate)) != null) {
				clientGUI.setActivity(bTree.search(String.valueOf(cDate)));
			}else {
				clientGUI.setActivity("");
			}
			
			br.close();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		//Additional
		setHighTemperature(tbl_calendar);
		
		executeGUI(clientGUI);
	}
	
	private void eventGUI() {
		javax.swing.JButton btn_city = clientGUI.btn_city;
		
		// Select city button
		CityListener cityListener = new CityListener();
		ActionListener listener = cityListener;
		btn_city.addActionListener(listener);
		
		// Switch city and save
		CityGUI cityGUI = cityListener.getCityGUI();
		java.awt.TextField txt_city = cityGUI.txt_city;
		javax.swing.JButton btn_save = cityGUI.btn_save;
		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String city = txt_city.getText();
				out.println(city);
				cityGUI.dispose();
				
				clientGUI.lbl_city.setText(city);
				cityGUI.txt_city.setText("");
			}
		});
		
		// Close window
		clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientGUI.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				// Write file
				try {
					FileWriter writer = new FileWriter("ACTIVITY_DATA.txt", false);
					writer.write(bTree.toString());
					writer.close();
					
					// Close Application
					if(clientSocket != null) {
						clientSocket.close();
						out.close();
					}
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		// ADD ACTIVITY
		// Add activity button
		btn_add = clientGUI.btn_add;
		ActivityListener activityListener = new ActivityListener(clientGUI, bTree);
		ActionListener aListener = activityListener;
		btn_add.addActionListener(aListener);
		
		// Add or remove plan
		ActivityGUI activityGUI = activityListener.getActivityGUI();
		javax.swing.JButton btn_up = activityGUI.btn_up;
		javax.swing.JButton btn_down = activityGUI.btn_down;
		javax.swing.JList<String> lbx_item = activityGUI.lbx_item;
		javax.swing.JList<String> lbx_plannedItem = activityGUI.lbx_planedItem;
		
		// Add
		btn_down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lbx_item.getSelectedValue() != null) {
					String selectedItem = lbx_item.getSelectedValue().toString();
					
					String planner = "";
					// Get all list in planner
					for(int i = 0; i < lbx_plannedItem.getModel().getSize(); i++) {
						planner += lbx_plannedItem.getModel().getElementAt(i) + ",";
					}
					planner += selectedItem;
					
					String item = "";
					// Get all list in item
					int length = lbx_item.getModel().getSize();
					for(int idx = 0; idx < length; idx++) {
						if(!(lbx_item.getModel().getElementAt(idx).equals(selectedItem))) {
							item += lbx_item.getModel().getElementAt(idx) + ",";
						}
					}
					activityGUI.setActivityItem(item);
					activityGUI.setPlannerItem(planner);
				}
			}
		});
		
		// Remove
		btn_up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lbx_plannedItem.getSelectedValue() != null) {
					String selectedItem = lbx_plannedItem.getSelectedValue().toString();
					
					String item = "";
					// Get all list in item
					for(int i = 0; i < lbx_item.getModel().getSize(); i++) {
						item += lbx_item.getModel().getElementAt(i) + ",";
					}
					
					item += selectedItem;
					
					String planner = "";
					// Get all list in planner
					int length = lbx_plannedItem.getModel().getSize();
					for(int idx = 0; idx < length; idx++) {
						if(!(lbx_plannedItem.getModel().getElementAt(idx).equals(selectedItem))) {
							planner += lbx_plannedItem.getModel().getElementAt(idx) + ",";
						}
					}
					activityGUI.setActivityItem(item);
					activityGUI.setPlannerItem(planner);
				}
			}
		});
		// Save activities planned
		javax.swing.JButton btn_saveActivity = activityGUI.btn_save;
		btn_saveActivity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Save the data in linked list
				String date = clientGUI.lbl_date.getText();
				String item = "";
				for(int i = 0; i < lbx_plannedItem.getModel().getSize(); i++) {
					item += lbx_plannedItem.getModel().getElementAt(i) + ",";
				}
				
				// Update Linked List
				if(item.length() > 0) item = item.substring(0, item.length()-1);
				
				if(bTree.replace(item, date, 1)) bTree.replace(item, date);
				else bTree.add(item, date);
				
				// Update main GUI
				clientGUI.setActivity(bTree.search(date));
				setActivityGUI(true);
				// Close
				activityGUI.dispose();
			}
		});
		
		tbl_calendar = clientGUI.tbl_calendar;
		
		// Change date
		tbl_calendar.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	int row = tbl_calendar.rowAtPoint(evt.getPoint());
		    	int col = tbl_calendar.columnAtPoint(evt.getPoint());
		    	String selectedDate = null;
		    	
		    	if(tbl_calendar.getModel().getValueAt(row, col) != null) {
		    		String temp = tbl_calendar.getModel().getValueAt(row, col).toString().trim();
		    		
		    		if(temp.length() > 3) {
		    			selectedDate = temp.substring(0, 2).trim();
		    		}else {
		    			selectedDate = temp;
		    		}
		    		
		    		if(bTree.search(selectedDate) != null) {
			    		clientGUI.setActivity(bTree.search(selectedDate));
			    		
			    	}else {
			    		clientGUI.setActivity(" ");
			    	}
			    	
			    	String weather = searchData(selectedDate);
			    	setWeatherGUI(weather);
			    	setDateGUI(selectedDate);
			    	setActivityGUI(true);
		    	}else {
		    		setWeatherGUI(null);
		    		setDateGUI(null);
		    		setActivityGUI(false);
		    	}
		    }
		});
	}
	
	private void setHighTemperature(javax.swing.JTable tbl) {
		QuickSort<Weather> quickSort = new QuickSort<Weather>(dLink.first);
		DefaultTableModel model = (DefaultTableModel)tbl.getModel();
		// Get the value of table
		for(int idx = 0; idx < 5; idx++) {
			for(int ind = 0; ind < 7; ind++) {
				if(tbl.getModel().getValueAt(idx, ind) != null) {
					String valueCal = tbl.getModel().getValueAt(idx, ind).toString().trim();
					
					// Get highest temperature
					String[] temp = dLink.last.data.toString().split(",");
					String[] temp2 = temp[3].split("-");
					String valueHigh = temp2[2].substring(0, 2);
					
					// Get lowest temperature
					String[] tempLow = dLink.first.data.toString().split(",");
					String[] tempLow2 = tempLow[3].split("-");
					String valueLow = tempLow2[2].substring(0, 2);
				
					if(valueCal.length() > 2) {
						valueCal = valueCal.substring(0, 2);
					}
					
					model.setValueAt(valueCal, idx, ind);
					
					if(valueHigh.equals(valueCal)) {
						model.setValueAt(valueHigh + " WARMEST", idx, ind);
						System.out.println(valueHigh + " " + valueCal);
					}
					if(valueLow.equals(valueCal)) {
						model.setValueAt(valueLow + " COLDEST", idx, ind);
						System.out.println(valueLow + " " + valueCal);
					}
				}
			}
		}
	}
	
	private void setDateGUI(String date) {
		if(date != null) {
			// set date
			lbl_date.setText(date);
			
			// set day
			int temp = Integer.parseInt(date) % 7;
			String day = "";
			switch(temp) {
				case 0: day = "Wed"; break;
				case 1: day = "Thu"; break;
				case 2: day = "Fri"; break;
				case 3: day = "Sat"; break;
				case 4: day = "Sun"; break;
				case 5: day = "Mon"; break;
				case 6: day = "Tue"; break;
				default: day = "None";
			}
			lbl_day.setText(day);
		}else {
			lbl_date.setText("");
			lbl_day.setText("");
		}
		
	}
	private void setWeatherGUI(String data) {
		lbl_tempMark = clientGUI.lbl_tempMark;
		
		if(data != null) {
			String[] temp = data.split(",");
			String temperature, weather, desc;
			temperature = temp[0];
			weather = temp[1];
			desc = temp[2];
			
			lbl_temp.setText(temperature);
			lbl_weather.setText(weather);
			lbl_desc.setText(desc);
			
			if(desc.equals("Not available")) {
				lbl_tempMark.setText("");
			}else {
				lbl_tempMark.setText("O");
			}
		}else {
			lbl_tempMark.setText("");
			lbl_temp.setText("");
			lbl_weather.setText("");
			lbl_desc.setText("");
		}
	}
	
	private void setActivityGUI(Boolean yn) {
		if(!yn) {
			lbl_line.setText("");
			clientGUI.removeListbox(false);
			btn_add.setIcon(new javax.swing.JLabel() {
				private static final long serialVersionUID = 6154914554760248033L;

				public javax.swing.Icon getIcon() {
	                try {
	                    return new javax.swing.ImageIcon(
	                        new java.net.URL("https://imgur.com/DMLCWU4.jpg")
	                    );
	                } catch (java.net.MalformedURLException e) {
	                }
	                return null;
	            }
	        }.getIcon());
		}else {
			lbl_line.setText("_______________________________");
			clientGUI.removeListbox(true);
			btn_add.setIcon(new javax.swing.JLabel() {
				private static final long serialVersionUID = 6154914554760248033L;

				public javax.swing.Icon getIcon() {
	                try {
	                    return new javax.swing.ImageIcon(
	                        new java.net.URL("https://imgur.com/A1SK4HX.jpg")
	                    );
	                } catch (java.net.MalformedURLException e) {
	                }
	                return null;
	            }
	        }.getIcon());
		}
	}
	
	private String searchData(String date) {
		String data = dLink.toString();
		String[] lines = data.split("\\n");
		String[] temp,tempTime;
		int tempDate;
		int tempHour;
		int tempMonth;
		String found = "";
		
		for(String line : lines) {
			temp = line.split(",");
			tempTime = temp[3].split("-");
			tempDate = Integer.parseInt(tempTime[2].substring(0, 2));
			tempMonth = Integer.parseInt(tempTime[1]);
			tempHour = Integer.parseInt(tempTime[2].substring(3, 5));
			
			if(tempDate == Integer.parseInt(date) && tempMonth == 11) {
				//if current date
				Calendar calendar = Calendar.getInstance();
			    Date getDate = calendar.getTime();
			    java.text.DateFormat formatter = new SimpleDateFormat("dd");
			    String currentDate = formatter.format(getDate);
				if(tempDate == Integer.parseInt(currentDate)) {
					found = line;
					break;
				}
				
				//if 12o'clock
				else if(tempDate != Integer.parseInt(currentDate) && tempHour == 12) {
					found = line;
					break;
				}
			}
			else {
				found = " ,Weather: Not available,Not available";
			}
		}
		return found;
	}
	
	// COMMUNICATE WITH SERVER
	private void communicate() {
		String msg;
		
		try {
			clientGUI = new ClientGUI();
			System.out.println("Trying to connect - " + hostName + ":" + "PORT" + " , " + (new Date()).toString());
			clientSocket = new Socket(hostName, PORT);
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			new Thread(this).start();
			
			msg = "Vancouver";
			while(true) {
				if(msg.equalsIgnoreCase("Vancouver")) {
					out.println(msg);
					msg = "none";
				}else {
					break;
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	// GET OBJECT FROM SERVER
	@Override
	public void run() {
		ObjectInputStream objInput;
		
		// Get data from server
		try {
			while(true) {
				objInput = new ObjectInputStream(clientSocket.getInputStream());
				if(objInput == null) break; 
				else {
					dLink = (DoubleLinkedList<Weather>)objInput.readObject();
					
					setDefaultGUI();
				}
			}
		}catch(Exception ex) {
			Thread.currentThread().interrupt();
			return;
		}
	}
	
	private static void executeGUI(ClientGUI gui) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		});
	}
}
