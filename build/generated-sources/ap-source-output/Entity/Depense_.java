package Entity;

import Entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Depense.class)
public class Depense_ { 

    public static volatile SingularAttribute<Depense, User> idUser;
    public static volatile SingularAttribute<Depense, Date> dateDepense;
    public static volatile SingularAttribute<Depense, Integer> montant;
    public static volatile SingularAttribute<Depense, String> motif;
    public static volatile SingularAttribute<Depense, Integer> idDepense;

}