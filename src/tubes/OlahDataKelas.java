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
    /**
     * Menambah sebuah Kelas ke database kelas
     * @param k
     * Menambah sebuah Objek (Kelas k) ke dalam arraylist
     */
    public void addKelas(Kelas k){
        dataKelas.add(k);
    }
    /**
     * Menghapus sebuah objek kelas 
     * @param kdkelas 
     * dengan menginputkan kode kelas yang ingin dihapus
     */
    public void remove(String kdkelas){
        for(Kelas k : dataKelas){
            if(k.getKdKelas().equals(kdkelas)){
                dataKelas.remove(k);
            }
            else{
                System.out.println("Data tidak ditemukan");
            }
        }
    }
    /**
     * Menampilkan seluruh data Kelas yang ada di dalam kelas
     */
    public void viewAll(){
        for(Kelas k : dataKelas){
            System.out.println(k.getKdKelas());
        }
    }
    
    
}
