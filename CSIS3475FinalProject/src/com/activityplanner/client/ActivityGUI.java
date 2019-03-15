package com.activityplanner.client;

import javax.swing.JFrame;

public class ActivityGUI extends JFrame {
	private static final long serialVersionUID = -2365649898626761353L;

	public ActivityGUI() {
		initComponents();
	}

	private void initComponents() {

		p1 = new javax.swing.JPanel();
		p2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		lbx_planedItem = new javax.swing.JList<>();
		btn_down = new javax.swing.JButton();
		btn_up = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		lbx_item = new javax.swing.JList<>();
		btn_save = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("ADD ACTIVITY");
		setBackground(new java.awt.Color(46, 46, 72));
		setResizable(false);
		java.awt.Dimension dimension = new java.awt.Dimension(325, 425);
		setPreferredSize(dimension);

		p1.setBackground(new java.awt.Color(46, 46, 72));

		p2.setBackground(new java.awt.Color(255, 255, 255));

		jScrollPane1.setViewportView(lbx_planedItem);

		btn_down.setBackground(new java.awt.Color(255, 255, 255));
		btn_down.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					return new javax.swing.ImageIcon(new java.net.URL("https://imgur.com/uhcU0Ln.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());
		btn_down.setBorder(null);

		btn_up.setBackground(new java.awt.Color(255, 255, 255));
		btn_up.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					return new javax.swing.ImageIcon(new java.net.URL("https://imgur.com/zef0nRi.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());
		btn_up.setBorder(null);

		jScrollPane2.setViewportView(lbx_item);

		javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
		p2.setLayout(p2Layout);
		p2Layout.setHorizontalGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p2Layout.createSequentialGroup().addContainerGap().addGroup(p2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2Layout.createSequentialGroup()
								.addComponent(btn_down, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13,
										Short.MAX_VALUE)
								.addComponent(btn_up, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1)).addContainerGap())
				.addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(p2Layout
						.createSequentialGroup().addContainerGap().addComponent(jScrollPane2).addContainerGap())));
		p2Layout.setVerticalGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p2Layout.createSequentialGroup().addContainerGap(142, Short.MAX_VALUE).addGroup(p2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(btn_up, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_down, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p2Layout.createSequentialGroup().addGap(21, 21, 21)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(156, Short.MAX_VALUE))));

		btn_save.setBackground(new java.awt.Color(46, 46, 72));
		btn_save.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					return new javax.swing.ImageIcon(new java.net.URL("https://imgur.com/XicdJ1l.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());
		btn_save.setBorder(null);

		javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
		p1.setLayout(p1Layout);
		p1Layout.setHorizontalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p1Layout.createSequentialGroup().addGroup(p1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(p1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(p2,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(p1Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(btn_save,
								javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		p1Layout.setVerticalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p1Layout.createSequentialGroup().addGap(28, 28, 28)
						.addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p1,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p1,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	public void setPlannerItem(String data) {
		System.out.println("setPlannerItem: " + data);
		if (data == null) {
			data = "";
		}
		
		String strings[] = data.split(",");
		lbx_planedItem.setModel(new javax.swing.AbstractListModel<String>() {
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});

	}

	public void setActivityItem(String data) {
		System.out.println("setActivityItem: " + data);
		String strings[] = data.split(",");
		lbx_item.setModel(new javax.swing.AbstractListModel<String>() {
			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
	}

	// Variables declaration - do not modify
	public javax.swing.JButton btn_down;
	public javax.swing.JButton btn_save;
	public javax.swing.JButton btn_up;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	public javax.swing.JList<String> lbx_item;
	public javax.swing.JList<String> lbx_planedItem;
	private javax.swing.JPanel p1;
	private javax.swing.JPanel p2;
	// End of variables declaration
}
