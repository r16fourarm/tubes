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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    private OlahDataDosen ods = new OlahDataDosen();
    private OlahDataMataKuliah odmk = new OlahDataMataKuliah();
    private OlahDataRuang odr = new OlahDataRuang();
    private OlahDataKelas odk = new OlahDataKelas();
    private OlahDataJadwal odj = new OlahDataJadwal();
    private Scanner s = null;
    private Dosen cd = null;
    private MataKuliah cmk = null;
    private RuangKelas crk = null;
    private Kelas ck;
    private String username, password;
    private boolean statusLogin = false;
    private boolean statusUser = true;
    private boolean statusInput = true;
    private String loginMessage = "Anda belum loginn";
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    Dosen d1 = new Dosen("Pak Andit","ADN");
    Dosen d2 = new Dosen("Pak Dody","DQR");
    MataKuliah mk1 =  new MataKuliah("Pemograman Berbasis Objek","PBO");
    MataKuliah mk2 =  new MataKuliah("Algoritma Struktur Data","ASD");
    Kelas k1 = new Kelas("SK3702",40);
    Kelas k2 = new Kelas("IF3706",40);
    RuangKelas rk1 = new RuangKelas("A103",40);
    RuangKelas rk2 = new RuangKelas("A102", 40);
    public Menu() {
        ods.addDosen(d1);
        ods.addDosen(d2);
        odk.addKelas(k1);
        odk.addKelas(k2);
        odmk.addMataKuliah(mk1);
        odmk.addMataKuliah(mk2);
        odr.addRuang(rk1);
        odr.addRuang(rk2);
        s = new Scanner(System.in);
    }

    public void userLogin(String username, String password) {
        this.username = username;
        this.password = password;
        if ("PPDU".equals(this.username) && "ppdu".equals(this.password)) {
            statusUser = true;
            loginMessage = "PPDU,selamat datang";
            statusLogin = true;
        } else {
            statusUser = false;
            loginMessage = "Guest,selamat datang";
            statusLogin = true;
        }
        if (this.username == null && this.password == null) {
            throw new RuntimeException("inputan tidak boleh kosong");
        }
    }

    public void userLogout() {
        System.out.println("");
        this.username = null;
        this.password = null;
        loginMessage = "anda belum login";
        statusLogin = false;
    }

    public boolean cekStatusLogin() {
        if (username == null && password == null) {
            return true;
        } else {
            return false;
        }
    }

    public void tampilMenuAwal() {
        int pil = 0;

        do {
            try {
                System.out.println("====Course Scheduling====");
                System.out.println("0.LOGIN");
                System.out.println("Status Login : " + loginMessage);
                System.out.println("1.Olah Data");
                System.out.println("2.Olah Jadwal");
                System.out.println("3.LOGOUT");
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
                        if (statusLogin == true && statusUser == true) {
                            menuOlahData();
                        } else {
                            System.out.println("anda harus login dan anda harus PPDU");
                        }
                        break;
                    case 2:
                        if (statusLogin == true) {
                            menuOlahJadwal();
                        } else {
                            System.out.println("anda harus login");
                        }
                        break;
                    case 3:
                        userLogout();
                        break;
                }
            } catch (InputMismatchException ie) {
                System.out.println("Input harus angka");
            } finally {
                s = new Scanner(System.in);
            }
        } while (pil != 4);

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
            try {
                pil = s.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("input harus angka");
            } finally {
                s = new Scanner(System.in);
            }
            System.out.println("============");
            if (pil < 1 && pil > 6) {
                System.out.println("input hrus 1-6");
            } else {
                OlahMenuJadwal(pil);
            }
        } while (pil != 6);
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
                Date skrg = new Date();
                try {
                    if (skrg.getTime() < formatter.parse(tgl).getTime()) {
                        System.out.println("Input Shift : ");

                        int shift = s.nextInt();
                        try {
                            if (odj.cariJadwal(tgl, shift, cd.getKdDosen(), ck.getKdKelas(), crk.getKdRuang()) == null) {
                                System.out.println("kode jadwal : ");
                                String kj = s.next();
                                if (ck == null || crk == null || cmk == null || cd == null) {
                                    System.out.println("maaf tidak bsa menginput jadwal parameter kurang");
                                } else {
                                    Jadwal j = new Jadwal(ck, cmk, cd, crk, tgl, kj, shift);
                                    odj.addJadwal(j);
                                }
                            } else {
                                System.out.println("maaf jadwal pada waktu tsbt telah diisii");
                            }
                        } catch (ParseException ex) {
                            System.out.println("format tanggal salah");
                        }
                    } else {
                        System.out.println("tidak bsa input dibawah tanggal skrg");
                    }
                } catch (ParseException pe) {
                    System.out.println("format salah");
                }
            System.out.println("masih mau input jadwal ?");
            ag = s.next().charAt(0);
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
        MataKuliah mk = odmk.cariMK(kdMK);
        if (mk == null) {
            System.out.println("MK tidak ada mohon cek kembali");
            statusInput = false;
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
            statusInput = false;
        } else {
            cd = d;
            inputRuangtoJadwal();
        }
    }

    public void inputRuangtoJadwal() {
        System.out.println("Masukkan kdRuangan");
        String kdRuang = s.next();
        RuangKelas rk = odr.cariRuang(kdRuang);
        if (rk == null) {
            System.out.println("Ruangan tdk ada mohon dicek kembali");
            statusInput = false;
        } else {
            crk = rk;
        }
    }

    public void menuOlahData() {
        int pil = 0;

        do {
            try {
                System.out.println("1.Dosen");
                System.out.println("2.MataKuliah");
                System.out.println("3.Ruangan");
                System.out.println("4.Kelas");
                System.out.println("5.Kembali");
                System.out.println("input pilihan");
                pil = s.nextInt();
                System.out.println("============");
                if (pil < 1 || pil > 5) {
                    throw new RuntimeException("Input harus 1-5");
                } else {
                    olahmenuOlah(pil);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Input harus angka ");
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            } finally {
                s = new Scanner(System.in);
            }
        } while (pil != 5);
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
                odmk.addMataKuliah(mk);
                break;
            case 2:
                System.out.println("masukkan nama mk yg mau dihapus : ");
                String in2 = s.next();
                odmk.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLMK==");
                odmk.viewAll();
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
                odr.addRuang(rk);
                break;
            case 2:
                System.out.println("masukkan kd ruang yg mau dihapus : ");
                String in2 = s.next();
                odr.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLRuang==");
                odr.viewAll();
                System.out.println("===ViewALLRuang==");
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
                System.out.println("===ViewALLKelas==");
                odk.viewAll();
                System.out.println("===ViewALLKelas==");
                break;

        }
    }

    public void olahmenuOlah(int pil) {
        int pil1 = 0;
        try {
            switch (pil) {
                case 1:
                    do {
                        try {
                            tampilanmenuOlah();
                            pil1 = s.nextInt();
                            System.out.println("============");
                            menuOlahDosen(pil1);
                        } catch (InputMismatchException ex) {
                            System.out.println("input harus angka");
                        } finally {
                            s = new Scanner(System.in);
                        }
                    } while (pil1 != 4);
                    break;
                case 2:
                    do {
                        try {
                            tampilanmenuOlah();
                            pil1 = s.nextInt();
                            System.out.println("============");
                            menuOlahMK(pil1);
                        } catch (InputMismatchException ex) {
                            System.out.println("input harus angka");
                        } finally {
                            s = new Scanner(System.in);
                        }
                    } while (pil1 != 4);
                    break;
                case 3:
                    do {
                        try {
                            tampilanmenuOlah();
                            pil1 = s.nextInt();
                            System.out.println("============");
                            menuOlahRuang(pil1);
                        } catch (InputMismatchException ex) {
                            System.out.println("input harus angka");
                        } finally {
                            s = new Scanner(System.in);
                        }
                    } while (pil1 != 4);
                    break;
                case 4:
                    do {
                        try {
                            tampilanmenuOlah();
                            pil1 = s.nextInt();
                            System.out.println("============");
                            menuOlahKelas(pil1);
                        } catch (InputMismatchException ex) {
                            System.out.println("input harus angka");
                        } finally {
                            s = new Scanner(System.in);
                        }
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
