/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import static DAL.NhanvienData.ps;
import static DAL.NhanvienData.rs;
import DTO.Nhacungcap;
import GUI.JFrameNhaCungCap;
import Utils.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
public class NhaCungCapData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;
    
    public static ArrayList<Nhacungcap> getListnv() {

        ArrayList<Nhacungcap> ListNV = new ArrayList<Nhacungcap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM nha_cung_cap order by Ma_ncc asc");
            rs = ps.executeQuery();
            Nhacungcap nv;
            while (rs.next()) {
                nv = new Nhacungcap(rs.getString("Ma_ncc"), rs.getString("Ten_ncc"),rs.getString("Dia_chi"), rs.getString("Sdt"),rs.getString("Email"));
                ListNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListNV;
    }
    
    public static ArrayList<Nhacungcap> ListNV(String manv) {
        ArrayList<Nhacungcap> list = new ArrayList<Nhacungcap>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM nha_cung_cap where Ma_ncc = '" + JFrameNhaCungCap.txt8.getText() + "'");
            rs = ps.executeQuery();

            Nhacungcap nv;
            while (rs.next()) {
                nv = new Nhacungcap(
                        rs.getString("Ma_ncc"),
                        rs.getString("Ten_ncc"),
                        rs.getString("Dia_chi"),
                        rs.getString("Sdt"),
                                                rs.getString("Email")

                        

                );
                list.add(nv);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public static ArrayList<Nhacungcap> addStaff(String mancc) {
        ArrayList<Nhacungcap> list = new ArrayList<Nhacungcap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `nha_cung_cap`"
                    + "(`Ma_ncc`, `Ten_ncc`,`Dia_chi`, `Sdt`,`Email`)"
                    + "VALUES ('" + JFrameNhaCungCap.txt1.getText() + "','" + JFrameNhaCungCap.txt2.getText() + "','" + JFrameNhaCungCap.txt3.getText() + "','" + JFrameNhaCungCap.txt4.getText()+ "','" + JFrameNhaCungCap.txt5.getText() + "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameNhaCungCap.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }
    
    public static ArrayList<Nhacungcap> deleteStaff(String mancc) {
        ArrayList<Nhacungcap> list = new ArrayList<Nhacungcap>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `nha_cung_cap` where Ma_ncc = '" + JFrameNhaCungCap.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameNhaCungCap.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed");

        }

        return list;
    }

    public static ArrayList<Nhacungcap> updateStaff(String mancc) {
        ArrayList<Nhacungcap> list = new ArrayList<Nhacungcap>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `nha_cung_cap` SET `Ten_ncc`='" + JFrameNhaCungCap.txt2.getText() + "',`Dia_chi`='" + JFrameNhaCungCap.txt3.getText() + "',`Sdt`='" + JFrameNhaCungCap.txt4.getText()+ "',`Email`='" + JFrameNhaCungCap.txt5.getText() + "' WHERE Ma_ncc = '" + mancc+ "'");
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
