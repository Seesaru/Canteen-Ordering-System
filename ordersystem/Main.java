package ordersystem;

import java.awt.Dimension;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;



public class Main {

    JFrame MainFrame;
    private JTextField txtName;
    private JTextField txtID;
    private JTextField textField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private int loggedInUserId;

    
    
    
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.MainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
   

    public Main() {
        initialize();
    }
    
    
    private JComponent getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}


	private void initialize() {

    	MainFrame = new JFrame();
    	MainFrame.setAlwaysOnTop(true);
    	MainFrame.setForeground(new Color(0, 0, 87));
        MainFrame.setBackground(new Color(0, 0, 87));
        MainFrame.getContentPane().setForeground(new Color(42, 42, 42));
        MainFrame.getContentPane().setBackground(new Color(0, 0, 87));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(16, 0, 60));

        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = 1550; // Increased width
        int frameHeight = 883   ; // Increased height
        int x = (screenSize.width - frameWidth) / 2;
        int y = (screenSize.height - frameHeight) / 2;
        
        MainFrame.setBounds(x, y, 1608, 826); 
        MainFrame.setContentPane(contentPanel);
        MainFrame.setVisible(true);
	}

            private void initializeComponents() {
                Container container = getContentPane();
                getContentPane().setLayout(null);

                JPanel panel = new JPanel();
                panel.setBackground(Color.ORANGE);
                panel.setBounds(583, 11, 690, 606);
                getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setBounds(367, 13, 152, 123);
                panel.add(lblNewLabel);
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sarci\\Downloads\\conference_96px.png"));
                
                        JButton signInButton = new JButton("Log In");
                        signInButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
                        signInButton.setBounds(490, 437, 119, 52);
                        panel.add(signInButton);
                        
                                JButton signUpButton = new JButton("Sign Up");
                                signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
                                signUpButton.setBounds(126, 437, 132, 52);
                                panel.add(signUpButton);
                                usernameField = new JTextField();
                                usernameField.setBounds(176, 159, 482, 48);
                                panel.add(usernameField);
                                
                                        // Password Field
                                        passwordField = new JPasswordField();
                                        passwordField.setBounds(176, 273, 482, 48);
                                        panel.add(passwordField);
                                        
                                                // Show Password Checkbox
                                                showPasswordCheckBox = new JCheckBox("Show Password");
                                                showPasswordCheckBox.setBounds(183, 335, 150, 23);
                                                panel.add(showPasswordCheckBox);
                                                
                                                        JLabel label_1 = new JLabel("");
                                                        label_1.setBounds(114, 149, 38, 74);
                                                        panel.add(label_1);
                                                        label_1.setIcon(new ImageIcon("C:\\Users\\sarci\\Downloads\\male_user_26px.png"));
                                                        
                                                                JLabel label = new JLabel("");
                                                                label.setBounds(114, 234, 61, 108);
                                                                panel.add(label);
                                                                label.setIcon(new ImageIcon("C:\\Users\\sarci\\Downloads\\lock_26px.png"));
                                                showPasswordCheckBox.addItemListener(new ItemListener() {
                                                    @Override
                                                    public void itemStateChanged(ItemEvent e) {
                                                        if (e.getStateChange() == ItemEvent.SELECTED) {
                                                            // Show Password
                                                            passwordField.setEchoChar((char) 0);
                                                        } else {
                                                            // Hide Password
                                                            passwordField.setEchoChar('\u2022');
                                                        }
                                                    }
                                                });
                                signUpButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        openSignUpForm();
                                    }
                                });
                        signInButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                signIn();
                            }
                        });

                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sarci\\Downloads\\kani2 (1).png"));
                lblNewLabel_1.setBounds(63, 186, 393, 230);
                getContentPane().add(lblNewLabel_1);

                JButton btnNewButton = new JButton("");
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new SecondFrame().setVisible(true);
                    }
                });
                btnNewButton.setIcon(new ImageIcon("C:\\Users\\sarci\\Downloads\\back-button-png.svg.hi (2).png"));
                btnNewButton.setBackground(Color.BLUE);
                btnNewButton.setBounds(10, 560, 150, 59);
                getContentPane().add(btnNewButton);

                setVisible(true);
            }

            protected void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}



			private void signIn() {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                try (Connection connection = DatabaseConnection.getConnection()) {
                    String signInQuery = "SELECT user_id, first_name, last_name FROM users WHERE username = ? AND password = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(signInQuery)) {
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, password);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        	 if (resultSet.next()) {
                        	        loggedInUserId = resultSet.getInt("user_id");  // Store the user ID

                                String firstName = resultSet.getString("first_name");
                                String lastName = resultSet.getString("last_name");

                                JOptionPane.showMessageDialog(MainFrame, this, "Sign In Successful!", loggedInUserId);
                                Main.dispose();

                            } else {
                                JOptionPane.showMessageDialog(MainFrame, this, "Invalid username or password!", loggedInUserId);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            private static void dispose() {
				// TODO Auto-generated method stub
				
			}



			public int getLoggedInUserId() {
                return loggedInUserId;}


            private void openSignUpForm() {
                SignUpFormWithDB signUpForm = new SignUpFormWithDB();
                signUpForm.setVisible(true);

                // Wait for SignUpForm to close and retrieve the user ID
                int signedUpUserId = signUpForm.getUserId();

                if (signedUpUserId != 0) {
                    // Use the user ID as needed (e.g., display in a label or store for future reference)
                    System.out.println("User ID of the signed-up user: " + signedUpUserId);
                }

                // You may also perform other actions based on the signed-up user ID
            }


            
};
 
        