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
public class RuangKelas {
    private String kdRuang;
    private int nKapasitas;

    public RuangKelas(String kdRuang, int nKapasitas) {
        this.kdRuang = kdRuang;
        this.nKapasitas = nKapasitas;
    }

    public void setnKapasitas(int nKapasitas) {
        this.nKapasitas = nKapasitas;
    }

    public String getKdRuang() {
        return kdRuang;
    }

    public int getnKapasitas() {
        return nKapasitas;
    }
    
}
