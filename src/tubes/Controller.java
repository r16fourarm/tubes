/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author R16
 */
public class Controller extends MouseAdapter implements ActionListener, MouseListener {

    private guimenu gui;
    private OlahDataDosen ods;
    private OlahDataJadwal odj;
    private OlahDataKelas odk;
    private OlahDataMataKuliah odmk;
    private OlahDataRuang odr;
    private ArrayList<JPanel> arycomp = new ArrayList<>();
    private final ImageIcon iconbtnexit = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-cancel-clicked.png");
    private final ImageIcon iconbtnexitclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-keluar-clicked.png");
    private final ImageIcon iconbtnOlahData = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-olah-data.png");
    private final ImageIcon iconbtnOlahDataclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-olahdata-clicked.png");
    private final ImageIcon iconbtnOlahJadwal = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-oahjadwal.png");
    private final ImageIcon iconbtnOlahJadwalclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-jadwal-clicked.png");
    private final ImageIcon iconbtnOlahDosen = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-dosen.png");
    private final ImageIcon iconbtnOlahDosenclicked = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-dosen-clicked.png");
    private final ImageIcon iconbtnOlahMk = new ImageIcon("");
    private final ImageIcon iconbtnOlahMkclicked = new ImageIcon("");
    private final ImageIcon iconbtnOlahKelas = new ImageIcon("");
    private final ImageIcon iconbtnOlahKelasclicked = new ImageIcon("");
    private final ImageIcon iconbtnOlahRuang = new ImageIcon("");
    private final ImageIcon iconbtnOlahRuangclicked = new ImageIcon("");
    private final ImageIcon iconbtnBackOlahDataclicked = new ImageIcon("");

    public void setView(guimenu gui) {
        this.gui = gui;
        simpen();
    }

    public void setListener() {

        gui.addMouseListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        } else {
            gui.getJpane().setToolTipText("Dosen sudah terdaftar");
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
            gui.getJpane().setToolTipText("Dosen tidak terdaftar");
            gui.getFieldnamadosen().setText("");
            gui.getFieldkdosen().setText("");
        } else {
            ods.remove(x);
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

    public void apSaveMKClicked() {
        odmk.loadData();
        MataKuliah x = odmk.cariMK(gui.getFieldkdMk().getText());
        if (x == null) {
            MataKuliah mk = new MataKuliah(gui.getFieldnamaMk().getText(), gui.getFieldkdMk().getText());
            odmk.add(mk);
        } else {
            gui.getJpane().setToolTipText("Matakuliah sudah terdaftar");
            gui.getFieldnamaMk().setText("");
            gui.getFieldkdMk().setText("");
        }
        odmk.emptyTemp();
    }

    public void apHapusMKClicked() {
        odmk.loadData();
        MataKuliah x = odmk.cariMK(gui.getFieldkdMk().getText());
        if (x == null) {
            gui.getJpane().setToolTipText("Mata kuliah tidak ditemukan");
            gui.getFieldnamaMk().setText("");
            gui.getFieldkdMk().setText("");
        } else {
            odmk.remove(x);
        }
        odmk.emptyTemp();
    }

    public void apViewMKClicked() {
        panelChange(gui.getPanelViewMK());
    }

    public void apSaveKelasClicked() {
        odk.loadData();
        Kelas x = odk.cariKelas(gui.getFieldkdKls().getText());
        if (x == null) {
            Kelas k = new Kelas(gui.getFieldkdKls().getText(), Integer.parseInt(gui.getFieldKapKelas().getText()));
            odk.add(k);
        } else {
            gui.getJpane().setToolTipText("Kelas sudah ada");
            gui.getJpane().setVisible(true);
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        }
        odk.emptyTemp();
    }

    public void apHapusKelasClicked() {
        odk.loadData();
        Kelas x = odk.cariKelas(gui.getFieldkdKls().getText());
        if (x == null) {
            gui.getJpane().setToolTipText("Kelas tidak ditemukan");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        } else {
            odk.remove(x);
        }
        odmk.emptyTemp();
    }

    public void apViewKelasClicked() {
        panelChange(gui.getPanelViewKelas());
    }
    public void apSaveRuangClicked(){
        odr.loadData();
        RuangKelas x = odr.cariRuang(gui.getFieldkdRuang().getText());
        if(x==null){
            RuangKelas r = new RuangKelas(gui.getFieldkdRuang().getText(), Integer.parseInt(gui.getFieldKapRuang().getText()));
            odr.add(r);
        }else{
            gui.getJpane().setToolTipText("Kelas tidak ditemukan");
            gui.getFieldkdKls().setText("");
            gui.getFieldKapKelas().setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

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
        } else if (source.equals(gui.getBtnKls())) {
        } else if (source.equals(gui.getBtnRuang())) {
        }
    }

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
        } else if (source.equals(gui.getBtnKls())) {
        } else if (source.equals(gui.getBtnRuang())) {
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
