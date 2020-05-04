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
@Table(name = "parametrevente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrevente.findAll", query = "SELECT p FROM Parametrevente p"),
    @NamedQuery(name = "Parametrevente.findByIdParamVente", query = "SELECT p FROM Parametrevente p WHERE p.idParamVente = :idParamVente"),
    @NamedQuery(name = "Parametrevente.findByTva", query = "SELECT p FROM Parametrevente p WHERE p.tva = :tva"),
    @NamedQuery(name = "Parametrevente.findByGain", query = "SELECT p FROM Parametrevente p WHERE p.gain = :gain"),
    @NamedQuery(name = "Parametrevente.findByDateModif", query = "SELECT p FROM Parametrevente p WHERE p.dateModif = :dateModif")})
public class Parametrevente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParamVente")
    private Integer idParamVente;
    @Column(name = "tva")
    private Integer tva;
    @Column(name = "gain")
    private Integer gain;
    @Column(name = "dateModif")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;

    public Parametrevente() {
    }

    public Parametrevente(Integer idParamVente) {
        this.idParamVente = idParamVente;
    }

    public Integer getIdParamVente() {
        return idParamVente;
    }

    public void setIdParamVente(Integer idParamVente) {
        this.idParamVente = idParamVente;
    }

    public Integer getTva() {
        return tva;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParamVente != null ? idParamVente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrevente)) {
            return false;
        }
        Parametrevente other = (Parametrevente) object;
        if ((this.idParamVente == null && other.idParamVente != null) || (this.idParamVente != null && !this.idParamVente.equals(other.idParamVente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Parametrevente[ idParamVente=" + idParamVente + " ]";
    }
    
}
