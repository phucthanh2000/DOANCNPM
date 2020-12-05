package BLL;

import DAL.CongNoData;
import DAL.Search;
import DTO.CongNo;
import GUI.JFrameCongNo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F
 */
public class CongNoBLL {
        public static void show_info() {
        ArrayList<CongNo> list = CongNoData.getListnv();
        DefaultTableModel model = (DefaultTableModel) JFrameCongNo.tb1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMakh();
            row[1] = list.get(i).getTenkh();
            row[2] = list.get(i).getHantt();
            row[3] = list.get(i).getTientt();
            row[4] = list.get(i).getConlai();
            model.addRow(row);
        }
        JFrameCongNo.tb1.setModel(model);
        }

    public static void getField() {
        try{
        JFrameCongNo.txt1.setEnabled(false);
        int selectedRow = JFrameCongNo.tb1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) JFrameCongNo.tb1.getModel();
        JFrameCongNo.txt1.setText(model.getValueAt(selectedRow, 0).toString());
        JFrameCongNo.txt2.setText(model.getValueAt(selectedRow, 1).toString());
        JFrameCongNo.txt3.setText(model.getValueAt(selectedRow, 2).toString());
        JFrameCongNo.txt4.setText(model.getValueAt(selectedRow, 3).toString());
        JFrameCongNo.txt5.setText(model.getValueAt(selectedRow, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public static void refresh(){
        JFrameCongNo.txt1.setText(null);
        JFrameCongNo.txt2.setText(null);
        JFrameCongNo.txt3.setText(null);
        JFrameCongNo.txt4.setText(null);
        JFrameCongNo.txt5.setText(null);
        JFrameCongNo.txt1.setEnabled(true);
    }
    public static void addStaff() {
        ArrayList<CongNo> congno = CongNoData.addStaff(JFrameCongNo.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameCongNo.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<CongNo> congno = CongNoData.deleteStaff(JFrameCongNo.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameCongNo.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }

    public static void updateStaff() {
        ArrayList<CongNo> congno = CongNoData.updateStaff(JFrameCongNo.txt1.getText());
        DefaultTableModel model2 = (DefaultTableModel) JFrameCongNo.tb1.getModel();
        model2.setRowCount(0);
        show_info();
    }
    public static void sreachStaff()
    {
        if(JFrameCongNo.txt8.getText().length() == 0) {
            String sql1 = "SELECT * from cong_no ";
            Search.LoadData(sql1, JFrameCongNo.tb3);
        }
        else {
            String sql1 = "SELECT * from cong_no WHERE Ma_kh like N'%"+JFrameCongNo.txt8.getText()+"%' "+ "or Ten_kh like N'%"+JFrameCongNo.txt8.getText()+"%'";
            Search.LoadData(sql1, JFrameCongNo.tb3);
        }
    }
}