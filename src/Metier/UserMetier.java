/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gauss
 */
public class UserMetier {
    
    public List allUser (EntityManager em){
    Query qr = em.createNamedQuery("User.findAll");
    List<User> listUser = qr.getResultList();
    
    return listUser;
    }
}
