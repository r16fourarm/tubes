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
public class OlahDataDosen implements TabelOlahData{
    private ArrayList<Dosen> dataDosen;

    public OlahDataDosen() {
        this.dataDosen = new ArrayList<Dosen>();  
    }
    public void addDosen(Dosen d){
      dataDosen.add(d);
    }
    public void remove(String nama){
        for (Dosen d : dataDosen){
            if (d.getNama()== nama){
                dataDosen.remove(d);
            }
            else
            {
                System.out.println("Data tidak ditemukan");
                break;
            }    
        }
    }
    public void viewAll(){
        for(Dosen d: dataDosen){
            System.out.println(d.getNama());
        }
    }
}
