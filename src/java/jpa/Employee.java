/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hamdi
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByNom", query = "SELECT e FROM Employee e WHERE e.nom = :nom")
    , @NamedQuery(name = "Employee.findByPrenom", query = "SELECT e FROM Employee e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Employee.findByAdresse", query = "SELECT e FROM Employee e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Employee.findByDateN", query = "SELECT e FROM Employee e WHERE e.dateN = :dateN")
    , @NamedQuery(name = "Employee.findByTelephone", query = "SELECT e FROM Employee e WHERE e.telephone = :telephone")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByService", query = "SELECT e FROM Employee e WHERE e.service = :service")
    , @NamedQuery(name = "Employee.findByLogin", query = "SELECT e FROM Employee e WHERE e.employeePK.login = :login")
    , @NamedQuery(name = "Employee.findByMotDePasse", query = "SELECT e FROM Employee e WHERE e.employeePK.motDePasse = :motDePasse")
    , @NamedQuery(name = "Employee.findByAdmin", query = "SELECT e FROM Employee e WHERE e.admin = :admin")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeePK employeePK;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_n")
    private String dateN;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "telephone")
    private int telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "service")
    private String service;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "admin")
    private boolean admin;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "confirmation")
    private boolean conf;
    public Employee() {
    }

    public Employee(EmployeePK employeePK) {
        this.employeePK = employeePK;
    }

    public Employee(EmployeePK employeePK, int id, String nom, String prenom, String adresse, String dateN, int telephone, String email, String service, boolean admin,boolean confir) {
        this.employeePK = employeePK;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateN = dateN;
        this.telephone = telephone;
        this.email = email;
        this.service = service;
        this.admin = admin;
        this.conf = confir;
                
    }

    public Employee(String login, String motDePasse) {
        this.employeePK = new EmployeePK(login, motDePasse);
    }

    public EmployeePK getEmployeePK() {
        return employeePK;
    }

    public void setEmployeePK(EmployeePK employeePK) {
        this.employeePK = employeePK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateN() {
        return dateN;
    }

    public void setDateN(String dateN) {
        this.dateN = dateN;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean isConf() {
        return conf;
    }

    public void setConf(boolean conf) {
        this.conf = conf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeePK != null ? employeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeePK == null && other.employeePK != null) || (this.employeePK != null && !this.employeePK.equals(other.employeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Employee[ employeePK=" + employeePK + " ]";
    }
    
}
