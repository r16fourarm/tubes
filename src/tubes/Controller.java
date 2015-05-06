/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author R16
 */
public class Controller extends MouseAdapter implements ActionListener, MouseListener {

    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    private guimenu gui;
    private OlahDataDosen ods = new OlahDataDosen();
    private OlahDataJadwal odj = new OlahDataJadwal();
    private OlahDataKelas odk = new OlahDataKelas();
    private OlahDataMataKuliah odmk = new OlahDataMataKuliah();
    private OlahDataRuang odr = new OlahDataRuang();
    private JFrame framejoptpane = new JFrame();
    private ArrayList<JPanel> arycomp = new ArrayList<>();
    private final ImageIcon iconbtnexit = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-cancel-clicked.png");
    private final ImageIcon iconbtnexitclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-keluar-clicked.png");
    private final ImageIcon iconbtnOlahData = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-olah-data.png");
    private final ImageIcon iconbtnOlahDataclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-olahdata-clicked.png");
    private final ImageIcon iconbtnOlahJadwal = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-oahjadwal.png");
    private final ImageIcon iconbtnOlahJadwalclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-jadwal-clicked.png");
    private final ImageIcon iconbtnOlahDosen = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-dosen.png");
    private final ImageIcon iconbtnOlahDosenclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-dosen-clicked.png");
    private final ImageIcon iconbtnOlahMk = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-matkul.png");
    private final ImageIcon iconbtnOlahMkclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-matkul-clicked.png");
    private final ImageIcon iconbtnOlahKelas = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-kelas.png");
    private final ImageIcon iconbtnOlahKelasclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-kelas-clicked.png");
    private final ImageIcon iconbtnOlahRuang = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-ruang.png");
    private final ImageIcon iconbtnOlahRuangclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-ruang-clicked.png");
    private final ImageIcon iconbtnBackOlahData = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-back.png");
    private final ImageIcon iconbtnBackOlahDataclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-back-clicked.png");
    private final ImageIcon iconbtnSave = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-tambahdata.png");
    private final ImageIcon iconbtnSaveclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-tambahdata-clicked.png");
    private final ImageIcon iconbtnHapus = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-hapus.png");
    private final ImageIcon iconbtnHapusclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-hapus-clicked.png");
    private final ImageIcon iconbtnCancel = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-cancel.png");
    private final ImageIcon iconbtnCancelclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-cancel-clicked.png");
    private final ImageIcon iconbtnViewOlahData = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-lihatdata.png");
    private final ImageIcon iconbtnViewOlahDataclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-lihatdata-clicked.png");
    private final ImageIcon iconbtnInputJadwal = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-input-jadwal.png");
    private final ImageIcon iconbtnInputJadwalclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-inputjadwal-clicked.png");
    private final ImageIcon iconbtnViewAllJadwal = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-semua.png");
    private final ImageIcon iconbtnViewAllJadwalClicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-semua-clicked.png");
    private final ImageIcon iconbtnViewAllJadwal1hari = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-1hari.png");
    private final ImageIcon iconbtnViewAllJadwal1hariClicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-1hari-clicked.png");
    private final ImageIcon iconbtnView1bulanJadwal = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-bulan.png");
    private final ImageIcon iconbtnView1bulanJadwalClicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-bulan-clicked.png");
/**
 * set view yang dipakai 
 * @param gui 
 * gui yang digunakan
 */
    public void setView(guimenu gui) {
        this.gui = gui;
        simpen();
    }
/**
 * set listener yang digunakan
 */
    public void setListener() {
        gui.addlistener(this);
        gui.addMouseListeners(this);

    }
/**
 * action performed dari event yang ada
 * @param e 
 * action event
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getjButton1())) {
            odj.loadData();
            String Data[][] = new String[odj.getDataJadwal().size()][7];
            int i = 0;
            String[] title = {"kode Jadwal", "Tanggal", "Shift", "Kode Dosen", "Kode MK", "Kode Kelas", "Kode Ruang"};
            for (Jadwal j : odj.getDataJadwal()) {
                if (j.getCal().getMonth() == comboboxbulan()) {
                    Data[i][0] = "" + j.getKdJadwal();
                    Data[i][1] = formatter.format(j.getCal());
                    Data[i][2] = "" + shifttoString(j.getShift());
                    Data[i][3] = j.getDosen().getKdDosen();
                    Data[i][4] = j.getMatkul().getKdMk();
                    Data[i][5] = j.getKelas().getKdKelas();
                    Data[i][6] = j.getRuang().getKdRuang();
                    i++;
                }
            }
            gui.getTableviewjadwalbulan().setModel(new DefaultTableModel(Data, title));
            odj.emptyTemp();
        } else if (source.equals(gui.getBtnrefviewalljadwal())) {
            odj.loadData();
            String Data[][] = new String[odj.getDataJadwal().size()][7];
            int i = 0;
            String[] title = {"kode Jadwal", "Tanggal", "Shift", "Kode Dosen", "Kode MK", "Kode Kelas", "Kode Ruang"};
            for (Jadwal j : odj.getDataJadwal()) {

                Data[i][0] = "" + j.getKdJadwal();
                Data[i][1] = formatter.format(j.getCal());
                Data[i][2] = "" + shifttoString(j.getShift());
                Data[i][3] = j.getDosen().getKdDosen();
                Data[i][4] = j.getMatkul().getKdMk();
                Data[i][5] = j.getKelas().getKdKelas();
                Data[i][6] = j.getRuang().getKdRuang();
                i++;
            }
            gui.getTableViewalljadwal().setModel(new DefaultTableModel(Data, title));
            odj.emptyTemp();
        } else if (source.equals(gui.getBtnrefjadwal1hari())) {
            odj.loadData();
            String Data[][] = new String[odj.getDataJadwal().size()][7];
            int i = 0;
            String[] title = {"kode Jadwal", "Tanggal", "Shift", "Kode Dosen", "Kode MK", "Kode Kelas", "Kode Ruang"};
            for (Jadwal j : odj.getDataJadwal()) {
                if (j.getCal().equals(gui.getJspinnerviewjadwal1hari().getValue())) {
                    Data[i][0] = "" + j.getKdJadwal();
                    Data[i][1] = formatter.format(j.getCal());
                    Data[i][2] = "" + shifttoString(j.getShift());
                    Data[i][3] = j.getDosen().getKdDosen();
                    Data[i][4] = j.getMatkul().getKdMk();
                    Data[i][5] = j.getKelas().getKdKelas();
                    Data[i][6] = j.getRuang().getKdRuang();
                    i++;
                }
            }
            gui.getTableViewharijadwal().setModel(new DefaultTableModel(Data, title));
            odj.emptyTemp();
        } else if (source.equals(gui.getBtnrefalldosen())) {
            ods.loadData();
            String Data[][] = new String[ods.getDataDosen().size()][2];
            int i = 0;
            String[] title = {"kode Dosen", "Nama Dosen"};
            for (Dosen d : ods.getDataDosen()) {
                Data[i][0] = d.getKdDosen();
                Data[i][1] = d.getNama();
                i++;
            }
            gui.getTableViewDosen().setModel(new DefaultTableModel(Data, title));
            ods.emptyTemp();
        } else if (source.equals(gui.getBtnrefallkls())) {
            odk.loadData();
            String Data[][] = new String[odk.getDataKelas().size()][2];
            int i = 0;
            String[] title = {"kode kelas", "kapasitas kelas"};
            for (Kelas k : odk.getDataKelas()) {
                Data[i][0] = k.getKdKelas();
                Data[i][1] = "" + k.getnKapasitas();
                i++;
            }
            gui.getTableViewKelas().setModel(new DefaultTableModel(Data, title));
            odk.emptyTemp();
        } else if (source.equals(gui.getBtnrefallmk())) {
            odmk.loadData();
            String Data[][] = new String[odmk.getDataMk().size()][2];
            int i = 0;
            String[] title = {"kode MK", "Nama MK"};
            for (MataKuliah mk : odmk.getDataMk()) {
                Data[i][0] = mk.getKdMk();
                Data[i][1] = mk.getNama();
                i++;
            }
            gui.getTableviewMk().setModel(new DefaultTableModel(Data, title));
            odmk.emptyTemp();
        } else if (source.equals(gui.getBtnrefruang())) {
            odr.loadData();
            String Data[][] = new String[odr.getDataRuang().size()][2];
            int i = 0;
            String[] title = {"kode Ruang", "Nama Ruang"};
            for (RuangKelas r : odr.getDataRuang()) {
                Data[i][0] = r.getKdRuang();
                Data[i][1] = "" + r.getnKapasitas();
                i++;
            }
            gui.getTableViewRuang().setModel(new DefaultTableModel(Data, title));
            odr.emptyTemp();
        }
    }

    /**
     * menyimpan komponen panel kedalam arraylist
     */
    public void simpen() {
        arycomp.add(gui.getPanelMenu());
        arycomp.add(gui.getPanelmenuawal());
        arycomp.add(gui.getPanelInputJadwal());
        arycomp.add(gui.getPanelview1hari());
        arycomp.add(gui.getPanelViewJadwalbulan());
        arycomp.add(gui.getPanelviewJadwalAll());
        arycomp.add(gui.getPanelViewDosen());
        arycomp.add(gui.getPanelOlahjadwal());
        arycomp.add(gui.getPanelOlahDosen());
        arycomp.add(gui.getPanelViewKelas());
        arycomp.add(gui.getPanelOlahKelas());
        arycomp.add(gui.getPanelViewMK());
        arycomp.add(gui.getPanelOlahMk());
        arycomp.add(gui.getPanelViewRuang());
        arycomp.add(gui.getPanelOlahRuang());
    }

