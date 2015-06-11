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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperfil")
    private Integer idperfil;
    @Size(max = 15)
    @Column(name = "tipoacesso")
    private String tipoacesso;
    @Column(name = "cadcliente")
    private Integer cadcliente;
    @Column(name = "cadclienteincluir")
    private Integer cadclienteincluir;
    @Column(name = "cadclienteeditar")
    private Integer cadclienteeditar;
    @Column(name = "cadclientesituacao")
    private Integer cadclientesituacao;
    @Column(name = "caddepartamento")
    private Integer caddepartamento;
    @Column(name = "caddepartamentoincluir")
    private Integer caddepartamentoincluir;
    @Column(name = "caddepartamentoeditar")
    private Integer caddepartamentoeditar;
    @Column(name = "cadsubdepartamento")
    private Integer cadsubdepartamento;
    @Column(name = "cadsubdepartamentoincluir")
    private Integer cadsubdepartamentoincluir;
    @Column(name = "cadsubdepartamentoeditar")
    private Integer cadsubdepartamentoeditar;
    @Column(name = "cadsubdepartamentosituacao")
    private Integer cadsubdepartamentosituacao;
    @Column(name = "cadrotina")
    private Integer cadrotina;
    @Column(name = "cadrotinaincluir")
    private Integer cadrotinaincluir;
    @Column(name = "cadrotinaeditar")
    private Integer cadrotinaeditar;
    @Column(name = "cadrotinaexcluir")
    private Integer cadrotinaexcluir;
    @Column(name = "cadusuario")
    private Integer cadusuario;
    @Column(name = "cadusuarioincluir")
    private Integer cadusuarioincluir;
    @Column(name = "cadusuarioeditar")
    private Integer cadusuarioeditar;
    @Column(name = "cadusuariosituacao")
    private Integer cadusuariosituacao;
    @Column(name = "tarefasincluir")
    private Integer tarefasincluir;
    @Column(name = "tarefaseditar")
    private Integer tarefaseditar;
    @Column(name = "tarefasoutros")
    private Integer tarefasoutros;
    @Column(name = "tarefatempo")
    private Integer tarefatempo;
    @Column(name = "tarefaeditaroutros")
    private Integer tarefaeditaroutros;
    @Column(name = "situacao")
    private Integer situacao;
    @Column(name = "cadperfil")
    private Integer cadperfil;
    @Column(name = "cadperfilincluir")
    private Integer cadperfilincluir;
    @Column(name = "cadperfileditar")
    private Integer cadperfileditar;

    public Perfil() {
    }

    public Perfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public String getTipoacesso() {
        return tipoacesso;
    }

    public void setTipoacesso(String tipoacesso) {
        this.tipoacesso = tipoacesso;
    }

    public Integer getCadcliente() {
        return cadcliente;
    }

    public void setCadcliente(Integer cadcliente) {
        this.cadcliente = cadcliente;
    }

    public Integer getCadclienteincluir() {
        return cadclienteincluir;
    }

    public void setCadclienteincluir(Integer cadclienteincluir) {
        this.cadclienteincluir = cadclienteincluir;
    }

    public Integer getCadclienteeditar() {
        return cadclienteeditar;
    }

    public void setCadclienteeditar(Integer cadclienteeditar) {
        this.cadclienteeditar = cadclienteeditar;
    }

    public Integer getCadclientesituacao() {
        return cadclientesituacao;
    }

    public void setCadclientesituacao(Integer cadclientesituacao) {
        this.cadclientesituacao = cadclientesituacao;
    }

    public Integer getCaddepartamento() {
        return caddepartamento;
    }

    public void setCaddepartamento(Integer caddepartamento) {
        this.caddepartamento = caddepartamento;
    }

    public Integer getCaddepartamentoincluir() {
        return caddepartamentoincluir;
    }

    public void setCaddepartamentoincluir(Integer caddepartamentoincluir) {
        this.caddepartamentoincluir = caddepartamentoincluir;
    }

    public Integer getCaddepartamentoeditar() {
        return caddepartamentoeditar;
    }

    public void setCaddepartamentoeditar(Integer caddepartamentoeditar) {
        this.caddepartamentoeditar = caddepartamentoeditar;
    }

    public Integer getCadsubdepartamento() {
        return cadsubdepartamento;
    }

    public void setCadsubdepartamento(Integer cadsubdepartamento) {
        this.cadsubdepartamento = cadsubdepartamento;
    }

    public Integer getCadsubdepartamentoincluir() {
        return cadsubdepartamentoincluir;
    }

    public void setCadsubdepartamentoincluir(Integer cadsubdepartamentoincluir) {
        this.cadsubdepartamentoincluir = cadsubdepartamentoincluir;
    }

    public Integer getCadsubdepartamentoeditar() {
        return cadsubdepartamentoeditar;
    }

    public void setCadsubdepartamentoeditar(Integer cadsubdepartamentoeditar) {
        this.cadsubdepartamentoeditar = cadsubdepartamentoeditar;
    }

    public Integer getCadsubdepartamentosituacao() {
        return cadsubdepartamentosituacao;
    }

    public void setCadsubdepartamentosituacao(Integer cadsubdepartamentosituacao) {
        this.cadsubdepartamentosituacao = cadsubdepartamentosituacao;
    }

    public Integer getCadrotina() {
        return cadrotina;
    }

    public void setCadrotina(Integer cadrotina) {
        this.cadrotina = cadrotina;
    }

    public Integer getCadrotinaincluir() {
        return cadrotinaincluir;
    }

    public void setCadrotinaincluir(Integer cadrotinaincluir) {
        this.cadrotinaincluir = cadrotinaincluir;
    }

    public Integer getCadrotinaeditar() {
        return cadrotinaeditar;
    }

    public void setCadrotinaeditar(Integer cadrotinaeditar) {
        this.cadrotinaeditar = cadrotinaeditar;
    }

    public Integer getCadrotinaexcluir() {
        return cadrotinaexcluir;
    }

    public void setCadrotinaexcluir(Integer cadrotinaexcluir) {
        this.cadrotinaexcluir = cadrotinaexcluir;
    }

    public Integer getCadusuario() {
        return cadusuario;
    }

    public void setCadusuario(Integer cadusuario) {
        this.cadusuario = cadusuario;
    }

    public Integer getCadusuarioincluir() {
        return cadusuarioincluir;
    }

    public void setCadusuarioincluir(Integer cadusuarioincluir) {
        this.cadusuarioincluir = cadusuarioincluir;
    }

    public Integer getCadusuarioeditar() {
        return cadusuarioeditar;
    }

    public void setCadusuarioeditar(Integer cadusuarioeditar) {
        this.cadusuarioeditar = cadusuarioeditar;
    }

    public Integer getCadusuariosituacao() {
        return cadusuariosituacao;
    }

    public void setCadusuariosituacao(Integer cadusuariosituacao) {
        this.cadusuariosituacao = cadusuariosituacao;
    }

    public Integer getTarefasincluir() {
        return tarefasincluir;
    }

    public void setTarefasincluir(Integer tarefasincluir) {
        this.tarefasincluir = tarefasincluir;
    }

    public Integer getTarefaseditar() {
        return tarefaseditar;
    }

    public void setTarefaseditar(Integer tarefaseditar) {
        this.tarefaseditar = tarefaseditar;
    }

    public Integer getTarefasoutros() {
        return tarefasoutros;
    }

    public void setTarefasoutros(Integer tarefasoutros) {
        this.tarefasoutros = tarefasoutros;
    }

    public Integer getTarefatempo() {
        return tarefatempo;
    }

    public void setTarefatempo(Integer tarefatempo) {
        this.tarefatempo = tarefatempo;
    }

    public Integer getTarefaeditaroutros() {
        return tarefaeditaroutros;
    }

    public void setTarefaeditaroutros(Integer tarefaeditaroutros) {
        this.tarefaeditaroutros = tarefaeditaroutros;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Integer getCadperfil() {
        return cadperfil;
    }

    public void setCadperfil(Integer cadperfil) {
        this.cadperfil = cadperfil;
    }

    public Integer getCadperfilincluir() {
        return cadperfilincluir;
    }

    public void setCadperfilincluir(Integer cadperfilincluir) {
        this.cadperfilincluir = cadperfilincluir;
    }

    public Integer getCadperfileditar() {
        return cadperfileditar;
    }

    public void setCadperfileditar(Integer cadperfileditar) {
        this.cadperfileditar = cadperfileditar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.financemate.model.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
