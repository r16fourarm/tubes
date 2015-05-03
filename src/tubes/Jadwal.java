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
    private int kdJadwal;
    private int shift;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

    public Jadwal(Kelas kelas, MataKuliah matkul, Dosen dosen, RuangKelas ruang, String cal, int kdJadwal, int shift) throws ParseException {
        this.kelas = kelas;
        this.matkul = matkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.shift = shift;
        this.cal = formatter.parse(cal);
        this.kdJadwal = kdJadwal;

    }

    public Jadwal(Kelas kelas, MataKuliah matkul, Dosen dosen, RuangKelas ruang, String cal, int shift) throws ParseException {
        this.kelas = kelas;
        this.matkul = matkul;
        this.dosen = dosen;
        this.ruang = ruang;
        this.cal = formatter.parse(cal);
        this.shift = shift;
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

    public int getKdJadwal() {
        return kdJadwal;
    }

    public int getShift() {
        return shift;
    }

}
