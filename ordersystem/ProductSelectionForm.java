package ordersystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ProductSelectionForm extends JFrame {
    private List<ProductPanel> productPanels = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable selectedProductsTable;

    public ProductSelectionForm() {
        setTitle("Product Selection Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel productPanelContainer = new JPanel(new GridLayout(2, 3, 10, 10));

        // Creating product panels
        for (int i = 1; i <= 6; i++) {
            ProductPanel productPanel = new ProductPanel("Product " + i);
            productPanelContainer.add(productPanel);
            productPanels.add(productPanel);
        }

        // Table to display selected products
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Selected Products");
        selectedProductsTable = new JTable(tableModel);

        // Adding components to the main frame
        add(productPanelContainer, BorderLayout.CENTER);
        add(new JScrollPane(selectedProductsTable), BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    private class ProductPanel extends JPanel {
        private String productName;
        private boolean selected = false;

        public ProductPanel(String productName) {
            this.productName = productName;
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setPreferredSize(new Dimension(150, 100));

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    toggleSelection();
                    updateTable();
                }
            });
        }

        public String getProductName() {
            return productName;
        }

        public boolean isSelected() {
            return selected;
        }

        private void toggleSelection() {
            selected = !selected;
            setBackground(selected ? Color.YELLOW : null);
        }

        private void updateTable() {
            if (selected) {
                tableModel.addRow(new Object[]{productName});
            } else {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (productName.equals(tableModel.getValueAt(i, 0))) {
                        tableModel.removeRow(i);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductSelectionForm().setVisible(true);
        });
    }
}