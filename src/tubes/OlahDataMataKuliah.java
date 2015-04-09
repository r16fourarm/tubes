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
public class OlahDataMataKuliah implements TabelOlahData{
    private ArrayList<MataKuliah> dataMk;

    public OlahDataMataKuliah() {
        this.dataMk = new ArrayList<MataKuliah>();
    }
    public void addMataKuliah(MataKuliah mk){
        dataMk.add(mk);
    }
    public void remove(String nama){
        for (MataKuliah mk : dataMk){
            if(mk.getNama().equals(nama)){
                ArrayList<MataKuliah>tmpmk = new ArrayList<MataKuliah>(dataMk);
                tmpmk.remove(mk);
                dataMk=tmpmk;
            }
            else{
                System.out.println("data tidak ditemukan");
                break;
            }
        }
    }
    public MataKuliah cariMK(String nama){
        MataKuliah mkx = null;
        for(MataKuliah mk : dataMk){
            if(mk.getKdMk().equals(nama)){
                mkx = mk;
            }
            else{
                mkx =null;
            }
        }
        return mkx;
    }
    public void viewAll(){
        for(MataKuliah mk : dataMk){
            System.out.println(mk.getNama());
        }
    }
}
