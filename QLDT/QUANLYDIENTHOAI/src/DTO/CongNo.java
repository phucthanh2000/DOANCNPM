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
public class CongNo {

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

    public Date getHantt() {
        return hantt;
    }

    public void setHantt(Date hantt) {
        this.hantt = hantt;
    }

    public float getTientt() {
        return tientt;
    }

    public void setTientt(float tientt) {
        this.tientt = tientt;
    }

    public float getConlai() {
        return conlai;
    }

    public void setConlai(float conlai) {
        this.conlai = conlai;
    }
    public String makh;
    public String tenkh;
    public Date hantt;
    public float tientt;
    public float conlai;
public CongNo(){
    
}

public CongNo(String makh, String tenkh, Date hantt, float tientt, float conlai){
    this.makh = makh;
    this.tenkh = tenkh;
    this.hantt = hantt;
    this.tientt = tientt;
    this.conlai = conlai;
}
}
