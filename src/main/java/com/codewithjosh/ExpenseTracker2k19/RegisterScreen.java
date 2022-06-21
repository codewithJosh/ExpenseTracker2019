package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import java.util.prefs.Preferences;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.*;
import org.netbeans.lib.awtextra.*;

public class RegisterScreen extends JFrame
{

    private JPanel BodyPanel;
    private JPanel HeadPanel;
    private JButton btnClose;
    private JButton btnMinimize;
    private JButton btnMode;
    private JButton btnRegister;
    private JLabel lblHead;
    private JLabel lblPassword;
    private JLabel lblProjectTitle;
    private JLabel lblQuestion;
    private JLabel lblRePassword;
    private JLabel lblSignUp;
    private JLabel lblTail;
    private JLabel lblUsername;
    private JButton navLogin;
    private JPasswordField pfPassword;
    private JPasswordField pfRePassword;
    private JTextField tfUsername;

    ExpenseTracker expenseTracker;
    static int currentXPosition = 0;
    static int currentYPosition = 0;
    boolean isNightMode = false;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Preferences pref;

    public RegisterScreen()
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
        tfUsername = new JTextField();
        pfPassword = new JPasswordField();
        pfRePassword = new JPasswordField();
        lblQuestion = new JLabel();
        navLogin = new JButton();
        lblPassword = new JLabel();
        lblSignUp = new JLabel();
        btnRegister = new JButton();
        lblUsername = new JLabel();
        lblRePassword = new JLabel();
        lblTail = new JLabel();
        btnMode = new JButton();

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
        BodyPanel.add(tfUsername, new AbsoluteConstraints(90, 110, 220, 30));

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
        BodyPanel.add(pfPassword, new AbsoluteConstraints(90, 190, 220, 30));

