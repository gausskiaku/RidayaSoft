/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauss
 */
public class Fichier {

    File file = new File("D:\\Ridaya\\ridayaText.txt");
     File fileLogAccess = new File("D:\\Ridaya\\logAccessridayaText.txt");
    
    public String lireFichier() {
        String texte = "";
        try (FileInputStream fis = new FileInputStream(file)) {

            byte[] buf = new byte[8];
            while (fis.read(buf) != -1) {
                texte = texte + new String(buf);
            }
//            JOptionPane.showMessageDialog(null, texte);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouver ! \n" + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return texte;
    }

    public void ecrireFichier(String texte) {
        try {
            file.createNewFile();
             } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Creation fichier : " +ex.getMessage());
        }
            try (FileOutputStream fos = new FileOutputStream(file)) {
                
                byte[] datas = texte.getBytes();
                
                fos.write(datas);
                
            } catch (FileNotFoundException e) {
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException : " +ex.getMessage());
            }
       
    }
    
    
    
    public String lireFichierLogAccess() {
        String texte = "";
        try (FileInputStream fis = new FileInputStream(fileLogAccess)) {

            byte[] buf = new byte[8];
            while (fis.read(buf) != -1) {
                texte = texte + new String(buf);
            }
//            JOptionPane.showMessageDialog(null, texte);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouver ! \n" + e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return texte;
    }
    public void ecrireFichierLogAccess(String texte) {
        if (!fileLogAccess.exists()) {
            try {
                fileLogAccess.createNewFile();
            } catch (Exception e) {
            }
        }
           
            try (PrintWriter pw = new PrintWriter(new FileWriter(fileLogAccess, true))) {
                
              pw.println(texte);
                
            } catch (FileNotFoundException e) {
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "IOException : " +ex.getMessage());
            }
       
    }

}
