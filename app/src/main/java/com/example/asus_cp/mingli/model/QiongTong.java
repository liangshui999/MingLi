package com.example.asus_cp.mingli.model;

/**
 * Created by asus-cp on 2016-04-29.
 * 和穷通宝鉴表对应的实体
 */
public class QiongTong {
    private String riGan;//日干
    private String yueFen;//月份
    private String duanYu;//断语

    public QiongTong(String riGan, String yueFen, String duanYu) {
        this.riGan = riGan;
        this.yueFen = yueFen;
        this.duanYu = duanYu;
    }

    public QiongTong() {
    }

    public String getRiGan() {
        return riGan;
    }

    public void setRiGan(String riGan) {
        this.riGan = riGan;
    }

    public String getYueFen() {
        return yueFen;
    }

    public void setYueFen(String yueFen) {
        this.yueFen = yueFen;
    }

    public String getDuanYu() {
        return duanYu;
    }

    public void setDuanYu(String duanYu) {
        this.duanYu = duanYu;
    }
}
