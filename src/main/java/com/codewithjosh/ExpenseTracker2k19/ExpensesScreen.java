package main.java.com.codewithjosh.ExpenseTracker2k19;

import com.toedter.calendar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.*;
import org.netbeans.lib.awtextra.*;

public class ExpensesScreen extends JFrame
{

    private JPanel BodyPanel;
    private JPanel pTopLeft;
    private JPanel pTopRight;
    private JPanel pBottomLeft;
    private JPanel pBottomRight;
    private JPanel DataPanel;
    private JPanel HeadPanel;
    private JPanel TablePanel;
    private JButton btnAdd;
    private JButton btnBack;
    private JButton btnCalculator;
    private JButton btnClear;
    private JComboBox<String> cmbCategory;
    private JDateChooser dcDate;
    private JButton btnDeleteAll;
    private JButton btnDelete;
    private JButton btnClose;
    private JButton btnGraph;
    private JButton btnMinimize;
    private JCheckBox chkTopLeft;
    private JCheckBox chkTopRight;
    private JCheckBox chkBottomLeft;
    private JCheckBox chkBottomRight;
    private JScrollPane spBottomRight;
    private JScrollPane spTopLeft;
    private JScrollPane spTopRight;
    private JScrollPane spBottomLeft;
    private JSeparator s;
    public JLabel lblTopLeft;
    public JLabel lblTopLeftAmount;
    public JLabel lblTopRight;
    public JLabel lblTopRightAmount;
    public JLabel lblBottomLeft;
    public JLabel lblBottomLeftAmount;
    public JLabel lblBottomRight;
    public JLabel lblBottomRightAmount;
    private JLabel lblHead;
    private JLabel lblProjectTitle;
    private JLabel lblTotal;
    private JButton btnMode;
    private JButton btnToday;
    private JTable tblTopLeft;
    private JTable tblTopRight;
    private JTable tblBottomLeft;
    private JTable tblBottomRight;
    private JLabel lblCategory;
    private JLabel lblQuantity;
    private JLabel lblAmount;
    private JLabel lblDescription;
    private JLabel lblDate;
    private JLabel lblBalance;
    private JLabel lblTitle;
    private JTextField tfAmount;
    private JTextField tfDescription;
    private JTextField tfQuantity;

    ExpenseTracker expenseTracker;
    static int currentXPosition = 0;
    static int currentYPosition = 0;
    int current = 0;
    Preferences pref;
    DefaultTableModel modelTopLeft = new DefaultTableModel();
    DefaultTableModel modelTopRight = new DefaultTableModel();
    DefaultTableModel modelBottomLeft = new DefaultTableModel();
    DefaultTableModel modelBottomRight = new DefaultTableModel();
    Connection conn = null;
    PreparedStatement ps = null;
    int user_id = 0;
    ResultSet rs = null;

    public ExpensesScreen()
    {

        initComponents();
        initInstances();
        initIcons();
        initTable();

        onToday();
        onClear();
        loadExpenses();
        setSelected(true);

    }

