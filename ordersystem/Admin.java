package ordersystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ADMINTABLE;
	private JScrollPane scrollPane;
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ordersystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550,820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 41, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 128, 0), 10));
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(-18, -39, 368, 901);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1.setBounds(134, 59, 191, 115);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("SIGN OUT");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(109, 764, 140, 42);
		panel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	logout();
                     
            }
        });
		 btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 
		 JLabel lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setIcon(new ImageIcon("D:\\Downloads\\USTP Logo against Dark Background (2).png"));
		 lblNewLabel_4.setBounds(27, 55, 111, 94);
		 panel.add(lblNewLabel_4);
         btnNewButton_1.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e) {
                 btnNewButton_1.setForeground(Color.WHITE);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 btnNewButton_1.setForeground(new Color(0,0,64));
             }
         });
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		panel_1.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		panel_1.setBounds(514, 161, 885, 537);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 42, 815, 450);
		panel_1.add(scrollPane);
		
		ADMINTABLE = new JTable();
		scrollPane.setViewportView(ADMINTABLE);
		JTableHeader adminT = ADMINTABLE.getTableHeader();
        adminT.setBackground(new Color(0,41,81));
        adminT.setForeground(new Color(255,255,255));
		
        JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(884, 731, 140, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LIST OF PRODUCT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(821, 75, 287, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d (1).jpg"));
		lblNewLabel_2.setBounds(348, 0, 1221, 885);
		contentPane.add(lblNewLabel_2);
		populateTable();
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateData();
                
            }
        });
		 btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         btnNewButton.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e) {
                 btnNewButton.setForeground(Color.WHITE);
             }

             @Override
             public void mouseExited(MouseEvent e) {
                 btnNewButton.setForeground(new Color(0,0,64));
             }
         });

        populateTable();
	}
	 private void populateTable() {
	        try {
	            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	            Statement statement = connection.createStatement();
	            String query = "SELECT * FROM admin";
	            ResultSet resultSet = statement.executeQuery(query);

	            // Create DefaultTableModel
	            DefaultTableModel model = new DefaultTableModel();

	            // Retrieve column names
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultSet.getMetaData().getColumnName(i));
	            }

	            // Retrieve data
	            while (resultSet.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(row);
	            }

	            // Set DefaultTableModel as the model for the JTable
	            ADMINTABLE.setModel(model);

	            // Close resources
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void logout() {
	        JOptionPane.showMessageDialog(this, "Logging out...");
	        setVisible(false); // Hide the OrderForm upon logout
	        new SignInForm1().setVisible(true); // Show SignInForm after logout
	    }
	 
	 private void updateData() {
		    // Get the selected row index
		    int selectedRowIndex = ADMINTABLE.getSelectedRow();

		    if (selectedRowIndex != -1) { // Check if a row is selected
		        // Get the data from the selected row
		        Object productID = ADMINTABLE.getValueAt(selectedRowIndex, 0);
		        Object stock = ADMINTABLE.getValueAt(selectedRowIndex, 2); // Assuming stock is the third column (index 2)
		        Object productPrice = ADMINTABLE.getValueAt(selectedRowIndex, 3); // Assuming product_price is the fourth column (index 3)
		        JOptionPane.showMessageDialog(this, "Data Updated!");
		        // Open a new window or dialog for editing the data (you need to implement this)

		        // After editing, update the data in the database

		        try {
		            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		            String updateQuery = "UPDATE admin SET stock=?, product_price=? WHERE product_id=?";
		            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

		            // Set the new values for stock and product_price columns
		            preparedStatement.setObject(1, stock);
		            preparedStatement.setObject(2, productPrice);
		            
		            // Set the condition based on product_id
		            preparedStatement.setObject(3, productID);

		            // Execute the update query
		            preparedStatement.executeUpdate();

		            // Close resources
		            preparedStatement.close();
		            connection.close();

		            // Refresh the table
		            populateTable();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Please select a row to update.");
		    }
		}
}



