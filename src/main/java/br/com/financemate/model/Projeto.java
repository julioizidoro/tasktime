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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "projeto")
@NamedQueries({
    @NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p")})
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprojeto")
    private Integer idprojeto;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto")
    private List<Modulos> modulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto")
    private List<Membros> membrosList;

    public Projeto() {
    }

    public Projeto(Integer idprojeto) {
        this.idprojeto = idprojeto;
    }

    public Integer getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(Integer idprojeto) {
        this.idprojeto = idprojeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Modulos> getModulosList() {
        return modulosList;
    }

    public void setModulosList(List<Modulos> modulosList) {
        this.modulosList = modulosList;
    }

    public List<Membros> getMembrosList() {
        return membrosList;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprojeto != null ? idprojeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projeto)) {
            return false;
        }
        Projeto other = (Projeto) object;
        if ((this.idprojeto == null && other.idprojeto != null) || (this.idprojeto != null && !this.idprojeto.equals(other.idprojeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Projeto[ idprojeto=" + idprojeto + " ]";
    }
    
}
