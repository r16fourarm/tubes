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
import java.util.Date;
import java.text.SimpleDateFormat;

public class Jadwal {

    private Kelas kelas;
    private MataKuliah matkul;
    private Dosen dosen;
    private RuangKelas ruang;
    private Date cal;
    private String kdJadwal;
    private int shift;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

    public Jadwal(Kelas kelas, MataKuliah matkul, Dosen dosen, RuangKelas ruang, String cal, String kdJadwal, int shift) {
            this.kelas = kelas;
            this.matkul = matkul;
            this.dosen = dosen;
            this.ruang = ruang;
            this.shift = shift;
            try {
                this.cal = formatter.parse(cal);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            this.kdJadwal = kdJadwal;
        
    }

    public boolean cekFull(RuangKelas r, Kelas k) {
        return (r.getnKapasitas() >= k.getnKapasitas());
    }

    public Kelas getKelas() {
        return kelas;
    }

    public MataKuliah getMatkul() {
        return matkul;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public RuangKelas getRuang() {
        return ruang;
    }

    public Date getCal() {
        return cal;
    }

    public String getKdJadwal() {
        return kdJadwal;
    }

    public int getShift() {
        return shift;
    }

}
