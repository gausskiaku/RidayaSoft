/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Depense;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class DepenseMetier {

    public List allDepense(EntityManager em) {
        Query qr = em.createNamedQuery("Depense.findAll");
        List<Depense> listDepense = qr.getResultList();
        return listDepense;
    }

    public List depenseDate(EntityManager em, Date dateDepense) {
        Query qr = em.createNamedQuery("Depense.findByDateDepense");
        qr.setParameter("dateDepense", new Date("2016-10-11"));
        List<Depense> listDepense = qr.getResultList();
        return listDepense;
    }

    public List reportJournalier(EntityManager em, String date) {
        String sql = "SELECT facture.idFacture, client.nomClient, COALESCE(SUM(commander.prixVenteCommander * commander.quantiteCommander), 0) AS Montant, COALESCE(facture.dateFacture, NOW()), (coalesce((SELECT SUM(depense.montant) FROM depense WHERE dateDepense LIKE '" + date + "%'),0)) AS montantDepense\n"
                + "FROM facture\n"
                + "INNER JOIN client ON facture.idClient = client.idClient\n"
                + "INNER JOIN commander ON commander.idClient = client.idClient\n"
                + "INNER JOIN produit ON produit.idProduit = commander.idProduit\n"
                + "WHERE facture.dateFacture LIKE '" + date + "%'";
        Query qr = em.createNativeQuery(sql);
        List list = qr.getResultList();
        return list;

    }

    public List reportMensuel(EntityManager em, String date) {
        String sql = "SELECT facture.idFacture, client.nomClient, SUM( commander.prixVenteCommander * commander.quantiteCommander ) AS Montant, facture.dateFacture, (\n"
                + "coalesce( (\n"
                + "\n"
                + "SELECT SUM( depense.montant )\n"
                + "FROM depense\n"
                + "WHERE MONTH( dateDepense ) = MONTH( '"+date+"' ) ) , 0\n"
                + ")\n"
                + ") AS montantDepense\n"
                + "FROM facture\n"
                + "INNER JOIN client ON facture.idClient = client.idClient\n"
                + "INNER JOIN commander ON commander.idClient = client.idClient\n"
                + "INNER JOIN produit ON produit.idProduit = commander.idProduit\n"
                + "WHERE MONTH( facture.dateFacture ) = MONTH( '"+date+"' ) ";
        Query qr = em.createNativeQuery(sql);
        List list = qr.getResultList();
        return list;
    }
}
