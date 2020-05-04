package Entity;

import Entity.Client;
import Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, User> idUser;
    public static volatile SingularAttribute<Facture, Client> idClient;
    public static volatile SingularAttribute<Facture, Date> dateFacture;
    public static volatile SingularAttribute<Facture, Integer> idFacture;
    public static volatile SingularAttribute<Facture, Double> remiseFacture;

}