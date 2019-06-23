package com.piero.its40.Models;

public class Percorsi {
    private int rank;
private String zoneSeguense;
private String avgTime;
private int numCarts;

    public Percorsi(int rank, String zoneSeguense, String avgTime, int numCarts) {
        this.rank = rank;
        this.zoneSeguense = zoneSeguense;
        this.avgTime = avgTime;
        this.numCarts = numCarts;
    }

    public Percorsi() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getZoneSeguense() {
        return zoneSeguense;
    }

    public void setZoneSeguense(String zoneSeguense) {
        this.zoneSeguense = zoneSeguense;
    }

    public String getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(String avgTime) {
        this.avgTime = avgTime;
    }

    public int getNumCarts() {
        return numCarts;
    }

    public void setNumCarts(int numCarts) {
        this.numCarts = numCarts;
    }
}
