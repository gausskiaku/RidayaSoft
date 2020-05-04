/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gauss
 */
@Entity
@Table(name = "typevente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typevente.findAll", query = "SELECT t FROM Typevente t"),
    @NamedQuery(name = "Typevente.findByIdType", query = "SELECT t FROM Typevente t WHERE t.idType = :idType"),
    @NamedQuery(name = "Typevente.findByDesignation", query = "SELECT t FROM Typevente t WHERE t.designation = :designation")})
public class Typevente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idType")
    private Integer idType;
    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;
    @ManyToMany(mappedBy = "typeventeList")
    private List<Produit> produitList;

    public Typevente() {
    }

    public Typevente(Integer idType) {
        this.idType = idType;
    }

    public Typevente(Integer idType, String designation) {
        this.idType = idType;
        this.designation = designation;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typevente)) {
            return false;
        }
        Typevente other = (Typevente) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Typevente[ idType=" + idType + " ]";
    }
    
}
