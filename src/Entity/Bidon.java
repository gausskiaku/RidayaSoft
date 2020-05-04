/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gauss
 */
@Entity
@Table(name = "bidon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bidon.findAll", query = "SELECT b FROM Bidon b"),
    @NamedQuery(name = "Bidon.findByIdBidon", query = "SELECT b FROM Bidon b WHERE b.idBidon = :idBidon"),
    @NamedQuery(name = "Bidon.findByTypeBidon", query = "SELECT b FROM Bidon b WHERE b.typeBidon = :typeBidon")})
public class Bidon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBidon")
    private Integer idBidon;
    @Column(name = "typeBidon")
    private String typeBidon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBidon")
    private List<Emprunter> emprunterList;
    @OneToMany(mappedBy = "idBidon")
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBidon")
    private List<Remettre> remettreList;

    public Bidon() {
    }

    public Bidon(Integer idBidon) {
        this.idBidon = idBidon;
    }

    public Integer getIdBidon() {
        return idBidon;
    }

    public void setIdBidon(Integer idBidon) {
        this.idBidon = idBidon;
    }

    public String getTypeBidon() {
        return typeBidon;
    }

    public void setTypeBidon(String typeBidon) {
        this.typeBidon = typeBidon;
    }

    @XmlTransient
    public List<Emprunter> getEmprunterList() {
        return emprunterList;
    }

    public void setEmprunterList(List<Emprunter> emprunterList) {
        this.emprunterList = emprunterList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<Remettre> getRemettreList() {
        return remettreList;
    }

    public void setRemettreList(List<Remettre> remettreList) {
        this.remettreList = remettreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBidon != null ? idBidon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bidon)) {
            return false;
        }
        Bidon other = (Bidon) object;
        if ((this.idBidon == null && other.idBidon != null) || (this.idBidon != null && !this.idBidon.equals(other.idBidon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bidon[ idBidon=" + idBidon + " ]";
    }
    
}
