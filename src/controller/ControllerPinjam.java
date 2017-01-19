/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelPinjam;
import util.Koneksi;

/**
 *
 * @author andreJR
 */
public class ControllerPinjam {
    Koneksi koneksi = new Koneksi();
    public void simpanPinjaman(ModelPinjam mp) { 
        try {
            koneksi.koneksiDatabase();
            String querySimpanPinjaman = "insert into tbl_pinjam(namaTeman,barangDipinjam)"
                + " values('" + mp.getNama() + "','" + mp.getBarang() + "')";
            koneksi.state.executeUpdate(querySimpanPinjaman);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("errorSimpanpinjam : " + e);
        }
    }
    
    public void hapusDataPinjam(ModelPinjam mp){
        try {
            koneksi.koneksiDatabase();
            String queryHapusPinjam = "delete from tbl_pinjam where id=('"+mp.getId()+"')";
            koneksi.state.executeUpdate(queryHapusPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
        } catch (SQLException e) {
            System.err.println("errorHapuspinjam: "+e);
            JOptionPane.showMessageDialog(null, "Data Tidak terhapus");
        }
    }
    
    public void ubahDataPinjam(ModelPinjam mp){
         try {
            koneksi.koneksiDatabase();
            String queryUbahPinjam = "update tbl_pinjam "
                    + "set barangDipinjam=('"+ mp.getBarang() +"') where id=('" + mp.getId() + "')";
            koneksi.state.executeUpdate(queryUbahPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } catch (SQLException e) {
            System.err.println("errorUbahpinjam : " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak terubah");
        }
    }
}
