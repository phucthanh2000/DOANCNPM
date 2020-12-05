/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author F
 */
public class Taikhoan {

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    public String tk;
    public String mk;
    public String manv;
    public String chucvu;
    
    public Taikhoan() {
    }
    public Taikhoan(String tk, String mk,String manv,String chucvu) {
        this.tk = tk;
        this.mk = mk;
        this.manv=manv;
        this.chucvu=chucvu;
    }
    
    
}
