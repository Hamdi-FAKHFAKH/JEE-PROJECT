/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hamdi
 */
@Embeddable
public class EmployeePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mot_de_passe")
    private String motDePasse;

    public EmployeePK() {
    }

    public EmployeePK(String login, String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        hash += (motDePasse != null ? motDePasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeePK)) {
            return false;
        }
        EmployeePK other = (EmployeePK) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        if ((this.motDePasse == null && other.motDePasse != null) || (this.motDePasse != null && !this.motDePasse.equals(other.motDePasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.EmployeePK[ login=" + login + ", motDePasse=" + motDePasse + " ]";
    }
    
}
