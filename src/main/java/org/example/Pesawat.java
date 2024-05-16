package org.example;

import java.util.List;

public class Pesawat {
    int idPesawat;
    String kelasPesawat;
    String bandaraAsal;
    String bandaraTujuan;
    List<String> kursiTersedia;
    String waktuKeberangkatan;
    String waktuTiba;

    public Pesawat(int idPesawat, String kelasPesawat, String asal, String tujuan, List<String> kursiTersedia, int kapasitas, String waktuBerangkat, String waktuSampai) {
        this.idPesawat = idPesawat;
        this.kelasPesawat = kelasPesawat;
        this.bandaraAsal = asal;
        this.bandaraTujuan = tujuan;
        this.kursiTersedia = kursiTersedia;
        this.waktuKeberangkatan = waktuBerangkat;
        this.waktuTiba = waktuSampai;
    }

    @Override
    public String toString() {
        return "Pesawat nomor: " + idPesawat + "( " + kelasPesawat + " dari " + bandaraAsal + " ke " + bandaraTujuan + " )" ;
    }
}
