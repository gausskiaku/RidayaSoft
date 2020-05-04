/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Famille;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class FamilleMetier {
    
    public List allFamille(EntityManager em){
    Query qr = em.createNamedQuery("Famille.findAll");
    List<Famille> listFamille = qr.getResultList();
    return listFamille;
    
    }
}
