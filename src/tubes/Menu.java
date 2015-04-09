/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author R16
 */
import java.text.ParseException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    private OlahDataDosen ods = new OlahDataDosen();
    private OlahDataMataKuliah ODMK = new OlahDataMataKuliah();
    private OlahDataRuang ODR = new OlahDataRuang();
    private OlahDataKelas odk = new OlahDataKelas();
    private OlahDataJadwal odj = new OlahDataJadwal();
    private Scanner s = null;
    private Dosen cd = null;
    private MataKuliah cmk = null;
    private RuangKelas crk = null;
    private Kelas ck;
    private String username, password;
    private boolean StatusUser = true;
    private String loginMessage = "Anda belum loginn";

    public Menu() {
        s = new Scanner(System.in);
    }

    public void userLogin(String username, String password) {
        this.username = username;
        this.password = password;
        if ("PPDU".equals(this.username) && "ppdu".equals(this.password)) {
            StatusUser = true;
            loginMessage = "PPDU,selamat datang";
        } else {
            StatusUser = false;
            loginMessage = "Guest,selamat datang";
        }
        if (this.username == null && this.password == null) {
            throw new RuntimeException("inputan tidak boleh kosong");
        }
    }

    public boolean cekStatusLogin() {
        if (username == null && password == null) {
            return true;
        } else {
            return false;
        }
    }

    public void tampilMenuAwal() {
        int pil;
        try {
            do {
                System.out.println("====Course Scheduling====");
                System.out.println("0.LOGIN");
                System.out.println("Status Login : " + loginMessage);
                System.out.println("1.Olah Data");
                System.out.println("2.Olah Jadwal");
                System.out.println("3.Exit");
                System.out.println("Input pilihan : ");
                pil = s.nextInt();
                System.out.println("============");
                if (pil < 0 || pil > 3) {
                    System.out.println("Input harus 0-3");
                }
                switch (pil) {
                    case 0:
                        try {
                            System.out.println("username = ");
                            String usr = s.next();
                            System.out.println("Password = ");
                            String pw = s.next();
                            userLogin(usr, pw);
                        } catch (RuntimeException re) {
                            re.getMessage();
                        } finally {
                            s = new Scanner(System.in);
                        }
                        break;
                    case 1:
                        menuOlahData();
                        break;
                    case 2:
                        menuOlahJadwal();
                        break;
                }
            } while (pil != 3);
        } catch (InputMismatchException ie) {
            System.out.println("Input harus angka");
        } finally {
            s = new Scanner(System.in);
        }
        
    }

    public void menuOlahJadwal() {
        int pil = 0;
        do {
            System.out.println("1.input jadwal");
            System.out.println("2.view jadwal semua");
            System.out.println("3.view jadwal 1 hari");
            System.out.println("4.view jadwal 1 bulan");
            System.out.println("5.view jadwal spesifik");
            System.out.println("6.Kembali");
            System.out.println("Input pilihan  : ");
            pil = s.nextInt();
            if (pil < 1 && pil > 6) {
                System.out.println("input hrus 1-6");
            } else {
                OlahMenuJadwal(pil);
            }
        } while (pil != 7);
    }

    public void OlahMenuJadwal(int pil) {
        switch (pil) {
            case 1:
                inputJadwal();
                break;
            case 2:
                odj.viewAll();
                break;
            case 3:
                    System.out.println("masukkan tanggal yang mau dilihat jadwalnya");
                    String tgl = s.next();
                    odj.viewAllJadwalSatuHari(tgl);
            case 4:
                    System.out.println("masukkan bulan yang mau diliat jadwalnya");
                    int bln = s.nextInt();
                    odj.viewAllJadwalSatuBulan(bln);
                   
        }
    }

    public void inputJadwal() {
        char ag = 0;
        Jadwal jtmp = null;
        do {
            System.out.println("++INPUT JADWAL++");
            inputToJadwal();
            System.out.println("Input Waktu : ");
            String tgl = s.next();
            System.out.println("Input Shift : ");
            int shift = s.nextInt();
            try {
                jtmp = odj.cariJadwal(tgl, shift);
            } catch (ParseException ex) {
                System.out.println(ex);
            }
            if (jtmp == null) {
                System.out.println("kode jadwal : ");
                String kj = s.next();
                if (ck == null || crk == null || cmk == null || cd == null) {
                    System.out.println("maaf tidak bsa menginput jadwal parameter kurang");
                } else {
                    Jadwal j = new Jadwal(ck, cmk, cd, crk, tgl, kj, shift);
                }
            } else {
                System.out.println("maaf jadwal pada waktu tsbt telah diisii");
            }
            System.out.println("masih mau input jadwal");
        } while (ag != 'n');

    }

    public void inputToJadwal() {
        System.out.println("masukkan Kelas : ");
        String kdKelas = s.next();
        Kelas k = odk.cariKelas(kdKelas);
        if (k == null) {
            System.out.println("Kelas tidak ada mohon dicek kembali");
        } else {
            ck = k;
            inputMKtoJadwal();
        }
    }

    public void inputMKtoJadwal() {
        System.out.println("masukkan kode MataKuliah : ");
        String kdMK = s.next();
        MataKuliah mk = ODMK.cariMK(kdMK);
        if (mk == null) {
            System.out.println("MK tidak ada mohon cek kembali");
        } else {
            cmk = mk;
            inputDosentoJadwal();
        }
    }

    public void inputDosentoJadwal() {
        System.out.println("Masukkan kode dosen : ");
        String kdDosen = s.next();
        Dosen d = ods.cariDosen(kdDosen);
        if (d == null) {
            System.out.println("Dosen tdk ada mohon dicek kmbali");
        } else {
            cd = d;
            inputRuangtoJadwal();
        }
    }

    public void inputRuangtoJadwal() {
        System.out.println("Masukkan kdRuangan");
        String kdRuang = s.next();
        RuangKelas rk = ODR.cariRuang(kdRuang);
        if (rk == null) {
            System.out.println("Ruangan tdk ada mohon dicek kembali");
        } else {
            crk = rk;
        }
    }

    public void menuOlahData() {
        int pil = 0;
        try {
            do {
                System.out.println("1.Dosen");
                System.out.println("2.MataKuliah");
                System.out.println("3.Ruangan");
                System.out.println("4.Kelas");
                System.out.println("5.Kembali");
                System.out.println("input pilihan");
                pil = s.nextInt();
                if (pil < 1 || pil > 5) {
                    throw new RuntimeException("Input harus 1-5");
                } else {
                    olahmenuOlah(pil);
                }
            } while (pil != 5);
        } catch (InputMismatchException ex) {
            System.out.println("Input harus angka ");
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        } finally {
            s = new Scanner(System.in);
        }
    }

    public void tampilanmenuOlah() {
        System.out.println("1.input");
        System.out.println("2.remove");
        System.out.println("3.viewall");
        System.out.println("4.Kembali");
        System.out.println("input pilihan   : ");
    }

    public void menuOlahDosen(int pil) {
        switch (pil) {
            case 1:
                System.out.println("nama dosen : ");
                String in = s.next();
                System.out.println("kd dosen : ");
                String in1 = s.next();
                Dosen d = new Dosen(in, in1);
                ods.addDosen(d);
                break;
            case 2:
                System.out.println("masukkan nama dosen yg mau dihapus : ");
                String in2 = s.next();
                ods.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLDosen==");
                ods.viewAll();
                System.out.println("===ViewALLDosen==");
                break;

        }

    }

    public void menuOlahMK(int pil) {
        switch (pil) {
            case 1:
                System.out.println("nama mk : ");
                String in = s.next();
                System.out.println("kd mk : ");
                String in1 = s.next();
                MataKuliah mk = new MataKuliah(in, in1);
                ODMK.addMataKuliah(mk);
                break;
            case 2:
                System.out.println("masukkan nama mk yg mau dihapus : ");
                String in2 = s.next();
                ODMK.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLMK==");
                ODMK.viewAll();
                System.out.println("===ViewALLMK==");
                break;

        }

    }

    public void menuOlahRuang(int pil) {
        switch (pil) {
            case 1:
                System.out.println("kd ruangan : ");
                String in = s.next();
                System.out.println("kapasitas ruangan : ");
                int in1 = s.nextInt();
                RuangKelas rk = new RuangKelas(in, in1);
                ODR.addRuang(rk);
                break;
            case 2:
                System.out.println("masukkan kd ruang yg mau dihapus : ");
                String in2 = s.next();
                ODR.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLDosen==");
                ODR.viewAll();
                System.out.println("===ViewALLDosen==");
                break;
        }
    }

    public void menuOlahKelas(int pil) {
        switch (pil) {
            case 1:
                System.out.println("kd Kelas : ");
                String in = s.next();
                System.out.println("kapasitas : ");
                int in1 = s.nextInt();
                Kelas k = new Kelas(in, in1);
                odk.addKelas(k);
                break;
            case 2:
                System.out.println("masukkan kd kelas yg mau dihapus : ");
                String in2 = s.next();
                odk.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLDosen==");
                odk.viewAll();
                System.out.println("===ViewALLDosen==");
                break;

        }
    }

    public void olahmenuOlah(int pil) {
        int pil1;
        try {
            switch (pil) {
                case 1:
                    do {
                        tampilanmenuOlah();
                        pil1 = s.nextInt();
                        menuOlahDosen(pil1);
                    } while (pil1 != 4);
                    break;
                case 2:
                    do {
                        tampilanmenuOlah();
                        pil1 = s.nextInt();
                        menuOlahMK(pil1);
                    } while (pil1 != 4);
                    break;
                case 3:
                    do {
                        tampilanmenuOlah();
                        pil1 = s.nextInt();
                        menuOlahRuang(pil1);
                    } while (pil1 != 4);
                    break;
                case 4:
                    do {
                        tampilanmenuOlah();
                        pil1 = s.nextInt();
                        menuOlahKelas(pil1);
                    } while (pil1 != 4);
                    break;
            }
        } catch (InputMismatchException IE) {
            System.out.println("Input Harus Angka");
        } finally {
            s = new Scanner(System.in);
        }
    }
}
