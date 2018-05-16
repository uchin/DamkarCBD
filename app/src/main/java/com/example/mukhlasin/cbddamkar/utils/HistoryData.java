package com.example.mukhlasin.cbddamkar.utils;

public class HistoryData {
    private String judul, lokasi;

    public HistoryData(String judul, String lokasi) {
        this.judul = judul;
        this.lokasi = lokasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getLokasi() {
        return lokasi;
    }

    @Override
    public String toString() {
        return "ListHistoryData{" +
                ", judul='" + judul + '\'' +
                ", lokasi='" + lokasi + '\'' +
                '}';
    }
}
