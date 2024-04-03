package ordersystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.LineBorder;

public class SignUpFormWithDB extends JFrame {

    private JTextField namefield;
    private JPasswordField passwordfield;
    private JTextField idfield;
    private JPanel panel;
    private JCheckBox showPasswordCheckBox;

    public SignUpFormWithDB() {
    	setUndecorated(true);
        getContentPane().setBackground(new Color(0, 0, 55));
        setTitle("Sign Up");
        setSize(1554, 820);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeComponents();
    }

    private void initializeComponents() {
        Container container = getContentPane();
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 128, 0), 10));
        panel.setBackground(new Color(252, 251, 244));
        panel.setBounds(453, 56, 694, 700);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_1.setBounds(53, 32, 589, 638);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("SIGN UP");
        lblNewLabel_2.setForeground(new Color(0, 0, 64));
        lblNewLabel_2.setBounds(244, 145, 132, 32);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 26));
        
                showPasswordCheckBox = new JCheckBox("Show Password");
                showPasswordCheckBox.setBorder(null);
                showPasswordCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                showPasswordCheckBox.setBounds(192, 430, 150, 32);
                panel_1.add(showPasswordCheckBox);
                showPasswordCheckBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
                
                        JButton signUpButton = new JButton("Sign Up");
                        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        signUpButton.setForeground(new Color(0, 0, 64));
                        signUpButton.setBackground(new Color(255, 128, 0));
                        signUpButton.setBounds(244, 513, 125, 47);
                        panel_1.add(signUpButton);
                        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        signUpButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                signUpButton.setForeground(Color.WHITE);
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                signUpButton.setForeground(new Color(0,0,64));
                            }
                        });
                        signUpButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
                        
                                passwordfield = new JPasswordField();
                                passwordfield.setBounds(192, 379, 234, 41);
                                panel_1.add(passwordfield);
                                passwordfield.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                
                                        namefield = new JTextField();
                                        namefield.setBounds(192, 302, 234, 41);
                                        panel_1.add(namefield);
                                        namefield.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                                
                                                        idfield = new JTextField();
                                                        idfield.setBounds(191, 229, 234, 41);
                                                        panel_1.add(idfield);
                                                        idfield.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                                        
                                                        idfield.addKeyListener(new KeyAdapter() {
                                                        	@Override
                                                        	public void keyPressed(KeyEvent e) {
                                                        		char c = e.getKeyChar();
                                                            	if(Character.isLetter(c)) {
                                                            		idfield.setEditable(false);
                                                            		JOptionPane.showMessageDialog(null, "Enter Number Only");
                                                            	} else {
                                                            		idfield.setEditable(true);
                                                            	}
                                                        	}
                                                        });
                                                        
                                                                JLabel label_1 = new JLabel("Password:");
                                                                label_1.setBounds(95, 364, 87, 64);
                                                                panel_1.add(label_1);
                                                                label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
                                                                
                                                                        JLabel lblName = new JLabel("Name :");
                                                                        lblName.setBounds(122, 299, 72, 41);
                                                                        panel_1.add(lblName);
                                                                        lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
                                                                                
                                                                                        JLabel lblId = new JLabel("Student ID :");
                                                                                        lblId.setBounds(80, 220, 132, 53);
                                                                                        panel_1.add(lblId);
                                                                                        lblId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
                                                                                        
                                                                                        JLabel lblNewLabel = new JLabel("");
                                                                                        lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\OIG.4eLRR3eaBIAdToJCYc (1).png"));
                                                                                        lblNewLabel.setBounds(229, 10, 132, 125);
                                                                                        panel_1.add(lblNewLabel);
                        
                        JButton BackButton = new JButton("BACK");
                        BackButton.setBorder(null);
                        BackButton.setForeground(new Color(0, 0, 64));
                        BackButton.setBackground(new Color(255, 128, 0));
                        BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
                        BackButton.setBounds(20, 762, 85, 36);
                        BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        BackButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                BackButton.setForeground(Color.WHITE);
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                BackButton.setForeground(new Color(0,0,64));
                            }
                        });
                        BackButton.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		setVisible(false);
                        		new SignInForm1().setVisible(true);
                        	}
                        });
                        getContentPane().add(BackButton);
                        
                        JPanel panel_2 = new JPanel();
                        panel_2.setBorder(new LineBorder(new Color(255, 128, 0), 10, true));
                        panel_2.setBackground(new Color(29,41, 81));
                        panel_2.setBounds(-18, 125, 1636, 556);
                        getContentPane().add(panel_2);
                        panel_2.setLayout(null);
                        
                        JLabel lblNewLabel_1 = new JLabel("");
                        lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d (1).jpg"));
                        lblNewLabel_1.setBounds(10, 10, 1616, 536);
                        panel_2.add(lblNewLabel_1);
                        
                        JLabel lblNewLabel_3 = new JLabel("");
                        lblNewLabel_3.setIcon(new ImageIcon("D:\\Downloads\\USTP Logo against Dark Background (2).png"));
                        lblNewLabel_3.setBounds(10, 10, 111, 94);
                        getContentPane().add(lblNewLabel_3);
                        
                                signUpButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        signUp();
                                    }
                                });
                showPasswordCheckBox.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            passwordfield.setEchoChar((char) 0); // Show password
                        } else {
                            passwordfield.setEchoChar('*'); // Hide password
                        }
                    }
                });

        setVisible(true);
    }

    private void signUp() {
        String id = idfield.getText();
        String name = namefield.getText();
        String password = String.valueOf(passwordfield.getPassword());

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Check if the id already exists
            if (isIdAvailable(id, connection)) {
                String signUpQuery = "INSERT INTO account (id, name, password) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(signUpQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, password);

                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(this, "Sign Up Successful!");
                        setVisible(false);
                        new SignInForm1().setVisible(true);

                        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                int userId = generatedKeys.getInt(1);

                                setVisible(false);
                                new Main().setVisible(true);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Error signing up.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "ID already exists. Please choose a different ID.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isIdAvailable(String id, Connection connection) throws SQLException {
        String checkIdQuery = "SELECT * FROM account WHERE id = ?";
        try (PreparedStatement checkIdStatement = connection.prepareStatement(checkIdQuery)) {
            checkIdStatement.setString(1, id);
            try (ResultSet resultSet = checkIdStatement.executeQuery()) {
                return !resultSet.next(); // Returns true if id is not found
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpFormWithDB();
            }
        });
    }

	public int getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}
}