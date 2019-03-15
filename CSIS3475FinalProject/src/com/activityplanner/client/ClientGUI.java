package com.activityplanner.client;

import javax.swing.GroupLayout;

public class ClientGUI extends javax.swing.JFrame{
	private static final long serialVersionUID = 5353688312288340869L;

	public ClientGUI() {
		initComponents();
	}

	private void initComponents() {

		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
				new java.awt.Dimension(32767, 32767));
		jProgressBar1 = new javax.swing.JProgressBar();
		p2_up1 = new javax.swing.JPanel();
		btn_add = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		lbx_todo = new javax.swing.JList<>();
		lbl_weatherMain = new javax.swing.JLabel();
		lbl_weatherDesc = new javax.swing.JLabel();
		lbl_temp = new javax.swing.JLabel();
		lbl_tempMark = new javax.swing.JLabel();
		lbl_lineDivision = new javax.swing.JLabel();
		lbl_day = new javax.swing.JLabel();
		lbl_date = new javax.swing.JLabel();
		p2_up2 = new javax.swing.JPanel();
		p1 = new javax.swing.JPanel();
		lbl_month = new javax.swing.JLabel();
		p_table = new javax.swing.JPanel();
		tbl_calendar = new javax.swing.JTable();
		lbl_day_sun = new javax.swing.JLabel();
		lbl_day_mon = new javax.swing.JLabel();
		lbl_day_tus = new javax.swing.JLabel();
		lbl_day_wed = new javax.swing.JLabel();
		lbl_day_thus = new javax.swing.JLabel();
		lbl_day_fri = new javax.swing.JLabel();
		lbl_day_sat = new javax.swing.JLabel();
		lbl_title = new javax.swing.JLabel();
		btn_city = new javax.swing.JButton();
		lbl_city = new javax.swing.JLabel();
		p_icon = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Activity Planner");
		setBackground(new java.awt.Color(255, 255, 255));
		setResizable(false);
		
		p2_up1.setBackground(new java.awt.Color(46, 46, 72));

