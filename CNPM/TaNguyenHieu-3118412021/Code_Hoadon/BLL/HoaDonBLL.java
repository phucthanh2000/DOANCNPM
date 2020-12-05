/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HoaDonData;
import DAL.Search;
import DTO.HoaDon;
import GUI.JFrameHoaDon;
import GUI.JFrameThongKe;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F
 */
public class HoaDonBLL {
        public static void show_info() {
        ArrayList<HoaDon> list = HoaDonData.getListhd();
        DefaultTableModel model = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMahd();
            row[1] = list.get(i).getManv();
            row[2] = list.get(i).getMakh();
            row[3] = list.get(i).getTenkh();
            row[4] = list.get(i).getTensp();
            row[5] = list.get(i).getSl();
            row[6] = list.get(i).getThanhtien();
            row[7] = list.get(i).getNgaylap();
            model.addRow(row);
        }
        JFrameHoaDon.tb3.setModel(model);
        }

    public static void getField() {
        try{
        JFrameHoaDon.txt1.setEnabled(false);
        int selectedRow = JFrameHoaDon.tb3.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
        JFrameHoaDon.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameHoaDon.txt3.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameHoaDon.txt4.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameHoaDon.txt5.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameHoaDon.txt2.setText(model.getValueAt(selectedRow, 4).toString());
        JFrameHoaDon.txt6.setText(model.getValueAt(selectedRow, 5).toString());
        JFrameHoaDon.txt8.setText(model.getValueAt(selectedRow, 6).toString());
        JFrameHoaDon.txt9.setText(model.getValueAt(selectedRow, 7).toString());
       
        JFrameHoaDon.ta.append("Mã hóa đơn: "+model.getValueAt(selectedRow, 0).toString()+"\n");
        JFrameHoaDon.ta.append("Mã nhân viên: "+model.getValueAt(selectedRow, 1).toString()+"\n");
        JFrameHoaDon.ta.append("Tên khách hàng: "+ model.getValueAt(selectedRow, 3).toString()+"\n");
        JFrameHoaDon.ta.append("Tên sản phẩm: "+model.getValueAt(selectedRow, 4).toString()+"\n");
        JFrameHoaDon.ta.append("Số lượng: "+model.getValueAt(selectedRow, 5).toString()+"\n");
        JFrameHoaDon.ta.append("Thành tiền: "+model.getValueAt(selectedRow, 5).toString()+" đồng"+"\n");
        JFrameHoaDon.ta.append("\t\tNgày lập: "+model.getValueAt(selectedRow, 6).toString());

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameHoaDon.txt1.setText(null);
        JFrameHoaDon.txt3.setText(null);
        JFrameHoaDon.txt4.setText(null);
        JFrameHoaDon.txt5.setText(null);
        JFrameHoaDon.txt2.setText(null);
                JFrameHoaDon.txt6.setText(null);
        JFrameHoaDon.txt8.setText(null);
        JFrameHoaDon.txt9.setText(null);
        JFrameHoaDon.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<HoaDon> hd = HoaDonData.addStaff(JFrameHoaDon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<HoaDon> hd = HoaDonData.deleteStaff(JFrameHoaDon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<HoaDon> hd = HoaDonData.updateStaff(JFrameHoaDon.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameHoaDon.txt7.getText().length() == 0) {
            String sql1 = "SELECT * from hoa_don ";
            Search.LoadData(sql1, JFrameHoaDon.tb2);
        }
        else {
            String sql1 = "SELECT * from hoa_don WHERE Ma_hd like N'%"+JFrameHoaDon.txt7.getText()+"%' "+ "or Ma_kh like N'%"+JFrameHoaDon.txt7.getText()+"%'";
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
                DefaultTableModel model = (DefaultTableModel) JFrameHoaDon.tb3.getModel();
                // ten Cot
                for (int j = 0; j < JFrameHoaDon.tb3.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < JFrameHoaDon.tb3.getRowCount(); j++) {
                    for (int k = 0; k < JFrameHoaDon.tb3.getColumnCount(); k++) {
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
    public static void save(){
                try {
            JFileChooser jfc = new JFileChooser("Save");
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String content = JFrameHoaDon.ta.getText();
                jfc.setDialogTitle("Save File");
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile()+".txt");
                fos.write(content.getBytes());
                fos.flush();
                fos.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công");
            }

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
    }
}
