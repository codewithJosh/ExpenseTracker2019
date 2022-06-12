package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.ExpenseTracker;

public class RegisterScreen extends JFrame {

    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnMode;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblRePassword;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblTail;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JButton navLogin;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPasswordField pfRePassword;
    private javax.swing.JTextField tfUsername;

    ExpenseTracker et;
    static int iCurrentXPosition = 0;
    static int iCurrentYPosition = 0;
    int iFuture = 0;
    int iCurrent = 0;

    public RegisterScreen() {

        initComponents();
        initInstances();
        initIcons();

    }

    private void initComponents() {

        HeadPanel = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblHead = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        tfUsername = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        pfRePassword = new javax.swing.JPasswordField();
        lblQuestion = new javax.swing.JLabel();
        navLogin = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblRePassword = new javax.swing.JLabel();
        lblTail = new javax.swing.JLabel();
        btnMode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimize.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnMinimize.setForeground(new java.awt.Color(240, 240, 240));
        btnMinimize.setText("—");
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnMinimizeActionPerformed(evt);
        });
        HeadPanel.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 30));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnClose.setForeground(new java.awt.Color(240, 240, 240));
        btnClose.setText("X");
        btnClose.setContentAreaFilled(false);
        btnClose.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnCloseFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnCloseFocusLost(evt);
            }
        });
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnCloseActionPerformed(evt);
        });
        HeadPanel.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 0, -1, 30));

        lblHead.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblHeadMouseDragged(evt);
            }
        });
        lblHead.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHeadMousePressed(evt);
            }
        });
        HeadPanel.add(lblHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        getContentPane().add(HeadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        BodyPanel.setForeground(new java.awt.Color(240, 240, 240));
        BodyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUsername.setFont(new java.awt.Font("Dialog", 0, 14));
        tfUsername.setBorder(null);
        tfUsername.setOpaque(false);
        BodyPanel.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 220, 30));

        pfPassword.setFont(new java.awt.Font("Dialog", 0, 14));
        pfPassword.setBorder(null);
        pfPassword.setOpaque(false);
        BodyPanel.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 220, 30));

        pfRePassword.setFont(new java.awt.Font("Dialog", 0, 14));
        pfRePassword.setBorder(null);
        pfRePassword.setOpaque(false);
        BodyPanel.add(pfRePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 220, 30));

        lblQuestion.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblQuestion.setText("Already have an account?");
        BodyPanel.add(lblQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 450, -1, -1));

        navLogin.setContentAreaFilled(false);
        navLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BodyPanel.add(navLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 147, 33));

        lblPassword.setFont(new java.awt.Font("Dialog", 0, 14));
        lblPassword.setText("Password");
        BodyPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 20));

        lblSignUp.setFont(new java.awt.Font("Arial", 0, 18));
        lblSignUp.setText("Sign Up");
        BodyPanel.add(lblSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BodyPanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 103, 33));

        lblUsername.setFont(new java.awt.Font("Dialog", 0, 14));
        lblUsername.setText("Username");
        BodyPanel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, 20));

        lblRePassword.setFont(new java.awt.Font("Dialog", 0, 14));
        lblRePassword.setText("Re-Enter Password");
        BodyPanel.add(lblRePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 220, 20));
        BodyPanel.add(lblTail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 400, 170));

        btnMode.setContentAreaFilled(false);
        btnMode.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnModeFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnModeFocusLost(evt);
            }
        });
        btnMode.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModeMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModeMouseExited(evt);
            }
        });
        btnMode.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnModeActionPerformed(evt);
        });
        btnMode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BodyPanel.add(btnMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 30, 55, 52));

        getContentPane().add(BodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 520));

        pack();
        setLocationRelativeTo(null);

    }

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {

        setState(ICONIFIED);

    }

    private void btnCloseFocusGained(java.awt.event.FocusEvent evt) {

        btnClose.setForeground(new java.awt.Color(255, 51, 51));

    }

    private void btnCloseFocusLost(java.awt.event.FocusEvent evt) {

        btnClose.setForeground(new java.awt.Color(240, 240, 240));

    }

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {

        btnClose.setForeground(new java.awt.Color(255, 51, 51));

    }

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {

        btnClose.setForeground(new java.awt.Color(240, 240, 240));

    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {

        System.exit(0);

    }

    private void lblHeadMousePressed(java.awt.event.MouseEvent evt) {

        iCurrentXPosition = evt.getX();
        iCurrentYPosition = evt.getY();

    }

    private void lblHeadMouseDragged(java.awt.event.MouseEvent evt) {

        final int iFutureXPosition = evt.getXOnScreen();
        final int iFutureYPosition = evt.getYOnScreen();

        setLocation(iFutureXPosition - iCurrentXPosition, iFutureYPosition - iCurrentYPosition);

    }

    private void btnModeFocusGained(java.awt.event.FocusEvent evt) {

        onMode();

    }

    private void btnModeFocusLost(java.awt.event.FocusEvent evt) {

        offMode();

    }

    private void btnModeMouseEntered(java.awt.event.MouseEvent evt) {

        onMode();

    }

    private void btnModeMouseExited(java.awt.event.MouseEvent evt) {

        offMode();

    }

    private void btnModeActionPerformed(java.awt.event.ActionEvent evt) {

        switch (iCurrent) {

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

    public static void main(String args[]) {

        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

                if ("Windows".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }

            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        java.awt.EventQueue.invokeLater(()
                -> {

            new RegisterScreen().setVisible(true);

        });

    }

    private void initInstances() {

        et = new ExpenseTracker();

    }

    private void initIcons() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(et.getString("logo"))));
        lblHead.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("head"))));
        navLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("navlogin"))));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("register"))));
        lblTail.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("tailregister"))));

        lblUsername.grabFocus();
        tfUsername.setText("Enter your Username");
        pfPassword.setText("******");
        pfRePassword.setText("******");

        switch (iCurrent) {

            case 0:
                onDayMode(true);
                break;

            case 1:
                onNightMode(true);
                break;

        }

    }

    private void onMode() {

        switch (iFuture) {
            case 0:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("dayhover"))));
                break;

            case 1:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("nighthover"))));
                break;
        }

    }

    private void offMode() {

        switch (iFuture) {

            case 0:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("day"))));
                break;

            case 1:
                btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("night"))));
                break;

        }

    }

    public void onDayMode(boolean isInitial) {

        final String sUsername = tfUsername.getText().toLowerCase().trim();
        final String sPassword = pfPassword.getText().trim();
        final String sRePassword = pfRePassword.getText().trim();

        BodyPanel.setBackground(new java.awt.Color(240, 240, 240));
        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(isInitial ? et.getString("night") : et.getString("nighthover"))));
        lblUsername.setForeground(new java.awt.Color(51, 51, 51));
        lblPassword.setForeground(new java.awt.Color(51, 51, 51));
        lblRePassword.setForeground(new java.awt.Color(51, 51, 51));
        lblSignUp.setForeground(new java.awt.Color(51, 51, 51));

        if (sUsername.equals("enter your username")) {

            tfUsername.setForeground(Color.BLACK);
            tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }
        if (sPassword.equals("******")) {

            pfPassword.setForeground(Color.BLACK);
            pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }
        if (sRePassword.equals("******")) {

            pfRePassword.setForeground(Color.BLACK);
            pfRePassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        }

        iFuture = 1;

    }

    public void onNightMode(boolean isInitial) {

        final String sUsername = tfUsername.getText().toLowerCase().trim();
        final String sPassword = pfPassword.getText().trim();
        final String sRePassword = pfRePassword.getText().trim();

        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(isInitial ? et.getString("day") : et.getString("dayhover"))));
        BodyPanel.setBackground(new java.awt.Color(41, 41, 41));
        lblUsername.setForeground(new java.awt.Color(240, 240, 240));
        lblPassword.setForeground(new java.awt.Color(240, 240, 240));
        lblRePassword.setForeground(new java.awt.Color(240, 240, 240));
        lblSignUp.setForeground(new java.awt.Color(240, 240, 240));

        if (sUsername.equals("enter your username")) {

            tfUsername.setForeground(Color.GRAY);
            tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }
        if (sPassword.equals("******")) {

            pfPassword.setForeground(Color.GRAY);
            pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }
        if (sRePassword.equals("******")) {

            pfRePassword.setForeground(Color.GRAY);
            pfRePassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));

        }

        iFuture = 0;

    }

}
