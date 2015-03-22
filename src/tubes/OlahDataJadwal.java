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
import java.text.ParseException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
public class OlahDataJadwal implements TabelOlahData{
    private ArrayList<Jadwal> dataJadwal;
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    
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
            System.out.println(j.getKdJadwal()+"||"+j.getKelas().getKdKelas()+"||"+j.getRuang().getKdRuang()+"||"+j.getDosen().getNama()+"||"+j.getMatkul().getNama()+"||"+formatter.format(j.getCal()));
        }
    }
    public void viewAllJadwalSatuHari(String tanggal){
        for (Jadwal j : dataJadwal){
            try{
                if(formatter.parse(tanggal) == j.getCal()){
                    System.out.println(j.getKelas().getKdKelas()+"||"+j.getRuang().getKdRuang()+"||"+j.getDosen().getNama()+"||"+j.getMatkul().getNama());
                }
            }
            catch(ParseException ex){
            ex.printStackTrace();
            }
            }
            
        }
    }
   
    
    

