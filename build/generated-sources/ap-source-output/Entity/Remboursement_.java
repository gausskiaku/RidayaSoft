package Entity;

import Entity.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Remboursement.class)
public class Remboursement_ { 

    public static volatile SingularAttribute<Remboursement, Integer> idRemboursement;
    public static volatile SingularAttribute<Remboursement, Client> idClient;
    public static volatile SingularAttribute<Remboursement, Date> dateRemboursement;
    public static volatile SingularAttribute<Remboursement, Double> montantRemboursement;
    public static volatile SingularAttribute<Remboursement, String> deviseRemboursement;

}