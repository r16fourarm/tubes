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

public class OlahDataMataKuliah implements TabelOlahData {

    private ArrayList<MataKuliah> dataMk;

    public OlahDataMataKuliah() {
        this.dataMk = new ArrayList<MataKuliah>();
    }

    public void addMataKuliah(MataKuliah mk) {
        MataKuliah mkx = cariMK(mk.getNama(), mk.getKdMk());
        if (mkx == null) {
            dataMk.add(mk);
        } else {
            System.out.println("data sudah ada");
        }
    }

    public void remove(String nama) {
        MataKuliah mkx = null;
        for (MataKuliah mk : dataMk) {
            if (mk.getNama().equals(nama)) {
                mkx = mk;
                break;
            } else {
                mkx = null;
            }
        }
        if (mkx == null) {
            System.out.println("data tidak ada");
        } else {
            dataMk.remove(mkx);
            System.out.println("data telah dihapus");
        }
    }

    public MataKuliah cariMK(String kdMk) {
        MataKuliah mkx = null;
        for (MataKuliah mk : dataMk) {
            if (mk.getKdMk().equals(kdMk)) {
                mkx = mk;
            } else {
                mkx = null;
            }
        }
        return mkx;
    }

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

    public void viewAll() {
        for (MataKuliah mk : dataMk) {
            System.out.println(mk.getNama());
        }
    }
}
