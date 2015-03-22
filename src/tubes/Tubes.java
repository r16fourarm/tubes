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
import java.util.Calendar;
public class Tubes {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        Dosen d1  = new Dosen("jackson","1103d3");
        Dosen d2 =  new Dosen("Mikasa","30303d2");
        MataKuliah mk1 = new MataKuliah("pemograman berorientasi objek","pbo");
        RuangKelas rk1 =  new RuangKelas("A103b",40);
        Kelas k1 =  new Kelas("if3706",35);
        OlahDataDosen td1 = new OlahDataDosen();
        td1.addDosen(d1);
        td1.addDosen(d2);
        td1.viewAll();
        OlahDataKelas dk1 = new OlahDataKelas();
        dk1.addKelas(k1);
        OlahDataMataKuliah dmk1 =  new OlahDataMataKuliah();
        dmk1.addMataKuliah(mk1);
        OlahDataRuang dr1 = new OlahDataRuang();
        dr1.addRuang(rk1);
        Jadwal j1 = new Jadwal(k1,mk1,d1,rk1,"21-Jun-1990","kd1");
        OlahDataJadwal dj1 =  new OlahDataJadwal();
        dj1.addJadwal(j1);
        dj1.viewAll();
        dj1.viewAllJadwalSatuHari("21-Jun-1990");
        
    }
    
}
