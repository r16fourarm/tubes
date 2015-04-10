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
import java.util.ArrayList;

public class OlahDataDosen implements TabelOlahData {

    private ArrayList<Dosen> dataDosen;

    public OlahDataDosen() {
        this.dataDosen = new ArrayList<Dosen>();
    }

    public void addDosen(Dosen d) {
        Dosen x = cariDosen(d.getNama(),d.getKdDosen());
        if(x==null){
        dataDosen.add(d);}
        else{
            System.out.println("dosen sudah ada");
        }
    }

    public void remove(String nama) {
        Dosen dx = null;
        for (Dosen d : dataDosen) {
            if (d.getNama().equals(nama)) {
                dx = d;
                break;
            } else {
                dx = null;
            }
        }
        if (dx == null) {
            System.out.println("data tidak ada di tabel data");
        } else {
            dataDosen.remove(dx);
            System.out.println("data telah dihapus");
        }
    }

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
    
    public Dosen cariDosen(String nama,String kdDosen) {
        Dosen dx = null;
        for (Dosen d : dataDosen) {
            if (d.getNama().equals(nama)||d.getKdDosen().equals(kdDosen)) {
                dx = d;
            } else {
                dx = null;
                break;
            }
        }
        return dx;
    }

    public void viewAll() {
        for (Dosen d : dataDosen) {
            System.out.println(d.getNama());
        }
    }
}
