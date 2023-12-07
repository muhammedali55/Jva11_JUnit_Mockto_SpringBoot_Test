package com.muhammet.jnuttest.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String ad;
    private Integer yas;

    @Override
    public String toString() {
        return "User{" +
                "ad='" + ad + '\'' +
                ", yas='" + yas + '\'' +
                '}';
    }

    public User(String ad, Integer yas) {
        this.ad = ad;
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }
}
