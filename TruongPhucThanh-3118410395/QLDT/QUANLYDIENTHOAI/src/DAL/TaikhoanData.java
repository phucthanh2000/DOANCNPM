/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
//import static DAL.KhachHangData.ps;
import Utils.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTO.Taikhoan;
import GUI.JFrameTaikhoan;
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
public class TaikhoanData {
    public static ResultSet rs;
    public static PreparedStatement ps;
    public static Connect conn;
    public static TaikhoanData cLog(String tk,String mk) {
        TaikhoanData con = null;
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM tai_khoan where tk = ? and mk = ? ");
            ps.setString(1, tk);
            ps.setString(2, mk);

            rs = ps.executeQuery();

            while (rs.next()) {
                con = new TaikhoanData();
            }

        } catch (Exception e) {
            return con = null;
        }
        return con;
    }
    public static ArrayList<Taikhoan> getListnv() {

        ArrayList<Taikhoan> ListTK = new ArrayList<Taikhoan>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM tai_khoan order by tk asc");
            rs = ps.executeQuery();
            Taikhoan tk;
            while (rs.next()) {
                tk = new Taikhoan(rs.getString("manv"), rs.getString("chucvu"),rs.getString("tk"), rs.getString("mk"));
                ListTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTK;
    }

    public static ArrayList<Taikhoan> ListTK(String manv) {
        ArrayList<Taikhoan> list = new ArrayList<Taikhoan>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM tai_khoan where manv = '" + JFrameTaikhoan.txt8.getText() + "'");
            rs = ps.executeQuery();

            Taikhoan tk;
            while (rs.next()) {
                tk = new Taikhoan(
                        rs.getString("manv"),
                        rs.getString("chucvu"),
                        rs.getString("tk"),
                        rs.getString("mk")

                );
                list.add(tk);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<Taikhoan> addStaff(String manv) {
        ArrayList<Taikhoan> list = new ArrayList<Taikhoan>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `tai_khoan`"
                    + "(`manv`, `chucvu`, `tk`, `mk`)"
                    + "VALUES ('" + JFrameTaikhoan.txt1.getText() + "','" + JFrameTaikhoan.txt2.getText() +  "','" + JFrameTaikhoan.txt4.getText() + "','" + JFrameTaikhoan.txt5.getText()+ "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<Taikhoan> deleteStaff(String manv) {
        ArrayList<Taikhoan> list = new ArrayList<Taikhoan>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `tai_khoan` where manv = '" + JFrameTaikhoan.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá tài khoản ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<Taikhoan> updateStaff(String manv) {
        ArrayList<Taikhoan> list = new ArrayList<Taikhoan>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `tai_khoan` SET `chucvu`='" + JFrameTaikhoan.txt2.getText() + "',`manv`='" + JFrameTaikhoan.txt1.getText() +"',`tk`='" + JFrameTaikhoan.txt4.getText() + "',`mk`='" + JFrameTaikhoan.txt5.getText() + "' WHERE manv = '" + manv+ "'");
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sửa tài khoản thành công !! ");

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

