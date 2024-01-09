package uas;


import java.sql.*;
import javax.swing.JOptionPane;
public class KoneksiDatabase {
    Connection aam;
    public static Connection BukaKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection aam = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_inventori","root","");
            return aam;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
