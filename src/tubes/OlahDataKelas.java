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
import java.util.ArrayList;

public class OlahDataKelas implements TabelOlahData {

    private DBase db;
    private String query;
    private ArrayList<Kelas> dataKelas;

    public OlahDataKelas() {
        dataKelas = new ArrayList<Kelas>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Kelas> getDataKelas() {
        return dataKelas;
    }

    /**
     * Menambah sebuah Kelas ke database kelas
     * @param o
     * Menambah sebuah Objek o yang di cast menjadi kelas ke dalam arraylist/DB
     */
    @Override
    public void add(Object o) {
        Kelas k = (Kelas) o;
            dataKelas.add(k);
            query = "insert into olahkelas" + "(kdkelas,kapasitas)"
                    + "values ('" + k.getKdKelas() + "', " + k.getnKapasitas() + ")";
            db.execute(query);
    }
    /**
     * Menghapus kelas dari dalam arraylist/DB
     * @param o
     * menghapus objek o yang di cast ke Kelas dari dalam arraylist/DB
     */
    @Override
    public void remove(Object o) {
            Kelas k=(Kelas) o;
            query = "delete from olahkelas where(kdkelas='" + k.getKdKelas() + "')";
            db.execute(query);
            dataKelas.remove(k);
            System.out.println("data telah dihapus");
        
    }
/**
 * method untuk mencari Kelas dalam arraylist/DB
 * @param kdkelas
 * parameter yang digunakan kode kelas
 * @return 
 * mengembalikan Objek Kelas jika ditemukan dan Null jika tidak
 */
    public Kelas cariKelas(String kdkelas) {
        Kelas km = null;
        for (Kelas k : dataKelas) {
            if (k.getKdKelas().equals(kdkelas)) {
                km = k;
                break;
            } else {
                km = null;
            }
        }
        return km;
    }

    /**
     * Menampilkan seluruh data Kelas yang ada di dalam kelas
     */
    @Override
    public void viewAll() {
        loadData();
        for (Kelas k : dataKelas) {
            System.out.println(k.getKdKelas());
        }
        emptyTemp();
    }

    @Override
    public void loadData() {
        query = "select * from olahkelas";
        try {
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                String sbkdk = rs.getString("kdkelas");
                int sbkap = Integer.parseInt(rs.getString("kapasitas"));
                Kelas kv = new Kelas(sbkdk, sbkap);
                dataKelas.add(kv);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void emptyTemp() {
        dataKelas.clear();
    }

}