    /**
     * method untuk memindahkan antar screen/panel(sebenarnya ga pindah sih cuma
     * di setvisible :v)
     *
     * @param panel parameter panel yang akan ditampilkan/atau panel
     * tujuan/panel yg di setvisible(true)
     */
    public void panelChange(JPanel panel) {
        for (JPanel c : arycomp) {
            if (c.equals(panel)) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }

    public void setjpanemessage(String message) {
        gui.getJpane().showMessageDialog(framejoptpane, message, "warning", WARNING_MESSAGE);
    }

    /**
     * "menu awal" action performed dari tombol olah data
     */
    public void apOlahDataclicked() {
        panelChange(gui.getPanelmenuawal());
    }

    /**
     * "menu awal" action performed dari tombol olah jadwal
     */
    public void apOlahJadwalClicked() {
        panelChange(gui.getPanelOlahjadwal());
    }

    /**
     * action performed dari tombol olah Dosen
     */
    public void apOlahDosenClicked() {
        panelChange(gui.getPanelOlahDosen());
    }

    /**
     * action performed dari tombol olah MK
     */
    public void apOlahMKClicked() {
        panelChange(gui.getPanelOlahMk());
    }

    /**
     * action performed dari tombol olah Kelas
     */
    public void apOlahKelasClicked() {
        panelChange(gui.getPanelOlahKelas());
    }

    /**
     * action performed dari tombol olah Ruang
     */
    public void apOlahRuangClicked() {
        panelChange(gui.getPanelOlahRuang());
    }

    /**
     * action performed kembali ke(Menu)tampilan paling awal
     */
    public void apKembalitoMenubuttonclicked() {
        panelChange(gui.getPanelMenu());
    }

    /**
     * action performed kembali ke(MenuAwal) tampilan dari OlahData
     */
    public void apKembalitoMenuAwalbtnClicked() {
        panelChange(gui.getPanelmenuawal());
    }

    /**
     * action performed dari tombol save dosen dimana akan mengecek dari field
     * kode dosen, jika dosen tsbt sudah ada di db makan akan keluar joptionpane
     * peringatan jika belum maka dosen tsbt akan ditambahkan ke db
     */
    public void apsaveDosenClicked() {
        ods.loadData();
        Dosen x = ods.cariDosen(gui.getFieldkdosen().getText());
        if (x == null) {
            Dosen d = new Dosen(gui.getFieldnamadosen().getText(), gui.getFieldkdosen().getText());
            ods.add(d);
            setjpanemessage("dosen berhasil diinput");
        } else {
            setjpanemessage("dosen udah ada");
            gui.getFieldnamadosen().setText("");
            gui.getFieldkdosen().setText("");
        }
        ods.emptyTemp();
    }

    /**
     * action performed dari tombol hapus dimana akan mengecek dari field kode
     * dosen, jika dosen tsbt sudah ada db makan akan keluar joptionpane
     * peringatan jika belum maka dosen tsbt akan ditambahkan ke db
     */
    public void aphapusDosenClicked() {
        ods.loadData();
        Dosen x = ods.cariDosen(gui.getFieldkdosen().getText());
        if (x == null) {
            setjpanemessage("dosen ga ada");
            gui.getFieldnamadosen().setText("");
            gui.getFieldkdosen().setText("");
        } else {
            ods.remove(x);
            setjpanemessage("Dosen telah dihapus");
        }
        ods.emptyTemp();
    }

    /**
     * action performed dari tombol view dimana akanmengarahkan ke layar view
     * all dosen
     */
    public void apViewDosenClicked() {
        panelChange(gui.getPanelViewDosen());
    }

    /**
     * action performed dari tombol save
     */
    public void apSaveMKClicked() {
        odmk.loadData();
        MataKuliah x = odmk.cariMK(gui.getFieldkdMk().getText());
        if (x == null) {
            MataKuliah mk = new MataKuliah(gui.getFieldnamaMk().getText(), gui.getFieldkdMk().getText());
            odmk.add(mk);
            setjpanemessage("Mata kuliah telah diinput");
        } else {
            setjpanemessage("Mata kuliah udah ada");
            gui.getFieldnamaMk().setText("");
            gui.getFieldkdMk().setText("");
        }
        odmk.emptyTemp();
    }

    /**
     * action performed dari tombol hapus
     */
    public void apHapusMKClicked() {
        odmk.loadData();
        MataKuliah x = odmk.cariMK(gui.getFieldkdMk().getText());
        if (x == null) {
            setjpanemessage("Mata kuliah ga ada");
            gui.getFieldnamaMk().setText("");
            gui.getFieldkdMk().setText("");
        } else {
            odmk.remove(x);
            setjpanemessage("Mata kuliah telah dihapus");
        }
        odmk.emptyTemp();
    }

    /**
     * action performed dari tombol view
     */
    public void apViewMKClicked() {
        panelChange(gui.getPanelViewMK());
    }
/**
 * action performed dari tombol save
 */
    public void apSaveKelasClicked() {
        odk.loadData();
        Kelas x = odk.cariKelas(gui.getFieldkdKls().getText());
        if (x == null) {
            Kelas k = new Kelas(gui.getFieldkdKls().getText(), Integer.parseInt(gui.getFieldKapKelas().getText()));
            odk.add(k);
            setjpanemessage("Kelas berhasil diinput");
        } else {
            setjpanemessage("Kelas udah ada");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        }
        odk.emptyTemp();
    }
/**
 * action performed dari tombol hapus
 */
    public void apHapusKelasClicked() {
        odk.loadData();
        Kelas x = odk.cariKelas(gui.getFieldkdKls().getText());
        if (x == null) {
            setjpanemessage("Kelas ga ada");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        } else {
            odk.remove(x);
            setjpanemessage("Kelas telah dihapus");
        }
        odmk.emptyTemp();
    }
/**
 * action performed dari tombol view
 */
    public void apViewKelasClicked() {
        panelChange(gui.getPanelViewKelas());
    }
/**
     * action performed dari tombol save
     */
    public void apSaveRuangClicked() {
        odr.loadData();
        RuangKelas x = odr.cariRuang(gui.getFieldkdRuang().getText());
        if (x == null) {
            RuangKelas r = new RuangKelas(gui.getFieldkdRuang().getText(), Integer.parseInt(gui.getFieldKapRuang().getText()));
            odr.add(r);
            setjpanemessage("Ruangan berhasil diinput");
        } else {
            setjpanemessage("Ruang udah ada");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        }
        odr.emptyTemp();
    }

    public void apHapusRuangClicked() {
        odr.loadData();
        RuangKelas x = odr.cariRuang(gui.getFieldkdRuang().getText());
        if (x == null) {
            setjpanemessage("Ruang ga ada");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        } else {
            odr.remove(x);
            setjpanemessage("Ruang berhasil dihapus");
        }
        odr.emptyTemp();
    }

    public void apViewRuangClicked() {
        panelChange(gui.getPanelViewRuang());
    }

    public void apInputJadwalClicked() {
        panelChange(gui.getPanelInputJadwal());
    }

    public void loadall() {
        odk.loadData();
        ods.loadData();
        odmk.loadData();
        odr.loadData();
    }

    public void emptytempall() {
        odk.emptyTemp();
        ods.emptyTemp();
        odmk.emptyTemp();
        odr.emptyTemp();
    }
/**
     * action performed dari tombol save
     */
    public void apSaveJadwalClicked() {
        odj.loadData();

        try {
            Jadwal x = odj.cariJadwal((formatter.format(gui.getJspinnertgl().getValue())), gui.getCboxShift(), gui.getFieldJadwalKddosen().getText(),
                    gui.getFieldJadwalKdKls().getText(), gui.getFieldJadwalKdRuang().getText());

            if (gui.getCboxShift() < 1 || gui.getCboxShift() > 6) {
                setjpanemessage("maaf tidak ada shift diluar ini");
            } else if (odj.cekConstraintTanggal((formatter.format(gui.getJspinnertgl().getValue())))) {
                setjpanemessage("maaf tidak bisa menginputkan diluar tanggal sekarang");

            } else if (gui.getFieldJadwalKdKls().getText().equals("") || gui.getFieldJadwalKdKls().getText() == null
                    || gui.getFieldJadwalKdMk().getText().equals("") || gui.getFieldJadwalKdMk().getText() == null
                    || gui.getFieldJadwalKdKls().getText().equals("") || gui.getFieldJadwalKdKls().getText() == null
                    || gui.getFieldJadwalKdRuang().getText().equals("") || gui.getFieldJadwalKdRuang().getText() == null) {
                setjpanemessage("ada field yang kosong");
            } else if (x == null) {
                loadall();
                Kelas kx = odk.cariKelas(gui.getFieldJadwalKdKls().getText());
                MataKuliah mkx = odmk.cariMK(gui.getFieldJadwalKdMk().getText());
                Dosen dx = ods.cariDosen(gui.getFieldJadwalKddosen().getText());
                RuangKelas rkx = odr.cariRuang(gui.getFieldJadwalKdRuang().getText());
                if (kx == null) {
                    setjpanemessage("Kelas tsbt tidak ada didatabase kelas");
                } else if (mkx == null) {
                    setjpanemessage("Matakuliah tidak ada didatabase mk");
                } else if (dx == null) {
                    setjpanemessage("Dosen tidak ada didatabase dosej");
                } else if (rkx == null) {
                    setjpanemessage("Ruang tidak ada di database ruang");
                } else {

                    Jadwal j = new Jadwal(new Kelas(gui.getFieldJadwalKdKls().getText(), 0),
                            new MataKuliah("", gui.getFieldJadwalKdMk().getText()),
                            new Dosen("", gui.getFieldJadwalKddosen().getText()),
                            new RuangKelas(gui.getFieldJadwalKdRuang().getText(), 0),
                            formatter.format(gui.getJspinnertgl().getValue()), gui.getCboxShift());

                    odj.add(j);
                    setjpanemessage("jadwal berhasil diinput");
                }
                emptytempall();
            } else {

                setjpanemessage("maaf ada jadwal yang bentrok");
            }
        } catch (ParseException ex) {
            setjpanemessage("format tanggal salah");
            ex.printStackTrace();
        }
        odj.emptyTemp();
    }
/**
 * method merubah tampilah shift pada gui menjadi string
 * @param shift
 * parameter shift bertype angka
 * @return 
 * mengembalikan String interval waktu shift
 */
    public String shifttoString(int shift) {
        Jadwal j;
        String s = null;
        if (shift == 1) {
            s = "06.30-08.10";
        } else if (shift == 2) {
            s = "08.30-10.10";
        } else if (shift == 3) {
            s = "10.30-12.10";
        } else if (shift == 4) {
            s = "12.30-14.10";
        } else if (shift == 5) {
            s = "14.30-16.10";
        } else if (shift == 6) {
            s = "16.30-18.10";
        }
        return s;
    }
/**
 * getter combobox yang dipilih
 * @return 
 */
    public int comboboxbulan() {
        return gui.getCboxviewjadwalbulan().getSelectedIndex();
    }
/**
 * action performed kembali ke menu awal
 */
    public void apbacktomenujadwal() {
        panelChange(gui.getPanelOlahjadwal());
    }
/**
 * action performed tombol view jadwal 1 bulan
 */
    public void apviewJadwal1bulan() {
        panelChange(gui.getPanelViewJadwalbulan());

    }
/**
 * action performed tombol view jadwal 1 hari
 */
    public void apviewJadwal1hari() {
        panelChange(gui.getPanelview1hari());
    }

    public void apviewJadwalAll() {
        panelChange(gui.getPanelviewJadwalAll());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
/**
 * action/event ketika mouse dipencet
 * @param e 
 * parameter berupa event
 */
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getBtnExit())) {
            gui.getBtnExit().setIcon(iconbtnexitclicked);
        } else if (source.equals(gui.getBtnOlahData())) {
            gui.getBtnOlahData().setIcon(iconbtnOlahDataclicked);
        } else if (source.equals(gui.getBtnOlahJadwal())) {
            gui.getBtnOlahJadwal().setIcon(iconbtnOlahJadwalclicked);
        } else if (source.equals(gui.getBtnDosen())) {
            gui.getBtnDosen().setIcon(iconbtnOlahDosenclicked);
        } else if (source.equals(gui.getBtnMk())) {
            gui.getBtnMk().setIcon(iconbtnOlahMkclicked);
        } else if (source.equals(gui.getBtnKls())) {
            gui.getBtnKls().setIcon(iconbtnOlahKelasclicked);
        } else if (source.equals(gui.getBtnRuang())) {
            gui.getBtnRuang().setIcon(iconbtnOlahRuangclicked);
        } else if (source.equals(gui.getBtnBack())) {
            gui.getBtnBack().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnsavedosen())) {
            gui.getBtnsavedosen().setIcon(iconbtnSaveclicked);
        } else if (source.equals(gui.getBtnsaveMk())) {
            gui.getBtnsaveMk().setIcon(iconbtnSaveclicked);
        } else if (source.equals(gui.getBtntmbhkelas())) {
            gui.getBtntmbhkelas().setIcon(iconbtnSaveclicked);
        } else if (source.equals(gui.getBtnsaveruang())) {
            gui.getBtnsaveruang().setIcon(iconbtnSaveclicked);
        } else if (source.equals(gui.getBtnhpsdosen())) {
            gui.getBtnhpsdosen().setIcon(iconbtnHapusclicked);
        } else if (source.equals(gui.getBtnhpsmk())) {
            gui.getBtnhpsmk().setIcon(iconbtnHapusclicked);
        } else if (source.equals(gui.getBtnHapuskls())) {
            gui.getBtnHapuskls().setIcon(iconbtnHapusclicked);
        } else if (source.equals(gui.getBtnHapusruang())) {
            gui.getBtnHapusruang().setIcon(iconbtnHapusclicked);
        } else if (source.equals(gui.getBtnviewdosen())) {
            gui.getBtnviewdosen().setIcon(iconbtnViewOlahDataclicked);
        } else if (source.equals(gui.getBtnviewMk())) {
            gui.getBtnviewMk().setIcon(iconbtnViewOlahDataclicked);
        } else if (source.equals(gui.getBtnviewkelas())) {
            gui.getBtnviewkelas().setIcon(iconbtnViewOlahDataclicked);
        } else if (source.equals(gui.getBtnviewRuang())) {
            gui.getBtnviewRuang().setIcon(iconbtnViewOlahDataclicked);
        } else if (source.equals(gui.getBtncanceldosen())) {
            gui.getBtncanceldosen().setIcon(iconbtnCancelclicked);
        } else if (source.equals(gui.getBtnCancelmk())) {
            gui.getBtnCancelmk().setIcon(iconbtnCancelclicked);
        } else if (source.equals(gui.getBtnCancelkelas())) {
            gui.getBtnCancelkelas().setIcon(iconbtnCancelclicked);
        } else if (source.equals(gui.getBtncancelruang())) {
            gui.getBtncancelruang().setIcon(iconbtnCancelclicked);
        } else if (source.equals(gui.getBtnOlahJadwal())) {
            gui.getBtnOlahJadwal().setIcon(iconbtnOlahJadwalclicked);
        } else if (source.equals(gui.getBtnInputjadwal())) {
            gui.getBtnInputjadwal().setIcon(iconbtnInputJadwalclicked);
        } else if (source.equals(gui.getBtnviewJadwal1bln())) {
            gui.getBtnviewJadwal1bln().setIcon(iconbtnView1bulanJadwalClicked);
        } else if (source.equals(gui.getBtnViewJadwalSemua())) {
            gui.getBtnViewJadwalSemua().setIcon(iconbtnViewAllJadwalClicked);
        } else if (source.equals(gui.getBtnviewHari())) {
            gui.getBtnviewHari().setIcon(iconbtnViewAllJadwal1hariClicked);
        } else if (source.equals(gui.getKembaliviewall1bulan())) {
            gui.getKembaliviewall1bulan().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnsavejadwal())) {
            gui.getBtnsavejadwal().setIcon(iconbtnSaveclicked);
        } else if (source.equals(gui.getKembaliviewall1hari())) {
            gui.getKembaliviewall1hari().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getKembaliviewalljdwal())) {
            gui.getKembaliviewalljdwal().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getKembaliviewalldosen())) {
            gui.getKembaliviewalldosen().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnBacKOlahjadwal())) {
            gui.getBtnBacKOlahjadwal().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnbackviewAllDosen())) {
            gui.getBtnbackviewAllDosen().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnbackviewAllKelas())) {
            gui.getBtnbackviewAllKelas().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnbackviewAllMk())) {
            gui.getBtnbackviewAllMk().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtnbackviewAllRuang())) {
            gui.getBtnbackviewAllRuang().setIcon(iconbtnBackOlahDataclicked);
        } else if (source.equals(gui.getBtncanceljadwal())) {
            gui.getBtncanceljadwal().setIcon(iconbtnCancelclicked);
        }
    }
