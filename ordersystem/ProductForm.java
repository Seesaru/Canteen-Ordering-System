package ordersystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductForm extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JPanel panel;

    public ProductForm() {
        setTitle("Product Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Create table
        model = new DefaultTableModel();
        model.addColumn("Product");
        model.addColumn("Quantity");
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Populate table from database
        populateTableFromDatabase();

        // Create panel with checkboxes and spinners
        panel = new JPanel(new GridLayout(0, 2));

        // Sample products
        String[] products = {"Product A", "Product B", "Product C"};
        for (String product : products) {
            JCheckBox checkBox = new JCheckBox(product);
            SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            
            spinner.addChangeListener(e -> {
                int quantity = (int) spinner.getValue();
                updateQuantityInDatabase(product, quantity);
                refreshTable(); // Refresh the table after database changes
            });

            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    addToDatabase(product, (int) spinner.getValue());
                    
                } else {
                    removeFromDatabase(product);
                }
                refreshTable(); // Refresh the table after database changes
            });

            panel.add(checkBox);
            panel.add(spinner);
        }

        getContentPane().add(panel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addToDatabase(String product, int quantity) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersystem", "root", "");
            String query = "INSERT INTO `order` (product, quantity) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, product);
            preparedStatement.setInt(2, quantity);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeFromDatabase(String product) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersystem", "root", "");
            String query = "DELETE FROM `order` WHERE product=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, product);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateTableFromDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersystem", "root", "");
            String query = "SELECT * FROM `order`";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String product = resultSet.getString("product");
                int quantity = resultSet.getInt("quantity");
                model.addRow(new Object[]{product, quantity});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void updateQuantityInDatabase(String product, int quantity) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordersystem", "root", "");
            String query = "UPDATE `order` SET quantity=? WHERE product=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, product);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void refreshTable() {
        model.setRowCount(0); // Clear the table data
        populateTableFromDatabase(); // Refresh by repopulating from the database
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductForm::new);
    }
}