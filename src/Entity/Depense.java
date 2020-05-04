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
import javax.persistence.Lob;
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
@Table(name = "depense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depense.findAll", query = "SELECT d FROM Depense d"),
    @NamedQuery(name = "Depense.findByIdDepense", query = "SELECT d FROM Depense d WHERE d.idDepense = :idDepense"),
    @NamedQuery(name = "Depense.findByMontant", query = "SELECT d FROM Depense d WHERE d.montant = :montant"),
    @NamedQuery(name = "Depense.findByDateDepense", query = "SELECT d FROM Depense d WHERE d.dateDepense = :dateDepense")})
public class Depense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepense")
    private Integer idDepense;
    @Basic(optional = false)
    @Lob
    @Column(name = "motif")
    private String motif;
    @Basic(optional = false)
    @Column(name = "montant")
    private int montant;
    @Basic(optional = false)
    @Column(name = "dateDepense")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepense;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private User idUser;

    public Depense() {
    }

    public Depense(Integer idDepense) {
        this.idDepense = idDepense;
    }

    public Depense(Integer idDepense, String motif, int montant, Date dateDepense) {
        this.idDepense = idDepense;
        this.motif = motif;
        this.montant = montant;
        this.dateDepense = dateDepense;
    }

    public Integer getIdDepense() {
        return idDepense;
    }

    public void setIdDepense(Integer idDepense) {
        this.idDepense = idDepense;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepense != null ? idDepense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depense)) {
            return false;
        }
        Depense other = (Depense) object;
        if ((this.idDepense == null && other.idDepense != null) || (this.idDepense != null && !this.idDepense.equals(other.idDepense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Depense[ idDepense=" + idDepense + " ]";
    }
    
}
