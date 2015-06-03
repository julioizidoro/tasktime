/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.financemate.manageBean;

import br.com.financemate.bean.SituacaoBean;
import br.com.financemate.facade.DepartamentoFacade;
import br.com.financemate.facade.RotinaFacade;
import br.com.financemate.facade.SubdepartamentoFacade;
import br.com.financemate.model.Departamento;
import br.com.financemate.model.Rotina;
import br.com.financemate.model.Subdepartamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Wolverine
 */

@Named("SituacaoMB")
@SessionScoped
public class SituacaoMB implements Serializable{
    
    @Inject
    private UsuarioLogadoBean usuarioLogadoBean;
    private List<Departamento> listaDepartamento;
    private List<Subdepartamento> listaSubdepartamento;
    private List<Rotina> listaRotina;
    private List<SituacaoBean> listaSituacao;
    private String idDepartamento;
    private String idSubdepartamento;
    private String idRotina;

    public UsuarioLogadoBean getUsuarioLogadoBean() {
        return usuarioLogadoBean;
    }

    public void setUsuarioLogadoBean(UsuarioLogadoBean usuarioLogadoBean) {
        this.usuarioLogadoBean = usuarioLogadoBean;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Subdepartamento> getListaSubdepartamento() {
        return listaSubdepartamento;
    }

    public void setListaSubdepartamento(List<Subdepartamento> listaSubdepartamento) {
        this.listaSubdepartamento = listaSubdepartamento;
    }

    public List<Rotina> getListaRotina() {
        return listaRotina;
    }

    public void setListaRotina(List<Rotina> listaRotina) {
        this.listaRotina = listaRotina;
    }

    public List<SituacaoBean> getListaSituacao() {
        return listaSituacao;
    }

    public void setListaSituacao(List<SituacaoBean> listaSituacao) {
        this.listaSituacao = listaSituacao;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdSubdepartamento() {
        return idSubdepartamento;
    }

    public void setIdSubdepartamento(String idSubdepartamento) {
        this.idSubdepartamento = idSubdepartamento;
    }

    public String getIdRotina() {
        return idRotina;
    }

    public void setIdRotina(String idRotina) {
        this.idRotina = idRotina;
    }
    
    
    
    
    
    
    
    
    
    public void gerarListaDepartamento() {
        DepartamentoFacade departamentoFacade = new DepartamentoFacade();
        listaDepartamento = departamentoFacade.listar("");
        if (listaDepartamento == null) {
            listaDepartamento = new ArrayList<Departamento>();
        }
    }
    
    public void gerarListaSubdepartamento() {
        int numDep = Integer.parseInt(idDepartamento);
        if (numDep>0){
            SubdepartamentoFacade subdepartamentoFacade = new SubdepartamentoFacade();
            listaSubdepartamento = subdepartamentoFacade.listar(numDep);
            if (listaSubdepartamento == null) {
                listaSubdepartamento = new ArrayList<Subdepartamento>();
           }
        }else {
            listaSubdepartamento = new ArrayList<Subdepartamento>();
        }    
    }
    
    
    public void gerarListaRotina() {
        int numSub = Integer.parseInt(idSubdepartamento);
        if (numSub>0) {
            RotinaFacade rotinaFacade = new RotinaFacade();
            listaRotina = rotinaFacade.listar(numSub);
            if (listaRotina == null) {
                listaRotina = new ArrayList<Rotina>();
            }
        }else {
            listaRotina = new ArrayList<Rotina>();
        }
    }
    
    
    
    
    
}
