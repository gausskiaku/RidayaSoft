/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridayasoft;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gauss
 */
public class RidayaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Looooooool");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
        EntityManager em = emf.createEntityManager();
        
        
        
    }
    
}
