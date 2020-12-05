/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Acer
 */
public class KhoXe {

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }
    public String maxe;
    public String loaixe;
    public String tenxe;
    public String sl;
    public float dongia;
    public KhoXe() {
        
    }
    public KhoXe(String maxe, String loaixe,String tenxe,String sl, float dongia) {
        this.maxe = maxe;
        this.loaixe = loaixe;
        
        this.tenxe= tenxe;
        
        this.dongia = dongia;
    }

     
}