			btn_add.setIcon(new javax.swing.JLabel() {
				private static final long serialVersionUID = -6711370113292227095L;

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
			btn_add.setBorder(null);

		lbx_todo.setBackground(new java.awt.Color(249, 249, 249));
		lbx_todo.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = { "Item 1" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(lbx_todo);

		lbl_weatherMain.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
		lbl_weatherMain.setForeground(new java.awt.Color(220, 220, 220));
		lbl_weatherMain.setText("Weather: Rain");

		lbl_weatherDesc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
		lbl_weatherDesc.setForeground(new java.awt.Color(222, 222, 222));
		lbl_weatherDesc.setText("Description: Rain a lot");

		lbl_temp.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		lbl_temp.setForeground(new java.awt.Color(221, 221, 221));
		lbl_temp.setText("11");

		lbl_tempMark.setFont(new java.awt.Font("Yu Gothic UI", 1, 10)); // NOI18N
		lbl_tempMark.setForeground(new java.awt.Color(221, 221, 221));
		lbl_tempMark.setText("O");
		lbl_tempMark.setToolTipText("");

		lbl_lineDivision.setForeground(new java.awt.Color(230, 230, 230));
		lbl_lineDivision.setText("_______________________________");
		lbl_lineDivision.setToolTipText("");
		lbl_day.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lbl_day.setForeground(new java.awt.Color(235, 235, 235));
		lbl_day.setText("WED");

		lbl_date.setFont(new java.awt.Font("Segoe UI Black", 1, 26)); // NOI18N
		lbl_date.setForeground(new java.awt.Color(200, 173, 140));
		lbl_date.setText("8");

		p2_up2.setBackground(new java.awt.Color(46, 46, 72));

		javax.swing.GroupLayout p2_up2Layout = new javax.swing.GroupLayout(p2_up2);
		p2_up2.setLayout(p2_up2Layout);
		p2_up2Layout.setHorizontalGroup(p2_up2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 240, Short.MAX_VALUE));
		p2_up2Layout.setVerticalGroup(p2_up2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 10, Short.MAX_VALUE));

		p1.setBackground(new java.awt.Color(255, 255, 255));
		p1.setAlignmentX(0.0F);
		p1.setAlignmentY(0.0F);

		lbl_month.setFont(new java.awt.Font("Florencesans SC Black", 1, 48)); // NOI18N
		lbl_month.setForeground(new java.awt.Color(106, 111, 123));
		lbl_month.setText("NOVEMBER");

		p_table.setBackground(new java.awt.Color(255, 255, 255));

		tbl_calendar.setBackground(new java.awt.Color(249, 249, 249));
		tbl_calendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 243, 243)));
		tbl_calendar.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
		tbl_calendar.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, "  1", "  2", "3" },
						{ "  4", "  5", "  6", "  7", "  8", "  9", "10" },
						{ "  11", "  12", "  13", "  14", "  15", "  16", "17" },
						{ "  18", "  19", "  20", "  21", "  22", "  23", "24" },
						{ "  25", "  26", "  27", "  28", "  29", "  30", null } },
				new String[] { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" }));
		tbl_calendar.setGridColor(new java.awt.Color(249, 251, 252));
		tbl_calendar.setRowHeight(70);
		tbl_calendar.setRowSelectionAllowed(false);
		tbl_calendar.setSelectionBackground(new java.awt.Color(153, 204, 255));
		tbl_calendar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tbl_calendar.setShowHorizontalLines(false);

		lbl_day_sun.setForeground(new java.awt.Color(255, 153, 153));
		lbl_day_sun.setText("SUN");

		lbl_day_mon.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_mon.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_mon.setText("MON");
		lbl_day_mon.setToolTipText("");

		lbl_day_tus.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_tus.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_tus.setText("TUS");
		lbl_day_tus.setToolTipText("");

		lbl_day_wed.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_wed.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_wed.setText("WED");
		lbl_day_wed.setToolTipText("");

		lbl_day_thus.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_thus.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_thus.setText("THU");
		lbl_day_thus.setToolTipText("");

		lbl_day_fri.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_fri.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_fri.setText("FRI");
		lbl_day_fri.setToolTipText("");

		lbl_day_sat.setBackground(new java.awt.Color(122, 122, 122));
		lbl_day_sat.setForeground(new java.awt.Color(65, 65, 65));
		lbl_day_sat.setText("SAT");
		lbl_day_sat.setToolTipText("");

		javax.swing.GroupLayout p_tableLayout = new javax.swing.GroupLayout(p_table);
		p_table.setLayout(p_tableLayout);
		p_tableLayout.setHorizontalGroup(p_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p_tableLayout.createSequentialGroup().addGap(37, 37, 37).addComponent(lbl_day_sun)
						.addGap(77, 77, 77).addComponent(lbl_day_mon).addGap(71, 71, 71).addComponent(lbl_day_tus)
						.addGap(73, 73, 73).addComponent(lbl_day_wed).addGap(72, 72, 72).addComponent(lbl_day_thus)
						.addGap(77, 77, 77).addComponent(lbl_day_fri)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addComponent(lbl_day_sat).addGap(39, 39, 39))
				.addComponent(tbl_calendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		p_tableLayout.setVerticalGroup(p_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_tableLayout.createSequentialGroup()
						.addGap(0, 11, Short.MAX_VALUE)
						.addGroup(p_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_day_sun).addComponent(lbl_day_mon).addComponent(lbl_day_tus)
								.addComponent(lbl_day_wed).addComponent(lbl_day_thus).addComponent(lbl_day_fri)
								.addComponent(lbl_day_sat))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tbl_calendar,
								javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		lbl_title.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
		lbl_title.setForeground(new java.awt.Color(126, 127, 144));
		lbl_title.setText("ACTIVITY PLANNER");

		btn_city.setBackground(new java.awt.Color(255, 255, 255));
		btn_city.setForeground(new java.awt.Color(255, 255, 255));
		btn_city.setIcon(new javax.swing.JLabel() {
			private static final long serialVersionUID = 6154914554760248033L;

			public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://imgur.com/t8pfoVs.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
		btn_city.setBorder(null);

		lbl_city.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
		lbl_city.setForeground(new java.awt.Color(126, 127, 144));
		lbl_city.setText("Vancouver");

		javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
		p1.setLayout(p1Layout);
		p1Layout.setHorizontalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				p1Layout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE).addGroup(p1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbl_month)
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										p1Layout.createSequentialGroup()
												.addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 161,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbl_city)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btn_city, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(22, 22, 22))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										p1Layout.createSequentialGroup()
												.addComponent(p_table, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))));
		p1Layout.setVerticalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p1Layout.createSequentialGroup().addGroup(p1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p1Layout.createSequentialGroup().addGap(18, 18, 18)
								.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_city, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_city, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(16, 16, 16))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								p1Layout.createSequentialGroup().addContainerGap()
										.addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
						.addComponent(lbl_month, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(p_table, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(45, Short.MAX_VALUE)));

		p_icon.setBackground(new java.awt.Color(46, 46, 72));
		javax.swing.GroupLayout p_iconLayout = new javax.swing.GroupLayout(p_icon);
		p_icon.setLayout(p_iconLayout);
		p_iconLayout.setHorizontalGroup(p_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 150, Short.MAX_VALUE));
		p_iconLayout.setVerticalGroup(p_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		javax.swing.GroupLayout p2_up1Layout = new javax.swing.GroupLayout(p2_up1);
		p2_up1.setLayout(p2_up1Layout);
		p2_up1.setSize(1000, p2_up1.getHeight());
		
		p2_up1Layout.setHorizontalGroup(p2_up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p2_up1Layout.createSequentialGroup().addGroup(p2_up1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2_up1Layout.createSequentialGroup().addGap(53, 53, 53).addComponent(p_icon,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(p2_up1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(p2_up1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(p2_up1Layout.createSequentialGroup().addGroup(p2_up1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_weatherDesc).addComponent(lbl_weatherMain)
										.addGroup(p2_up1Layout.createSequentialGroup().addComponent(lbl_day)
												.addGap(4, 4, 4).addComponent(lbl_date).addGap(60, 60, 60)
												.addComponent(lbl_temp, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(lbl_tempMark)))
										.addGap(6, 6, 6))
								.addComponent(lbl_lineDivision, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 220,
										javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(27, 27, 27).addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(p2_up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2_up1Layout.createSequentialGroup().addContainerGap()
								.addComponent(p2_up2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(666, Short.MAX_VALUE))));
		
		
		p2_up1Layout.setVerticalGroup(p2_up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p2_up1Layout.createSequentialGroup().addGroup(p2_up1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2_up1Layout.createSequentialGroup().addGap(26, 26, 26)
								.addComponent(p_icon, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(p2_up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(p2_up1Layout.createSequentialGroup().addComponent(lbl_tempMark).addGap(28,
												28, 28))
										.addGroup(p2_up1Layout.createSequentialGroup()
												.addGroup(p2_up1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_temp, javax.swing.GroupLayout.PREFERRED_SIZE,
																38, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_day).addComponent(lbl_date))
												.addGap(1, 1, 1)))
								.addComponent(lbl_lineDivision)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lbl_weatherMain, javax.swing.GroupLayout.PREFERRED_SIZE, 13,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(4, 4, 4)
								.addComponent(lbl_weatherDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(p2_up1Layout.createSequentialGroup().addContainerGap().addComponent(p1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(p2_up1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2_up1Layout.createSequentialGroup().addContainerGap()
								.addComponent(p2_up2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(524, Short.MAX_VALUE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				p2_up1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(p2_up1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, Short.MAX_VALUE));

		pack();
	}
	
	public void removeListbox(Boolean val) {
		lbx_todo.setVisible(val);
		jScrollPane1.setVisible(val);
	}
	
	public void setActivity(String str) {
		String strings[] = str.split(",");

		lbx_todo.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
	}

	// Variables declaration - do not modify
	public javax.swing.JButton btn_add;
	public javax.swing.JButton btn_city;
	@SuppressWarnings("unused")
	private javax.swing.Box.Filler filler1;
	public javax.swing.JLabel lbl_lineDivision;
	@SuppressWarnings("unused")
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JTable tbl_calendar;
	public javax.swing.JLabel lbl_day;
	private javax.swing.JLabel lbl_day_fri;
	private javax.swing.JLabel lbl_day_mon;
	private javax.swing.JLabel lbl_day_sat;
	private javax.swing.JLabel lbl_day_sun;
	private javax.swing.JLabel lbl_day_thus;
	private javax.swing.JLabel lbl_day_tus;
	private javax.swing.JLabel lbl_day_wed;
	public javax.swing.JLabel lbl_date;
	private javax.swing.JLabel lbl_month;
	public javax.swing.JLabel lbl_tempMark;
	public javax.swing.JLabel lbl_temp;
	private javax.swing.JLabel lbl_title;
	public javax.swing.JLabel lbl_city;
	public javax.swing.JLabel lbl_weatherDesc;
	public javax.swing.JLabel lbl_weatherMain;
	public javax.swing.JList<String> lbx_todo;
	private javax.swing.JPanel p1;
	private javax.swing.JPanel p2_up1;
	private javax.swing.JPanel p2_up2;
	public javax.swing.JPanel p_icon;
	private javax.swing.JPanel p_table;
	// End of variables declaration

}
