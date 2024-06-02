package view;

import controller.CustomerService;
import controller.CustomerServiceImplement;
import controller.SalesService;
import controller.SalesServiceImplement;
import controller.StockService;
import controller.StockServiceImplement;
import controller.UserService;
import controller.UserServiceImplement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import facade.Customer;
import facade.InvoiceFacade;
import facade.Stock;
import facade.User;
import facade.ViewSales;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Home extends javax.swing.JFrame {

    private DefaultListModel customerListModel = new DefaultListModel();
    private DefaultListModel productListModel = new DefaultListModel();
    private int selectedUserId;
    private int selectedCustomerId;
    private int selectedStockId;
    private Stock selectedInvoiceStock;
    private List<InvoiceFacade> InvoiceDetailsList = new CopyOnWriteArrayList<InvoiceFacade>();
    private double total;
    private int customerId;
    private SpinnerModel sm = new SpinnerNumberModel(1, 1, 10000, 1);

    public Home() {
        initComponents();
    }

    public Home(User user) {
        initComponents();
        setButtonVisibility(user);
        invoice_id.setText(UUID.randomUUID() + "");
        customer_name_sales.setEditable(false);
        total_price.setEditable(false);

        switch (user.getUserType()) {
            case 1:
                loadTableUserData();
                loadTableCustomerData();
                loadTableStockData();
                loadTableSalesData();
                break;
            case 2:
                loadTableCustomerData();
                loadTableStockData();
                loadTableSalesData();
                break;
            case 3:
                loadTableStockData();
                break;
            default:
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        main_tab = new javax.swing.JTabbedPane();
        home_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user_panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_user_delete = new javax.swing.JButton();
        btn_user_update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        userStatus = new javax.swing.JComboBox<>();
        userType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btn_user_save = new javax.swing.JButton();
        userSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_user_clear_all = new javax.swing.JButton();
        customer_panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        customer_firstName = new javax.swing.JTextField();
        customer_lastName = new javax.swing.JTextField();
        customer_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_customer_delete = new javax.swing.JButton();
        btn_customer_update = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        customer_status = new javax.swing.JComboBox<>();
        btn_customer_save = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
        customer_search = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btn_customer_clear = new javax.swing.JButton();
        stock_panel = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        productId = new javax.swing.JTextField();
        productName = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btn_product_delete = new javax.swing.JButton();
        btn_product_update = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        liter = new javax.swing.JTextField();
        btn_product_save = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_product = new javax.swing.JTable();
        stock_search = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sales_panel = new javax.swing.JPanel();
        search_sales_customer = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        sale_clearAll = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_sales = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        sales_product_name = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        customer_list = new javax.swing.JList<>(customerListModel);
        add_product = new javax.swing.JButton();
        btn_create_sale = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        product_list = new javax.swing.JList<>(productListModel);
        jLabel22 = new javax.swing.JLabel();
        customer_name_sales = new javax.swing.JTextField();
        sales_qty = new javax.swing.JSpinner(sm);
        jLabel23 = new javax.swing.JLabel();
        total_price = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        invoice_id = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_sales_records = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        home_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/img/asian_paint.jpg"))); // NOI18N

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        main_tab.addTab("Home", home_panel);

        user_panel.setBackground(new java.awt.Color(255, 255, 255));
        user_panel.setPreferredSize(new java.awt.Dimension(262, 600));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Fisrt Name", "Last Name", "Email", "Username", "Status", "User Type"
            }
        ));
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(user_table);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setText("First Name");
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel3.setText("Last Name");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel4.setText("Email");
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel5.setText("Username");
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel6.setText("Password");
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_user_delete.setText("Delete");
        btn_user_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_deleteActionPerformed(evt);
            }
        });

        btn_user_update.setText("Update");
        btn_user_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_updateActionPerformed(evt);
            }
        });
        btn_user_update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_user_updateKeyReleased(evt);
            }
        });

        jLabel7.setText("Status");
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 16));

        userStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Locked" }));

        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Stock Keeper", "Cashier" }));

        jLabel9.setText("User Type");
        jLabel9.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_user_save.setText("Save");
        btn_user_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_saveActionPerformed(evt);
            }
        });
        btn_user_save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_user_saveKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lastName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(firstName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addComponent(btn_user_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_user_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_user_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password)
                                    .addComponent(userStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(userStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_user_delete)
                            .addComponent(btn_user_update)
                            .addComponent(btn_user_save))
                        .addContainerGap())))
        );

        userSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSearchActionPerformed(evt);
            }
        });
        userSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userSearchKeyReleased(evt);
            }
        });

        jLabel8.setText("Search");
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_user_clear_all.setText("Clear All");
        btn_user_clear_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_user_clear_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout user_panelLayout = new javax.swing.GroupLayout(user_panel);
        user_panel.setLayout(user_panelLayout);
        user_panelLayout.setHorizontalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_user_clear_all)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(user_panelLayout.createSequentialGroup()
                .addGroup(user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(user_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        user_panelLayout.setVerticalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_panelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_user_clear_all))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main_tab.addTab("User Management", user_panel);

        customer_panel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel10.setText("First Name");
        jLabel10.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel11.setText("Last Name");
        jLabel11.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel12.setText("Email");
        jLabel12.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_customer_delete.setText("Delete");
        btn_customer_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer_deleteActionPerformed(evt);
            }
        });

        btn_customer_update.setText("Update");
        btn_customer_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer_updateActionPerformed(evt);
            }
        });

        jLabel15.setText("Status");
        jLabel15.setPreferredSize(new java.awt.Dimension(80, 16));

        customer_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivate" }));

        btn_customer_save.setText("Save");
        btn_customer_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(btn_customer_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_customer_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_customer_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customer_lastName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customer_firstName)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(customer_status, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customer_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(customer_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customer_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_customer_delete)
                    .addComponent(btn_customer_update)
                    .addComponent(btn_customer_save))
                .addContainerGap())
        );

        table_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Fisrt Name", "Last Name", "Email", "Status"
            }
        ));
        table_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_customer);

        customer_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_searchActionPerformed(evt);
            }
        });
        customer_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customer_searchKeyReleased(evt);
            }
        });

        jLabel17.setText("Search");
        jLabel17.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_customer_clear.setText("Clear All");
        btn_customer_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customer_panelLayout = new javax.swing.GroupLayout(customer_panel);
        customer_panel.setLayout(customer_panelLayout);
        customer_panelLayout.setHorizontalGroup(
            customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(customer_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_customer_clear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(customer_panelLayout.createSequentialGroup()
                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customer_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(customer_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        customer_panelLayout.setVerticalGroup(
            customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_panelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customer_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main_tab.addTab("Customer Management", customer_panel);

        stock_panel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel13.setText("Product ID :");
        jLabel13.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel14.setText("Name :");
        jLabel14.setPreferredSize(new java.awt.Dimension(80, 16));

        productId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdActionPerformed(evt);
            }
        });

        jLabel16.setText("Quantity :");
        jLabel16.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_product_delete.setText("Delete");
        btn_product_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_product_deleteActionPerformed(evt);
            }
        });

        btn_product_update.setText("Update");
        btn_product_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_product_updateActionPerformed(evt);
            }
        });

        jLabel18.setText("Liters :");
        jLabel18.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel20.setText("Price :");
        jLabel20.setPreferredSize(new java.awt.Dimension(80, 16));

        btn_product_save.setText("Save");
        btn_product_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_product_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(btn_product_save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_product_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_product_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(productName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(productId)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(liter, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_product_delete)
                    .addComponent(btn_product_update)
                    .addComponent(btn_product_save))
                .addContainerGap())
        );

        table_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product ID", "Product Name", "Quantity", "Price", "Liters"
            }
        ));
        table_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_product);
        if (table_product.getColumnModel().getColumnCount() > 0) {
            table_product.getColumnModel().getColumn(1).setHeaderValue("Qty");
            table_product.getColumnModel().getColumn(5).setHeaderValue("Liters");
        }

        stock_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_searchActionPerformed(evt);
            }
        });
        stock_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stock_searchKeyReleased(evt);
            }
        });

        jLabel19.setText("Search");
        jLabel19.setPreferredSize(new java.awt.Dimension(80, 16));

        jButton1.setText("Clear All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stock_panelLayout = new javax.swing.GroupLayout(stock_panel);
        stock_panel.setLayout(stock_panelLayout);
        stock_panelLayout.setHorizontalGroup(
            stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stock_search, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(stock_panelLayout.createSequentialGroup()
                .addGroup(stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stock_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(stock_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        stock_panelLayout.setVerticalGroup(
            stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_panelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main_tab.addTab("Stock Management", stock_panel);

        sales_panel.setBackground(new java.awt.Color(255, 255, 255));

        search_sales_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_sales_customerActionPerformed(evt);
            }
        });
        search_sales_customer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_sales_customerKeyReleased(evt);
            }
        });

        jLabel21.setText("Customer :");
        jLabel21.setPreferredSize(new java.awt.Dimension(80, 16));

        sale_clearAll.setText("Clear All");
        sale_clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_clearAllActionPerformed(evt);
            }
        });

        table_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Price"
            }
        ));
        table_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_salesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_sales);
        if (table_sales.getColumnModel().getColumnCount() > 0) {
            table_sales.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel27.setText("Product  :");

        sales_product_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sales_product_nameKeyReleased(evt);
            }
        });

        customer_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_listMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(customer_list);

        add_product.setText("Add");
        add_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_productActionPerformed(evt);
            }
        });

        btn_create_sale.setText("Create a Sale");
        btn_create_sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_saleActionPerformed(evt);
            }
        });

        product_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_listMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(product_list);

        jLabel22.setText("Customer Name :");
        jLabel22.setPreferredSize(new java.awt.Dimension(80, 16));

        customer_name_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_name_salesActionPerformed(evt);
            }
        });
        customer_name_sales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customer_name_salesKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel23.setText("Total Price : ");

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel24.setText("Invoice ID  : ");

        invoice_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sales_panelLayout = new javax.swing.GroupLayout(sales_panel);
        sales_panel.setLayout(sales_panelLayout);
        sales_panelLayout.setHorizontalGroup(
            sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sales_panelLayout.createSequentialGroup()
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4))
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(sales_panelLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customer_name_sales)
                                .addGap(492, 492, 492))
                            .addGroup(sales_panelLayout.createSequentialGroup()
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5)
                                    .addGroup(sales_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(search_sales_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addGap(18, 18, 18)
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sales_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sales_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sales_panelLayout.createSequentialGroup()
                                        .addComponent(sales_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(add_product, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_create_sale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sale_clearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_panelLayout.createSequentialGroup()
                                            .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_panelLayout.createSequentialGroup()
                                                    .addComponent(jLabel23)
                                                    .addGap(4, 4, 4))
                                                .addGroup(sales_panelLayout.createSequentialGroup()
                                                    .addComponent(jLabel24)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(total_price)
                                                .addComponent(invoice_id, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(25, 25, 25)))))
                .addContainerGap())
        );
        sales_panelLayout.setVerticalGroup(
            sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sales_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_sales_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(sales_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sales_panelLayout.createSequentialGroup()
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add_product)
                                    .addComponent(sales_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(invoice_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(total_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_create_sale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sale_clearAll)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer_name_sales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        main_tab.addTab("Sales", sales_panel);

        table_sales_records.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Product Name", "SubTotal"
            }
        ));
        table_sales_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sales_recordsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_sales_records);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        main_tab.addTab("View sales records", jPanel8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_tab)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_user_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_updateActionPerformed
        try {
            UserService userService = new UserServiceImplement();
            User user = new User();
            user.setUserId(selectedUserId);
            user.setFirstName(firstName.getText());
            user.setLastName(lastName.getText());
            user.setEmail(email.getText());
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setStatus(getSelectedUserStatus());
            user.setUserType(getSelectedUserType());

            userService.update(user);

            clearUserManagementFields();
            loadTableUserData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_user_updateActionPerformed

    private void userSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userSearchKeyReleased
        try {
            if (userSearch.getText().equals("")) {
                loadTableUserData();
            } else {
                UserService userService = new UserServiceImplement();
                User user = userService.searchByString(userSearch.getText());

                if (user != null) {
                    DefaultTableModel userTableModel = (DefaultTableModel) user_table.getModel();
                    userTableModel.setRowCount(0);

                    userTableModel.addRow(addUserValuesToVector(user));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            loadTableUserData();
        }
    }//GEN-LAST:event_userSearchKeyReleased

    private void userSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userSearchActionPerformed

    private void btn_customer_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer_updateActionPerformed
        try {
            CustomerService customerService = new CustomerServiceImplement();
            Customer customer = new Customer();
            customer.setCustomerId(selectedCustomerId);
            customer.setFirstName(customer_firstName.getText());
            customer.setLastName(customer_firstName.getText());
            customer.setEmail(customer_email.getText());
            customer.setStatus(getSelectedCustomerStatus());

            customerService.update(customer);

            clearCustomerManagementFields();
            loadTableCustomerData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_customer_updateActionPerformed

    private void customer_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_searchActionPerformed

    private void customer_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_searchKeyReleased
        try {
            if (customer_search.getText().equals("")) {
                loadTableCustomerData();
            } else {
                CustomerService customerService = new CustomerServiceImplement();
                Customer customer = customerService.searchByString(customer_search.getText());

                if (customer != null && customer.getFirstName() != null && customer.getLastName() != null) {
                    DefaultTableModel customerTableModel = (DefaultTableModel) table_customer.getModel();
                    customerTableModel.setRowCount(0);

                    customerTableModel.addRow(addCustomerValuesToVector(customer));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            loadTableUserData();
        }
    }//GEN-LAST:event_customer_searchKeyReleased

    private void btn_product_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_product_updateActionPerformed
        try {
            StockService stockService = new StockServiceImplement();
            Stock stock = new Stock();

            stock.setStockId(selectedStockId);
            stock.setProductId(productId.getText());
            stock.setProductName(productName.getText());
            stock.setQuantity(Double.parseDouble(qty.getText()));
            stock.setPrice(Double.parseDouble(price.getText()));
            stock.setLiter(Double.parseDouble(liter.getText()));

            stockService.update(stock);

            clearStockManagementFields();
            loadTableStockData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_product_updateActionPerformed

    private void stock_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stock_searchActionPerformed

    private void stock_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stock_searchKeyReleased
        try {
            if (stock_search.getText().equals("")) {
                loadTableCustomerData();
            } else {
                StockService stockService = new StockServiceImplement();
                Stock stock = stockService.searchByString(stock_search.getText());

                if (stock != null) {
                    DefaultTableModel stockTableModel = (DefaultTableModel) table_product.getModel();
                    stockTableModel.setRowCount(0);
                    stockTableModel.addRow(addStockValuesToVector(stock));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            loadTableUserData();
        }
    }//GEN-LAST:event_stock_searchKeyReleased

    private void btn_product_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_product_saveActionPerformed
        try {
            StockService stockService = new StockServiceImplement();
            Stock stock = new Stock();
            stock.setProductId(productId.getText());
            stock.setProductName(productName.getText());
            stock.setQuantity(Double.parseDouble(qty.getText()));
            stock.setPrice(Double.parseDouble(price.getText()));
            stock.setLiter(Double.parseDouble(liter.getText()));

            stockService.save(stock);

            clearStockManagementFields();
            loadTableStockData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_product_saveActionPerformed

    private void btn_user_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_saveActionPerformed
        try {
            UserService userService = new UserServiceImplement();
            User user = new User();
            user.setFirstName(firstName.getText());
            user.setLastName(lastName.getText());
            user.setEmail(email.getText());
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setStatus(getSelectedUserStatus());
            user.setUserType(getSelectedUserType());

            userService.save(user);

            clearUserManagementFields();
            loadTableUserData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_user_saveActionPerformed

    private void btn_customer_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer_saveActionPerformed
        try {
            CustomerService customerService = new CustomerServiceImplement();
            Customer customer = new Customer();
            customer.setFirstName(customer_firstName.getText());
            customer.setLastName(customer_lastName.getText());
            customer.setEmail(customer_email.getText());
            customer.setStatus(getSelectedCustomerStatus());

            customerService.save(customer);

            clearCustomerManagementFields();
            loadTableCustomerData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_customer_saveActionPerformed

    private void btn_user_updateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_user_updateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_user_updateKeyReleased

    private void btn_user_saveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_user_saveKeyReleased

    }//GEN-LAST:event_btn_user_saveKeyReleased

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked
        try {
            JTable target = (JTable) evt.getSource();
            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();

            Object value = target.getValueAt(selectedRow, 0);
            selectedUserId = Integer.parseInt(value.toString());

            btn_user_save.setEnabled(false);
            btn_user_update.setEnabled(true);
            btn_user_delete.setEnabled(true);

            UserService userService = new UserServiceImplement();
            User user = userService.getUserById(selectedUserId);

            firstName.setText(user.getFirstName());
            lastName.setText(user.getLastName());
            email.setText(user.getEmail());
            username.setText(user.getUsername());
            password.setText(user.getPassword());
            setUserStatus(user.getStatus());
            setUserType(user.getUserType());

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_tableMouseClicked

    private void btn_user_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_deleteActionPerformed
        try {
            UserService userService = new UserServiceImplement();
            userService.delete(selectedUserId);

            clearUserManagementFields();
            loadTableUserData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_user_deleteActionPerformed

    private void btn_user_clear_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_user_clear_allActionPerformed
        clearUserManagementFields();
    }//GEN-LAST:event_btn_user_clear_allActionPerformed

    private void btn_customer_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer_clearActionPerformed
        clearCustomerManagementFields();
    }//GEN-LAST:event_btn_customer_clearActionPerformed

    private void btn_customer_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer_deleteActionPerformed
        try {
            CustomerService customerService = new CustomerServiceImplement();
            customerService.delete(selectedCustomerId);

            clearCustomerManagementFields();
            loadTableCustomerData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_customer_deleteActionPerformed

    private void table_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customerMouseClicked
        try {
            JTable target = (JTable) evt.getSource();
            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();

            Object value = target.getValueAt(selectedRow, 0);
            selectedCustomerId = Integer.parseInt(value.toString());

            btn_customer_save.setEnabled(false);
            btn_customer_update.setEnabled(true);
            btn_customer_delete.setEnabled(true);

            CustomerService customerService = new CustomerServiceImplement();
            Customer customer = customerService.getCustomerById(selectedCustomerId);

            customer_firstName.setText(customer.getFirstName());
            customer_lastName.setText(customer.getLastName());
            customer_email.setText(customer.getEmail());
            setCustomerStatus(customer.getStatus());

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_customerMouseClicked

    private void productIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdActionPerformed

    private void btn_product_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_product_deleteActionPerformed
        try {
            StockService stockService = new StockServiceImplement();
            stockService.delete(selectedStockId);

            clearStockManagementFields();
            loadTableStockData();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_product_deleteActionPerformed

    private void table_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productMouseClicked

        try {
            JTable target = (JTable) evt.getSource();
            int selectedRow = target.getSelectedRow();
            int selectedColumn = target.getSelectedColumn();

            Object value = target.getValueAt(selectedRow, 0);
            selectedStockId = Integer.parseInt(value.toString());

            btn_product_save.setEnabled(false);
            btn_product_update.setEnabled(true);
            btn_product_delete.setEnabled(true);

            StockService stockService = new StockServiceImplement();
            Stock stock = stockService.getStockById(selectedStockId);

            productId.setText(stock.getProductId());
            productName.setText(stock.getProductName());
            qty.setText(stock.getQuantity() + "");
            price.setText(stock.getPrice() + "");
            liter.setText(stock.getLiter() + "");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_table_productMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearCustomerManagementFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void search_sales_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_sales_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_sales_customerActionPerformed

    private void search_sales_customerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_sales_customerKeyReleased
        try {
            if (search_sales_customer.getText().equals("")) {
                customerListModel.removeAllElements();
                customer_name_sales.setText("");
            } else {
                CustomerService customerService = new CustomerServiceImplement();
                Customer customer = customerService.searchByString(search_sales_customer.getText());

                if (customer != null && customer.getFirstName() != null && customer.getLastName() != null) {
                    if (customerListModel.getSize() != 0) {
                        customerListModel.removeAllElements();
                    }
                    customerListModel.addElement(customer.getCustomerId() + " : " + customer.getFirstName() + " " + customer.getLastName());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_sales_customerKeyReleased

    private void sale_clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_clearAllActionPerformed
        clearSalesFields();
    }//GEN-LAST:event_sale_clearAllActionPerformed

    private void table_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_salesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_salesMouseClicked

    private void add_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_productActionPerformed
        try {
            DefaultTableModel salesTableModel = (DefaultTableModel) table_sales.getModel();
            double qty = Double.parseDouble(sales_qty.getValue().toString());
            total += selectedInvoiceStock.getPrice() * qty;

            InvoiceFacade invoiceFacade = new InvoiceFacade();
            invoiceFacade.setPrice(selectedInvoiceStock.getPrice());
            invoiceFacade.setProductId(selectedInvoiceStock.getProductId());
            invoiceFacade.setProductName(selectedInvoiceStock.getProductName());
            invoiceFacade.setStockId(selectedInvoiceStock.getStockId());
            invoiceFacade.setTotalPrice(selectedInvoiceStock.getPrice() * qty);
            invoiceFacade.setQty(qty);

            for (InvoiceFacade invoice : InvoiceDetailsList) {
                if (invoice.getProductId().equals(selectedInvoiceStock.getProductId())) {
                    InvoiceDetailsList.remove(invoice);

                    double q = invoice.getQty() + qty;
                    invoice.setQty(q);
                    invoice.setTotalPrice(q * invoice.getPrice());
                    InvoiceDetailsList.add(invoice);
                } else {
                    InvoiceDetailsList.add(invoiceFacade);
                }
            }

            if (InvoiceDetailsList.isEmpty()) {
                InvoiceDetailsList.add(invoiceFacade);
            }

            salesTableModel.setRowCount(0);
            for (InvoiceFacade invoice : InvoiceDetailsList) {
                salesTableModel.addRow(addSalesValuesToVector(invoice));
            }

            total_price.setText(total + "");
        } catch (NumberFormatException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_productActionPerformed

    private void btn_create_saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_saleActionPerformed
        try {
            SalesService salesService = new SalesServiceImplement();
            salesService.createSale(InvoiceDetailsList, invoice_id.getText(), customerId, total, selectedInvoiceStock.getProductId());
            clearSalesFields();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_create_saleActionPerformed

    private void customer_name_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_name_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_name_salesActionPerformed

    private void customer_name_salesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_name_salesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_customer_name_salesKeyReleased

    private void customer_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_listMouseClicked
        try {

            String[] index = customer_list.getSelectedValue().split(" :");
            CustomerService customerService = new CustomerServiceImplement();
            customerId = Integer.parseInt(index[0]);
            Customer customer = customerService.getCustomerById(customerId);
            customer_name_sales.setText(customer.getFirstName() + " " + customer.getLastName());

        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customer_listMouseClicked

    private void sales_product_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sales_product_nameKeyReleased
        try {
            if (sales_product_name.getText().equals("")) {
                productListModel.removeAllElements();
                sales_product_name.setText("");
            } else {
                StockService stockService = new StockServiceImplement();
                Stock stock = stockService.searchByString(sales_product_name.getText());

                if (stock != null && stock.getProductId() != null && stock.getProductName() != null) {
                    if (productListModel.getSize() != 0) {
                        productListModel.removeAllElements();
                    }

                    selectedInvoiceStock = stock;
                    productListModel.addElement("Product ID : " + stock.getProductId() + " / Name : " + stock.getProductName());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sales_product_nameKeyReleased

    private void product_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_listMouseClicked

    }//GEN-LAST:event_product_listMouseClicked

    private void invoice_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoice_idActionPerformed

    private void table_sales_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sales_recordsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_sales_recordsMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_product;
    private javax.swing.JButton btn_create_sale;
    private javax.swing.JButton btn_customer_clear;
    private javax.swing.JButton btn_customer_delete;
    private javax.swing.JButton btn_customer_save;
    private javax.swing.JButton btn_customer_update;
    private javax.swing.JButton btn_product_delete;
    private javax.swing.JButton btn_product_save;
    private javax.swing.JButton btn_product_update;
    private javax.swing.JButton btn_user_clear_all;
    private javax.swing.JButton btn_user_delete;
    private javax.swing.JButton btn_user_save;
    private javax.swing.JButton btn_user_update;
    private javax.swing.JTextField customer_email;
    private javax.swing.JTextField customer_firstName;
    private javax.swing.JTextField customer_lastName;
    private javax.swing.JList<String> customer_list;
    private javax.swing.JTextField customer_name_sales;
    private javax.swing.JPanel customer_panel;
    private javax.swing.JTextField customer_search;
    private javax.swing.JComboBox<String> customer_status;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstName;
    private javax.swing.JPanel home_panel;
    private javax.swing.JTextField invoice_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField liter;
    private javax.swing.JTabbedPane main_tab;
    private javax.swing.JTextField password;
    private javax.swing.JTextField price;
    private javax.swing.JTextField productId;
    private javax.swing.JTextField productName;
    private javax.swing.JList<String> product_list;
    private javax.swing.JTextField qty;
    private javax.swing.JButton sale_clearAll;
    private javax.swing.JPanel sales_panel;
    private javax.swing.JTextField sales_product_name;
    private javax.swing.JSpinner sales_qty;
    private javax.swing.JTextField search_sales_customer;
    private javax.swing.JPanel stock_panel;
    private javax.swing.JTextField stock_search;
    private javax.swing.JTable table_customer;
    private javax.swing.JTable table_product;
    private javax.swing.JTable table_sales;
    private javax.swing.JTable table_sales_records;
    private javax.swing.JTextField total_price;
    private javax.swing.JTextField userSearch;
    private javax.swing.JComboBox<String> userStatus;
    private javax.swing.JComboBox<String> userType;
    private javax.swing.JPanel user_panel;
    private javax.swing.JTable user_table;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void setButtonVisibility(User user) {

        btn_user_update.setEnabled(false);
        btn_user_delete.setEnabled(false);

        btn_customer_update.setEnabled(false);
        btn_customer_delete.setEnabled(false);

        btn_product_update.setEnabled(false);
        btn_product_delete.setEnabled(false);

        if (user.getUserType() == 2) {
            main_tab.removeAll();
            main_tab.add(home_panel, "Home");
            main_tab.add(customer_panel, "Customer Management");
            main_tab.add(stock_panel, "Stock Management");
            main_tab.add(sales_panel, "Sales Management");
        } else if (user.getUserType() == 3) {
            main_tab.removeAll();
            main_tab.add(home_panel, "Home");
            main_tab.add(stock_panel, "Stock Management");
        }
    }

    private int getSelectedUserStatus() {
        if (userStatus.getSelectedItem().equals("Active")) {
            return 1;
        }

        return 2;
    }

    private int getSelectedUserType() {
        if (userType.getSelectedItem().equals("Manager")) {
            return 1;
        } else if (userType.getSelectedItem().equals("Cashier")) {
            return 2;
        }

        return 3;
    }

    private void setUserStatus(int status) {
        if (status == 1) {
            userStatus.setSelectedItem("Active");
        } else {
            userStatus.setSelectedItem("Locked");
        }
    }

    private void setUserType(int status) {
        if (status == 1) {
            userType.setSelectedItem("Manager");
        } else if (status == 2) {
            userType.setSelectedItem("Cashier");
        } else {
            userType.setSelectedItem("Stock Keeper");
        }
    }

    private void loadTableUserData() {
        try {
            UserService userService = new UserServiceImplement();
            List<User> userList = userService.loadAllUsers();

            DefaultTableModel userTableModel = (DefaultTableModel) user_table.getModel();
            userTableModel.setRowCount(0);

            for (User user : userList) {
                userTableModel.addRow(addUserValuesToVector(user));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Vector addUserValuesToVector(User user) {
        Vector userVector = new Vector();
        userVector.add(user.getUserId());
        userVector.add(user.getFirstName());
        userVector.add(user.getLastName());
        userVector.add(user.getEmail());
        userVector.add(user.getUsername());

        if (user.getStatus() == 1) {
            userVector.add("Active");
        } else {
            userVector.add("Locked");
        }

        if (user.getUserType() == 1) {
            userVector.add("Manager");
        } else if (user.getUserType() == 2) {
            userVector.add("Stock Keeper");
        } else if (user.getUserType() == 3) {
            userVector.add("Cashier");
        }

        return userVector;
    }

    private void clearUserManagementFields() {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        setUserStatus(1);
        setUserType(1);
        userSearch.setText("");
        loadTableUserData();
        btn_user_save.setEnabled(true);
        btn_user_update.setEnabled(false);
        btn_user_delete.setEnabled(false);
    }

//    Cutomer section
    private int getSelectedCustomerStatus() {
        if (customer_status.getSelectedItem().equals("Active")) {
            return 1;
        }

        return 2;
    }

    private void setCustomerStatus(int status) {
        if (status == 1) {
            customer_status.setSelectedItem("Active");
        } else {
            customer_status.setSelectedItem("Deactivate");
        }
    }

    private void loadTableCustomerData() {
        try {
            CustomerService customerService = new CustomerServiceImplement();
            List<Customer> customerList = customerService.loadAllCustomers();

            DefaultTableModel customerTableModel = (DefaultTableModel) table_customer.getModel();
            customerTableModel.setRowCount(0);

            for (Customer customer : customerList) {
                customerTableModel.addRow(addCustomerValuesToVector(customer));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Vector addCustomerValuesToVector(Customer customer) {
        Vector customerVector = new Vector();
        customerVector.add(customer.getCustomerId());
        customerVector.add(customer.getFirstName());
        customerVector.add(customer.getLastName());
        customerVector.add(customer.getEmail());

        if (customer.getStatus() == 1) {
            customerVector.add("Active");
        } else {
            customerVector.add("Deactivate");
        }

        return customerVector;
    }

    private void clearCustomerManagementFields() {
        customer_firstName.setText("");
        customer_lastName.setText("");
        customer_email.setText("");
        setCustomerStatus(1);
        customer_search.setText("");

        loadTableUserData();

        btn_customer_save.setEnabled(true);
        btn_customer_update.setEnabled(false);
        btn_customer_delete.setEnabled(false);
    }

//    Stock Management
    private void clearStockManagementFields() {
        productId.setText("");
        productName.setText("");
        qty.setText("");
        price.setText("");
        liter.setText("");
        stock_search.setText("");

        loadTableUserData();

        btn_product_save.setEnabled(true);
        btn_product_update.setEnabled(false);
        btn_product_delete.setEnabled(false);
    }

    private void loadTableStockData() {
        try {
            StockService stockService = new StockServiceImplement();
            List<Stock> stockList = stockService.loadAllStock();

            DefaultTableModel stockTableModel = (DefaultTableModel) table_product.getModel();
            stockTableModel.setRowCount(0);

            for (Stock stock : stockList) {
                stockTableModel.addRow(addStockValuesToVector(stock));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Vector addStockValuesToVector(Stock stock) {
        Vector customerVector = new Vector();
        customerVector.add(stock.getStockId());
        customerVector.add(stock.getProductId());
        customerVector.add(stock.getProductName());
        customerVector.add(stock.getQuantity());
        customerVector.add(stock.getPrice());
        customerVector.add(stock.getLiter());

        return customerVector;
    }

    // Sales Management
    private Vector addSalesValuesToVector(InvoiceFacade invoiceFacade) {
        Vector customerVector = new Vector();
        customerVector.add(invoiceFacade.getProductId());
        customerVector.add(invoiceFacade.getProductName());
        customerVector.add(invoiceFacade.getQty());
        customerVector.add(invoiceFacade.getTotalPrice());

        return customerVector;
    }

//    Sales records
    private void loadTableSalesData() {
        try {
            SalesService stockService = new SalesServiceImplement();
            List<ViewSales> stockList = stockService.getSalesRecords();

            DefaultTableModel stockTableModel = (DefaultTableModel) table_sales_records.getModel();
            stockTableModel.setRowCount(0);

            for (ViewSales sales : stockList) {
                stockTableModel.addRow(addSalesRecordValuesToVector(sales));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Vector addSalesRecordValuesToVector(ViewSales viewSales) {
        Vector vector = new Vector();
        vector.add(viewSales.getCustomerName());
        vector.add(viewSales.getProductName());
        vector.add(viewSales.getTotal());

        return vector;
    }

    private void clearSalesFields() {
        DefaultTableModel salesTableModel = (DefaultTableModel) table_sales.getModel();
        salesTableModel.setRowCount(0);
        total_price.setText("");
        invoice_id.setText(UUID.randomUUID() + "");
        search_sales_customer.setText("");
        sales_product_name.setText("");
        customer_list.removeAll();
        product_list.removeAll();;

        loadTableSalesData();
    }

}
