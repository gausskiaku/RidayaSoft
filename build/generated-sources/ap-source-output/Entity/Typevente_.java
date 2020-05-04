package Entity;

import Entity.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Typevente.class)
public class Typevente_ { 

    public static volatile SingularAttribute<Typevente, Integer> idType;
    public static volatile ListAttribute<Typevente, Produit> produitList;
    public static volatile SingularAttribute<Typevente, String> designation;

}