package com.tungdv.subjectmanager.model;

public class Term {
    private  String maHocPhan ;
    private  String tenHocPhan;
    private  String maMonHoc;
    private  String maGiaoVien1;
    private  String maGiaoVien2;
    private  String hocKy;
    private  String namHoc;

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public void setMaGiaoVien1(String maGiaoVien1) {
        this.maGiaoVien1 = maGiaoVien1;
    }

    public void setMaGiaoVien2(String maGiaoVien2) {
        this.maGiaoVien2 = maGiaoVien2;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }


    public String getMaHocPhan() {
        return maHocPhan;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getMaGiaoVien1() {
        return maGiaoVien1;
    }

    public String getMaGiaoVien2() {
        return maGiaoVien2;
    }

    public String getHocKy() {
        return hocKy;
    }

    public String getNamHoc() {
        return namHoc;
    }


    public Term(String maHocPhan, String tenHocPhan, String maMonHoc, String maGiaoVien1,
                String maGiaoVien2, String hocKy, String namHoc) {
        this.maHocPhan = maHocPhan;
        this.tenHocPhan = tenHocPhan;
        this.maMonHoc = maMonHoc;
        this.maGiaoVien1 = maGiaoVien1;
        this.maGiaoVien2 = maGiaoVien2;
        this.hocKy = hocKy;
        this.namHoc = namHoc;
    }




}
