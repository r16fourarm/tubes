/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
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
    private final ImageIcon iconbtnOlahDosen = new ImageIcon("");
    private final ImageIcon iconbtnOlahDosenclicked = new ImageIcon("");
    private final ImageIcon iconbtnOlahMk = new ImageIcon("");
    private final ImageIcon iconbtnOlahMkclicked = new ImageIcon("");
    private final ImageIcon iconbtnOlahKelas = new ImageIcon("");
    private final ImageIcon iconbtnOlahRuang = new ImageIcon("");

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
     * "menu awal" action performed dari tombol olah data
     */
    public void apOlahDataclicked() {
        for (JPanel c : arycomp) {
            if (c.equals(gui.getPanelmenuawal())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }

    /**
     * "menu awal" action performed dari tombol olah jadwal
     */
    public void apOlahJadwalClicked() {
        for (Component c : arycomp) {
            if (c.equals(gui.getPanelOlahjadwal())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }
/**
 *  action performed dari tombol olah Dosen
 */
    public void apOlahDosenClicked() {
        for (Component c : arycomp) {
            if (c.equals(gui.getPanelOlahDosen())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }
/**
 * action performed dari tombol olah MK
 */
    public void apOlahMKClicked() {
        for (Component c : arycomp) {
            if (c.equals(gui.getPanelOlahMk())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }
/**
 * action performed dari tombol olah Kelas
 */
    public void apOlahKelasClicked() {
    for (Component c : arycomp) {
            if (c.equals(gui.getPanelOlahKelas())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }
/**
 * action performed dari tombol olah Ruang
 */
    public void apOlahRuangClicked() {
        for (Component c : arycomp) {
            if (c.equals(gui.getPanelOlahRuang())) {
                c.setVisible(true);
            } else {
                c.setVisible(false);
            }
        }
    }

    public void apsaveDosenClicked() {
        ods.loadData();
        Dosen x = ods.cariDosen(gui.getFieldkdosen().getText());
        if(x==null){
            Dosen d = new Dosen(gui.getFieldnamadosen().getText(), gui.getFieldkdosen().getText());
            ods.add(d);
        }
        else{
            gui.getJpane().setToolTipText("Dosen sudah terdaftar");
            gui.getFieldnamadosen().setText("");
            gui.getFieldkdosen().setText("");
        }
    }
    public void aphapusDosenClicked(){
    
    }
    public void apViewDosenClicked(){}
    public void apBackDosenClicked(){}

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
        } else if(source.equals(gui.getBtnOlahJadwal())){
            gui.getBtnOlahJadwal().setIcon(iconbtnOlahJadwalclicked);
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
