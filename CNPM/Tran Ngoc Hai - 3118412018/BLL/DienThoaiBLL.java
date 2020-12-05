package BLL;

import DAL.DienThoaiData;
import DAL.Search;
import DTO.DienThoai;
import GUI.JFrameDienThoai;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DienThoaiBLL {
        public static void show_info() {
        ArrayList<DienThoai> list = DienThoaiData.getListkx();
        DefaultTableModel model = (DefaultTableModel) JFrameDienThoai.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaDT();
            row[1] = list.get(i).getLoaiDT();
            row[2] = list.get(i).getHangDT();
            row[3] = list.get(i).getTenDT();
            row[4] = list.get(i).getDonGia();
            row[5] = list.get(i).getTrangThai();
            model.addRow(row);
        }
        JFrameDienThoai.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameDienThoai.txt1.setEnabled(false);
        int selectedRow = JFrameDienThoai.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameDienThoai.tb1.getModel();
        JFrameDienThoai.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameDienThoai.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameDienThoai.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameDienThoai.txt6.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameDienThoai.txt7.setText(model.getValueAt(selectedRow, 4).toString());
        JFrameDienThoai.txt4.setText(model.getValueAt(selectedRow, 5).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameDienThoai.txt1.setText(null);
        JFrameDienThoai.txt2.setText(null);
        JFrameDienThoai.txt3.setText(null);
        JFrameDienThoai.txt6.setText(null);
        JFrameDienThoai.txt4.setText(null);
        JFrameDienThoai.txt5.setText(null);
        JFrameDienThoai.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<DienThoai> kx = DienThoaiData.addStaff(JFrameDienThoai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameDienThoai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<DienThoai> kx = DienThoaiData.deleteStaff(JFrameDienThoai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameDienThoai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<DienThoai> kx = DienThoaiData.updateStaff(JFrameDienThoai.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameDienThoai.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameDienThoai.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from dienthoai ";
            Search.LoadData(sql1, JFrameDienThoai.tb2);
        }
        else {
            String sql1 = "SELECT * from dienthoai WHERE Ma_dt like N'%"+JFrameDienThoai.txt8.getText()+"%' "+ "or Ten_dt like N'%"+JFrameDienThoai.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameDienThoai.tb2);
        }
    }
}
