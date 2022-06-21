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
    boolean isNightMode = false;
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

        final int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        switch (response)
        {

            case JOptionPane.YES_OPTION:
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

        setLocation(futureXPosition
                            - currentXPosition, futureYPosition
                                                        - currentYPosition);

    }

    private void btnModeFocusGained(FocusEvent evt)
    {

        onHover();

    }

    private void btnModeFocusLost(FocusEvent evt)
    {

        offHover();

    }

    private void btnModeMouseEntered(MouseEvent evt)
    {

        onHover();

    }

    private void btnModeMouseExited(MouseEvent evt)
    {

        offHover();

    }

    private void btnModeActionPerformed(ActionEvent evt)
    {

        isNightMode = !isNightMode;
        onMode(false);
        pref.putBoolean("isNightMode", isNightMode);

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
        new RegisterScreen().setVisible(true);

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

        tfUsername.setHorizontalAlignment(JTextField.LEADING);

        final String username = tfUsername.getText().toLowerCase().trim();

        if (username.equals(""))
        {

            tfUsername.setText("Enter your Username");

            final Color colorFields = isNightMode
                                      ? Color.GRAY
                                      : Color.BLACK;

            tfUsername.setForeground(colorFields);
            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

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

        pfPassword.setHorizontalAlignment(JTextField.LEADING);

        String password = pfPassword.getText().trim();

        if (password.equals(""))
        {

            pfPassword.setText("******");

            final Color colorFields = isNightMode
                                      ? Color.GRAY
                                      : Color.BLACK;

            pfPassword.setForeground(colorFields);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

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

        final Color colorFields = isNightMode
                                  ? Color.GRAY
                                  : Color.BLACK;

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();

        if (username.equals("enter your username")
                    || password.equals("******"))
        {

            JOptionPane.showMessageDialog(this, "All fields are required!", "Log In", JOptionPane.WARNING_MESSAGE);

            if (username.equals("enter your username"))
            {

                tfUsername.setForeground(colorFields);
                tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

            }

            if (password.equals("******"))
            {

                pfPassword.setForeground(colorFields);
                pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

            }

        }
        else if (password.length() < 6)
        {

            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters!", "Log In", JOptionPane.WARNING_MESSAGE);
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

            final Preferences pref = Preferences.userNodeForPackage(Class.class);
            final int user_id = pref.getInt("user_id", 0);
            if (user_id != 0)
                new HomeScreen().setVisible(true);
            else
                new MainScreen().setVisible(true);

                });

    }

    private void initInstances()
    {

        expenseTracker = new ExpenseTracker();
        conn = SQLite.getInstance();
        pref = Preferences.userNodeForPackage(Class.class);
        isNightMode = pref.getBoolean("isNightMode", false);

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

        onMode(true);

    }

    private void onHover()
    {

        final String hover = isNightMode
                             ? "dayhover"
                             : "nighthover";

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(hover))));

    }

    private void offHover()
    {

        final String hover = isNightMode
                             ? "day"
                             : "night";

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(hover))));

    }

    private void onMode(boolean isInitial)
    {

        final String mode = isInitial
                            ? isNightMode
                              ? "day"
                              : "night"
                            : isNightMode
                              ? "dayhover"
                              : "nighthover";

        final String logo = isNightMode
                            ? "nightlogo"
                            : "daylogo";

        final Color colorBodyPanel = isNightMode
                                     ? new Color(41, 41, 41)
                                     : new Color(240, 240, 240);

        final Color colorLbl = isNightMode
                               ? new Color(240, 240, 240)
                               : new Color(51, 51, 51);

        final Color colorFields = isNightMode
                                  ? Color.GRAY
                                  : Color.BLACK;

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(mode))));
        lblLogo.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(logo))));
        BodyPanel.setBackground(colorBodyPanel);
        lblProjectName.setForeground(colorLbl);
        lblUsername.setForeground(colorLbl);
        lblPassword.setForeground(colorLbl);

        if (username.equals("enter your username"))
        {

            tfUsername.setForeground(colorFields);
            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

        }
        if (password.equals("******"))
        {

            pfPassword.setForeground(colorFields);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

        }

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
                            JOptionPane.showMessageDialog(this, "User Doesn't Exist!", "Log In", JOptionPane.WARNING_MESSAGE);
                            tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
                            tfUsername.setForeground(new Color(255, 51, 51));
                            break;

                        case 1:
                            JOptionPane.showMessageDialog(this, "Incorrect Password!", "Log In", JOptionPane.WARNING_MESSAGE);
                            break;

                    }

                    pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
                    pfPassword.setForeground(new Color(255, 51, 51));
                    break;

                case 1:
                    conn.close();
                    dispose();
                    new HomeScreen().setVisible(true);
                    break;

            }

            rs.close();
            ps.close();

        }
        catch (HeadlessException
               | SQLException ex)
        {

            JOptionPane.showMessageDialog(this, "An error occured while logging in", "Expense Tracker", JOptionPane.ERROR_MESSAGE);

        }

    }

}
