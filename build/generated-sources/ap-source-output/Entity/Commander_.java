package Entity;

import Entity.Client;
import Entity.Produit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Commander.class)
public class Commander_ { 

    public static volatile SingularAttribute<Commander, Produit> idProduit;
    public static volatile SingularAttribute<Commander, Client> idClient;
    public static volatile SingularAttribute<Commander, Integer> idCommander;
    public static volatile SingularAttribute<Commander, Integer> quantiteCommander;
    public static volatile SingularAttribute<Commander, Double> remiseCommander;
    public static volatile SingularAttribute<Commander, Double> prixVenteCommander;
    public static volatile SingularAttribute<Commander, Date> dateCommander;

}