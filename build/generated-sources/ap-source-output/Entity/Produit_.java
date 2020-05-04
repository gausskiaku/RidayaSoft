package Entity;

import Entity.Commander;
import Entity.Famille;
import Entity.Stock;
import Entity.Typevente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Double> prixUnitaire;
    public static volatile SingularAttribute<Produit, Famille> idFamille;
    public static volatile SingularAttribute<Produit, Date> dateCreation;
    public static volatile SingularAttribute<Produit, Integer> seuil;
    public static volatile SingularAttribute<Produit, Integer> idProduit;
    public static volatile ListAttribute<Produit, Stock> stockList;
    public static volatile ListAttribute<Produit, Typevente> typeventeList;
    public static volatile SingularAttribute<Produit, String> nomProduit;
    public static volatile ListAttribute<Produit, Commander> commanderList;

}