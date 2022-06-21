package main.java.com.codewithjosh.ExpenseTracker2k19;

import com.toedter.calendar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.ExpenseTracker;
import org.netbeans.lib.awtextra.*;

public class BudgetScreen extends JFrame
{

    private JPanel BodyPanel;
    private JPanel DataPanel;
    private JPanel HeadPanel;
    private JButton btnAdd;
    private JButton btnBack;
    private JButton btnCalculator;
    private JButton btnClear;
    private JComboBox<String> cmbCategory;
    private JDateChooser dcFrom;
    private JDateChooser dcTo;
    private JButton btnDeleteAll;
    private JButton btnDelete;
    private JButton btnClose;
    private JButton btnGraph;
    private JButton btnMinimize;
    private JScrollPane sp;
    private JSeparator s;
    private JLabel lblTotal;
    private JLabel lblHead;
    private JLabel lblProjectTitle;
    private JButton btnMode;
    private JTable tbl;
    private JLabel lblCategory;
    private JLabel lblFrom;
    private JLabel lblAmount;
    private JLabel lblTo;
    private JLabel lblDate;
    private JLabel lblBalance;
    private JLabel lblTitle;
    private JTextField tfAmount;

    ExpenseTracker expenseTracker;
    DefaultTableModel model = new DefaultTableModel();
    static int currentXPosition = 0;
    static int currentYPosition = 0;
    Preferences pref;
    int user_id = 0;
    boolean isNightMode = false;

    public BudgetScreen()
    {

        initComponents();
        initInstances();
        initIcons();
        initTable();

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
        lblFrom = new JLabel();
        lblAmount = new JLabel();
        lblTo = new JLabel();
        lblDate = new JLabel();
        cmbCategory = new JComboBox<>();
        tfAmount = new JTextField();
        s = new JSeparator();
        btnBack = new JButton();
        btnAdd = new JButton();
        btnClear = new JButton();
        btnCalculator = new JButton();
        dcFrom = new JDateChooser();
        dcTo = new JDateChooser();
        btnGraph = new JButton();
        btnDelete = new JButton();
        btnDeleteAll = new JButton();
        sp = new JScrollPane();
        tbl = new JTable();
        lblBalance = new JLabel();
        lblTotal = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        HeadPanel.setBackground(new Color(39, 71, 217));
        HeadPanel.setLayout(new AbsoluteLayout());

        lblProjectTitle.setText("Expense Tracker - Budget");
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
        HeadPanel.add(btnMinimize, new AbsoluteConstraints(670, 0, -1, 30));

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
        HeadPanel.add(btnClose, new AbsoluteConstraints(710, 0, -1, 30));

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
        HeadPanel.add(lblHead, new AbsoluteConstraints(0, 0, 750, 30));

        getContentPane().add(HeadPanel, new AbsoluteConstraints(0, 0, 750, -1));

        BodyPanel.setLayout(new AbsoluteLayout());

        DataPanel.setBackground(new Color(225, 225, 225));
        DataPanel.setLayout(new AbsoluteLayout());

        lblTitle.setFont(new Font("Arial", 1, 24));
        lblTitle.setText("BUDGET");
        DataPanel.add(lblTitle, new AbsoluteConstraints(60, 20, -1, -1));

        lblCategory.setFont(new Font("Arial", 1, 14));
        lblCategory.setText("Category");
        DataPanel.add(lblCategory, new AbsoluteConstraints(370, 60, -1, 20));

        lblFrom.setFont(new Font("Arial", 1, 14));
        lblFrom.setText("From");
        DataPanel.add(lblFrom, new AbsoluteConstraints(100, 60, -1, 20));

        lblAmount.setFont(new Font("Arial", 1, 14));
        lblAmount.setText("Amount");
        DataPanel.add(lblAmount, new AbsoluteConstraints(470, 60, -1, 20));

        lblTo.setFont(new Font("Arial", 1, 14));
        lblTo.setText("To");
        DataPanel.add(lblTo, new AbsoluteConstraints(230, 60, -1, 20));

        lblDate.setFont(new Font("Arial", 1, 13));
        lblDate.setText("Date:");
        DataPanel.add(lblDate, new AbsoluteConstraints(60, 90, -1, 20));

        cmbCategory.setFont(new Font("Tahoma", 0, 12));
        cmbCategory.setModel(new DefaultComboBoxModel<>(new String[]
        {
            "<Choose>",
            "TRAVEL",
            "SHOPPING",
            "FOODS",
            "OTHERS"
        }));
        DataPanel.add(cmbCategory, new AbsoluteConstraints(370, 80, 90, 30));

        tfAmount.setBorder(null);
        DataPanel.add(tfAmount, new AbsoluteConstraints(470, 80, 100, 30));
        DataPanel.add(s, new AbsoluteConstraints(50, 120, 660, 10));

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
        DataPanel.add(btnAdd, new AbsoluteConstraints(580, 80, 30, 30));

        btnClear.setContentAreaFilled(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DataPanel.add(btnClear, new AbsoluteConstraints(620, 80, 80, 30));

        btnCalculator.setContentAreaFilled(false);
        btnCalculator.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalculator.addActionListener((ActionEvent evt)
                ->
        {
            btnCalculatorActionPerformed(evt);
                });
        DataPanel.add(btnCalculator, new AbsoluteConstraints(680, 30, -1, -1));

        dcFrom.setDateFormatString("yyyy-MM-dd");
        ((JTextFieldDateEditor) dcFrom.getDateEditor()).setEditable(false);
        DataPanel.add(dcFrom, new AbsoluteConstraints(100, 80, 120, 30));

        dcTo.setDateFormatString("yyyy-MM-dd");
        ((JTextFieldDateEditor) dcTo.getDateEditor()).setEditable(false);
        DataPanel.add(dcTo, new AbsoluteConstraints(230, 80, 120, 30));

        BodyPanel.add(DataPanel, new AbsoluteConstraints(0, 0, 750, -1));

        btnGraph.setContentAreaFilled(false);
        btnGraph.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnGraph, new AbsoluteConstraints(180, 360, -1, -1));

        btnDelete.setContentAreaFilled(false);
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnDelete, new AbsoluteConstraints(380, 360, -1, -1));

