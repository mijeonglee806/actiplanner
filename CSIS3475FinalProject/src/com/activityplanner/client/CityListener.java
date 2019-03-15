package com.activityplanner.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CityListener implements ActionListener{
	private CityGUI cityGUI = null;
	public CityListener() {
		this.cityGUI = new CityGUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.executeGUI();
	}
	
	public CityGUI getCityGUI() {
		return cityGUI;
	}
	
	public void executeGUI() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CityGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CityGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CityGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CityGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				cityGUI.setVisible(true);
			}
		});
	}
}
