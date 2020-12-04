/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.NhaCungCapData;
import DAL.Search;
import DTO.Nhacungcap;
import GUI.JFrameNhaCungCap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer
 */
public class NhaCungCapBLL {
    public static void show_info() {
        ArrayList<Nhacungcap> list = NhaCungCapData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameNhaCungCap.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMancc();
            row[1] = list.get(i).getTenncc();
            row[2] = list.get(i).getDiachi();
            row[3] = list.get(i).getSdt();
            row[4] = list.get(i).getEmail();
           
            model.addRow(row);
        }
        JFrameNhaCungCap.tb1.setModel(model);
        }
    
    public static void getField() {
        try{
        JFrameNhaCungCap.txt1.setEnabled(false);
        int selectedRow = JFrameNhaCungCap.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameNhaCungCap.tb1.getModel();
        JFrameNhaCungCap.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameNhaCungCap.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameNhaCungCap.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameNhaCungCap.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameNhaCungCap.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    
    public static void refresh(){
        JFrameNhaCungCap.txt1.setText(null);
        JFrameNhaCungCap.txt2.setText(null);
        JFrameNhaCungCap.txt3.setText(null);
        JFrameNhaCungCap.txt4.setText(null);
                JFrameNhaCungCap.txt5.setText(null);

        JFrameNhaCungCap.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Nhacungcap> ncc = NhaCungCapData.addStaff(JFrameNhaCungCap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhaCungCap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Nhacungcap> ncc = NhaCungCapData.deleteStaff(JFrameNhaCungCap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhaCungCap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<Nhacungcap> ncc = NhaCungCapData.updateStaff(JFrameNhaCungCap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhaCungCap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    
    public static void sreachStaff()
    {
        if(JFrameNhaCungCap.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from nha_cung_cap ";
            Search.LoadData(sql1, JFrameNhaCungCap.tb2);
        }
        else {
            String sql1 = "SELECT * from nha_cung_cap WHERE Ma_ncc like N'%"+JFrameNhaCungCap.txt8.getText()+"%' "+ "or Ten_ncc like N'%"+JFrameNhaCungCap.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameNhaCungCap.tb2);
        }
    }
}
