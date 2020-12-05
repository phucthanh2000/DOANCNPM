package DTO;

public class DienThoai {
    public String madt;
    public String loaidt;
    public String hangdt;
    public String tendt;
    public float dongia;
    public String trangthai;
    public DienThoai() {
        
    }
    public DienThoai(String madt, String loaidt, String hangdt ,String tendt,float dongia, String trangthai) {
        this.madt = madt;
        this.loaidt = loaidt;
        this.hangdt = hangdt;
        this.tendt = tendt;
        this.dongia = dongia;
        this.trangthai = trangthai;
    }

    public String getMadt() {
        return madt;
    }

    public void setMadt(String madt) {
        this.maxe = madt;
    }

    public String getLoaidt() {
        return loaidt;
    }

    public void setLoaidt(String loaidt) {
        this.loaidt = loaidt;
    }

    public String getHangdt() {
        return hangdt;
    }

    public void setHangdt(String hangdt) {
        this.hangxe = hangdt;
    }
    public String getTendt() {
        return tendt;
    }

    public void setTendt(String tendt) {
        this.tendt = tendt;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    } 
}
