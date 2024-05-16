package org.example;

import java.util.ArrayList;
import java.util.List;

public class PesanPesawat {
    String namaPemesan;
    Pesawat pesawat;
    int kursiDipesan;
    double totalBayar;

    public PesanPesawat(String namaPemesan, Pesawat pesawat, int kursiDipesan, double totalBayar) {
        this.namaPemesan = namaPemesan;
        this.pesawat = pesawat;
        this.kursiDipesan = kursiDipesan;
        this.totalBayar = totalBayar;
    }

    public static List<String> kursiPesawat(int totalKursi) {
        List<String> kursi = new ArrayList<>();
        for (int i = 1; i <= totalKursi; i++) {
            kursi.add("A" + i);
        }
        return kursi;
    }
}
