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
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    private OlahDataDosen ODS = new OlahDataDosen();
    private OlahDataMataKuliah ODMK = new OlahDataMataKuliah();
    private OlahDataRuang ODR = new OlahDataRuang();
    private OlahDataKelas ODK = new OlahDataKelas();
    private Scanner s;
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
        int pil = 0;
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
                if (pil < 0 || pil > 3) {
                    System.out.println("Input harus 1-3");
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
                        System.out.println("1.input jadwal");
                        System.out.println("2.view jadwal 1 hari");
                        System.out.println("3.view jadwal 1 minggu");
                        System.out.println("4.view jadwal 1 bulan");
                        System.out.println("5.view jadwal 1 tahun");
                        System.out.println("6.view jadwal spesifik");
                        break;
                }
            } while (pil != 3);
        } catch (InputMismatchException ie) {
            System.out.println("Input harus angka");
        }finally{
            s = new Scanner(System.in);
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
        System.out.println("input pilihan");
    }

    public void menuOlahDosen(int pil) {
        switch (pil) {
            case 1:
                System.out.println("nama dosen : ");
                String in = s.next();
                System.out.println("kd dosen : ");
                String in1 = s.next();
                Dosen d = new Dosen(in, in1);
                ODS.addDosen(d);
                break;
            case 2:
                System.out.println("masukkan nama dosen yg mau dihapus : ");
                String in2 = s.next();
                ODS.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLDosen==");
                ODS.viewAll();
                System.out.println("===ViewALLDosen==");

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
                ODK.addKelas(k);
                break;
            case 2:
                System.out.println("masukkan kd kelas yg mau dihapus : ");
                String in2 = s.next();
                ODK.remove(in2);
                break;
            case 3:
                System.out.println("===ViewALLDosen==");
                ODK.viewAll();
                System.out.println("===ViewALLDosen==");

        }
    }

    public void olahmenuOlah(int pil) {
        try {
            do {
                tampilanmenuOlah();
                pil = s.nextInt();
                if (pil < 1 || pil > 4) {
                    System.out.println("Input harus 1-4");
                }
                switch (pil) {
                    case 1:
                        menuOlahDosen(pil);
                        break;
                    case 2:
                        menuOlahMK(pil);
                        break;
                    case 3:
                        menuOlahRuang(pil);
                        break;
                    case 4:
                        menuOlahKelas(pil);
                        break;
                }
            } while (pil != 4);

        } catch (InputMismatchException IE) {
            System.out.println("Input Harus Angka");
        } finally {
            s = new Scanner(System.in);
        }
    }
}
