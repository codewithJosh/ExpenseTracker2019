package main.java.com.codewithjosh.ExpenseTracker2k19;

import com.toedter.calendar.*;
import java.awt.*;
import java.util.logging.*;
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
        HeadPanel.add(btnMode, new AbsoluteConstraints(0, 0, 30, 30));

        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFont(new Font("Tahoma", 1, 18));
        btnMinimize.setForeground(new Color(240, 240, 240));
        btnMinimize.setText("—");
        HeadPanel.add(btnMinimize, new AbsoluteConstraints(670, 0, -1, 30));

        btnClose.setContentAreaFilled(false);
        btnClose.setFont(new Font("Tahoma", 1, 14));
        btnClose.setForeground(new Color(240, 240, 240));
        btnClose.setText("X");
        HeadPanel.add(btnClose, new AbsoluteConstraints(710, 0, -1, 30));

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
        DataPanel.add(btnBack, new AbsoluteConstraints(20, 20, -1, -1));

        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DataPanel.add(btnAdd, new AbsoluteConstraints(580, 80, 30, 30));

        btnClear.setContentAreaFilled(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DataPanel.add(btnClear, new AbsoluteConstraints(620, 80, 80, 30));

        btnCalculator.setContentAreaFilled(false);
        btnCalculator.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(expenseTracker.getString("logo"))));
        lblHead.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("head"))));

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

}
