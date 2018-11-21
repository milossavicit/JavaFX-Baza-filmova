/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mrdatacable
 */
@Entity
@Table(name = "tvtime")
@NamedQueries({
    @NamedQuery(name = "Tvtime.findAll", query = "SELECT t FROM Tvtime t")
    , @NamedQuery(name = "Tvtime.findById", query = "SELECT t FROM Tvtime t WHERE t.id = :id")
    , @NamedQuery(name = "Tvtime.findByNaziv", query = "SELECT t FROM Tvtime t WHERE t.naziv = :naziv")
    , @NamedQuery(name = "Tvtime.findByZanr", query = "SELECT t FROM Tvtime t WHERE t.zanr = :zanr")
    , @NamedQuery(name = "Tvtime.findByGodina", query = "SELECT t FROM Tvtime t WHERE t.godina = :godina")
    , @NamedQuery(name = "Tvtime.findByTrajanje", query = "SELECT t FROM Tvtime t WHERE t.trajanje = :trajanje")
    , @NamedQuery(name = "Tvtime.findByOpis", query = "SELECT t FROM Tvtime t WHERE t.opis = :opis")
    , @NamedQuery(name = "Tvtime.findByOcena", query = "SELECT t FROM Tvtime t WHERE t.ocena = :ocena")})
public class Tvtime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "zanr")
    private String zanr;
    @Basic(optional = false)
    @Column(name = "godina")
    private int godina;
    @Basic(optional = false)
    @Column(name = "trajanje")
    private String trajanje;
    @Basic(optional = false)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "ocena")
    private int ocena;

    public Tvtime() {
    }

    public Tvtime(Integer id) {
        this.id = id;
    }

    public Tvtime(Integer id, String naziv, String zanr, int godina, String trajanje, String opis, int ocena) {
        this.id = id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.godina = godina;
        this.trajanje = trajanje;
        this.opis = opis;
        this.ocena = ocena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
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
        if (!(object instanceof Tvtime)) {
            return false;
        }
        Tvtime other = (Tvtime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tvtime[ id=" + id + " ]";
    }
    
}
