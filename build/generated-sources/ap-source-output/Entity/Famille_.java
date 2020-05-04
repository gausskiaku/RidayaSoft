package Entity;

import Entity.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Famille.class)
public class Famille_ { 

    public static volatile SingularAttribute<Famille, Integer> idFamille;
    public static volatile ListAttribute<Famille, Produit> produitList;
    public static volatile SingularAttribute<Famille, String> designation;

}