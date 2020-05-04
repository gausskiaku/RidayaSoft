package Entity;

import Entity.Commander;
import Entity.Dette;
import Entity.Emprunter;
import Entity.Facture;
import Entity.Remboursement;
import Entity.Remettre;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, String> prenomClient;
    public static volatile ListAttribute<Client, Dette> detteList;
    public static volatile ListAttribute<Client, Remboursement> remboursementList;
    public static volatile ListAttribute<Client, Emprunter> emprunterList;
    public static volatile ListAttribute<Client, Commander> commanderList;
    public static volatile ListAttribute<Client, Facture> factureList;
    public static volatile SingularAttribute<Client, String> nomClient;
    public static volatile ListAttribute<Client, Remettre> remettreList;

}