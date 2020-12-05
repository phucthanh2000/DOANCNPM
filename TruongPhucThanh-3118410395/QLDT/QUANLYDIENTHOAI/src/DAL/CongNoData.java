/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.CongNo;
import GUI.JFrameCongNo;
import Utils.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;

/**
 *
 * @author Gaara
 */
public class CongNoData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<CongNo> getListnv() {

        ArrayList<CongNo> ListCN = new ArrayList<CongNo>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM cong_no order by Ma_kh asc");
            rs = ps.executeQuery();
            CongNo cn;
            while (rs.next()) {
                cn = new CongNo(rs.getString("Ma_kh"), rs.getString("Ten_kh"), rs.getDate("Han_tt"), rs.getFloat("Tien_tt"), rs.getFloat("Conlai"));
                ListCN.add(cn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListCN;
    }

    public static ArrayList<CongNo> ListCN(String makh) {
        ArrayList<CongNo> list = new ArrayList<CongNo>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM cong_no where Ma_kh = '" + JFrameCongNo.txt1.getText() + "'");
            rs = ps.executeQuery();

            CongNo cn;
            while (rs.next()) {
                cn = new CongNo(
                        rs.getString("Ma_kh"),
                        rs.getString("Ten_kh"),
                        rs.getDate("Han_tt"),
                        rs.getFloat("Tien_tt"),
                        rs.getFloat("Conlai")

                );
                list.add(cn);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<CongNo> addStaff(String makh) {
        ArrayList<CongNo> list = new ArrayList<CongNo>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `cong_no`"
                    + "(`Ma_kh`, `Ten_kh`, `Han_tt`, `Tien_tt`, `Conlai`)"
                    + "VALUES ('" + JFrameCongNo.txt1.getText() + "','" + JFrameCongNo.txt2.getText() + "','" + Date.valueOf(JFrameCongNo.txt3.getText()) + "','" + JFrameCongNo.txt4.getText() + "','" + JFrameCongNo.txt5.getText()+ "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameCongNo.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<CongNo> deleteStaff(String makh) {
        ArrayList<CongNo> list = new ArrayList<CongNo>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `cong_no` where Ma_kh = '" + JFrameCongNo.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameCongNo.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thành công");

        }

        return list;
    }

    public static ArrayList<CongNo> updateStaff(String makh) {
        ArrayList<CongNo> list = new ArrayList<CongNo>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `cong_no` SET `Ten_kh`='" + JFrameCongNo.txt2.getText() + "',`Ma_kh`='" + JFrameCongNo.txt1.getText() + "',`Han_tt`='" + Date.valueOf(JFrameCongNo.txt3.getText()) + "',`Tien_tt`='" + JFrameCongNo.txt4.getText() + "',`Conlai`='" + JFrameCongNo.txt5.getText() + "' WHERE Ma_kh = '" + makh+ "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa thành công !! ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    public static void sreachStaff (String sql,JTable tb) {
         try{
            ps = (PreparedStatement) Connect.getConnect().prepareStatement(sql);
            rs = ps.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e ,"Thông báo lỗi",1);
        }
    }
    
}
