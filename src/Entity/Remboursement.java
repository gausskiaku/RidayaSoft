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
@Table(name = "remboursement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remboursement.findAll", query = "SELECT r FROM Remboursement r"),
    @NamedQuery(name = "Remboursement.findByIdRemboursement", query = "SELECT r FROM Remboursement r WHERE r.idRemboursement = :idRemboursement"),
    @NamedQuery(name = "Remboursement.findByDateRemboursement", query = "SELECT r FROM Remboursement r WHERE r.dateRemboursement = :dateRemboursement"),
    @NamedQuery(name = "Remboursement.findByMontantRemboursement", query = "SELECT r FROM Remboursement r WHERE r.montantRemboursement = :montantRemboursement"),
    @NamedQuery(name = "Remboursement.findByDeviseRemboursement", query = "SELECT r FROM Remboursement r WHERE r.deviseRemboursement = :deviseRemboursement")})
public class Remboursement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRemboursement")
    private Integer idRemboursement;
    @Column(name = "dateRemboursement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRemboursement;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantRemboursement")
    private Double montantRemboursement;
    @Column(name = "deviseRemboursement")
    private String deviseRemboursement;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Remboursement() {
    }

    public Remboursement(Integer idRemboursement) {
        this.idRemboursement = idRemboursement;
    }

    public Integer getIdRemboursement() {
        return idRemboursement;
    }

    public void setIdRemboursement(Integer idRemboursement) {
        this.idRemboursement = idRemboursement;
    }

    public Date getDateRemboursement() {
        return dateRemboursement;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemboursement = dateRemboursement;
    }

    public Double getMontantRemboursement() {
        return montantRemboursement;
    }

    public void setMontantRemboursement(Double montantRemboursement) {
        this.montantRemboursement = montantRemboursement;
    }

    public String getDeviseRemboursement() {
        return deviseRemboursement;
    }

    public void setDeviseRemboursement(String deviseRemboursement) {
        this.deviseRemboursement = deviseRemboursement;
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
        hash += (idRemboursement != null ? idRemboursement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remboursement)) {
            return false;
        }
        Remboursement other = (Remboursement) object;
        if ((this.idRemboursement == null && other.idRemboursement != null) || (this.idRemboursement != null && !this.idRemboursement.equals(other.idRemboursement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Remboursement[ idRemboursement=" + idRemboursement + " ]";
    }
    
}
