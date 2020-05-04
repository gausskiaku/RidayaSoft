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
@Table(name = "emprunter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunter.findAll", query = "SELECT e FROM Emprunter e"),
    @NamedQuery(name = "Emprunter.findByIdEmprunter", query = "SELECT e FROM Emprunter e WHERE e.idEmprunter = :idEmprunter"),
    @NamedQuery(name = "Emprunter.findByDateEmprunter", query = "SELECT e FROM Emprunter e WHERE e.dateEmprunter = :dateEmprunter"),
    @NamedQuery(name = "Emprunter.findByQuantiteEmprunter", query = "SELECT e FROM Emprunter e WHERE e.quantiteEmprunter = :quantiteEmprunter")})
public class Emprunter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmprunter")
    private Integer idEmprunter;
    @Column(name = "dateEmprunter")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmprunter;
    @Column(name = "quantiteEmprunter")
    private Integer quantiteEmprunter;
    @JoinColumn(name = "idBidon", referencedColumnName = "idBidon")
    @ManyToOne(optional = false)
    private Bidon idBidon;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Emprunter() {
    }

    public Emprunter(Integer idEmprunter) {
        this.idEmprunter = idEmprunter;
    }

    public Integer getIdEmprunter() {
        return idEmprunter;
    }

    public void setIdEmprunter(Integer idEmprunter) {
        this.idEmprunter = idEmprunter;
    }

    public Date getDateEmprunter() {
        return dateEmprunter;
    }

    public void setDateEmprunter(Date dateEmprunter) {
        this.dateEmprunter = dateEmprunter;
    }

    public Integer getQuantiteEmprunter() {
        return quantiteEmprunter;
    }

    public void setQuantiteEmprunter(Integer quantiteEmprunter) {
        this.quantiteEmprunter = quantiteEmprunter;
    }

    public Bidon getIdBidon() {
        return idBidon;
    }

    public void setIdBidon(Bidon idBidon) {
        this.idBidon = idBidon;
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
        hash += (idEmprunter != null ? idEmprunter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunter)) {
            return false;
        }
        Emprunter other = (Emprunter) object;
        if ((this.idEmprunter == null && other.idEmprunter != null) || (this.idEmprunter != null && !this.idEmprunter.equals(other.idEmprunter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Emprunter[ idEmprunter=" + idEmprunter + " ]";
    }
    
}
