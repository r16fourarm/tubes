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
public class OlahDataJadwal implements TabelOlahData{
    private ArrayList<Jadwal> dataJadwal;

    public OlahDataJadwal() {
        dataJadwal = new ArrayList<Jadwal>();
    }
    public void addJadwal(Jadwal j){
        dataJadwal.add(j);
    }
    public void remove(String nama){
    for(Jadwal j : dataJadwal){
        if(j.getKdJadwal()==nama){
            dataJadwal.remove(j);
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }
    }
    
    public void viewAll(){
        for(Jadwal j : dataJadwal){
            System.out.println(j.getKdJadwal()+"||"+j.getKelas().getKdKelas()+"||"+j.getRuang().getKdRuang()+"||"+j.getDosen().getNama()+"||"+j.getMatkul().getNama()+"||"+j.getCal().toString());
        }
    }
        
    }
    
    