        pfRePassword.setFont(new Font("Dialog", 0, 14));
        pfRePassword.setBorder(null);
        pfRePassword.setOpaque(false);
        pfRePassword.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                pfRePasswordFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                pfRePasswordFocusLost(evt);
            }

        });
        BodyPanel.add(pfRePassword, new AbsoluteConstraints(90, 270, 220, 30));

        lblQuestion.setFont(new Font("Tahoma", 0, 14));
        lblQuestion.setText("Already have an account?");
        BodyPanel.add(lblQuestion, new AbsoluteConstraints(17, 450, -1, -1));

        navLogin.setContentAreaFilled(false);
        navLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navLogin.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                navLoginFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                navLoginFocusLost(evt);
            }

        });
        navLogin.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                navLoginMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                navLoginMouseExited(evt);
            }

        });
        navLogin.addActionListener((ActionEvent evt)
                ->
        {
            navLoginActionPerformed(evt);
                });
        BodyPanel.add(navLogin, new AbsoluteConstraints(20, 470, 147, 33));

        lblPassword.setFont(new Font("Dialog", 0, 14));
        lblPassword.setText("Password");
        BodyPanel.add(lblPassword, new AbsoluteConstraints(90, 170, 220, 20));

        lblSignUp.setFont(new Font("Arial", 0, 18));
        lblSignUp.setText("Sign Up");
        BodyPanel.add(lblSignUp, new AbsoluteConstraints(90, 40, -1, -1));

        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.addFocusListener(new FocusAdapter()
        {

            @Override
            public void focusGained(FocusEvent evt)
            {
                btnRegisterFocusGained(evt);
            }

            @Override
            public void focusLost(FocusEvent evt)
            {
                btnRegisterFocusLost(evt);
            }

        });
        btnRegister.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent evt)
            {
                btnRegisterMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt)
            {
                btnRegisterMouseExited(evt);
            }

        });
        btnRegister.addActionListener((ActionEvent evt)
                ->
        {
            btnRegisterActionPerformed(evt);
                });
        BodyPanel.add(btnRegister, new AbsoluteConstraints(150, 330, 103, 33));

        lblUsername.setFont(new Font("Dialog", 0, 14));
        lblUsername.setText("Username");
        BodyPanel.add(lblUsername, new AbsoluteConstraints(90, 90, 220, 20));

        lblRePassword.setFont(new Font("Dialog", 0, 14));
        lblRePassword.setText("Re-Enter Password");
        BodyPanel.add(lblRePassword, new AbsoluteConstraints(90, 250, 220, 20));
        BodyPanel.add(lblTail, new AbsoluteConstraints(0, 350, 400, 170));

        btnMode.setContentAreaFilled(false);
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
        btnMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BodyPanel.add(btnMode, new AbsoluteConstraints(345, 30, 55, 52));

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

        setLocation(futureXPosition - currentXPosition, futureYPosition
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

    private void navLoginFocusGained(FocusEvent evt)
    {

        navLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navloginhover"))));

    }

    private void navLoginFocusLost(FocusEvent evt)
    {

        navLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navlogin"))));

    }

    private void navLoginMouseExited(MouseEvent evt)
    {

        navLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navlogin"))));

    }

    private void navLoginMouseEntered(MouseEvent evt)
    {

        navLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navloginhover"))));

    }

    private void navLoginActionPerformed(ActionEvent evt)
    {

        dispose();
        new MainScreen().setVisible(true);

    }

    private void tfUsernameFocusGained(FocusEvent evt)
    {

        tfUsername.setHorizontalAlignment(JTextField.CENTER);
        tfUsername.setForeground(new Color(51, 153, 255));
        tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 153, 255)));

        final String username = tfUsername.getText().toLowerCase().trim();

        if (username.equals("enter your username"))
            tfUsername.setText("");

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

    private void pfRePasswordFocusGained(FocusEvent evt)
    {

        pfRePassword.setText("******");
        pfRePassword.setHorizontalAlignment(JTextField.CENTER);
        pfRePassword.setForeground(new Color(51, 153, 255));
        pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51, 153, 255)));

        final String repassword = pfRePassword.getText().trim();

        if (repassword.equals("******"))
            pfRePassword.setText("");

    }

    private void pfRePasswordFocusLost(FocusEvent evt)
    {

        pfRePassword.setHorizontalAlignment(JTextField.LEADING);

        String repassword = pfRePassword.getText().trim();

        if (repassword.equals(""))
        {

            pfRePassword.setText("******");

            final Color colorFields = isNightMode
                                      ? Color.GRAY
                                      : Color.BLACK;

            pfRePassword.setForeground(colorFields);
            pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

        }

    }

    private void btnRegisterFocusGained(FocusEvent evt)
    {

        btnRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("registerhover"))));

    }

    private void btnRegisterFocusLost(FocusEvent evt)
    {

        btnRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("register"))));

    }

    private void btnRegisterMouseExited(MouseEvent evt)
    {

        btnRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("register"))));

    }

    private void btnRegisterMouseEntered(MouseEvent evt)
    {

        btnRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("registerhover"))));

    }

    private void btnRegisterActionPerformed(ActionEvent evt)
    {

        final Color colorFields = isNightMode
                                  ? Color.GRAY
                                  : Color.BLACK;

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();
        final String repassword = pfRePassword.getText().trim();

        if (username.equals("enter your username")
                    || password.equals("******")
                    || repassword.equals("******"))
        {

            JOptionPane.showMessageDialog(this, "All fields are required!", "Sign Up", JOptionPane.WARNING_MESSAGE);

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

            if (repassword.equals("******"))
            {

                pfRePassword.setForeground(colorFields);
                pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

            }

        }
        else if (password.length() < 6)
        {

            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters!", "Sign Up", JOptionPane.WARNING_MESSAGE);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
            pfPassword.setForeground(new Color(255, 51, 51));

        }
        else if (!password.equals(repassword))
        {

            JOptionPane.showMessageDialog(this, "Password doesn't match!", "Sign Up", JOptionPane.WARNING_MESSAGE);
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
            pfPassword.setForeground(new Color(255, 51, 51));
            pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
            pfRePassword.setForeground(new Color(255, 51, 51));

        }
        else
            onRegister(username, password);

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

            Logger.getLogger(RegisterScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new RegisterScreen().setVisible(true);

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
        navLogin.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("navlogin"))));
        btnRegister.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("register"))));
        lblTail.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString("tailregister"))));

        lblUsername.grabFocus();
        tfUsername.setText("Enter your Username");
        pfPassword.setText("******");
        pfRePassword.setText("******");

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
        final String repassword = pfRePassword.getText().trim();

        btnMode.setIcon(new ImageIcon(getClass().getResource(expenseTracker.getString(mode))));
        BodyPanel.setBackground(colorBodyPanel);
        lblUsername.setForeground(colorLbl);
        lblPassword.setForeground(colorLbl);
        lblRePassword.setForeground(colorLbl);
        lblSignUp.setForeground(colorLbl);

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
        if (repassword.equals("******"))
        {

            pfRePassword.setForeground(colorFields);
            pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorFields));

        }

    }

    private void onRegister(final String username, final String password)
    {

        String sql = "SELECT * FROM Users WHERE user_name=?";

        try
        {

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            rs = ps.executeQuery();
            int count = 0;
            while (rs.next())
                count += 1;

            switch (count)
            {

                case 0:

                    sql = "INSERT INTO Users (user_name, user_password) VALUES (?,?)";

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, username);
                    ps.setString(2, password);

                    ps.execute();
                    JOptionPane.showMessageDialog(this, "You're Successfully Added!", "Sign Up", JOptionPane.INFORMATION_MESSAGE);

                    conn.close();
                    dispose();
                    new MainScreen().setVisible(true);
                    break;

                case 1:
                    JOptionPane.showMessageDialog(this, "Username is Already Taken!", "Sign Up", JOptionPane.WARNING_MESSAGE);
                    tfUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
                    tfUsername.setForeground(new Color(255, 51, 51));
                    break;

            }

            rs.close();
            ps.close();

        }
        catch (HeadlessException
               | SQLException ex)
        {

            JOptionPane.showMessageDialog(this, "An error occured while signing up", "Expense Tracker", JOptionPane.ERROR_MESSAGE);

        }

    }

}
