package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.*;

public class MainScreen extends JFrame
{

    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnMode;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblTail;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JButton navRegister;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUsername;

    ExpenseTracker et;
    static int iCurrentXPosition = 0;
    static int iCurrentYPosition = 0;
    int iFuture = 0;
    int iCurrent = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int user_id = 0;

    public MainScreen()
    {

        initComponents();
        initInstances();
        initIcons();

    }

    private void initComponents()
    {

        HeadPanel = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblHead = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        navRegister = new javax.swing.JButton();
        btnMode = new javax.swing.JButton();
        lblTail = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        lblProjectName = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimize.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnMinimize.setForeground(new java.awt.Color(240, 240, 240));
        btnMinimize.setText("—");
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            btnMinimizeActionPerformed(evt);
                });
        HeadPanel.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 30));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnClose.setForeground(new java.awt.Color(240, 240, 240));
        btnClose.setText("X");
        btnClose.setContentAreaFilled(false);
        btnClose.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                btnCloseFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                btnCloseFocusLost(evt);
            }

        });
        btnClose.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btnCloseMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btnCloseMouseExited(evt);
            }

        });
        btnClose.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            btnCloseActionPerformed(evt);
                });
        HeadPanel.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 0, -1, 30));

        lblHead.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                lblHeadMouseDragged(evt);
            }

        });
        lblHead.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                lblHeadMousePressed(evt);
            }

        });
        HeadPanel.add(lblHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        getContentPane().add(HeadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        BodyPanel.setForeground(new java.awt.Color(240, 240, 240));
        BodyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQuestion.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblQuestion.setText("Don't have account yet?");
        BodyPanel.add(lblQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        navRegister.setContentAreaFilled(false);
        navRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navRegister.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                navRegisterFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                navRegisterFocusLost(evt);
            }

        });
        navRegister.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                navRegisterMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                navRegisterMouseExited(evt);
            }

        });
        navRegister.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            navRegisterActionPerformed(evt);
                });
        BodyPanel.add(navRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 470, 147, 33));

        btnMode.setContentAreaFilled(false);
        btnMode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMode.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                btnModeFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                btnModeFocusLost(evt);
            }

        });
        btnMode.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btnModeMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btnModeMouseExited(evt);
            }

        });
        btnMode.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            btnModeActionPerformed(evt);
                });
        BodyPanel.add(btnMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 30, 55, 52));
        BodyPanel.add(lblTail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 400, 168));
        BodyPanel.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 112, 106));

        tfUsername.setFont(new java.awt.Font("Dialog", 0, 14));
        tfUsername.setBorder(null);
        tfUsername.setOpaque(false);
        tfUsername.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                tfUsernameFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                tfUsernameFocusLost(evt);
            }

        });
        BodyPanel.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 220, 30));

        pfPassword.setFont(new java.awt.Font("Dialog", 0, 14));
        pfPassword.setBorder(null);
        pfPassword.setOpaque(false);
        pfPassword.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                pfPasswordFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                pfPasswordFocusLost(evt);
            }

        });
        BodyPanel.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 220, 30));

        lblProjectName.setFont(new java.awt.Font("Arial", 0, 18));
        lblProjectName.setForeground(new java.awt.Color(51, 51, 51));
        lblProjectName.setText("Expense Tracker");
        BodyPanel.add(lblProjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 120, -1, -1));

        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addFocusListener(new java.awt.event.FocusAdapter()
        {

            @Override
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                btnLoginFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                btnLoginFocusLost(evt);
            }

        });
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btnLoginMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btnLoginMouseExited(evt);
            }

        });
        btnLogin.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            btnLoginActionPerformed(evt);
                });
        BodyPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 103, 33));

        lblUsername.setFont(new java.awt.Font("Dialog", 0, 14));
        lblUsername.setForeground(new java.awt.Color(51, 51, 51));
        lblUsername.setText("Username");
        BodyPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 80, 20));

        lblPassword.setFont(new java.awt.Font("Dialog", 0, 14));
        lblPassword.setForeground(new java.awt.Color(51, 51, 51));
        lblPassword.setText("Password");
        BodyPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 70, 20));

        getContentPane().add(BodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 520));

        pack();
        setLocationRelativeTo(null);

    }

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt)
    {

        setState(ICONIFIED);

    }

    private void btnCloseFocusGained(java.awt.event.FocusEvent evt)
    {

        btnClose.setForeground(new java.awt.Color(255, 51, 51));

    }

    private void btnCloseFocusLost(java.awt.event.FocusEvent evt)
    {

        btnClose.setForeground(new java.awt.Color(240, 240, 240));

    }

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt)
    {

        btnClose.setForeground(new java.awt.Color(255, 51, 51));

    }

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt)
    {

        btnClose.setForeground(new java.awt.Color(240, 240, 240));

    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt)
    {

        System.exit(0);

    }

    private void lblHeadMousePressed(java.awt.event.MouseEvent evt)
    {

        iCurrentXPosition = evt.getX();
        iCurrentYPosition = evt.getY();

    }

    private void lblHeadMouseDragged(java.awt.event.MouseEvent evt)
    {

        final int iFutureXPosition = evt.getXOnScreen();
        final int iFutureYPosition = evt.getYOnScreen();

        setLocation(iFutureXPosition - iCurrentXPosition, iFutureYPosition
                                                                  - iCurrentYPosition);

    }

    private void btnModeFocusGained(java.awt.event.FocusEvent evt)
    {

        onMode();

    }

    private void btnModeFocusLost(java.awt.event.FocusEvent evt)
    {

        offMode();

    }

    private void btnModeMouseEntered(java.awt.event.MouseEvent evt)
    {

        onMode();

    }

    private void btnModeMouseExited(java.awt.event.MouseEvent evt)
    {

        offMode();

    }

    private void btnModeActionPerformed(java.awt.event.ActionEvent evt)
    {

        switch (iCurrent)
        {

            case 0:
                onNightMode(false);
                iCurrent = 1;
                break;

            case 1:
                onDayMode(false);
                iCurrent = 0;
                break;

        }

    }

    private void navRegisterFocusGained(java.awt.event.FocusEvent evt)
    {

        navRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navregisterhover"))));

    }

    private void navRegisterFocusLost(java.awt.event.FocusEvent evt)
    {

        navRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navregister"))));

    }

    private void navRegisterMouseExited(java.awt.event.MouseEvent evt)
    {

        navRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navregister"))));

    }

    private void navRegisterMouseEntered(java.awt.event.MouseEvent evt)
    {

        navRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navregisterhover"))));

    }

    private void navRegisterActionPerformed(java.awt.event.ActionEvent evt)
    {

        dispose();
        final RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.setVisible(true);

        switch (iCurrent)
        {

            case 0:
                registerScreen.onDayMode(true);
                registerScreen.iCurrent = 0;
                break;

            case 1:
                registerScreen.onNightMode(true);
                registerScreen.iCurrent = 1;
                break;

        }

    }

    private void tfUsernameFocusGained(java.awt.event.FocusEvent evt)
    {

        tfUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUsername.setForeground(new java.awt.Color(51, 153, 255));
        tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 153, 255)));

        final String sUsername = tfUsername.getText().toLowerCase().trim();

        if (sUsername.equals("enter your username"))
        {
            tfUsername.setText("");
        }

    }

    private void tfUsernameFocusLost(java.awt.event.FocusEvent evt)
    {

        tfUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        final String sUsername = tfUsername.getText().toLowerCase().trim();

        if (sUsername.equals(""))
        {

            tfUsername.setText("Enter your Username");

            switch (iCurrent)
            {

                case 0:
                    tfUsername.setForeground(Color.BLACK);
                    tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    break;

                case 1:
                    tfUsername.setForeground(Color.GRAY);
                    tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                    break;

            }

        }

    }

    private void pfPasswordFocusGained(java.awt.event.FocusEvent evt)
    {

        pfPassword.setText("******");
        pfPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pfPassword.setForeground(new java.awt.Color(51, 153, 255));
        pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 153, 255)));

        final String sPassword = pfPassword.getText().trim();

        if (sPassword.equals("******"))
        {
            pfPassword.setText("");
        }

    }

    private void pfPasswordFocusLost(java.awt.event.FocusEvent evt)
    {

        pfPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        String sPassword = pfPassword.getText().trim();

        if (sPassword.equals(""))
        {

            pfPassword.setText("******");

            switch (iCurrent)
            {

                case 0:
                    pfPassword.setForeground(Color.BLACK);
                    pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    break;

                case 1:
                    pfPassword.setForeground(Color.GRAY);
                    pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                    break;

            }

        }

    }

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt)
    {

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("login"))));

    }

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt)
    {

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("loginhover"))));

    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)
    {

        final String sUsername = tfUsername.getText().toLowerCase().trim();
        final String sPassword = pfPassword.getText().trim();

        if (sUsername.equals("enter your username")
                    || sPassword.equals("******"))
        {

            JOptionPane.showMessageDialog(null, "All fields are required!");

            if (sUsername.equals("enter your username"))
            {

                switch (iCurrent)
                {

                    case 0:
                        tfUsername.setForeground(Color.BLACK);
                        tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;

                    case 1:
                        tfUsername.setForeground(Color.GRAY);
                        tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                        break;

                }

            }
            if (sPassword.equals("******"))
            {

                switch (iCurrent)
                {

                    case 0:
                        pfPassword.setForeground(Color.BLACK);
                        pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;

                    case 1:
                        pfPassword.setForeground(Color.GRAY);
                        pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                        break;

                }

            }

        }
        else if (sPassword.length() < 6)
        {

            JOptionPane.showMessageDialog(null, "Password Must be at least 6 characters!");
            pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
            pfPassword.setForeground(new java.awt.Color(255, 51, 51));

        }
        else
        {
            onLogin(sUsername, sPassword);
        }

    }

    private void btnLoginFocusGained(java.awt.event.FocusEvent evt)
    {

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("loginhover"))));

    }

    private void btnLoginFocusLost(java.awt.event.FocusEvent evt)
    {

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("login"))));

    }

    public static void main(String args[])
    {

        try
        {

            for (UIManager.LookAndFeelInfo info
                         : UIManager.getInstalledLookAndFeels())
            {

                if ("Windows".equals(info.getName()))
                {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }

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

        et = new ExpenseTracker();
        conn = SQLite.getInstance();

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(et.getString("logo"))));
        lblHead.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("head"))));
        navRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navregister"))));
        lblTail.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("taillogin"))));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("login"))));

        lblUsername.grabFocus();
        tfUsername.setText("Enter your Username");
        pfPassword.setText("******");

        switch (iCurrent)
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

        switch (iFuture)
        {
            case 0:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("dayhover"))));
                break;

            case 1:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("nighthover"))));
                break;
        }

    }

    private void offMode()
    {

        switch (iFuture)
        {

            case 0:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("day"))));
                break;

            case 1:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("night"))));
                break;

        }

    }

    public void onDayMode(boolean isInitial)
    {

        final String sUsername = tfUsername.getText().toLowerCase().trim();
        final String sPassword = pfPassword.getText().trim();

        BodyPanel.setBackground(new java.awt.Color(240, 240, 240));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("daylogo"))));
        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(isInitial
                                                                         ? et.getString("night")
                                                                         : et.getString("nighthover"))));
        lblProjectName.setForeground(new java.awt.Color(51, 51, 51));
        lblUsername.setForeground(new java.awt.Color(51, 51, 51));
        lblPassword.setForeground(new java.awt.Color(51, 51, 51));

        if (sUsername.equals("enter your username"))
        {

            tfUsername.setForeground(Color.BLACK);
            tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }
        if (sPassword.equals("******"))
        {

            pfPassword.setForeground(Color.BLACK);
            pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }

        iFuture = 1;

    }

    public void onNightMode(boolean isInitial)
    {

        final String sUsername = tfUsername.getText().toLowerCase().trim();
        final String sPassword = pfPassword.getText().trim();

        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(isInitial
                                                                         ? et.getString("day")
                                                                         : et.getString("dayhover"))));
        BodyPanel.setBackground(new java.awt.Color(41, 41, 41));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("nightlogo"))));
        lblProjectName.setForeground(new java.awt.Color(240, 240, 240));
        lblUsername.setForeground(new java.awt.Color(240, 240, 240));
        lblPassword.setForeground(new java.awt.Color(240, 240, 240));

        if (sUsername.equals("enter your username"))
        {

            tfUsername.setForeground(Color.GRAY);
            tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }
        if (sPassword.equals("******"))
        {

            pfPassword.setForeground(Color.GRAY);
            pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }

        iFuture = 0;

    }

    private void onLogin(final String sUsername, final String sPassword)
    {

        String sql = "SELECT * FROM Users WHERE user_name=? AND user_password=?";

        try
        {

            ps = conn.prepareStatement(sql);
            ps.setString(1, sUsername);
            ps.setString(2, sPassword);

            rs = ps.executeQuery();
            int count = 0;
            while (rs.next())
            {

                count += 1;
                user_id = rs.getInt("user_id");

            }

            switch (count)
            {

                case 0:
                    sql = "SELECT * FROM Users WHERE user_name=?";

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, sUsername);

                    rs = ps.executeQuery();
                    count = 0;
                    while (rs.next())
                    {

                        count += 1;

                    }

                    switch (count)
                    {

                        case 0:
                            JOptionPane.showMessageDialog(null, "User Doesn't Exist!");
                            tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
                            tfUsername.setForeground(new java.awt.Color(255, 51, 51));
                            break;

                        case 1:
                            JOptionPane.showMessageDialog(null, "Incorrect Password!");
                            break;

                    }

                    pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
                    pfPassword.setForeground(new java.awt.Color(255, 51, 51));

                    break;

                case 1:
                    conn.close();
                    dispose();
                    final HomeScreen homeScreen = new HomeScreen();
                    homeScreen.setVisible(true);
                    homeScreen.user_id = user_id;

                    switch (iCurrent)
                    {

                        case 0:
                            homeScreen.onDayMode();
                            break;

                        case 1:
                            homeScreen.onNightMode();
                            break;

                    }

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
