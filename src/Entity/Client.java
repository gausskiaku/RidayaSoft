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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByNomClient", query = "SELECT c FROM Client c WHERE c.nomClient = :nomClient"),
    @NamedQuery(name = "Client.findByPrenomClient", query = "SELECT c FROM Client c WHERE c.prenomClient = :prenomClient")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "nomClient")
    private String nomClient;
    @Column(name = "prenomClient")
    private String prenomClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Commander> commanderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Dette> detteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Facture> factureList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Emprunter> emprunterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Remboursement> remboursementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Remettre> remettreList;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    @XmlTransient
    public List<Commander> getCommanderList() {
        return commanderList;
    }

    public void setCommanderList(List<Commander> commanderList) {
        this.commanderList = commanderList;
    }

    @XmlTransient
    public List<Dette> getDetteList() {
        return detteList;
    }

    public void setDetteList(List<Dette> detteList) {
        this.detteList = detteList;
    }

    @XmlTransient
    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }

    @XmlTransient
    public List<Emprunter> getEmprunterList() {
        return emprunterList;
    }

    public void setEmprunterList(List<Emprunter> emprunterList) {
        this.emprunterList = emprunterList;
    }

    @XmlTransient
    public List<Remboursement> getRemboursementList() {
        return remboursementList;
    }

    public void setRemboursementList(List<Remboursement> remboursementList) {
        this.remboursementList = remboursementList;
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
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Client[ idClient=" + idClient + " ]";
    }
    
}
