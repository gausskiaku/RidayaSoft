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
public class ArticleMetier {

    public List getArticles(EntityManager em, String date, int id) {
        String sql = "SELECT *\n"
                + "FROM facture\n"
                + "INNER JOIN client ON facture.idClient = client.idClient\n"
                + "INNER JOIN commander ON client.idClient = commander.idClient\n"
                + "INNER JOIN produit ON commander.idProduit = produit.idProduit\n"
                + "WHERE commander.dateCommande LIKE '"+date+"%' AND facture.idFacture = "+id+"";
        Query qr = em.createNativeQuery(sql);
        List listArticle = qr.getResultList();
        return listArticle;
    }
}
