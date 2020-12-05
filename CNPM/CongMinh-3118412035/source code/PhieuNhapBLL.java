/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.PhieuNhapData;
import DAL.Search;
import DTO.Phieunhap;
import GUI.JFrameHoaDon;
import GUI.JFramePhieuNhap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Cong Minh
 */
public class PhieuNhapBLL {
    public static void show_info() {
        ArrayList<Phieunhap> list = PhieuNhapData.getListpn();
        DefaultTableModel model = (DefaultTableModel) JFramePhieuNhap.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMapn();
            row[1] = list.get(i).getMaxept();
            row[2] = list.get(i).getManv();
            row[3] = list.get(i).getTennv();
            row[4] = list.get(i).getMancc();
            row[5] = list.get(i).getNgaylap();
            row[6] = list.get(i).getThanhtien();
            model.addRow(row);
        }
        JFramePhieuNhap.tb1.setModel(model);
        }
    
    public static void getField() {
        try{
        JFramePhieuNhap.txt1.setEnabled(false);
        int selectedRow = JFramePhieuNhap.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFramePhieuNhap.tb1.getModel();
        JFramePhieuNhap.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFramePhieuNhap.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFramePhieuNhap.txt8.setText(model.getValueAt(selectedRow, 2).toString());
        JFramePhieuNhap.txt3.setText(model.getValueAt(selectedRow, 3).toString());
        JFramePhieuNhap.txt9.setText(model.getValueAt(selectedRow, 4).toString());
        JFramePhieuNhap.txt5.setText(model.getValueAt(selectedRow, 5).toString());
        JFramePhieuNhap.txt6.setText(model.getValueAt(selectedRow, 6).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    
    public static void refresh(){
        JFramePhieuNhap.txt1.setText(null);
        JFramePhieuNhap.txt2.setText(null);
        JFramePhieuNhap.txt8.setText(null);
        JFramePhieuNhap.txt3.setText(null);
        JFramePhieuNhap.txt9.setText(null);
        JFramePhieuNhap.txt5.setText(null);
        JFramePhieuNhap.txt6.setText(null);
        JFramePhieuNhap.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<Phieunhap> pt = PhieuNhapData.addStaff(JFramePhieuNhap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuNhap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<Phieunhap> pt = PhieuNhapData.deleteStaff(JFramePhieuNhap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuNhap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    

    public static void updateStaff() {
        ArrayList<Phieunhap> pt = PhieuNhapData.updateStaff(JFramePhieuNhap.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFramePhieuNhap.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameHoaDon.txt7.getText().length() == 0) {
            String sql1 = "SELECT * from phieu_nhap ";
            Search.LoadData(sql1, JFrameHoaDon.tb2);
        }
        else {
            String sql1 = "SELECT * from hoa_don WHERE Ma_pn like N'%"+JFrameHoaDon.txt7.getText()+"%' "+ "or Ma_ncc like N'%"+JFrameHoaDon.txt7.getText()+"%'";
            Search.LoadData(sql1, JFrameHoaDon.tb2);
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
                DefaultTableModel model = (DefaultTableModel) JFramePhieuNhap.tb2.getModel();
                // ten Cot
                for (int j = 0; j < JFramePhieuNhap.tb2.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFramePhieuNhap.tb2.getRowCount(); j++) {
                    for (int k = 0; k < JFramePhieuNhap.tb2.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu!");
         
    }   
        }
        }
}