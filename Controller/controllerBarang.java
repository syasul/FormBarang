/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.*;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormBarang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author T470s
 */
public class controllerBarang {
    FormBarang frame;
    List<Barang> listBrg;
    daoBarang daoBrg = new daoBarang();
    Barang brg = new Barang();
    
    public controllerBarang(FormBarang frame) {
        this.frame = frame;
        listBrg = daoBrg.getData();
    }
    
    public void tampil_label() {
        TabelModelBarang tabelBrg = new TabelModelBarang(listBrg);
            frame.getTblBarang().setModel(tabelBrg);
    }
    
    public void tambahData() {
        if (frame.getTextKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Diisi");
        } else {
            brg.setKode(frame.getTextKode().getText());
            brg.setNama(frame.getTextNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerk(frame.getTextMerek().getText());
            daoBrg.tambah(brg);
            JOptionPane.showMessageDialog(frame,"Berhasil mengubah data");
        }
    }
    
    public void hapusData() {
        brg.setKode(frame.getTextKode().getText());
        daoBrg.hapus(brg);
        JOptionPane.showMessageDialog(frame, "Berhasil Mengahpus data");
    }
    
    public void bersih() {
        frame.setTxtKode("");
        frame.setTxtNama("");
        frame.setTxtJumlah(0);
        frame.setTxtHarga(0);
        frame.setTxtMerek("");
    }
    
    public void keluar() {
        frame.dispose();
    }
}
