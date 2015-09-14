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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "processosituacao")
@NamedQueries({
    @NamedQuery(name = "Processosituacao.findAll", query = "SELECT p FROM Processosituacao p")})
public class Processosituacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataabertura")
    @Temporal(TemporalType.DATE)
    private Date dataabertura;
    @Size(max = 50)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processosituacao")
    private List<Processoatividade> processoatividadeList;

    public Processosituacao() {
    }

    public Processosituacao(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Processoatividade> getProcessoatividadeList() {
        return processoatividadeList;
    }

    public void setProcessoatividadeList(List<Processoatividade> processoatividadeList) {
        this.processoatividadeList = processoatividadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataabertura != null ? dataabertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processosituacao)) {
            return false;
        }
        Processosituacao other = (Processosituacao) object;
        if ((this.dataabertura == null && other.dataabertura != null) || (this.dataabertura != null && !this.dataabertura.equals(other.dataabertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Processosituacao[ dataabertura=" + dataabertura + " ]";
    }
    
}
