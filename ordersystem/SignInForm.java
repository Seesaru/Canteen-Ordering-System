package ordersystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SignInForm extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JPasswordField passwordField;

    public SignInForm() {
    	setUndecorated(true);
        getContentPane().setBackground(new Color(0, 0, 55));
        setTitle("Sign In");
        setSize(1654, 820);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        Container container = getContentPane();
        getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 64));
        panel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.setBorder(new LineBorder(new Color(255, 128, 0), 10));
        panel.setBackground(new Color(252, 251, 244));
        panel.setBounds(-13, 70, 1721, 644);
        getContentPane().add(panel);
        panel.setLayout(null);
                                
                                        JLabel lblName = new JLabel("Name:");
                                        lblName.setBounds(677, 258, 30, 13);
                                        panel.add(lblName);
                                                                
                                                                        passwordField = new JPasswordField(15);
                                                                        passwordField.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                                                        passwordField.setBounds(504, 188, 233, 39);
                                                                        panel.add(passwordField);
                                                                                
                                                                                JPanel panel_1 = new JPanel();
                                                                                panel_1.setBounds(902, 30, 588, 585);
                                                                                panel.add(panel_1);
                                                                                panel_1.setLayout(null);
                                                                                
                                                                                JLabel lblNewLabel = new JLabel("     LOGIN");
                                                                                lblNewLabel.setBounds(209, 24, 113, 39);
                                                                                panel_1.add(lblNewLabel);
                                                                                lblNewLabel.setForeground(new Color(0, 0, 64));
                                                                                lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
                                                                                
                                                                                        JButton signInButton = new JButton("LOGIN");
                                                                                        signInButton.setBounds(197, 381, 171, 45);
                                                                                        panel_1.add(signInButton);
                                                                                        signInButton.setForeground(new Color(0, 0, 64));
                                                                                        signInButton.setBackground(new Color(255, 128, 0));
                                                                                        signInButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
                                                                                        
                                                                                                nameField = new JTextField(15);
                                                                                                nameField.setBounds(164, 310, 233, 39);
                                                                                                panel_1.add(nameField);
                                                                                                nameField.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                                                                                
                                                                                                        JLabel lblPassword = new JLabel("Password");
                                                                                                        lblPassword.setBounds(164, 279, 101, 21);
                                                                                                        panel_1.add(lblPassword);
                                                                                                        lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                                                                                                                        
                                                                                                                                idField = new JTextField(15);
                                                                                                                                idField.setBounds(161, 230, 236, 39);
                                                                                                                                panel_1.add(idField);
                                                                                                                                idField.setBorder(new LineBorder(new Color(0, 0, 64), 2));
                                                                                                                                
                                                                                                                                        JLabel lblID = new JLabel("ID");
                                                                                                                                        lblID.setBounds(164, 191, 36, 29);
                                                                                                                                        panel_1.add(lblID);
                                                                                                                                        lblID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
                                                                                                                                        
                                                                                                                                        JLabel lblDontHaveAn = new JLabel("Don't have an account yet?");
                                                                                                                                        lblDontHaveAn.setForeground(new Color(0, 0, 64));
                                                                                                                                        lblDontHaveAn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
                                                                                                                                        lblDontHaveAn.setBounds(161, 459, 171, 39);
                                                                                                                                        panel_1.add(lblDontHaveAn);
                                                                                                                                        
                                                                                                                                        JLabel lblNewLabel_1_1 = new JLabel("______________________\r\n");
                                                                                                                                        lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
                                                                                                                                        lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
                                                                                                                                        lblNewLabel_1_1.setBounds(164, 436, 243, 24);
                                                                                                                                        panel_1.add(lblNewLabel_1_1);
                                                                                                                                        
                                                                                                                                        JButton btnNewButton = new JButton("Sign up");
                                                                                                                                        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
                                                                                                                                        btnNewButton.setForeground(new Color(255, 128, 0));
                                                                                                                                        btnNewButton.setOpaque(false);
                                                                                                                                        btnNewButton.setContentAreaFilled(false);
                                                                                                                                        btnNewButton.setBorderPainted(false);
                                                                                                                                        btnNewButton.addActionListener(new ActionListener() {
                                                                                                                                        	public void actionPerformed(ActionEvent e) {
                                                                                                                                        		setVisible(false);
                                                                                                                                        		new SignUpFormWithDB().setVisible(true);
                                                                                                                                       
                                                                                                                                        	}
                                                                                                                                        });
                                                                                                                                        btnNewButton.setBounds(312, 468, 85, 21);
                                                                                                                                        panel_1.add(btnNewButton);
                                                                                signInButton.addActionListener(new ActionListener() {
                                                                                    @Override
                                                                                    public void actionPerformed(ActionEvent e) {
                                                                                        signIn();
                                                                                    }
                                                                                });

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
                new SignInForm();
            }
        });
    }
}
