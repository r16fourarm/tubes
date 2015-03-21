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
public class OlahDataRuang implements TabelOlahData{
    private ArrayList<RuangKelas> dataRuang;

    public OlahDataRuang() {
        dataRuang = new ArrayList<RuangKelas>();
    }
    public void addRuang(RuangKelas r){
        dataRuang.add(r);
    }
    public void remove(String nama){
        for(RuangKelas r : dataRuang){
            if(r.getKdRuang()==nama){
                dataRuang.remove(r);
            }
            else{
                System.out.println("data tidak ditemukan");
                break;
            }
        }
    }
    public void viewAll(){
        for(RuangKelas r : dataRuang){
            System.out.println(r.getKdRuang());
        }
    }
    
}
