package Entity;

import Entity.Emprunter;
import Entity.Remettre;
import Entity.Stock;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T16:24:31")
@StaticMetamodel(Bidon.class)
public class Bidon_ { 

    public static volatile SingularAttribute<Bidon, String> typeBidon;
    public static volatile ListAttribute<Bidon, Stock> stockList;
    public static volatile SingularAttribute<Bidon, Integer> idBidon;
    public static volatile ListAttribute<Bidon, Emprunter> emprunterList;
    public static volatile ListAttribute<Bidon, Remettre> remettreList;

}