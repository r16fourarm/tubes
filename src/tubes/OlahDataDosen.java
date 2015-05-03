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


public class OlahDataDosen implements TabelOlahData {

    private DBase db;
    private String query;
    private ArrayList<Dosen> dataDosen;

    public ArrayList<Dosen> getDataDosen() {
        return dataDosen;
    }
/**
 * konstruktor instansiansi OlahDataDosen,Database
 * sekaligus connect Database
 */
    public OlahDataDosen() {
        this.dataDosen = new ArrayList<Dosen>();
        db = new DBase();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/**
 * menambahkan Dosen kedalam Tabel dosen
 * @param o 
 * add objek o yang di cast menjadi Dosen  kedalam Arraylist/DB
 */
    @Override
    public void add(Object o) {
            Dosen d = (Dosen) o;
            dataDosen.add(d);
            query = "insert into olahdosen" + "(kddosen,namadosen)"
                    + "values ('" + d.getKdDosen() + "', " + "'" + d.getNama() + "')";
            db.execute(query);
       
    }
/**
 * menghapus Dosen dari Tabel
 * @param o 
 * hapus objek o yang di cast menjadi dosen dari dalam Arraylist/DB
 */
    @Override
    public void remove(Object o) {
            Dosen d =(Dosen) o;
            query="delete from olahdosen where(kddosen='"+d.getKdDosen()+"')";
            db.execute(query);
            System.out.println("data telah dihapus");
      
    }
/**
 * mencari objek Dosen dari dalam Arraylist/DB
 * @param kdDosen
 * dengan parameter kdDosen
 * @return 
 * mengembalikan Objek Dosen jika ditemukan dan Null jika tidak
 */
    public Dosen cariDosen(String kdDosen) {
        Dosen dx = null;
        for (Dosen d : dataDosen) {
            if (d.getKdDosen().equals(kdDosen)) {
                dx = d;
                break;
            } else {
                dx = null;
            }
        }
        return dx;
    }
/**
 * overloading method dari method diatas dengan parameter yang lebih banyak(tidak terpakai di program)
 * @param nama
 * dengan parameter nama dosen
 * @param kdDosen
 * parameter kode dosen
 * @return
 * mengembalikan Objek Dosen jika ditemukan dan Null jika tidak
 */
    public Dosen cariDosen(String nama, String kdDosen) {
        Dosen dx = null;
        for (Dosen d : dataDosen) {
            if (d.getNama().equals(nama) || d.getKdDosen().equals(kdDosen)) {
                dx = d;
            } else {
                dx = null;
                break;
            }
        }
        return dx;
    }
/**
 * method untuk melihat semua data Dosen dari dalam tabel dosen/Arraylist/DB
 */
    @Override
    public void viewAll() {
        loadData();
        for (Dosen d : dataDosen) {
            System.out.println(d.getNama() + "||" + d.getKdDosen());
        }
        emptyTemp();
    }
 /**
  * method load data dari database dan menyimpannya ke temporary arraylist 
  */
    @Override
    public void loadData(){
    query = "select * from olahdosen";
        
        try {
            ResultSet rs = db.getData(query);
            while (rs.next()) {

                String sbkdDosen = rs.getString("kdDosen");
                String sbnmDosen = rs.getString("namaDosen");
                Dosen dv = new Dosen(sbnmDosen, sbkdDosen);
                dataDosen.add(dv);
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
        dataDosen.clear();
    }
}
