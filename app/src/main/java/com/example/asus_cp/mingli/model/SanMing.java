package com.example.asus_cp.mingli.model;

/**
 * Created by asus-cp on 2016-04-29.
 * 和三命通会表对应的断语
 */
public class SanMing {
    private String riGan;//日干
    private String shiChen;//时辰
    private String duanYu;//断语

    public SanMing(String riGan, String shiChen, String duanYu) {
        this.riGan = riGan;
        this.shiChen = shiChen;
        this.duanYu = duanYu;
    }

    public SanMing() {
    }

    public String getRiGan() {
        return riGan;
    }

    public void setRiGan(String riGan) {
        this.riGan = riGan;
    }

    public String getShiChen() {
        return shiChen;
    }

    public void setShiChen(String shiChen) {
        this.shiChen = shiChen;
    }

    public String getDuanYu() {
        return duanYu;
    }

    public void setDuanYu(String duanYu) {
        this.duanYu = duanYu;
    }
}
