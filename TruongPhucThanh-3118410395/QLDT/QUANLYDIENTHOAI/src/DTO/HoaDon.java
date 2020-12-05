/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class HoaDon {

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    
    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }
    
    public String mahd;
    public String manv;
    public String makh;
    public String tenkh;
    public String tensp;
    public String sl;
    public float thanhtien;
    public Date ngaylap;
public HoaDon(){

}
public HoaDon(String mahd,String manv,String makh,String tenkh,String tensp,String sl,float thanhtien,Date ngaylap){
    this.mahd=mahd;
    this.manv=manv;
    this.makh=makh;
    this.tenkh=tenkh;
    this.tensp=tensp;
    this.sl=sl;
    this.thanhtien= thanhtien;
    this.ngaylap=ngaylap;
}
}