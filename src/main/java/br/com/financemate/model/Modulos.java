/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "modulos")
@NamedQueries({
    @NamedQuery(name = "Modulos.findAll", query = "SELECT m FROM Modulos m")})
public class Modulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodulos")
    private Integer idmodulos;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "datainicial")
    @Temporal(TemporalType.DATE)
    private Date datainicial;
    @Column(name = "datafinal")
    @Temporal(TemporalType.DATE)
    private Date datafinal;
    @JoinColumn(name = "projeto_idprojeto", referencedColumnName = "idprojeto")
    @ManyToOne(optional = false)
    private Projeto projeto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulos")
    private List<Atividademodulo> atividademoduloList;

    public Modulos() {
    }

    public Modulos(Integer idmodulos) {
        this.idmodulos = idmodulos;
    }

    public Integer getIdmodulos() {
        return idmodulos;
    }

    public void setIdmodulos(Integer idmodulos) {
        this.idmodulos = idmodulos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Atividademodulo> getAtividademoduloList() {
        return atividademoduloList;
    }

    public void setAtividademoduloList(List<Atividademodulo> atividademoduloList) {
        this.atividademoduloList = atividademoduloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodulos != null ? idmodulos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulos)) {
            return false;
        }
        Modulos other = (Modulos) object;
        if ((this.idmodulos == null && other.idmodulos != null) || (this.idmodulos != null && !this.idmodulos.equals(other.idmodulos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Modulos[ idmodulos=" + idmodulos + " ]";
    }
    
}
