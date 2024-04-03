package ordersystem;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class AdminForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm frame = new AdminForm();
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
	public AdminForm() {
		setBackground(new Color(0, 0, 64));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1550,820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel_2.setBackground(new Color(0, 0, 64));
		panel_2.setBounds(461, 108, 649, 605);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 29, 579, 534);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(193, 233, 193, 46);
		textField.setBorder(new LineBorder(new Color(0, 0, 64), 1, true));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.setBounds(240, 422, 105, 40);
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN");
		lblNewLabel_2.setBounds(230, 74, 125, 32);
		lblNewLabel_2.setForeground(new Color(0, 0, 64));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(193, 194, 101, 29);
		lblUsername.setForeground(new Color(0, 0, 64));
		lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel_1.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(193, 301, 101, 29);
		lblPassword.setForeground(new Color(0, 0, 64));
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel_1.add(lblPassword);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(155, 240, 36, 39);
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\png-transparent-computer-icons-user-username-avatar-person-skill-thumbnail (2).png"));
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(155, 341, 36, 39);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\png-transparent-computer-icons-password-icon-svg-security-password-icon.png"));
		panel_1.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 334, 193, 46);
		panel_1.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(193, 386, 114, 21);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JCheckBox CheckBox = (JCheckBox) e.getSource();
        		passwordField.setEchoChar(CheckBox.isSelected() ? '\u0000' : '*');
        	} 
        });
		chckbxNewCheckBox .setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(new Color(255, 128, 0));
		btnBack.setBounds(32, 756, 105, 40);
		contentPane.add(btnBack);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBorder(new LineBorder(new Color(255, 128, 0), 10));
		panel.setBounds(0, 132, 1562, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 10, 1590, 520);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d (1).jpg"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignInForm1().setVisible(true);
			}
			
				
		});;
		btnBack.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e) {
            	 btnBack.setForeground(Color.WHITE);
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 btnBack.setForeground(new Color(0,0,64));
             }
         });
		
		 btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Check if username and password are "admin"
	                String username = textField.getText();
	                String password = passwordField.getText();

	                if ("admin".equals(username) && "admin".equals(password)) {
	                    // Valid account
	                    JOptionPane.showMessageDialog(null, "Login successful");
	                    setVisible(false);
	                    new Admin().setVisible(true);
	                } else {
	                    // Invalid account
	                    JOptionPane.showMessageDialog(null, "Invalid account");
	                }
	            }
	        });
		 btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 
		 lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setIcon(new ImageIcon("D:\\Downloads\\USTP Logo against Dark Background (2).png"));
		 lblNewLabel_4.setBounds(10, 24, 111, 94);
		 contentPane.add(lblNewLabel_4);
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
	    }
	}

