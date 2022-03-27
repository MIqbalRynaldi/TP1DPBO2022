package tp1dpbo2022;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Iqbal Rynaldi
 */

import components.PopupMessage;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class dbConnection {
    public static Connection con;
    public static Statement stm;
    private PopupMessage popup = new PopupMessage();
    
    public void connect(){
        try{
            String url = "jdbc:mysql://localhost/tp1dpbo2022";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            stm = con.createStatement();
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException e){
            popup.textMessage.setText("Koneksi Gagal " + e.getMessage());
            popup.tampil();
        }
    }
    
    public ResultSet query(String input){
        ResultSet res = null;
        try{
            connect();
            String sql = input;
            res = stm.executeQuery(sql);
        }catch(SQLException e){
            System.err.println("Read Gagal " + e.getMessage());
            popup.textMessage.setText("Read Gagal " + e.getMessage());
            popup.tampil();
        }
        return res;
    }
}