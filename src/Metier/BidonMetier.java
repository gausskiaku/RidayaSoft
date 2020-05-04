/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Bidon;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class BidonMetier {
    
    public Bidon bidonParTypeBidon(EntityManager em, String typeBidon){
    Query qrBidon = em.createNamedQuery("Bidon.findByTypeBidon");
        qrBidon.setParameter("typeBidon", typeBidon);
        List<Bidon> listBidon = qrBidon.getResultList();
        Bidon lastBidon = listBidon.get(listBidon.size() - 1); // Last Id
        return lastBidon;
    }
    
    public Object bidonParClientLorsDuRemise(EntityManager em, String nomClient, String typeBidon){
    Query qrBidon = em.createNativeQuery("SELECT *, coalesce(quantiteEmprunter - SUM(Coalesce(quantiteRemettre, 0))) as qtReste "
            + "FROM Emprunter LEFT JOIN Remettre ON emprunter.idClient = remettre.idClient AND emprunter.idBidon = remettre.idBidon "
            + "INNER JOIN Client ON emprunter.idClient = client.idClient "
            + "INNER JOIN Bidon ON emprunter.idBidon = bidon.idBidon "
            + "GROUP BY emprunter.dateEmprunter "
            + "HAVING quantiteEmprunter > SUM(coalesce(quantiteRemettre, 0)) "
            + "AND client.nomClient = '"+nomClient+"' "
            + "AND typeBidon = '"+typeBidon+"'");
    
        List listBidon = qrBidon.getResultList();
    Object lastBidon = listBidon.get(listBidon.size() - 1); // Last Id
        return lastBidon;
    }
    
    public List bidonEmprunter(EntityManager em){
    Query qrBidon = em.createNativeQuery("SELECT * FROM Emprunter INNER JOIN Client ON Emprunter.idClient = Client.idClient INNER JOIN Bidon ON emprunter.idBidon = Bidon.idBidon");
    
        List listBidon = qrBidon.getResultList();
        return listBidon;
    }
    
     public List bidonRemettre(EntityManager em){
    Query qrBidon = em.createNativeQuery("SELECT * FROM Remettre INNER JOIN Client ON Remettre.idClient = Client.idClient INNER JOIN Bidon ON Remettre.idBidon = Bidon.idBidon");
    
        List listBidon = qrBidon.getResultList();
        return listBidon;
    }
}
