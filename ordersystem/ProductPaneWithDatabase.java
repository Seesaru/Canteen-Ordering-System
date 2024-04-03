package ordersystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductPaneWithDatabase extends JFrame {
    private JPanel productPanel;
    private JSpinner quantitySpinner;
    private JLabel priceLabel;
    private boolean isSelected = false;

    // SQLite database connection details
    private static final String JDBC_URL = "jdbc:sqlite:/path/to/your/database.db";

    public ProductPaneWithDatabase() {
        setTitle("Product Panel with Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productPanel = createProductPanel("Siomai", 20);

        add(productPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createProductPanel(String productName, int defaultPrice) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setPreferredSize(new Dimension(200, 100));

        JLabel nameLabel = new JLabel(productName);
        quantitySpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        priceLabel = new JLabel("Price: " + defaultPrice + " Pesos");

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSelection();
                saveToDatabase(productName, (int) quantitySpinner.getValue(), defaultPrice);
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleSelection();
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(nameLabel, BorderLayout.NORTH);
        panel.add(quantitySpinner, BorderLayout.CENTER);
        panel.add(priceLabel, BorderLayout.SOUTH);
        panel.add(saveButton, BorderLayout.EAST);

        return panel;
    }

    private void toggleSelection() {
        isSelected = !isSelected;
        productPanel.setBackground(isSelected ? Color.YELLOW : null);
    }

    private void saveToDatabase(String productName, int quantity, int defaultPrice) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT OR REPLACE INTO order3 (product_name, quantity, price) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, quantity * defaultPrice);

            preparedStatement.executeUpdate();
            updatePriceLabel(quantity * defaultPrice);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updatePriceLabel(int price) {
        priceLabel.setText("Price: " + price + " Pesos");
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new ProductPaneWithDatabase().setVisible(true);
        });
    }
}
