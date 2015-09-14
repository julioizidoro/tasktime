/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "processoatividade")
@NamedQueries({
    @NamedQuery(name = "Processoatividade.findAll", query = "SELECT p FROM Processoatividade p")})
public class Processoatividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprocessoatividade")
    private Integer idprocessoatividade;
    @JoinColumn(name = "processorotina_idprocessorotina", referencedColumnName = "idprocessorotina")
    @ManyToOne(optional = false)
    private Processorotina processorotina;
    @JoinColumn(name = "atividades_idatividades", referencedColumnName = "idatividades")
    @ManyToOne(optional = false)
    private Atividades atividades;

    public Processoatividade() {
    }

    public Processoatividade(Integer idprocessoatividade) {
        this.idprocessoatividade = idprocessoatividade;
    }

    public Integer getIdprocessoatividade() {
        return idprocessoatividade;
    }

    public void setIdprocessoatividade(Integer idprocessoatividade) {
        this.idprocessoatividade = idprocessoatividade;
    }

    public Processorotina getProcessorotina() {
        return processorotina;
    }

    public void setProcessorotina(Processorotina processorotina) {
        this.processorotina = processorotina;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades atividades) {
        this.atividades = atividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocessoatividade != null ? idprocessoatividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processoatividade)) {
            return false;
        }
        Processoatividade other = (Processoatividade) object;
        if ((this.idprocessoatividade == null && other.idprocessoatividade != null) || (this.idprocessoatividade != null && !this.idprocessoatividade.equals(other.idprocessoatividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Processoatividade[ idprocessoatividade=" + idprocessoatividade + " ]";
    }
    
}
