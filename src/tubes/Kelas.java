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
public class Kelas {
   private String kdKelas;
   private int nKapasitas;

    public Kelas(String kdKelas, int nKapasitas) {
        this.kdKelas = kdKelas;
        this.nKapasitas = nKapasitas;
    }

    public void setnKapasitas(int nKapasitas) {
        this.nKapasitas = nKapasitas;
    }

    public String getKdKelas() {
        return kdKelas;
    }

    public int getnKapasitas() {
        return nKapasitas;
    }
   
}
