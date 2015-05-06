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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class OlahDataJadwal implements TabelOlahData {

    private ArrayList<Jadwal> dataJadwal;
    private ArrayList<Dosen> tempODS;
    private ArrayList<MataKuliah> tempODMK;
    private ArrayList<Kelas> tempODK;
    private ArrayList<RuangKelas> tempOR;
    private DBase db;
    private String query, query1, query2, query3;
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

/**
 * 
 */
    public OlahDataJadwal() {
        dataJadwal = new ArrayList<Jadwal>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
 * getter arraylist jadwal
 * @return 
 */
    public ArrayList<Jadwal> getDataJadwal() {
        return dataJadwal;
    }
/**
 * menambahkan jadwal ke db/list
 * @param o 
 * Parameter Objek o yang di cast menjadi Jadwal
 */
    @Override
    public void add(Object o) {
        Jadwal j = (Jadwal) o;
        dataJadwal.add(j);
        query = "INSERT INTO olahjadwal( kdDosen, kdMk, kdKelas, kdRuang, tanggal, shift) VALUES ('"
                + j.getDosen().getKdDosen() + "','"
                + j.getMatkul().getKdMk() + "','"
                + j.getKelas().getKdKelas() + "','"
                + j.getRuang().getKdRuang() + "','"
                + new java.sql.Date(j.getCal().getTime()) + "',"
                + j.getShift() + ")";
        db.execute(query);
        Collections.sort(dataJadwal, new Comparator<Jadwal>() {
            @Override
            public int compare(Jadwal j1, Jadwal j2) {
                if (j1.getCal() == null || j2.getCal() == null) {
                    return 0;
                }
                return j1.getCal().compareTo(j2.getCal());
            }
        });

    }
/**
 * menghapus jadwal dari list/db
 * @param o 
 * paramter objek o yang di cast menjadi Jadwal
 */
    public void remove(Object o) {
        Jadwal jx = (Jadwal) o;
        dataJadwal.remove(jx);
        query = "delete from olahjadwal where kdJadwal=" + jx.getKdJadwal();
        System.out.println("data telah dihapus");
    }
/**
 * method cek waktu 
 * @param j
 * @param tanggal
 * @return
 * @throws ParseException 
 */
    public boolean cekWaktu(Jadwal j, String tanggal) throws ParseException {
        return (formatter.parse(tanggal).getDate() == j.getCal().getDate() && formatter.parse(tanggal).getDay() == j.getCal().getDay() && formatter.parse(tanggal).getYear() == j.getCal().getYear() && formatter.parse(tanggal).getHours() == j.getCal().getHours());
    }
/**
 * overloading method cekwaktu 1
 * @param j
 * @param jd
 * @return
 * @throws ParseException 
 */
    public boolean cekWaktu(Jadwal j, Jadwal jd) throws ParseException {
        return (jd.getCal().getDate() == j.getCal().getDate() && jd.getCal().getDay() == j.getCal().getDay() && jd.getCal().getYear() == j.getCal().getYear() && jd.getCal().getHours() == j.getCal().getHours());
    }
/**
 * overloading method cekwaktu 2
 * @param j
 * @param bulan
 * @return 
 */
    public boolean cekWaktu(Jadwal j, int bulan) {
        return (j.getCal().getMonth() + 1 == bulan);
    }
/**
 * method untuk mencari jadwal dari dalam list/db
 * @param tanggal
 * parameter tanggal bertype String
 * @param shift
 * paramter shift bertype int
 * @return
 * mengembalikan objek Jadwal jika ada dan mengembalikan null jika tidak
 * @throws ParseException 
 */
//kondisi dosen,ruang,kelas#overload untuk menu
    public Jadwal cariJadwal(String tanggal, int shift) throws ParseException {
        Jadwal jx = null;
        for (Jadwal j : dataJadwal) {
            if (formatter.parse(tanggal).equals(j.getCal()) && shift == j.getShift()) {
                jx = j;
            } else {
                jx = null;
            }
        }
        return jx;
    }
/**
 * overloading method carijadwal ke 1
 * @param tanggal
 * @param shift
 * @param kdDosen
 * @param kdKelas
 * @param kdRuang
 * @return
 * @throws ParseException 
 */
    public Jadwal cariJadwal(String tanggal, int shift, String kdDosen, String kdKelas, String kdRuang) throws ParseException {
        Jadwal jx = null;
        for (Jadwal j : dataJadwal) {
            if (formatter.parse(tanggal).equals(j.getCal()) && shift == j.getShift()) {
                if (j.getDosen().getKdDosen().equals(kdDosen) || j.getKelas().getKdKelas().equals(kdKelas) || j.getRuang().getKdRuang().equals(kdRuang)) {
                    jx = j;
                    break;
                } else {
                    jx = null;
                }
            } else {
                jx = null;
            }
        }
        return jx;
    }
/**
 * method untuk melihat semua data jadwal dari list/db
 */
    @Override
    public void viewAll() {
        for (Jadwal j : dataJadwal) {
            System.out.println(j.getKdJadwal() + "||" + j.getKelas().getKdKelas() + "||" + j.getRuang().getKdRuang() + "||" + j.getDosen().getNama() + "||" + j.getMatkul().getNama() + "||" + formatter.format(j.getCal()) + "||" + j.getShift());
        }
    }
/**
 * method untuk melihat semua jadwal yang telah dibuat dalam 1 hari tertentu
 * @param tanggal 
 * paramter tanggal bertype String
 */
    public void viewAllJadwalSatuHari(String tanggal) {
        for (Jadwal j : dataJadwal) {
            try {
                if (cekWaktu(j, tanggal)) {
                    System.out.println(j.getKelas().getKdKelas() + "||" + j.getRuang().getKdRuang() + "||" + j.getDosen().getNama() + "||" + j.getMatkul().getNama() + "||" + j.getShift());

                } else {
                    System.out.println("tdk ad jdwl");
                }
            } catch (ParseException ex) {
                System.out.println("format input tanggal salah");;
            }
        }
    }
/**
 * method untuk melihat semua jadawl yang telah dibuat dalam 1 bulan tertentuu
 * @param bulan 
 * paramter bulan bertype int
 */
    public void viewAllJadwalSatuBulan(int bulan) {
        for (Jadwal j : dataJadwal) {
            if (cekWaktu(j, bulan)) {
                System.out.println(j.getKelas().getKdKelas() + "||" + j.getRuang().getKdRuang() + "||" + j.getDosen().getNama() + "||" + j.getMatkul().getNama() + "||" + j.getShift());
            } else {
                System.out.println("tdk ad jdwal");
            }
        }
    }
    /**
     * method pengecekan constraint tanggal inputan(input harus lebih dari tanggal sekarang)
     * @param tanggal
     * parameter tanggal bertype String
     * @return
     * mengembalikan boolean
     * @throws ParseException 
     */
    public boolean cekConstraintTanggal(String tanggal) throws ParseException{
        return (formatter.parse(tanggal).getTime()<new Date().getTime());
    }
    /**
     * method load data dari db
     */
    @Override
    public void loadData() {
        query = "select * from olahjadwal";
        try {
            ResultSet rs = db.getData(query);

            while (rs.next()) {
                String kdDosen = rs.getString("kdDosen");
                Dosen d = new Dosen("", kdDosen);
                String kdMk = rs.getString("kdMk");
                MataKuliah mk =  new MataKuliah("", kdMk);
                String kdKelas = rs.getString("kdKelas");
                Kelas k =  new Kelas(kdKelas,0);
                String kdRuang = rs.getString("kdRuang");
                RuangKelas r = new RuangKelas(kdRuang, 0);
                int shift = Integer.parseInt(rs.getString("shift"));
                int idJadwal = Integer.parseInt(rs.getString("kdJadwal"));
                String tgl =  formatter.format(formatter2.parse(rs.getString("tanggal")));
                Jadwal  j = new Jadwal(k, mk, d, r, tgl, idJadwal, shift);
                dataJadwal.add(j);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
    }
/**
 * method mengosong kan temporary arraylist
 */
    @Override
    public void emptyTemp() {
        dataJadwal.clear();
    }

}
