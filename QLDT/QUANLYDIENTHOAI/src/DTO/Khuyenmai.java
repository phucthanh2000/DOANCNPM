/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Gaara
 */
public class Khuyenmai {

    public String getMact() {
        return mact;
    }

    public void setMact(String mact) {
        this.mact = mact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public Date getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(Date ngaybd) {
        this.ngaybd = ngaybd;
    }

    public Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(Date ngaykt) {
        this.ngaykt = ngaykt;
    }

    private String mact;
    private String name;
    private String masp;
    private Date ngaybd;
    private Date ngaykt;

    
    public Khuyenmai() {
        
    }
    public Khuyenmai(String mact, String name, String masp, Date ngaybd, Date ngaykt) {
        this.mact = mact;
        this.name = name;
        this.masp = masp;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
    }
       

}