/**
 * action/event ketika mouse dilepaskan setelah dipencet
 * @param e 
 * parameter event
 */
    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getBtnExit())) {
            System.exit(0);
            gui.getBtnExit().setIcon(iconbtnexit);
        }
        if (source.equals(gui.getBtnOlahData())) {
            apOlahDataclicked();
            gui.getBtnOlahData().setIcon(iconbtnOlahData);
        } else if (source.equals(gui.getBtnOlahJadwal())) {
            apOlahJadwalClicked();
            gui.getBtnOlahJadwal().setIcon(iconbtnOlahJadwal);
        } else if (source.equals(gui.getBtnDosen())) {
            apOlahDosenClicked();
            gui.getBtnDosen().setIcon(iconbtnOlahDosen);
        } else if (source.equals(gui.getBtnMk())) {
            apOlahMKClicked();
            gui.getBtnMk().setIcon(iconbtnOlahMk);
        } else if (source.equals(gui.getBtnKls())) {
            apOlahKelasClicked();
            gui.getBtnKls().setIcon(iconbtnOlahKelas);
        } else if (source.equals(gui.getBtnRuang())) {
            apOlahRuangClicked();
            gui.getBtnRuang().setIcon(iconbtnOlahRuang);
        } else if (source.equals(gui.getBtnBack())) {
            apKembalitoMenubuttonclicked();
            gui.getBtnBack().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnsavedosen())) {
            apsaveDosenClicked();
            gui.getBtnsavedosen().setIcon(iconbtnSave);
        } else if (source.equals(gui.getBtnhpsdosen())) {
            aphapusDosenClicked();
            gui.getBtnhpsdosen().setIcon(iconbtnHapus);
        } else if (source.equals(gui.getBtnviewdosen())) {
            apViewDosenClicked();
            gui.getBtnviewdosen().setIcon(iconbtnViewOlahData);
        } else if (source.equals(gui.getBtncanceldosen())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtncanceldosen().setIcon(iconbtnCancel);
        } else if (source.equals(gui.getBtnsaveMk())) {
            apSaveMKClicked();
            gui.getBtnsaveMk().setIcon(iconbtnSave);
        } else if (source.equals(gui.getBtnhpsmk())) {
            apHapusMKClicked();
            gui.getBtnhpsmk().setIcon(iconbtnHapus);
        } else if (source.equals(gui.getBtnviewMk())) {
            apViewMKClicked();
            gui.getBtnviewMk().setIcon(iconbtnViewOlahData);
        } else if (source.equals(gui.getBtnCancelmk())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnCancelmk().setIcon(iconbtnCancel);
        } else if (source.equals(gui.getBtntmbhkelas())) {
            apSaveKelasClicked();
            gui.getBtntmbhkelas().setIcon(iconbtnSave);
        } else if (source.equals(gui.getBtnHapuskls())) {
            apHapusKelasClicked();
            gui.getBtnHapuskls().setIcon(iconbtnHapus);
        } else if (source.equals(gui.getBtnviewkelas())) {
            apViewKelasClicked();
            gui.getBtnviewkelas().setIcon(iconbtnViewOlahData);
        } else if (source.equals(gui.getBtnCancelkelas())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnCancelmk().setIcon(iconbtnCancel);
        } else if (source.equals(gui.getBtnsaveruang())) {
            apSaveRuangClicked();
            gui.getBtnsaveruang().setIcon(iconbtnSave);
        } else if (source.equals(gui.getBtnHapusruang())) {
            apHapusRuangClicked();
            gui.getBtnHapusruang().setIcon(iconbtnHapus);
        } else if (source.equals(gui.getBtnviewRuang())) {
            apViewRuangClicked();
            gui.getBtnviewRuang().setIcon(iconbtnViewOlahData);
        } else if (source.equals(gui.getBtncancelruang())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtncancelruang().setIcon(iconbtnCancel);
        } else if (source.equals(gui.getBtnBacKOlahjadwal())) {
            apKembalitoMenubuttonclicked();
            gui.getBtnBacKOlahjadwal().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnOlahJadwal())) {
            apOlahJadwalClicked();
            gui.getBtnOlahJadwal().setIcon(iconbtnOlahJadwal);
        } else if (source.equals(gui.getBtnInputjadwal())) {
            apInputJadwalClicked();
            gui.getBtnInputjadwal().setIcon(iconbtnInputJadwal);
        } else if (source.equals(gui.getBtnviewJadwal1bln())) {
            apviewJadwal1bulan();
            gui.getBtnviewJadwal1bln().setIcon(iconbtnView1bulanJadwal);
        } else if (source.equals(gui.getBtnViewJadwalSemua())) {
            apviewJadwalAll();
            gui.getBtnViewJadwalSemua().setIcon(iconbtnViewAllJadwal);
        } else if (source.equals(gui.getBtnviewHari())) {
            apviewJadwal1hari();
            gui.getBtnviewHari().setIcon(iconbtnViewAllJadwal1hari);
        } else if (source.equals(gui.getBtnsavejadwal())) {
            apSaveJadwalClicked();
            gui.getBtnsavejadwal().setIcon(iconbtnSave);
        } else if (source.equals(gui.getKembaliviewall1bulan())) {
            apbacktomenujadwal();
            gui.getKembaliviewall1bulan().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getKembaliviewall1hari())) {
            apbacktomenujadwal();
            gui.getKembaliviewall1hari().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getKembaliviewalljdwal())) {
            apbacktomenujadwal();
            gui.getKembaliviewalljdwal().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnbackviewAllDosen())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnbackviewAllDosen().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnbackviewAllKelas())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnbackviewAllKelas().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnbackviewAllMk())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnbackviewAllMk().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtnbackviewAllRuang())) {
            apKembalitoMenuAwalbtnClicked();
            gui.getBtnbackviewAllRuang().setIcon(iconbtnBackOlahData);
        } else if (source.equals(gui.getBtncanceljadwal())) {
            apbacktomenujadwal();
            gui.getBtncanceljadwal().setIcon(iconbtnCancel);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
