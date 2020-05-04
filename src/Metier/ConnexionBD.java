/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauss
 */
public class ConnexionBD {
    
     EntityManagerFactory emf;
    EntityManager em;
   public EntityManager getConnexion(){
 try {
            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
            em = emf.createEntityManager();
            return em;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Erreur de la connexion à la base de données");
            return null;
        }
}
}
