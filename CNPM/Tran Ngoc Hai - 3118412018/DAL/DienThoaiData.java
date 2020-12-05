package DAL;
import DTO.DienThoai;
import GUI.JFrameDienThoai;
import Utils.Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;

public class DienThoaiData {
    public static PreparedStatement ps;

    public static ResultSet rs;

    public static Connect conn;

    public static ArrayList<DienThoai> getListdt() {

        ArrayList<DienThoai> Listdt = new ArrayList<DienThoai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM dienthoai order by Ma_dt asc");
            rs = ps.executeQuery();
            DienThoai dt;
            while (rs.next()) {
                dt = new DienThoai(rs.getString("Ma_dt"), rs.getString("Loai_dt"), rs.getString("Hang_dt"),rs.getString("Ten_dt"),rs.getString("Phan_khoi"), rs.getFloat("Don_gia"), rs.getString("So_luong"));
                Listkx.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listkx;
    }

    public static ArrayList<DienThoai> Listkx(String madt) {
        ArrayList<DienThoai> list = new ArrayList<DienThoai>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("SELECT * FROM dienthoai where Ma_Nhan_vien = '" + JFrameKhoXe.txt8.getText() + "'");
            rs = ps.executeQuery();

            DienThoai dt;
            while (rs.next()) {
                kx = new DienThoai(
                        rs.getString("Ma_dt"),
                        rs.getString("Loai_dt"),
                        rs.getString("Hang_dt"),
                        rs.getString("Ten_dt"),
                        rs.getFloat("Don_gia"),
                        rs.getString("So_luong")

                );
                list.add(kx);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<DienThoai>addStaff(String madt) {
        ArrayList<DienThoai> list = new ArrayList<DienThoai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("INSERT INTO `dt`"
                    + "(`Ma_dt`, `Loai_dt`, `Hang_dt`,`Ten_dt`, `Don_gia`, `So_luong`)"
                    + "VALUES ('" + JFrameDienThoai.txt1.getText() + "','" + JFrameDienThoai.txt2.getText() + "','" + JFrameDienThoai.txt3.getText() + "','" + JFrameDienThoai.txt6.getText() + "','" + JFrameDienThoai.txt7.getText() + "','" + JFrameDienThoai.txt4.getText() + "','" + JFrameDienThoai.txt5.getText()+ "')");

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm " + JFrameDienThoai.txt2.getText() + " thành công !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return list;
    }

    public static ArrayList<DienThoai> deleteStaff(String madt) {
        ArrayList<DienThoai> list = new ArrayList<DienThoai>();
        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("DELETE FROM `dienthoai` where Ma_dt = '" + JFrameDienThoai.txt1.getText() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xoá " + JFrameDienThoai.txt2.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thành công");

        }

        return list;
    }

    public static ArrayList<DienThoai> updateStaff(String madt) {
        ArrayList<DienThoai> list = new ArrayList<DienThoai>();

        try {
            ps = (PreparedStatement) Connect.getConnect().prepareStatement("UPDATE `dienthoai` SET `Hang_dt`='" + JFrameDienThoai.txt3.getText() + "',`Ma_dt`='" + JFrameDienThoai.txt1.getText() + "',`Loai_dt`='" + JFrameDienThoai.txt2.getText() + "',`Ten_dt`='" + JFrameDienThoai.txt6.getText() + "',`Don_gia`='" + JFrameDienThoai.txt4.getText() + "',`So_luong`='" + JFrameDienThoai.txt5.getText() + "' WHERE Ma_dt = '" + madt+ "'");
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
