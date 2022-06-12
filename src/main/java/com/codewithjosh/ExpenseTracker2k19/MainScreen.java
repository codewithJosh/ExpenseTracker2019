package main.java.com.codewithjosh.ExpenseTracker2k19;

import javax.swing.*;

public class MainScreen extends JFrame {

    public static void main(String args[]) {

        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

                if ("Windows".equals(info.getName())) {

                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }

            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        java.awt.EventQueue.invokeLater(()
                -> {

            new MainScreen().setVisible(true);

        });

    }

}
