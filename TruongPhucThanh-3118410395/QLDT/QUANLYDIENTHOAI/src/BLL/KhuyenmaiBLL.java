/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhuyenmaiData;
import DAL.Search;
import DTO.Khuyenmai;
import GUI.JFrameKhuyenmai;
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
public class KhuyenmaiBLL {
        public static void show_info() {
        ArrayList<Khuyenmai> list = KhuyenmaiData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMact();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getMasp();
            row[3] = list.get(i).getNgaybd();
            row[4] = list.get(i).getNgaykt();
            model.addRow(row);
        }
        JFrameKhuyenmai.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameKhuyenmai.txt1.setEnabled(false);
        int selectedRow = JFrameKhuyenmai.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
        JFrameKhuyenmai.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameKhuyenmai.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameKhuyenmai.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameKhuyenmai.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameKhuyenmai.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameKhuyenmai.txt1.setText(null);
        JFrameKhuyenmai.txt2.setText(null);
        JFrameKhuyenmai.txt3.setText(null);
        JFrameKhuyenmai.txt4.setText(null);
        JFrameKhuyenmai.txt5.setText(null);
        JFrameKhuyenmai.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Khuyenmai> nhanvien = KhuyenmaiData.addStaff(JFrameKhuyenmai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Khuyenmai> nhanvien = KhuyenmaiData.deleteStaff(JFrameKhuyenmai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<Khuyenmai> nhanvien = KhuyenmaiData.updateStaff(JFrameKhuyenmai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameKhuyenmai.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from khuyen_mai ";
            Search.LoadData(sql1, JFrameKhuyenmai.tb2);
        }
        else {
            String sql1 = "SELECT * from khuyen_mai WHERE Ma_CHuong_trinh like N'%"+JFrameKhuyenmai.txt8.getText()+"%' "+ "or Ten_Chuong_trinh like N'%"+JFrameKhuyenmai.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameKhuyenmai.tb2);
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
                DefaultTableModel model = (DefaultTableModel) JFrameKhuyenmai.tb1.getModel();
                // ten Cot
                for (int j = 0; j < JFrameKhuyenmai.tb1.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameKhuyenmai.tb1.getRowCount(); j++) {
                    for (int k = 0; k < JFrameKhuyenmai.tb1.getColumnCount(); k++) {
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