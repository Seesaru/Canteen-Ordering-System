package ordersystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;

public class SignInForm1 extends JFrame {

    private JTextField idField;
    private JPasswordField passwordField;
    

    public SignInForm1() {
    	setUndecorated(true);
    	getContentPane().setBackground(new Color(0, 0, 64));
        setTitle("Sign In");
        setSize(1654, 820);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        initializeComponents();
    }
    
    

    private void initializeComponents() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 64));
        panel.setLayout(null);
        container.add(panel, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_1.setLayout(null);
        panel_1.setForeground(new Color(0, 0, 64));
        panel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.setBorder(new LineBorder(new Color(255, 128, 0), 10));
        panel_1.setBackground(new Color(29, 41, 81));
        panel_1.setBounds(-45, 98, 1721, 644);
        panel.add(panel_1);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBackground(new Color(0, 0, 64));
                panel_2.setBounds(251, 73, 1132, 523);
                panel_1.add(panel_2);
                panel_2.setLayout(null);
                
                JPanel panel_1_1 = new JPanel();
                panel_1_1.setBounds(533, 10, 588, 498);
                panel_2.add(panel_1_1);
                panel_1_1.setBorder(null);
                panel_1_1.setLayout(null);
                
                JLabel lblNewLabel = new JLabel("LOG IN");
                lblNewLabel.setForeground(new Color(0, 0, 64));
                lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
                lblNewLabel.setBounds(252, 128, 113, 39);
                panel_1_1.add(lblNewLabel);
                
                JLabel lblPassword = new JLabel("Password");
                lblPassword.setForeground(new Color(0, 0, 64));
                lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                lblPassword.setBounds(190, 286, 101, 21);
                panel_1_1.add(lblPassword);
                
                JLabel lblID = new JLabel("Student ID");
                lblID.setForeground(new Color(0, 0, 64));
                lblID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                lblID.setBounds(190, 198, 101, 29);
                panel_1_1.add(lblID);
                
                JLabel lblDontHaveAn = new JLabel("Don't have an account yet?");
                lblDontHaveAn.setForeground(new Color(0, 0, 64));
                lblDontHaveAn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
                lblDontHaveAn.setBounds(177, 429, 171, 39);
                panel_1_1.add(lblDontHaveAn);
                
                JLabel lblNewLabel_1_1 = new JLabel("______________________\r\n");
                lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
                lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
                lblNewLabel_1_1.setBounds(177, 415, 243, 24);
                panel_1_1.add(lblNewLabel_1_1);
                
                JButton btnNewButton = new JButton("Sign up");
                btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		setVisible(false);
                		new SignUpFormWithDB().setVisible(true);
                	}
                });
                btnNewButton.setOpaque(false);
                btnNewButton.setForeground(new Color(255, 128, 0));
                btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
                btnNewButton.setContentAreaFilled(false);
                btnNewButton.setBorderPainted(false);
                btnNewButton.setBounds(330, 438, 85, 21);
                panel_1_1.add(btnNewButton);
                
                idField = new JTextField();
                idField.addKeyListener(new KeyAdapter() {
                	@Override
                	public void keyPressed(KeyEvent e) {
                		char c = e.getKeyChar();
                    	if(Character.isLetter(c)) {
                    		idField.setEditable(false);
                    		JOptionPane.showMessageDialog(null, "Enter Number Only");
                    	} else {
                    		idField.setEditable(true);
                    	}
                    	
                    	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    		passwordField.requestFocus();
                    		
                    	}
                	}
                });
                idField.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                idField.setBounds(190, 227, 204, 39);
                
                panel_1_1.add(idField);
                passwordField = new JPasswordField();
                passwordField.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                passwordField.setBounds(190, 310, 207, 39);
                panel_1_1.add(passwordField);
                passwordField.addKeyListener(new KeyAdapter() {
                	public void keyTyped (KeyEvent e) {
                		
                	}
                	public void keyPressed(KeyEvent e) {
                		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                			signIn();
                		}
                	}
                });
                
                
                        JButton signInButton = new JButton("Sign In");
                        signInButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
                        signInButton.setForeground(new Color(0, 0, 64));
                        signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        signInButton.setBackground(new Color(255, 128, 0));
                        signInButton.setBounds(228, 391, 137, 39);
                        panel_1_1.add(signInButton);
                        signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        signInButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                signInButton.setForeground(Color.WHITE);
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                signInButton.setForeground(new Color(0,0,64));
                            }
                        });
                        
                        JCheckBox CheckBox_1 = new JCheckBox("Show Password");
                        CheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 10));
                        CheckBox_1.setForeground(new Color(0, 0, 64));
                        CheckBox_1.setOpaque(false);
                        CheckBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        CheckBox_1.setBounds(190, 355, 131, 21);
                        CheckBox_1.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		JCheckBox CheckBox = (JCheckBox) e.getSource();
                        		passwordField.setEchoChar(CheckBox.isSelected() ? '\u0000' : '*');
                        	} 
                        });
                        panel_1_1.add(CheckBox_1);
                        
                        JLabel lblNewLabel_2 = new JLabel("New label");
                        lblNewLabel_2.setBounds(216, 10, 137, 108);
                        panel_1_1.add(lblNewLabel_2);
                        lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\OIG.4eLRR3eaBIAdToJCYc (1).png"));
                        
                        JLabel lblNewLabel_3 = new JLabel("");
                        lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\png-transparent-computer-icons-user-username-avatar-person-skill-thumbnail (2).png"));
                        lblNewLabel_3.setBounds(147, 227, 36, 39);
                        panel_1_1.add(lblNewLabel_3);
                        
                        JLabel lblNewLabel_3_1 = new JLabel("");
                        lblNewLabel_3_1.setIcon(new ImageIcon("D:\\Downloads\\png-transparent-computer-icons-password-icon-svg-security-password-icon.png"));
                        lblNewLabel_3_1.setBounds(147, 310, 36, 39);
                        panel_1_1.add(lblNewLabel_3_1);
                        
                        JButton adminBtn = new JButton("ADMIN");
                        adminBtn.setBackground(new Color(255, 128, 0));
                        adminBtn.setForeground(new Color(0, 0, 64));
                        adminBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
                        adminBtn.setBounds(252, 467, 85, 21);
                        panel_1_1.add(adminBtn);
                        adminBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        adminBtn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                adminBtn.setForeground(Color.WHITE);
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                adminBtn.setForeground(new Color(0,0,64));
                            }
                        });
                        
                        JLabel lblNewLabel_1 = new JLabel("");
                        lblNewLabel_1.setBounds(10, 10, 524, 498);
                        panel_2.add(lblNewLabel_1);
                        lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\tbo.jpg"));
                        
                        
                        
                        adminBtn.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		setVisible(false);
                        		new AdminForm().setVisible(true);
                        	}
                        });
                        
                                     
                                     signInButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             signIn();
                                         }
                                     });
                
                JLabel lblNewLabel_4 = new JLabel("");
                lblNewLabel_4.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d (1).jpg"));
                lblNewLabel_4.setBounds(44, 10, 1693, 624);
                panel_1.add(lblNewLabel_4);
                
                JLabel lblNewLabel_5 = new JLabel("");
                lblNewLabel_5.setIcon(new ImageIcon("D:\\Downloads\\USTP Logo against Dark Background (2).png"));
                lblNewLabel_5.setBounds(10, 10, 107, 78);
                panel.add(lblNewLabel_5);

        setVisible(true);
    }

    private void signIn() {
        String id = idField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try (Connection connection = DatabaseConnection.getConnection()) {
            String signInQuery = "SELECT * FROM account WHERE id = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(signInQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Login successful!");
                        setVisible(false);
                        new OrderForm().setVisible(true);
                        // Perform actions after successful login
                        // For example: Open a new window or perform other tasks
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid ID or password!");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignInForm1();
            }
        });
    }
}
