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

public class Tubes {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        Dosen d1  = new Dosen("jackson","1103d3");
        Dosen d2 =  new Dosen("Mikasa","30303d2");
        Dosen d3 = new Dosen("Brontosaurus","dino09293");
        MataKuliah mk1 = new MataKuliah("pemograman berorientasi objek","pbo");
        RuangKelas rk1 =  new RuangKelas("A103b",40);
        Kelas k1 =  new Kelas("if3706",35);
        Kelas k2 =  new Kelas("if0106",35);
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
        Jadwal j2 = new Jadwal(k2,mk1,d2,rk1,"21-Jun-1990","kd2");
        Jadwal j3 = new Jadwal(k1,mk1,d3,rk1,"21-Jul-1920","kd3");
        Jadwal j4 = new Jadwal(k1,mk1,d2,rk1,"11-May-1920","kd4");
        OlahDataJadwal dj1 =  new OlahDataJadwal();
        dj1.addJadwal(j1);
        dj1.viewAll();
        dj1.viewAllJadwalSatuHari("21-Jun-1993");
        dj1.addJadwal(j2);
        dj1.addJadwal(j3);
        dj1.addJadwal(j4);
        System.out.println();
        System.out.println(j1.getCal().getDate()+"||"+j3.getCal().getDate());
        dj1.viewAll();
        
    }
    
}
