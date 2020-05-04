package Entity;

import Entity.Depense;
import Entity.Facture;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> motDePasse;
    public static volatile SingularAttribute<User, String> droit;
    public static volatile SingularAttribute<User, String> login;
    public static volatile ListAttribute<User, Depense> depenseList;
    public static volatile ListAttribute<User, Facture> factureList;

}