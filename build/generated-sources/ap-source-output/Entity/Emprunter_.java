package Entity;

import Entity.Bidon;
import Entity.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Emprunter.class)
public class Emprunter_ { 

    public static volatile SingularAttribute<Emprunter, Date> dateEmprunter;
    public static volatile SingularAttribute<Emprunter, Integer> quantiteEmprunter;
    public static volatile SingularAttribute<Emprunter, Client> idClient;
    public static volatile SingularAttribute<Emprunter, Integer> idEmprunter;
    public static volatile SingularAttribute<Emprunter, Bidon> idBidon;

}