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
public class Jadwal {
    private Kelas kelas;
    private MataKuliah matkul;
    private Dosen dosen;
    private RuangKelas ruang;
    private Calendar cal;
    private String kdJadwal;

    public Jadwal(Kelas kelas, MataKuliah matkul, Dosen dosen, RuangKelas ruang, Calendar cal, String kdJadwal) {
        this.kelas = kelas;
        this.matkul = matkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.cal = cal;
        this.kdJadwal = kdJadwal;
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

    public Calendar getCal() {
        return cal;
    }

    public String getKdJadwal() {
        return kdJadwal;
    }
    
}
