package main.java.com.codewithjosh.ExpenseTracker2k19.functions;

import java.sql.*;
import java.util.logging.*;

public class SQLite
{

    Connection conn = null;

    public static Connection getInstance()
    {

        try
        {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:expense-tracker-2k19.db");
            return conn;

        }
        catch (ClassNotFoundException
               | SQLException ex)
        {

            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }

    }

}
