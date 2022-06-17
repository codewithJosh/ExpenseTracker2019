package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.ExpenseTracker;
import org.netbeans.lib.awtextra.*;

public class HomeScreen extends JFrame
{

    private JPanel BodyPanel;
    private JButton nav;
    private JPanel HeadPanel;
    private JButton btnClose;
    private JButton btnMinimize;
    private JLabel lblBackground;
    private JLabel lblHead;
    private JLabel lblStart;
    private JLabel lblCenterStart;
    private JLabel lblCenterEnd;
    private JLabel lblTitle;
    private JLabel lblProjectTitle;
    private JLabel lblEnd;
    private JButton btnMode;
    private JButton btnNext;
    private JButton btnPrevious;
    private JTextArea taDescription;

    ExpenseTracker expenseTracker;
    static int currentXPosition = 0;
    static int currentYPosition = 0;
    int current = 0;
    int position = 0;
    Preferences pref;

    public HomeScreen()
    {

        initComponents();
        initInstances();
        initIcons();

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
        lblTitle = new JLabel();
        taDescription = new JTextArea();
        btnPrevious = new JButton();
        btnNext = new JButton();
        nav = new JButton();
        lblStart = new JLabel();
        lblCenterStart = new JLabel();
        lblCenterEnd = new JLabel();
        lblEnd = new JLabel();
        lblBackground = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        HeadPanel.setBackground(new Color(44, 59, 255));
        HeadPanel.setLayout(new AbsoluteLayout());

        lblProjectTitle.setText("Expense Tracker");
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

        btnMinimize.setFont(new Font("Tahoma", 1, 18));
        btnMinimize.setForeground(new Color(240, 240, 240));
        btnMinimize.setText("—");
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.addActionListener((ActionEvent evt)
                ->
        {
            btnMinimizeActionPerformed(evt);
                });
        HeadPanel.add(btnMinimize, new AbsoluteConstraints(310, 0, -1, 30));

        btnClose.setFont(new Font("Tahoma", 1, 14));
        btnClose.setForeground(new Color(240, 240, 240));
        btnClose.setText("X");
        btnClose.setContentAreaFilled(false);
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
        HeadPanel.add(btnClose, new AbsoluteConstraints(356, 0, -1, 30));

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
        HeadPanel.add(lblHead, new AbsoluteConstraints(0, 0, 400, 30));

        getContentPane().add(HeadPanel, new AbsoluteConstraints(0, 0, -1, 30));

        BodyPanel.setForeground(new Color(240, 240, 240));
        BodyPanel.setLayout(new AbsoluteLayout());

        lblTitle.setFont(new Font("Tahoma", 0, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        BodyPanel.add(lblTitle, new AbsoluteConstraints(90, 140, 220, -1));

        taDescription.setEditable(false);
        taDescription.setColumns(20);
        taDescription.setFont(new Font("Monospaced", 1, 14));
        taDescription.setForeground(Color.WHITE);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setWrapStyleWord(true);
        taDescription.setFocusable(false);
        taDescription.setOpaque(false);
        BodyPanel.add(taDescription, new AbsoluteConstraints(90, 190, 220, -1));

        btnPrevious.addActionListener((ActionEvent evt)
                ->
        {
            btnPreviousActionPerformed(evt);
                });
        btnPrevious.setFont(new Font("Arial Narrow", 2, 48));
        btnPrevious.setContentAreaFilled(false);
        btnPrevious.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPrevious.setText("<");
        BodyPanel.add(btnPrevious, new AbsoluteConstraints(25, 200, -1, 50));

        btnNext.addActionListener((ActionEvent evt)
                ->
        {
            btnNextActionPerformed(evt);
                });
        btnNext.setFont(new Font("Arial Narrow", 2, 48));
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.setText(">");
        BodyPanel.add(btnNext, new AbsoluteConstraints(320, 200, -1, 50));

        nav.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                navFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                navFocusLost(evt);
            }

        });
        nav.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                navMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                navMouseExited(evt);
            }

        });
        nav.addActionListener((ActionEvent evt)
                ->
        {
            navActionPerformed(evt);
                });
        nav.setContentAreaFilled(false);
        nav.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(nav, new AbsoluteConstraints(128, 300, 147, 33));

        lblStart.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                lblStartMouseEntered(evt);
            }

        });
        BodyPanel.add(lblStart, new AbsoluteConstraints(30, 450, 85, 10));

        lblCenterStart.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                lblCenterStartMouseEntered(evt);
            }

        });
        BodyPanel.add(lblCenterStart, new AbsoluteConstraints(114, 450, 85, 10));

        lblCenterEnd.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                lblCenterEndMouseEntered(evt);
            }

        });
        BodyPanel.add(lblCenterEnd, new AbsoluteConstraints(197, 450, 85, 10));

        lblEnd.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                lblEndMouseEntered(evt);
            }

        });
        BodyPanel.add(lblEnd, new AbsoluteConstraints(280, 450, 85, 10));
        BodyPanel.add(lblBackground, new AbsoluteConstraints(30, 50, 340, 365));

        getContentPane().add(BodyPanel, new AbsoluteConstraints(0, 30, 400, 520));

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

    private void lblStartMouseEntered(MouseEvent evt)
    {

        onIntroduction();

    }

    private void lblCenterStartMouseEntered(MouseEvent evt)
    {

        onIncome();

    }

    private void lblCenterEndMouseEntered(MouseEvent evt)
    {

        onBudget();

    }

    private void lblEndMouseEntered(MouseEvent evt)
    {

        onExpenses();

    }

    private void btnPreviousActionPerformed(ActionEvent evt)
    {

        switch (position)
        {

            case 1:
                onIntroduction();
                break;

            case 2:
                onIncome();
                break;

            case 3:
                onBudget();
                break;

        }

    }

    private void btnNextActionPerformed(ActionEvent evt)
    {

        switch (position)
        {

            case 0:
                onIncome();
                break;

            case 1:
                onBudget();
                break;

            case 2:
                onExpenses();
                break;

        }

    }

    private void navFocusGained(FocusEvent evt)
    {

        onNav();

    }

    private void navFocusLost(FocusEvent evt)
    {

        offNav();

    }

    private void navMouseEntered(MouseEvent evt)
    {

        onNav();

    }

    private void navMouseExited(MouseEvent evt)
    {

        offNav();

    }

    private void navActionPerformed(ActionEvent evt)
    {

        dispose();
        pref.putInt("position", position);

        switch (position)
        {

            case 1:
                final IncomeScreen incomeScreen = new IncomeScreen();
                incomeScreen.setVisible(true);
                break;

            case 2:
                final BudgetScreen budgetScreen = new BudgetScreen();
                budgetScreen.setVisible(true);
                break;

            case 3:
                final ExpensesScreen expensesScreen = new ExpensesScreen();
                expensesScreen.setVisible(true);
                break;

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

            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new HomeScreen().setVisible(true);

                });

    }

    private void initInstances()
    {

        expenseTracker = new ExpenseTracker();
        pref = Preferences.userNodeForPackage(Class.class);
        current = pref.getInt("current", 0);
        position = pref.getInt("position", 0);

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(expenseTracker.getString("logo"))));
        lblHead.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("head"))));

        switch (position)
        {

            case 0:
                onIntroduction();
                break;

            case 1:
                onIncome();
                break;

            case 2:
                onBudget();
                break;

            case 3:
                onExpenses();
                break;

        }

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

    private void onDayMode()
    {

        BodyPanel.setBackground(new Color(240, 240, 240));
        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("moon"))));
        btnNext.setForeground(new Color(240, 240, 240));
        btnPrevious.setForeground(new Color(240, 240, 240));

    }

    private void onNightMode()
    {

        BodyPanel.setBackground(new Color(41, 41, 41));
        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("sun"))));
        btnNext.setForeground(new Color(130, 130, 130));
        btnPrevious.setForeground(new Color(130, 130, 130));

    }

    private void onIntroduction()
    {

        final String title = "Expense Tracker";
        final String description = "Welcome to Expense Tracker! Try out managing your money through our Expense Tracker. Special features presents Budget Management and Income Management.";

        lblBackground.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("background01"))));
        lblStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("starthover"))));
        lblCenterStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblCenterEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("end"))));
        lblTitle.setText(title);
        taDescription.setText(description);
        btnPrevious.setVisible(false);
        btnNext.setVisible(true);
        nav.setVisible(false);

        position = 0;

    }

    private void onIncome()
    {

        final String title = "Income Manager";
        final String description = "Hello! here you will see income progress of yours. Try me!";

        lblBackground.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("background02"))));
        lblStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("start"))));
        lblCenterStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("centerhover"))));
        lblCenterEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("end"))));
        nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("income"))));
        lblTitle.setText(title);
        taDescription.setText(description);
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
        nav.setVisible(true);

        position = 1;

    }

    private void onBudget()
    {

        final String title = "Financial Plan";
        final String description = "Hello! here you can budget your own money to handle it well. Try me!";

        lblBackground.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("background03"))));
        lblStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("start"))));
        lblCenterStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblCenterEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("centerhover"))));
        lblEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("end"))));
        nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("budget"))));
        lblTitle.setText(title);
        taDescription.setText(description);
        btnPrevious.setVisible(true);
        btnNext.setVisible(true);
        nav.setVisible(true);

        position = 2;

    }

    private void onExpenses()
    {

        final String title = "Expenses";
        final String description = "Hello! here you can monitor, record and compute your expenses. Try me!";

        lblBackground.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("background04"))));
        lblStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("start"))));
        lblCenterStart.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblCenterEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("center"))));
        lblEnd.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("endhover"))));
        nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("expenses"))));
        lblTitle.setText(title);
        taDescription.setText(description);
        btnPrevious.setVisible(true);
        btnNext.setVisible(false);
        nav.setVisible(true);

        position = 3;

    }

    private void onNav()
    {

        switch (position)
        {

            case 1:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("incomehover"))));
                break;

            case 2:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("budgethover"))));
                break;

            case 3:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("expenseshover"))));
                break;

        }

    }

    private void offNav()
    {

        switch (position)
        {

            case 1:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("income"))));
                break;

            case 2:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("budget"))));
                break;

            case 3:
                nav.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("expenses"))));
                break;

        }

    }

}
