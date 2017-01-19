/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author andreJR
 */
public class ControllerTeman {
    Koneksi koneksi =new Koneksi();
    
    public void simpanTeman(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
            String querySimpanTeman = "insert into tbl_teman(nama,nope,email) values('"+mt.getNama()+"','"+mt.getNope()+"','"+mt.getEmail()+"')";
            koneksi.state.executeUpdate(querySimpanTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("eroorSimpanteman: "+e);
        }
    }
    public void hapusDataTeman(ModelTeman mt){
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataTeman = "delete from tbl_teman where id=('"+mt.getId()+"')";
            koneksi.state.executeUpdate(queryHapusDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
        } catch (SQLException e) {
            System.err.println(" erorrHapusteman : "+e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terhapus");
        }
    }
     public void ubahDataTeman(ModelTeman mt){
        koneksi.koneksiDatabase();
         try {
             String queryUbahDataTeman = "update tbl_teman "
                    + "set nama=('" + mt.getNama() + "'),"
                    + "nope=('"+ mt.getNope() +"'),"
                    + "email=('"+ mt.getEmail() +"')"
                    + "where id=('" + mt.getId() + "')";
            koneksi.state.executeUpdate(queryUbahDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } catch (SQLException e) {
            System.err.println("erorrUbahteman : " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terubah");
        }
    }
}
