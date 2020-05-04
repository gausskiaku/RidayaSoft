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
@Table(name = "dette")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dette.findAll", query = "SELECT d FROM Dette d"),
    @NamedQuery(name = "Dette.findByIdDette", query = "SELECT d FROM Dette d WHERE d.idDette = :idDette"),
    @NamedQuery(name = "Dette.findByMontantDette", query = "SELECT d FROM Dette d WHERE d.montantDette = :montantDette"),
    @NamedQuery(name = "Dette.findByDevise", query = "SELECT d FROM Dette d WHERE d.devise = :devise"),
    @NamedQuery(name = "Dette.findByDateDette", query = "SELECT d FROM Dette d WHERE d.dateDette = :dateDette")})
public class Dette implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDette")
    private Integer idDette;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantDette")
    private Double montantDette;
    @Column(name = "Devise")
    private String devise;
    @Column(name = "dateDette")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDette;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Dette() {
    }

    public Dette(Integer idDette) {
        this.idDette = idDette;
    }

    public Integer getIdDette() {
        return idDette;
    }

    public void setIdDette(Integer idDette) {
        this.idDette = idDette;
    }

    public Double getMontantDette() {
        return montantDette;
    }

    public void setMontantDette(Double montantDette) {
        this.montantDette = montantDette;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Date getDateDette() {
        return dateDette;
    }

    public void setDateDette(Date dateDette) {
        this.dateDette = dateDette;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDette != null ? idDette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dette)) {
            return false;
        }
        Dette other = (Dette) object;
        if ((this.idDette == null && other.idDette != null) || (this.idDette != null && !this.idDette.equals(other.idDette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Dette[ idDette=" + idDette + " ]";
    }
    
}
