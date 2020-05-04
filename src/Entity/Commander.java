/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gauss
 */
@Entity
@Table(name = "commander")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commander.findAll", query = "SELECT c FROM Commander c"),
    @NamedQuery(name = "Commander.findByIdCommander", query = "SELECT c FROM Commander c WHERE c.idCommander = :idCommander"),
    @NamedQuery(name = "Commander.findByQuantiteCommander", query = "SELECT c FROM Commander c WHERE c.quantiteCommander = :quantiteCommander"),
    @NamedQuery(name = "Commander.findByPrixVenteCommander", query = "SELECT c FROM Commander c WHERE c.prixVenteCommander = :prixVenteCommander"),
    @NamedQuery(name = "Commander.findByRemiseCommander", query = "SELECT c FROM Commander c WHERE c.remiseCommander = :remiseCommander"),
    @NamedQuery(name = "Commander.findByDateCommander", query = "SELECT c FROM Commander c WHERE c.dateCommander = :dateCommander")})
public class Commander implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommander")
    private Integer idCommander;
    @Column(name = "quantiteCommander")
    private Integer quantiteCommander;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixVenteCommander")
    private Double prixVenteCommander;
    @Column(name = "remiseCommander")
    private Double remiseCommander;
    @Column(name = "dateCommander")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommander;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit")
    @ManyToOne(optional = false)
    private Produit idProduit;

    public Commander() {
    }

    public Commander(Integer idCommander) {
        this.idCommander = idCommander;
    }

    public Integer getIdCommander() {
        return idCommander;
    }

    public void setIdCommander(Integer idCommander) {
        this.idCommander = idCommander;
    }

    public Integer getQuantiteCommander() {
        return quantiteCommander;
    }

    public void setQuantiteCommander(Integer quantiteCommander) {
        this.quantiteCommander = quantiteCommander;
    }

    public Double getPrixVenteCommander() {
        return prixVenteCommander;
    }

    public void setPrixVenteCommander(Double prixVenteCommander) {
        this.prixVenteCommander = prixVenteCommander;
    }

    public Double getRemiseCommander() {
        return remiseCommander;
    }

    public void setRemiseCommander(Double remiseCommander) {
        this.remiseCommander = remiseCommander;
    }

    public Date getDateCommander() {
        return dateCommander;
    }

    public void setDateCommander(Date dateCommander) {
        this.dateCommander = dateCommander;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommander != null ? idCommander.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commander)) {
            return false;
        }
        Commander other = (Commander) object;
        if ((this.idCommander == null && other.idCommander != null) || (this.idCommander != null && !this.idCommander.equals(other.idCommander))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Commander[ idCommander=" + idCommander + " ]";
    }
    
}
