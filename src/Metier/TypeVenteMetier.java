/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Typevente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class TypeVenteMetier {
    public List allTypeVenete(EntityManager em){
    Query qr = em.createNamedQuery("Typevente.findAll");
    List<Typevente> listTypeVente = qr.getResultList();
    return listTypeVente;
    
    }
}
