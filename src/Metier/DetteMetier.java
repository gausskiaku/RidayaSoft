/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class DetteMetier {

    public List clientInsovable(EntityManager em) {
        // Pour Etat de stock
        String sqlSolde = "SELECT ( coalesce( ("
                + "SELECT SUM(dette.montantDette) FROM dette "
                + "WHERE dette.idClient = client.idClient ) , 0 ) "
                + "- coalesce( ( "
                + "SELECT SUM( remboursement.montantRemboursement )FROM Remboursement "
                + "WHERE remboursement.idClient = client.idClient ) , 0)) AS solde, client.nomClient, dette.devise, dette.dateDette "
                + "FROM Client "
                + "INNER JOIN dette ON client.idClient = dette.idClient "
                + "GROUP BY client.nomClient";
        Query qrSolde = em.createNativeQuery(sqlSolde);
        List listInsolvable = qrSolde.getResultList();
        return listInsolvable;
    }
    
//    SELECT * FROM Remboursement INNER JOIN Client ON remboursement.idClient = client.idClient
    
    
    public List historiquepaiement(EntityManager em) {
        // Pour Etat de stock
        String sqlSolde = "SELECT * FROM Remboursement "
                + "INNER JOIN Client "
                + "ON remboursement.idClient = client.idClient "
                + "ORDER BY client.nomClient, remboursement.dateRemboursement";
        Query qrSolde = em.createNativeQuery(sqlSolde);
        List listHistorique = qrSolde.getResultList();
        return listHistorique;
    }
    
     public List clientInsovableMontantparClient(EntityManager em, int id) {
        // Pour Etat de stock
        String sqlSolde = "SELECT ( coalesce( ("
                + "SELECT SUM(dette.montantDette) FROM dette "
                + "WHERE dette.idClient = client.idClient ) , 0 ) "
                + "- coalesce( ( "
                + "SELECT SUM( remboursement.montantRemboursement )FROM Remboursement "
                + "WHERE remboursement.idClient = client.idClient ) , 0)) AS solde, client.nomClient "
                + "FROM Client "
                + "WHERE client.idClient = " + id;
        Query qrSolde = em.createNativeQuery(sqlSolde);
        List listInsolvable = qrSolde.getResultList();
        return listInsolvable;
    }
     
     
//     public List detteCourante(EntityManager em, String date) {
//        String sqlVenteJour = "SELECT facture.idFacture, client.nomClient, SUM(commander.prixVenteCommander * commander.quantiteCommander) AS Montant, facture.dateFacture "
//                + "FROM facture "
//                + "INNER JOIN client ON facture.idClient = client.idClient "
//                + "INNER JOIN commander ON commander.idClient = client.idClient "
//                + "INNER JOIN produit ON produit.idProduit = commander.idProduit "
//                + "WHERE facture.dateFacture LIKE '" + date + "%'"
//                + "GROUP BY facture.idFacture, client.nomClient, facture.dateFacture";
//        Query qrVenteJour = em.createNativeQuery(sqlVenteJour);
//        List listVenteJour = qrVenteJour.getResultList();
//        return listVenteJour;
//    }

//    SELECT ( coalesce( ( 
//SELECT SUM( dette.montantDette) FROM dette
//WHERE dette.idClient = client.idClient ) , 0 ) 
//- coalesce( ( 
//SELECT SUM( clientdette.montantClientDette )FROM clientdette
//WHERE clientdette.idClient = client.idClient ) , 0)) AS solde, client.nomClient FROM Client
}
