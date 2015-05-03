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
import java.util.logging.Level;
import java.util.logging.Logger;

public class OlahDataMataKuliah implements TabelOlahData {
    private DBase db;
    private String query;
    private ArrayList<MataKuliah> dataMk;
/**
 * konstruktor menginstansiansi Arraylist MK,Database
 * Sekaligus Connect Database
 */
    public OlahDataMataKuliah() {
        this.dataMk = new ArrayList<MataKuliah>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<MataKuliah> getDataMk() {
        return dataMk;
    }
/**
 * menambahkan MataKuliah ke dalam Arraylist/DB
 * @param o 
 * add objek o yang di cast menjadi MataKuliah kedalam Arraylist/DB
 */
    public void add(Object o) {
        MataKuliah mk = (MataKuliah) o;
            dataMk.add(mk);
            query = "insert into olahmk" + "(kdmk,namamk)"
                    + "values ('" +mk.getKdMk() + "', " + "'" + mk.getNama()+ "')";
            db.execute(query);
    }
/**
 * menghapus MataKuliah dari dalam Arraylist/DB
 * @param o 
 * remove objek o yang di cast menjadi MataKuliah dari dalam Arraylist/DB
 */
    public void remove(Object o) {
        MataKuliah mkx = (MataKuliah) o;
            query="delete from olahmk where(kdmk='"+mkx.getKdMk()+"')";
            db.execute(query);
            System.out.println("data telah dihapus");
    }
/**
 * mencari MataKuliah dari dalam Arraylist/DB
 * @param kdMk
 * parameter yang digunakan kode MK
 * @return 
 * mengembalikan objek MataKuliah jika ditemukan dan Null jika tidak
 */
    public MataKuliah cariMK(String kdMk) {
        MataKuliah mkx = null;
        for (MataKuliah mk : dataMk) {
            if (mk.getKdMk().equals(kdMk)) {
                mkx = mk;
                break;
            } else {
                mkx = null;
            }
        }
        return mkx;
    }
/**
 * overloading method dari method diatas dimana menggunakan parameter yang lebih banyak(tidak terpakai di program) 
 * @param nama
 * parameter yang digunakan nama matakuliah
 * @param kdMk
 * parameter yang digunakan kode matakuliah
 * @return 
 * mengembalikan objek MataKuliah jika ditemukan dan Null jika tidak
 */
    public MataKuliah cariMK(String nama, String kdMk) {
        MataKuliah mkx = null;
        for (MataKuliah mk : dataMk) {
            if (mk.getNama().equals(nama) && mk.getKdMk().equals(kdMk)) {
                mkx = mk;
            } else {
                mkx = null;
            }
        }
        return mkx;
    }
/**
 * method yang menampilkan seluruh matakuliah dari Arraylist/DB
 */
    @Override
    public void viewAll() {
        loadData();
        for (MataKuliah mk : dataMk) {
            System.out.println(mk.getNama()+"||"+mk.getKdMk());
        }
        emptyTemp();
    }
/**
 * method load data dari database dan menyimpannya ke temporary arraylist
 */
    @Override
    public void loadData() {
    query = "select * from olahmk";
        try {
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                String sbkdMk = rs.getString("kdmk");
                String sbnmMk = rs.getString("namamk");
                MataKuliah mkv = new MataKuliah(sbnmMk, sbkdMk);
                dataMk.add(mkv);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/**
 * method mengosongkan temporary arraylist
 */
    @Override
    public void emptyTemp() {
        dataMk.clear();
    }
    
}
