package ordersystem;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PlaceOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DatabaseConnection dbConnection;
	private JPanel panel_1;
	private String queueCode;
	private JLabel queLabel;
	private static int queueNumber = 1;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrder frame = new PlaceOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	public PlaceOrder() {
		setUndecorated(true);
		setBackground(new Color(0, 0, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 1677, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		panel.setBounds(702, 65, 581, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 27, 532, 570);
		panel.add(scrollPane);
		
		dbConnection = new DatabaseConnection();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JTableHeader orderT = table.getTableHeader();
        orderT.setBackground(new Color(0,41,81));
        orderT.setForeground(new Color(255,255,255));
		
		try {
            dbConnection = new DatabaseConnection(); // Assuming this class sets up the DB connection.
            Connection conn = DatabaseConnection.getConnection(); // Get the connection object.
            double totalPrice = 0.0;
            // Query to retrieve data from the "order3" table.
            String query = "SELECT product, quantity, price FROM order3";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            // Create a DefaultTableModel to hold the data.
            DefaultTableModel model = new DefaultTableModel();
            
            // Add columns to the model.
            model.addColumn("Product");
            model.addColumn("Quantity");
            model.addColumn("Price");
            
            // Add rows to the model based on the retrieved data.
            while (rs.next()) {
                Object[] row = {
                    rs.getString("product"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                };
                model.addRow(row);
               totalPrice += rs.getDouble("price");
            }
            
            // Set the model to your JTable.
            table.setModel(model);
            
            JLabel totalPriceLabel_1 = new JLabel("TOTAL PRICE: ₱ " + totalPrice);
            totalPriceLabel_1.setForeground(new Color(0, 0, 64));
            totalPriceLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
            totalPriceLabel_1.setBounds(315, 617, 243, 33);
            panel.add(totalPriceLabel_1);
            
            panel_1 = new JPanel();
            panel_1.setBorder(new LineBorder(new Color(255, 128, 0), 10, true));
            panel_1.setBackground(new Color(29, 41, 81));
            panel_1.setBounds(-407, 115, 2084, 556);
            contentPane.add(panel_1);
            panel_1.setLayout(null);
            
            JButton printbtn = new JButton("PRINT");
            printbtn.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		queueNumber++;
                    queLabel.setText("Queue Number: " + (queueNumber < 10 ? "0" : "") + queueNumber);
            		
            	}
            });
            printbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            printbtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    printbtn.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    printbtn.setForeground(new Color(0,0,64));
                }
            });
            printbtn.setForeground(new Color(0, 0, 64));
            printbtn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            printbtn.setBorder(null);
            printbtn.setBackground(new Color(255, 128, 0));
            printbtn.setBounds(715, 485, 190, 44);
            panel_1.add(printbtn);

            
            JLabel lblNewLabel = new JLabel("Your order ");
            lblNewLabel.setForeground(new Color(255, 255, 255));
            lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 60));
            lblNewLabel.setBounds(672, 20, 345, 129);
            panel_1.add(lblNewLabel);
            
            JLabel lblHasBeen = new JLabel("has been");
            lblHasBeen.setForeground(new Color(255, 255, 255));
            lblHasBeen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 60));
            lblHasBeen.setBounds(678, 81, 281, 129);
            panel_1.add(lblHasBeen);
            
            JLabel lblPlaced = new JLabel("placed.");
            lblPlaced.setForeground(new Color(255, 255, 255));
            lblPlaced.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 60));
            lblPlaced.setBounds(678, 140, 281, 129);
            panel_1.add(lblPlaced);
            
            JLabel lblNewLabel_1 = new JLabel("Thank you for using");
            lblNewLabel_1.setForeground(new Color(255, 128, 0));
            lblNewLabel_1.setBackground(new Color(192, 192, 192));
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lblNewLabel_1.setBounds(672, 269, 360, 66);
            panel_1.add(lblNewLabel_1);
            
            JLabel lblNewLabel_1_1 = new JLabel("Trail Blaze Ordering System");
            lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
            lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
            lblNewLabel_1_1.setBounds(672, 320, 374, 52);
            panel_1.add(lblNewLabel_1_1);
            
            
            
            JLabel queLabel = new JLabel("Queue Number:" + (queueNumber < 10 ? "0" : "") + queueNumber);
            queLabel.setForeground(new Color(255, 255, 255));
            queLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
            queLabel.setBackground(Color.LIGHT_GRAY);
            queLabel.setBounds(678, 396, 360, 66);
            panel_1.add(queLabel);
            
            JLabel lblNewLabel_2 = new JLabel("");
            lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d (1).jpg"));
            lblNewLabel_2.setBounds(398, 10, 1708, 536);
            panel_1.add(lblNewLabel_2);
            
            
            
            JButton btnSignOut = new JButton("Sign Out");
            btnSignOut.setBorder(null);
            btnSignOut.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		logout();
            	}
            });
            btnSignOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnSignOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnSignOut.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnSignOut.setForeground(new Color(0,0,64));
                }
            });
            btnSignOut.setForeground(new Color(0, 0, 64));
            btnSignOut.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            btnSignOut.setBackground(new Color(255, 128, 0));
            btnSignOut.setBounds(40, 752, 137, 39);
            contentPane.add(btnSignOut);
            
            JButton btnOrderAgain = new JButton("Order Again");
            btnOrderAgain.setBorder(null);
            btnOrderAgain.setForeground(new Color(0, 0, 64));
            btnOrderAgain.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
            btnOrderAgain.setBackground(new Color(255, 128, 0));
            btnOrderAgain.setBounds(1356, 752, 137, 39);
            contentPane.add(btnOrderAgain);
            btnOrderAgain.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            JLabel lblNewLabel_3 = new JLabel("");
            lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\USTP Logo against Dark Background (2).png"));
            lblNewLabel_3.setBounds(10, 10, 111, 94);
            contentPane.add(lblNewLabel_3);
           
            btnOrderAgain.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnOrderAgain.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnOrderAgain.setForeground(new Color(0,0,64));
                }
            });
            
            btnOrderAgain.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to place the order again?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        try {
                            // Get the database connection
                            DatabaseConnection dbConnection = new DatabaseConnection();
                            Connection conn = DatabaseConnection.getConnection();

                            // Execute a DELETE query to clear the data in the order3 table
                            String deleteQuery = "DELETE FROM order3";
                            PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
                            deleteStmt.executeUpdate();

                            // Close the prepared statement and connection
                            deleteStmt.close();
                            conn.close();

                            // Clear the table in the OrderForm frame
                            OrderForm orderForm = new OrderForm();
                            orderForm.clearTableModel();
                            setVisible(false);
                            orderForm.setVisible(true);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            // Close resources.
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
        	
    }
	
	
	private void logout() {
        JOptionPane.showMessageDialog(this, "Logging out...");
        resetOrderTableInDatabase(); // Reset 'order3' table
        setVisible(false); // Hide the OrderForm upon logout
        new SignInForm1().setVisible(true); // Show SignInForm after logout
    }
	
	private void resetOrderTableInDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            java.sql.Statement statement = connection.createStatement(); // Use java.sql.Statement
            String resetQuery = "TRUNCATE TABLE order3";
            statement.executeUpdate(resetQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
	
	
}

