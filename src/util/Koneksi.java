/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andreJR
 */
public class Koneksi {
    public Statement state;
    public Connection connect;
    String namaDatabase = "jdbc:mysql://localhost/db_uas_15312615";
    
    public void koneksiDatabase(){
        try {
        connect = DriverManager.getConnection(namaDatabase,"root","123");
        state = connect.createStatement();
        System.out.println("berhasil terhubung");
        } 
        catch (SQLException err) {
            System.out.println("erorr"+err);
        }
    }
}
