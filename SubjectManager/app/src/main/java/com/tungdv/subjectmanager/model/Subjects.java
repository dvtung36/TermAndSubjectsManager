package com.tungdv.subjectmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Subjects implements Serializable {
    private String maMonHoc;
    private String tenMonHoc;
    private String maBoMon;
    private int soTinChi;
    private int soTiet;
    private String moTa;


    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public void setMaBoMon(String maBoMon) {
        this.maBoMon = maBoMon;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getMaBoMon() {
        return maBoMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public String getMoTa() {
        return moTa;
    }

    public Subjects(String maMonHoc, String tenMonHoc, String maBoMon, int soTinChi, int soTiet, String moTa) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.maBoMon = maBoMon;
        this.soTinChi = soTinChi;
        this.soTiet = soTiet;
        this.moTa = moTa;
    }

}
