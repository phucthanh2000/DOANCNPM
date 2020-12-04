/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TaikhoanData;
import DTO.Taikhoan;
import GUI.JFrameTaikhoan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class TaikhoanBLL {
    public static void show_info() {
        ArrayList<Taikhoan> list = TaikhoanData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameTaikhoan.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getManv();
            row[1] = list.get(i).getChucvu();
            row[2] = list.get(i).getTk();
            row[3] = list.get(i).getMk();
           
            model.addRow(row);
        }
        JFrameTaikhoan.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameTaikhoan.txt1.setEnabled(false);
        int selectedRow = JFrameTaikhoan.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameTaikhoan.tb1.getModel();
        JFrameTaikhoan.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameTaikhoan.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameTaikhoan.txt4.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameTaikhoan.txt5.setText(model.getValueAt(selectedRow, 3).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameTaikhoan.txt1.setText(null);
        JFrameTaikhoan.txt2.setText(null);
        JFrameTaikhoan.txt4.setText(null);
        JFrameTaikhoan.txt5.setText(null);
        JFrameTaikhoan.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Taikhoan> tk = TaikhoanData.addStaff(JFrameTaikhoan.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameTaikhoan.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Taikhoan> tk = TaikhoanData.deleteStaff(JFrameTaikhoan.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameTaikhoan.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<Taikhoan> nhanvien = TaikhoanData.updateStaff(JFrameTaikhoan.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameTaikhoan.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameTaikhoan.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from tai_khoan ";
            Search.LoadData(sql1, JFrameTaikhoan.tb2);
        }
        else {
            String sql1 = "SELECT * from tai_khoan WHERE manv like N'%"+JFrameTaikhoan.txt8.getText()+"%' "+ "or tk like N'%"+JFrameTaikhoan.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameTaikhoan.tb2);
        }
    }
}
