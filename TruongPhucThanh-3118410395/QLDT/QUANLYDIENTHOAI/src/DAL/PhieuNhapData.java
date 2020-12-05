/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.Phieunhap;
import GUI.JFramePhieuNhap;
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
 * @author ADMIN
 */
public class PhieuNhapData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;
    
    public static ArrayList<Phieunhap> getListpn() {

        ArrayList<Phieunhap> Listpn = new ArrayList<Phieunhap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM phieu_nhap order by Ma_pn asc");
            rs = ps.executeQuery();
            Phieunhap pn;
            while (rs.next()) {
                pn = new Phieunhap(rs.getString("Ma_pn"), rs.getString("Ma_pt"), rs.getString("Ma_nv"),rs.getString("Ten_nv"),rs.getString("Ma_ncc"),rs.getDate("Ngay_Lap"),rs.getFloat("Thanh_Tien"));
                Listpn.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listpn;
    }
    
    public static ArrayList<Phieunhap> Listpn(String mapn) {
        ArrayList<Phieunhap> list = new ArrayList<Phieunhap>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM phieu_nhap where Ma_pn = '" + JFramePhieuNhap.txt7.getText() + "'");
            rs = ps.executeQuery();

            Phieunhap pn;
            while (rs.next()) {
                pn = new Phieunhap(
                        rs.getString("Ma_pn"),
                        rs.getString("Ma_pt"),
                        rs.getString("Ma_nv"),
                        rs.getString("Ten_nv"),
                        rs.getString("Ma_ncc"),  
                        rs.getDate("Ngay_Lap"),
                        rs.getFloat("Thanh_Tien")


                );
                list.add(pn);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public static ArrayList<Phieunhap> addStaff(String mapn) {
        ArrayList<Phieunhap> list = new ArrayList<Phieunhap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `phieu_nhap`"
                    + "(Ma_pn,`Ma_pt`,`Ma_nv`,`Ten_nv`,`Ma_ncc`, `Ngay_Lap`, `Thanh_Tien`)"
                    + "VALUES ('" + JFramePhieuNhap.txt1.getText() + "','" + JFramePhieuNhap.txt2.getText() + "','" + JFramePhieuNhap.txt8.getText() + "','" + JFramePhieuNhap.txt3.getText() + "','" + JFramePhieuNhap.txt9.getText() + "','" + JFramePhieuNhap.txt5.getText() + "','" + JFramePhieuNhap.txt6.getText()+ "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFramePhieuNhap.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    
    public static ArrayList<Phieunhap> deleteStaff(String mapn) {
        ArrayList<Phieunhap> list = new ArrayList<Phieunhap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `phieu_nhap` where Ma_pn = '" + JFramePhieuNhap.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFramePhieuNhap.txt1.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thành công");

        }

        return list;
    }
    
    public static ArrayList<Phieunhap> updateStaff(String mapn) {
        ArrayList<Phieunhap> list = new ArrayList<Phieunhap>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `phieu_nhap` SET `Ma_pt`='" + JFramePhieuNhap.txt2.getText() + "',`Ma_nv`='" + JFramePhieuNhap.txt8.getText() + "',`Ten_nv`='" + JFramePhieuNhap.txt3.getText() + "',`Ma_ncc`='" + JFramePhieuNhap.txt9.getText() + "',`Ngay_Lap`='" + Date.valueOf(JFramePhieuNhap.txt5.getText()) + "',`Thanh_tien`='" + JFramePhieuNhap.txt6.getText() + "' WHERE Ma_pn = '" + mapn+ "'");
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
