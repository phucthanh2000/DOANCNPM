/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.HoaDon;
import GUI.JFrameHoaDon;
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
public class HoaDonData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<HoaDon> getListhd() {

        ArrayList<HoaDon> Listhd = new ArrayList<HoaDon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM hoa_don order by Ma_hd asc");
            rs = ps.executeQuery();
            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon(rs.getString("Ma_hd"), rs.getString("Ma_nv"),rs.getString("Ma_kh"), rs.getString("Ten_kh"),rs.getString("Ten_sp"),rs.getString("Sl"),rs.getFloat("Thanh_tien"),rs.getDate("Ngay_lap"));
                Listhd.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listhd;
    }

    public static ArrayList<HoaDon> Listpt(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM hoa_don where Ma_hd = '" + JFrameHoaDon.txt7.getText() + "'");
            rs = ps.executeQuery();

            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon(
                        rs.getString("Ma_hd"),
                        rs.getString("Ma_nv"),
                        rs.getString("Ma_kh"),
                        rs.getString("Ten_kh"),
                        rs.getString("Ten_sp"),
                                                rs.getString("Sl"),
                        rs.getFloat("Thanh_tien"),
                        rs.getDate("Ngay_lap")

                );
                list.add(hd);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<HoaDon> addStaff(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `hoa_don`"
                    + "(`Ma_hd`, `Ma_nv`, `Ma_kh`, `Ten_kh`,`Ten_sp`,`Sl`,`Thanh_tien`,`Ngay_lap`)"
                    + "VALUES ('" + JFrameHoaDon.txt1.getText() + "','" + JFrameHoaDon.txt3.getText() + "','" + JFrameHoaDon.txt4.getText() + "','" + JFrameHoaDon.txt5.getText()+ "','" + JFrameHoaDon.txt2.getText()+ "','"+ JFrameHoaDon.txt6.getText()+ "','" + JFrameHoaDon.txt8.getText()+ "','" +Date.valueOf(JFrameHoaDon.txt9.getText())+"')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameHoaDon.txt1.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<HoaDon> deleteStaff(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `hoa_don` where Ma_hd = '" + JFrameHoaDon.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameHoaDon.txt1.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thành công");

        }

        return list;
    }

    public static ArrayList<HoaDon> updateStaff(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `hoa_don` SET `Ma_nv`='" + JFrameHoaDon.txt3.getText() + "',`Ma_kh`='" + JFrameHoaDon.txt4.getText() + "',`Ten_kh`='" + JFrameHoaDon.txt5.getText() + "',`Ten_sp`='" + JFrameHoaDon.txt2.getText() +"',`Sl`='" + JFrameHoaDon.txt6.getText() +"',`Thanh_tien`='" + JFrameHoaDon.txt8.getText() +"',`Ngay_lap`='" + JFrameHoaDon.txt9.getText() + "' WHERE Ma_hd = '" + mahd+ "'");
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