    private void initComponents()
    {

        HeadPanel = new JPanel();
        lblProjectTitle = new JLabel();
        btnMode = new JButton();
        btnMinimize = new JButton();
        btnClose = new JButton();
        lblHead = new JLabel();
        BodyPanel = new JPanel();
        DataPanel = new JPanel();
        lblTitle = new JLabel();
        lblCategory = new JLabel();
        lblQuantity = new JLabel();
        lblAmount = new JLabel();
        lblDescription = new JLabel();
        cmbCategory = new JComboBox<>();
        tfQuantity = new JTextField();
        tfAmount = new JTextField();
        tfDescription = new JTextField();
        s = new JSeparator();
        btnBack = new JButton();
        btnAdd = new JButton();
        btnClear = new JButton();
        btnCalculator = new JButton();
        dcDate = new JDateChooser();
        TablePanel = new JPanel();
        chkTopLeft = new JCheckBox();
        chkTopRight = new JCheckBox();
        chkBottomLeft = new JCheckBox();
        chkBottomRight = new JCheckBox();
        pTopLeft = new JPanel();
        lblTopLeft = new JLabel();
        lblTopLeftAmount = new JLabel();
        pTopRight = new JPanel();
        lblTopRight = new JLabel();
        lblTopRightAmount = new JLabel();
        pBottomLeft = new JPanel();
        lblBottomLeft = new JLabel();
        lblBottomLeftAmount = new JLabel();
        pBottomRight = new JPanel();
        lblBottomRight = new JLabel();
        lblBottomRightAmount = new JLabel();
        spBottomRight = new JScrollPane();
        tblBottomRight = new JTable();
        tblBottomRight = new JTable();
        spTopLeft = new JScrollPane();
        tblTopLeft = new JTable();
        tblTopLeft = new JTable();
        spTopRight = new JScrollPane();
        tblTopRight = new JTable();
        tblTopRight = new JTable();
        spBottomLeft = new JScrollPane();
        tblBottomLeft = new JTable();
        tblBottomLeft = new JTable();
        btnGraph = new JButton();
        btnDelete = new JButton();
        btnToday = new JButton();
        btnDeleteAll = new JButton();
        lblDate = new JLabel();
        lblBalance = new JLabel();
        lblTotal = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        HeadPanel.setBackground(new Color(39, 71, 217));
        HeadPanel.setLayout(new AbsoluteLayout());

        lblProjectTitle.setText("Expense Tracker - Expenses");
        lblProjectTitle.setForeground(Color.WHITE);
        lblProjectTitle.setFont(new Font("Dialog", 0, 11));
        HeadPanel.add(lblProjectTitle, new AbsoluteConstraints(40, 0, 290, 30));

        btnMode.setContentAreaFilled(false);
        btnMode.addActionListener((ActionEvent evt)
                ->
        {
            btnModeActionPerformed(evt);
                });
        HeadPanel.add(btnMode, new AbsoluteConstraints(0, 0, 30, 30));

        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFont(new Font("Tahoma", 1, 18));
        btnMinimize.setForeground(new Color(240, 240, 240));
        btnMinimize.setText("—");
        btnMinimize.addActionListener((ActionEvent evt)
                ->
        {
            btnMinimizeActionPerformed(evt);
                });
        HeadPanel.add(btnMinimize, new AbsoluteConstraints(770, 0, -1, 30));

        btnClose.setContentAreaFilled(false);
        btnClose.setFont(new Font("Tahoma", 1, 14));
        btnClose.setForeground(new Color(240, 240, 240));
        btnClose.setText("X");
        btnClose.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                btnCloseFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                btnCloseFocusLost(evt);
            }

        });
        btnClose.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                btnCloseMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                btnCloseMouseExited(evt);
            }

        });
        btnClose.addActionListener((ActionEvent evt)
                ->
        {
            btnCloseActionPerformed(evt);
                });
        HeadPanel.add(btnClose, new AbsoluteConstraints(810, 0, -1, 30));

        lblHead.addMouseMotionListener(new MouseMotionAdapter()
        {

            @Override
            public void mouseDragged(MouseEvent evt)
            {
                lblHeadMouseDragged(evt);
            }

        });
        lblHead.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mousePressed(MouseEvent evt)
            {
                lblHeadMousePressed(evt);
            }

        });
        lblHead.setHorizontalAlignment(SwingConstants.CENTER);
        HeadPanel.add(lblHead, new AbsoluteConstraints(0, 0, 850, 30));

        getContentPane().add(HeadPanel, new AbsoluteConstraints(0, 0, 850, 30));

        BodyPanel.setLayout(new AbsoluteLayout());

        DataPanel.setBackground(new Color(225, 225, 225));
        DataPanel.setLayout(new AbsoluteLayout());

        lblTitle.setFont(new Font("Arial", 1, 24));
        lblTitle.setText("EXPENSES");
        DataPanel.add(lblTitle, new AbsoluteConstraints(60, 20, -1, -1));

        lblCategory.setFont(new Font("Arial", 1, 14));
        lblCategory.setText("Category");
        DataPanel.add(lblCategory, new AbsoluteConstraints(62, 60, -1, 20));

        lblQuantity.setFont(new Font("Arial", 1, 14));
        lblQuantity.setText("Qty");
        DataPanel.add(lblQuantity, new AbsoluteConstraints(152, 60, -1, 20));

        lblAmount.setFont(new Font("Arial", 1, 14));
        lblAmount.setText("Amount");
        DataPanel.add(lblAmount, new AbsoluteConstraints(202, 60, -1, 20));

        lblDescription.setFont(new Font("Arial", 1, 14));
        lblDescription.setText("Description");
        DataPanel.add(lblDescription, new AbsoluteConstraints(292, 60, -1, 20));

        cmbCategory.setFont(new Font("Tahoma", 0, 12));
        cmbCategory.setModel(new DefaultComboBoxModel<>(new String[]
        {
            "<Choose>",
            "TRAVEL",
            "SHOPPING",
            "FOODS",
            "OTHERS"
        }));
        cmbCategory.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                cmbCategoryFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                cmbCategoryFocusLost(evt);
            }

        });
        DataPanel.add(cmbCategory, new AbsoluteConstraints(60, 80, -1, 30));

        tfQuantity.setBorder(null);
        tfQuantity.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                tfQuantityFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                tfQuantityFocusLost(evt);
            }

        });
        tfQuantity.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyTyped(KeyEvent evt)
            {
                tfQuantityKeyTyped(evt);
            }

        });
        DataPanel.add(tfQuantity, new AbsoluteConstraints(150, 80, 40, 30));

        tfAmount.setBorder(null);
        tfAmount.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                tfAmountFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                tfAmountFocusLost(evt);
            }

        });
        tfAmount.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyTyped(KeyEvent evt)
            {
                tfAmountKeyTyped(evt);
            }

        });
        DataPanel.add(tfAmount, new AbsoluteConstraints(200, 80, 80, 30));

        tfDescription.setBorder(null);
        tfDescription.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                tfDescriptionFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                tfDescriptionFocusLost(evt);
            }

        });
        tfDescription.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyTyped(KeyEvent evt)
            {
                tfDescriptionKeyTyped(evt);
            }

        });
        DataPanel.add(tfDescription, new AbsoluteConstraints(290, 80, 370, 30));
        DataPanel.add(s, new AbsoluteConstraints(50, 120, 740, 10));

        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener((ActionEvent evt)
                ->
        {
            btnBackActionPerformed(evt);
                });
        DataPanel.add(btnBack, new AbsoluteConstraints(20, 20, -1, -1));

        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.addActionListener((ActionEvent evt)
                ->
        {
            btnAddActionPerformed(evt);
                });
        DataPanel.add(btnAdd, new AbsoluteConstraints(670, 80, 30, 30));

        btnClear.setContentAreaFilled(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusLost(FocusEvent evt)
            {
                btnClearFocusLost(evt);
            }

        });
        btnClear.addActionListener((ActionEvent evt)
                ->
        {
            btnClearActionPerformed(evt);
                });
        DataPanel.add(btnClear, new AbsoluteConstraints(710, 80, 80, 30));

        btnCalculator.setContentAreaFilled(false);
        btnCalculator.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalculator.addActionListener((ActionEvent evt)
                ->
        {
            btnCalculatorActionPerformed(evt);
                });
        DataPanel.add(btnCalculator, new AbsoluteConstraints(770, 30, -1, -1));

        BodyPanel.add(DataPanel, new AbsoluteConstraints(0, 0, 850, 149));

        dcDate.setDateFormatString("yyyy-MM-dd");
        ((JTextFieldDateEditor) dcDate.getDateEditor()).setEditable(false);
        BodyPanel.add(dcDate, new AbsoluteConstraints(140, 160, 120, 30));

        TablePanel.setLayout(new AbsoluteLayout());

        chkTopLeft.addItemListener((ItemEvent evt)
                ->
        {
            chkTopLeftItemStateChanged(evt);
                });
        TablePanel.add(chkTopLeft, new AbsoluteConstraints(320, 0, -1, -1));

        chkTopRight.addItemListener((ItemEvent evt)
                ->
        {
            chkTopRightItemStateChanged(evt);
                });
        TablePanel.add(chkTopRight, new AbsoluteConstraints(680, 0, -1, -1));

        chkBottomLeft.addItemListener((ItemEvent evt)
                ->
        {
            chkBottomLeftItemStateChanged(evt);
                });
        TablePanel.add(chkBottomLeft, new AbsoluteConstraints(320, 170, -1, -1));

        chkBottomRight.addItemListener((ItemEvent evt)
                ->
        {
            chkBottomRightItemStateChanged(evt);
                });
        TablePanel.add(chkBottomRight, new AbsoluteConstraints(680, 170, -1, -1));

        pTopLeft.setLayout(new AbsoluteLayout());

        lblTopLeft.setFont(new Font("Tahoma", 1, 12));
        pTopLeft.add(lblTopLeft, new AbsoluteConstraints(20, 0, -1, 16));

        lblTopLeftAmount.setFont(new Font("Tahoma", 1, 12));
        lblTopLeftAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTopLeftAmount.setText("0.00");
        pTopLeft.add(lblTopLeftAmount, new AbsoluteConstraints(150, 0, 120, -1));

        TablePanel.add(pTopLeft, new AbsoluteConstraints(30, 4, 290, 16));

        pTopRight.setLayout(new AbsoluteLayout());

        lblTopRight.setFont(new Font("Tahoma", 1, 12));
        pTopRight.add(lblTopRight, new AbsoluteConstraints(20, 0, -1, 16));

        lblTopRightAmount.setFont(new Font("Tahoma", 1, 12));
        lblTopRightAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTopRightAmount.setText("0.00");
        pTopRight.add(lblTopRightAmount, new AbsoluteConstraints(150, 0, 120, -1));

        TablePanel.add(pTopRight, new AbsoluteConstraints(390, 4, 290, -1));

        pBottomLeft.setLayout(new AbsoluteLayout());

        lblBottomLeft.setFont(new Font("Tahoma", 1, 12));
        pBottomLeft.add(lblBottomLeft, new AbsoluteConstraints(20, 0, -1, 16));

        lblBottomLeftAmount.setFont(new Font("Tahoma", 1, 12));
        lblBottomLeftAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBottomLeftAmount.setText("0.00");
        pBottomLeft.add(lblBottomLeftAmount, new AbsoluteConstraints(150, 0, 120, -1));

        TablePanel.add(pBottomLeft, new AbsoluteConstraints(30, 174, 290, -1));

        pBottomRight.setLayout(new AbsoluteLayout());

        lblBottomRight.setFont(new Font("Tahoma", 1, 12));
        pBottomRight.add(lblBottomRight, new AbsoluteConstraints(20, 0, -1, 16));

        lblBottomRightAmount.setFont(new Font("Tahoma", 1, 12));
        lblBottomRightAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBottomRightAmount.setText("0.00");
        pBottomRight.add(lblBottomRightAmount, new AbsoluteConstraints(150, 0, 120, -1));

        TablePanel.add(pBottomRight, new AbsoluteConstraints(390, 174, 290, -1));

        tblTopLeft = new JTable()
        {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex)
            {

                return false;

            }

        };
        tblTopLeft.getTableHeader().setResizingAllowed(false);
        tblTopLeft.getTableHeader().setReorderingAllowed(false);
        tblTopLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblTopLeft.setFont(new Font("Tahoma", 0, 11));
        spTopLeft.setViewportView(tblTopLeft);

        TablePanel.add(spTopLeft, new AbsoluteConstraints(30, 30, 310, 120));

        tblTopRight = new JTable()
        {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex)
            {

                return false;

            }

        };
        tblTopRight.getTableHeader().setResizingAllowed(false);
        tblTopRight.getTableHeader().setReorderingAllowed(false);
        tblTopRight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblTopRight.setFont(new Font("Tahoma", 0, 11));
        spTopRight.setViewportView(tblTopRight);

        TablePanel.add(spTopRight, new AbsoluteConstraints(390, 30, 310, 120));

        tblBottomLeft = new JTable()
        {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex)
            {

                return false;

            }

        };
        tblBottomLeft.getTableHeader().setResizingAllowed(false);
        tblBottomLeft.getTableHeader().setReorderingAllowed(false);
        tblBottomLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblBottomLeft.setFont(new Font("Tahoma", 0, 11));
        spBottomLeft.setViewportView(tblBottomLeft);

        TablePanel.add(spBottomLeft, new AbsoluteConstraints(30, 200, 310, 120));

        tblBottomRight = new JTable()
        {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex)
            {

                return false;

            }

        };
        tblBottomRight.getTableHeader().setResizingAllowed(false);
        tblBottomRight.getTableHeader().setReorderingAllowed(false);
        tblBottomRight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblBottomRight.setFont(new Font("Tahoma", 0, 11));
        spBottomRight.setViewportView(tblBottomRight);

        TablePanel.add(spBottomRight, new AbsoluteConstraints(390, 200, 310, 120));

        BodyPanel.add(TablePanel, new AbsoluteConstraints(60, 210, 740, 330));

        btnGraph.setContentAreaFilled(false);
        btnGraph.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnGraph, new AbsoluteConstraints(90, 560, -1, -1));

        btnDelete.setContentAreaFilled(false);
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnDelete, new AbsoluteConstraints(290, 560, -1, -1));

        btnToday.setContentAreaFilled(false);
        btnToday.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnToday.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                btnTodayMouseEntered(evt);
            }

        });
        btnToday.addActionListener((ActionEvent evt)
                ->
        {
            btnTodayActionPerformed(evt);
                });
        BodyPanel.add(btnToday, new AbsoluteConstraints(270, 160, 80, 30));

        btnDeleteAll.setContentAreaFilled(false);
        btnDeleteAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnDeleteAll, new AbsoluteConstraints(390, 560, -1, -1));

        lblDate.setFont(new Font("Arial", 1, 14));
        lblDate.setText("Date:");
        BodyPanel.add(lblDate, new AbsoluteConstraints(90, 170, -1, 20));

        lblBalance.setFont(new Font("Arial", 1, 13));
        lblBalance.setText("BALANCE:");
        BodyPanel.add(lblBalance, new AbsoluteConstraints(560, 570, -1, 20));

        lblTotal.setFont(new Font("Arial", 1, 24));
        BodyPanel.add(lblTotal, new AbsoluteConstraints(710, 560, -1, 30));

        getContentPane().add(BodyPanel, new AbsoluteConstraints(0, 30, 850, 620));

        pack();
        setLocationRelativeTo(null);

    }

    private void btnMinimizeActionPerformed(ActionEvent evt)
    {

        setState(ICONIFIED);

    }

    private void btnCloseFocusGained(FocusEvent evt)
    {

        btnClose.setForeground(new Color(255, 51, 51));

    }

    private void btnCloseFocusLost(FocusEvent evt)
    {

        btnClose.setForeground(new Color(240, 240, 240));

    }

    private void btnCloseMouseEntered(MouseEvent evt)
    {

        btnClose.setForeground(new Color(255, 51, 51));

    }

    private void btnCloseMouseExited(MouseEvent evt)
    {

        btnClose.setForeground(new Color(240, 240, 240));

    }

    private void btnCloseActionPerformed(ActionEvent evt)
    {

        final int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Log Out", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (response)
        {

            case JOptionPane.YES_OPTION:
                dispose();
                final MainScreen mainScreen = new MainScreen();
                mainScreen.setVisible(true);
                break;

            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;

            case JOptionPane.CANCEL_OPTION:
                break;

            case JOptionPane.CLOSED_OPTION:
                break;
        }

    }

    private void lblHeadMousePressed(MouseEvent evt)
    {

        currentXPosition = evt.getX();
        currentYPosition = evt.getY();

    }

    private void lblHeadMouseDragged(MouseEvent evt)
    {

        final int futureXPosition = evt.getXOnScreen();
        final int futureYPosition = evt.getYOnScreen();

        setLocation(futureXPosition - currentXPosition, futureYPosition
                                                                - currentYPosition);

    }

    private void btnModeActionPerformed(ActionEvent evt)
    {

        switch (current)
        {

            case 0:
                onNightMode();
                current = 1;
                break;

            case 1:
                onDayMode();
                current = 0;
                break;

        }

        pref.putInt("current", current);

    }

    private void btnBackActionPerformed(ActionEvent evt)
    {

        dispose();

        final HomeScreen homeScreen = new HomeScreen();
        homeScreen.setVisible(true);

    }

    private void btnCalculatorActionPerformed(ActionEvent evt)
    {

        try
        {

            Runtime.getRuntime().exec("calc");

        }
        catch (IOException ex)
        {

            Logger.getLogger(ExpensesScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void btnTodayMouseEntered(MouseEvent evt)
    {

        setSelected(true);
        loadExpenses();

    }

    private void btnTodayActionPerformed(ActionEvent evt)
    {

        cmbCategory.grabFocus();
        onToday();
        loadExpenses();

    }

    private void btnClearFocusLost(FocusEvent evt)
    {

        cmbCategory.grabFocus();

    }

    private void btnClearActionPerformed(ActionEvent evt)
    {

        onClear();

    }

    private void cmbCategoryFocusGained(FocusEvent evt)
    {

        cmbCategory.setForeground(Color.BLACK);

    }

    private void cmbCategoryFocusLost(FocusEvent evt)
    {

        if (cmbCategory.getSelectedIndex() != 0)
            cmbCategory.setForeground(new Color(50, 166, 248));

        else
            cmbCategory.setForeground(new Color(255, 51, 51));

    }

    private void tfQuantityFocusGained(FocusEvent evt)
    {

        tfQuantity.setHorizontalAlignment(JTextField.CENTER);
        tfQuantity.setForeground(new Color(50, 166, 248));
        tfQuantity.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(50, 166, 248)));
        tfQuantity.setText("");

    }

    private void tfQuantityFocusLost(FocusEvent evt)
    {

        tfQuantity.setHorizontalAlignment(JTextField.TRAILING);
        tfQuantity.setBorder(BorderFactory.createLineBorder(new Color(50, 166, 248)));

        final String quantity = tfQuantity.getText();

        tfQuantity.setText(!quantity.equals("")
                           ? quantity
                           : "1");

        if (Integer.parseInt(tfQuantity.getText()) == 0)
        {

            tfQuantity.setForeground(new Color(255, 51, 51));
            tfQuantity.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));

        }

        if (quantity.startsWith("0") && quantity.length() == 2)
        {

            final int _quantity = Integer.parseInt(quantity);
            tfQuantity.setText(String.valueOf(_quantity));

        }

    }

    private void tfQuantityKeyTyped(KeyEvent evt)
    {

        final char input = evt.getKeyChar();

        if (!Character.isDigit(input)
                    || input == KeyEvent.VK_BACK_SPACE
                    || tfQuantity.getText().length() > 1)
            evt.consume();

    }

    private void tfAmountFocusGained(FocusEvent evt)
    {

        tfAmount.setHorizontalAlignment(JTextField.CENTER);
        tfAmount.setForeground(new Color(50, 166, 248));
        tfAmount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(50, 166, 248)));
        tfAmount.setText("");

    }

    private void tfAmountFocusLost(FocusEvent evt)
    {

        tfAmount.setHorizontalAlignment(JTextField.TRAILING);
        tfAmount.setBorder(BorderFactory.createLineBorder(new Color(50, 166, 248)));

        final String amount = tfAmount.getText();

        if (amount.equals("") || Integer.parseInt(amount) == 0)
        {

            tfAmount.setText("0.00");
            tfAmount.setForeground(new Color(255, 51, 51));
            tfAmount.setBorder(BorderFactory.createLineBorder(new Color(255, 51, 51)));

        }

        else
        {

            tfAmount.setText(String.format("%.2f", Double.parseDouble(amount)));
            tfAmount.setBorder(BorderFactory.createLineBorder(new Color(50, 166, 248)));

        }

    }

    private void tfAmountKeyTyped(KeyEvent evt)
    {

        final char input = evt.getKeyChar();

        if (!Character.isDigit(input)
                    || input == KeyEvent.VK_BACK_SPACE)
            evt.consume();

    }

    private void tfDescriptionFocusGained(FocusEvent evt)
    {

        tfDescription.setHorizontalAlignment(JTextField.CENTER);
        tfDescription.setForeground(new Color(50, 166, 248));
        tfDescription.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(50, 166, 248)));
        tfDescription.setText("");

    }

    private void tfDescriptionFocusLost(FocusEvent evt)
    {

        tfDescription.setHorizontalAlignment(JTextField.LEADING);

        final String description = tfDescription.getText().trim();

        if (description.equals(""))
        {

            tfDescription.setText("What's expense did you make? (Optional)");
            tfDescription.setForeground(Color.GRAY);
            tfDescription.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        }
        else
            tfDescription.setBorder(BorderFactory.createLineBorder(new Color(50, 166, 248)));

    }

    private void tfDescriptionKeyTyped(KeyEvent evt)
    {

        final char input = evt.getKeyChar();

        if (!Character.isAlphabetic(input)
                    || input == KeyEvent.VK_BACK_SPACE)
            evt.consume();

    }

    private void btnAddActionPerformed(ActionEvent evt)
    {

        final String category = String.valueOf(cmbCategory.getSelectedItem());
        final int quantity = Integer.parseInt(tfQuantity.getText());
        final double amount = Double.parseDouble(tfAmount.getText());
        final String description = tfDescription.getText().trim();

        if (category.equals("<Choose>")
                    || quantity == 0
                    || amount == 0)
            JOptionPane.showMessageDialog(null, "All fields are required!");

        else
            onAdd(category, quantity, amount, description);

    }

    private void chkTopLeftItemStateChanged(ItemEvent evt)
    {

        onSelected(chkTopLeft, lblTopLeftAmount, tblTopLeft);

    }

    private void chkTopRightItemStateChanged(ItemEvent evt)
    {

        onSelected(chkTopRight, lblTopRightAmount, tblTopRight);

    }

    private void chkBottomLeftItemStateChanged(ItemEvent evt)
    {

        onSelected(chkBottomLeft, lblBottomLeftAmount, tblBottomLeft);

    }

    private void chkBottomRightItemStateChanged(ItemEvent evt)
    {

        onSelected(chkBottomRight, lblBottomRightAmount, tblBottomRight);

    }

    public static void main(String args[])
    {

        try
        {

            for (UIManager.LookAndFeelInfo info
                         : UIManager.getInstalledLookAndFeels())
                if ("Windows".equals(info.getName()))
                {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }

        }
        catch (ClassNotFoundException
               | InstantiationException
               | IllegalAccessException
               | UnsupportedLookAndFeelException ex)
        {

            Logger.getLogger(ExpensesScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new ExpensesScreen().setVisible(true);

                });

    }

    private void initInstances()
    {

        expenseTracker = new ExpenseTracker();
        pref = Preferences.userNodeForPackage(Class.class);
        current = pref.getInt("current", 0);
        user_id = pref.getInt("user_id", 0);
        conn = SQLite.getInstance();

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(expenseTracker.getString("logo"))));
        lblHead.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("head"))));

        switch (current)
        {

            case 0:
                onDayMode();
                break;

            case 1:
                onNightMode();
                break;

        }

    }

    private void initTable()
    {

        lblTopLeft.setText(cmbCategory.getItemAt(1));
        lblTopRight.setText(cmbCategory.getItemAt(2));
        lblBottomLeft.setText(cmbCategory.getItemAt(3));
        lblBottomRight.setText(cmbCategory.getItemAt(4));

        final Object col[] =
        {
            "ID",
            "QTY",
            "AMOUNT",
            "DESCRIPTION"
        };

        modelTopLeft.setColumnIdentifiers(col);
        modelTopRight.setColumnIdentifiers(col);
        modelBottomLeft.setColumnIdentifiers(col);
        modelBottomRight.setColumnIdentifiers(col);

        tblTopLeft.setModel(modelTopLeft);
        tblTopLeft.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblTopLeft.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblTopLeft.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblTopLeft.getColumnModel().getColumn(3).setPreferredWidth(140);

        tblTopRight.setModel(modelTopRight);
        tblTopRight.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblTopRight.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblTopRight.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblTopRight.getColumnModel().getColumn(3).setPreferredWidth(140);

        tblBottomLeft.setModel(modelBottomLeft);
        tblBottomLeft.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblBottomLeft.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblBottomLeft.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblBottomLeft.getColumnModel().getColumn(3).setPreferredWidth(140);

        tblBottomRight.setModel(modelBottomRight);
        tblBottomRight.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblBottomRight.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblBottomRight.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblBottomRight.getColumnModel().getColumn(3).setPreferredWidth(140);

    }

    private void onDayMode()
    {

        BodyPanel.setBackground(new Color(240, 240, 240));
        TablePanel.setBackground(new Color(240, 240, 240));
        DataPanel.setBackground(new Color(225, 225, 225));

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("moon"))));
        btnBack.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("dayback"))));
        btnCalculator.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daycalculator"))));
        btnClear.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("dayclear"))));
        btnAdd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("dayadd"))));

        lblTitle.setForeground(new Color(0, 0, 0));
        lblCategory.setForeground(new Color(0, 0, 0));
        lblQuantity.setForeground(new Color(0, 0, 0));
        lblAmount.setForeground(new Color(0, 0, 0));
        lblDescription.setForeground(new Color(0, 0, 0));
        lblDate.setForeground(new Color(0, 0, 0));
        lblBalance.setForeground(new Color(0, 0, 0));
        lblTotal.setForeground(new Color(0, 0, 0));

        btnGraph.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daygraph"))));
        btnDelete.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daydelete"))));
        btnDeleteAll.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daydeleteall"))));
        btnToday.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daytoday"))));
        chkTopLeft.setBackground(new Color(240, 240, 240));
        chkTopRight.setBackground(new Color(240, 240, 240));
        chkBottomLeft.setBackground(new Color(240, 240, 240));
        chkBottomRight.setBackground(new Color(240, 240, 240));

        pTopLeft.setBackground(new Color(50, 166, 248));
        pTopRight.setBackground(new Color(50, 166, 248));
        pBottomLeft.setBackground(new Color(50, 166, 248));
        pBottomRight.setBackground(new Color(50, 166, 248));
        lblTopLeft.setForeground(new Color(0, 0, 0));
        lblTopLeftAmount.setForeground(new Color(0, 0, 0));
        lblTopRight.setForeground(new Color(0, 0, 0));
        lblTopRightAmount.setForeground(new Color(0, 0, 0));
        lblBottomLeft.setForeground(new Color(0, 0, 0));
        lblBottomLeftAmount.setForeground(new Color(0, 0, 0));
        lblBottomRight.setForeground(new Color(0, 0, 0));
        lblBottomRightAmount.setForeground(new Color(0, 0, 0));

        tfQuantity.setBackground(new Color(225, 225, 225));
        tfAmount.setBackground(new Color(225, 225, 225));
        tfDescription.setBackground(new Color(225, 225, 225));

    }

    private void onNightMode()
    {

        BodyPanel.setBackground(new Color(41, 41, 41));
        TablePanel.setBackground(new Color(41, 41, 41));
        DataPanel.setBackground(new Color(62, 62, 62));

        lblTitle.setForeground(new Color(51, 153, 255));
        lblCategory.setForeground(new Color(204, 204, 204));
        lblQuantity.setForeground(new Color(204, 204, 204));
        lblAmount.setForeground(new Color(204, 204, 204));
        lblDescription.setForeground(new Color(204, 204, 204));
        lblDate.setForeground(new Color(204, 204, 204));
        lblBalance.setForeground(new Color(204, 204, 204));
        lblTotal.setForeground(new Color(204, 204, 204));

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("sun"))));
        btnBack.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightback"))));
        btnCalculator.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightcalculator"))));
        btnClear.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightclear"))));
        btnAdd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightadd"))));

        btnGraph.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightgraph"))));
        btnDelete.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightdelete"))));
        btnDeleteAll.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightdeleteall"))));
        btnToday.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nighttoday"))));
        chkBottomRight.setBackground(new Color(41, 41, 41));
        chkTopLeft.setBackground(new Color(41, 41, 41));
        chkTopRight.setBackground(new Color(41, 41, 41));
        chkBottomLeft.setBackground(new Color(41, 41, 41));

        pTopLeft.setBackground(new Color(39, 71, 217));
        pTopRight.setBackground(new Color(39, 71, 217));
        pBottomLeft.setBackground(new Color(39, 71, 217));
        pBottomRight.setBackground(new Color(39, 71, 217));
        lblTopLeft.setForeground(new Color(204, 204, 204));
        lblTopLeftAmount.setForeground(new Color(204, 204, 204));
        lblTopRightAmount.setForeground(new Color(204, 204, 204));
        lblTopRight.setForeground(new Color(204, 204, 204));
        lblBottomLeftAmount.setForeground(new Color(204, 204, 204));
        lblBottomLeft.setForeground(new Color(204, 204, 204));
        lblBottomRightAmount.setForeground(new Color(204, 204, 204));
        lblBottomRight.setForeground(new Color(204, 204, 204));

        tfQuantity.setBackground(new Color(62, 62, 62));
        tfAmount.setBackground(new Color(62, 62, 62));
        tfDescription.setBackground(new Color(62, 62, 62));

    }

    private void onToday()
    {

        final long millis = System.currentTimeMillis();

        Date date = new Date(millis);
        dcDate.setDate(date);

    }

    private void onClear()
    {

        cmbCategory.grabFocus();
        tfQuantity.setText("1");
        tfQuantity.setHorizontalAlignment(JTextField.TRAILING);
        tfAmount.setText("0.00");
        tfAmount.setHorizontalAlignment(JTextField.TRAILING);
        tfDescription.setText("What's expense did you make? (Optional)");
        tfDescription.setHorizontalAlignment(JTextField.LEADING);

        tfQuantity.setForeground(Color.GRAY);
        tfQuantity.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tfAmount.setForeground(Color.GRAY);
        tfAmount.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tfDescription.setForeground(Color.GRAY);
        tfDescription.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }

    private void onAdd(final String category, final int quantity, final double amount, final String description)
    {

        final String sql = "INSERT INTO Expenses (user_id, expense_category, expense_quantity, expense_amount, expense_description, expense_date) VALUES (?,?,?,?,?,?)";

        try
        {

            ps = conn.prepareStatement(sql);
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            final String date = simpleDateFormat.format(dcDate.getDate());

            ps.setInt(1, user_id);
            ps.setString(2, category);
            ps.setInt(3, quantity);
            ps.setDouble(4, amount);
            ps.setString(5, !description.equals("What's expense did you make? (Optional)")
                            ? description
                            : "");
            ps.setString(6, date);
            ps.execute();
            ps.close();

            onClear();
            loadExpenses();

        }
        catch (HeadlessException
               | SQLException ex)
        {

            JOptionPane.showMessageDialog(null, "Please Contact Your Service Provider");
            conn = SQLite.getInstance();

        }

    }

    private void loadExpenses()
    {

        final String sql = "SELECT * FROM Expenses WHERE user_id=? AND expense_date=?";
        final SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String date = SimpleDateFormat.format(dcDate.getDate());
        final String topLeft = lblTopLeft.getText();
        final String topRight = lblTopRight.getText();
        final String bottomLeft = lblBottomLeft.getText();
        final String bottomRight = lblBottomRight.getText();

        modelTopLeft.setRowCount(0);
        modelTopRight.setRowCount(0);
        modelBottomLeft.setRowCount(0);
        modelBottomRight.setRowCount(0);

        try
        {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, date);

            rs = ps.executeQuery();
            Object[] ColumnData = new Object[4];
            while (rs.next())
            {

                ColumnData[0] = rs.getString("expense_id");
                ColumnData[1] = rs.getString("expense_quantity");
                ColumnData[2] = rs.getString("expense_amount");
                ColumnData[3] = rs.getString("expense_description");

                if (topLeft.equals(rs.getString("expense_category")))
                    modelTopLeft.addRow(ColumnData);
                else if (topRight.equals(rs.getString("expense_category")))
                    modelTopRight.addRow(ColumnData);
                else if (bottomLeft.equals(rs.getString("expense_category")))
                    modelBottomLeft.addRow(ColumnData);
                else if (bottomRight.equals(rs.getString("expense_category")))
                    modelBottomRight.addRow(ColumnData);

                onSelected(chkTopLeft, lblTopLeftAmount, tblTopLeft);
                onSelected(chkTopRight, lblTopRightAmount, tblTopRight);
                onSelected(chkBottomLeft, lblBottomLeftAmount, tblBottomLeft);
                onSelected(chkBottomRight, lblBottomRightAmount, tblBottomRight);
                getTotal();

            }

        }
        catch (SQLException ex)
        {

            JOptionPane.showMessageDialog(null, "Please Contact Your Service Provider");
            conn = SQLite.getInstance();

        }

    }

    private void onSelected(final JCheckBox chk, final JLabel lblAmount, final JTable tbl)
    {

        if (chk.isSelected())
        {

            lblAmount.setText(expenseTracker.getSum(tbl));
            tbl.setVisible(true);

        }

        else
        {

            lblAmount.setText("0.00");
            tbl.setVisible(false);

        }

        getTotal();

    }

    private void getTotal()
    {

        final double topLeftAmount = Double.parseDouble(lblTopLeftAmount.getText());
        final double topRightAmount = Double.parseDouble(lblTopRightAmount.getText());
        final double bottomLeftAmount = Double.parseDouble(lblBottomLeftAmount.getText());
        final double bottomRightAmount = Double.parseDouble(lblBottomRightAmount.getText());

        lblTotal.setText(String.format("%.2f", topLeftAmount
                                                       + topRightAmount
                                                       + bottomLeftAmount
                                                       + bottomRightAmount));

    }

    private void setSelected(final boolean isSelected)
    {

        chkTopLeft.setSelected(isSelected);
        chkTopRight.setSelected(isSelected);
        chkBottomLeft.setSelected(isSelected);
        chkBottomRight.setSelected(isSelected);

    }

}
