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
@Table(name = "remettre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remettre.findAll", query = "SELECT r FROM Remettre r"),
    @NamedQuery(name = "Remettre.findByIdRemettre", query = "SELECT r FROM Remettre r WHERE r.idRemettre = :idRemettre"),
    @NamedQuery(name = "Remettre.findByDateRemettre", query = "SELECT r FROM Remettre r WHERE r.dateRemettre = :dateRemettre"),
    @NamedQuery(name = "Remettre.findByQuantiteRemettre", query = "SELECT r FROM Remettre r WHERE r.quantiteRemettre = :quantiteRemettre")})
public class Remettre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRemettre")
    private Integer idRemettre;
    @Column(name = "dateRemettre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRemettre;
    @Column(name = "quantiteRemettre")
    private Integer quantiteRemettre;
    @JoinColumn(name = "idBidon", referencedColumnName = "idBidon")
    @ManyToOne(optional = false)
    private Bidon idBidon;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Remettre() {
    }

    public Remettre(Integer idRemettre) {
        this.idRemettre = idRemettre;
    }

    public Integer getIdRemettre() {
        return idRemettre;
    }

    public void setIdRemettre(Integer idRemettre) {
        this.idRemettre = idRemettre;
    }

    public Date getDateRemettre() {
        return dateRemettre;
    }

    public void setDateRemettre(Date dateRemettre) {
        this.dateRemettre = dateRemettre;
    }

    public Integer getQuantiteRemettre() {
        return quantiteRemettre;
    }

    public void setQuantiteRemettre(Integer quantiteRemettre) {
        this.quantiteRemettre = quantiteRemettre;
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
        hash += (idRemettre != null ? idRemettre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remettre)) {
            return false;
        }
        Remettre other = (Remettre) object;
        if ((this.idRemettre == null && other.idRemettre != null) || (this.idRemettre != null && !this.idRemettre.equals(other.idRemettre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Remettre[ idRemettre=" + idRemettre + " ]";
    }
    
}
