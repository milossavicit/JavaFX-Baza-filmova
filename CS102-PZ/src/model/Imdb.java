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
 * @author Milos
 */
@Entity
@Table(name = "imdb")
@NamedQueries({
    @NamedQuery(name = "Imdb.findAll", query = "SELECT i FROM Imdb i")
    , @NamedQuery(name = "Imdb.findById", query = "SELECT i FROM Imdb i WHERE i.id = :id")
    , @NamedQuery(name = "Imdb.findByNaziv", query = "SELECT i FROM Imdb i WHERE i.naziv = :naziv")
    , @NamedQuery(name = "Imdb.findByOcena", query = "SELECT i FROM Imdb i WHERE i.ocena = :ocena")})
public class Imdb implements Serializable {

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
    @Column(name = "ocena")
    private String ocena;

    public Imdb() {
    }

    public Imdb(Integer id) {
        this.id = id;
    }

    public Imdb(Integer id, String naziv, String ocena) {
        this.id = id;
        this.naziv = naziv;
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

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
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
        if (!(object instanceof Imdb)) {
            return false;
        }
        Imdb other = (Imdb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Imdb[ id=" + id + " ]";
    }
    
}
