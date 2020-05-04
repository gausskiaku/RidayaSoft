/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Produit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;

/**
 *
 * @author Gauss
 */
public class ProduitMetier {
    
    
    public Produit produitParNom(EntityManager em, String nomProduit){
    Query qrProduit = em.createNamedQuery("Produit.findByNomProduit");
        qrProduit.setParameter("nomProduit", nomProduit);
        List<Produit> listProduit = qrProduit.getResultList();
        Produit lastProduit = listProduit.get(listProduit.size() - 1); // Last Id
        return lastProduit;
    }
     
    public void cboProduit(EntityManager em, JComboBox cbProduit) {
        Query qrProduit = em.createNamedQuery("Produit.findAll");
        List<Produit> listProduit = qrProduit.getResultList();
        cbProduit.removeAllItems();
        for (Produit produit : listProduit) {
            cbProduit.addItem(produit.getNomProduit());
        }
        cbProduit.setSelectedIndex(-1);
    }
    
    public List allProduit(EntityManager em){
    Query qr = em.createNamedQuery("Produit.findAll");
    List<Produit> listProduit = qr.getResultList();
    return listProduit;
    }
}
