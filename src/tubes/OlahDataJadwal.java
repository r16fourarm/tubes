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
public class OlahDataJadwal implements TabelOlahData{
    private ArrayList<Jadwal> dataJadwal;
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    DateFormat formatter2= new SimpleDateFormat("HH-mm-ss");
    
    public OlahDataJadwal() {
        dataJadwal = new ArrayList<Jadwal>();
    }
    public void addJadwal(Jadwal j){
        boolean status=false;
          for(Jadwal jd : dataJadwal){
            try {
                status=cekWaktu(j,jd);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            }
        if(dataJadwal.isEmpty()||!status){
            dataJadwal.add(j);
        }
        else{
               System.out.println("jadwal tsbt sudah diisi");
            }
           
      }
    public void remove(String nama){
    for(Jadwal j : dataJadwal){
        if(j.getKdJadwal().equals(nama)){
            dataJadwal.remove(j);
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
        }
    }
    public boolean cekWaktu(Jadwal j,String tanggal) throws ParseException{
        return (formatter.parse(tanggal).getDate() == j.getCal().getDate()&&formatter.parse(tanggal).getDay() == j.getCal().getDay()&&formatter.parse(tanggal).getYear() ==j.getCal().getYear()&&formatter.parse(tanggal).getHours() == j.getCal().getHours());
    }
    public boolean cekWaktu(Jadwal j,Jadwal jd) throws ParseException{
        return (jd.getCal().getDate() == j.getCal().getDate()&&jd.getCal().getDay() == j.getCal().getDay()&&jd.getCal().getYear() ==j.getCal().getYear()&&jd.getCal().getHours() == j.getCal().getHours());
    }
    public void viewAll(){
        for(Jadwal j : dataJadwal){
            System.out.println(j.getKdJadwal()+"||"+j.getKelas().getKdKelas()+"||"+j.getRuang().getKdRuang()+"||"+j.getDosen().getNama()+"||"+j.getMatkul().getNama()+"||"+formatter.format(j.getCal()));
        }
    }
    public void viewAllJadwalSatuHari(String tanggal) {
        for (Jadwal j : dataJadwal){
            try {
                if(cekWaktu(j,tanggal)){
                    System.out.println(j.getKelas().getKdKelas()+"||"+j.getRuang().getKdRuang()+"||"+j.getDosen().getNama()+"||"+j.getMatkul().getNama());
                
                }
                else{
                    System.out.println("tdk ad jdwl");
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            }
            
        }
    }

    
    

