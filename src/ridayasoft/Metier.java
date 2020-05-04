/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridayasoft;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gauss
 */
public class Metier {

//    public EntityManager em() {
//        EntityManagerFactory emf;
//        EntityManager em;
//        try {
//            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
//            em = emf.createEntityManager();
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//            return null;
//        }
//        return em;
//    }
    public void supTab(DefaultTableModel model){
if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }

    public boolean isNumeric(char carac) {
        try {
            Integer.parseInt(String.valueOf(carac));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String dateCourante() {
        Date aujourdhui = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String date = formater.format(aujourdhui);
        return date;
    }
}
