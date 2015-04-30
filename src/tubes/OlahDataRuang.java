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


public class OlahDataRuang implements TabelOlahData {

    private DBase db;
    private String query;
    private ArrayList<RuangKelas> dataRuang;
/**
 * konstruktor menginstansiansi Arraylist Ruang,Database
 * sekaligus Connect Database
 */
    public OlahDataRuang() {
        dataRuang = new ArrayList<RuangKelas>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/**
 * menambahkan Ruang kedalam Arraylist/DB
 * @param o 
 * add object o yang di cast menjadi Ruang ke dalam Arraylist/DB
 */
    @Override
    public void add(Object o) {
        RuangKelas r =  (RuangKelas) o;
            dataRuang.add(r);
            query = "insert into olahruang" + "(kdruang,kapasitasruang)"
                    + "values ('" + r.getKdRuang() + "', " + r.getnKapasitas() + ")";
            db.execute(query);
    }
/**
 * menghapus Ruang dari dalam Arraylist/DB
 * @param o 
 * remove object o yang di cast menjadi Ruang dari dalam Arraylist/DB
 */
    @Override
    public void remove(Object o) {
        RuangKelas rkx = (RuangKelas) o;

            dataRuang.remove(rkx);
            System.out.println("data telah dihapus");
    }
/**
 * method untuk mencari Ruang dari dalam Arraylist/DB
 * @param kdruang
 * dengan parameter kode ruang
 * @return
 * mengembalikan objek ruang jika ditemukan dan Null jika tidak
 */
    public RuangKelas cariRuang(String kdruang) {
        RuangKelas rkx = null;
        for (RuangKelas r : dataRuang) {
            if (r.getKdRuang().equals(kdruang)) {
                rkx = r;
                break;
            } else {
                rkx = null;
            }
        }
        return rkx;
    }
/**
 * method untuk melihat semua ruang yang ada di dalam Arraylist/DB
 */
    @Override
    public void viewAll() {
        loadData();
        for (RuangKelas r : dataRuang) {
            System.out.println(r.getKdRuang());
        }
        emptyTemp();
    }
/**
 * method load data dari database ke dalam temporary arraylist
 */
    @Override
    public void loadData() {
    query = "select * from olahmk";
        try {
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                String sbkdr = rs.getString("kdruang");
                int sbkr = Integer.parseInt(rs.getString("kapasitasruang"));
                RuangKelas rv = new RuangKelas(sbkdr, sbkr);
                dataRuang.add(rv);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/**
 * method untuk mengosongkan temporary arraylist
 */
    @Override
    public void emptyTemp() {
        dataRuang.clear();
    }

}
