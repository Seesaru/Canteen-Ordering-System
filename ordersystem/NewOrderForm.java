package ordersystem;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NewOrderForm extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DatabaseConnection dbConnection;
    private JPanel panel_1;
    private JSpinner spinner_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewOrderForm frame = new NewOrderForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewOrderForm() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1550, 820);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(103, 77, 804, 609);
        contentPane.add(tabbedPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 64, 128));
        tabbedPane.addTab("New tab", null, panel, null);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(26, 41, 225, 236);
        panel.add(panel_1);
        panel_1.setLayout(null);

        spinner_1 = new JSpinner();
        spinner_1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTotalPrice();
            }
        });
        spinner_1.setBounds(79, 187, 30, 20);
        panel_1.add(spinner_1);
        

        panel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelColor();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(938, 120, 404, 514);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        dbConnection = new DatabaseConnection();
        updateTableModel();
    }

    private void togglePanelColor() {
        Color originalColor = panel_1.getBackground();

        if (originalColor.equals(Color.GREEN)) {
            panel_1.setBackground(Color.RED);
            removeFromDatabase("Product Name"); // Replace with the actual product name
            setSpinnerEnabled(false); // Disable the spinner when the panel turns red
        } else {
            panel_1.setBackground(Color.GREEN);
            addToDatabase("Product Name", 0, 0.0); // Pass default or other values
            setSpinnerEnabled(true); // Enable the spinner when the panel turns green
        }

        updateTableModel();
    }

    private void setSpinnerEnabled(boolean enabled) {
        spinner_1.setEnabled(enabled);
    }

    private void removeFromDatabase(String productName) {
        try (Connection conn = dbConnection.getConnection()) {
            String deleteQuery = "DELETE FROM order3 WHERE product = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setString(1, productName);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addToDatabase(String productName, int quantity, double totalPrice) {
        try (Connection conn = dbConnection.getConnection()) {
            String updateQuery = "INSERT INTO order3 (product, quantity, price) VALUES (?, ?, ?)"
                    + " ON DUPLICATE KEY UPDATE quantity = VALUES(quantity), price = VALUES(price)";

            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setString(1, productName);
                pstmt.setInt(2, quantity);
                pstmt.setDouble(3, totalPrice);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateTableModel() {
        try (Connection conn = dbConnection.getConnection()) {
            String query = "SELECT product, quantity, price FROM order3";
            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Product");
                model.addColumn("Quantity");
                model.addColumn("Price");

                while (rs.next()) {
                    Object[] row = {rs.getString("product"), rs.getInt("quantity"), rs.getDouble("price")};
                    model.addRow(row);
                }

                table.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateTotalPrice() {
        // Retrieve the selected quantity from the spinner
        int quantity = (int) spinner_1.getValue();

        // Calculate the total price based on the quantity (replace 20.0 with your actual price per unit)
        double totalPrice = quantity * 20.0;

        // Update the database with the new quantity and total price
        addToDatabase("Product Name", quantity, totalPrice);

        // Update the table model to reflect the changes
        updateTableModel();
    }

}
