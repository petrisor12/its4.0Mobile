package com.piero.its40.Models;

public class Carrelli {
    private int id;
    private String totSpesa;
    private String data;

    public Carrelli(int id, String totSpesa, String data) {
        this.id = id;
        this.totSpesa = totSpesa;
        this.data = data;
    }

    public Carrelli() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotSpesa() {
        return totSpesa;
    }

    public void setTotSpesa(String totSpesa) {
        this.totSpesa = totSpesa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
