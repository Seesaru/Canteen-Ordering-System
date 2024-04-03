package ordersystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.cj.xdevapi.Statement;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class OrderForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DatabaseConnection dbConnection;
	private JSpinner spinner1;
	private static boolean isPanelClicked = false;
	private int originalQuantity;
	Set<JPanel> selectedPanels = new HashSet<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderForm frame = new OrderForm();
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
	public OrderForm() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1611, 823);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(36, 70, 959, 675);
		tabbedPane.setForeground(new Color(0, 0, 64));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(tabbedPane);
		tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel4 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel5 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel3 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel6 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel7 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel8 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel9 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel10 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel11 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel12 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel13 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel14 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel15= new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		SpinnerNumberModel spinnerModel16= new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		
		
		JPanel SnacksPanel = new JPanel();
		SnacksPanel.setBorder(new LineBorder(new Color(0, 0, 64), 4));
		SnacksPanel.setBackground(new Color(29, 41, 81));
		tabbedPane.addTab("Snacks", null, SnacksPanel, null);
		SnacksPanel.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 128, 0), 4, true));
		panel.setBounds(80, 20, 243, 289);
		SnacksPanel.add(panel);
		panel.setLayout(null);
		panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\siomai1 (3).jpg"));
		lblNewLabel.setBounds(20, 20, 213, 142);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(59, 237, 84, 21);
		panel.add(lblNewLabel_3);
		
		spinner1 = new JSpinner(spinnerModel);
		spinner1.setBounds(142, 240, 39, 20);
		panel.add(spinner1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Siomai"));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(66, 209, 98, 21);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Siomai (3 pcs)");
		lblNewLabel_3_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1.setBounds(59, 160, 122, 21);
		panel.add(lblNewLabel_3_2_1);
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new LineBorder(new Color(255, 128, 0), 4, true));
		panel4.setBounds(200, 316, 243, 289);
		SnacksPanel.add(panel4);
		panel4.setLayout(null);
		panel4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3 = new JLabel("Hotdog");
		lblNewLabel_3_2_1_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3.setBounds(83, 160, 67, 21);
		panel4.add(lblNewLabel_3_2_1_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\Downloads\\hotdog1 (1) (1).png"));
		lblNewLabel_5.setBounds(10, 25, 223, 125);
		panel4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_2_4 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Hotdog"));
		lblNewLabel_3_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_4.setBounds(71, 211, 102, 21);
		panel4.add(lblNewLabel_3_2_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Quantity:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(61, 239, 90, 21);
		panel4.add(lblNewLabel_3_5);
		JSpinner spinner4 = new JSpinner(spinnerModel4);
		spinner4.setBounds(143, 242, 41, 20);
		panel4.add(spinner4);
		
		JPanel panel5 = new JPanel();
		panel5.setBorder(new LineBorder(new Color(255, 128, 0), 4, true));
		panel5.setBounds(453, 316, 243, 289);
		SnacksPanel.add(panel5);
		panel5.setLayout(null);
		panel5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Downloads\\cup noodles (1).png"));
		lblNewLabel_4.setBounds(46, 22, 158, 142);
		panel5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_2_1_3_1 = new JLabel("Cup Noodles");
		lblNewLabel_3_2_1_3_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_1.setBounds(63, 162, 110, 21);
		panel5.add(lblNewLabel_3_2_1_3_1);
		
		JLabel lblNewLabel_3_2_5 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Cup Noodles"));
		lblNewLabel_3_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_5.setBounds(63, 211, 110, 21);
		panel5.add(lblNewLabel_3_2_5);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		quantityLabel.setBounds(46, 242, 90, 21);
		panel5.add(quantityLabel);
		JSpinner spinner5 = new JSpinner(spinnerModel5);
		spinner5.setBounds(128, 243, 45, 20);
		panel5.add(spinner5);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(255, 128, 0), 4, true));
		panel2.setBounds(333, 20, 243, 289);
		SnacksPanel.add(panel2);
		panel2.setLayout(null);
		panel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Burger");
		lblNewLabel_3_2_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_1.setBounds(95, 162, 90, 21);
		panel2.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Price: ₱" +  getProductPriceFromAdmin("Burger"));
		lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_2.setBounds(79, 208, 116, 21);
		panel2.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantity:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(53, 239, 90, 21);
		panel2.add(lblNewLabel_3_1);
		JSpinner spinner2 = new JSpinner(spinnerModel1);
		spinner2.setBounds(132, 242, 43, 20);
		panel2.add(spinner2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Downloads\\burger (1).png"));
		lblNewLabel_1.setBounds(21, 19, 200, 133);
		panel2.add(lblNewLabel_1);
		
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel3.setBounds(586, 20, 243, 289);
		SnacksPanel.add(panel3);
		panel3.setLayout(null);
		panel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Siopao");
		lblNewLabel_3_2_1_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_2.setBounds(84, 164, 90, 21);
		panel3.add(lblNewLabel_3_2_1_2);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Siopao"));
		lblNewLabel_3_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_3.setBounds(82, 211, 119, 21);
		panel3.add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Quantity:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(56, 241, 90, 21);
		panel3.add(lblNewLabel_3_3);
		JSpinner spinner3 = new JSpinner(spinnerModel3);
		spinner3.setBounds(134, 242, 41, 20);
		panel3.add(spinner3);
		
		JCheckBox checkBox = new JCheckBox("New check box");
		checkBox.setBounds(23, 274, 41, -10);
		panel3.add(checkBox);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\siopao (1).jpg"));
		lblNewLabel_2.setBounds(23, 21, 199, 131);
		panel3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d.jpg"));
		lblNewLabel_7.setBounds(0, 0, 954, 640);
		SnacksPanel.add(lblNewLabel_7);
		
		
		panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel);
                    isPanelClicked = true;
                    panel.setBackground(new Color(255, 128, 0));
                    panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Siomai";
                    int quantity = (int) spinner1.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel.setBackground(new Color(255, 255, 255));
                        spinner1.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel);
                    isPanelClicked = false;
                    panel.setBackground(new Color(255, 255, 255));
                    panel.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));
                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Siomai");
                    spinner1.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel)) {
                	panel.setBackground(new Color(255, 128, 0));
                    panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel)) {
                	panel.setBackground(new Color(255, 255, 255));
                    panel.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner1.addChangeListener(e -> {
            int newQuantity = (int) spinner1.getValue();
            String productName = "Siomai";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
                for (JPanel selectedPanel : selectedPanels) {
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(selectedPanel, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner1.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            }
        });       

	
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel2)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel2);
                    isPanelClicked = true;
                    panel2.setBackground(new Color(255, 128, 0));
                    panel2.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Burger";
                    int quantity = (int) spinner2.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel2, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel2.setBackground(new Color(255, 255, 255));
                        spinner2.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel2);
                    isPanelClicked = false;
                    panel2.setBackground(new Color(255, 255, 255));
                    panel2.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Burger");
                    spinner2.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel2)) {
                	panel2.setBackground(new Color(255, 128, 0));
                    panel2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel2)) {
                	panel2.setBackground(new Color(255, 255, 255));
                    panel2.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner2.addChangeListener(e -> {
            int newQuantity = (int) spinner2.getValue();
            String productName = "Burger";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel2, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner2.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
		
        panel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel3)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel3);
                    isPanelClicked = true;
                    panel3.setBackground(new Color(255, 128, 0));
                    panel3.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Siopao";
                    int quantity = (int) spinner3.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel2, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel3.setBackground(new Color(255, 255, 255));
                        spinner3.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel3);
                    isPanelClicked = false;
                    panel3.setBackground(new Color(255, 255, 255));
                    panel3.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Siopao");
                    spinner3.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel3)) {
                	panel3.setBackground(new Color(255, 128, 0));
                    panel3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel3)) {
                	panel3.setBackground(new Color(255, 255, 255));
                    panel3.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner3.addChangeListener(e -> {
            int newQuantity = (int) spinner3.getValue();
            String productName = "Siopao";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel3, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner3.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
		
        panel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel4)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel4);
                    isPanelClicked = true;
                    panel4.setBackground(new Color(255, 128, 0));
                    panel4.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Hotdog";
                    int quantity = (int) spinner4.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel4, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel4.setBackground(new Color(255, 255, 255));
                        spinner4.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel4);
                    isPanelClicked = false;
                    panel4.setBackground(new Color(255, 255, 255));
                    panel4.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Hotdog");
                    spinner4.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel4)) {
                	panel4.setBackground(new Color(255, 128, 0));
                    panel4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel4)) {
                	panel4.setBackground(new Color(255, 255, 255));
                    panel4.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner4.addChangeListener(e -> {
            int newQuantity = (int) spinner4.getValue();
            String productName = "Hotdog";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel4, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner4.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
		
        panel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel5)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel5);
                    isPanelClicked = true;
                    panel5.setBackground(new Color(255, 128, 0));
                    panel5.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Cup Noodles";
                    int quantity = (int) spinner5.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel5, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel5.setBackground(new Color(255, 255, 255));
                        spinner5.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel5);
                    isPanelClicked = false;
                    panel5.setBackground(new Color(255, 255, 255));
                    panel5.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Cup Noodles");
                    spinner5.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel5)) {
                	panel5.setBackground(new Color(255, 128, 0));
                    panel5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel5)) {
                	panel5.setBackground(new Color(255, 255, 255));
                    panel5.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner5.addChangeListener(e -> {
            int newQuantity = (int) spinner5.getValue();
            String productName = "Cup Noodles";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel5, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner5.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
       
        
        
		JPanel drinksPanel = new JPanel();
		drinksPanel.setBackground(new Color(29,41, 81));
		tabbedPane.addTab("Drinks", null, drinksPanel, null);
		drinksPanel.setLayout(null);
	
		
		JPanel panel8 = new JPanel();
		panel8.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel8.setLayout(null);
		panel8.setBounds(291, 10, 187, 201);
		drinksPanel.add(panel8);
		panel8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2 = new JLabel("Coke (sakto)");
		lblNewLabel_3_2_1_3_2_10_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2.setBounds(42, 87, 110, 21);
		panel8.add(lblNewLabel_3_2_1_3_2_10_2);
		
		JLabel lblNewLabel_5_1_10_2 = new JLabel("");
		lblNewLabel_5_1_10_2.setIcon(new ImageIcon("D:\\Downloads\\d7e05c1d5eeb25c49d97f674bc072576 (4) (1).png"));
		lblNewLabel_5_1_10_2.setBounds(51, 10, 101, 82);
		panel8.add(lblNewLabel_5_1_10_2);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Coke (sakto)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1.setBounds(52, 118, 101, 21);
		panel8.add(lblNewLabel_3_2_1_3_2_1_3_2_1);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1.setBounds(36, 149, 80, 21);
		panel8.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1);
		
		JSpinner spinner8 = new JSpinner(spinnerModel8);
		spinner8.setBounds(113, 149, 39, 20);
		panel8.add(spinner8);
		
		JPanel panel14 = new JPanel();
		panel14.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel14.setLayout(null);
		panel14.setBounds(291, 429, 187, 201);
		drinksPanel.add(panel14);
		panel14.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_5_1_10_2_1 = new JLabel("");
		lblNewLabel_5_1_10_2_1.setIcon(new ImageIcon("D:\\Downloads\\4801981116072 (1).png"));
		lblNewLabel_5_1_10_2_1.setBounds(50, 10, 91, 82);
		panel14.add(lblNewLabel_5_1_10_2_1);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_1 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Coke (litro)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_1.setBounds(10, 123, 101, 21);
		panel14.add(lblNewLabel_3_2_1_3_2_1_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_1 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_1.setBounds(10, 145, 80, 21);
		panel14.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_1);
		
		JSpinner spinner14 = new JSpinner(spinnerModel14);
		spinner14.setBounds(92, 148, 39, 20);
		panel14.add(spinner14);
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2_3 = new JLabel("Coke (1 Liter)");
		lblNewLabel_3_2_1_3_2_10_2_2_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2_3.setBounds(33, 92, 118, 21);
		panel14.add(lblNewLabel_3_2_1_3_2_10_2_2_3);
		
		JPanel panel11 = new JPanel();
		panel11.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel11.setLayout(null);
		panel11.setBounds(291, 218, 187, 201);
		drinksPanel.add(panel11);
		panel11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2 = new JLabel("Coke (mismo)");
		lblNewLabel_3_2_1_3_2_10_2_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2.setBounds(46, 92, 112, 21);
		panel11.add(lblNewLabel_3_2_1_3_2_10_2_2);
		
		JLabel lblNewLabel_5_1_10_2_2 = new JLabel("");
		lblNewLabel_5_1_10_2_2.setIcon(new ImageIcon("D:\\Downloads\\2004853827-1 (2).png"));
		lblNewLabel_5_1_10_2_2.setBounds(49, 10, 85, 82);
		panel11.add(lblNewLabel_5_1_10_2_2);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_2 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Coke (mismo)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_2.setBounds(45, 123, 101, 21);
		panel11.add(lblNewLabel_3_2_1_3_2_1_3_2_1_2);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_2 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_2.setBounds(26, 154, 80, 21);
		panel11.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_2);
		
		JSpinner spinner11 = new JSpinner(spinnerModel11);
		spinner11.setBounds(106, 154, 39, 20);
		panel11.add(spinner11);
		
		JPanel panel9 = new JPanel();
		panel9.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel9.setLayout(null);
		panel9.setBounds(488, 10, 187, 201);
		drinksPanel.add(panel9);
		panel9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_3 = new JLabel("Sprite (sakto)");
		lblNewLabel_3_2_1_3_2_10_2_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_3.setBounds(34, 89, 119, 21);
		panel9.add(lblNewLabel_3_2_1_3_2_10_2_3);
		
		JLabel lblNewLabel_5_1_10_2_3 = new JLabel("");
		lblNewLabel_5_1_10_2_3.setIcon(new ImageIcon("D:\\Downloads\\d6015ed5f51f17e70eee08b7d39bd34e (2) (1).png"));
		lblNewLabel_5_1_10_2_3.setBounds(47, 10, 106, 82);
		panel9.add(lblNewLabel_5_1_10_2_3);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_3 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Sprite (sakto)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_3.setBounds(44, 120, 101, 21);
		panel9.add(lblNewLabel_3_2_1_3_2_1_3_2_1_3);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_3 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_3.setBounds(29, 151, 80, 21);
		panel9.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_3);
		
		JSpinner spinner9 = new JSpinner(spinnerModel9);
		spinner9.setBounds(105, 152, 39, 20);
		panel9.add(spinner9);
		
		JPanel panel10 = new JPanel();
		panel10.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel10.setLayout(null);
		panel10.setBounds(685, 10, 187, 201);
		drinksPanel.add(panel10);
		panel10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_4 = new JLabel("Royal (sakto)");
		lblNewLabel_3_2_1_3_2_10_2_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_4.setBounds(41, 92, 114, 21);
		panel10.add(lblNewLabel_3_2_1_3_2_10_2_4);
		
		JLabel lblNewLabel_5_1_10_2_4 = new JLabel("");
		lblNewLabel_5_1_10_2_4.setIcon(new ImageIcon("D:\\Downloads\\d1aec9830e7f99b558f9c1f8af733c80 (1).png"));
		lblNewLabel_5_1_10_2_4.setBounds(40, 10, 101, 82);
		panel10.add(lblNewLabel_5_1_10_2_4);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_4 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Royal (sakto"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_4.setBounds(41, 123, 101, 21);
		panel10.add(lblNewLabel_3_2_1_3_2_1_3_2_1_4);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_4 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_4.setBounds(23, 154, 80, 21);
		panel10.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_4);
		
		JSpinner spinner10 = new JSpinner(spinnerModel10);
		spinner10.setBounds(102, 154, 39, 20);
		panel10.add(spinner10);
		
		JPanel panel12 = new JPanel();
		panel12.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel12.setLayout(null);
		panel12.setBounds(488, 218, 187, 201);
		drinksPanel.add(panel12);
		panel12.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_5_1_10_2_5 = new JLabel("");
		lblNewLabel_5_1_10_2_5.setIcon(new ImageIcon("D:\\Downloads\\2004890123-1 (2).png"));
		lblNewLabel_5_1_10_2_5.setBounds(54, 10, 106, 82);
		panel12.add(lblNewLabel_5_1_10_2_5);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_5 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Sprite (mismo)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_5.setBounds(47, 123, 101, 21);
		panel12.add(lblNewLabel_3_2_1_3_2_1_3_2_1_5);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_5 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_5.setBounds(29, 154, 80, 21);
		panel12.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_5);
		
		JSpinner spinner12 = new JSpinner(spinnerModel12);
		spinner12.setBounds(109, 154, 39, 20);
		panel12.add(spinner12);
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2_1 = new JLabel("Sprite (mismo)");
		lblNewLabel_3_2_1_3_2_10_2_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2_1.setBounds(35, 92, 125, 21);
		panel12.add(lblNewLabel_3_2_1_3_2_10_2_2_1);
		
		JPanel panel13 = new JPanel();
		panel13.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel13.setLayout(null);
		panel13.setBounds(685, 218, 187, 201);
		drinksPanel.add(panel13);
		panel13.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_5_1_10_2_6 = new JLabel("");
		lblNewLabel_5_1_10_2_6.setIcon(new ImageIcon("D:\\Downloads\\4801981118519 (6).png"));
		lblNewLabel_5_1_10_2_6.setBounds(76, 10, 57, 85);
		panel13.add(lblNewLabel_5_1_10_2_6);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_6 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Royal (mismo)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_6.setBounds(50, 123, 101, 21);
		panel13.add(lblNewLabel_3_2_1_3_2_1_3_2_1_6);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_6 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_6.setBounds(33, 154, 80, 21);
		panel13.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_6);
		
		JSpinner spinner13 = new JSpinner(spinnerModel13);
		spinner13.setBounds(112, 154, 39, 20);
		panel13.add(spinner13);
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2_2 = new JLabel("Royal (mismo)");
		lblNewLabel_3_2_1_3_2_10_2_2_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2_2.setBounds(40, 92, 137, 21);
		panel13.add(lblNewLabel_3_2_1_3_2_10_2_2_2);
		
		JPanel panel15 = new JPanel();
		panel15.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel15.setLayout(null);
		panel15.setBounds(488, 429, 187, 201);
		drinksPanel.add(panel15);
		panel15.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_5_1_10_2_7 = new JLabel("");
		lblNewLabel_5_1_10_2_7.setIcon(new ImageIcon("D:\\Downloads\\images (2).png"));
		lblNewLabel_5_1_10_2_7.setBounds(60, 10, 90, 82);
		panel15.add(lblNewLabel_5_1_10_2_7);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_7 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Sprite (litro)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_7.setBounds(10, 123, 101, 21);
		panel15.add(lblNewLabel_3_2_1_3_2_1_3_2_1_7);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_7 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_7.setBounds(10, 145, 80, 21);
		panel15.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_7);
		
		JSpinner spinner15 = new JSpinner(spinnerModel15);
		spinner15.setBounds(92, 148, 39, 20);
		panel15.add(spinner15);
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2_1_1 = new JLabel("Sprite (1 Liter)");
		lblNewLabel_3_2_1_3_2_10_2_2_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2_1_1.setBounds(36, 92, 125, 21);
		panel15.add(lblNewLabel_3_2_1_3_2_10_2_2_1_1);
		
		JPanel panel16 = new JPanel();
		panel16.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel16.setLayout(null);
		panel16.setBounds(685, 429, 187, 201);
		drinksPanel.add(panel16);
		panel16.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_5_1_10_2_8 = new JLabel("");
		lblNewLabel_5_1_10_2_8.setIcon(new ImageIcon("D:\\Downloads\\images (1) (1).png"));
		lblNewLabel_5_1_10_2_8.setBounds(52, 10, 85, 82);
		panel16.add(lblNewLabel_5_1_10_2_8);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_8 = new JLabel("Price: ₱"+ getProductPriceFromAdmin("Royal (litro)"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_8.setBounds(10, 123, 101, 21);
		panel16.add(lblNewLabel_3_2_1_3_2_1_3_2_1_8);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_8 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_8.setBounds(10, 145, 80, 21);
		panel16.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_8);
		
		JSpinner spinner16 = new JSpinner(spinnerModel16);
		spinner16.setBounds(92, 148, 39, 20);
		panel16.add(spinner16);
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_2_2_1 = new JLabel("Royal (1 Liter)");
		lblNewLabel_3_2_1_3_2_10_2_2_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_2_2_1.setBounds(40, 92, 137, 21);
		panel16.add(lblNewLabel_3_2_1_3_2_10_2_2_2_1);
		
		JPanel panel6 = new JPanel();
		panel6.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel6.setLayout(null);
		panel6.setBounds(49, 120, 187, 201);
		drinksPanel.add(panel6);
		panel6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_1 = new JLabel("Bottled Water");
		lblNewLabel_3_2_1_3_2_10_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_1.setBounds(32, 92, 132, 21);
		panel6.add(lblNewLabel_3_2_1_3_2_10_2_1);
		
		JLabel lblNewLabel_5_1_10_2_9 = new JLabel("");
		lblNewLabel_5_1_10_2_9.setIcon(new ImageIcon("D:\\Downloads\\images (4) (1) (1).png"));
		lblNewLabel_5_1_10_2_9.setBounds(53, 10, 90, 82);
		panel6.add(lblNewLabel_5_1_10_2_9);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_9 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Bottled Water") );
		lblNewLabel_3_2_1_3_2_1_3_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_9.setBounds(42, 123, 101, 21);
		panel6.add(lblNewLabel_3_2_1_3_2_1_3_2_1_9);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_9 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_9.setBounds(32, 154, 80, 21);
		panel6.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_9);
		
		JSpinner spinner6 = new JSpinner(spinnerModel6);
		spinner6.setBounds(109, 154, 39, 20);
		panel6.add(spinner6);
		
		JPanel panel7 = new JPanel();
		panel7.setBorder(new LineBorder(new Color(255, 128, 0), 4));
		panel7.setLayout(null);
		panel7.setBounds(49, 328, 187, 201);
		drinksPanel.add(panel7);
		panel7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3_2_1_3_2_10_2_5 = new JLabel("Zesto");
		lblNewLabel_3_2_1_3_2_10_2_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_10_2_5.setBounds(62, 92, 78, 21);
		panel7.add(lblNewLabel_3_2_1_3_2_10_2_5);
		
		JLabel lblNewLabel_5_1_10_2_10 = new JLabel("");
		lblNewLabel_5_1_10_2_10.setIcon(new ImageIcon("D:\\Downloads\\images (3) (1).png"));
		lblNewLabel_5_1_10_2_10.setBounds(47, 10, 93, 82);
		panel7.add(lblNewLabel_5_1_10_2_10);
		
		JLabel lblNewLabel_3_2_1_3_2_1_3_2_1_10 = new JLabel("Price: ₱" + getProductPriceFromAdmin("Zesto"));
		lblNewLabel_3_2_1_3_2_1_3_2_1_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_3_2_1_10.setBounds(47, 123, 101, 21);
		panel7.add(lblNewLabel_3_2_1_3_2_1_3_2_1_10);
		
		JLabel lblNewLabel_3_2_1_3_2_1_1_1_2_1_10 = new JLabel("Quantity:");
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1_3_2_1_1_1_2_1_10.setBounds(34, 154, 80, 21);
		panel7.add(lblNewLabel_3_2_1_3_2_1_1_1_2_1_10);
		
		JSpinner spinner7 = new JSpinner(spinnerModel7);
		spinner7.setBounds(113, 154, 39, 20);
		panel7.add(spinner7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\Downloads\\e1f8554dd0f4e79613cceb8cd006161d.jpg"));
		lblNewLabel_8.setBounds(0, 0, 954, 640);
		drinksPanel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1018, 107, 505, 626);
		panel_1.setBorder(new LineBorder(new Color(255, 128, 0), 6));
		panel_1.setBackground(new Color(29, 41, 81));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 //drinks panel
	       
        panel6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel6)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel6);
                    isPanelClicked = true;
                    panel6.setBackground(new Color(255, 128, 0));
                    panel6.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Bottled Water";
                    int quantity = (int) spinner6.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel6, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel6.setBackground(new Color(255, 255, 255));
                        spinner6.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel6);
                    isPanelClicked = false;
                    panel6.setBackground(new Color(255, 255, 255));
                    panel6.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Bottled Water");
                    spinner5.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel6)) {
                	panel6.setBackground(new Color(255, 128, 0));
                    panel6.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel6)) {
                	panel6.setBackground(new Color(255, 255, 255));
                    panel6.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner6.addChangeListener(e -> {
            int newQuantity = (int) spinner6.getValue();
            String productName = "Bottled Water";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel6, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner6.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
		
        panel7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel7)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel7);
                    isPanelClicked = true;
                    panel7.setBackground(new Color(255, 128, 0));
                    panel7.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Zesto";
                    int quantity = (int) spinner7.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel7, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel7.setBackground(new Color(255, 255, 255));
                        spinner7.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel7);
                    isPanelClicked = false;
                    panel7.setBackground(new Color(255, 255, 255));
                    panel7.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Zesto");
                    spinner7.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel7)) {
                	panel7.setBackground(new Color(255, 128, 0));
                    panel7.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel7)) {
                	panel7.setBackground(new Color(255, 255, 255));
                    panel7.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner7.addChangeListener(e -> {
            int newQuantity = (int) spinner7.getValue();
            String productName = "Zesto";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel7, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner7.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel8)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel8);
                    panel8.setBackground(new Color(255, 128, 0));
                    panel8.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Coke (sakto)";
                    int quantity = (int) spinner8.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel8, "Insufficient stock for product: " + productName);
                        panel8.setBackground(new Color(255, 255, 255));
                        panel8.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                        spinner8.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel8);
                    isPanelClicked = false;
                    panel8.setBackground(new Color(255, 255, 255));
                    panel8.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));
                    removeFromDatabase("Coke (sakto)");
                    spinner8.setValue(1);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel8)) {
                	panel8.setBackground(new Color(255, 128, 0));
                    panel8.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel8)) {
                	panel8.setBackground(new Color(255, 255, 255));
                    panel8.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner8.addChangeListener(e -> {
            int newQuantity = (int) spinner8.getValue();
            String productName = "Coke (sakto)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel8, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner8.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel9)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel9);
                    isPanelClicked = true;
                    panel9.setBackground(new Color(255, 128, 0));
                    panel9.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Sprite (sakto)";
                    int quantity = (int) spinner9.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel9, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel9.setBackground(new Color(255, 255, 255));
                        spinner9.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel9);
                    isPanelClicked = false;
                    panel9.setBackground(new Color(255, 255, 255));
                    panel9.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Sprite (sakto)");
                    spinner9.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel9)) {
                	panel9.setBackground(new Color(255, 128, 0));
                    panel9.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel9)) {
                	panel9.setBackground(new Color(255, 255, 255));
                    panel9.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner9.addChangeListener(e -> {
            int newQuantity = (int) spinner9.getValue();
            String productName = "Sprite (sakto)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel9, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner9.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel10)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel10);
                    isPanelClicked = true;
                    panel10.setBackground(new Color(255, 128, 0));
                    panel10.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Royal (sakto)";
                    int quantity = (int) spinner10.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel10, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel10.setBackground(new Color(255, 255, 255));
                        spinner10.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel10);
                    isPanelClicked = false;
                    panel10.setBackground(new Color(255, 255, 255));
                    panel10.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Royal (sakto)");
                    spinner10.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel10)) {
                	panel10.setBackground(new Color(255, 128, 0));
                    panel10.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel10)) {
                	panel10.setBackground(new Color(255, 255, 255));
                    panel10.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });

        spinner10.addChangeListener(e -> {
            int newQuantity = (int) spinner10.getValue();
            String productName = "Royal (sakto)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel10, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner10.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel11)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel11);
                    isPanelClicked = true;
                    panel11.setBackground(new Color(255, 128, 0));
                    panel11.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Coke (mismo)";
                    int quantity = (int) spinner10.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel11, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel11.setBackground(new Color(255, 255, 255));
                        spinner11.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel11);
                    isPanelClicked = false;
                    panel11.setBackground(new Color(255, 255, 255));
                    panel11.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Coke (mismo)");
                    spinner11.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel11)) {
                	panel11.setBackground(new Color(255, 128, 0));
                    panel11.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel11)) {
                	panel11.setBackground(new Color(255, 255, 255));
                    panel11.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner11.addChangeListener(e -> {
            int newQuantity = (int) spinner11.getValue();
            String productName = "Coke (mismo)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel11, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner11.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel12)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel12);
                    isPanelClicked = true;
                    panel12.setBackground(new Color(255, 128, 0));
                    panel12.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Sprite (mismo)";
                    int quantity = (int) spinner12.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel12, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel12.setBackground(new Color(255, 255, 255));
                        spinner12.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel12);
                    isPanelClicked = false;
                    panel12.setBackground(new Color(255, 255, 255));
                    panel12.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Sprite (mismo)");
                    spinner12.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel12)) {
                	panel12.setBackground(new Color(255, 128, 0));
                    panel12.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel12)) {
                	panel12.setBackground(new Color(255, 255, 255));
                    panel12.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner12.addChangeListener(e -> {
            int newQuantity = (int) spinner12.getValue();
            String productName = "Sprite (mismo)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel12, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner12.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel13)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel13);
                    isPanelClicked = true;
                    panel13.setBackground(new Color(255, 128, 0));
                    panel13.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Royal (mismo)";
                    int quantity = (int) spinner13.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel13, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel13.setBackground(new Color(255, 255, 255));
                        spinner13.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel13);
                    isPanelClicked = false;
                    panel13.setBackground(new Color(255, 255, 255));
                    panel13.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Royal (mismo)");
                    spinner13.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel13)) {
                	panel13.setBackground(new Color(255, 128, 0));
                    panel13.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel13)) {
                	panel13.setBackground(new Color(255, 255, 255));
                    panel13.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner13.addChangeListener(e -> {
            int newQuantity = (int) spinner13.getValue();
            String productName = "Royal (mismo)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel13, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner13.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel14)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel14);
                    isPanelClicked = true;
                    panel14.setBackground(new Color(255, 128, 0));
                    panel14.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Coke (litro)";
                    int quantity = (int) spinner14.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel14, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel14.setBackground(new Color(255, 255, 255));
                        spinner14.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel14);
                    isPanelClicked = false;
                    panel14.setBackground(new Color(255, 255, 255));
                    panel14.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Coke (litro)");
                    spinner14.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel14)) {
                	panel14.setBackground(new Color(255, 128, 0));
                    panel14.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel14)) {
                	panel14.setBackground(new Color(255, 255, 255));
                    panel14.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner14.addChangeListener(e -> {
            int newQuantity = (int) spinner14.getValue();
            String productName = "Coke (litro)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel14, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner14.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel15)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel15);
                    isPanelClicked = true;
                    panel15.setBackground(new Color(255, 128, 0));
                    panel15.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Sprite (litro)";
                    int quantity = (int) spinner15.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel15, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel15.setBackground(new Color(255, 255, 255));
                        spinner15.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel15);
                    isPanelClicked = false;
                    panel15.setBackground(new Color(255, 255, 255));
                    panel15.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Sprite (litro)");
                    spinner15.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel15)) {
                	panel15.setBackground(new Color(255, 128, 0));
                    panel15.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel15)) {
                	panel15.setBackground(new Color(255, 255, 255));
                    panel15.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner15.addChangeListener(e -> {
            int newQuantity = (int) spinner15.getValue();
            String productName = "Sprite (litro)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel15, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner15.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
        panel16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selectedPanels.contains(panel16)) {
                    // Panel was not selected, select it
                    selectedPanels.add(panel16);
                    isPanelClicked = true;
                    panel16.setBackground(new Color(255, 128, 0));
                    panel16.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
                    // Your existing logic for processing the click
                    // (You can add any additional logic you need here)
                    String productName = "Royal (litro)";
                    int quantity = (int) spinner16.getValue();
                    double productPrice = getProductPriceFromAdmin(productName);
                    double totalPrice = productPrice * quantity;

                    if (isStockAvailable(productName, quantity)) {
                        addToDatabase(productName, quantity, totalPrice);
                    } else {
                        JOptionPane.showMessageDialog(panel16, "Insufficient stock for product: " + productName);
                        isPanelClicked = false;
                        panel16.setBackground(new Color(255, 255, 255));
                        spinner16.setValue(getCurrentQuantity(productName));
                    }
                } else {
                    // Panel was selected, deselect it
                    selectedPanels.remove(panel16);
                    isPanelClicked = false;
                    panel16.setBackground(new Color(255, 255, 255));
                    panel16.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 4));

                    // Your existing logic for updating the order3 table when panel is deselected
                    removeFromDatabase("Royal (litro)");
                    spinner16.setValue(1);
                }
            }
            public void mouseEntered(MouseEvent e) {
                // Change color on mouse enter
                if (!selectedPanels.contains(panel16)) {
                	panel16.setBackground(new Color(255, 128, 0));
                    panel16.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color on mouse exit
                if (!selectedPanels.contains(panel16)) {
                	panel16.setBackground(new Color(255, 255, 255));
                    panel16.setBorder(BorderFactory.createLineBorder(new Color(255,128,0),4));
                }
            }
        });
        
        spinner16.addChangeListener(e -> {
            int newQuantity = (int) spinner16.getValue();
            String productName = "Royal (litro)";
            double productPrice = getProductPriceFromAdmin(productName);
            double totalPrice = productPrice * newQuantity;

            // Check if any panel is selected before changing the spinner value
            if (!selectedPanels.isEmpty()) {
               
                    // Check if the new quantity exceeds the available stock
                    if (newQuantity > getAvailableStock(productName)) {
                        JOptionPane.showMessageDialog(panel16, "Exceeded available stock. Please decrease the quantity.");
                        // Reset the spinner value to the previous valid quantity
                        spinner16.setValue(getCurrentQuantity(productName));
                        return;  // Stop further processing if stock is exceeded
                    }

                    // Update order quantity and total price
                    updateOrderQuantity(productName, newQuantity, totalPrice);

                    // (You can add any additional logic you need here)
                }
            
        });
        
       

        // Add the mouse listener to each panel in the array
      
        
		dbConnection = new DatabaseConnection(); // Initialize your DatabaseConnection class

        // Retrieve data from the database and populate the table
        try {
            Connection connection = dbConnection.getConnection(); // Obtain connection
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `order3`");
            ResultSet resultSet = statement.executeQuery();

            // Create table model with columns
            String[] columns = {"Product", "Quantity", "Price"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            while (resultSet.next()) {
                String productName = resultSet.getString("product");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                // Add fetched data to the table model including price
                Object[] row = {productName, quantity, price};
                model.addRow(row);
            }
            
            
            table = new JTable(model); // Set the table with the populated model
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(21, 20, 460, 589); // Adjust the bounds as needed
            panel_1.add(scrollPane);
            JTableHeader orderT = table.getTableHeader();
            orderT.setBackground(new Color(0,41,81));
            orderT.setForeground(new Color(255,255,255));
            
            
            JButton btnSignOut = new JButton("SIGN OUT");
            btnSignOut.setBounds(36, 769, 122, 31);
            btnSignOut.setBorder(null);
            btnSignOut.setForeground(new Color(0, 0, 64));
            btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnSignOut.setBackground(new Color(255, 128, 0));
            contentPane.add(btnSignOut);
            btnSignOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnSignOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnSignOut.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnSignOut.setForeground(new Color(0,0,64));
                }
            });

            JButton btnPlaceOrder = new JButton("PLACE ORDER");
            btnPlaceOrder.setBounds(1350, 769, 122, 31);
            btnPlaceOrder.setBorder(null);
            btnPlaceOrder.setForeground(new Color(29, 41, 81));
            btnPlaceOrder.setBackground(new Color(255, 128, 0));
            btnPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
            contentPane.add(btnPlaceOrder);
            btnPlaceOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnPlaceOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnPlaceOrder.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnPlaceOrder.setForeground(new Color(0,0,64));
                }
            });
            
            btnPlaceOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnPlaceOrder.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnPlaceOrder.setForeground(new Color(0,0,64));
                }
            });
            
            btnPlaceOrder.addActionListener(e -> {
                try {
                    Connection conn = DatabaseConnection.getConnection(); // Get the connection object.

                    // Query to retrieve data from the "order3" table
                    String selectQuery = "SELECT * FROM order3";
                    PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
                    ResultSet result = selectStmt.executeQuery(); // Changed variable name to 'result'

                    // Save data from the database table
                    List<Object[]> tableData = new ArrayList<>();
                    while (result.next()) {
                        Object[] rowData = new Object[3]; // Assuming 3 columns: product, quantity, price
                        rowData[0] = result.getString("product");
                        rowData[1] = result.getInt("quantity");
                        rowData[2] = result.getDouble("price");
                        tableData.add(rowData);
                    }

                    result.close();
                    selectStmt.close();

                    if (tableData.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please order something before placing the order.");
                    } else {
                        int option = JOptionPane.showConfirmDialog(null, "Confirm the order?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                        	
                            // Proceed to the next frame (assuming PlaceOrder is another JFrame)
                        	 new PlaceOrder().setVisible(true);
                           
                            for (Object[] rowData : tableData) {
                                String productName = (String) rowData[0];
                                int quantity = (int) rowData[1];

                                // Retrieve product ID based on product name from the admin table
                                String selectProductIDQuery = "SELECT Product_ID FROM admin WHERE Product_name=?";
                                try (PreparedStatement selectProductIDStmt = conn.prepareStatement(selectProductIDQuery)) {
                                    selectProductIDStmt.setString(1, productName);
                                    try (ResultSet productIDResult = selectProductIDStmt.executeQuery()) {
                                        if (productIDResult.next()) {
                                            int productID = productIDResult.getInt("Product_ID");

                                            // Check if the product already exists in the sale table
                                            String checkExistingQuery = "SELECT * FROM sale WHERE Product_ID=?";
                                            try (PreparedStatement checkExistingStmt = conn.prepareStatement(checkExistingQuery)) {
                                                checkExistingStmt.setInt(1, productID);
                                                try (ResultSet existingResult = checkExistingStmt.executeQuery()) {
                                                    if (existingResult.next()) {
                                                        // Product already exists, update the quantity
                                                        int existingQuantity = existingResult.getInt("Quantity");
                                                        int newQuantity = existingQuantity + quantity;

                                                        // Update data in the "sales" table
                                                        String updateQuery = "UPDATE sale SET Quantity=? WHERE Product_ID=?";
                                                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                                                            updateStmt.setInt(1, newQuantity);
                                                            updateStmt.setInt(2, productID);
                                                            updateStmt.executeUpdate();
                                                        }
                                                    } else {
                                                        // Product doesn't exist, insert new record
                                                        String insertQuery = "INSERT INTO sale (Product_ID, Product, Quantity) VALUES (?, ?, ?)";
                                                        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                                                            insertStmt.setInt(1, productID);
                                                            insertStmt.setString(2, productName);
                                                            insertStmt.setInt(3, quantity);
                                                            insertStmt.executeUpdate();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // Close current frame if needed
                            dispose();
                        }
                    }

                    conn.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });
            
            JButton btnClear = new JButton("CLEAR");
            btnClear.setBounds(1038, 769, 122, 31);
            btnClear.setBorder(null);
            btnClear.setForeground(new Color(29, 41, 81));
            btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
            btnClear.setBackground(new Color(255, 128, 0));
            contentPane.add(btnClear);
            btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnClear.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btnClear.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btnClear.setForeground(new Color(0,0,64));
                }
            });
            
            JPanel panel_2 = new JPanel();
            panel_2.setBorder(new LineBorder(new Color(255, 128, 0), 7));
            panel_2.setBackground(new Color(255, 255, 255));
            panel_2.setBounds(1170, 10, 485, 66);
            contentPane.add(panel_2);
            panel_2.setLayout(null);
            
            JLabel lblNewLabel_6 = new JLabel("New label");
            lblNewLabel_6.setBackground(new Color(0, 0, 64));
            lblNewLabel_6.setBounds(20, 17, 336, 39);
            panel_2.add(lblNewLabel_6);
            lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblNewLabel_6.setForeground(new Color(0, 0, 64));
            
            JLabel lblNewLabel_9 = new JLabel("Menu Items");
            lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 30));
            lblNewLabel_9.setForeground(new Color(255, 255, 255));
            lblNewLabel_9.setBounds(447, 38, 212, 38);
            contentPane.add(lblNewLabel_9);
            
            JLabel lblNewLabel_10 = new JLabel("");
            lblNewLabel_10.setIcon(new ImageIcon("D:\\Downloads\\star (3) (1).png"));
            lblNewLabel_10.setBounds(1101, 10, 59, 66);
            contentPane.add(lblNewLabel_10);
            
            try {
                Connection conn = DatabaseConnection.getConnection();

                // Query to get the product with the most quantity sold
                String maxQuantityQuery = "SELECT product FROM sale GROUP BY Product ORDER BY SUM(Quantity) DESC LIMIT 1";
                PreparedStatement maxQuantityStmt = conn.prepareStatement(maxQuantityQuery);
                ResultSet maxQuantityResult = maxQuantityStmt.executeQuery();

                if (maxQuantityResult.next()) {
                    String mostSoldProduct = maxQuantityResult.getString("Product");
                    lblNewLabel_6.setText("Most Sold Product: " + mostSoldProduct);
                } else {
                    lblNewLabel_6.setText("No sales data available");
                }

                maxQuantityResult.close();
                maxQuantityStmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            
            
            List<Object[]> savedTableData = new ArrayList<>();
            btnClear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Save the data from the database before clearing
                        Connection conn = DatabaseConnection.getConnection(); // Get the connection object.
                        String selectQuery = "SELECT product, quantity, price FROM order3";
                        PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
                        ResultSet rs = selectStmt.executeQuery();

                        while (rs.next()) {
                            Object[] rowData = new Object[3]; // Assuming there are 3 columns in the table
                            rowData[0] = rs.getString("product");
                            rowData[1] = rs.getInt("quantity");
                            rowData[2] = rs.getDouble("price");
                            savedTableData.add(rowData);
                        }

                        rs.close();
                        selectStmt.close();

                        // Clear the table in the UI
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setRowCount(0);

                        // Clear the table in the database
                        String clearQuery = "DELETE FROM order3";
                        PreparedStatement clearStmt = conn.prepareStatement(clearQuery);
                        clearStmt.executeUpdate();
                        clearStmt.close();

                        // Reset checkboxes using an array
                        //JCheckBox[] checkboxes = {checkBox1, checkBox2, checkBox3, checkBox4, checkBox5}; // Array of checkboxes
                        //for (JCheckBox checkbox : checkboxes) {
                        // checkbox.setSelected(false); // Uncheck each checkbox
                        //}

                        // Reset panels to normal color
                        for (JPanel selectedPanel : selectedPanels) {
                            selectedPanel.setBackground(new Color(255, 255, 255));
                            selectedPanel.setBorder(new LineBorder(new Color(255, 128, 0), 4, true));
                        }
                        selectedPanels.clear(); // Clear the selected panels list

                        // Reset spinners using an array
                        JSpinner[] spinners = {spinner1, spinner2, spinner3, spinner4, spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,
                        		spinner11,spinner12,spinner13,spinner14,spinner15,spinner16}; // Array of spinners
                        
                        
                       for (JSpinner spinner : spinners) {
                            SpinnerNumberModel model1 = (SpinnerNumberModel) spinner.getModel();
                            spinner.setValue(model1.getMinimum()); // Reset each spinner to its minimum value
                        }

                        conn.close();

                        // ... (rest of your code)
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            btnSignOut.addActionListener(e -> {
            	logout();
            });

            
            connection.close(); // Close the connection after use
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	private void addToDatabase(String product, int quantity, double price) {
	    try {
	        Connection connection = DatabaseConnection.getConnection();

	        // Check if there is enough stock in the admin table
	        if (isStockAvailable(product, quantity, connection)) {
	            // Insert the order into the order3 table with the calculated total price
	            String insertQuery = "INSERT INTO `order3` (product, quantity, price) VALUES (?, ?, ?)";
	            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
	                insertStatement.setString(1, product);
	                insertStatement.setInt(2, quantity);
	                insertStatement.setDouble(3, price);
	                insertStatement.executeUpdate();
	            }
	        } else {
	            // Handle insufficient stock scenario (display an error message, etc.)
	            JOptionPane.showMessageDialog(this, "Insufficient stock for product: " + product);
	        }

	        // Refresh the table after insertion
	        refreshTableFromDatabase();

	        connection.close(); // Close the connection after use
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private void removeFromDatabase(String product) {
	    try {
	        Connection connection = DatabaseConnection.getConnection(); // Obtain connection
	        String deleteQuery = "DELETE FROM `order3` WHERE product = ?";
	        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
	        deleteStatement.setString(1, product);
	        deleteStatement.executeUpdate();
	        
	        // Refresh the table after removal
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear current table data

	        // Fetch updated data from the database and populate the table again
	        PreparedStatement fetchStatement = connection.prepareStatement("SELECT * FROM `order3`");
	        ResultSet resultSet = fetchStatement.executeQuery();

	        while (resultSet.next()) {
	            String fetchedProductName = resultSet.getString("product");
	            int fetchedQuantity = resultSet.getInt("quantity");
	            double fetchedPrice =  resultSet.getInt("price");
	            //double price = resultSet.getDouble("price");

	            // Add fetched data to the table model
	            Object[] row = { fetchedProductName, fetchedQuantity, fetchedPrice};
	            model.addRow(row);
	        }

	        connection.close(); // Close the connection after use
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static boolean isProductInDatabase(String productName) {
        boolean productExists = false;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) FROM order3 WHERE product = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, productName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        productExists = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error-handling strategy
        }

        return productExists;
    }

	
	private void updateOrderQuantity(String product, int newQuantity, double totalPrice) {
	    try {
	        Connection connection = DatabaseConnection.getConnection();

	        // Update the quantity and price in the order3 table
	        String updateOrderQuery = "UPDATE `order3` SET quantity = ?, price = ? WHERE product = ?";
	        try (PreparedStatement updateOrderStatement = connection.prepareStatement(updateOrderQuery)) {
	            updateOrderStatement.setInt(1, newQuantity);
	            updateOrderStatement.setDouble(2, totalPrice);
	            updateOrderStatement.setString(3, product);
	            updateOrderStatement.executeUpdate();
	        }

	        // Refresh the table after update
	        refreshTableFromDatabase();

	        connection.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
    private void logout() {
        JOptionPane.showMessageDialog(this, "Logging out...");
        resetOrderTableInDatabase(); // Reset 'order3' table
        setVisible(false); // Hide the OrderForm upon logout
        new SignInForm1().setVisible(true); // Show SignInForm after logout
    }
    
    private void resetOrderTableInDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            java.sql.Statement statement = connection.createStatement(); // Use java.sql.Statement
            String resetQuery = "TRUNCATE TABLE order3";
            statement.executeUpdate(resetQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    public void saveTableDataToDatabase() {
        try {
            Connection connection = DatabaseConnection.getConnection(); // Get the connection object

            // Get table model and iterate to save data to the database
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String productName = model.getValueAt(i, 0).toString();
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                double price = Double.parseDouble(model.getValueAt(i, 2).toString());

                // Use PreparedStatement to insert data into the 'order3' table
                PreparedStatement statement = connection.prepareStatement("INSERT INTO `order3` (product, quantity, price) VALUES (?, ?, ?)");
                statement.setString(1, productName);
                statement.setInt(2, quantity);
                statement.setDouble(3, price);
                statement.executeUpdate();
                statement.close();
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void clearTableModel() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    private boolean isTableEmpty() {
        // Add logic to check if the table is empty in the database
        boolean isEmpty = true; // Replace this with your logic to check if the table is empty in the database
        return isEmpty;
    }
   

   
    private double getProductPriceFromAdmin(String productName) {
        double productPrice = 0.0;

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Prepare the SQL query to retrieve the product price based on the product name
            String query = "SELECT product_price FROM admin WHERE product_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, productName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if a result is found
                    if (resultSet.next()) {
                        productPrice = resultSet.getDouble("product_price");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return productPrice;
    }


    // Check if there is enough stock in the admin table for a given product
    private boolean isStockAvailable(String product, int quantity) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            return isStockAvailable(product, quantity, connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



    // Original isStockAvailable without connection parameter
    private boolean isStockAvailable(String product, int quantity, Connection connection) throws SQLException {
        String stockQuery = "SELECT stock FROM admin WHERE product_name = ?";
        try (PreparedStatement stockStatement = connection.prepareStatement(stockQuery)) {
            stockStatement.setString(1, product);
            try (ResultSet resultSet = stockStatement.executeQuery()) {
                if (resultSet.next()) {
                    int availableStock = resultSet.getInt("stock");
                    return availableStock >= quantity;
                }
            }
        }
        return false;
    }
 
    // Refresh the table data from the order3 table after any modification
    private void refreshTableFromDatabase() {
        // Fetch updated data from the database and populate the table again
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear current table data

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement fetchStatement = connection.prepareStatement("SELECT * FROM `order3`");
             ResultSet resultSet = fetchStatement.executeQuery()) {

            while (resultSet.next()) {
                String fetchedProductName = resultSet.getString("product");
                int fetchedQuantity = resultSet.getInt("quantity");
                double fetchedPrice = resultSet.getDouble("price");

                // Add fetched data to the table model
                Object[] row = {fetchedProductName, fetchedQuantity, fetchedPrice};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    private int getAvailableStock(String product) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            return getAvailableStock(product, connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0; // Handle the exception as needed, returning a default value
        }
    }

    // Original getAvailableStock without connection parameter
    private int getAvailableStock(String product, Connection connection) throws SQLException {
        String stockQuery = "SELECT stock FROM admin WHERE product_name = ?";
        try (PreparedStatement stockStatement = connection.prepareStatement(stockQuery)) {
            stockStatement.setString(1, product);
            try (ResultSet resultSet = stockStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("stock");
                }
            }
        }
        return 0;
    }
    
    private int getProductIDFromAdmin(Connection conn, String productName) throws SQLException {
        String selectProductIDQuery = "SELECT ProductID FROM admin WHERE ProductName = ?";
        try (PreparedStatement selectProductIDStmt = conn.prepareStatement(selectProductIDQuery)) {
            selectProductIDStmt.setString(1, productName);
            try (ResultSet productIDResult = selectProductIDStmt.executeQuery()) {
                if (productIDResult.next()) {
                    return productIDResult.getInt("ProductID");
                }
            }
        }
        return -1; // Default value
    }
    
   
    
    	private int getCurrentQuantity(String product) {
    	    Connection connection = null;
    	    try {
    	        connection = dbConnection.getConnection(); // Obtain connection
    	        String quantityQuery = "SELECT quantity FROM `order3` WHERE product = ?";
    	        try (PreparedStatement quantityStatement = connection.prepareStatement(quantityQuery)) {
    	            quantityStatement.setString(1, product);
    	            try (ResultSet resultSet = quantityStatement.executeQuery()) {
    	                if (resultSet.next()) {
    	                    return resultSet.getInt("quantity");
    	                }
    	            }
    	        }
    	    } catch (SQLException ex) {
    	        ex.printStackTrace();
    	    } finally {
    	        if (connection != null) {
    	            try {
    	                connection.close(); // Close the connection in a finally block
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	            }
    	        }
    	    }
    	    return 0; // Handle the exception as needed, returning a default value
    	}
}



	
	

	
	

	
