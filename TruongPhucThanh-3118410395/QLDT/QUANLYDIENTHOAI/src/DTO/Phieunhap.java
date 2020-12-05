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
public class Phieunhap {

    public String getMapn() {
        return mapn;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public String getMaxept() {
        return maxept;
    }

    public void setMaxept(String maxept) {
        this.maxept = maxept;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    public String mapn;
    public String maxept;
    public String manv;
    public String tennv;
    public String mancc;
    public Date ngaylap;
    public float thanhtien;
    public Phieunhap(){
        
    }
    public Phieunhap(String mapn,String maxept,String manv,String tennv, String mancc, Date ngaylap, float thanhtien){
        this.mapn = mapn;
        this.maxept = maxept;
        this.manv = manv;
        this.tennv = tennv;
        this.mancc= mancc;
        this.ngaylap= ngaylap;
        this.thanhtien= thanhtien;
    }
}
