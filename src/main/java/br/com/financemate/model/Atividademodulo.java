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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "atividademodulo")
@NamedQueries({
    @NamedQuery(name = "Atividademodulo.findAll", query = "SELECT a FROM Atividademodulo a")})
public class Atividademodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idatividademodulo")
    private Integer idatividademodulo;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "datafinal")
    @Temporal(TemporalType.DATE)
    private Date datafinal;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividademodulo")
    private List<Raci> raciList;
    @JoinColumn(name = "modulos_idmodulos", referencedColumnName = "idmodulos")
    @ManyToOne(optional = false)
    private Modulos modulos;
    @Transient
    private Date dataInicio;

    public Atividademodulo() {
    }

    public Atividademodulo(Integer idatividademodulo) {
        this.idatividademodulo = idatividademodulo;
    }

    public Integer getIdatividademodulo() {
        return idatividademodulo;
    }

    public void setIdatividademodulo(Integer idatividademodulo) {
        this.idatividademodulo = idatividademodulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<Raci> getRaciList() {
        return raciList;
    }

    public void setRaciList(List<Raci> raciList) {
        this.raciList = raciList;
    }

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idatividademodulo != null ? idatividademodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividademodulo)) {
            return false;
        }
        Atividademodulo other = (Atividademodulo) object;
        if ((this.idatividademodulo == null && other.idatividademodulo != null) || (this.idatividademodulo != null && !this.idatividademodulo.equals(other.idatividademodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Atividademodulo[ idatividademodulo=" + idatividademodulo + " ]";
    }
    
}
