/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Facture;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class FactureMetier {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
    EntityManager em = emf.createEntityManager();
  
   

    public int idFacture(EntityManager em) {
        Query qrFacture = em.createNamedQuery("Facture.findAll");
        List<Facture> listFacture = qrFacture.getResultList();
        return listFacture.size() + 1;
    }

    
}
