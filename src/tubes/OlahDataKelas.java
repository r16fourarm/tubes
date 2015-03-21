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
public class OlahDataKelas implements TabelOlahData{
    private ArrayList<Kelas> dataKelas;

    public OlahDataKelas() {
        dataKelas = new ArrayList<Kelas>();
    }
    public void addKelas(Kelas k){
        dataKelas.add(k);
    }
    public void remove(String nama){
        for(Kelas k : dataKelas){
            if(k.getKdKelas()==nama){
                dataKelas.remove(k);
            }
            else{
                System.out.println("Data tidak ditemukan");
            }
        }
    }
    public void viewAll(){
        for(Kelas k : dataKelas){
            System.out.println(k.getKdKelas());
        }
    }
    
    
}