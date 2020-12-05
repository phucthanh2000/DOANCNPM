/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Khuyenmai;
import GUI.JFrameKhuyenmai;
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
public class KhuyenmaiData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<Khuyenmai> getListnv() {

        ArrayList<Khuyenmai> ListNV = new ArrayList<Khuyenmai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM khuyen_mai order by Ma_Chuong_trinh asc");
            rs = ps.executeQuery();
            Khuyenmai nv;
            while (rs.next()) {
                nv = new Khuyenmai(rs.getString("Ma_Chuong_trinh"), rs.getString("Ten_Chuong_trinh"), rs.getString("Ma_San_pham"),rs.getDate("Ngay_bd"),rs.getDate("Ngay_kt"));
                ListNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListNV;
    }

    public static ArrayList<Khuyenmai> ListNV(String mact) {
        ArrayList<Khuyenmai> list = new ArrayList<Khuyenmai>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM khuyen_mai where Ma_Chuong_trinh = '" + JFrameKhuyenmai.txt8.getText() + "'");
            rs = ps.executeQuery();

            Khuyenmai nv;
            while (rs.next()) {
                nv = new Khuyenmai(
                        rs.getString("Ma_Chuong_trinh"),
                        rs.getString("Ten_Chuong_trinh"),                      
                        rs.getString("Ma_San_pham"),
                        rs.getDate("Ngay_bd"),
                        rs.getDate("Ngay_kt")

                );
                list.add(nv);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<Khuyenmai> addStaff(String mact) {
        ArrayList<Khuyenmai> list = new ArrayList<Khuyenmai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO khuyen_mai"
                    + "(Ma_Chuong_trinh, Ten_Chuong_trinh, Ma_San_pham, Ngay_bd, Ngay_kt)"
                    + "VALUES ('" + JFrameKhuyenmai.txt1.getText() + "','" + JFrameKhuyenmai.txt2.getText() + "','" + JFrameKhuyenmai.txt3.getText() + "','" + Date.valueOf(JFrameKhuyenmai.txt4.getText()) + "','" + Date.valueOf(JFrameKhuyenmai.txt5.getText()) + "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameKhuyenmai.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<Khuyenmai> deleteStaff(String mact) {
        ArrayList<Khuyenmai> list = new ArrayList<Khuyenmai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM khuyen_mai where Ma_Chuong_trinh = '" + JFrameKhuyenmai.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameKhuyenmai.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<Khuyenmai> updateStaff(String mact) {
        ArrayList<Khuyenmai> list = new ArrayList<Khuyenmai>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE khuyen_mai SET Ten_Chuong_trinh`='" + JFrameKhuyenmai.txt2.getText() + "',Ma_Chuong_trinh`='" + JFrameKhuyenmai.txt1.getText() + "',`Ma_San_pham`='" + JFrameKhuyenmai.txt3.getText() + "',`Ngay_bd`='" + Date.valueOf(JFrameKhuyenmai.txt4.getText()) + "',`Ngay_kt`='" + Date.valueOf(JFrameKhuyenmai.txt5.getText()) + "' WHERE Ma_Chuong_trinh = '" + mact+ "'");
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