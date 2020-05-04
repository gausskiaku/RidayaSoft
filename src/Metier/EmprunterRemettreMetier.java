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
public class EmprunterRemettreMetier {
    
    public List clientConcernerParUneRemise(EntityManager em) {
        Query qrClient = em.createNativeQuery("SELECT * FROM Emprunter "
                + "LEFT JOIN remettre ON emprunter.idClient = remettre.idClient "
                + "INNER JOIN Client ON emprunter.idClient = client.idClient "
                + "WHERE emprunter.quantiteEmprunter > COALESCE(remettre.quantiteRemettre, 0)");

        List listClient = qrClient.getResultList();
//        Client lastClient = listClient.get(listClient.size() - 1); // Last Id
        return listClient;
    }
}
