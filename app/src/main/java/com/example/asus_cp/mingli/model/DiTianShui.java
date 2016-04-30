package com.example.asus_cp.mingli.model;

/**
 * Created by asus-cp on 2016-04-30.
 */
public class DiTianShui {
    private String riGan;
    private String duanYu;

    public DiTianShui(String riGan, String duanYu) {
        this.riGan = riGan;
        this.duanYu = duanYu;
    }

    public DiTianShui() {
    }

    public String getRiGan() {
        return riGan;
    }

    public void setRiGan(String riGan) {
        this.riGan = riGan;
    }

    public String getDuanYu() {
        return duanYu;
    }

    public void setDuanYu(String duanYu) {
        this.duanYu = duanYu;
    }
}
