import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.io.File;
import java.io.IOException;


public class BagelApp extends JFrame{
	
	private int width = 800;
	private int height = 600;
	private JPanel parent;
	private JPanel panel1;
	private JPanel panel2a;
	private JPanel panel2b;
	private JPanel panel2c;
	private JPanel panel3;
	private JLabel title;
	private JPanel buttons;
	
	private JRadioButton product1;
	private JRadioButton product2;
	private JRadioButton product3;
	private ButtonGroup productgroup;
	
	private JPanel subpanel1;
	private JPanel subpanel2;
	private JPanel subpanel3;
	private JPanel subpanel4;
	private JPanel subpanel5;
	private JPanel subpanel6;
	private JPanel subpanel7;
	private JPanel subpanel8;
	private JPanel subpanel9;
	
	private JTextArea text;

	private JScrollPane scroll;
	
	//	PANEL 2A
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	private ButtonGroup group1;
	
	private JRadioButton decafe;
	private JRadioButton regular;
	private JRadioButton roast;
	private ButtonGroup group2;
	
	private JCheckBox cream;
	private JCheckBox sugar;
	
	// PANEL 2B
	
	private JRadioButton white;
	private JRadioButton wheat;
	private JRadioButton salt;
	private JRadioButton seseme;
	private JRadioButton popy;
	private ButtonGroup group4;
	
	private JRadioButton cc;
	private JRadioButton lcc;
	private JRadioButton gc;
	private JRadioButton butter;
	private JRadioButton jam;
	private ButtonGroup group5;
	
	private JCheckBox lox;
	private JCheckBox novalox;
	
	// PANEL 2C
	
	private String[] pastrylist = {"Apricot Danish", "Prune Danish", "Crossant", "English Muffin", "Blueberry Muffin"};
	private JList list;
	private int[] indices = {};
	
	// OTHERS
	
	private JLabel quantitylabel;
	private JTextField quantity;
	private JRadioButton gcash;
	private JRadioButton cash;
	private ButtonGroup paymentGroup;
	private JButton delete;
	private int q = 1;
	
	private BorderLayout layout;
	
	private boolean isMember;

	private Order order;
	private Coffee coffee;
	private Bagel bagel;
	private Pastry pastry;
	
