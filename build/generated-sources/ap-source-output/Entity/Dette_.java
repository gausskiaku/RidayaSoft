package Entity;

import Entity.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Dette.class)
public class Dette_ { 

    public static volatile SingularAttribute<Dette, Date> dateDette;
    public static volatile SingularAttribute<Dette, Client> idClient;
    public static volatile SingularAttribute<Dette, Double> montantDette;
    public static volatile SingularAttribute<Dette, Integer> idDette;
    public static volatile SingularAttribute<Dette, String> devise;

}