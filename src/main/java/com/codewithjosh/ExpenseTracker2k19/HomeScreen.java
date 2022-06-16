package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.*;
import java.util.logging.*;
import javax.swing.*;
import main.java.com.codewithjosh.ExpenseTracker2k19.functions.ExpenseTracker;

public class HomeScreen extends JFrame
{

    private javax.swing.JPanel BodyPanel;
    private javax.swing.JButton nav;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblCenterStart;
    private javax.swing.JLabel lblCenterEnd;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblProjectTitle;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JButton btnMode;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JTextArea taDescription;

    ExpenseTracker et;
    static int iCurrentXPosition = 0;
    static int iCurrentYPosition = 0;
    int iCurrent = 0;

    public HomeScreen()
    {

        initComponents();
        initInstances();
        initIcons();

    }

    private void initComponents()
    {

        HeadPanel = new javax.swing.JPanel();
        lblProjectTitle = new javax.swing.JLabel();
        btnMode = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblHead = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        taDescription = new javax.swing.JTextArea();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        nav = new javax.swing.JButton();
        lblStart = new javax.swing.JLabel();
        lblCenterStart = new javax.swing.JLabel();
        lblCenterEnd = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeadPanel.setBackground(new java.awt.Color(44, 59, 255));
        HeadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProjectTitle.setText("Expense Tracker");
        lblProjectTitle.setForeground(Color.WHITE);
        lblProjectTitle.setFont(new java.awt.Font("Dialog", 0, 11));
        HeadPanel.add(lblProjectTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 290, 30));

        btnMode.setContentAreaFilled(false);
        btnMode.addActionListener((java.awt.event.ActionEvent evt)
                ->
        {
            btnModeActionPerformed(evt);
                });
        HeadPanel.add(btnMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

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

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblTitle.setForeground(Color.WHITE);
        BodyPanel.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        taDescription.setEditable(false);
        taDescription.setColumns(20);
        taDescription.setFont(new java.awt.Font("Monospaced", 1, 14));
        taDescription.setForeground(Color.WHITE);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setWrapStyleWord(true);
        taDescription.setFocusable(false);
        taDescription.setOpaque(false);
        BodyPanel.add(taDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 220, -1));

        btnPrevious.setFont(new java.awt.Font("Arial Narrow", 2, 48));
        btnPrevious.setContentAreaFilled(false);
        btnPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevious.setText("<");
        BodyPanel.add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 50));

        btnNext.setFont(new java.awt.Font("Arial Narrow", 2, 48));
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setText(">");
        BodyPanel.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 50));

        nav.setContentAreaFilled(false);
        nav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BodyPanel.add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 300, 147, 33));

        BodyPanel.add(lblStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 85, 10));

        BodyPanel.add(lblCenterStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 450, 85, 10));

        BodyPanel.add(lblCenterEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 450, 85, 10));

        BodyPanel.add(lblEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 85, 10));
        BodyPanel.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 365));

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

    private void btnModeActionPerformed(java.awt.event.ActionEvent evt)
    {

        switch (iCurrent)
        {

            case 0:
                onNightMode();
                iCurrent = 1;
                break;

            case 1:
                onDayMode();
                iCurrent = 0;
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

        et = new ExpenseTracker();

    }

    private void initIcons()
    {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(et.getString("logo"))));
        lblHead.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("head"))));

    }

    public void onDayMode()
    {

        BodyPanel.setBackground(new java.awt.Color(240, 240, 240));
        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("moon"))));
        btnNext.setForeground(new java.awt.Color(240, 240, 240));
        btnPrevious.setForeground(new java.awt.Color(240, 240, 240));

    }

    public void onNightMode()
    {

        BodyPanel.setBackground(new java.awt.Color(41, 41, 41));
        btnMode.setIcon(new javax.swing.ImageIcon(getClass().getResource(et.getString("sun"))));
        btnNext.setForeground(new java.awt.Color(130, 130, 130));
        btnPrevious.setForeground(new java.awt.Color(130, 130, 130));

    }

}
