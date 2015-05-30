/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.model;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "datarotina")
public class Datarotina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddatarotina")
    private Integer iddatarotina;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datarotina")
    private List<Rotinacliente> rotinaclienteList;


    public Datarotina() {
    }

    public Datarotina(Integer iddatarotina) {
        this.iddatarotina = iddatarotina;
    }

    public Integer getIddatarotina() {
        return iddatarotina;
    }

    public void setIddatarotina(Integer iddatarotina) {
        this.iddatarotina = iddatarotina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddatarotina != null ? iddatarotina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datarotina)) {
            return false;
        }
        Datarotina other = (Datarotina) object;
        if ((this.iddatarotina == null && other.iddatarotina != null) || (this.iddatarotina != null && !this.iddatarotina.equals(other.iddatarotina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Datarotina[ iddatarotina=" + iddatarotina + " ]";
    }

    public List<Rotinacliente> getRotinaclienteList() {
        return rotinaclienteList;
    }

    public void setRotinaclienteList(List<Rotinacliente> rotinaclienteList) {
        this.rotinaclienteList = rotinaclienteList;
    }
    
}
