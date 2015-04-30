/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author R16
 */
public class NewClass {
    public static void main(String[] args) {
        JFrame jframe1 =  new javax.swing.JFrame();
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();

       Image img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\btn-bulat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
