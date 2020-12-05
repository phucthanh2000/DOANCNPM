/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanvienData;
import DAL.Search;
import DTO.Nhanvien;
import GUI.JFrameNhanvien;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F
 */
public class NhanvienBLL {
        public static void show_info() {
        ArrayList<Nhanvien> list = NhanvienData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaNV();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getNgaySinh();
            row[3] = list.get(i).getDiaChi();
            row[4] = list.get(i).getSdt();
            model.addRow(row);
        }
        JFrameNhanvien.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameNhanvien.txt1.setEnabled(false);
        int selectedRow = JFrameNhanvien.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
        JFrameNhanvien.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameNhanvien.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameNhanvien.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameNhanvien.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameNhanvien.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameNhanvien.txt1.setText(null);
        JFrameNhanvien.txt2.setText(null);
        JFrameNhanvien.txt3.setText(null);
        JFrameNhanvien.txt4.setText(null);
        JFrameNhanvien.txt5.setText(null);
        JFrameNhanvien.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.addStaff(JFrameNhanvien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.deleteStaff(JFrameNhanvien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<Nhanvien> nhanvien = NhanvienData.updateStaff(JFrameNhanvien.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameNhanvien.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from nhan_vien ";
            Search.LoadData(sql1, JFrameNhanvien.tb2);
        }
        else {
            String sql1 = "SELECT * from nhan_vien WHERE Ma_Nhan_vien like N'%"+JFrameNhanvien.txt8.getText()+"%' "+ "or Ten_Nhan_vien like N'%"+JFrameNhanvien.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameNhanvien.tb2);
        }
    }
    public static void save1(){
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) JFrameNhanvien.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameNhanvien.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameNhanvien.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameNhanvien.tb1.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
         
    }   
        }
        }
}