        btnDeleteAll.setContentAreaFilled(false);
        btnDeleteAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnDeleteAll, new AbsoluteConstraints(480, 360, -1, -1));

        tbl = new JTable()
        {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex)
            {

                return false;

            }

        };
        tbl.getTableHeader().setResizingAllowed(false);
        tbl.getTableHeader().setReorderingAllowed(false);
        tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl.setFont(new Font("Tahoma", 0, 11));
        sp.setViewportView(tbl);

        BodyPanel.add(sp, new AbsoluteConstraints(50, 150, 660, 190));

        lblBalance.setFont(new Font("Arial", 1, 13));
        lblBalance.setText("BALANCE:");
        BodyPanel.add(lblBalance, new AbsoluteConstraints(480, 420, -1, 20));

        lblTotal.setFont(new Font("Arial", 1, 24));
        BodyPanel.add(lblTotal, new AbsoluteConstraints(630, 410, -1, 30));

        getContentPane().add(BodyPanel, new AbsoluteConstraints(0, 30, 750, 470));

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

        final int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Log Out", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (response)
        {

            case JOptionPane.YES_OPTION:
                dispose();
                pref.putInt("user_id", 0);
                new MainScreen().setVisible(true);
                break;

            case JOptionPane.NO_OPTION:
                System.exit(0);
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

        isNightMode = !isNightMode;
        onMode();
        pref.putBoolean("isNightMode", isNightMode);

    }

    private void btnBackActionPerformed(ActionEvent evt)
    {

        dispose();
        new HomeScreen().setVisible(true);

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

            Logger.getLogger(BudgetScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new BudgetScreen().setVisible(true);

                });

    }

    private void initInstances()
    {

        expenseTracker = new ExpenseTracker();
        pref = Preferences.userNodeForPackage(Class.class);
        user_id = pref.getInt("user_id", 0);
        isNightMode = pref.getBoolean("isNightMode", false);

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(expenseTracker.getString("logo"))));
        lblHead.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("head"))));

        onMode();

    }

    private void initTable()
    {

        final Object col[] =
        {
            "ID",
            "START DATE",
            "END DATE",
            "CATEGORY",
            "AMOUNT",
            "REMARKS"
        };

        model.setColumnIdentifiers(col);

        tbl.setModel(model);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(140);

    }

    private void onMode()
    {

        final Color colorBodyPanel = isNightMode
                                     ? new Color(41, 41, 41)
                                     : new Color(240, 240, 240);

        final Color colorPrimary = isNightMode
                                   ? new Color(62, 62, 62)
                                   : new Color(225, 225, 225);

        final Color colorTitle = isNightMode
                                 ? new Color(51, 153, 255)
                                 : new Color(0, 0, 0);

        final Color colorLbl = isNightMode
                               ? new Color(204, 204, 204)
                               : new Color(0, 0, 0);

        final String mode = isNightMode
                            ? "sun"
                            : "moon";

        final String back = isNightMode
                            ? "nightback"
                            : "dayback";

        final String calculator = isNightMode
                                  ? "nightcalculator"
                                  : "daycalculator";

        final String clear = isNightMode
                             ? "nightclear"
                             : "dayclear";

        final String add = isNightMode
                           ? "nightadd"
                           : "dayadd";

        final String graph = isNightMode
                             ? "nightgraph"
                             : "daygraph";

        final String delete = isNightMode
                              ? "nightdelete"
                              : "daydelete";

        final String deleteAll = isNightMode
                                 ? "nightdeleteAll"
                                 : "daydeleteAll";

        BodyPanel.setBackground(colorBodyPanel);
        DataPanel.setBackground(colorPrimary);

        lblTitle.setForeground(colorTitle);
        lblCategory.setForeground(colorLbl);
        lblAmount.setForeground(colorLbl);
        lblDate.setForeground(colorLbl);
        lblFrom.setForeground(colorLbl);
        lblTo.setForeground(colorLbl);
        lblBalance.setForeground(colorLbl);
        lblTotal.setForeground(colorLbl);

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(mode))));
        btnBack.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(back))));
        btnCalculator.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(calculator))));
        btnClear.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(clear))));
        btnAdd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(add))));

        btnGraph.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(graph))));
        btnDelete.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(delete))));
        btnDeleteAll.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(deleteAll))));

        tfAmount.setBackground(colorPrimary);

    }

}
