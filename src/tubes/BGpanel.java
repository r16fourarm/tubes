/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author R16
 */
public class BGpanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        ImageIcon imageicon  = new ImageIcon("C:\\Users\\R16\\Documents\\NetBeansProjects\\tubes\\src\\tubes\\gambar\\background.png"); 
        Image img = imageicon.getImage();
        super.paintComponent(g);
        if(img!=null){
            g.drawImage(img,0,0, this);
        }
    }
}
