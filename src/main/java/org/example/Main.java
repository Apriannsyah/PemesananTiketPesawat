package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static org.example.PesanPesawat.kursiPesawat;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<PesanPesawat> daftarPesanan = new ArrayList<>();
        List<Pesawat> pesawats = new ArrayList<>();
        pesawats.add(new Pesawat(1, "Eksekutif", "Palembang", "Jakarta", kursiPesawat(16), 16, "08.00", "10.00"));
        pesawats.add(new Pesawat(2, "Bisnis", "Palembang", "Jakarta", kursiPesawat(16), 16, "08.00", "10.00"));
        pesawats.add(new Pesawat(3, "Ekonomi", "Palembang", "Jakarta", kursiPesawat(16), 16, "08.00", "10.00"));

        pesawats.add(new Pesawat(4, "Ekesekutif", "Palembang", "Bandung", kursiPesawat(20), 20, "07.00", "11.00"));
        pesawats.add(new Pesawat(5, "Bisnis", "Palembang", "Bandung", kursiPesawat(20), 20, "07.00", "11.00"));
        pesawats.add(new Pesawat(6, "Ekonomi", "Palembang", "Bandung", kursiPesawat(20), 20, "07.00", "11.00"));
       
        pesawats.add(new Pesawat(7, "Eksekutif", "Palembang", "Surabaya", kursiPesawat(30), 30, "10.00", "10.00"));
        pesawats.add(new Pesawat(8, "Bisnis", "Palembang", "Surabaya", kursiPesawat(30), 30, "10.00", "10.00"));
        pesawats.add(new Pesawat(9, "Ekonomi", "Palembang", "Surabaya", kursiPesawat(30), 30, "10.00", "10.00"));
        
        pesawats.add(new Pesawat(10, "Eksekutif", "Jakarta", "Palembang", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(11, "Bisnis", "Jakarta", "Palembang", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(12, "Ekonomi", "Jakarta", "Palembang", kursiPesawat(16), 16, "08.00", "14.00"));
        
        pesawats.add(new Pesawat(13, "Eksekutif", "Jakarta", "Bandung", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(14, "Bisnis", "Jakarta", "Bandung", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(15, "Ekonomi", "Jakarta", "Bandung", kursiPesawat(16), 16, "08.00", "14.00"));

        pesawats.add(new Pesawat(16, "Eksekutif", "Jakarta", "Surabaya", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(17, "Bisnis", "Jakarta", "Surabaya", kursiPesawat(16), 16, "08.00", "14.00"));
        pesawats.add(new Pesawat(18, "Ekonomi", "Jakarta", "Surabaya", kursiPesawat(16), 16, "08.00", "14.00"));
        
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    pesanTiketPesawat(pesawats, daftarPesanan);
                    break;
                case 2:
                    cariPesawatTersedia(pesawats);
                    break;
                case 3:
                    pesananPenumpang(daftarPesanan, pesawats);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("pilihan tidak tersedia");
            }
        }
    }

    public static int menu() {
        System.out.println("\nMenu di Aplikasi Pemesanan Tiket Pesawat:");
        System.out.println("1. Pesan Pesawat");
        System.out.println("2. Cari Pesawat");
        System.out.println("3. Lihat Detail Pesanan");
        System.out.println("4. Exit");
        System.out.print("Masukkan Pilihan: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void pesanTiketPesawat(List<Pesawat> pesawats, List<PesanPesawat> daftarPesanan) {
        boolean find = false;
        System.out.println("\n--------Pesan Tiket Pesawat--------");
        System.out.print("Masukkan nama: ");
        String namaPemesan = scanner.nextLine();

        while(!find) {
            System.out.print("Masukkan bandara asal  : ");
            String bandaraAsal = scanner.nextLine();
            System.out.print("Masukkan bandara tujuan: ");
            String bandaraTujuan = scanner.nextLine();

            List<Pesawat> cariPesawat = new ArrayList<>();

            for (Pesawat p : pesawats) {
                if (p.bandaraAsal.equalsIgnoreCase(bandaraAsal) && p.bandaraTujuan.equalsIgnoreCase(bandaraTujuan)) {
                    cariPesawat.add(p);
                }
            }

            if (cariPesawat.isEmpty()) {
                System.out.println("Pesawat Ditemukan: Asal "  + bandaraAsal + " ke " + bandaraTujuan + " tidak/belum ada.");
            } else {
                find = true;
                System.out.println("Pesawat ditemukan");
                for (Pesawat p : cariPesawat) {
                    System.out.println("Pesawat tersedia nomor " + p.idPesawat + ", kelas " + p.kelasPesawat + ", dari " + bandaraAsal + " ke " + bandaraTujuan);
                }
            }
        }

        System.out.print("Masukkan Nomor Pesawat: ");
        int idPesawat = Integer.parseInt(scanner.nextLine());
        Pesawat pilihPesawat = null;
        for (Pesawat p : pesawats) {
            if (Objects.equals(p.idPesawat, idPesawat)) {
                pilihPesawat = p;
                break;
            }
        }

        System.out.print("Masukkan jumlah tiket: ");
        int kursiDipesan = Integer.parseInt(scanner.nextLine());

        assert pilihPesawat != null;
        if (kursiDipesan > pilihPesawat.kursiTersedia.size()) {
            System.out.println("Anda memesan terlalu banyak tiket/kursi");
            return;
        }

        double tiketAntarKota = 0;

        if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta"))) {
            tiketAntarKota = 100_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung"))) {
            tiketAntarKota = 200_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya"))) {
            tiketAntarKota = 300_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang"))) {
            tiketAntarKota = 200_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung"))) {
            tiketAntarKota = 400_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya"))) {
            tiketAntarKota = 600_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta"))) {
            tiketAntarKota = 150_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang"))) {
            tiketAntarKota = 250_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya"))) {
            tiketAntarKota = 350_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Jakarta"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Jakarta"))) {
            tiketAntarKota = 200_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Bandung"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Bandung"))) {
            tiketAntarKota = 400_000.00;
        } else if ((pilihPesawat.bandaraAsal.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraTujuan.equalsIgnoreCase("Palembang"))
        || (pilihPesawat.bandaraTujuan.equalsIgnoreCase("Surabaya") && pilihPesawat.bandaraAsal.equalsIgnoreCase("Palembang"))) {
            tiketAntarKota = 600_000.00;
        }

        double hargaTiketKelas = switch (pilihPesawat.kelasPesawat) {
            case "Eksekutif" -> 500_000.00;
            case "Bisnis" -> 250_000.00;
            case "Ekonomi" -> 150_000.00;
            default -> 0.00;
        };

        double hargaTiket = tiketAntarKota + hargaTiketKelas;

        double hargaAwal = kursiDipesan * hargaTiket;
        System.out.println("Harga: " + String.format("%.2f", hargaAwal));

        double diskon = 0.0;
        if (kursiDipesan >= 20) {
            diskon = 0.30;
            System.out.println("anda mendapatkan diskon sebesar 30%");
        } else if (kursiDipesan >= 15) {
            diskon = 0.15;
            System.out.println("anda mendapatkan diskon sebesar 15%");
        } else if (kursiDipesan >= 5) {
            diskon = 0.10;
            System.out.println("anda mendapatkan diskon sebesar 10%");
        }

        double totalBayar = hargaAwal - (hargaAwal * diskon);
        System.out.println("jumlah bayar = Rp" + String.format("%.2f", totalBayar));

        PesanPesawat pesanPesawat = new PesanPesawat(namaPemesan, pilihPesawat, kursiDipesan, totalBayar);

        if (pilihPesawat.kursiTersedia.size() < kursiDipesan) {
            System.out.println("Pesawat sudah penuh");
            return;
        }
        
        System.out.println("Anda akan memesan pesawat nomor " + idPesawat + " kelas " + pilihPesawat.kelasPesawat + " ( " + pilihPesawat.bandaraAsal + " - " + pilihPesawat.bandaraTujuan + ").");
        System.out.print("Ketik ya jika setuju: ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("ya")) {
            System.out.println("Pesanan Berhasil Dibuat...");
            daftarPesanan.add(pesanPesawat);
        } else {
            System.out.println("Pesanan Dibatalkan...");
            daftarPesanan.remove(pesanPesawat);
        }
    }

    public static void cariPesawatTersedia(List<Pesawat> pesawats) {
        System.out.println("\n--------Cari Pesawat--------");
        System.out.print("Masukkan bandara asal: ");
        String bandaraAsal = scanner.nextLine();
        System.out.print("Masukkan bandara tujuan: ");
        String bandaraTujuan = scanner.nextLine();
        System.out.print("Masukkan kelas pesawat(Eksekutif/bisnis/ekonomi): ");
        String kelasPesawat = scanner.nextLine();

        List<Pesawat> pesawat = new ArrayList<>();
        for (Pesawat p : pesawats) {
            if (p.kelasPesawat.equalsIgnoreCase(kelasPesawat) && p.bandaraAsal.equalsIgnoreCase(bandaraAsal) && p.bandaraTujuan.equalsIgnoreCase(bandaraTujuan)) {
                pesawat.add(p);
            }
        }

        if (pesawat.isEmpty()) {
            System.out.println("Pesawat dengan " + kelasPesawat + "dari" + bandaraAsal + " ke " + bandaraTujuan + " tidak ditemukan.");
        } else {
            System.out.println("Pesawat ditemukan");
            for (Pesawat p : pesawat) {
                System.out.println("Pesawat tersedia nomor " + p.idPesawat + ", kelas " + p.kelasPesawat + ", dari " + bandaraAsal + " ke " + bandaraTujuan);
                System.out.println("Jam Berangkat: " + p.waktuKeberangkatan + "\nJam Sampai: " + p.waktuTiba);
            }
        }
    }

    public static void pesananPenumpang(List<PesanPesawat> daftarPesanan, List<Pesawat> pesawats) {
        System.out.println("-----Menampilkan Pesanan-----");
        System.out.print("Masukkan nama anda: ");
        String namaPenumpang = scanner.nextLine();

        PesanPesawat pesanan = null;
        for (PesanPesawat p : daftarPesanan) {
            if (p.namaPemesan.equalsIgnoreCase(namaPenumpang)) {
                pesanan = p;
                break;
            }
        }

        if (pesanan != null) {
            System.out.println("--------Pesanan Penumpang--------");
            System.out.println("=========Detail Pesanan==========");
            System.out.println("Nama Pemesan        : " + pesanan.namaPemesan);
            System.out.println("- Pesawat           : " + pesanan.pesawat.toString());
            System.out.println("- Tiket yang Dipesan: " + pesanan.kursiDipesan);
            System.out.println("- Total Bayar       : Rp" + String.format("%.2f", pesanan.totalBayar));
            System.out.println("Detail Pesawat =>");
            Pesawat pesawat = null;
            for (Pesawat p : pesawats) {
                if (p.idPesawat == pesanan.pesawat.idPesawat) {
                    pesawat = p;
                    break;
                }
            }
            if (pesawat != null) {
                System.out.println("- ID Pesawat         : " + pesawat.idPesawat);
                System.out.println("- Kelas              : " + pesawat.kelasPesawat);
                System.out.println("- Bandara Asal       : " + pesawat.bandaraAsal);
                System.out.println("- Bandara Tujuan     : " + pesawat.bandaraTujuan);
                System.out.println("- Waktu Keberangkatan: " + pesawat.waktuKeberangkatan);
                System.out.println("- Waktu Tiba         : " + pesawat.waktuTiba);
                System.out.println("Kursi yang dipesan");
                List<String> kursi = kursiPesawat(pesanan.kursiDipesan);
                System.out.println(kursi);
            } else {
                System.out.println("Detail Pesawat tidak ditemukan.");
            }
        } else {
            System.out.println("Tidak ditemukan pesanan untuk penumpang dengan nama " + namaPenumpang);
        }
    }
}
