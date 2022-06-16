package main.java.com.codewithjosh.ExpenseTracker2k19;

import java.awt.EventQueue;
import java.util.logging.*;
import javax.swing.*;

public class IncomeScreen extends JFrame
{

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

            Logger.getLogger(IncomeScreen.class.getName()).log(Level.SEVERE, null, ex);

        }

        EventQueue.invokeLater(()
                ->
        {

            new IncomeScreen().setVisible(true);

                });

    }

}
