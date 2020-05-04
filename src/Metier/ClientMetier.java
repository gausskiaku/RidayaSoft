/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauss
 */
public class ClientMetier {

    public void suppLastId(EntityManager em) {
        try {
            String sql = "SELECT *\n"
                    + "FROM client "
                    + "WHERE client.idClient = (\n"
                    + "SELECT MAX( idClient ) AS Id\n"
                    + "FROM client )";
            Query qr = em.createNativeQuery(sql);
            List lastClient = qr.getResultList();
            Object[] cl = (Object[]) lastClient.get(0);
//        JOptionPane.showMessageDialog(null, "Client : " + Integer.parseInt(cl[0].toString().trim())); 
            Client client = em.find(Client.class, Integer.parseInt(cl[0].toString().trim()));
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(client);
            transaction.commit();
//        JOptionPane.showMessageDialog(null, "Client supprimer"); 
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
    }

    public Client clientParNom(EntityManager em, String nomClient) {
        Query qrClient = em.createNamedQuery("Client.findByNomClient");
        qrClient.setParameter("nomClient", nomClient);
        List<Client> listClient = qrClient.getResultList();
        Client lastClient = listClient.get(listClient.size() - 1); // Last Id
        return lastClient;
    }
    

    public List clientConcernerParUneRemise(EntityManager em) {
        Query qrClient = em.createNativeQuery("SELECT *, coalesce(quantiteEmprunter - SUM(Coalesce(quantiteRemettre, 0))) as qtReste "
                + "FROM Emprunter LEFT JOIN Remettre ON emprunter.idClient = remettre.idClient AND emprunter.idBidon = remettre.idBidon "
                + "INNER JOIN Client ON emprunter.idClient = client.idClient "
                + "INNER JOIN Bidon ON emprunter.idBidon = bidon.idBidon "
                + "GROUP BY client.nomClient "
                + "HAVING quantiteEmprunter > SUM(coalesce(quantiteRemettre, 0))");

        List listClient = qrClient.getResultList();
        return listClient;
    }

    public List clientConcernerParUneRemiseParNom(EntityManager em, String nomClient) {
        Query qrClient = em.createNativeQuery("SELECT *, coalesce(quantiteEmprunter - SUM(Coalesce(quantiteRemettre, 0))) as qtReste "
                + "FROM Emprunter "
                + "LEFT JOIN Remettre ON emprunter.idClient = remettre.idClient AND emprunter.idBidon = remettre.idBidon "
                + "INNER JOIN Client ON emprunter.idClient = client.idClient "
                + "INNER JOIN Bidon ON emprunter.idBidon = bidon.idBidon "
                + "GROUP BY emprunter.dateEmprunter HAVING quantiteEmprunter > SUM(coalesce(quantiteRemettre, 0)) "
                + "AND client.nomClient = '"+nomClient+"'");

        List listClient = qrClient.getResultList();
//        Client lastClient = listClient.get(listClient.size() - 1); // Last Id
        return listClient;
    }
    
    public void cboClient(EntityManager em, JComboBox cbClient) {
        Query qrClient = em.createNamedQuery("Client.findAll");
        List<Client> listClient = qrClient.getResultList();
        cbClient.removeAllItems();
        for (Client client : listClient) {
            cbClient.addItem(client.getNomClient());
        }
        cbClient.setSelectedIndex(-1);
    }
    
    
}
