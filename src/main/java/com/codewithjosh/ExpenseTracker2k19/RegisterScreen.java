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
    int future = 0;
    int current = 0;
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

        setLocation(futureXPosition - currentXPosition, futureYPosition
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
        final MainScreen MainScreen = new MainScreen();
        MainScreen.setVisible(true);

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

        pfRePassword.setHorizontalAlignment(JTextField.LEFT);

        String repassword = pfRePassword.getText().trim();

        if (repassword.equals(""))
        {

            pfRePassword.setText("******");

            switch (current)
            {

                case 0:
                    pfRePassword.setForeground(Color.BLACK);
                    pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    break;

                case 1:
                    pfRePassword.setForeground(Color.GRAY);
                    pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                    break;

            }

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

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();
        final String repassword = pfRePassword.getText().trim();

        if (username.equals("enter your username")
                    || password.equals("******")
                    || repassword.equals("******"))
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
            if (repassword.equals("******"))
                switch (current)
                {

                    case 0:
                        pfRePassword.setForeground(Color.BLACK);
                        pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;

                    case 1:
                        pfRePassword.setForeground(Color.GRAY);
                        pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
                        break;

                }

        }
        else if (password.length() < 6)
        {

            JOptionPane.showMessageDialog(null, "Password Must be at least 6 characters!");
            pfPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 51, 51)));
            pfPassword.setForeground(new Color(255, 51, 51));

        }
        else if (!password.equals(repassword))
        {

            JOptionPane.showMessageDialog(null, "Password doesn't match!");
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
        final String repassword = pfRePassword.getText().trim();

        BodyPanel.setBackground(new Color(240, 240, 240));
        btnMode.setIcon(new ImageIcon(getClass().getResource(isInitial
                                                             ? expenseTracker.getString("night")
                                                             : expenseTracker.getString("nighthover"))));
        lblUsername.setForeground(new Color(51, 51, 51));
        lblPassword.setForeground(new Color(51, 51, 51));
        lblRePassword.setForeground(new Color(51, 51, 51));
        lblSignUp.setForeground(new Color(51, 51, 51));

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
        if (repassword.equals("******"))
        {

            pfRePassword.setForeground(Color.BLACK);
            pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }

        future = 1;

    }

    private void onNightMode(boolean isInitial)
    {

        final String username = tfUsername.getText().toLowerCase().trim();
        final String password = pfPassword.getText().trim();
        final String repassword = pfRePassword.getText().trim();

        btnMode.setIcon(new ImageIcon(getClass().getResource(isInitial
                                                             ? expenseTracker.getString("day")
                                                             : expenseTracker.getString("dayhover"))));
        BodyPanel.setBackground(new Color(41, 41, 41));
        lblUsername.setForeground(new Color(240, 240, 240));
        lblPassword.setForeground(new Color(240, 240, 240));
        lblRePassword.setForeground(new Color(240, 240, 240));
        lblSignUp.setForeground(new Color(240, 240, 240));

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
        if (repassword.equals("******"))
        {

            pfRePassword.setForeground(Color.GRAY);
            pfRePassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }

        future = 0;

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
                    JOptionPane.showMessageDialog(null, "You're Successfully Added!");

                    conn.close();
                    dispose();
                    final MainScreen MainScreen = new MainScreen();
                    MainScreen.setVisible(true);

                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Username is Already Taken!");
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

            JOptionPane.showMessageDialog(null, "Please Contact Your Service Provider");
            conn = SQLite.getInstance();

        }

    }

}
