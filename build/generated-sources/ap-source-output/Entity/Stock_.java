package Entity;

import Entity.Bidon;
import Entity.Produit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> idStock;
    public static volatile SingularAttribute<Stock, Produit> idProduit;
    public static volatile SingularAttribute<Stock, Double> prixAchat;
    public static volatile SingularAttribute<Stock, Bidon> idBidon;
    public static volatile SingularAttribute<Stock, Date> dateStock;
    public static volatile SingularAttribute<Stock, Integer> quantite;

}