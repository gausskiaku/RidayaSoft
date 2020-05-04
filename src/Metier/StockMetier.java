/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Facture;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class StockMetier {

    public List etatDeStockParProduit(EntityManager em, int idProduit) {
        // Pour Etat de stock
        String sqlSolde = "SELECT ( coalesce( ( "
                + "SELECT SUM( stock.quantite ) FROM stock "
                + "WHERE produit.idProduit = stock.idProduit ) , 0 ) "
                + "- coalesce( ( "
                + "SELECT SUM( commander.quantiteCommander )FROM commander "
                + "WHERE commander.idProduit = produit.idProduit ) , 0)) AS solde FROM produit "
                + "WHERE produit.idProduit =" + idProduit;
        Query qrSolde = em.createNativeQuery(sqlSolde);
        List listProduitSolde = qrSolde.getResultList();
        return listProduitSolde;
    }

    public List etatDeStockParBidon(EntityManager em, int idBidon) {
        // Pour Etat de stock
        String sqlSolde = "SELECT ("
                + "coalesce( (SELECT SUM( stock.quantite )"
                + "FROM stock "
                + "WHERE bidon.idBidon = stock.idBidon ) , 0 "
                + ") - coalesce( ( "
                + "SELECT SUM( emprunter.quantiteEmprunter ) "
                + "FROM Emprunter "
                + "WHERE emprunter.idBidon = Bidon.idBidon ) , 0 "
                + ") + coalesce( ( "
                + "SELECT SUM( remettre.quantiteRemettre ) "
                + "FROM Remettre "
                + "WHERE remettre.idBidon = Bidon.idBidon ) , 0 "
                + ") "
                + ") AS solde "
                + "FROM Bidon "
                + "WHERE bidon.idBidon =" + idBidon;
        Query qrSolde = em.createNativeQuery(sqlSolde);
        List listBidonSolde = qrSolde.getResultList();
        return listBidonSolde;
    }

    public List venteJournaliere(EntityManager em, String date) {
        String sqlVenteJour = "SELECT facture.idFacture, client.nomClient, SUM(commander.prixVenteCommander * commander.quantiteCommander) AS Montant, facture.dateFacture "
                + "FROM facture "
                + "INNER JOIN client ON facture.idClient = client.idClient "
                + "INNER JOIN commander ON commander.idClient = client.idClient "
                + "INNER JOIN produit ON produit.idProduit = commander.idProduit "
                + "WHERE facture.dateFacture LIKE '" + date + "%'"
                + "GROUP BY facture.idFacture, client.nomClient, facture.dateFacture";
        Query qrVenteJour = em.createNativeQuery(sqlVenteJour);
        List listVenteJour = qrVenteJour.getResultList();
        return listVenteJour;
    }

    public List stockActuel(EntityManager em) {
        String sql = "SELECT ( coalesce( ("
                + "SELECT SUM( stock.quantite ) "
                + "FROM stock "
                + "WHERE produit.idProduit = stock.idProduit ) , 0) - coalesce( ("
                + "SELECT SUM( commander.quantiteCommander ) "
                + "FROM commander "
                + "WHERE commander.idProduit = produit.idProduit ) , 0 ) ) AS solde, nomProduit, prixUnitaire, seuil, idProduit "
                + "FROM produit";
        Query qr = em.createNativeQuery(sql);
        List listStockActuel = qr.getResultList();
        return listStockActuel;
    }

    public List stockActuelBidon(EntityManager em) {
        String sql = "SELECT ("
                + "coalesce( (SELECT SUM( stock.quantite )"
                + "FROM stock "
                + "WHERE bidon.idBidon = stock.idBidon ) , 0 "
                + ") - coalesce( ( "
                + "SELECT SUM( emprunter.quantiteEmprunter ) "
                + "FROM Emprunter "
                + "WHERE emprunter.idBidon = Bidon.idBidon ) , 0 "
                + ") + coalesce( ( "
                + "SELECT SUM( remettre.quantiteRemettre ) "
                + "FROM Remettre "
                + "WHERE remettre.idBidon = Bidon.idBidon ) , 0 "
                + ") "
                + ") AS solde, idBidon, typeBidon "
                + "FROM Bidon";
        Query qr = em.createNativeQuery(sql);
        List listStockActuel = qr.getResultList();
        return listStockActuel;
    }

    public List stockPrecedent(EntityManager em, String date) {
        String sql = "SELECT ( coalesce( ( "
                + "SELECT SUM( stock.quantite ) "
                + "FROM stock "
                + "WHERE produit.idProduit = stock.idProduit "
                + "AND stock.dateStock LIKE '"+date+"%' ) , 0) - coalesce( ("
                + "SELECT SUM( commander.quantiteCommander ) "
                + "FROM commander "
                + "WHERE commander.idProduit = produit.idProduit "
                + "AND commander.dateCommander <= '" + date + "%' ) , 0 )) AS "
                + "solde, nomProduit, prixUnitaire, seuil, idProduit "
                + "FROM produit";

        Query qr = em.createNativeQuery(sql);
        List listStockPrecedent = qr.getResultList();
        return listStockPrecedent;
    }
    
    public List stockPrecedentBidon(EntityManager em, String date) {
        String sql = "SELECT ( coalesce( ( "
                + "SELECT SUM( stock.quantite ) "
                + "FROM stock "
                + "WHERE produit.idProduit = stock.idProduit ) , 0) - coalesce( ("
                + "SELECT SUM( commander.quantiteCommander ) "
                + "FROM commander "
                + "WHERE commander.idProduit = produit.idProduit "
                + "AND commander.dateCommander <= '" + date + "%' ) , 0 )) AS "
                + "solde, nomProduit, prixUnitaire, seuil, idProduit "
                + "FROM produit";

        Query qr = em.createNativeQuery(sql);
        List listStockPrecedent = qr.getResultList();
        return listStockPrecedent;
    }

    public List entreeStock(EntityManager em) {
        String sql = "SELECT produit.idProduit, produit.nomProduit, SUM(stock.quantite) as quantite,stock.prixAchat,stock.dateStock "
                + "FROM produit "
                + "INNER JOIN stock ON produit.idProduit=stock.idProduit "
                + "GROUP BY produit.idProduit,produit.nomProduit,stock.prixAchat, stock.dateStock "
                + "ORDER BY stock.dateStock";

        Query qr = em.createNativeQuery(sql);
        List listStock = qr.getResultList();
        return listStock;
    }

    public List entreeStockbyDate(EntityManager em, String date) {
        String sql = "SELECT produit.idProduit, produit.nomProduit, SUM( stock.quantite ) AS quantite, stock.prixAchat, stock.dateStock "
                + "FROM produit "
                + "INNER JOIN stock ON produit.idProduit = stock.idProduit "
                + "WHERE stock.dateStock LIKE '" + date + "%' "
                + "GROUP BY produit.idProduit, produit.nomProduit, stock.prixAchat, stock.dateStock "
                + "ORDER BY stock.dateStock";
        Query qr = em.createNativeQuery(sql);
        List listStockPrecedent = qr.getResultList();
        return listStockPrecedent;
    }

    public List sortieStock(EntityManager em) {

        String sql = "SELECT produit.idProduit, produit.nomProduit, SUM( commander.quantiteCommander ) AS quantite, commander.prixVenteCommander, facture.dateFacture\n"
                + "FROM produit\n"
                + "INNER JOIN commander ON produit.idProduit = commander.idProduit\n"
                + "INNER JOIN client ON client.idClient = commander.IdClient\n"
                + "INNER JOIN facture ON facture.idClient = client.idClient\n"
                + "GROUP BY produit.idProduit, produit.nomProduit, commander.prixVenteCommander, facture.dateFacture\n"
                + "ORDER BY facture.dateFacture";
        Query qr = em.createNativeQuery(sql);
        List list = qr.getResultList();
        return list;
    }

    public List sortieStockByDate(EntityManager em, String dateStart, String dateEnd) {

        String sql = "SELECT produit.idProduit, produit.nomProduit, SUM( commander.quantiteCommander ) AS quantite, commander.prixVenteCommander, facture.dateFacture\n"
                + "FROM produit\n"
                + "INNER JOIN commander ON produit.idProduit = commander.idProduit\n"
                + "INNER JOIN client ON client.idClient = commander.IdClient\n"
                + "INNER JOIN facture ON facture.idClient = client.idClient\n"
                + "WHERE facture.dateFacture BETWEEN '" + dateStart + " 00:00:00' AND '" + dateEnd + " 23:59:00'\n"
                + "GROUP BY produit.idProduit, produit.nomProduit, commander.prixVenteCommander, facture.dateFacture\n"
                + "ORDER BY facture.dateFacture";
        Query qr = em.createNativeQuery(sql);
        List list = qr.getResultList();
        return list;
    }

    public List stockMafia(EntityManager em, String date) {
        String sql = "SELECT produit.idProduit, produit.nomProduit, SUM( commander.quantiteCommander ) AS quantite, commander.prixVenteCommander, facture.dateFacture\n"
                + "FROM produit\n"
                + "INNER JOIN commander ON produit.idProduit = commander.idProduit\n"
                + "INNER JOIN client ON client.idClient = commander.IdClient\n"
                + "INNER JOIN facture ON facture.idClient = client.idClient\n"
                + "WHERE facture.dateFacture LIKE '" + date + "%'\n"
                + "GROUP BY produit.idProduit, produit.nomProduit, commander.prixVenteCommander, facture.dateFacture\n"
                + "ORDER BY facture.dateFacture\n"
                + "LIMIT 20";

        Query qr = em.createNativeQuery(sql);
        List list = qr.getResultList();
        return list;

    }

}
