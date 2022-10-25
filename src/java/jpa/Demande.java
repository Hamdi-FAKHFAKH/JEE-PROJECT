/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hamdi
 */
@Entity
@Table(name = "demande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")
    , @NamedQuery(name = "Demande.findById", query = "SELECT d FROM Demande d WHERE d.id = :id")
    , @NamedQuery(name = "Demande.findByNomEmp", query = "SELECT d FROM Demande d WHERE d.nomEmp = :nomEmp")
    , @NamedQuery(name = "Demande.findByPrenomEmp", query = "SELECT d FROM Demande d WHERE d.prenomEmp = :prenomEmp")
    , @NamedQuery(name = "Demande.findByType", query = "SELECT d FROM Demande d WHERE d.type = :type")
    , @NamedQuery(name = "Demande.findByEtat", query = "SELECT d FROM Demande d WHERE d.etat = :etat")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_emp")
    private String nomEmp;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom_emp")
    private String prenomEmp;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "etat")
    private String etat;

    public Demande() {
    }

    public Demande(Integer id) {
        this.id = id;
    }

    public Demande(Integer id, String nomEmp, String prenomEmp, String type, String etat) {
        this.id = id;
        this.nomEmp = nomEmp;
        this.prenomEmp = prenomEmp;
        this.type = type;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getPrenomEmp() {
        return prenomEmp;
    }

    public void setPrenomEmp(String prenomEmp) {
        this.prenomEmp = prenomEmp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Demande[ id=" + id + " ]";
    }
    
}
