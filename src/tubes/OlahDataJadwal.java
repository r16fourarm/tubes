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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OlahDataJadwal implements TabelOlahData {

    private ArrayList<Jadwal> dataJadwal;
    private DBase db;
    private String query;
    DateFormat formatter = new SimpleDateFormat("dd;-MMM-yyyy");
    DateFormat formatter2 = new SimpleDateFormat("HH-mm-ss");

    public OlahDataJadwal() {
        dataJadwal = new ArrayList<Jadwal>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void add(Object o) {
        Jadwal j = (Jadwal) o;
        dataJadwal.add(j);
        /*query = "insert into olahruang" + "(kdruang,kapasitasruang)"
                    + "values ('" + r.getKdRuang() + "', " + r.getnKapasitas() + ")";
            db.execute(query);*/
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

    public void remove(Object o) {
        Jadwal jx = (Jadwal) o; 
            dataJadwal.remove(jx);
            System.out.println("data telah dihapus");
    }
    public boolean cekWaktu(Jadwal j, String tanggal) throws ParseException {
        return (formatter.parse(tanggal).getDate() == j.getCal().getDate() && formatter.parse(tanggal).getDay() == j.getCal().getDay() && formatter.parse(tanggal).getYear() == j.getCal().getYear() && formatter.parse(tanggal).getHours() == j.getCal().getHours());
    }

    public boolean cekWaktu(Jadwal j, Jadwal jd) throws ParseException {
        return (jd.getCal().getDate() == j.getCal().getDate() && jd.getCal().getDay() == j.getCal().getDay() && jd.getCal().getYear() == j.getCal().getYear() && jd.getCal().getHours() == j.getCal().getHours());
    }

    public boolean cekWaktu(Jadwal j, int bulan) {
        return (j.getCal().getMonth() + 1 == bulan);
    }

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

    @Override
    public void viewAll() {
        for (Jadwal j : dataJadwal) {
            System.out.println(j.getKdJadwal() + "||" + j.getKelas().getKdKelas() + "||" + j.getRuang().getKdRuang() + "||" + j.getDosen().getNama() + "||" + j.getMatkul().getNama() + "||" + formatter.format(j.getCal()) + "||" + j.getShift());
        }
    }

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

    public void viewAllJadwalSatuBulan(int bulan) {
        for (Jadwal j : dataJadwal) {
            if (cekWaktu(j, bulan)) {
                System.out.println(j.getKelas().getKdKelas() + "||" + j.getRuang().getKdRuang() + "||" + j.getDosen().getNama() + "||" + j.getMatkul().getNama() + "||" + j.getShift());
            } else {
                System.out.println("tdk ad jdwal");
            }
        }
    }

    @Override
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emptyTemp() {
        dataJadwal.clear();
    }

}