	private BagelApp()
	{
		setTitle("Coffee");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(new Color(0xBE, 0x31, 0x44));
		
		buildPanel();
		add(panel3, BorderLayout.CENTER);
		add(title, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		add(parent, BorderLayout.WEST);
		
		setVisible(true);
		
		// CALL CLASSES
		order = new Order();
		coffee = new Coffee();
		bagel = new Bagel();
		pastry = new Pastry();
	}
	
	private void buildPanel()
	{
		/* A very big build method because
		 * all the panels are pre-made
		 */
		
		// PARENT PANEL
		
		parent = new JPanel();
		parent.setLayout(new BorderLayout(10,10));
		parent.setBackground(new Color(0xBE, 0x31, 0x44));

		title = new JLabel("C  O  F  F  E  E    S  H  O  P");
		title.setForeground(Color.WHITE); 
		title.setBorder(new LineBorder(Color.BLACK, 2));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setOpaque(true); // Enable component transparency
		title.setBackground(new Color(0xF0, 0x59, 0x41));
		title.setPreferredSize(new Dimension(12, 30));
		
		panel1 = new JPanel();
		panel2a = new JPanel();
		panel2b = new JPanel();
		panel2c = new JPanel();
		panel3 = new JPanel();
		
		// PANEL1
		
		panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2)));
		panel1.setLayout(new GridLayout(3, 1));
		panel1.setBackground(new Color(0x87, 0x23, 0x41));

		
		try {
            ImageIcon cupIcon = new ImageIcon(new File("cup.png").getCanonicalPath());
            Image cupImage = cupIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedCupIcon = new ImageIcon(cupImage);
			
            product1 = new JRadioButton(resizedCupIcon);
            product1.setSelectedIcon(resizedCupIcon);
            product1.setBackground(new Color(0x87, 0x23, 0x41));
            productgroup = new ButtonGroup();
            productgroup.add(product1);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		try {
            ImageIcon bagelIcon = new ImageIcon(new File("bagel.png").getCanonicalPath());
            Image bagelImage = bagelIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedBagelIcon = new ImageIcon(bagelImage);

            product2 = new JRadioButton(resizedBagelIcon);
            product2.setSelectedIcon(resizedBagelIcon);
            product2.setBackground(new Color(0x87, 0x23, 0x41));             
			productgroup = new ButtonGroup();
            productgroup.add(product2);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		try {
            ImageIcon pastryIcon = new ImageIcon(new File("pastry.png").getCanonicalPath());
            Image pastryImage = pastryIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedPastryIcon = new ImageIcon(pastryImage);

            product3 = new JRadioButton(resizedPastryIcon);
            product3.setSelectedIcon(resizedPastryIcon);
            product3.setBackground(new Color(0x87, 0x23, 0x41));
            productgroup = new ButtonGroup();
            productgroup.add(product3);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		productgroup = new ButtonGroup();
		productgroup.add(product1);
		productgroup.add(product2);
		productgroup.add(product3);
		
		product1.addActionListener(new ButtonListener());
		product2.addActionListener(new ButtonListener());
		product3.addActionListener(new ButtonListener());
		
		panel1.add(product1);
		panel1.add(product2);
		panel1.add(product3);
		
		panel2a.setLayout(new GridLayout(3,1));
		panel2a.setPreferredSize(new Dimension(180, 650));
		panel2a.setBackground(new Color(0x87, 0x23, 0x41));
        Border blackLineBorderPanel2a = BorderFactory.createLineBorder(Color.BLACK, 2);
        panel2a.setBorder(BorderFactory.createTitledBorder(blackLineBorderPanel2a));
		
		panel2b.setLayout(new GridLayout(3, 1));
        panel2b.setPreferredSize(new Dimension(180, 650));
        panel2b.setBackground(new Color(0x87, 0x23, 0x41));
        Border blackLineBorderPanel2b = BorderFactory.createLineBorder(Color.BLACK, 2);
        panel2b.setBorder(BorderFactory.createTitledBorder(blackLineBorderPanel2b));
		
		panel2c.setLayout(new GridLayout(2,1));
		panel2c.setPreferredSize(new Dimension(180, 650));
        panel2c.setBackground(new Color(0x87, 0x23, 0x41));
        Border blackLineBorderPanel2c = BorderFactory.createLineBorder(Color.BLACK, 2);
        panel2c.setBorder(BorderFactory.createTitledBorder(blackLineBorderPanel2c));
		
		subpanel1 = new JPanel();
		subpanel2 = new JPanel();
		subpanel3 = new JPanel();
		
		// PANEL3
		
		panel3.setLayout(new BorderLayout());
		panel3.setPreferredSize(new Dimension(180, 650));
		panel3.setBackground(new Color(0x87, 0x23, 0x41));
        Border blackLineBorderPanel3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        panel3.setBorder(BorderFactory.createTitledBorder(blackLineBorderPanel3));
		
		subpanel8 = new JPanel();
		Border blackLineBorderSubpanel8 = BorderFactory.createLineBorder(Color.BLACK, 0);
        TitledBorder titledBorderSubpanel8 = BorderFactory.createTitledBorder(blackLineBorderSubpanel8);
        titledBorderSubpanel8.setTitleColor(Color.WHITE); 
		subpanel8.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel8.setBorder(titledBorderSubpanel8);
		
		subpanel9 = new JPanel();
		Border blackLineBorderSubpanel9 = BorderFactory.createLineBorder(Color.BLACK, 0);
		TitledBorder titledBorderSubpanel9 = BorderFactory.createTitledBorder(blackLineBorderSubpanel9, "Order Details");
        titledBorderSubpanel9.setTitleColor(Color.WHITE);
		subpanel9.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel9.setBorder(titledBorderSubpanel9);
		subpanel9.setLayout(new BorderLayout());
		
		quantitylabel = new JLabel("Quantity: ");
		quantitylabel.setForeground(Color.WHITE); 
		quantity = new JTextField(5);
		quantity.setBackground(new Color(0xF0, 0x59, 0x41)); // Set the background color to BE3141
		quantity.setBorder(new LineBorder(Color.BLACK, 2));
		
		gcash = new JRadioButton("GCash");
		gcash.setForeground(Color.WHITE); 
		gcash.setBackground(new Color(0x87, 0x23, 0x41)); // Set the background color to BE3141

		cash = new JRadioButton("Cash");
		cash.setForeground(Color.WHITE); 
		cash.setBackground(new Color(0x87, 0x23, 0x41)); // Set the background color to BE3141

		paymentGroup = new ButtonGroup();
		delete = new JButton("Delete Previous");
		delete.setBackground(new Color(0xF0, 0x59, 0x41));
		delete.setPreferredSize(new Dimension(100, 30));
		delete.setBorder(new LineBorder(Color.BLACK, 2));
		
		gcash.setActionCommand("GCash");
		cash.setActionCommand("Cash");
		
		delete.addActionListener(new ButtonListener());
		quantity.addActionListener(new ButtonListener());
		gcash.addActionListener(new ButtonListener());
		cash.addActionListener(new ButtonListener());
		
		paymentGroup.add(gcash);
		paymentGroup.add(cash);
		
		text = new JTextArea();
		text.setBackground(new Color(0xDE, 0xD0, 0xB6));
		
		scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBackground(new Color(0x87, 0x23, 0x41)); // Set the background color to BE3141

        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        
        subpanel8.add(quantitylabel);
        subpanel8.add(quantity);
        subpanel8.add(gcash); // Change membery to gcash
		subpanel8.add(cash);  // Change membern to cash
        subpanel8.add(delete);
        subpanel9.add(scroll, BorderLayout.CENTER);
        
        panel3.add(subpanel8, BorderLayout.SOUTH);
		panel3.add(subpanel9, BorderLayout.CENTER);
		
		// BUTTON PANEL
		
		buttons = new JPanel();
        Border blackLineBorderButtons = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderButtons = BorderFactory.createTitledBorder(blackLineBorderButtons);
        buttons.setBackground(new Color(0x87, 0x23, 0x41));
        buttons.setBorder(titledBorderButtons);

        button1 = new JButton("Enter Item");
        button2 = new JButton("Total");
        button3 = new JButton("New Order");

        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());

        button1.setBackground(new Color(0xF0, 0x59, 0x41));
        button2.setBackground(new Color(0xF0, 0x59, 0x41));
        button3.setBackground(new Color(0xF0, 0x59, 0x41));
		
		button1.setPreferredSize(new Dimension(100, 30));
        button2.setPreferredSize(new Dimension(100, 30));
        button3.setPreferredSize(new Dimension(100, 30));

        button1.setBorder(new LineBorder(Color.BLACK, 2));
        button2.setBorder(new LineBorder(Color.BLACK, 2));
        button3.setBorder(new LineBorder(Color.BLACK, 2));	
			
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		
		//panel2a
		
		subpanel1.setLayout(new GridLayout(3,1));
		subpanel2.setLayout(new GridLayout(3,1));
		subpanel3.setLayout(new GridLayout(2,1));
		
		Border blackLineBorderSubpanel1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel1 = BorderFactory.createTitledBorder(blackLineBorderSubpanel1, "Size");
        titledBorderSubpanel1.setTitleColor(Color.WHITE); // Set the title text color
		subpanel1.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel1.setBorder(titledBorderSubpanel1);
		
		small = new JRadioButton("Small");
		small.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		medium = new JRadioButton("Medium");
		medium.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		large = new JRadioButton("Large");
		large.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		group1 = new ButtonGroup();
		
		small.setActionCommand("Small");
		
		medium.setActionCommand("Medium");
		large.setActionCommand("Large");
		
		small.addActionListener(new ButtonListener());
		medium.addActionListener(new ButtonListener());
		large.addActionListener(new ButtonListener());
		
		group1.add(small);
		group1.add(medium);
		group1.add(large);
		
		subpanel1.add(small);
		subpanel1.add(medium);
		subpanel1.add(large);
		
		Border blackLineBorderSubpanel2 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel2 = BorderFactory.createTitledBorder(blackLineBorderSubpanel2, "Type");
        titledBorderSubpanel2.setTitleColor(Color.WHITE); // Set the title text color
		subpanel2.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel2.setBorder(titledBorderSubpanel2);

		
		regular = new JRadioButton("Regular");
		regular.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		decafe = new JRadioButton("DeCafe");
		decafe.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		roast = new JRadioButton("French Roast");
		roast.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6

		group2 = new ButtonGroup();
		
		regular.setActionCommand("Regular");
		decafe.setActionCommand("DeCafe");
		roast.setActionCommand("French Roast");
		
		regular.addActionListener(new ButtonListener());
		decafe.addActionListener(new ButtonListener());
		roast.addActionListener(new ButtonListener());
		
		group2.add(regular);
		group2.add(decafe);
		group2.add(roast);
		
		subpanel2.add(regular);
		subpanel2.add(decafe);
		subpanel2.add(roast);
		
		Border blackLineBorderSubpanel3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel3 = BorderFactory.createTitledBorder(blackLineBorderSubpanel3, "Extras");
        titledBorderSubpanel3.setTitleColor(Color.WHITE); // Set the title text color
		subpanel3.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel3.setBorder(titledBorderSubpanel3);

		cream = new JCheckBox("Cream");
		cream.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		sugar = new JCheckBox("Sugar");
		sugar.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6

		
		cream.addActionListener(new ButtonListener());
		sugar.addActionListener(new ButtonListener());
		
		subpanel3.add(cream);
		subpanel3.add(sugar);
		
		panel2a.add(subpanel1);
		panel2a.add(subpanel2);
		panel2a.add(subpanel3);
		
		//panel2b
		
		subpanel4 = new JPanel();
		subpanel5 = new JPanel();
		subpanel6 = new JPanel();
		
		subpanel4.setLayout(new GridLayout(5,1));
		subpanel5.setLayout(new GridLayout(5,1));
		subpanel6.setLayout(new GridLayout(2,1));
		
		Border blackLineBorderSubpanel4 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel4 = BorderFactory.createTitledBorder(blackLineBorderSubpanel4, "Bagel");
        titledBorderSubpanel4.setTitleColor(Color.WHITE); // Set the title text color
		subpanel4.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel4.setBorder(titledBorderSubpanel4);
				
		white = new JRadioButton("White");
		white.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		wheat = new JRadioButton("Wheat");
		wheat.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		salt = new JRadioButton("Salt");
		salt.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		seseme = new JRadioButton("Seseme");
		seseme.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		popy = new JRadioButton("Popy");
		popy.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		
		group4 = new ButtonGroup();
		
		white.setActionCommand("White");
		wheat.setActionCommand("Wheat");
		salt.setActionCommand("Salt");
		seseme.setActionCommand("Seseme");
		popy.setActionCommand("Popy");
		
		white.addActionListener(new ButtonListener());
		wheat.addActionListener(new ButtonListener());
		salt.addActionListener(new ButtonListener());
		seseme.addActionListener(new ButtonListener());
		popy.addActionListener(new ButtonListener());
		
		group4.add(white);
		group4.add(wheat);
		group4.add(salt);
		group4.add(seseme);
		group4.add(popy);
		
		subpanel4.add(white);
		subpanel4.add(wheat);
		subpanel4.add(salt);
		subpanel4.add(seseme);
		subpanel4.add(popy);
		
		Border blackLineBorderSubpanel5 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel5 = BorderFactory.createTitledBorder(blackLineBorderSubpanel5, "Spreads");
        titledBorderSubpanel5.setTitleColor(Color.WHITE); // Set the title text color
		subpanel5.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel5.setBorder(titledBorderSubpanel5);
		
		cc = new JRadioButton("Cream Cheese ");
		cc.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		lcc = new JRadioButton("Lowfat Cream Cheese ");
		lcc.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		gc = new JRadioButton("Garlic Cream ");
		gc.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		butter = new JRadioButton("Butter ");
		butter.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		jam = new JRadioButton("Jam ");
		jam.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		
		group5 = new ButtonGroup();
		
		cc.setActionCommand("Cream Cheese ");
		lcc.setActionCommand("Lowfat Cream Cheese ");
		gc.setActionCommand("Garlic Cream ");
		butter.setActionCommand("Butter ");
		jam.setActionCommand("Jam ");
		
		cc.addActionListener(new ButtonListener());
		lcc.addActionListener(new ButtonListener());
		gc.addActionListener(new ButtonListener());
		butter.addActionListener(new ButtonListener());
		jam.addActionListener(new ButtonListener());
		
		group5.add(cc);
		group5.add(lcc);
		group5.add(gc);
		group5.add(butter);
		group5.add(jam);
		
		subpanel5.add(cc);
		subpanel5.add(lcc);
		subpanel5.add(gc);
		subpanel5.add(butter);
		subpanel5.add(jam);
		
		Border blackLineBorderSubpanel6 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel6 = BorderFactory.createTitledBorder(blackLineBorderSubpanel6, "Toppings");
        titledBorderSubpanel6.setTitleColor(Color.WHITE); // Set the title text color
		subpanel6.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel6.setBorder(titledBorderSubpanel6);
		
		lox = new JCheckBox("Lox");
		lox.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		novalox = new JCheckBox("Nova Lox");
		novalox.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6

		lox.addActionListener(new ButtonListener());
		novalox.addActionListener(new ButtonListener());
		
		subpanel6.add(lox);
		subpanel6.add(novalox);
		
		panel2b.add(subpanel4);
		panel2b.add(subpanel5);
		panel2b.add(subpanel6);
		
		//panel2c
		
		subpanel7 = new JPanel();
		
		subpanel7.setLayout(new GridLayout());
		
		Border blackLineBorderSubpanel7 = BorderFactory.createLineBorder(Color.BLACK, 2);
        TitledBorder titledBorderSubpanel7 = BorderFactory.createTitledBorder(blackLineBorderSubpanel7, "Pastries");
        titledBorderSubpanel7.setTitleColor(Color.WHITE); // Set the title text color
		subpanel7.setBackground(new Color(0x87, 0x23, 0x41));
        subpanel7.setBorder(titledBorderSubpanel7);
				
		list = new JList(pastrylist);
		list.setBackground(new Color(0xDE, 0xD0, 0xB6)); // RGB values for #DED0B6
		list.addListSelectionListener(new ListListener());
		
		subpanel7.add(list);
		panel2c.add(subpanel7);
		
		parent.add(panel1, BorderLayout.WEST);
		parent.add(panel2a, BorderLayout.CENTER);
		layout = (BorderLayout)parent.getLayout();
		
		product1.doClick();
	}
	
	private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (product1.isSelected()) {
            parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            parent.add(panel2a, BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
            if (group1.getSelection() == null) {
                small.doClick();
            }
            if (group2.getSelection() == null) {
                regular.doClick();
            }
        } else if (product2.isSelected()) {
            parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            parent.add(panel2b, BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
            if (group4.getSelection() == null) {
                white.doClick();
            }
        } else if (product3.isSelected()) {
            parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
            parent.add(panel2c, BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
        }

        if (arg0.getActionCommand().equals("Enter Item")) {
            try {
                if (!quantity.getText().isEmpty()) {
                    q = Integer.parseInt(quantity.getText());
                } else {
                    q = 1;
                }
                
                 if (q <= 0) {
                    // Handle case when quantity is not a positive integer
                    JOptionPane.showMessageDialog(BagelApp.this, "Please enter a valid positive quantity.", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                    quantity.setText("");
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle case when quantity is not a valid integer
                JOptionPane.showMessageDialog(BagelApp.this, "Please enter a valid integer for quantity.", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                quantity.setText("");
                return;
            }
            if (product1.isSelected()) {
                coffee.getSelectedButton(group1, group2);
                if (sugar.isSelected()) {
                    coffee.getString().add("Extra Sugar");
                    sugar.doClick();
                }
                if (cream.isSelected()) {
                    coffee.getString().add("Extra Cream");
                    cream.doClick();
                }
                coffee.pricing();
                for (int x = 0; x < q; x++) {
                    order.getOrder(coffee.getPrice(), coffee.getString());
                }
                q = 1;
                coffee.clear();
                small.doClick();
                regular.doClick();
            } else if (product2.isSelected()) {
                bagel.getSelectedButton(group4, group5);
                if (lox.isSelected()) {
                    bagel.getString().add("Lox Topping");
                    lox.doClick();
                }
                if (novalox.isSelected()) {
                    bagel.getString().add("Nova Lox Topping");
                    novalox.doClick();
                }
                bagel.pricing();
                for (int x = 0; x < q; x++) {
                    order.getOrder(bagel.getPrice(), bagel.getString());
                }
                q = 1;
                bagel.clear();
                white.doClick();
                group5.clearSelection();
            } else if (product3.isSelected()) {
                pastry.getSelectedButton(indices, pastrylist);
                pastry.pricing();
                for (int x = 0; x < q; x++) {
                    order.getOrder(pastry.getPrice(), pastry.getString());
                }
                q = 1;
                pastry.clear();
            }

            printOrder(order.getOrder(), order.getOrderprice());
            quantity.setText("");
        } else if (arg0.getActionCommand() == "New Order") {
            order.clear();
            product1.doClick();
            small.doClick();
            regular.doClick();
            white.doClick();
            group5.clearSelection();
            text.setText("");
        } else if (arg0.getActionCommand() == "Total") {
            String paymentMethod = isMember ? "GCash" : "Cash";
            text.append(String.format("%n%100s%2s%.2f", "Subtotal: ", "$", (float) order.calculateSubtotal() / 100));
            text.append(String.format("%n%102s%2s%.2f", "Total (" + paymentMethod + "): ", "$", (float) order.calculateTotal(isMember) / 100));
        } else if (arg0.getActionCommand() == "Delete Previous") {
            int i = order.getOrder().size() - 1;
            int k = order.getOrderprice().size() - 1;
            boolean yes = false;
            int y = i;
            int x = k;

            while (!yes && !(i == -1 && k == -1)) {
                if (order.getOrder().get(y).equals("Coffee") || order.getOrder().get(y).equals("Bagel") || order.getOrder().get(y).equals("Pastry")) {
                    order.getOrder().remove(y);
                    yes = true;
                } else {
                    order.getOrder().remove(y);
                    order.getOrderprice().remove(x);
                    y--;
                    x--;
                }
            }
            printOrder(order.getOrder(), order.getOrderprice());
        }

        if (arg0.getActionCommand().equals("GCash")) {
            isMember = true;
        } else if (arg0.getActionCommand().equals("Cash")) {
            isMember = false;
        }
    }
}

		
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			JList source;
			if (!arg0.getValueIsAdjusting())
			{
	            source = (JList)arg0.getSource();
	            indices = source.getSelectedIndices();
	        }
		}
	}
	
	private void printOrder(ArrayList<String> list, ArrayList<Integer> list2)
	{
		int y = 0;
		text.setText("");
		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x).equals("Coffee")||list.get(x).equals("Bagel")||list.get(x).equals("Pastry"))
			{
				text.append(list.get(x)+"\n");
			}
			else
			{
				text.append("           "+list.get(x)+"\n");
				text.append(String.format("%107s%.2f\n","$", (float)list2.get(y)/100));
				y++;
			}
		}
	}

	public static void main(String[] args)
	{
		BagelApp app = new BagelApp();
	}
	
	//Getters and Setters
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}
	
	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
}
