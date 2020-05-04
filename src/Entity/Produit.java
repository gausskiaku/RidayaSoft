/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gauss
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdProduit", query = "SELECT p FROM Produit p WHERE p.idProduit = :idProduit"),
    @NamedQuery(name = "Produit.findByNomProduit", query = "SELECT p FROM Produit p WHERE p.nomProduit = :nomProduit"),
    @NamedQuery(name = "Produit.findByDateCreation", query = "SELECT p FROM Produit p WHERE p.dateCreation = :dateCreation"),
    @NamedQuery(name = "Produit.findByPrixUnitaire", query = "SELECT p FROM Produit p WHERE p.prixUnitaire = :prixUnitaire"),
    @NamedQuery(name = "Produit.findBySeuil", query = "SELECT p FROM Produit p WHERE p.seuil = :seuil")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduit")
    private Integer idProduit;
    @Basic(optional = false)
    @Column(name = "nomProduit")
    private String nomProduit;
    @Basic(optional = false)
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixUnitaire")
    private Double prixUnitaire;
    @Column(name = "seuil")
    private Integer seuil;
    @JoinTable(name = "concerner", joinColumns = {
        @JoinColumn(name = "idProduit", referencedColumnName = "idProduit")}, inverseJoinColumns = {
        @JoinColumn(name = "idType", referencedColumnName = "idType")})
    @ManyToMany
    private List<Typevente> typeventeList;
    @JoinColumn(name = "idFamille", referencedColumnName = "idFamille")
    @ManyToOne(optional = false)
    private Famille idFamille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduit")
    private List<Commander> commanderList;
    @OneToMany(mappedBy = "idProduit")
    private List<Stock> stockList;

    public Produit() {
    }

    public Produit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Integer idProduit, String nomProduit, Date dateCreation) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.dateCreation = dateCreation;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }

    @XmlTransient
    public List<Typevente> getTypeventeList() {
        return typeventeList;
    }

    public void setTypeventeList(List<Typevente> typeventeList) {
        this.typeventeList = typeventeList;
    }

    public Famille getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(Famille idFamille) {
        this.idFamille = idFamille;
    }

    @XmlTransient
    public List<Commander> getCommanderList() {
        return commanderList;
    }

    public void setCommanderList(List<Commander> commanderList) {
        this.commanderList = commanderList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
