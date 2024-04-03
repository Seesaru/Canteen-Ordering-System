package ordersystem;

import java.awt.EventQueue;
import java.lang.String;
import javax.swing.SpinnerNumberModel;
import java.util.Date;
import java.awt.Image;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class SecondFrame {

	JFrame SecondFrame;
	private JLabel timeLabel;  
	private JLabel dateLabel;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel model;
	
	
    
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					SecondFrame second = new SecondFrame();
					second.SecondFrame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecondFrame() {
		initialize();
		showDateTime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void showDateTime() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");

                        Date now = new Date();

                        // Format date and time separately
                        String date = dateFormat.format(now);
                        String time = timeFormat.format(now);

                        // Update the date and time labels
                        dateLabel.setText("Date: " + date);
                        timeLabel.setText("Time: " + time);

                        sleep(1000); // Update every second
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
	
	
	public int calculateTotalPrice(JTable table) {
	    int total = 0;
	    int rowCount = table.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        total += Integer.parseInt(table.getValueAt(i, 2).toString()); // Assuming the total price is in column 2
	    }
	    return total;
	}
	
	public void calculateTotalPrice(JLabel totalPriceLabel, JTable table) {
	    double totalPrice = calculateTotalPrice(table);
	    totalPriceLabel.setText("TOTAL PRICE: ₱ " + totalPrice); // Update label text with total price
	}
	
	public boolean isJTableEmpty(JTable table) {
	    if (table.getModel().getRowCount() == 0) {
	        return true; // If the table has no rows, it's empty
	    } else {
	        return false; // The table has rows, so it's not empty
	    }
	}
	
	private void initialize() {
		
		
		
		SecondFrame = new JFrame();
		SecondFrame.setUndecorated(true);
        SecondFrame.setSize(new Dimension(1608, 883));
        SecondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 55));
        SecondFrame.setContentPane(panel);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setBounds(22, 90, 1045, 664);
        panel.add(tabbedPane);
        tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tabbedPane.setPreferredSize(new Dimension(300,100));
        
        
      
        JPanel foodPanel = new JPanel();
        foodPanel.setBackground(new Color(251, 140, 4));
        foodPanel.setLayout(null);
        tabbedPane.addTab("Foods", null, foodPanel, null);
        foodPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 64), 4, true));
        panel_1.setBounds(97, 21, 243, 276);
        foodPanel.add(panel_1);
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setForeground(new Color(190, 137, 12));
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\siomai1 (1).jpg"));
        lblNewLabel.setBounds(10, 10, 218, 142);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Siomai (3pcs)");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1.setBounds(64, 162, 126, 21);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(10, 188, 126, 21);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Quantity:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1.setBounds(10, 219, 66, 21);
        panel_1.add(lblNewLabel_1_1_1);
        
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner1 = new JSpinner(spinnerModel);
        spinner1.setBounds(77, 221, 41, 20);
        panel_1.add(spinner1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Select:");
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1.setBounds(10, 249, 55, 21);
        panel_1.add(lblNewLabel_1_1_1_1);
        
        final JCheckBox checkBox1 = new JCheckBox("");
        checkBox1.setBounds(72, 249, 33, 21);
        panel_1.add(checkBox1);
        
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox1.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner1.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBorder(new LineBorder(new Color(0, 0, 64), 4, true));
        panel_1_1.setBounds(369, 21, 243, 276);
        foodPanel.add(panel_1_1);
        panel_1_1.setLayout(null);
        panel_1_1.setForeground(new Color(190, 137, 12));
        panel_1_1.setBackground(Color.WHITE);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\siopao.jpg"));
        lblNewLabel_2.setBounds(10, 10, 223, 142);
        panel_1_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_2 = new JLabel("Siopao");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_2.setBounds(87, 162, 62, 21);
        panel_1_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_2.setBounds(10, 188, 126, 21);
        panel_1_1.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_1_2 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_2.setBounds(10, 219, 66, 21);
        panel_1_1.add(lblNewLabel_1_1_1_2);
        
        SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner2 = new JSpinner(spinnerModel1);
        spinner2.setBounds(77, 221, 41, 20);
        panel_1_1.add(spinner2);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_1.setBounds(10, 249, 55, 21);
        panel_1_1.add(lblNewLabel_1_1_1_1_1);
        
        final JCheckBox checkBox2 = new JCheckBox("");
        checkBox2.setBounds(72, 249, 33, 21);
        panel_1_1.add(checkBox2);
        
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox2.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner2.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 64), 4, true));
        panel_1_1_1.setBounds(642, 21, 243, 276);
        foodPanel.add(panel_1_1_1);
        panel_1_1_1.setLayout(null);
        panel_1_1_1.setForeground(new Color(190, 137, 12));
        panel_1_1_1.setBackground(Color.WHITE);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("D:\\Downloads\\burger.jpg"));
        lblNewLabel_2_1.setBounds(10, 10, 218, 142);
        panel_1_1_1.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("Burger");
        lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_2_1.setBounds(93, 162, 71, 21);
        panel_1_1_1.add(lblNewLabel_1_2_1);
        
        JLabel lblNewLabel_1_1_2_1 = new JLabel("Price:   ₱ 35");
        lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_2_1.setBounds(10, 188, 126, 21);
        panel_1_1_1.add(lblNewLabel_1_1_2_1);
        
        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_2_1.setBounds(10, 219, 66, 21);
        panel_1_1_1.add(lblNewLabel_1_1_1_2_1);
       
        SpinnerNumberModel spinnerModel2 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner3 = new JSpinner(spinnerModel2);
        spinner3.setBounds(77, 221, 41, 20);
        panel_1_1_1.add(spinner3);
        
        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_1_1.setBounds(10, 249, 55, 21);
        panel_1_1_1.add(lblNewLabel_1_1_1_1_1_1);
        
        final JCheckBox checkBox3 = new JCheckBox("");
        checkBox3.setBounds(72, 249, 33, 21);
        panel_1_1_1.add(checkBox3);
        
        checkBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox3.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner3.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setBorder(new LineBorder(new Color(0, 0, 64), 4, true));
        panel_1_2.setLayout(null);
        panel_1_2.setForeground(new Color(190, 137, 12));
        panel_1_2.setBackground(Color.WHITE);
        panel_1_2.setBounds(220, 334, 243, 276);
        foodPanel.add(panel_1_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\hotdog1.jpg"));
        lblNewLabel_3.setBounds(10, 10, 223, 142);
        panel_1_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_1_3 = new JLabel("Hotdog");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_3.setBounds(84, 162, 66, 21);
        panel_1_2.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_3.setBounds(10, 188, 126, 21);
        panel_1_2.add(lblNewLabel_1_1_3);
        
        JLabel lblNewLabel_1_1_1_3 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_3.setBounds(10, 219, 66, 21);
        panel_1_2.add(lblNewLabel_1_1_1_3);
        
        SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner4 = new JSpinner(spinnerModel4);
        spinner4.setBounds(77, 221, 41, 20);
        panel_1_2.add(spinner4);
        
        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_2.setBounds(10, 249, 55, 21);
        panel_1_2.add(lblNewLabel_1_1_1_1_2);
        
        final JCheckBox checkBox4 = new JCheckBox("");
        checkBox4.setBounds(72, 249, 33, 21);
        panel_1_2.add(checkBox4);
        
        checkBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox4.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner4.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_3 = new JPanel();
        panel_1_3.setBorder(new LineBorder(new Color(0, 0, 64), 4, true));
        panel_1_3.setLayout(null);
        panel_1_3.setForeground(new Color(190, 137, 12));
        panel_1_3.setBackground(Color.WHITE);
        panel_1_3.setBounds(519, 334, 243, 276);
        foodPanel.add(panel_1_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("D:\\Downloads\\cup noodles (1).jpg"));
        lblNewLabel_4.setBounds(51, 10, 149, 142);
        panel_1_3.add(lblNewLabel_4);
        
        JLabel lblNewLabel_1_4 = new JLabel("Cup Noodles");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_4.setBounds(75, 162, 106, 21);
        panel_1_3.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_1_1_4 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_4.setBounds(10, 188, 126, 21);
        panel_1_3.add(lblNewLabel_1_1_4);
        
        JLabel lblNewLabel_1_1_1_4 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_4.setBounds(10, 219, 66, 21);
        panel_1_3.add(lblNewLabel_1_1_1_4);
        
        SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner5 = new JSpinner(spinnerModel5);
        spinner5.setBounds(77, 221, 41, 20);
        panel_1_3.add(spinner5);
        
        JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_3.setBounds(10, 249, 55, 21);
        panel_1_3.add(lblNewLabel_1_1_1_1_3);
        
        final JCheckBox checkBox5 = new JCheckBox("");
        checkBox5.setBounds(72, 249, 33, 21);
        panel_1_3.add(checkBox5);
        
        checkBox5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox5.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner5.setModel(model); 
                }
            }
        });
        
        //drinksPanel
        
        JPanel drinksPanel = new JPanel();
        tabbedPane.addTab("Drinks", null, drinksPanel, null);
        drinksPanel.setBackground(new Color(247, 151, 9));
        drinksPanel.setLayout(null);
        
        JPanel panel_1_5 = new JPanel();
        panel_1_5.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5.setLayout(null);
        panel_1_5.setForeground(new Color(190, 137, 12));
        panel_1_5.setBackground(Color.WHITE);
        panel_1_5.setBounds(150, 301, 187, 201);
        drinksPanel.add(panel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("Zesto ");
        lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6.setBounds(70, 90, 54, 21);
        panel_1_5.add(lblNewLabel_1_6);
        
        JLabel lblNewLabel_1_1_6 = new JLabel("Price:  ₱ 15");
        lblNewLabel_1_1_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6.setBounds(10, 121, 126, 21);
        panel_1_5.add(lblNewLabel_1_1_6);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("D:\\Downloads\\images (3).jpg"));
        lblNewLabel_6.setBounds(36, 10, 100, 81);
        panel_1_5.add(lblNewLabel_6);
        
        JLabel lblNewLabel_1_6_1 = new JLabel("Quantity:");
        lblNewLabel_1_6_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1.setBounds(10, 143, 64, 21);
        panel_1_5.add(lblNewLabel_1_6_1);
        
        JLabel lblNewLabel_1_6_1_1 = new JLabel("Select");
        lblNewLabel_1_6_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1.setBounds(10, 166, 41, 21);
        panel_1_5.add(lblNewLabel_1_6_1_1);
        
        SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner7 = new JSpinner(spinnerModel7);
        spinner7.setBounds(64, 144, 30, 20);
        panel_1_5.add(spinner7);
        
        final JCheckBox checkBox7 = new JCheckBox("");
        checkBox7.setBounds(57, 170, 30, 21);
        panel_1_5.add(checkBox7);
        
        checkBox7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox7.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner7.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1 = new JPanel();
        panel_1_5_1.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1.setLayout(null);
        panel_1_5_1.setForeground(new Color(190, 137, 12));
        panel_1_5_1.setBackground(Color.WHITE);
        panel_1_5_1.setBounds(417, 10, 187, 201);
        drinksPanel.add(panel_1_5_1);
        
        JLabel lblNewLabel_1_6_2 = new JLabel("Coke (sakto)");
        lblNewLabel_1_6_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2.setBounds(50, 90, 99, 21);
        panel_1_5_1.add(lblNewLabel_1_6_2);
        
        JLabel lblNewLabel_1_1_6_1 = new JLabel("Price:   ₱ 15");
        lblNewLabel_1_1_6_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1.setBounds(10, 121, 126, 21);
        panel_1_5_1.add(lblNewLabel_1_1_6_1);
        
        JLabel lblNewLabel_6_1 = new JLabel("");
        lblNewLabel_6_1.setIcon(new ImageIcon("D:\\Downloads\\d7e05c1d5eeb25c49d97f674bc072576 (1).png"));
        lblNewLabel_6_1.setBounds(45, 10, 91, 81);
        panel_1_5_1.add(lblNewLabel_6_1);
        
        JLabel lblNewLabel_1_6_1_2 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2.setBounds(10, 143, 64, 21);
        panel_1_5_1.add(lblNewLabel_1_6_1_2);
        
        JLabel lblNewLabel_1_6_1_1_1 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1.setBounds(10, 166, 41, 21);
        panel_1_5_1.add(lblNewLabel_1_6_1_1_1);
        
        SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner8 = new JSpinner(spinnerModel8);
        spinner8.setBounds(64, 144, 30, 20);
        panel_1_5_1.add(spinner8);
        
        final JCheckBox checkBox8 = new JCheckBox("");
        checkBox8.setBounds(57, 170, 30, 21);
        panel_1_5_1.add(checkBox8);
        
        checkBox8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox8.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner8.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_1 = new JPanel();
        panel_1_5_1_1.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_1.setLayout(null);
        panel_1_5_1_1.setForeground(new Color(190, 137, 12));
        panel_1_5_1_1.setBackground(Color.WHITE);
        panel_1_5_1_1.setBounds(417, 221, 187, 201);
        drinksPanel.add(panel_1_5_1_1);
        
        JLabel lblNewLabel_1_6_2_1 = new JLabel("Coke (mismo)");
        lblNewLabel_1_6_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_1.setBounds(47, 90, 110, 21);
        panel_1_5_1_1.add(lblNewLabel_1_6_2_1);
        
        JLabel lblNewLabel_1_1_6_1_1 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1_6_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_1.setBounds(10, 121, 126, 21);
        panel_1_5_1_1.add(lblNewLabel_1_1_6_1_1);
        
        JLabel lblNewLabel_6_1_1 = new JLabel("");
        lblNewLabel_6_1_1.setIcon(new ImageIcon("D:\\Downloads\\2004853827-1.png"));
        lblNewLabel_6_1_1.setBounds(36, 10, 100, 81);
        panel_1_5_1_1.add(lblNewLabel_6_1_1);
        
        JLabel lblNewLabel_1_6_1_2_1 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_1.setBounds(10, 143, 64, 21);
        panel_1_5_1_1.add(lblNewLabel_1_6_1_2_1);
        
        JLabel lblNewLabel_1_6_1_1_1_1 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_1.setBounds(10, 166, 41, 21);
        panel_1_5_1_1.add(lblNewLabel_1_6_1_1_1_1);
        
        SpinnerNumberModel spinnerModel11= new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner11 = new JSpinner(spinnerModel11);
        spinner11.setBounds(64, 144, 30, 20);
        panel_1_5_1_1.add(spinner11);
        
        final JCheckBox checkBox11 = new JCheckBox("");
        checkBox11.setBounds(57, 170, 30, 21);
        panel_1_5_1_1.add(checkBox11);
        
        checkBox11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox11.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner11.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_2 = new JPanel();
        panel_1_5_1_2.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_2.setLayout(null);
        panel_1_5_1_2.setForeground(new Color(190, 137, 12));
        panel_1_5_1_2.setBackground(Color.WHITE);
        panel_1_5_1_2.setBounds(614, 426, 187, 201);
        drinksPanel.add(panel_1_5_1_2);
        
        JLabel lblNewLabel_1_6_2_2 = new JLabel("Sprite (1 liter)");
        lblNewLabel_1_6_2_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_2.setBounds(40, 90, 107, 21);
        panel_1_5_1_2.add(lblNewLabel_1_6_2_2);
        
        JLabel lblNewLabel_1_1_6_1_2 = new JLabel("Price:  ₱ 45");
        lblNewLabel_1_1_6_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_2.setBounds(10, 121, 126, 21);
        panel_1_5_1_2.add(lblNewLabel_1_1_6_1_2);
        
        JLabel lblNewLabel_6_1_2 = new JLabel("");
        lblNewLabel_6_1_2.setIcon(new ImageIcon("D:\\Downloads\\images (1).jpg"));
        lblNewLabel_6_1_2.setBounds(51, 10, 107, 81);
        panel_1_5_1_2.add(lblNewLabel_6_1_2);
        
        JLabel lblNewLabel_1_6_1_2_2 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_2.setBounds(10, 143, 64, 21);
        panel_1_5_1_2.add(lblNewLabel_1_6_1_2_2);
        
        JLabel lblNewLabel_1_6_1_1_1_2 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_2.setBounds(10, 166, 41, 21);
        panel_1_5_1_2.add(lblNewLabel_1_6_1_1_1_2);
        
        SpinnerNumberModel spinnerModel15 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner15 = new JSpinner(spinnerModel15);
        spinner15.setBounds(64, 144, 30, 20);
        panel_1_5_1_2.add(spinner15);
        
        final JCheckBox checkBox15 = new JCheckBox("");
        checkBox15.setBounds(57, 170, 30, 21);
        panel_1_5_1_2.add(checkBox15);
        
        checkBox15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox15.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner15.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_2 = new JPanel();
        panel_1_5_2.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_2.setLayout(null);
        panel_1_5_2.setForeground(new Color(190, 137, 12));
        panel_1_5_2.setBackground(Color.WHITE);
        panel_1_5_2.setBounds(150, 68, 187, 201);
        drinksPanel.add(panel_1_5_2);
        
        JLabel lblNewLabel_1_6_3 = new JLabel("Bottled Water");
        lblNewLabel_1_6_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_3.setBounds(45, 90, 107, 21);
        panel_1_5_2.add(lblNewLabel_1_6_3);
        
        JLabel lblNewLabel_1_1_6_2 = new JLabel("Price:  ₱ 15");
        lblNewLabel_1_1_6_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_2.setBounds(10, 121, 126, 21);
        panel_1_5_2.add(lblNewLabel_1_1_6_2);
        
        JLabel lblNewLabel_6_2 = new JLabel("");
        lblNewLabel_6_2.setIcon(new ImageIcon("D:\\Downloads\\images (4).jpg"));
        lblNewLabel_6_2.setBounds(45, 10, 107, 81);
        panel_1_5_2.add(lblNewLabel_6_2);
        
        JLabel lblNewLabel_1_6_1_3 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_3.setBounds(10, 143, 64, 21);
        panel_1_5_2.add(lblNewLabel_1_6_1_3);
        
        JLabel lblNewLabel_1_6_1_1_2 = new JLabel("Select");
        lblNewLabel_1_6_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_2.setBounds(10, 166, 41, 21);
        panel_1_5_2.add(lblNewLabel_1_6_1_1_2);
        
        SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner6 = new JSpinner(spinnerModel6);
        spinner6.setBounds(64, 144, 30, 20);
        panel_1_5_2.add(spinner6);
        
        final JCheckBox checkBox6 = new JCheckBox("");
        checkBox6.setBounds(57, 170, 30, 21);
        panel_1_5_2.add(checkBox6);
       
        checkBox6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox6.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner6.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_3 = new JPanel();
        panel_1_5_1_3.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_3.setLayout(null);
        panel_1_5_1_3.setForeground(new Color(190, 137, 12));
        panel_1_5_1_3.setBackground(Color.WHITE);
        panel_1_5_1_3.setBounds(614, 10, 187, 201);
        drinksPanel.add(panel_1_5_1_3);
        
        JLabel lblNewLabel_1_6_2_3 = new JLabel("Sprite (sakto)");
        lblNewLabel_1_6_2_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_3.setBounds(50, 90, 99, 21);
        panel_1_5_1_3.add(lblNewLabel_1_6_2_3);
        
        JLabel lblNewLabel_1_1_6_1_3 = new JLabel("Price:   ₱ 15");
        lblNewLabel_1_1_6_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_3.setBounds(10, 121, 126, 21);
        panel_1_5_1_3.add(lblNewLabel_1_1_6_1_3);
        
        JLabel lblNewLabel_6_1_3 = new JLabel("");
        lblNewLabel_6_1_3.setIcon(new ImageIcon("D:\\Downloads\\d6015ed5f51f17e70eee08b7d39bd34e.png"));
        lblNewLabel_6_1_3.setBounds(43, 10, 106, 81);
        panel_1_5_1_3.add(lblNewLabel_6_1_3);
        
        JLabel lblNewLabel_1_6_1_2_3 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_3.setBounds(10, 143, 64, 21);
        panel_1_5_1_3.add(lblNewLabel_1_6_1_2_3);
        
        JLabel lblNewLabel_1_6_1_1_1_3 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_3.setBounds(10, 166, 41, 21);
        panel_1_5_1_3.add(lblNewLabel_1_6_1_1_1_3);
        
        SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner9 = new JSpinner(spinnerModel9);
        spinner9.setBounds(64, 144, 30, 20);
        panel_1_5_1_3.add(spinner9);
        
        final JCheckBox checkBox9 = new JCheckBox("");
        checkBox9.setBounds(57, 170, 30, 21);
        panel_1_5_1_3.add(checkBox9);
        
        checkBox9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox9.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner9.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_4 = new JPanel();
        panel_1_5_1_4.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_4.setLayout(null);
        panel_1_5_1_4.setForeground(new Color(190, 137, 12));
        panel_1_5_1_4.setBackground(Color.WHITE);
        panel_1_5_1_4.setBounds(811, 10, 187, 201);
        drinksPanel.add(panel_1_5_1_4);
        
        JLabel lblNewLabel_1_6_2_4 = new JLabel("Royal (sakto)");
        lblNewLabel_1_6_2_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_4.setBounds(50, 90, 99, 21);
        panel_1_5_1_4.add(lblNewLabel_1_6_2_4);
        
        JLabel lblNewLabel_1_1_6_1_4 = new JLabel("Price:   ₱ 15");
        lblNewLabel_1_1_6_1_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_4.setBounds(10, 121, 126, 21);
        panel_1_5_1_4.add(lblNewLabel_1_1_6_1_4);
        
        JLabel lblNewLabel_6_1_4 = new JLabel("");
        lblNewLabel_6_1_4.setIcon(new ImageIcon("D:\\Downloads\\d1aec9830e7f99b558f9c1f8af733c80.jpg"));
        lblNewLabel_6_1_4.setBounds(50, 10, 99, 81);
        panel_1_5_1_4.add(lblNewLabel_6_1_4);
        
        JLabel lblNewLabel_1_6_1_2_4 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_4.setBounds(10, 143, 64, 21);
        panel_1_5_1_4.add(lblNewLabel_1_6_1_2_4);
        
        JLabel lblNewLabel_1_6_1_1_1_4 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_4.setBounds(10, 166, 41, 21);
        panel_1_5_1_4.add(lblNewLabel_1_6_1_1_1_4);
        
        SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner10 = new JSpinner(spinnerModel10);
        spinner10.setBounds(64, 144, 30, 20);
        panel_1_5_1_4.add(spinner10);
        
        final JCheckBox checkBox10 = new JCheckBox("");
        checkBox10.setBounds(57, 170, 30, 21);
        panel_1_5_1_4.add(checkBox10);
        
        checkBox10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox10.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner10.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_1_1 = new JPanel();
        panel_1_5_1_1_1.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_1_1.setLayout(null);
        panel_1_5_1_1_1.setForeground(new Color(190, 137, 12));
        panel_1_5_1_1_1.setBackground(Color.WHITE);
        panel_1_5_1_1_1.setBounds(614, 221, 187, 201);
        drinksPanel.add(panel_1_5_1_1_1);
        
        JLabel lblNewLabel_1_6_2_1_1 = new JLabel("Sprite (mismo)");
        lblNewLabel_1_6_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_1_1.setBounds(47, 90, 110, 21);
        panel_1_5_1_1_1.add(lblNewLabel_1_6_2_1_1);
        
        JLabel lblNewLabel_1_1_6_1_1_1 = new JLabel("Price:   ₱ 20");
        lblNewLabel_1_1_6_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_1_1.setBounds(10, 121, 126, 21);
        panel_1_5_1_1_1.add(lblNewLabel_1_1_6_1_1_1);
        
        JLabel lblNewLabel_6_1_1_1 = new JLabel("");
        lblNewLabel_6_1_1_1.setIcon(new ImageIcon("D:\\Downloads\\images (2).jpg"));
        lblNewLabel_6_1_1_1.setBounds(47, 10, 100, 81);
        panel_1_5_1_1_1.add(lblNewLabel_6_1_1_1);
        
        JLabel lblNewLabel_1_6_1_2_1_1 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_1_1.setBounds(10, 143, 64, 21);
        panel_1_5_1_1_1.add(lblNewLabel_1_6_1_2_1_1);
        
        JLabel lblNewLabel_1_6_1_1_1_1_1 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_1_1.setBounds(10, 166, 41, 21);
        panel_1_5_1_1_1.add(lblNewLabel_1_6_1_1_1_1_1);
        
        SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner12 = new JSpinner(spinnerModel12);
        spinner12.setBounds(64, 144, 30, 20);
        panel_1_5_1_1_1.add(spinner12);
        
        final JCheckBox checkBox12 = new JCheckBox("");
        checkBox12.setBounds(57, 170, 30, 21);
        panel_1_5_1_1_1.add(checkBox12);
        
        checkBox12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox12.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner12.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_1_2 = new JPanel();
        panel_1_5_1_1_2.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_1_2.setLayout(null);
        panel_1_5_1_1_2.setForeground(new Color(190, 137, 12));
        panel_1_5_1_1_2.setBackground(Color.WHITE);
        panel_1_5_1_1_2.setBounds(811, 221, 187, 201);
        drinksPanel.add(panel_1_5_1_1_2);
        
        JLabel lblNewLabel_1_6_2_1_2 = new JLabel("Royal (mismo)");
        lblNewLabel_1_6_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_1_2.setBounds(47, 90, 110, 21);
        panel_1_5_1_1_2.add(lblNewLabel_1_6_2_1_2);
        
        JLabel lblNewLabel_1_1_6_1_1_2 = new JLabel("Price:  ₱ 20");
        lblNewLabel_1_1_6_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_1_2.setBounds(10, 121, 126, 21);
        panel_1_5_1_1_2.add(lblNewLabel_1_1_6_1_1_2);
        
        JLabel lblNewLabel_6_1_1_2 = new JLabel("");
        lblNewLabel_6_1_1_2.setIcon(new ImageIcon("D:\\Downloads\\4801981118519.png"));
        lblNewLabel_6_1_1_2.setBounds(81, 10, 76, 81);
        panel_1_5_1_1_2.add(lblNewLabel_6_1_1_2);
        
        JLabel lblNewLabel_1_6_1_2_1_2 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_1_2.setBounds(10, 143, 64, 21);
        panel_1_5_1_1_2.add(lblNewLabel_1_6_1_2_1_2);
        
        JLabel lblNewLabel_1_6_1_1_1_1_2 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_1_2.setBounds(10, 166, 41, 21);
        panel_1_5_1_1_2.add(lblNewLabel_1_6_1_1_1_1_2);
        
        SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner13 = new JSpinner(spinnerModel13);
        spinner13.setBounds(64, 144, 30, 20);
        panel_1_5_1_1_2.add(spinner13);
        
        final JCheckBox checkBox13 = new JCheckBox("");
        checkBox13.setBounds(57, 170, 30, 21);
        panel_1_5_1_1_2.add(checkBox13);
        
        checkBox13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox13.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner13.setModel(model); 
                }
            }
        });
        
        
        JPanel panel_1_5_1_2_1 = new JPanel();
        panel_1_5_1_2_1.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_2_1.setLayout(null);
        panel_1_5_1_2_1.setForeground(new Color(190, 137, 12));
        panel_1_5_1_2_1.setBackground(Color.WHITE);
        panel_1_5_1_2_1.setBounds(811, 426, 187, 201);
        drinksPanel.add(panel_1_5_1_2_1);
        
        JLabel lblNewLabel_1_6_2_2_1 = new JLabel("Royal (1 liter)");
        lblNewLabel_1_6_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_2_1.setBounds(40, 90, 107, 21);
        panel_1_5_1_2_1.add(lblNewLabel_1_6_2_2_1);
        
        JLabel lblNewLabel_1_1_6_1_2_1 = new JLabel("Price:   ₱ 45");
        lblNewLabel_1_1_6_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_2_1.setBounds(10, 121, 126, 21);
        panel_1_5_1_2_1.add(lblNewLabel_1_1_6_1_2_1);
        
        JLabel lblNewLabel_6_1_2_1 = new JLabel("");
        lblNewLabel_6_1_2_1.setIcon(new ImageIcon("D:\\Downloads\\images (1) (1).jpg"));
        lblNewLabel_6_1_2_1.setBounds(50, 10, 107, 81);
        panel_1_5_1_2_1.add(lblNewLabel_6_1_2_1);
        
        JLabel lblNewLabel_1_6_1_2_2_1 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_2_1.setBounds(10, 143, 64, 21);
        panel_1_5_1_2_1.add(lblNewLabel_1_6_1_2_2_1);
        
        JLabel lblNewLabel_1_6_1_1_1_2_1 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_2_1.setBounds(10, 166, 41, 21);
        panel_1_5_1_2_1.add(lblNewLabel_1_6_1_1_1_2_1);
        
        SpinnerNumberModel spinnerModel16 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner16 = new JSpinner(spinnerModel16);
        spinner16.setBounds(64, 144, 30, 20);
        panel_1_5_1_2_1.add(spinner16);
        
        final JCheckBox checkBox16 = new JCheckBox("");
        checkBox16.setBounds(57, 170, 30, 21);
        panel_1_5_1_2_1.add(checkBox16);
        
        checkBox16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox16.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner16.setModel(model); 
                }
            }
        });
        
        JPanel panel_1_5_1_2_2 = new JPanel();
        panel_1_5_1_2_2.setBorder(new LineBorder(new Color(0, 0, 64), 3));
        panel_1_5_1_2_2.setLayout(null);
        panel_1_5_1_2_2.setForeground(new Color(190, 137, 12));
        panel_1_5_1_2_2.setBackground(Color.WHITE);
        panel_1_5_1_2_2.setBounds(417, 426, 187, 201);
        drinksPanel.add(panel_1_5_1_2_2);
        
        JLabel lblNewLabel_1_6_2_2_2 = new JLabel("Coke (1 liter)");
        lblNewLabel_1_6_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_6_2_2_2.setBounds(40, 90, 107, 21);
        panel_1_5_1_2_2.add(lblNewLabel_1_6_2_2_2);
        
        JLabel lblNewLabel_1_1_6_1_2_2 = new JLabel("Price:  ₱ 45");
        lblNewLabel_1_1_6_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1_6_1_2_2.setBounds(10, 121, 126, 21);
        panel_1_5_1_2_2.add(lblNewLabel_1_1_6_1_2_2);
        
        JLabel lblNewLabel_6_1_2_2 = new JLabel("");
        lblNewLabel_6_1_2_2.setIcon(new ImageIcon("D:\\Downloads\\4801981116072 (1).jpg"));
        lblNewLabel_6_1_2_2.setBounds(47, 10, 100, 81);
        panel_1_5_1_2_2.add(lblNewLabel_6_1_2_2);
        
        JLabel lblNewLabel_1_6_1_2_2_2 = new JLabel("Quantity:");
        lblNewLabel_1_6_1_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_2_2_2.setBounds(10, 143, 64, 21);
        panel_1_5_1_2_2.add(lblNewLabel_1_6_1_2_2_2);
        
        JLabel lblNewLabel_1_6_1_1_1_2_2 = new JLabel("Select");
        lblNewLabel_1_6_1_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_6_1_1_1_2_2.setBounds(10, 166, 41, 21);
        panel_1_5_1_2_2.add(lblNewLabel_1_6_1_1_1_2_2);
        
        SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(1,1, Integer.MAX_VALUE, 1);
        final JSpinner spinner14 = new JSpinner(spinnerModel14);
        spinner14.setBounds(64, 144, 30, 20);
        panel_1_5_1_2_2.add(spinner14);
        
        final JCheckBox checkBox14 = new JCheckBox("");
        checkBox14.setBounds(57, 170, 30, 21);
        panel_1_5_1_2_2.add(checkBox14);
        
        checkBox14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkBox14.isSelected()) {
                    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1); 
                    spinner14.setModel(model); 
                }
            }
        });
        
        //Snacks Panel 
        JPanel snacksPanel = new JPanel();
        tabbedPane.addTab("Snacks", null, snacksPanel, null);
        snacksPanel.setBackground(new Color(247, 151, 9));
        snacksPanel.setLayout(null);
        
        JPanel panel_1_6 = new JPanel();
        panel_1_6.setLayout(null);
        panel_1_6.setForeground(new Color(190, 137, 12));
        panel_1_6.setBackground(Color.WHITE);
        panel_1_6.setBounds(242, 24, 243, 276);
        snacksPanel.add(panel_1_6);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setBounds(10, 10, 218, 142);
        panel_1_6.add(lblNewLabel_7);
        
        JLabel lblNewLabel_1_7 = new JLabel("Siomai (3pcs)");
        lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_7.setBounds(64, 162, 126, 21);
        panel_1_6.add(lblNewLabel_1_7);
        
        JLabel lblNewLabel_1_1_7 = new JLabel("Price:   20");
        lblNewLabel_1_1_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_7.setBounds(10, 188, 126, 21);
        panel_1_6.add(lblNewLabel_1_1_7);
        
        JLabel lblNewLabel_1_1_1_6 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_6.setBounds(10, 219, 66, 21);
        panel_1_6.add(lblNewLabel_1_1_1_6);
        
        JSpinner spinner_6 = new JSpinner();
        spinner_6.setBounds(77, 221, 41, 20);
        panel_1_6.add(spinner_6);
        
        JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_5.setBounds(10, 249, 55, 21);
        panel_1_6.add(lblNewLabel_1_1_1_1_5);
        
        JCheckBox checkBox1_1 = new JCheckBox("");
        checkBox1_1.setBounds(72, 249, 33, 21);
        panel_1_6.add(checkBox1_1);
        
        JPanel panel_1_7 = new JPanel();
        panel_1_7.setLayout(null);
        panel_1_7.setForeground(new Color(190, 137, 12));
        panel_1_7.setBackground(Color.WHITE);
        panel_1_7.setBounds(515, 24, 243, 276);
        snacksPanel.add(panel_1_7);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setBounds(10, 10, 218, 142);
        panel_1_7.add(lblNewLabel_8);
        
        JLabel lblNewLabel_1_8 = new JLabel("Siomai (3pcs)");
        lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_8.setBounds(64, 162, 126, 21);
        panel_1_7.add(lblNewLabel_1_8);
        
        JLabel lblNewLabel_1_1_8 = new JLabel("Price:   20");
        lblNewLabel_1_1_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_8.setBounds(10, 188, 126, 21);
        panel_1_7.add(lblNewLabel_1_1_8);
        
        JLabel lblNewLabel_1_1_1_7 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_7.setBounds(10, 219, 66, 21);
        panel_1_7.add(lblNewLabel_1_1_1_7);
        
        JSpinner spinner_7 = new JSpinner();
        spinner_7.setBounds(77, 221, 41, 20);
        panel_1_7.add(spinner_7);
        
        JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_6.setBounds(10, 249, 55, 21);
        panel_1_7.add(lblNewLabel_1_1_1_1_6);
        
        JCheckBox checkBox1_2 = new JCheckBox("");
        checkBox1_2.setBounds(72, 249, 33, 21);
        panel_1_7.add(checkBox1_2);
        
        JPanel panel_1_8 = new JPanel();
        panel_1_8.setLayout(null);
        panel_1_8.setForeground(new Color(190, 137, 12));
        panel_1_8.setBackground(Color.WHITE);
        panel_1_8.setBounds(242, 326, 243, 276);
        snacksPanel.add(panel_1_8);
        
        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.setBounds(10, 10, 218, 142);
        panel_1_8.add(lblNewLabel_12);
        
        JLabel lblNewLabel_1_9 = new JLabel("Siomai (3pcs)");
        lblNewLabel_1_9.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_9.setBounds(64, 162, 126, 21);
        panel_1_8.add(lblNewLabel_1_9);
        
        JLabel lblNewLabel_1_1_9 = new JLabel("Price:   20");
        lblNewLabel_1_1_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_9.setBounds(10, 188, 126, 21);
        panel_1_8.add(lblNewLabel_1_1_9);
        
        JLabel lblNewLabel_1_1_1_8 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_8.setBounds(10, 219, 66, 21);
        panel_1_8.add(lblNewLabel_1_1_1_8);
        
        JSpinner spinner_8 = new JSpinner();
        spinner_8.setBounds(77, 221, 41, 20);
        panel_1_8.add(spinner_8);
        
        JLabel lblNewLabel_1_1_1_1_7 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_7.setBounds(10, 249, 55, 21);
        panel_1_8.add(lblNewLabel_1_1_1_1_7);
        
        JCheckBox checkBox1_3 = new JCheckBox("");
        checkBox1_3.setBounds(72, 249, 33, 21);
        panel_1_8.add(checkBox1_3);
        
        JPanel panel_1_9 = new JPanel();
        panel_1_9.setLayout(null);
        panel_1_9.setForeground(new Color(190, 137, 12));
        panel_1_9.setBackground(Color.WHITE);
        panel_1_9.setBounds(515, 326, 243, 276);
        snacksPanel.add(panel_1_9);
        
        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setBounds(10, 10, 218, 142);
        panel_1_9.add(lblNewLabel_13);
        
        JLabel lblNewLabel_1_10 = new JLabel("Siomai (3pcs)");
        lblNewLabel_1_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_10.setBounds(64, 162, 126, 21);
        panel_1_9.add(lblNewLabel_1_10);
        
        JLabel lblNewLabel_1_1_10 = new JLabel("Price:   20");
        lblNewLabel_1_1_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_10.setBounds(10, 188, 126, 21);
        panel_1_9.add(lblNewLabel_1_1_10);
        
        JLabel lblNewLabel_1_1_1_9 = new JLabel("Quantity:");
        lblNewLabel_1_1_1_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_9.setBounds(10, 219, 66, 21);
        panel_1_9.add(lblNewLabel_1_1_1_9);
        
        JSpinner spinner_9 = new JSpinner();
        spinner_9.setBounds(77, 221, 41, 20);
        panel_1_9.add(spinner_9);
        
        JLabel lblNewLabel_1_1_1_1_8 = new JLabel("Select:");
        lblNewLabel_1_1_1_1_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1_1_1_8.setBounds(10, 249, 55, 21);
        panel_1_9.add(lblNewLabel_1_1_1_1_8);
        
        JCheckBox checkBox1_4 = new JCheckBox("");
        checkBox1_4.setBounds(72, 249, 33, 21);
        panel_1_9.add(checkBox1_4);
        
        JButton btnBack = new JButton("LOG OUT");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		new SignInForm1().setVisible(true);
        		SecondFrame.dispose();
        			/*Main main = new Main();
        			main.MainFrame.setVisible(true);
        			SecondFrame.dispose();*/
        	}
        });
        
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnBack.setForeground(new Color(0, 0, 64));
        btnBack.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnBack.setBorder(new LineBorder(Color.WHITE, 4));
        btnBack.setBackground(new Color(247, 151, 9));
        btnBack.setBounds(22, 776, 98, 43);
        panel.add(btnBack);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(247, 151, 9));
        panel_2.setBounds(1077, 109, 420, 645);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 38, 400, 576);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(0, 0, 400, 587);
        panel_3.add(scrollPane);
        
        model = new DefaultTableModel();
        model.addColumn("Product");
        model.addColumn("Quantity");
        model.addColumn("Price");
        
        table_1 = new JTable(model);

        
        scrollPane.setViewportView(table_1);
      
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(0, 0, 64));
        panel_4.setBounds(10, 10, 400, 29);
        panel_2.add(panel_4);
        panel_4.setLayout(null);
        
        final JLabel totalPriceLabel_1 = new JLabel("TOTAL PRICE: ₱ 0.0");
        totalPriceLabel_1.setForeground(new Color(255, 255, 255));
        totalPriceLabel_1.setBackground(new Color(255, 255, 255));
        totalPriceLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        totalPriceLabel_1.setBounds(115, 10, 232, 13);
        panel_4.add(totalPriceLabel_1);
        
        
        JLabel lblNewLabel_9 = new JLabel("MENU ITEMS");
        lblNewLabel_9.setForeground(new Color(255, 255, 255));
        lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 30));
        lblNewLabel_9.setBounds(441, 65, 229, 33);
        panel.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("TRAIL BLAZE");
        lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_10.setForeground(new Color(247, 151, 9));
        lblNewLabel_10.setBounds(22, 10, 138, 33);
        panel.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("ORDER");
        lblNewLabel_11.setForeground(new Color(255, 255, 255));
        lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_11.setBounds(50, 37, 83, 25);
        panel.add(lblNewLabel_11);
        
        SecondFrame.setVisible(true);
        
        timeLabel = new JLabel("");
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(1342, 37, 163, 30); // Adjust the position as needed
        panel.add(timeLabel);
       
        dateLabel = new JLabel("");
        dateLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(1342, 10, 147, 30); // Adjust the position as needed
        panel.add(dateLabel);
        
        JButton btnPlaceOrder = new JButton("PLACE ORDER");
        btnPlaceOrder.setForeground(new Color(0, 0, 64));
        btnPlaceOrder.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnPlaceOrder.setBorder(new LineBorder(Color.WHITE, 4));
        btnPlaceOrder.setBackground(new Color(247, 151, 9));
        btnPlaceOrder.setBounds(1322, 776, 147, 43);
        panel.add(btnPlaceOrder);
        
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isJTableEmpty(table_1)) {
                    JOptionPane.showMessageDialog(null, "Please order something!");
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "Confirm order?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        try {
                            Connection connection = DatabaseConnection.getConnection();
                            Statement statement = connection.createStatement();

                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            int rowCount = model.getRowCount();

                            for (int i = 0; i < rowCount; i++) {
                                // Assuming your table columns are in order of 'column1', 'column2', etc.
                                Object column1Value = model.getValueAt(i, 0);
                                Object column2Value = model.getValueAt(i, 1);
                                Object column3Value = model.getValueAt(i, 2);// Replace with actual column index

                                // Construct your SQL INSERT statement
                                String query = "INSERT INTO order3 (product, quantity, price) VALUES ('" + column1Value + "', '" + column2Value + "' + column3Value + )";
                                
                                // Execute the INSERT statement
                                statement.executeUpdate(query);
                            }

                            statement.close();
                            connection.close();

                            JOptionPane.showMessageDialog(null, "Order placed successfully!");
                            SecondFrame.dispose();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Failed to place order. Please try again.");
                        }
                    } else {
                        // User canceled order confirmation
                    }
                }
            }
        });

        
        JButton btnClear = new JButton("CLEAR");
        btnClear.setForeground(new Color(0, 0, 64));
        btnClear.setFont(new Font("Arial Black", Font.BOLD, 12));
        btnClear.setBorder(new LineBorder(Color.WHITE, 4));
        btnClear.setBackground(new Color(247, 151, 9));
        btnClear.setBounds(1121, 776, 98, 43);
        panel.add(btnClear);
        
        JLabel lblNewLabel_9_1 = new JLabel("Order Summary");
        lblNewLabel_9_1.setForeground(Color.WHITE);
        lblNewLabel_9_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblNewLabel_9_1.setBounds(1209, 69, 177, 33);
        panel.add(lblNewLabel_9_1);
        
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear data from the table
                DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                model.setRowCount(0); // Remove all rows from the table
                
                // Uncheck all checkboxes
                JCheckBox[] checkboxes = {checkBox1, checkBox2, checkBox3, checkBox4, checkBox5}; // Add all your checkboxes here
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].setSelected(false); // Uncheck each checkbox
                }
                
                // Reset all spinners
                JSpinner[] spinners = {spinner1, spinner2, spinner3, spinner4, spinner5}; // Add all your spinners here
                for (int i = 0; i < spinners.length; i++) {
                    SpinnerNumberModel model1 = (SpinnerNumberModel) spinners[i].getModel();
                    spinners[i].setValue(model1.getMinimum()); // Reset each spinner to its minimum value
                }
                
                // Reset total price label
                totalPriceLabel_1.setText("TOTAL PRICE: ₱ 0.0");
            }
        });
        
        // Food checkbox listener
        spinner1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                if (rowCount > 0 && checkBox1.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Siomai (3pcs)")) {
                            int newQuantity = Integer.parseInt(spinner1.getValue().toString());
                            int price = 20;

                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(Integer.valueOf(newQuantity), i, 1); // Update quantity as a String
                            model.setValueAt(Integer.valueOf(price * newQuantity), i, 2); // Update total price as a String
                            break;
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1); // Update total price label
                }
            }
        });
        
        checkBox1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox1.isSelected()) {
        		  int quantity = Integer.parseInt(spinner1.getValue().toString());
        		  int price = 20;
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Siomai (3pcs)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        			
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Siomai (3pcs)")) {
        					model.removeRow(i);
        					break;
        				}
        				
        			}
        			
        		}
        	
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox2.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Siopao")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner2.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox2.isSelected()) {
        			int quantity = Integer.parseInt(spinner2.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Siopao",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Siopao")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox3.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Burger")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner3.getValue().toString());
                            int price = 35; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox3.isSelected()) {
        			int quantity = Integer.parseInt(spinner3.getValue().toString());
        			int price = 35;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Burger",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Burger")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner4.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox4.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Hotdog")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner4.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox4.isSelected()) {
        			int quantity = Integer.parseInt(spinner4.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Hotdog",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Hotdog")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner5.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox5.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Cup Noodles")){
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner5.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox5.isSelected()) {
        			int quantity = Integer.parseInt(spinner5.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Cup Noodles",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Cup Noodles")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        // Drinks Panel
        spinner6.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox6.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Bottled Water")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner6.getValue().toString());
                            int price = 15; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox6.isSelected()) {
        			int quantity = Integer.parseInt(spinner6.getValue().toString());
        			int price = 15;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Bottled Water",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Bottled Water")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner7.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox7.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Zesto")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner7.getValue().toString());
                            int price = 15; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox7.isSelected()) {
        			int quantity = Integer.parseInt(spinner7.getValue().toString());
        			int price = 15;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Zesto",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Zesto")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner8.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox8.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Coke (sakto)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner8.getValue().toString());
                            int price = 15; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox8.isSelected()) {
        			int quantity = Integer.parseInt(spinner8.getValue().toString());
        			int price = 15;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Coke (sakto)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Coke(sakto)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner9.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox9.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Sprite (sakto)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner9.getValue().toString());
                            int price = 15; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox9.isSelected()) {
        			int quantity = Integer.parseInt(spinner9.getValue().toString());
        			int price = 15;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Sprite (sakto)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Sprite (sakto)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner10.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox10.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Royal (sakto)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner10.getValue().toString());
                            int price = 15; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox10.isSelected()) {
        			int quantity = Integer.parseInt(spinner10.getValue().toString());
        			int price = 15;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Royal (sakto)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Royal (sakto)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner11.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox11.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Coke (mismo)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner11.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
                
            }
        });
        
        checkBox11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox11.isSelected()) {
        			int quantity = Integer.parseInt(spinner11.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Coke (mismo)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Coke(mismo)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner12.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox12.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Sprite (mismo)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner12.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox12.isSelected()) {
        			int quantity = Integer.parseInt(spinner12.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Sprite (mismo)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Sprite (mismo)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner13.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox13.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Royal (mismo)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner13.getValue().toString());
                            int price = 20; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox13.isSelected()) {
        			int quantity = Integer.parseInt(spinner13.getValue().toString());
        			int price = 20;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Royal (mismo)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Royal (mismo)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner14.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox14.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Coke (litro)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner14.getValue().toString());
                            int price = 45; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox14.isSelected()) {
        			int quantity = Integer.parseInt(spinner14.getValue().toString());
        			int price = 45;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Coke (litro)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Coke (ltiro)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner15.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox15.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Sprite (litro)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner15.getValue().toString());
                            int price = 45; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox15.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox15.isSelected()) {
        			int quantity = Integer.parseInt(spinner15.getValue().toString());
        			int price = 45;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Sprite (litro)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Sprite (ltiro)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        
        spinner16.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int rowCount = table_1.getRowCount();

                
                if (rowCount > 0 && checkBox16.isSelected()) {
                    for (int i = 0; i < rowCount; i++) {
                        if (table_1.getValueAt(i, 0).equals("Royal (litro)")) {
                            // Get the new quantity from the spinner
                            int newQuantity = Integer.parseInt(spinner16.getValue().toString());
                            int price = 45; 
                            
                            // Update the table with the new quantity and total price
                            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                            model.setValueAt(String.valueOf(newQuantity), i, 1); 
                            model.setValueAt(String.valueOf(price * newQuantity), i, 2); 
                            break; 
                        }
                    }
                    calculateTotalPrice(totalPriceLabel_1, table_1);
                }
            }
        });
        
        checkBox16.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkBox16.isSelected()) {
        			int quantity = Integer.parseInt(spinner16.getValue().toString());
        			int price = 45;
        			
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			model.addRow(new Object[] {"Royal (litro)",Integer.valueOf(quantity),Integer.valueOf(price * quantity)});
        		} else {
        			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        			for	(int i = 0; i < model.getRowCount(); i++) {
        				if(model.getValueAt(i, 0).equals("Royal (ltiro)")) {
        					model.removeRow(i);
        					break;
        				}
        			}
        		}
        		calculateTotalPrice(totalPriceLabel_1, table_1);
        	}
        });
        

	}
	
}


