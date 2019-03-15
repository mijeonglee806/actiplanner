package com.activityplanner.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.activityplanner.old.LinkedList;

public class ActivityListener implements ActionListener {
	ClientGUI clientGUI = null;
	ActivityGUI activityGUI = null;
	AddActivity addActivity = null;
	BinaryTree<String> bTree = null;
//	LinkedList lList = null;
	
	public ActivityListener(ClientGUI clientGUI, BinaryTree<String> bTree) {
		this.clientGUI = clientGUI;
		this.bTree = bTree;
//		this.lList = lList;
		activityGUI = new ActivityGUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.getActivity();
		this.executeGUI();
	}
	
	private void getActivity() {
		String temp = clientGUI.lbl_temp.getText();
		String weather = clientGUI.lbl_weatherMain.getText();
		
		addActivity = new AddActivity(temp, weather, bTree.search(clientGUI.lbl_date.getText()));
		String activity = addActivity.getActivity();
		System.out.println("Activity get activity: " + addActivity.getActivity());
		activityGUI.setActivityItem(activity);
		activityGUI.setPlannerItem(bTree.search(clientGUI.lbl_date.getText()));
	}
	
	
	public ActivityGUI getActivityGUI() {
		return activityGUI;
	}
	
	private void executeGUI() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ActivityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ActivityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ActivityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ActivityGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				activityGUI.setVisible(true);
			}
		});
	}
}
