package com.piero.its40.Models;

public class Zone {
    private int id;
    private String nome;
    private  String avgSpending;
    private String totalSpending;
    private String conversion;
    private String avgStaytime;
    private String timeStamp;
    private String numCarrelli;

    public String getNumCarrelli() {
        return numCarrelli;
    }

    public void setNumCarrelli(String numCarrelli) {
        this.numCarrelli = numCarrelli;
    }

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvgSpending() {
        return avgSpending;
    }

    public void setAvgSpending(String avgSpending) {
        this.avgSpending = avgSpending;
    }

    public String getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(String totalSpending) {
        this.totalSpending = totalSpending;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getAvgStaytime() {
        return avgStaytime;
    }

    public void setAvgStaytime(String avgStaytime) {
        this.avgStaytime = avgStaytime;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
