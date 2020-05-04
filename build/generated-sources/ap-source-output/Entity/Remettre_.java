package Entity;

import Entity.Bidon;
import Entity.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Remettre.class)
public class Remettre_ { 

    public static volatile SingularAttribute<Remettre, Date> dateRemettre;
    public static volatile SingularAttribute<Remettre, Client> idClient;
    public static volatile SingularAttribute<Remettre, Bidon> idBidon;
    public static volatile SingularAttribute<Remettre, Integer> quantiteRemettre;
    public static volatile SingularAttribute<Remettre, Integer> idRemettre;

}