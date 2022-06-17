package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.*;
import org.netbeans.lib.awtextra.*;

public class MainScreen extends JFrame
{

    private JPanel BodyPanel;
    private JPanel HeadPanel;
    private JButton btnClose;
    private JButton btnLogin;
    private JButton btnMinimize;
    private JButton btnMode;
    private JLabel lblHead;
    private JLabel lblLogo;
    private JLabel lblPassword;
    private JLabel lblProjectName;
    private JLabel lblProjectTitle;
    private JLabel lblQuestion;
    private JLabel lblTail;
    private JLabel lblUsername;
    private JButton navRegister;
    private JPasswordField pfPassword;
    private JTextField tfUsername;

    ExpenseTracker expenseTracker;
    static int currentXPosition = 0;
    static int currentYPosition = 0;
    int future = 0;
    int current = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Preferences pref;

    public MainScreen()
    {

        initComponents();
        initInstances();
        initIcons();

    }

    private void initComponents()
    {

        HeadPanel = new JPanel();
        lblProjectTitle = new JLabel();
        btnMinimize = new JButton();
        btnClose = new JButton();
        lblHead = new JLabel();
        BodyPanel = new JPanel();
        lblQuestion = new JLabel();
        navRegister = new JButton();
        btnMode = new JButton();
        lblTail = new JLabel();
        lblLogo = new JLabel();
        tfUsername = new JTextField();
        pfPassword = new JPasswordField();
        lblProjectName = new JLabel();
        btnLogin = new JButton();
        lblUsername = new JLabel();
        lblPassword = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        HeadPanel.setLayout(new AbsoluteLayout());

        lblProjectTitle.setText("Expense Tracker");
        lblProjectTitle.setForeground(Color.WHITE);
        lblProjectTitle.setFont(new Font("Dialog", 0, 11));
        HeadPanel.add(lblProjectTitle, new AbsoluteConstraints(10, 0, 310, 30));

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

        lblQuestion.setFont(new Font("Tahoma", 0, 14));
        lblQuestion.setText("Don't have account yet?");
        BodyPanel.add(lblQuestion, new AbsoluteConstraints(20, 450, -1, -1));

        navRegister.setContentAreaFilled(false);
        navRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navRegister.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                navRegisterFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                navRegisterFocusLost(evt);
            }

        });
        navRegister.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                navRegisterMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                navRegisterMouseExited(evt);
            }

        });
        navRegister.addActionListener((ActionEvent evt)
                ->
        {
            navRegisterActionPerformed(evt);
                });
        BodyPanel.add(navRegister, new AbsoluteConstraints(25, 470, 147, 33));

        btnMode.setContentAreaFilled(false);
        btnMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMode.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                btnModeFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                btnModeFocusLost(evt);
            }

        });
        btnMode.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                btnModeMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                btnModeMouseExited(evt);
            }

        });
        btnMode.addActionListener((ActionEvent evt)
                ->
        {
            btnModeActionPerformed(evt);
                });
        BodyPanel.add(btnMode, new AbsoluteConstraints(345, 30, 55, 52));
        BodyPanel.add(lblTail, new AbsoluteConstraints(0, 360, 400, 168));
        BodyPanel.add(lblLogo, new AbsoluteConstraints(150, 10, 112, 106));

        tfUsername.setFont(new Font("Dialog", 0, 14));
        tfUsername.setBorder(null);
        tfUsername.setOpaque(false);
        tfUsername.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                tfUsernameFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                tfUsernameFocusLost(evt);
            }

        });
        BodyPanel.add(tfUsername, new AbsoluteConstraints(90, 190, 220, 30));

        pfPassword.setFont(new Font("Dialog", 0, 14));
        pfPassword.setBorder(null);
        pfPassword.setOpaque(false);
        pfPassword.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                pfPasswordFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                pfPasswordFocusLost(evt);
            }

        });
        BodyPanel.add(pfPassword, new AbsoluteConstraints(90, 250, 220, 30));

        lblProjectName.setFont(new Font("Arial", 0, 18));
        lblProjectName.setForeground(new Color(51, 51, 51));
        lblProjectName.setText("Expense Tracker");
        BodyPanel.add(lblProjectName, new AbsoluteConstraints(135, 120, -1, -1));

        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                btnLoginFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                btnLoginFocusLost(evt);
            }

        });
        btnLogin.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                btnLoginMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                btnLoginMouseExited(evt);
            }

        });
        btnLogin.addActionListener((ActionEvent evt)
                ->
        {
            btnLoginActionPerformed(evt);
                });
        BodyPanel.add(btnLogin, new AbsoluteConstraints(150, 310, 103, 33));

        lblUsername.setFont(new Font("Dialog", 0, 14));
        lblUsername.setForeground(new Color(51, 51, 51));
        lblUsername.setText("Username");
        BodyPanel.add(lblUsername, new AbsoluteConstraints(90, 170, 80, 20));

        lblPassword.setFont(new Font("Dialog", 0, 14));
        lblPassword.setForeground(new Color(51, 51, 51));
        lblPassword.setText("Password");
        BodyPanel.add(lblPassword, new AbsoluteConstraints(90, 230, 70, 20));

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

        System.exit(0);

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

        setLocation(futureXPosition
                            - currentXPosition, futureYPosition
                                                        - currentYPosition);

    }

    private void btnModeFocusGained(FocusEvent evt)
    {

        onMode();

    }

    private void btnModeFocusLost(FocusEvent evt)
    {

        offMode();

    }

    private void btnModeMouseEntered(MouseEvent evt)
    {

        onMode();

    }

    private void btnModeMouseExited(MouseEvent evt)
    {

        offMode();

    }

    private void btnModeActionPerformed(ActionEvent evt)
    {

        switch (current)
        {

            case 0:
                onNightMode(false);
                current = 1;
                break;

            case 1:
                onDayMode(false);
                current = 0;
                break;

        }

        pref.putInt("current", current);

    }

    private void navRegisterFocusGained(FocusEvent evt)
    {

        navRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navregisterhover"))));

    }

    private void navRegisterFocusLost(FocusEvent evt)
    {

        navRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navregister"))));

    }

    private void navRegisterMouseExited(MouseEvent evt)
    {

        navRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navregister"))));

    }

    private void navRegisterMouseEntered(MouseEvent evt)
    {

        navRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navregisterhover"))));

    }

    private void navRegisterActionPerformed(ActionEvent evt)
    {

        dispose();
        final RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.setVisible(true);

    }

    private void tfUsernameFocusGained(FocusEvent evt)
    {

        tfUsername.setHorizontalAlignment(JTextField.CENTER);
        tfUsername.setForeground(new Color(51, 153, 255));
        tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 153, 255)));

        final String username = tfUsername.getText().toLowerCase().trim();

        if (username.equals("enter your username")) tfUsername.setText("");

    }

    private void tfUsernameFocusLost(FocusEvent evt)
    {

        tfUsername.setHorizontalAlignment(JTextField.LEFT);

        final String username = tfUsername.getText().toLowerCase().trim();

        if (username.equals(""))
        {

            tfUsername.setText("Enter your Username");

            switch (current)
            {

                case 0:
                    tfUsername.setForeground(Color.BLACK);
                    tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    break;

                case 1:
                    tfUsername.setForeground(Color.GRAY);
                    tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                    break;

            }

        }

    }

    private void pfPasswordFocusGained(FocusEvent evt)
    {

        pfPassword.setText("******");
        pfPassword.setHorizontalAlignment(JTextField.CENTER);
        pfPassword.setForeground(new Color(51, 153, 255));
        pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 153, 255)));

        final String password = pfPassword.getText().trim();

        if (password.equals("******"))
            pfPassword.setText("");

    }

    private void pfPasswordFocusLost(FocusEvent evt)
    {

        pfPassword.setHorizontalAlignment(JTextField.LEFT);

        String password = pfPassword.getText().trim();

        if (password.equals(""))
        {

            pfPassword.setText("******");

            switch (current)
            {

                case 0:
                    pfPassword.setForeground(Color.BLACK);
                    pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    break;

                case 1:
                    pfPassword.setForeground(Color.GRAY);
                    pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                    break;

            }

        }

    }

    private void btnLoginMouseExited(MouseEvent evt)
    {

        btnLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("login"))));

    }

    private void btnLoginMouseEntered(MouseEvent evt)
    {

        btnLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("loginhover"))));

    }

    private void btnLoginActionPerformed(ActionEvent evt)
    {

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();

        if (username.equals("enter your username")
                    || password.equals("******"))
        {

            JOptionPane.showMessageDialog(null, "All fields are required!");

            if (username.equals("enter your username"))
                switch (current)
                {

                    case 0:
                        tfUsername.setForeground(Color.BLACK);
                        tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;

                    case 1:
                        tfUsername.setForeground(Color.GRAY);
                        tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                        break;

                }

            if (password.equals("******"))
                switch (current)
                {

                    case 0:
                        pfPassword.setForeground(Color.BLACK);
                        pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;

                    case 1:
                        pfPassword.setForeground(Color.GRAY);
                        pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                        break;

                }

        }
        else if (password.length() < 6)
        {

            JOptionPane.showMessageDialog(null, "Password Must be at least 6 characters!");
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
            pfPassword.setForeground(new Color(255, 51, 51));

        }
        else
            onLogin(username, password);

    }

    private void btnLoginFocusGained(FocusEvent evt)
    {

        btnLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("loginhover"))));

    }

    private void btnLoginFocusLost(FocusEvent evt)
    {

        btnLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("login"))));

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

            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new MainScreen().setVisible(true);

                });

    }

    private void initInstances()
    {

        expenseTracker = new ExpenseTracker();
        conn = SQLite.getInstance();
        pref = Preferences.userNodeForPackage(Class.class);

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(expenseTracker.getString("logo"))));
        lblHead.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("head"))));
        navRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navregister"))));
        lblTail.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("taillogin"))));
        btnLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("login"))));

        lblUsername.grabFocus();
        tfUsername.setText("Enter your Username");
        pfPassword.setText("******");

        current = pref.getInt("current", 0);

        switch (current)
        {

            case 0:
                onDayMode(true);
                break;

            case 1:
                onNightMode(true);
                break;

        }

    }

    private void onMode()
    {

        switch (future)
        {
            case 0:
                btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("dayhover"))));
                break;

            case 1:
                btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nighthover"))));
                break;
        }

    }

    private void offMode()
    {

        switch (future)
        {

            case 0:
                btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("day"))));
                break;

            case 1:
                btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("night"))));
                break;

        }

    }

    private void onDayMode(boolean isInitial)
    {

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();

        BodyPanel.setBackground(new Color(240, 240, 240));
        lblLogo.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("daylogo"))));
        btnMode.setIcon(new ImageIcon(getClass().getResource(isInitial
                                                             ? expenseTracker.getString("night")
                                                             : expenseTracker.getString("nighthover"))));
        lblProjectName.setForeground(new Color(51, 51, 51));
        lblUsername.setForeground(new Color(51, 51, 51));
        lblPassword.setForeground(new Color(51, 51, 51));

        if (username.equals("enter your username"))
        {

            tfUsername.setForeground(Color.BLACK);
            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }
        if (password.equals("******"))
        {

            pfPassword.setForeground(Color.BLACK);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }

        future = 1;

    }

    private void onNightMode(boolean isInitial)
    {

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();

        btnMode.setIcon(new ImageIcon(getClass().getResource(isInitial
                                                             ? expenseTracker.getString("day")
                                                             : expenseTracker.getString("dayhover"))));
        BodyPanel.setBackground(new Color(41, 41, 41));
        lblLogo.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("nightlogo"))));
        lblProjectName.setForeground(new Color(240, 240, 240));
        lblUsername.setForeground(new Color(240, 240, 240));
        lblPassword.setForeground(new Color(240, 240, 240));

        if (username.equals("enter your username"))
        {

            tfUsername.setForeground(Color.GRAY);
            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }
        if (password.equals("******"))
        {

            pfPassword.setForeground(Color.GRAY);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }

        future = 0;

    }

    private void onLogin(final String username, final String password)
    {

        String sql = "SELECT * FROM Users WHERE user_name=? AND user_password=?";

        try
        {

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            int count = 0;
            while (rs.next())
            {

                count += 1;
                final int user_id = rs.getInt("user_id");
                pref.putInt("user_id", user_id);

            }

            switch (count)
            {

                case 0:
                    sql = "SELECT * FROM Users WHERE user_name=?";

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, username);

                    rs = ps.executeQuery();
                    count = 0;
                    while (rs.next())
                        count += 1;

                    switch (count)
                    {

                        case 0:
                            JOptionPane.showMessageDialog(null, "User Doesn't Exist!");
                            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
                            tfUsername.setForeground(new Color(255, 51, 51));
                            break;

                        case 1:
                            JOptionPane.showMessageDialog(null, "Incorrect Password!");
                            break;

                    }

                    pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
                    pfPassword.setForeground(new Color(255, 51, 51));

                    break;

                case 1:
                    conn.close();
                    dispose();
                    final HomeScreen homeScreen = new HomeScreen();
                    homeScreen.setVisible(true);

                    break;

            }

            rs.close();
            ps.close();

        }
        catch (HeadlessException
               | SQLException ex)
        {

            JOptionPane.showMessageDialog(null, "Please Contact Your Service Provider");
            conn = SQLite.getInstance();

        }

    }

}
