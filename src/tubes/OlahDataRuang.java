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

public class OlahDataRuang implements TabelOlahData {

    private ArrayList<RuangKelas> dataRuang;

    public OlahDataRuang() {
        dataRuang = new ArrayList<RuangKelas>();
    }

    public void addRuang(RuangKelas r) {
        dataRuang.add(r);
    }

    public void remove(String nama) {
        RuangKelas rkx =null;
        for (RuangKelas r : dataRuang) {
            if (r.getKdRuang().equals(nama)) {
                rkx=r;
                break;
            } else {
                rkx=null;
            }
        }
        if(rkx==null){
            System.out.println("data tidak ada");
        }else{
            dataRuang.remove(rkx);
            System.out.println("data telah dihapus");
        }
    }

    public RuangKelas cariRuang(String nama) {
        RuangKelas rkx = null;
        for (RuangKelas r : dataRuang) {
            if (r.getKdRuang().equals(nama)) {
                rkx = r;
                break;
            } else {
                rkx = null;
                
            }
        }
        return rkx;
    }

    public void viewAll() {
        for (RuangKelas r : dataRuang) {
            System.out.println(r.getKdRuang());
        }
    }

}
